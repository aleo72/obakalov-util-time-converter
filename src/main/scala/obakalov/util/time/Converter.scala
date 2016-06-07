package obakalov.util.time

import scala.language.implicitConversions

/**
  * Created by abakalov on 10.05.16.
  *
  * @author abakalov
  */
class Converter {

  /**
    * Converting [[org.joda.time.DateTime]] to [[java.time.LocalDateTime]]
    *
    * @param jodaDateTime instance
    * @return object of [[java.time.LocalDateTime]]
    */
  def jodaLocalDateTimeToJavaLocalDateTime(jodaDateTime: org.joda.time.LocalDateTime): java.time.LocalDateTime = {
    java.time.LocalDateTime.ofInstant(jodaDateTime.toDate.toInstant, java.time.ZoneId.systemDefault())
  }

  /**
    * Converting [[java.time.LocalDateTime]] to [[org.joda.time.LocalDateTime]]
    *
    * @param localDateTime instance of [[java.time.LocalDateTime]]
    * @return object of [[org.joda.time.LocalDateTime]]
    */
  def javaLocalDateTimeToJodaLocalDateTime(localDateTime: java.time.LocalDateTime): org.joda.time.LocalDateTime = {
    new org.joda.time.LocalDateTime(
      localDateTime.atZone(
        java.time.ZoneId.systemDefault()
      ).toInstant.toEpochMilli
    )
  }

  /**
    * Converting [[java.time.OffsetDateTime]] to [[org.joda.time.DateTime]]
    *
    * @param offsetDateTime instance of [[java.time.OffsetDateTime]]
    * @return object of [[org.joda.time.DateTime]]
    */
  def javaOffsetDateTimeToJodaDateTime(offsetDateTime: java.time.OffsetDateTime): org.joda.time.DateTime = {
    new org.joda.time.DateTime(offsetDateTime.toInstant.toEpochMilli, org.joda.time.DateTimeZone.forID(offsetDateTime.getOffset.getId))
  }

  /**
    * Converting [[org.joda.time.DateTime]] to [[java.time.OffsetDateTime]]
    *
    * @param dateTime instance of [[org.joda.time.DateTime]]
    * @return object of [[java.time.OffsetDateTime]]
    */
  def jodaDateTimeToJavaOffsetDateTime(dateTime: org.joda.time.DateTime) = java.time.OffsetDateTime
    .ofInstant(dateTime.toDate.toInstant, java.time.ZoneId.of(dateTime.getZone.getID))

  /**
    * Converting [[java.time.LocalDate]] to [[org.joda.time.LocalDate]]
    *
    * @param date instance of [[java.time.LocalDate]]
    * @return object of [[org.joda.time.LocalDate]]
    */
  def javaLocalDateToJodaLocalDate(date: java.time.LocalDate): org.joda.time.LocalDate = {
    new org.joda.time.LocalDate(date.getYear, date.getMonthValue, date.getDayOfMonth)
  }

  /**
    * Converting [[org.joda.time.LocalDate]] to [[java.time.LocalDate]]
    *
    * @param jodaDate instance of [[org.joda.time.LocalDate]]
    * @return object of [[java.time.LocalDate]]
    */
  def jodaLocalDateToJavaLocalDate(jodaDate: org.joda.time.LocalDate): java.time.LocalDate = {
    java.time.LocalDate.ofYearDay(jodaDate.getYear, jodaDate.getDayOfYear)
  }
}

object Converter extends Converter {

  object Implicits {

    implicit def jodaLocalDateTimeToJavaLocalDateTimeImplicits(d: org.joda.time.LocalDateTime): java.time.LocalDateTime = Converter.jodaLocalDateTimeToJavaLocalDateTime(d)

    implicit def javaLocalDateTimeToJodaDateTimeImplicits(d: java.time.LocalDateTime): org.joda.time.LocalDateTime = Converter.javaLocalDateTimeToJodaLocalDateTime(d)

    implicit def javaOffsetDateTimeToJodaDateTimeImplicits(d: java.time.OffsetDateTime): org.joda.time.DateTime = Converter.javaOffsetDateTimeToJodaDateTime(d)

    implicit def javaLocalDateToJodaLocalDateImplicits(d: java.time.LocalDate): org.joda.time.LocalDate = Converter.javaLocalDateToJodaLocalDate(d)

    implicit def jodaLocalDateToJavaLocalDateImplicits(d: org.joda.time.LocalDate): java.time.LocalDate = Converter.jodaLocalDateToJavaLocalDate(d)

    implicit def jodaDateTimeToJavaOffsetDateTimeImplicits(d: org.joda.time.DateTime): java.time.OffsetDateTime = Converter.jodaDateTimeToJavaOffsetDateTime(d)
  }

}


