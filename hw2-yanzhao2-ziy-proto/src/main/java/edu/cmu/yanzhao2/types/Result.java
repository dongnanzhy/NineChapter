

/* First created by JCasGen Tue Oct 07 18:23:16 PDT 2014 */
package edu.cmu.yanzhao2.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Oct 08 13:11:36 PDT 2014
 * XML source: /home/dongnanzhy/git/hw2-yanzhao2/hw2-yanzhao2-ziy-proto/src/main/resources/descriptors/typeSystemDescriptor.xml
 * @generated */
public class Result extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Result.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Result() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Result(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Result(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Result(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.yanzhao2.types.Result");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Result_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.yanzhao2.types.Result");
    jcasType.ll_cas.ll_setStringValue(addr, ((Result_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets 
   * @generated
   * @return value of the feature 
   */
  public String getContent() {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "edu.cmu.yanzhao2.types.Result");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Result_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setContent(String v) {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "edu.cmu.yanzhao2.types.Result");
    jcasType.ll_cas.ll_setStringValue(addr, ((Result_Type)jcasType).casFeatCode_content, v);}    
  }

    