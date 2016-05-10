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
  def jodaDateTimeToJavaLocalDateTime(jodaDateTime: org.joda.time.DateTime): java.time.LocalDateTime = {
    java.time.LocalDateTime.ofInstant(
      java.time.Instant.ofEpochMilli(jodaDateTime.toInstant.getMillis),
      java.time.ZoneId.systemDefault()
    )
  }

  /**
    * Converting [[java.time.LocalDateTime]] to [[org.joda.time.DateTime]]
    *
    * @param localDateTime instance of [[java.time.LocalDateTime]]
    * @return object of [[org.joda.time.DateTime]]
    */
  def javaLocalDateTimeToJodaDateTime(localDateTime: java.time.LocalDateTime): org.joda.time.DateTime = {
    new org.joda.time.DateTime(
      localDateTime.atZone(
        java.time.ZoneId.systemDefault()
      ).toInstant.toEpochMilli
    )
  }
}

object Converter extends Converter {

  object Implicits {

    implicit val jodaDateTimeToJavaLocalDateTimeImplicits: org.joda.time.DateTime => java.time.LocalDateTime = Converter.jodaDateTimeToJavaLocalDateTime

    implicit val localDateTimeToJodaDateTime: java.time.LocalDateTime => org.joda.time.DateTime = Converter.javaLocalDateTimeToJodaDateTime
  }

}


