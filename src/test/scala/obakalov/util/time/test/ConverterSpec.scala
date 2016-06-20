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
  val options = new obakalov.util.time.OptionConverter

  import Data._

  "Class Converter" should "JavaLocalDateTime to JodaLocalDateTime" in {
    javaLocalDateTime shouldEqual converter.jodaLocalDateTimeToJavaLocalDateTime(jodaLocalDateTime)
  }

  it should "JodaLocalDateTime to JavaLocalDateTime" in {
    jodaLocalDateTime shouldEqual converter.javaLocalDateTimeToJodaLocalDateTime(javaLocalDateTime)
  }

  it should "JavaLocalDate to JodaLocalDate" in {
    javaLocalDate shouldEqual converter.jodaLocalDateToJavaLocalDate(jodaLocalDate)
  }

  it should "JodaLocalDate to JavaLocalDate" in {
    jodaLocalDate shouldEqual converter.javaLocalDateToJodaLocalDate(javaLocalDate)
  }

  it should "JodaDateTime to JavaOffsetDateTime" in {
    javaZonedDateTime shouldEqual converter.jodaDateTimeToJavaZonedDateTime(jodaDateTime)
  }

  it should "JavaOffsetDateTime to JodaDateTime" in {
    jodaDateTime shouldEqual converter.javaZonedDateTimeToJodaDateTime(javaZonedDateTime)
  }

  "Implicits Converter" should "JavaLocalDateTime to JodaLocalDateTime" in {
    import obakalov.util.time.Converter.Implicits.jodaLocalDateTimeToJavaLocalDateTimeImplicits
    val _jodaDateTime: java.time.LocalDateTime = jodaLocalDateTime
    javaLocalDateTime shouldEqual _jodaDateTime
  }

  it should "JodaLocalDateTime to JavaLocalDateTime" in {
    import obakalov.util.time.Converter.Implicits.javaLocalDateTimeToJodaDateTimeImplicits
    val _javaDateTime: org.joda.time.LocalDateTime = javaLocalDateTime
    jodaLocalDateTime shouldEqual _javaDateTime
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

  it should "JodaDateTime to JavaOffsetDateTime" in {
    import obakalov.util.time.Converter.Implicits.jodaDateTimeToJavaZonedDateTimeImplicits
    val joda: java.time.ZonedDateTime = jodaDateTime
    javaZonedDateTime shouldEqual joda
  }

  it should "JavaOffsetDateTime to JodaDateTime" in {
    import obakalov.util.time.Converter.Implicits.javaZonedDateTimeToJodaDateTimeImplicits
    val java: org.joda.time.DateTime = javaZonedDateTime
    jodaDateTime shouldEqual java
  }

  "Class OptionConverter" should "JavaLocalDateTime to JodaLocalDateTime" in {
    options.jodaLocalDateTimeToJavaLocalDateTime(Some(jodaLocalDateTime)) should contain(javaLocalDateTime)
  }

  it should "JodaLocalDateTime to JavaLocalDateTime" in {
    options.javaLocalDateTimeToJodaLocalDateTime(Some(javaLocalDateTime)) should contain(jodaLocalDateTime)
  }

  it should "JavaLocalDate to JodaLocalDate" in {
    options.jodaLocalDateToJavaLocalDate(Some(jodaLocalDate)) should contain(javaLocalDate)
  }

  it should "JodaLocalDate to JavaLocalDate" in {
    options.javaLocalDateToJodaLocalDate(Some(javaLocalDate)) should contain(jodaLocalDate)
  }

  it should "JodaDateTime to JavaOffsetDateTime" in {
    options.jodaDateTimeToJavaZonedDateTime(Some(jodaDateTime)) should contain(javaZonedDateTime)
  }

  it should "JavaOffsetDateTime to JodaDateTime" in {
    options.javaZonedDateTimeToJodaDateTime(Some(javaZonedDateTime)) should contain(jodaDateTime)
  }
  it should "None to None" in {
    options.javaZonedDateTimeToJodaDateTime(Option(null)) shouldBe empty
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
    val jodaLocalDateTime = new org.joda.time.LocalDateTime(year, month, dayOfMonth, hour, minute, seconds, 0)

    val javaLocalDate = java.time.LocalDate.of(year, month, dayOfMonth)
    val jodaLocalDate = new org.joda.time.LocalDate(year, month, dayOfMonth)

    val javaZonedDateTime = java.time.ZonedDateTime.of(javaLocalDateTime, java.time.ZoneOffset.ofHours(-2))
    val jodaDateTime = new org.joda.time.DateTime(year, month, dayOfMonth, hour, minute, seconds, 0, org.joda.time.DateTimeZone.forOffsetHours(-2))

  }

}
