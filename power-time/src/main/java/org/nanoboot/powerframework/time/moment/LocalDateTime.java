
///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2016-2022 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation;
// version 2.1 of the License only.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package org.nanoboot.powerframework.time.moment;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * This class stores date time without time zone information.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class LocalDateTime extends DateTime {

    /**
     *
     * @param universalDateTime UniversalDateTime instance
     *
     * @return LocalDateTime instance
     */
    public static LocalDateTime removeUniversalTimeZone(UniversalDateTime universalDateTime) {
        return new LocalDateTime(universalDateTime);
    }

    /**
     *
     * @param zonedDateTime ZonedDateTime instance
     *
     * @return LocalDateTime instance
     */
    public static LocalDateTime removeTimeZone(ZonedDateTime zonedDateTime) {
        return new LocalDateTime(zonedDateTime);
    }

    /**
     *
     *
     * @param ldt java.time.LocalDateTime instance
     *
     * @return a org.nanoboot.powerframework.time.moment.LocalDateTime instance from this object
     */
    public static LocalDateTime toPowerLocalDateTime(java.time.LocalDateTime ldt) {
        return new LocalDateTime(ldt.getYear(), ldt.getDayOfMonth(), ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond(), ldt.getSecond());
    }

     /**
     *
     ** Creates new LocalDateTime from java.util.Date.
     * @param javaUtilDate java.util.Date instance
     *
     * @return a org.nanoboot.powerframework.time.moment.LocalDateTime instance from this object
     */
    public static LocalDateTime convertJavaUtilDateToPowerLocalDateTime(java.util.Date javaUtilDate) {
           Calendar cal = Calendar.getInstance();
        cal.setTime(javaUtilDate);
        
        return new LocalDateTime(
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND),
                cal.get(Calendar.MILLISECOND));
    }
    
    /**
     * Constructor
     *
     * Creates new LocalDateTime from String.
     *
     * @param dateTimeInString string representing the new LocalDateTime
     */
    public LocalDateTime(final String dateTimeInString) {
        super(dateTimeInString);
    }

    /**
     * Constructor
     *
     * Creates new LocalDateTime with these parameters.
     *
     * @param date date
     * @param time time
     */
    public LocalDateTime(final LocalDate date, final LocalTime time) {
        super(date.getYear(), date.getMonth(), date.getDay(),
                time.getHour(), time.getMinute(), time.getSecond(),
                time.getMillisecond());
    }
    /**
     * Constructor
     *
     * Creates new LocalDateTime with these parameters.
     *
     * @param year value
     * @param month value
     * @param day value
     * @param hour24Format value
     * @param minute value
     * @param second value
     * @param millisecond value
     */
    public LocalDateTime(int year,
            int month,
            int day,
            int hour24Format,
            int minute,
            int second,
            int millisecond) {
        super(year, month, day, hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     *
     * Creates new LocalDateTime from UniversalDateTime.
     *
     * @param universalDateTime UniversalDateTime instance
     */
    private LocalDateTime(UniversalDateTime universalDateTime) {
        super(universalDateTime);
    }

    /**
     * Constructor
     *
     * Creates new LocalDateTime from ZonedDateTime. The time zone information
     * is lost.
     *
     * @param zonedDateTime ZonedDateTime instance
     */
    private LocalDateTime(ZonedDateTime zonedDateTime) {
        super(zonedDateTime);
    }

    /**
     * Adds the universal time zone information to this local date time and
     * return new instance.
     *
     * @return a UniversalDateTime instance from this object.
     */
    public UniversalDateTime addUniversalTimeZoneInformation() {
        return UniversalDateTime.addUniversalTimeZoneInformation(this);
    }

    /**
     * Adds the time zone information to this local date time and return new
     * instance.
     *
     * @param timeZone time zone of new created ZonedDateTime
     *
     * @return a ZonedDateTime instance from this object
     */
    public ZonedDateTime addTimeZone(TimeZone timeZone) {
        return ZonedDateTime.joinLocalDateTimeAndTimeZone(this, timeZone);
    }

    /**
     *
     *
     * @return a java.time.LocalDateTime instance from this object
     */
    public java.time.LocalDateTime toJavaLocalDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String stringRepresentationOfThisObject = this.toString();
        return java.time.LocalDateTime.parse(stringRepresentationOfThisObject, dateTimeFormatter);
    }

}
