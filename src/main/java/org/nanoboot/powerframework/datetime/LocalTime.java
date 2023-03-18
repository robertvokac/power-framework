
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
 * Represents Time without date and time zone information.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public final class LocalTime {

    private static final String COLON = ":";

    private final int hour;
    private final int minute;
    private final int second;
    private final int millisecond;

    /**
     * Constructor
     *
     * @param hour
     * @param minute
     * @param second
     * @param millisecond
     * @exception PowerRuntimeException if parameters are invalid.
     */
    public LocalTime(int hour, int minute, int second, int millisecond) {
        TimeUnitsValidator.checkInputValuesForTimeAndIfThereIsAnInvalidOneThrowException(hour, minute, second, millisecond);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
    }

    /**
     *
     * @return hour of this time.
     */
    public int getHour() {
        return hour;
    }

    /**
     *
     * @return minute of this time.
     */
    public int getMinute() {
        return minute;
    }

    /**
     *
     * @return second of this time.
     */
    public int getSecond() {
        return second;
    }

    /**
     *
     * @return millisecond of this time.
     */
    public int getMillisecond() {
        return millisecond;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (hour < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.getHour());
        stringBuilder.append(COLON);
        if (minute < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.getMinute());
        stringBuilder.append(COLON);
        if (second < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.getSecond());
        stringBuilder.append(COLON);
        if (millisecond < 10) {
            stringBuilder.append("00");
        } else if (millisecond < 100) {
            stringBuilder.append("0");
        }
        stringBuilder.append(this.getMillisecond());
        return stringBuilder.toString();
    }
}
