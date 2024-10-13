
///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2016-2024 the original author or authors.
//
// This program is free software: you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation, either version 3
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program. If not, see 
// <https://www.gnu.org/licenses/> or write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
///////////////////////////////////////////////////////////////////////////////////////////////

package com.robertvokac.powerframework.time.moment;

import com.robertvokac.powerframework.time.utils.TimeException;

/**
 * This class represents date and time and is immutable.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class DateTime implements Comparable<DateTime> {

    private final LocalDate date;
    private final LocalTime time;

    /**
     * Constructor
     * <p>
     * Sets all values.
     *
     * @param localDate Represents a date.
     * @param localTime Represents a time.
     */
    DateTime(LocalDate localDate,
             LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    /**
     * Constructor
     * <p>
     * Sets all values.
     *
     * @param year         Represents a year.
     * @param month        Represents a month.
     * @param day          Represents a day.
     * @param hour24Format Represents an hour.
     * @param minute       Represents a minute
     * @param second       Represents a second.
     * @param millisecond  Represents a millisecond.
     */
    DateTime(int year,
             int month,
             int day,
             int hour24Format,
             int minute,
             int second,
             int millisecond) {
        this.date = new LocalDate(year, month, day);
        this.time = new LocalTime(hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     * <p>
     * Sets all values from another object.
     *
     * @param dateTimeIn instance of a object extending the DateTime class, which values of this object will be set from
     */
    protected DateTime(DateTime dateTimeIn) {
        int year = dateTimeIn.getYear();
        int month = dateTimeIn.getMonth();
        int day = dateTimeIn.getDay();
        date = new LocalDate(year, month, day);

        int hour24Format = dateTimeIn.getHour();
        int minute = dateTimeIn.getMinute();
        int second = dateTimeIn.getSecond();
        int millisecond = dateTimeIn.getMillisecond();
        time = new LocalTime(hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     * <p>
     * Sets all values from String
     *
     * @param dateTimeInString This String has following format: 2016-12-31
     *                         24:45:14:453 yyyy-MM-dd HH:mm:ss:SSS
     */
    public DateTime(String dateTimeInString) {
        String[] array=dateTimeInString.split(" ");
        if(array.length!= 2){
            throw new TimeException("Wrong Date Time format: " + dateTimeInString);
        }
        date = new LocalDate(array[0]);

        time = new LocalTime(array[1]);
    }
    /**
     * Constructor
     * <p>
     * Sets all values from String
     *
     * @param dateTimeAsLong
     */
    public DateTime(long dateTimeAsLong) {
        String str = String.valueOf(dateTimeAsLong);

        if(str.length()!= 17){
            throw new TimeException("Wrong Date Time format: " + dateTimeAsLong);
        }
        String year = str.substring(0,4);
        String month = str.substring(4,6);
        String day = str.substring(6,8);
        String hour = str.substring(8,10);
        String minute = str.substring(10,12);
        String second = str.substring(12,14);
        String millisecond = str.substring(14,17);

        int yearInt = Integer.valueOf(year);
        int monthInt = Integer.valueOf(month);
        int dayInt = Integer.valueOf(day);
        int hourInt = Integer.valueOf(hour);
        int minuteInt = Integer.valueOf(minute);
        int secondInt = Integer.valueOf(second);
        int millisecondInt = Integer.valueOf(millisecond);

        date = new LocalDate(yearInt, monthInt, dayInt);

        time = new LocalTime(hourInt, minuteInt, secondInt, millisecondInt);
    }

    /**
     * @return year
     */
    public int getYear() {
        return this.date.getYear();
    }

    /**
     * @return month
     */
    public int getMonth() {
        return this.date.getMonth();
    }

    /**
     * @return day
     */
    public int getDay() {
        return this.date.getDay();
    }

    /**
     * @return hour
     */
    public int getHour() {
        return this.time.getHour();
    }

    /**
     * @return minute
     */
    public int getMinute() {
        return this.time.getMinute();
    }

    /**
     * @return second
     */
    public int getSecond() {
        return this.time.getSecond();
    }

    /**
     * @return millisecond
     */
    public int getMillisecond() {
        return this.time.getMillisecond();
    }
    /**
     * @return date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * @return time
     */
    public LocalTime getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(this.date.toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.time.toString());

        return stringBuffer.toString();
    }

    public long toLong() {
        StringBuilder sb = new StringBuilder();
        sb.append(getYear());

        if (getMonth() < 10) {
            sb.append("0");
        }
        sb.append(getMonth());

        if (getDay() < 10) {
            sb.append("0");
        }
        sb.append(getDay());

        if (getHour() < 10) {
            sb.append("0");
        }
        sb.append(getHour());

        if (getMinute() < 10) {
            sb.append("0");
        }
        sb.append(getMinute());

        if (getSecond() < 10) {
            sb.append("0");
        }
        sb.append(getSecond());

        if (getMillisecond() < 100) {
            sb.append("0");
        }
        if (getMillisecond() < 10) {
            sb.append("0");
        }
        sb.append(getMillisecond());

        return Long.valueOf(sb.toString());
    }

    public int compareTo(DateTime otherDateTime) {
        return Long.valueOf(toLong()).compareTo(Long.valueOf(otherDateTime.toLong()));
    }
}
