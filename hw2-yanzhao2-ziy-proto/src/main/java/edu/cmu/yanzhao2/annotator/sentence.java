package edu.cmu.yanzhao2.annotator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import edu.cmu.yanzhao2.types.*;

/**
 * This class used to annotate the sentence.  
 * @author Yan Zhao
 * @version 1.0 September, 2014.
 */
public class sentence extends JCasAnnotator_ImplBase {

  /**
   * process(JCas arg0)     Read content from CAS, split it by line, and annotate them by their ID and content. 
   * @param aCAS  
   */
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    String text = arg0.getDocumentText();
    String[] sentence = text.split("\n");
    for (int i = 0; i< sentence.length; i++){
      /**
       * The first whitespace split the ID and content.
       */
      int partition = sentence[i].indexOf(' ');
      String sentenceID = sentence[i].substring(0, partition);
      String sentenceContent = sentence[i].substring(partition).trim();
      
      Sentence annot = new Sentence(arg0);
      annot.setId(sentenceID);
      annot.setContent(sentenceContent);
      annot.addToIndexes();
    }
  }
}
