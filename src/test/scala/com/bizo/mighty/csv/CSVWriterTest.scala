package com.bizo.mighty.csv

import org.scalatest.{ WordSpec, BeforeAndAfterAll }
import org.scalatest.Matchers
import collection.JavaConversions._
import com.bizo.mighty.collection.ConsecutivelyGroupable._
import java.io.StringWriter
import au.com.bytecode.opencsv.{ CSVWriter => OpenCSVWriter }

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class CSVWriterTest extends WordSpec with Matchers with BeforeAndAfterAll {
  "CSVWriter" should {
    "properly write one row at a time" in {
      val rows = Seq(List("a", "b", "c"), List("1", "2", "3"))
      val output = new StringWriter()
      val writer = CSVWriter(new OpenCSVWriter(output))
      writer.write(rows(0))
      writer.write(rows(1))
      output.toString() should be("\"a\",\"b\",\"c\"\n\"1\",\"2\",\"3\"\n")
    }
  }
}
