package edu.cmu.yanzhao2.annotator;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.yanzhao2.types.*;


/** Lingpipe used to annotate gene words.Using lingpipe genetag.HmmChunker
 * 
 * @author Yan Zhao
 * @version 2.0 September, 2014.
 */
public class Lingpipe extends JCasAnnotator_ImplBase {
  /**
   * the maximum length of gene words according to sample.out
   */
  private static final int MAX = 8;

  /**
   * the name of NER gene model
   */
  private File modelFile = null;

  /**
   * the handler to load the model and recognize gene words
   */
  private ConfidenceChunker chunker = null;
  
  /**
   * initialize method will initialize one instance for private variable chunker,
   * which is one of the components of Lingpipe. It also loads the Genetag Model into
   * the annotator.
   * 
   * @param aContext
   * @throws ResourceInitializationException 
   * 
   */
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    /*
    try {
//      System.out.println(getContext().getResourceFilePath("Hmm"));
      modelFile = new File(getContext().getResourceFilePath("HmmChunker"));
    } catch (ResourceAccessException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    */
//   modelFile = new File("src/main/resources/descriptors/ne-en-bio-genetag.HmmChunker");
    try {
      chunker = (ConfidenceChunker) AbstractExternalizable.readResourceObject(Lingpipe.class, 
              (String)context.getConfigParameterValue("HmmChunker"));
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    /*
    try {
      chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
     */
  }

  
  /** 
   * process(JCas arg0) will process JCAS with annotation of noun/phrase, 
   * adding gene annotation to them using lingpipe.
   * 
   * @param arg0 
   *      a JCAS that this annotator should process.
   */
  public void process(JCas arg0) throws AnalysisEngineProcessException {
  
    JCas jcas = arg0;
    
    FSIterator<org.apache.uima.jcas.tcas.Annotation> it = jcas.getAnnotationIndex(Sentence.type).iterator(); 
    while (it.hasNext()) {
      Sentence annotate_s = (Sentence) it.next();
      String content = annotate_s.getContent();
      char[] temp = content.toCharArray();
      Iterator<Chunk> gene_iterator = chunker.nBestChunks(temp, 0, temp.length, MAX);
      while (gene_iterator.hasNext()) {
        Chunk chunk = gene_iterator.next();
        /**
         * Set the confidence to 0.6, can get a higher F1 score.
         */
        double confidence = Math.pow(2.0, chunk.score());
        if (confidence < 0.3) {
          break;
        }
        int begin = chunk.start();
        int end = chunk.end();
        String gene = content.substring(begin, end);
        begin = begin - countWhiteSpaces(content.substring(0,begin)) ;
        end = begin + gene.length() - countWhiteSpaces(gene) - 1;
        
        GeneLingpipe annotate = new GeneLingpipe(jcas);
        annotate.setBegin(begin);
        annotate.setEnd(end);
        annotate.setId(annotate_s.getId());
        annotate.setContent(gene);
        annotate.setConfidence(confidence);
        annotate.addToIndexes(jcas);
      }    
    }
  }
  
  /**
   * countWhiteSpaces(String phrase)    Count the number of whitespaces in a string.
   * 
   * @param phrase      input string that need to calculate.
   * @return int        the number of whitespaces in an input string.
   */
  private int countWhiteSpaces(String phrase){
    int countBlank = 0;
    for(int i=0; i<phrase.length(); i++) {
      if(Character.isWhitespace(phrase.charAt(i))) {
          countBlank++;
      }
    }
    return countBlank;
  }
}
