
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

package org.nanoboot.powerframework.time.utils;

import java.util.ArrayList;
import org.nanoboot.powerframework.core.PowerException;
import org.nanoboot.powerframework.time.moment.LocalDate;

/**
 * Validates date units.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class DateUnitsValidator extends AbstractValidator {

    private static final int MONTHLOWERBOUND = 1;
    private static final int MONTHHIGHERBOUND = 12;
    private static final int DAYLOWERBOUND = 1;
    private static final int DAYHIGHERBOUND = 31;
    private static final int MAXIMUMDAYFORFEBRUARYANDLEAPYEAR = 29;
    private static final int MAXIMUMDAYFORFEBRUARYANDNOTLEAPYEAR = 28;
    private static final ArrayList<Integer> LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31 = new ArrayList<>();

    static {
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(1);
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(3);
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(5);
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(7);
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(8);
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(10);
        LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.add(12);
    }


    /*
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
    /**
     *
     * @param year year value
     * @param month month value
     * @param day day value
     */
    public static void validate(int year,
            int month,
            int day) {
        if(!DateUnitsValidator.isMonthValid(month)) {
            throw new TimeException("Month " + month + " is not valid.");
        }
        if(!DateUnitsValidator.isDayValid(day)) {
            throw new TimeException("Day " + day + " is not valid.");
        }
        if(!DateUnitsValidator.hasDateValidCombination(year, month, day)) {
            throw new TimeException("Date has not valid combination.");

        }
    }

    /**
     * Checks if month has valid format.
     *
     * @param month 1 to 12
     *
     * @return Result of this control.
     */
    static boolean isMonthValid(int month) {
        return DateUnitsValidator.isInBound(TimeUnit.MONTH, month);
    }

    /**
     * Checks if day is not more than the highest possible one- 31.
     *
     * @param day 1 to 31
     *
     * @return Result of this control.
     */
    static boolean isDayValid(int day) {
        return DateUnitsValidator.isInBound(TimeUnit.DAY, day);
    }

    /**
     * Checks if date has valid combination.
     *
     * @param year year value
     * @param month month value
     * @param day day value
     *
     * @return true if the date combination is valid, otherwise false.
     */
    public static boolean hasDateValidCombination(int year, int month, int day) {
        return day <= getMaximumDay(year, month);
    }

    /**
     *
     * @param year year value
     * @param month month value
     *
     * @return maximum day for the given month in the given year.
     *
     * @throws PowerException if month is out of range and is invalid.
     */
    private static int getMaximumDay(int year,
            int month) {//NOSONAR
        if(!isMonthValid(month)) {
            throw new TimeException("Month is not valid.");
        }
        if(hasMonth31Days(month)) {
            return 31;
        }
        if(hasMonth30Days(month)) {
            return 30;
        }
        if(hasMonth29Days(year, month)) {
            return MAXIMUMDAYFORFEBRUARYANDLEAPYEAR;
        }
        if(hasMonth28Days(year, month)) {
            return MAXIMUMDAYFORFEBRUARYANDNOTLEAPYEAR;
        }
        throw new TimeException(year + " " + month + " " + "I am not able to find out the maximum day for the given year and  month.");

    }

    /**
     *
     * @param month month value
     *
     * @return true if the given month in the given year has 31 days, otherwise
     * false.
     */
    private static boolean hasMonth31Days(int month) {

        return LIST_OF_MONTH_HAVING_MAXIMUM_DAY_31.contains(month);
    }

    /**
     *
     * @param month month value
     *
     * @return true if the given month in the given year has 30 days, otherwise
     * false.
     */
    private static boolean hasMonth30Days(int month) {
        return (month == 4) || (month == 6) || (month == 9) || (month == 11);
    }

    /**
     *
     * @param year year value
     * @param month month value
     *
     * @return true if the given month in the given year has 29 days, otherwise
     * false.
     */
    private static boolean hasMonth29Days(int year, int month) {
        return (month == 2) && (LocalDate.isYearLeap(year));
    }

    /**
     *
     * @param year year value
     * @param month month value
     *
     * @return true if the given month in the given year has 28 days, otherwise
     * false.
     */
    private static boolean hasMonth28Days(int year, int month) {
        return (month == 2) && (!LocalDate.isYearLeap(year));
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private DateUnitsValidator() {
    }
}
