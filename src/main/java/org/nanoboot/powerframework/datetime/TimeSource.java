
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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Is used to get current universal date and time.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class TimeSource {

    private static final org.nanoboot.powerframework.datetime.TimeZone universalTimeZone = new org.nanoboot.powerframework.datetime.TimeZone("GMT");

    private static final DateFormat yearFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "yyyy");
    private static final DateFormat monthFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "MM");
    private static final DateFormat dayFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "dd");
    private static final DateFormat hourFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "HH");
    private static final DateFormat minuteFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "mm");
    private static final DateFormat secondFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "ss");
    private static final DateFormat millisecondFormat = new DateTime.SimpleDateTimeFormatByTimeZone(universalTimeZone, "S");

    /**
     * Represents source for current universal date time.
     */
    private Calendar calendar;
    private final UniversalDateTime universalDateTime;

    /**
     * Constructor
     *
     * Every time, you want know the current time, you have to create new
     * instance of TimeSource class.
     */
    private TimeSource() {
        this.universalDateTime = this.buildCurrentUniversalDateTime();
    }

    /**
     *
     * @return current universal date time
     */
    public static UniversalDateTime getCurrentUniversalDateTimeInstance() {
        TimeSource timeSource = new TimeSource();
        return timeSource.getCurrentUniversalDateTime();
    }

    /**
     *
     * @return Date instance for current universal date and time
     */
    private UniversalDateTime buildCurrentUniversalDateTime() {
        Date currentDate = getCurrentDate();
        int year = Integer.parseInt(yearFormat.format(currentDate));
        int month = Integer.parseInt(monthFormat.format(currentDate));
        int day = Integer.parseInt(dayFormat.format(currentDate));

        int hour = Integer.parseInt(hourFormat.format(currentDate));
        int minute = Integer.parseInt(minuteFormat.format(currentDate));
        int second = Integer.parseInt(secondFormat.format(currentDate));
        int millisecond = Integer.parseInt(millisecondFormat.format(currentDate));
        return new UniversalDateTime(year, month, day, hour, minute, second, millisecond);
    }

    /**
     *
     * @return a new instance of Date class for current universal date and time
     */
    private Date getCurrentDate() {
        calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar = null;
        return currentDate;
    }

    /**
     *
     * @return current universal date time
     */
    UniversalDateTime getCurrentUniversalDateTime() {
        return this.universalDateTime;
    }
}
