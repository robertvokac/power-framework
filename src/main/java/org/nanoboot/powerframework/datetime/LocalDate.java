
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

import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Represents Date without time zone information.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public final class LocalDate {

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructor
     *
     * @param year Year of this date.
     * @param month Month of this date.
     * @param day Day of this date.
     * @exception PowerRuntimeException if parameters are invalid or have wrong
     * combination.
     */
    public LocalDate(int year, int month, int day) {
        LocalDate.checkInputValuesForDateAndIfThereIsAnInvalidOneThrowException(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Checks input data for date.
     *
     * @param year
     * @param month
     * @param day
     * @exception PowerRuntimeException if input data for date are invalid or
     * have wrong combination.<br />
     * This will throw PowerRuntimeException:
     * {@code new LocalDateTime(2015,2,29)}<br />
     * This will throw PowerRuntimeException:
     * {@code new LocalDateTime(2013,6,31)}<br />
     * This will not throw PowerRuntimeException:
     * {@code new LocalDateTime(2013,6,30)}<br />
     */
    private static void checkInputValuesForDateAndIfThereIsAnInvalidOneThrowException(int year, int month, int day) {
        if (!DateUnitsValidator.isMonthValid(month)) {
            throw new PowerRuntimeException("Month is not valid.");
        }
        if (!DateUnitsValidator.isDayValid(day)) {
            throw new PowerRuntimeException("Day is not valid.");
        }
        if (!DateUnitsValidator.hasDateValidCombination(year, month, day)) {
            throw new PowerRuntimeException("Date has not valid combination.");
            
        }
    }

    /**
     * Checks if year is leap. A year is leap if this year is divided by 4 and
     * there remainder 0. In other words this year is divisible by 4.
     *
     * @param year
     * @return true if the year is leap, otherwise false.
     */
    public static boolean isYearLeap(int year) {
        return (year % 4) == 0;
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
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.getYear());
        stringBuilder.append("-");
        if (month < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.getMonth());
        stringBuilder.append("-");
        if (day < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.getDay());
        return stringBuilder.toString();
    }
}
