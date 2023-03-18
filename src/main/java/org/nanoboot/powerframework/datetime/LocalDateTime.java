
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

import java.time.format.DateTimeFormatter;

/**
 * This class stores date time without time zone information.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public final class LocalDateTime extends DateTime {

    /**
     * Constructor
     *
     * Creates new LocalDateTime from String.
     *
     * @param dateTimeInString
     */
    protected LocalDateTime(String dateTimeInString) {
        super(dateTimeInString);
    }

    /**
     * Constructor
     *
     * Creates new LocalDateTime with these parameters.
     *
     * @param year
     * @param month
     * @param day
     * @param hour24Format
     * @param minute
     * @param second
     * @param millisecond
     */
    public LocalDateTime(int year, int month, int day, int hour24Format, int minute, int second, int millisecond) {
        super(year, month, day, hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     *
     * Creates new LocalDateTime from UniversalDateTime.
     *
     * @param universalDateTime
     */
    public LocalDateTime(UniversalDateTime universalDateTime) {
        super(universalDateTime);
    }

    /**
     * Constructor
     *
     * Creates new LocalDateTime from ZonedDateTime.
     *
     * @param zonedDateTime
     */
    public LocalDateTime(ZonedDateTime zonedDateTime) {
        super(zonedDateTime);
    }

    /**
     *
     *
     * @return a UniversalDateTime instance from this object
     */
    public UniversalDateTime toUniversalDateTime() {
        return new UniversalDateTime(this);
    }

    /**
     *
     *
     * @param timeZone time zone of new created ZonedDateTime
     * @return a ZonedDateTime instance from this object
     */
    public ZonedDateTime toZonedDateTime(org.nanoboot.powerframework.datetime.TimeZone timeZone) {
        return new ZonedDateTime(this, timeZone);
    }

    /**
     *
     *
     * @return a java.time.LocalDateTime instance from this object
     */
    java.time.LocalDateTime toJavaLocalDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String stringRepresentationOfThisObject = this.toString();
        return java.time.LocalDateTime.parse(stringRepresentationOfThisObject, dateTimeFormatter);
    }

}
