
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

import org.nanoboot.powerframework.pseudorandom.PseudoRandomGenerator;

/**
 * This class stores universal date time.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public final class UniversalDateTime extends DateTime {

    /**
     * Constructor
     *
     * Creates new UniversalDateTime from String.
     *
     * @param stringRepresentationOfNewlyCreatedObject
     */
    public UniversalDateTime(String stringRepresentationOfNewlyCreatedObject) {
        super(stringRepresentationOfNewlyCreatedObject);
    }

    /**
     * Constructor
     *
     * Creates new UniversalDateTime with these parameters.
     *
     * @param year
     * @param month
     * @param day
     * @param hour24Format
     * @param minute
     * @param second
     * @param millisecond
     */
    public UniversalDateTime(int year, int month, int day, int hour24Format, int minute, int second, int millisecond) {
        super(year, month, day, hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     *
     * Creates new UniversalDateTime from ZonedDateTime.
     *
     * @param zonedDateTime
     */
    public UniversalDateTime(ZonedDateTime zonedDateTime) {
        super(zonedDateTime.toUniversalDateTime());
    }

    /**
     * Constructor
     *
     * Creates new UniversalDateTime from LocalDateTime.
     *
     * @param localDateTime
     */
    public UniversalDateTime(LocalDateTime localDateTime) {
        super(localDateTime);
    }

    /**
     *
     * @return current universal date time
     */
    public static UniversalDateTime getCurrentUniversalDateTime() {
        return TimeSource.getCurrentUniversalDateTimeInstance();
    }

    /**
     *
     * @return random universal date time
     */
    public static UniversalDateTime getRandomUniversalDateTime() {
        UniversalDateTime universalDateTime;

        int maxPossibleYear = UniversalDateTime.getCurrentUniversalDateTime().getYear();

        int randomYear = PseudoRandomGenerator.getInstance().getInt(1900, maxPossibleYear);
        int randomMonth = PseudoRandomGenerator.getInstance().getInt(1, 12);
        int randomDay = PseudoRandomGenerator.getInstance().getInt(1, 31);

        int randomHour = PseudoRandomGenerator.getInstance().getInt(0, 23);
        int randomMinute = PseudoRandomGenerator.getInstance().getInt(0, 59);
        int randomSecond = PseudoRandomGenerator.getInstance().getInt(0, 59);
        int randomMillisecond = PseudoRandomGenerator.getInstance().getInt(0, 999);

        if (!DateUnitsValidator.hasDateValidCombination(randomYear, randomMonth, randomDay)) {
            randomDay = randomDay - PseudoRandomGenerator.getInstance().getInt(3, 20);
        }

        universalDateTime = new UniversalDateTime(randomYear, randomMonth, randomDay, randomHour, randomMinute, randomSecond, randomMillisecond);

        return universalDateTime;
    }

    /**
     * @return a ZonedDateTime instance from this object
     */
    public ZonedDateTime toZonedDateTime() {
        return new ZonedDateTime(this);
    }

    /**
     * @return a LocalDateTime instance from this object without universal date
     * time information.
     */
    public LocalDateTime toLocalDateTime() {
        return new LocalDateTime(this);
    }
}
