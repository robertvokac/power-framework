
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

import org.nanoboot.powerframework.random.generators.RandomGenerator;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum TimeUnit {

    /**
     *
     */
    YEAR("year", 1, Integer.MIN_VALUE, Integer.MAX_VALUE),

    /**
     *
     */
    MONTH("month", 2, 1, 12),

    /**
     *
     */
    DAY("day", 3, 1, 31),

    /**
     *
     */
    HOUR("hour", 4, 0, 23),

    /**
     *
     */
    MINUTE("minute", 5, 0, 59),

    /**
     *
     */
    SECOND("second", 6, 0, 59),

    /**
     *
     */
    MILLISECOND("millisecond", 7, 0, 999);
    private final String description;
    private final int asNumber;
    private final int lowerBound;
    private final int higherBound;

    /**
     *
     * @param timeUnitFrom
     * @param timeUnitTo
     *
     * @return
     */
    public static TimeUnit getRandom(TimeUnit timeUnitFrom,
            TimeUnit timeUnitTo) {
        RandomGenerator randomGenerator = RandomGenerator.getDefaultImplStatic();
        return TimeUnit.getFromNumber(randomGenerator.nextInt(timeUnitFrom.asNumber, timeUnitTo.asNumber));
    }

    TimeUnit(String description,
            int asNumber,
            int lowerBound,
            int higherBound) {
        this.description = description;
        this.asNumber = asNumber;
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @return
     */
    public TimeUnit getSmallerUnit() {
        switch (this) {
            case YEAR:
                return MONTH;
            case MONTH:
                return DAY;
            case DAY:
                return HOUR;
            case HOUR:
                return MINUTE;
            case MINUTE:
                return SECOND;
            case SECOND:
                return MILLISECOND;
            default:
                throw new TimeException("Can't get smaller time unit.");
        }
    }

    /**
     *
     * @return
     */
    public TimeUnit getBiggerUnit() {
        switch (this) {

            case MONTH:
                return YEAR;
            case DAY:
                return MONTH;
            case HOUR:
                return DAY;
            case MINUTE:
                return HOUR;
            case SECOND:
                return MINUTE;
            case MILLISECOND:
                return SECOND;
            default:
                throw new TimeException("Can't get bigger time unit.");
        }
    }

    /**
     *
     * @param asNumber
     *
     * @return
     */
    public static TimeUnit getFromNumber(int asNumber) {
        switch (asNumber) {
            case 1:
                return YEAR;
            case 2:
                return MONTH;
            case 3:
                return DAY;
            case 4:
                return HOUR;
            case 5:
                return MINUTE;
            case 6:
                return SECOND;
            case 7:
                return MILLISECOND;
            default:
                throw new TimeException("Can't get TimeUnit from number.");
        }
    }

    /**
     *
     * @return
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     *
     * @return
     */
    public int getHigherBound() {
        return higherBound;
    }

    /**
     *
     * @return
     */
    public int getRandomValue() {
        int from = this == YEAR ? 0 : this.lowerBound;
        int to = this == YEAR ? 3000 : this.higherBound;
        return RandomGenerator.getDefaultImplStatic().nextInt(from, to);
    }

}
