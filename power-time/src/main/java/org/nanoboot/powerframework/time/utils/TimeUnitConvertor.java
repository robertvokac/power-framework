
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

package org.nanoboot.powerframework.time.utils;

/**
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
