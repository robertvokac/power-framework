
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

import java.text.SimpleDateFormat;

/**
 * This class represents date and time and is immutable.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public abstract class DateTime {

    /**
     *
     */
    protected static class SimpleDateTimeFormatByTimeZone extends SimpleDateFormat {

        /**
         *
         * @param timeZone
         * @param formatText
         */
        protected SimpleDateTimeFormatByTimeZone(TimeZone timeZone, String formatText) {
            super(formatText);
            setTimeZone(java.util.TimeZone.getTimeZone(timeZone.toString()));
        }
    }

    private final LocalDate date;
    private final LocalTime time;

    /**
     * Constructor
     *
     * Sets all values.
     *
     * @param localDate Represents a date.
     * @param localTime Represents a time.
     */
    DateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    /**
     * Constructor
     *
     * Sets all values.
     *
     * @param year Represents a year.
     * @param month Represents a month.
     * @param day Represents a day.
     * @param hour24Format Represents an hour.
     * @param minute Represents a minute
     * @param second Represents a second.
     * @param millisecond Represents a millisecond.
     */
    DateTime(int year, int month, int day, int hour24Format, int minute, int second, int millisecond) {
        this.date = new LocalDate(year, month, day);
        this.time = new LocalTime(hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     *
     * Sets all values from another object.
     *
     * @param dateTime
     */
    protected DateTime(DateTime dateTime) {
        int year = dateTime.getYear();
        int month = dateTime.getMonth();
        int day = dateTime.getDay();
        date = new LocalDate(year, month, day);

        int hour24Format = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();
        int millisecond = dateTime.getMillisecond();
        time = new LocalTime(hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     *
     * Sets all values from String
     *
     * @param dateTimeInString This String has following format: 2016-12-31
     * 24:45:14:453 yyyy-MM-dd HH:mm:ss:SSS
     */
    public DateTime(String dateTimeInString) {
        int year = Integer.parseInt(dateTimeInString.substring(0, 4));
        int month = Integer.parseInt(dateTimeInString.substring(5, 7));
        int day = Integer.parseInt(dateTimeInString.substring(8, 10));
        date = new LocalDate(year, month, day);

        int hour = Integer.parseInt(dateTimeInString.substring(11, 13));
        int minute = Integer.parseInt(dateTimeInString.substring(14, 16));
        int second = Integer.parseInt(dateTimeInString.substring(17, 19));
        int millisecond = Integer.parseInt(dateTimeInString.substring(20, 23));
        time = new LocalTime(hour, minute, second, millisecond);
    }

    /**
     *
     * @return year
     */
    public int getYear() {
        return this.date.getYear();
    }

    /**
     *
     * @return month
     */
    public int getMonth() {
        return this.date.getMonth();
    }

    /**
     *
     * @return day
     */
    public int getDay() {
        return this.date.getDay();
    }

    /**
     *
     * @return hour
     */
    public int getHour() {
        return this.time.getHour();
    }

    /**
     *
     * @return minute
     */
    public int getMinute() {
        return this.time.getMinute();
    }

    /**
     *
     * @return second
     */
    public int getSecond() {
        return this.time.getSecond();
    }

    /**
     *
     * @return millisecond
     */
    public int getMillisecond() {
        return this.time.getMillisecond();
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(this.date.toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.time.toString());

        return stringBuffer.toString();
    }

}
