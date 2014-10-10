package edu.cmu.yanzhao2.reader;

import java.io.File;
import java.io.IOException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;

/**
 * A simple collection reader that reads documents from a directory in the filesystem(src/main/resources/data).
 * It can be configured with the following parameters:
 * <ul>
 * <li><code>input</code> - path to directory containing files</li>
 * </ul>
 * @author Yan Zhao
 * @version 1.0 September, 2014.
 */
public class Reader extends CollectionReader_ImplBase {
  File file;
  
  /**
   * initialize()   used to set the path of files that the reader reads from
   */
  public void initialize() throws ResourceInitializationException {
    file = new File((String) getConfigParameterValue("input"));
  }
  
  /**
   * hasNext()      to identify if there are extra files need to read.
   * @return        return true for the first time, and return false. 
   */
  boolean test = true;
  public boolean hasNext() {
//    System.out.println("1111");
    if (test) {
      test = false;
      return true;
    } else {
      return false;
    }
  }

  /**
   * getNext(CAS aCAS)    Read the input file, and store the content into CAS.   
   * @param aCAS    
   */
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    JCas jcas;
    try {
    jcas = aCAS.getJCas();
    } catch (CASException e) {
    throw new CollectionException(e);
    }
    
    String content = null;
    try {
        content = FileUtils.file2String(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
    jcas.setDocumentText(content);
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

}

