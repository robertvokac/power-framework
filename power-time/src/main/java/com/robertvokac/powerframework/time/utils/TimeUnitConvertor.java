
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

package com.robertvokac.powerframework.time.utils;

/**
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class TimeUnitConvertor {

    private static final long DAYHASHOURS = 24;
    private static final long HOURHASMINUTES = 60;
    private static final long MINUTEHASSECONDS = 60;
    private static final long SECONDHASMILLISECONDS = 1000;

    /**
     *
     * @param timeUnitFrom DAY,HOUR,MINUTE,SECOND,MILLISECOND
     * @param timeUnitTo DAY,HOUR,MINUTE,SECOND,MILLISECOND umst be smaller than
     * timeUnitFrom
     * @param value
     *
     * @return
     */
    public static long convert(long value,
            TimeUnit timeUnitFrom,
            TimeUnit timeUnitTo) {

        if(timeUnitFrom == timeUnitTo) {
            return value;
        }

        long returnValue = value;

        TimeUnit tempTimeUnit = timeUnitFrom;

        while (true) {
            tempTimeUnit = tempTimeUnit.getSmallerUnit();
            if(tempTimeUnit != TimeUnit.DAY) {
                returnValue *= TimeUnitConvertor.timeUnitHasSmallerTimeUnits(tempTimeUnit.getBiggerUnit());
            }
            if(timeUnitTo == tempTimeUnit) {
                return returnValue;
            }

            if(timeUnitTo == TimeUnit.MILLISECOND && tempTimeUnit == timeUnitTo) {
                break;
            }

        }

        throw new TimeException("Can't convert value " + value + " " + " from unit " + timeUnitFrom + " to unit " + timeUnitTo);
    }

    private static long timeUnitHasSmallerTimeUnits(TimeUnit timeUnit) {
        switch (timeUnit) {
            case DAY:
                return DAYHASHOURS;
            case HOUR:
                return HOURHASMINUTES;
            case MINUTE:
                return MINUTEHASSECONDS;
            case SECOND:
                return SECONDHASMILLISECONDS;
        }
        throw new TimeException("Can't get smaller time units of time unit " + timeUnit.getDescription());
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private TimeUnitConvertor() {
    }
}
