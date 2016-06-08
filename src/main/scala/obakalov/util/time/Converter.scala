package obakalov.util.time

import scala.language.implicitConversions

/**
  * Created by abakalov on 10.05.16.
  *
  * @author abakalov
  */
class Converter {

  val options = new OptionConverter(this)

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
    * Converting [[java.time.ZonedDateTime]] to [[org.joda.time.DateTime]]
    *
    * @param zonedDateTime instance of [[java.time.ZonedDateTime]]
    * @return object of [[org.joda.time.DateTime]]
    */
  def javaZonedDateTimeToJodaDateTime(zonedDateTime: java.time.ZonedDateTime): org.joda.time.DateTime = {
    new org.joda.time.DateTime(zonedDateTime.toInstant.toEpochMilli, org.joda.time.DateTimeZone.forID(zonedDateTime.getOffset.getId))
  }

  /**
    * Converting [[org.joda.time.DateTime]] to [[java.time.ZonedDateTime]]
    *
    * @param dateTime instance of [[org.joda.time.DateTime]]
    * @return object of [[java.time.ZonedDateTime]]
    */
  def jodaDateTimeToJavaZonedDateTime(dateTime: org.joda.time.DateTime) = java.time.ZonedDateTime
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

protected final class OptionConverter(val converter: Converter) {
  def jodaLocalDateTimeToJavaLocalDateTime(op: Option[org.joda.time.LocalDateTime]): Option[java.time.LocalDateTime] =
    op.map(converter.jodaLocalDateTimeToJavaLocalDateTime)

  def javaLocalDateTimeToJodaLocalDateTime(op: Option[java.time.LocalDateTime]): Option[org.joda.time.LocalDateTime] =
    op.map(converter.javaLocalDateTimeToJodaLocalDateTime)

  def javaZonedDateTimeToJodaDateTime(op: Option[java.time.ZonedDateTime]): Option[org.joda.time.DateTime] =
    op.map(converter.javaZonedDateTimeToJodaDateTime)

  def jodaDateTimeToJavaZonedDateTime(op: Option[org.joda.time.DateTime]): Option[java.time.ZonedDateTime] =
    op.map(converter.jodaDateTimeToJavaZonedDateTime)

  def javaLocalDateToJodaLocalDate(op: Option[java.time.LocalDate]): Option[org.joda.time.LocalDate] =
    op.map(converter.javaLocalDateToJodaLocalDate)

  def jodaLocalDateToJavaLocalDate(op: Option[org.joda.time.LocalDate]): Option[java.time.LocalDate] =
    op.map(converter.jodaLocalDateToJavaLocalDate)
}

object Converter extends Converter {

  object Implicits {

    implicit def jodaLocalDateTimeToJavaLocalDateTimeImplicits(d: org.joda.time.LocalDateTime): java.time.LocalDateTime = Converter.jodaLocalDateTimeToJavaLocalDateTime(d)

    implicit def javaLocalDateTimeToJodaDateTimeImplicits(d: java.time.LocalDateTime): org.joda.time.LocalDateTime = Converter.javaLocalDateTimeToJodaLocalDateTime(d)

    implicit def javaZonedDateTimeToJodaDateTimeImplicits(d: java.time.ZonedDateTime): org.joda.time.DateTime = Converter.javaZonedDateTimeToJodaDateTime(d)

    implicit def javaLocalDateToJodaLocalDateImplicits(d: java.time.LocalDate): org.joda.time.LocalDate = Converter.javaLocalDateToJodaLocalDate(d)

    implicit def jodaLocalDateToJavaLocalDateImplicits(d: org.joda.time.LocalDate): java.time.LocalDate = Converter.jodaLocalDateToJavaLocalDate(d)

    implicit def jodaDateTimeToJavaZonedDateTimeImplicits(d: org.joda.time.DateTime): java.time.ZonedDateTime = Converter.jodaDateTimeToJavaZonedDateTime(d)
  }

}


