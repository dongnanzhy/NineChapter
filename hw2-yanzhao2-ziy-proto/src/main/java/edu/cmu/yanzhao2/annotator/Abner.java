package edu.cmu.yanzhao2.annotator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import abner.Tagger;
import edu.cmu.yanzhao2.types.GeneAbner;
import edu.cmu.yanzhao2.types.Sentence;


public class Abner extends JCasAnnotator_ImplBase {
    private Tagger chunk = null;
    public void initialize(UimaContext context) throws ResourceInitializationException{
                chunk = new Tagger();
    }
      @Override
    public void process(JCas aJCas) throws AnalysisEngineProcessException {
      FSIterator<Annotation> it = aJCas.getAnnotationIndex(Sentence.type).iterator();
      while (it.hasNext()) {
          Sentence annot = (Sentence) it.next();
          String SentenceID = annot.getId();
          String SentenceContent = annot.getContent();
          GeneAbner abner = new GeneAbner(aJCas);
          String gene[][] = chunk.getEntities(SentenceContent);
          for (int i = 0; i < gene[0].length; i++){
            double confidence = 0.8;
            if(gene[0][i].length() >= 6){
              confidence = 0.6;
            }
            int begin = SentenceContent.indexOf(gene[0][i]);
            if (begin == -1) {
              continue;
            }
            begin = begin - countWhiteSpaces(SentenceContent.substring(0,begin));
            int end = begin + gene[0][i].length() - countWhiteSpaces(gene[0][i]) - 1;
            abner.setId(SentenceID);
            abner.setContent(gene[0][i]);
            abner.setBegin(begin);
            abner.setEnd(end);
            abner.setConfidence(confidence);
            abner.addToIndexes();
      }
      
      }
    }
      
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