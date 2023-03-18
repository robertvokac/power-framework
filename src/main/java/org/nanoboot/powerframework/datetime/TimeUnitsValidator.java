
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
 * Validates time units.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class TimeUnitsValidator {

    private static final int HOURLOWERBOUND = 0;
    private static final int HOURHIGHERBOUND = 23;
    private static final int MINUTEORSECONDLOWERBOUND = 0;
    private static final int MINUTEORSECONDHIGHERBOUND = 59;
    private static final int MILLISECONDLOWERBOUND = 0;
    private static final int MILLISECONDHIGHERBOUND = 999;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private TimeUnitsValidator() {
    }

    /**
     * Checks if hour has valid format.
     *
     * @param hour
     * @return Result of this control.
     */
    static boolean isHourValid(int hour) {
        return (hour >= HOURLOWERBOUND) && (hour <= HOURHIGHERBOUND);
    }

    /**
     * Checks if minuteOrSecond has valid format.
     *
     * @param minuteOrSecond
     * @return Result of this control.
     */
    private static boolean isMinuteOrSecondValid(int minuteOrSecond) {
        return (minuteOrSecond >= MINUTEORSECONDLOWERBOUND) && (minuteOrSecond <= MINUTEORSECONDHIGHERBOUND);
    }

    /**
     * Checks if minute has valid format.
     *
     * @param minute
     * @return Result of this control.
     */
    static boolean isMinuteValid(int minute) {
        return isMinuteOrSecondValid(minute);
    }

    /**
     * Checks if second has valid format.
     *
     * @param second
     * @return Result of this control.
     */
    static boolean isSecondValid(int second) {
        return isMinuteOrSecondValid(second);
    }

    /**
     * Checks if millisecond has valid format.
     *
     * @param millisecond
     * @return Result of this control.
     */
    static boolean isMillisecondValid(int millisecond) {
        return (millisecond >= MILLISECONDLOWERBOUND) && (millisecond <= MILLISECONDHIGHERBOUND);
    }

    /**
     * Checks if all the given time values are valid.
     *
     * @param hour
     * @param minute
     * @param second
     * @param millisecond
     * * @return Result of this control.
     */
    static boolean areAllTimeUnitsValid(int hour, int minute, int second, int millisecond) {
        return isHourValid(hour)
                && (isMinuteValid(minute))
                && (isSecondValid(second))
                && (isMillisecondValid(millisecond));
    }

    static void checkInputValuesForTimeAndIfThereIsAnInvalidOneThrowException(int hour, int minute, int second, int millisecond) {
        if (!areAllTimeUnitsValid(hour, minute, second, millisecond)) {
            throw new PowerRuntimeException("One or more values of time units have invalid format.");
        }
    }
}
