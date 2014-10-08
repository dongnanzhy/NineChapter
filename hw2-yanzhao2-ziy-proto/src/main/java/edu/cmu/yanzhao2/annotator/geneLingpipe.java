package edu.cmu.yanzhao2.annotator;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;
import edu.cmu.yanzhao2.types.*;


/**
 * This class used to annotate gene words.Using lingpipe genetag.HmmChunker
 * @author Yan Zhao
 * @version 2.0 September, 2014.
 */
public class geneLingpipe extends JCasAnnotator_ImplBase {
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
  
  public void initialize(UimaContext context) {
    modelFile = new File("src/main/resources/descriptors/ne-en-bio-genetag.HmmChunker");
    try {
      chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * process(JCas arg0)     Read sentences from CAS iteratively, use lingpipe gene library to check if a string is genetic.
   *                        Store the ID and content of gene words into CAS. 
   * @param aCAS            Object of JCas
   * @param annotate_s      Object of Class sentenceTag, used to read sentence ID and content.
   * @param confidence      Used in <ne-en-bio-genetag.HmmChunker> to calculate the confidence of the recognized gene words.
   * @param annotate_g      Used to set Gene ID and content.
   */
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    /*   First method using Stanford NER
    PosTagNamedEntityRecognizer Recognizer = null;    
    try {
      Recognizer = new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    int begin;
    int end;
    String gene;
    
    while (it.hasNext()) {
      sentenceTag annotate_s = (sentenceTag) it.next();
      sentenceID = annotate_s.getId();
      sentenceContent = annotate_s.getContent(); 
      Map<Integer, Integer> BeginToEnd = Recognizer.getGeneSpans(sentenceContent);
      
      for (Map.Entry<Integer, Integer> entry : BeginToEnd.entrySet())
      {
          begin = entry.getKey();
          end = entry.getValue();
          gene = sentenceContent.substring(begin, end);
          begin = begin - countWhiteSpaces(sentenceContent.substring(0,begin)) ;
          end = begin + gene.length() - countWhiteSpaces(gene) - 1;
          
            geneTag annotate_g = new geneTag(jcas);
            annotate_g.setBegin(begin);
            annotate_g.setEnd(end);
            annotate_g.setId(sentenceID);
            annotate_g.setContent(gene);
            annotate_g.addToIndexes();
      }
    }
    */
    JCas jcas = arg0;
    try {
      chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
        if (confidence < 0.6) {
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
        annotate.addToIndexes(jcas);
      }    
    }
  }
  
  /**
   * countWhiteSpaces(String phrase)    Count the number of whitespaces in a string.
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
