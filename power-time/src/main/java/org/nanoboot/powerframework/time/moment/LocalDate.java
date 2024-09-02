
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

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
package org.nanoboot.powerframework.time.moment;

import org.nanoboot.powerframework.core.PowerException;
import org.nanoboot.powerframework.time.utils.DateUnitsValidator;
import org.nanoboot.powerframework.time.utils.TimeException;
import org.nanoboot.powerframework.utils.StringUtils;

/**
 * Represents Date without time zone information.
 *
 * @author Robert Vokáč e-mail: robertvokac@nanoboot.org
 */
public final class LocalDate  {

    private static final String DASH = "-";
    public static final int LOCAL_DATE_AS_STRING_LENGTH = 10;

    /**
     *
     * @param s with format yyyy-MM-dd
     */
    public LocalDate(String s) {
        if (s == null) {
            throw new TimeException("Local date as string is null.");
        }
        if (s.length() != LOCAL_DATE_AS_STRING_LENGTH) {
            throw new TimeException("Local date length is " + s.length() + ", but length 10 is expected.");
        }
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(5, 7));
        int day = Integer.parseInt(s.substring(8, 10));

        DateUnitsValidator.validate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Checks if year is leap. A year is leap if this year is divided by 4 and
     * there remainder 0. In other words this year is divisible by 4.
     *
     * @param year value
     *
     * @return true if the year is leap, otherwise false.
     */
    public static boolean isYearLeap(int year) {
        return (year % 4) == 0;
    }

 

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructor
     *
     * @param year Year of this date.
     * @param month Month of this date.
     * @param day Day of this date.
     *
     * @throws PowerException if parameters are invalid or have wrong
     * combination.
     */
    public LocalDate(int year, int month, int day) {
        DateUnitsValidator.validate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     *
     * @return year of this date.
     */
    public int getYear() {
        return this.year;
    }

    /**
     *
     * @return month of this date.
     */
    public int getMonth() {
        return this.month;
    }

    /**
     *
     * @return day of this date.
     */
    public int getDay() {
        return this.day;
    }

    @Override
    public String toString() {
        return StringUtils.appendObjects(getYear(), DASH, month < 10 ? "0" : "", getMonth(), DASH, day < 10 ? "0" : "", getDay());
    }

 
}
