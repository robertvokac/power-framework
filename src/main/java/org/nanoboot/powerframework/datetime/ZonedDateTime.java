
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

package org.nanoboot.powerframework.datetime;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Represents date and time with time zone information.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public final class ZonedDateTime extends DateTime {

    private static final String DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIMEFORMAT);
    /**
     * Instance of class UniversalDateTime for this ZonedDateTime.
     */
    private final UniversalDateTime universalDateTime;
    private final TimeZone timeZone;

    /**
     * Constructor
     *
     * Creates ZonedDateTime from UniversalDateTime with universal time zone.
     *
     * @param universalDateTime
     */
    public ZonedDateTime(UniversalDateTime universalDateTime) {
        super(universalDateTime);

        TimeZone timeZoneForUniversalTime = new org.nanoboot.powerframework.datetime.TimeZone("UTC");
        this.timeZone = timeZoneForUniversalTime;
        this.universalDateTime = universalDateTime;

    }

    /**
     * Constructor
     *
     * Creates ZonedDateTime from LocalDateTime with the given time zone.
     *
     * @param localDateTime
     * @param toTimeZone
     */
    public ZonedDateTime(LocalDateTime localDateTime, org.nanoboot.powerframework.datetime.TimeZone toTimeZone) {
        super(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDay(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getMillisecond());

        String stringRepresentationOfLocalDateTime = localDateTime.toString();
        TimeZone timeZoneForUniversalTime = new org.nanoboot.powerframework.datetime.TimeZone("UTC");
        String stringRepresentationOfZonedDateTimeWithUniversalTimeZone = org.nanoboot.powerframework.datetime.ZonedDateTime.convertDateTimeFromOneTimeZoneToAnother(
                stringRepresentationOfLocalDateTime,
                toTimeZone,
                timeZoneForUniversalTime
        );
        this.universalDateTime = new UniversalDateTime(stringRepresentationOfZonedDateTimeWithUniversalTimeZone);

        this.timeZone = toTimeZone;
    }

    /**
     * Constructor
     *
     * Creates ZonedDateTime from another ZonedDateTime object, but the time
     * zone is changed.
     *
     * @param zonedDateTime
     * @param newTimeZone
     */
    public ZonedDateTime(ZonedDateTime zonedDateTime, org.nanoboot.powerframework.datetime.TimeZone newTimeZone) {
        super(ZonedDateTime.convertDateTimeFromOneTimeZoneToAnother(zonedDateTime.toString(), zonedDateTime.timeZone, newTimeZone));

        this.universalDateTime = zonedDateTime.toUniversalDateTime();
        this.timeZone = newTimeZone;
    }

    /**
     *
     * @param dateTimeInString
     * @param oldTimeZone
     * @param newTimeZone
     *
     * @return String representation from the given String, but old time zone is
     * changed to new time zone.
     */
    static String convertDateTimeFromOneTimeZoneToAnother(String dateTimeInString, org.nanoboot.powerframework.datetime.TimeZone oldTimeZone, org.nanoboot.powerframework.datetime.TimeZone newTimeZone) {

        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.parse(dateTimeInString, dateTimeFormatter);

        ZoneId oldZoneID = ZoneId.of(oldTimeZone.getTimeZoneID());
        java.time.ZonedDateTime oldZonedDateTime = localDateTime.atZone(oldZoneID);

        ZoneId newZoneId = ZoneId.of(newTimeZone.getTimeZoneID());
        java.time.ZonedDateTime newZonedDateTime = oldZonedDateTime.withZoneSameInstant(newZoneId);
        return dateTimeFormatter.format(newZonedDateTime);
    }

    /**
     *
     * @return time zone of this ZonedDateTime
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     *
     * @return a UniversalDateTime instance from this object
     */
    public UniversalDateTime toUniversalDateTime() {
        return this.universalDateTime;
    }

    /**
     *
     * @return a LocalDateTime instance from this object
     */
    public LocalDateTime toLocalDateTime() {
        return new LocalDateTime(this);
    }

    /**
     *
     * @param newTimeZone
     * @return a ZonedDateTime instance from this object with the given new time
     * zone.
     */
    public ZonedDateTime toZonedDateTime(org.nanoboot.powerframework.datetime.TimeZone newTimeZone) {
        return new ZonedDateTime(this, newTimeZone);
    }

    /**
     *
     * @return a java.time.ZonedDateTime instance from this object
     */
    java.time.ZonedDateTime toJavaZonedDateTime() {
        ZoneId zoneId = java.time.ZoneId.of(this.timeZone.getTimeZoneID());
        java.time.LocalDateTime tempLocalDateTime = java.time.LocalDateTime.parse(toString(), dateTimeFormatter);
        return tempLocalDateTime.atZone(zoneId);
    }
}
