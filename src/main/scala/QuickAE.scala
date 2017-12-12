package org.usfinformatics.hs619.uima_anotator
import java.io.FileOutputStream

import org.apache.ctakes.core.cc.TokenFreqCasConsumer
import org.apache.uima.analysis_engine.AnalysisEngine
import org.apache.uima.fit.descriptor.ConfigurationParameter
import org.apache.uima.fit.factory.AnalysisEngineFactory
import org.apache.uima.fit.factory.JCasFactory
import org.apache.uima.jcas.JCas
import org.apache.ctakes.core.cr.TextReader
import org.apache.ctakes.typesystem.`type`.refsem.DiseaseDisorder
import org.apache.ctakes.typesystem.`type`.textsem.DiseaseDisorderMention
import edu.mayo.bmi.uima.drugner.DrugMentionAnnotation

import org.apache.uima.analysis_engine.AnalysisEngineDescription
import org.apache.uima.collection.CollectionReaderDescription
import org.apache.uima.fit.factory.AnalysisEngineFactory
import org.apache.uima.fit.factory.CollectionReaderFactory
import org.apache.uima.fit.pipeline.SimplePipeline
import org.apache.uima.fit.util.JCasUtil
import org.apache.uima.jcas.tcas.Annotation
import scala.util.matching.Regex

object QuickAE {
  final val REGEX_Patter = "regex"
}

class QuickAE extends org.apache.uima.fit.component.JCasAnnotator_ImplBase {


  override def process(aJCas: JCas): Unit = {

    println("this is working")

    //val all = JCasUtil.selectAll(aJCas)
    //println("all.size(): " + all.size() )
    val drug_name = JCasUtil.select(aJCas, classOf[medicationRelatedSection])

    
    println("disease or disorders:" + medicationRelatedSection)
    //println(aJCas.getDocumentText)
    import scala.util._

//    val text = aJCas.getDocumentText
//    //println(text)
//
//    val reg = "[A-Z]+".r
//    val matches = reg.findAllMatchIn(text)
//    for (c <- matches) {
//      println(c)
//      val annotation = new Annotation(aJCas)
//      annotation.setBegin(c.start)
//      annotation.setEnd(c.end)
//      annotation.addToIndexes()
//      println("Annotation added: " + annotation)

      //}



  }

}

object TestAE extends App{
  println("main works")
  val jCas= JCasFactory.createJCas

  val analysisEngine =  AnalysisEngineFactory.createEngine(
    classOf[QuickAE]
    //QuickAE.REGEX_Patter, ".*"
  )
  analysisEngine.process(jCas)

}

object TextAMLAE extends App {
  val ae = AnalysisEngineFactory.createEngine(
    "desc.ctakes-clinical-pipeline.desc.analysis_engine.AggregatePlaintextUMLSProcessor"
  )

}

object TestXMLAE extends App {



  val reader = CollectionReaderFactory.createReaderDescription(
    classOf[TextReader],
    TextReader.PARAM_FILES, "docs/sample.txt"
  )

  val ane = AnalysisEngineFactory.createEngineDescription(
    "desc.ctakes-clinical-pipeline.desc.analysis_engine.AggregatePlaintextProcessor"
  )
  val qae = AnalysisEngineFactory.createEngineDescription(
    classOf[QuickAE]
  )//because the qae, it called the 'process' function and print out "this is working".

  SimplePipeline.runPipeline(reader, ane, qae)
}

