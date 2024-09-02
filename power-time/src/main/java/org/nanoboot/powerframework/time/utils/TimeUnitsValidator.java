
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

/**
 * Validates time units.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TimeUnitsValidator extends AbstractValidator {

    /**
     *
     * @param hour
     * @param minute
     * @param second
     * @param millisecond
     */
    public static void validate(int hour,
            int minute,
            int second,
            int millisecond) {
        if(!TimeUnitsValidator.isHourValid(hour)) {
            throw new TimeException("Hour is not valid.");
        }
        if(!TimeUnitsValidator.isMinuteValid(minute)) {
            throw new TimeException("Minute is not valid.");
        }
        if(!TimeUnitsValidator.isSecondValid(second)) {
            throw new TimeException("Second is not valid.");
        }
        if(!TimeUnitsValidator.isMillisecondValid(millisecond)) {
            throw new TimeException("Millisecond is not valid.");
        }
    }

    /**
     * Checks if hour has valid format.
     *
     * @param hour
     *
     * @return Result of this control.
     */
    static boolean isHourValid(int hour) {
        return isInBound(TimeUnit.HOUR, hour);
    }

    /**
     * Checks if minute has valid format.
     *
     * @param minute
     *
     * @return Result of this control.
     */
    static boolean isMinuteValid(int minute) {
        return isInBound(TimeUnit.MINUTE, minute);
    }

    /**
     * Checks if second has valid format.
     *
     * @param second
     *
     * @return Result of this control.
     */
    static boolean isSecondValid(int second) {
        return isInBound(TimeUnit.SECOND, second);
    }

    /**
     * Checks if millisecond has valid format.
     *
     * @param millisecond
     *
     * @return Result of this control.
     */
    static boolean isMillisecondValid(int millisecond) {
        return isInBound(TimeUnit.MILLISECOND, millisecond);
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private TimeUnitsValidator() {
    }
}
