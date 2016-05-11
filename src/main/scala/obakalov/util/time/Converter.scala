package obakalov.util.time

import java.time.ZoneId

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
    java.time.LocalDateTime.ofInstant(jodaDateTime.toDate.toInstant, ZoneId.systemDefault())
  }

  /**
    * Converting [[java.time.LocalDateTime]] to [[org.joda.time.DateTime]]
    *
    * @param localDateTime instance of [[java.time.LocalDateTime]]
    * @return object of [[org.joda.time.DateTime]]
    */
  def javaLocalDateTimeToJodaDateTime(localDateTime: java.time.LocalDateTime): org.joda.time.LocalDateTime = {
    new org.joda.time.LocalDateTime(
      localDateTime.atZone(
        java.time.ZoneId.systemDefault()
      ).toInstant.toEpochMilli
    )
  }

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

    implicit def javaLocalDateTimeToJodaDateTimeImplicits(d: java.time.LocalDateTime): org.joda.time.LocalDateTime = Converter.javaLocalDateTimeToJodaDateTime(d)

    implicit def javaLocalDateToJodaLocalDateImplicits(d: java.time.LocalDate): org.joda.time.LocalDate = Converter.javaLocalDateToJodaLocalDate(d)

    implicit def jodaLocalDateToJavaLocalDateImplicits(d: org.joda.time.LocalDate): java.time.LocalDate = Converter.jodaLocalDateToJavaLocalDate(d)
  }

}


