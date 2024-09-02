
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

package org.nanoboot.powerframework.time.moment;

import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.time.TimeSource;
import org.nanoboot.powerframework.time.utils.DateUnitsValidator;
import org.nanoboot.powerframework.time.duration.Duration;
import org.nanoboot.powerframework.time.duration.Period;

/**
 * This class stores universal date time.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class UniversalDateTime extends DateTime {

    static UniversalDateTime addUniversalTimeZoneInformation(
            LocalDateTime localDateTime) {
        return new UniversalDateTime(localDateTime);
    }

    /**
     *
     * @return current universal date time
     */
    public static UniversalDateTime now() {
        return TimeSource.getCurrentUniversalDateTimeInstance();
    }

    /**
     *
     * @return random universal date time
     */
    public static UniversalDateTime random() {
        UniversalDateTime universalDateTime;
        int maxPossibleYear = UniversalDateTime.now().getYear();
        RandomGenerator randomGenerator = RandomGenerator.getDefaultImplStatic();
        int randomYear = randomGenerator.nextInt(1900, maxPossibleYear);
        int randomMonth = randomGenerator.nextInt(1, 12);
        int randomDay = randomGenerator.nextInt(1, 31);
        int randomHour = randomGenerator.nextInt(0, 23);
        int randomMinute = randomGenerator.nextInt(0, 59);
        int randomSecond = randomGenerator.nextInt(0, 59);
        int randomMillisecond = randomGenerator.nextInt(0, 999);
        if(!DateUnitsValidator.hasDateValidCombination(randomYear, randomMonth, randomDay)) {
            randomDay -= randomGenerator.nextInt(3, 20);
        }
        universalDateTime = new UniversalDateTime(randomYear, randomMonth, randomDay, randomHour, randomMinute, randomSecond, randomMillisecond);
        return universalDateTime;
    }

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
    public UniversalDateTime(int year,
            int month,
            int day,
            int hour24Format,
            int minute,
            int second,
            int millisecond) {
        super(year, month, day, hour24Format, minute, second, millisecond);
    }

    /**
     * Constructor
     *
     * Creates new UniversalDateTime from ZonedDateTime.
     *
     * @param zonedDateTime
     */
    private UniversalDateTime(ZonedDateTime zonedDateTime) {
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
     * Constructor
     *
     * Creates new UniversalDateTime from long.
     *
     * @param udtAsLong
     */
    public UniversalDateTime(long udtAsLong) {
        super(udtAsLong);
    }

    UniversalDateTime updateDateAndTimeToUniversalTimeZone(
            ZonedDateTime zonedDateTime) {
        return new UniversalDateTime(zonedDateTime);
    }

    /**
     *
     * @param duration
     *
     * @return
     */
    public UniversalDateTime plusDuration(Duration duration) {
        return new Period(this, duration).getEndUniversalDateTime();
    }

    /**
     *
     * @return
     */
    public ZonedDateTime convertToZonedDateTimeWithUniversalTimeZone() {
        return ZonedDateTime.updateDateAndTimeToUniversalDateTime(this);
    }

    /**
     *
     * @return
     */
    public LocalDateTime removeUniversalTimeZone() {
        return LocalDateTime.removeUniversalTimeZone(this);
    }

}
