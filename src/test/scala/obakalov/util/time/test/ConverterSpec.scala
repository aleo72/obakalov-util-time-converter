package obakalov.util.time.test

import org.scalatest.{FlatSpec, Matchers}

/**
  * Test of [[obakalov.util.time.Converter]]
  *
  * Created by abakalov on 10.05.16.
  *
  * @author abakalov
  */
class ConverterSpec extends FlatSpec with Matchers {
  val converter = new obakalov.util.time.Converter

  import Data._

  "Class Converter" should "JavaLocalDateTime to JodaLocalDateTime" in {
    javaLocalDateTime shouldEqual converter.jodaLocalDateTimeToJavaLocalDateTime(jodaDateTime)
  }

  it should "JodaLocalDateTime to JavaLocalDateTime" in {
    jodaDateTime shouldEqual converter.javaLocalDateTimeToJodaLocalDateTime(javaLocalDateTime)
  }

  it should "JavaLocalDate to JodaLocalDate" in {
    javaLocalDate shouldEqual converter.jodaLocalDateToJavaLocalDate(jodaLocalDate)
  }

  it should "JodaLocalDate to JavaLocalDate" in {
    jodaLocalDate shouldEqual converter.javaLocalDateToJodaLocalDate(javaLocalDate)
  }
  
  "Implicits Converter" should "JavaLocalDateTime to JodaLocalDateTime" in {
    import obakalov.util.time.Converter.Implicits.jodaLocalDateTimeToJavaLocalDateTimeImplicits
    val _jodaDateTime: java.time.LocalDateTime = jodaDateTime
    javaLocalDateTime shouldEqual _jodaDateTime
  }

  it should "JodaLocalDateTime to JavaLocalDateTime" in {
    import obakalov.util.time.Converter.Implicits.javaLocalDateTimeToJodaDateTimeImplicits
    val _javaDateTime: org.joda.time.LocalDateTime = javaLocalDateTime
    jodaDateTime shouldEqual _javaDateTime

  }

  it should "JavaLocalDate to JodaLocalDate" in {
    import obakalov.util.time.Converter.Implicits.javaLocalDateToJodaLocalDateImplicits
    val _javaLocalDate: org.joda.time.LocalDate = javaLocalDate
    jodaLocalDate shouldEqual _javaLocalDate
  }


  it should "JodaLocalDate to JavaLocalDate" in {
    import obakalov.util.time.Converter.Implicits.jodaLocalDateToJavaLocalDateImplicits
    val _jodaLocalDate: java.time.LocalDate = jodaLocalDate
    javaLocalDate shouldEqual _jodaLocalDate
  }

  object Data {
    val year = 2000
    val month = 1
    val dayOfMonth = 10
    val hour = 10
    val minute = 28
    val seconds = 18
    val nanoOfSecond = 0

    val javaLocalDateTime = java.time.LocalDateTime.of(year, month, dayOfMonth, hour, minute, seconds, nanoOfSecond)
    val jodaDateTime = new org.joda.time.LocalDateTime(year, month, dayOfMonth, hour, minute, seconds, 0)

    val javaLocalDate = java.time.LocalDate.of(year, month, dayOfMonth)
    val jodaLocalDate = new org.joda.time.LocalDate(year, month, dayOfMonth)

  }

}
