package edu.cmu.yanzhao2.annotator;

import java.util.HashMap;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import edu.cmu.yanzhao2.types.*;

public class Merge extends JCasAnnotator_ImplBase {
    private HashMap<String, Integer> abner_map_h = new HashMap<String, Integer>();
    private HashMap<String, Integer> abner_map_l = new HashMap<String, Integer>();
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