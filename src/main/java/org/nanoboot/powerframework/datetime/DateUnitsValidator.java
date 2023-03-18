
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

import java.util.ArrayList;
import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Validates date units.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class DateUnitsValidator {

    private static final int MONTHLOWERBOUND = 1;
    private static final int MONTHHIGHERBOUND = 12;
    private static final int DAYLOWERBOUND = 1;
    private static final int DAYHIGHERBOUND = 31;
    private static final int MAXIMUMDAYFORFEBRUARYANDLEAPYEAR = 29;
    private static final int MAXIMUMDAYFORFEBRUARYANDNOTLEAPYEAR = 28;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private DateUnitsValidator() {
    }

    /**
     * Checks if month has valid format.
     *
     * @param month
     * @return Result of this control.
     */
    static boolean isMonthValid(int month) {
        return (month >= MONTHLOWERBOUND) && (month <= MONTHHIGHERBOUND);
    }

    /**
     * Checks if day is not more than the highest possible one- 31.
     *
     * @param day
     * @return Result of this control.
     */
    static boolean isDayValid(int day) {
        return (day >= DAYLOWERBOUND) && (day <= DAYHIGHERBOUND);
    }

    /**
     * Checks if date has valid combination.
     *
     * @param year
     * @param month
     * @param day
     *
     * @return true if the date combination is valid, otherwise false.
     */
    static boolean hasDateValidCombination(int year, int month, int day) {
        return day <= getMaximumDay(year, month);
    }

    /**
     *
     * @param year
     * @param month
     * @return maximum day for the given month in the given year.
     * @exception PowerRuntimeException if month is out of range and is invalid.
     */
    private static int getMaximumDay(int year, int month) {//NOSONAR
        if (!isMonthValid(month)) {
            throw new PowerRuntimeException("Month is not valid.");
        }
        if (hasMonth31Days(month)) {
            return 31;
        }
        if (hasMonth30Days(month)) {
            return 30;
        }
        if (hasMonth29Days(year, month)) {
            return MAXIMUMDAYFORFEBRUARYANDLEAPYEAR;
        }
        if (hasMonth28Days(year, month)) {
            return MAXIMUMDAYFORFEBRUARYANDNOTLEAPYEAR;
        }
        throw new PowerRuntimeException(year + " " + month + " " + "I am not able to find out the maximum day for the given year and  month.");

    }

    /**
     *
     * @param month
     * @return true if the given month in the given year has 31 days, otherwise
     * false.
     */
    private static boolean hasMonth31Days(int month) {
        ArrayList<Integer> monthWithMaximumDay31 = new ArrayList<>();
        monthWithMaximumDay31.add(1);
        monthWithMaximumDay31.add(3);
        monthWithMaximumDay31.add(5);
        monthWithMaximumDay31.add(7);
        monthWithMaximumDay31.add(8);
        monthWithMaximumDay31.add(10);
        monthWithMaximumDay31.add(12);
        return monthWithMaximumDay31.contains(month);
    }

    /**
     *
     * @param month
     * @return true if the given month in the given year has 30 days, otherwise
     * false.
     */
    private static boolean hasMonth30Days(int month) {
        return (month == 4) || (month == 6) || (month == 9) || (month == 11);
    }

    /**
     *
     * @param year
     * @param month
     * @return true if the given month in the given year has 29 days, otherwise
     * false.
     */
    private static boolean hasMonth29Days(int year, int month) {
        return (month == 2) && (LocalDate.isYearLeap(year));
    }

    /**
     *
     * @param year
     * @param month
     * @return true if the given month in the given year has 28 days, otherwise
     * false.
     */
    private static boolean hasMonth28Days(int year, int month) {
        return (month == 2) && (!LocalDate.isYearLeap(year));
    }

}
