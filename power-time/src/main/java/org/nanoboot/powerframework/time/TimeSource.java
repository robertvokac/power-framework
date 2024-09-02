
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

package org.nanoboot.powerframework.time;

import java.text.*;
import java.util.*;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import org.nanoboot.powerframework.time.moment.TimeZone;

/**
 * Is used to get current universal date and time.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TimeSource {

    private static final TimeZone universalTimeZone = new TimeZone("GMT");

    private static final DateFormat yearFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "yyyy");
    private static final DateFormat monthFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "MM");
    private static final DateFormat dayFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "dd");
    private static final DateFormat hourFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "HH");
    private static final DateFormat minuteFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "mm");
    private static final DateFormat secondFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "ss");
    private static final DateFormat millisecondFormat = new SimpleDateTimeFormatByTimeZone(universalTimeZone, "S");

    /**
     *
     * @return current universal date time
     */
    public static UniversalDateTime getCurrentUniversalDateTimeInstance() {
        TimeSource timeSource = new TimeSource();
        return timeSource.getCurrentUniversalDateTime();
    }

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
    private UniversalDateTime getCurrentUniversalDateTime() {
        return this.universalDateTime;
    }
}
