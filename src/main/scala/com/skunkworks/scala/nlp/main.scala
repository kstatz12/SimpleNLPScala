package com.skunkworks.scala.nlp
import awscala._
import com.amazonaws.services.s3.model
import s3._

object main extends App {
  implicit val s3 = S3.at(Region.US_EAST_1)
  val obj: model.S3Object = s3.getObject("test-nlp-bucket", "end-user-license-agreements-ed-ca.pdf")
  val content = new TextExtractor().extractText(obj)
}
