package com.skunkworks.scala.nlp

import com.amazonaws.services.s3.model.S3Object
import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.{AutoDetectParser, ParseContext, Parser}
import org.apache.tika.sax.{BodyContentHandler, WriteOutContentHandler}

class TextExtractor {

  def extractText(s3Object: S3Object): String ={
    try{
      val handler = new WriteOutContentHandler(-1)
      val metaData = new Metadata()
      val parser = new AutoDetectParser()
      val ctx = new ParseContext()
      parser.parse(s3Object.getObjectContent(), handler, metaData, ctx)
      return handler.toString()
    }
  }
}
