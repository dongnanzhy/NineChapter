package edu.cmu.yanzhao2.annotator;

import java.util.HashMap;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import edu.cmu.yanzhao2.types.*;
/** Merge used to evaluate gene words annotated using abner and lingpipe.
 * 
 * @author Yan Zhao
 * @version 1.0 October, 2014.
 */
public class Merge extends JCasAnnotator_ImplBase {
    private HashMap<String, Integer> abner_map_h = new HashMap<String, Integer>();
    private HashMap<String, Integer> abner_map_l = new HashMap<String, Integer>();
    /**
     * initialize method will initialize two hashmap to store high and low confident abner.
     * 
     * @param aContext
     * 
     */
    public void initialize(JCas jcas) {
        FSIterator<Annotation> abner_it = jcas.getAnnotationIndex(GeneAbner.type).iterator();
        while (abner_it.hasNext()) {
            GeneAbner abner = (GeneAbner) abner_it.next();
            if (abner.getConfidence() > 0.7) {
               abner_map_h.put(abner.getContent(), 1);
            } else {
               abner_map_l.put(abner.getContent(), 1);
            }
        }
    }
    /** 
     * process(JCas aJCas) will process JCAS with annotated noun/phrase by lingpipe and abner 
     * adding to result for consumer.
     * 
     * @param aJCas 
     *      a JCAS that this annotator should process.
     */
    public void process(JCas aJCas) throws AnalysisEngineProcessException {
        //TODO Auto-generated method stub
        initialize(aJCas);
        FSIterator<Annotation> Lingpipe_it = aJCas.getAnnotationIndex(GeneLingpipe.type).iterator();
        while (Lingpipe_it.hasNext()) {
              GeneLingpipe Lingpipe = (GeneLingpipe) Lingpipe_it.next();
              if (abner_map_h.containsKey(Lingpipe.getContent())
                     || (Lingpipe.getConfidence()>=0.7 && abner_map_l.containsKey(Lingpipe.getContent())) ){
//                  abner_map.remove(Lingpipe.getContent());
                  Result result = new Result(aJCas);
                  result.setContent(Lingpipe.getContent());
                  result.setId(Lingpipe.getId());
                  result.setBegin(Lingpipe.getBegin());
                  result.setEnd(Lingpipe.getEnd());
                  result.addToIndexes(aJCas);
          }
      }
    }
}