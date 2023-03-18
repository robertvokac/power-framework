
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

import java.time.ZoneId;
import java.time.format.*;
import org.nanoboot.powerframework.time.duration.Duration;
import org.nanoboot.powerframework.time.duration.Period;

/**
 * Represents date and time with time zone information.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class ZonedDateTime extends DateTime {

    private static final String DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIMEFORMAT);

    /**
     *
     * @param timeZone
     *
     * @return
     */
    public static ZonedDateTime getCurrentZonedDateTimeForTimeZone(
            TimeZone timeZone) {
        UniversalDateTime udt = UniversalDateTime.now();
        return udt.convertToZonedDateTimeWithUniversalTimeZone().toZonedDateTime(timeZone);
    }

    static ZonedDateTime updateDateAndTimeToUniversalDateTime(
            UniversalDateTime universalDateTime) {
        return new ZonedDateTime(universalDateTime);
    }

    static ZonedDateTime joinLocalDateTimeAndTimeZone(
            LocalDateTime localDateTime,
            TimeZone toTimeZone) {
        return new ZonedDateTime(localDateTime, toTimeZone);
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
    static String convertDateTimeFromOneTimeZoneToAnother(
            String dateTimeInString,
            TimeZone oldTimeZone,
            TimeZone newTimeZone) {

        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.parse(dateTimeInString, dateTimeFormatter);

        ZoneId oldZoneID = ZoneId.of(oldTimeZone.getTimeZoneID());
        java.time.ZonedDateTime oldZonedDateTime = localDateTime.atZone(oldZoneID);

        ZoneId newZoneId = ZoneId.of(newTimeZone.getTimeZoneID());
        java.time.ZonedDateTime newZonedDateTime = oldZonedDateTime.withZoneSameInstant(newZoneId);
        return dateTimeFormatter.format(newZonedDateTime);
    }
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
    private ZonedDateTime(UniversalDateTime universalDateTime) {
        super(universalDateTime);

        TimeZone timeZoneForUniversalTime = new TimeZone("UTC");
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
    private ZonedDateTime(LocalDateTime localDateTime,
            TimeZone toTimeZone) {
        super(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDay(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getMillisecond());

        String stringRepresentationOfLocalDateTime = localDateTime.toString();
        TimeZone timeZoneForUniversalTime = new TimeZone("UTC");
        String stringRepresentationOfZonedDateTimeWithUniversalTimeZone = ZonedDateTime.convertDateTimeFromOneTimeZoneToAnother(
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
    public ZonedDateTime(ZonedDateTime zonedDateTime,
            TimeZone newTimeZone) {
        super(ZonedDateTime.convertDateTimeFromOneTimeZoneToAnother(zonedDateTime.toString(), zonedDateTime.timeZone, newTimeZone));

        this.universalDateTime = zonedDateTime.toUniversalDateTime();
        this.timeZone = newTimeZone;
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
     * @param duration
     *
     * @return
     */
    public ZonedDateTime plusDuration(Duration duration) {
        return new Period(this, duration).getEndZonedDateTime();
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
        return LocalDateTime.removeTimeZone(this);
    }

    /**
     *
     * @param newTimeZone
     *
     * @return a ZonedDateTime instance from this object with the given new time
     * zone.
     */
    public ZonedDateTime toZonedDateTime(TimeZone newTimeZone) {
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
