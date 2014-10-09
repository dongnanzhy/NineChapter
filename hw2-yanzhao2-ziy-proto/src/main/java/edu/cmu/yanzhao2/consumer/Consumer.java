package edu.cmu.yanzhao2.consumer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;
import org.xml.sax.SAXException;

import edu.cmu.yanzhao2.types.*;

/**
 * This class used to write the annotated gene words into output file.
 * @author Yan Zhao
 * @version 2.0 September, 2014.
 */
public class Consumer extends CasConsumer_ImplBase {
  File out = null;
  File test = null;
  HashMap<String, Integer> table = new HashMap<String, Integer>();
  BufferedWriter bw = null;
  
  /**
   * @param  hit, miss    the number of hit, miss between result using lingpipe and sample.out.
   * @param  answer       the number of words in sample.out
   */
  int hit = 0, miss = 0, answer = 0;

  /**
   * initialize()   used to set the output path of files and the path of sample.out.
   */
  public void initialize() {
    try {
    out = new File((String) getConfigParameterValue("output"));
    bw = new BufferedWriter(new FileWriter(out));
    } catch (Exception e) {
      e.printStackTrace();
    }
    test = new File((String) getConfigParameterValue("test"));
    Scanner dict = null;
    try {
      dict = new Scanner(test);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    while (dict.hasNext()) {
      table.put(dict.nextLine(), 0);
      answer++;
    }
    
  }
  
  /**
   * process(JCas arg0)     output the gene words. Calculating the F1_Score of the output, and print.
   * @param aCAS  
   */
  public void processCas(CAS arg0) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = arg0.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    FSIterator<org.apache.uima.jcas.tcas.Annotation> it = jcas.getAnnotationIndex(Result.type).iterator();
    System.out.println("Consuming CAS");
    String geneId = null;
    String geneContent = null;
    int begin = -1;
    int end = -1;
    String output = null;
    while (it.hasNext()) {
      Result result = (Result) it.next();
      geneId = result.getId();
      geneContent = result.getContent();      
      begin = result.getBegin();
      end = result.getEnd();  
      
      /**
       * @param output      String need to write into output file, including ID and content.
       */
      output = geneId + "|" + begin + " " + end + "|" + geneContent;
      if (table.containsKey(output)) {
        hit++;
      } else {
        miss++;
      }

      try {
        writeIntoFile(output);
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      } catch (SAXException e) {
        throw new ResourceProcessException(e);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
    double precision = hit * 1.0 / (hit + miss);
    double recall = hit * 1.0 / answer;
    System.out.println("Precision: " + precision + " " + "Recall: " + recall + " " 
                      + "F1_Score: " + 2 * precision * recall / (precision + recall));
  }
  
  /**
   * writeIntoFile(String output)   write a string into output file
   * @param output                  String need to write.
   */
  public void writeIntoFile(String output) 
      throws Exception {
        bw.write(output);
        bw.newLine();
        bw.flush();
      }

  /**
   * destroy   
   */
  public void destroy() {
      try {
        if (bw != null) {
          bw.close();
          bw = null;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
