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
package org.nanoboot.powerframework.time.duration;

import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.time.utils.TimeException;
import org.nanoboot.powerframework.time.utils.TimeUnit;
import org.nanoboot.powerframework.time.utils.TimeUnitConvertor;
import org.nanoboot.powerframework.time.utils.TimeUnitsValidator;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import org.nanoboot.powerframework.time.moment.ZonedDateTime;
import org.nanoboot.powerframework.utils.StringUtils;

/**
 * Is used to do arithmetics with Date and Time.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class Duration {

    private static final Duration zeroDuration = new Duration(0);

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String COLON = ":";
    private static final String DOT = ".";

    /**
     *
     * @return Duration instance
     */
    public static Duration getZeroDuration() {
        return zeroDuration;
    }

    /**
     *
     * @return random duration
     */
    public static Duration createRandomDuration() {
        Duration duration;
        RandomGenerator pseudoRandomNumberGenerator = RandomGenerator.getDefaultImplStatic();
        long days = pseudoRandomNumberGenerator.nextInt(0, 6000);
        int hours = pseudoRandomNumberGenerator.nextInt(0, 23);
        int minutes = pseudoRandomNumberGenerator.nextInt(0, 59);
        int seconds = pseudoRandomNumberGenerator.nextInt(0, 59);
        int milliseconds = pseudoRandomNumberGenerator.nextInt(0, 999);
        duration = new Duration(days, hours, minutes, seconds, milliseconds);
        return duration;
    }

    /**
     *
     * @param value value of count of the unit
     * @param timeUnit TimeUnit instance
     *
     * @return an instance of Duration class with the given count of days
     */
    public static Duration of(long value, TimeUnit timeUnit) {
        return new Duration(convertToMilliseconds(value, timeUnit));
    }

    /**
     * Converts the value (timeUnit) to count of milliseconds.
     *
     * @param value value of count of the unit
     * @param timeUnit TimeUnit instance for the value
     *
     * @return count of milliseconds of the count of the timeUnits
     */
    private static long convertToMilliseconds(long value, TimeUnit timeUnit) {
        return value * getMillisecondsPerTimeUnit(timeUnit);
    }

    /**
     *
     * @param timeUnit TimeUnit instance
     *
     * @return count of milliseconds of one timeUnit
     */
    private static int getMillisecondsPerTimeUnit(TimeUnit timeUnit) {
        return (int) TimeUnitConvertor.convert(1, timeUnit, TimeUnit.MILLISECOND);

    }

    /**
     *
     * @param universalDateTime UniversalDateTime instance
     * @param duration Duration instance to add to the time
     *
     * @return add to universalDateTime duration and return result
     */
    public static UniversalDateTime fromUniversalDateTimePlusDurationCreateNewUniversalDateTime(UniversalDateTime universalDateTime, Duration duration) {
        return addToUniversalDateTimeDuration(universalDateTime, duration, true);
    }

    /**
     *
     * @param universalDateTime UniversalDateTime instance
     * @param duration Duration instance to remove from the time
     *
     * @return subtract from universalDateTime duration and return result
     */
    public static UniversalDateTime fromUniversalDateTimeMinusDurationCreateNewUniversalDateTime(
            UniversalDateTime universalDateTime,
            Duration duration) {
        return addToUniversalDateTimeDuration(universalDateTime, duration, false);
    }

    private static UniversalDateTime addToUniversalDateTimeDuration(
            UniversalDateTime universalDateTime,
            Duration duration,
            boolean trueForAddingFalseForSubtracting) {
        java.time.LocalDateTime javaLocalDateTime = universalDateTime.removeUniversalTimeZone().toJavaLocalDateTime();
        java.time.Duration javaDuration = duration.toJavaDuration();
        java.time.LocalDateTime newJavaLocalDateTime;
        if (trueForAddingFalseForSubtracting) {
            newJavaLocalDateTime = javaLocalDateTime.plus(javaDuration);
        } else {
            newJavaLocalDateTime = javaLocalDateTime.minus(javaDuration);
        }

        int year = newJavaLocalDateTime.getYear();
        int day = newJavaLocalDateTime.getDayOfMonth();
        int month = newJavaLocalDateTime.getMonth().getValue();
        int hour = newJavaLocalDateTime.getHour();
        int minute = newJavaLocalDateTime.getMinute();
        int second = newJavaLocalDateTime.getSecond();
        final int nanosecondspermillisecond;
        nanosecondspermillisecond = 1000000;
        int millisecond = newJavaLocalDateTime.getNano() / nanosecondspermillisecond;

        return new UniversalDateTime(year, month, day, hour, minute, second, millisecond);
    }

    /**
     *
     * @param zonedDateTime ZonedDateTime instance
     * @param duration Duration instance to add to the time
     *
     * @return add to zonedDateTime duration and return result
     */
    public static ZonedDateTime fromZonedDateTimePlusDurationCreateNewZonedDateTime(ZonedDateTime zonedDateTime, Duration duration) {
        return addToZonedDateTimeDuration(zonedDateTime, duration, true);
    }

    /**
     *
     * @param zonedDateTime ZonedDateTime instance
     * @param duration Duration instance to remove from the time
     *
     * @return subtract from zonedDateTime duration and return result
     */
    public static ZonedDateTime fromZonedDateTimeMinusDurationCreateNewZonedDateTime(
            ZonedDateTime zonedDateTime,
            Duration duration) {
        return addToZonedDateTimeDuration(zonedDateTime, duration, false);
    }

    private static ZonedDateTime addToZonedDateTimeDuration(
            ZonedDateTime zonedDateTime,
            Duration duration,
            boolean trueForAddingFalseForSubtracting) {
        UniversalDateTime universalDateTime = zonedDateTime.toUniversalDateTime();
        UniversalDateTime newUniversalDateTime;
        if (trueForAddingFalseForSubtracting) {
            newUniversalDateTime = fromUniversalDateTimePlusDurationCreateNewUniversalDateTime(universalDateTime, duration);
        } else {
            newUniversalDateTime = fromUniversalDateTimeMinusDurationCreateNewUniversalDateTime(universalDateTime, duration);
        }

        return newUniversalDateTime.convertToZonedDateTimeWithUniversalTimeZone().toZonedDateTime(zonedDateTime.getTimeZone());
    }

    private final long countOfTotalMilliseconds;
    private final int days;
    private final int hours;
    private final int minutes;
    private final int seconds;
    private final int milliseconds;
    private final boolean positive;

    /**
     * Constructor
     *
     * Creates new Duration with duration 0 milliseconds.
     *
     */
    public Duration() {
        this(0);
    }

    /**
     * Constructor
     *
     * Creates new Duration from count of milliseconds.
     *
     * @param countOfMilliseconds milliseconds representing the new Duration
     */
    public Duration(long countOfMilliseconds) {

        positive = countOfMilliseconds >= 0;

        this.countOfTotalMilliseconds = Math.abs(countOfMilliseconds);
        this.days = (int) Math.floor(this.toTotal(TimeUnit.DAY));
        this.hours = (int) Math.floor(this.toTotal(TimeUnit.HOUR) - TimeUnitConvertor.convert(days, TimeUnit.DAY, TimeUnit.HOUR));
        this.minutes = (int) (Math.floor(this.toTotal(TimeUnit.MINUTE)) - TimeUnitConvertor.convert(days, TimeUnit.DAY, TimeUnit.MINUTE) - TimeUnitConvertor.convert(hours, TimeUnit.HOUR, TimeUnit.MINUTE));
        this.seconds = (int) Math.floor(this.toTotal(TimeUnit.SECOND) - TimeUnitConvertor.convert(days, TimeUnit.DAY, TimeUnit.SECOND) - TimeUnitConvertor.convert(hours, TimeUnit.HOUR, TimeUnit.SECOND) - TimeUnitConvertor.convert(minutes, TimeUnit.MINUTE, TimeUnit.SECOND));
        this.milliseconds = (int) (this.toTotal(TimeUnit.MILLISECOND) - TimeUnitConvertor.convert(days, TimeUnit.DAY, TimeUnit.MILLISECOND) - TimeUnitConvertor.convert(hours, TimeUnit.HOUR, TimeUnit.MILLISECOND) - TimeUnitConvertor.convert(minutes, TimeUnit.MINUTE, TimeUnit.MILLISECOND) - TimeUnitConvertor.convert(seconds, TimeUnit.SECOND, TimeUnit.MILLISECOND));

    }

    /**
     * Constructor
     *
     * Creates new Duration from the given values.
     *
     * @param days value
     * @param hours value
     * @param minutes value
     * @param seconds value
     * @param milliseconds value
     */
    public Duration(long days, int hours, int minutes, int seconds, int milliseconds) {
        this(true, days, hours, minutes, seconds, milliseconds);
    }

    /**
     * Constructor
     *
     * Creates new Duration from the given values.
     *
     * @param positive true, if this duration is greater than 0, otherwise false
     * @param days value
     * @param hours value
     * @param minutes value
     * @param seconds value
     * @param milliseconds value
     */
    public Duration(boolean positive, long days, int hours, int minutes, int seconds, int milliseconds) {
        this(
                (positive ? 1 : (-1))
                * (convertToMilliseconds(days, TimeUnit.DAY)
                + convertToMilliseconds(hours, TimeUnit.HOUR)
                + convertToMilliseconds(minutes, TimeUnit.MINUTE)
                + convertToMilliseconds(seconds, TimeUnit.SECOND)
                + milliseconds)
        );
        TimeUnitsValidator.validate(hours, minutes, seconds, milliseconds);
    }

    /**
     * Constructor
     *
     * Creates new Duration from the String.
     *
     * @param string representing the new Duration
     */
    public Duration(String string) {
        String[] splitString = string.replace("\\.", ":").split("\\:+");
        if (splitString.length != 5) {
            throw new TimeException("Input String has wrong format.");
        }
        try {
            this.days = Integer.parseInt(splitString[0]);
            this.hours = Integer.parseInt(splitString[1]);
            this.minutes = Integer.parseInt(splitString[2]);
            this.seconds = Integer.parseInt(splitString[3]);
            this.milliseconds = Integer.parseInt(splitString[4]);
            this.countOfTotalMilliseconds = convertToMilliseconds(days, TimeUnit.DAY)
                    + convertToMilliseconds(hours, TimeUnit.HOUR)
                    + convertToMilliseconds(minutes, TimeUnit.MINUTE)
                    + convertToMilliseconds(seconds, TimeUnit.SECOND)
                    + milliseconds;
            this.positive = string.charAt(0) != '-';
        } catch (NumberFormatException e) {//NOSONAR
            throw new TimeException("Input String has wrong format.");
        }
        TimeUnitsValidator.validate(hours, minutes, seconds, milliseconds);
    }

    /**
     *
     * @param timeUnit TimeUnit instance
     *
     * @return value
     */
    public long get(TimeUnit timeUnit) {
        switch (timeUnit) {
            case DAY:
                return this.days;
            case HOUR:
                return this.hours;
            case MINUTE:
                return this.minutes;
            case SECOND:
                return this.seconds;
            case MILLISECOND:
                return this.milliseconds;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     *
     * @return result of this control
     */
    public boolean isPositive() {
        return this.positive;
    }

    /**
     *
     * @return new Duration instance created from negated this object
     */
    public Duration negated() {
        return new Duration((int) this.toTotal(TimeUnit.MILLISECOND) * (-1));
    }

    /**
     *
     * @return new Duration instance created from this object, if this object is
     * negative, returned Duration is not negative
     */
    public Duration abs() {
        long absCountOfTotalMilliseconds;
        absCountOfTotalMilliseconds = this.countOfTotalMilliseconds >= 0 ? countOfTotalMilliseconds : (countOfTotalMilliseconds * (-1));
        return new Duration(absCountOfTotalMilliseconds);
    }

    /**
     *
     * @param durationToAdd Duration instance to add
     *
     * @return new Duration by adding the two Duration instance together
     */
    public Duration plus(Duration durationToAdd) {
        return plus((long) durationToAdd.toTotal(TimeUnit.MILLISECOND), TimeUnit.MILLISECOND);
    }

    /**
     *
     * @param value value
     * @param timeUnit TimeUnit instance
     *
     * @return new Duration instance
     */
    public Duration plus(long value, TimeUnit timeUnit) {
        return new Duration((int) this.toTotal(TimeUnit.MILLISECOND) + convertToMilliseconds(value, timeUnit));
    }

    /**
     *
     * @param durationToSubtract Duration instance
     *
     * @return from this object plus the given durationToAdd new Duration
     */
    public Duration minus(Duration durationToSubtract) {
        //TODO A bug is probably here.
        return minus((long) durationToSubtract.toTotal(TimeUnit.MILLISECOND), TimeUnit.MILLISECOND);
    }

    /**
     *
     * @param value value
     * @param timeUnit TimeUnit instance
     *
     * @return new Duration instance
     */
    public Duration minus(long value,
            TimeUnit timeUnit) {
        return new Duration((int) this.toTotal(TimeUnit.MILLISECOND) - convertToMilliseconds(value, timeUnit));
    }

    /**
     *
     * @param timeUnit DAY,HOUR,MINUTE,SECOND, MILLISECOND
     *
     * @return number of the timeUnit representing this duration
     */
    public double toTotal(TimeUnit timeUnit) {
        int divisor = 0;
        divisor = getMillisecondsPerTimeUnit(timeUnit);
        return countOfTotalMilliseconds / divisor;

    }

    /**
     *
     * @return java.time.duration representation of this object
     */
    java.time.Duration toJavaDuration() {
        java.time.Duration javaDuration = java.time.Duration.ofMillis((int) this.toTotal(TimeUnit.MILLISECOND));
        return this.isPositive() ? javaDuration : javaDuration.negated();
    }

    @Override
    public String toString() {
        return StringUtils.appendObjects(this.isPositive() ? PLUS : MINUS,
                String.format("%02d", get(TimeUnit.DAY)),
                COLON,
                String.format("%02d", get(TimeUnit.HOUR)),
                COLON,
                String.format("%02d", get(TimeUnit.MINUTE)),
                COLON,
                String.format("%02d", get(TimeUnit.SECOND)),
                DOT,
                String.format("%03d", get(TimeUnit.MILLISECOND)));
    }

    public String toHumanString() {
        long days = get(TimeUnit.DAY);
        long hours = get(TimeUnit.HOUR);
        long minutes = get(TimeUnit.MINUTE);
        long seconds = get(TimeUnit.SECOND);
        long milliseconds = get(TimeUnit.MILLISECOND);
        StringBuilder sb = new StringBuilder();
        if (!this.isPositive()) {
            sb.append(MINUS).append(" ");
        }
            if (days > 0) {
                sb.append(days).append(" ").append(TimeUnit.DAY.name().toLowerCase()).append((days > 1) ? "s" : "").append(" ");
            }
            if (hours > 0) {
                sb.append(hours).append(" ").append(TimeUnit.HOUR.name().toLowerCase()).append((hours > 1) ? "s" : "").append(" ");
            }
            if (minutes > 0) {
                sb.append(minutes).append(" ").append(TimeUnit.MINUTE.name().toLowerCase()).append((minutes > 1) ? "s" : "").append(" ");
            }
            sb.append(seconds).append(" ").append(TimeUnit.SECOND.name().toLowerCase()).append((seconds > 1) ? "s" : "");
            return sb.toString();
        }
    }
