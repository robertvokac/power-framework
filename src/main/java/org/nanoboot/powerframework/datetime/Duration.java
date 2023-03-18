
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
import org.nanoboot.powerframework.pseudorandom.PseudoRandomGenerator;

/**
 * Is used to do arithmetics with Date and Time.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class Duration {

    private static final int MILLISECONDSPERSECOND = 1000;
    private static final int SECONDSPERMINUTE = 60;
    private static final int MILLISECONDSPERMINUTE = MILLISECONDSPERSECOND * SECONDSPERMINUTE;
    private static final int MINUTESPERHOUR = 60;
    private static final int MILLISECONDSPERHOUR = MILLISECONDSPERMINUTE * MINUTESPERHOUR;
    private static final int HOURSPERDAY = 24;
    private static final int MILLISECONDSPERDAY = MILLISECONDSPERHOUR * HOURSPERDAY;
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String COLON = ":";

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
     * Creates new Duration from count of milliseconds.
     *
     * @param countOfMilliseconds
     */
    public Duration(long countOfMilliseconds) {
        if (countOfMilliseconds >= 0) {
            positive = true;
        } else {
            positive = false;
        }
        this.countOfTotalMilliseconds = Math.abs(countOfMilliseconds);

        this.days = (int) Math.floor(this.toTotalDays());
        this.hours = (int) Math.floor(this.toTotalHours()) - (days * HOURSPERDAY);
        this.minutes = (int) Math.floor(this.toTotalMinutes()) - (days * HOURSPERDAY * MINUTESPERHOUR) - (hours * MINUTESPERHOUR);
        this.seconds = (int) Math.floor(this.toTotalSeconds()) - (days * HOURSPERDAY * MINUTESPERHOUR * SECONDSPERMINUTE) - (hours * MINUTESPERHOUR * SECONDSPERMINUTE) - (minutes * SECONDSPERMINUTE);
        this.milliseconds = (int) this.toTotalMilliseconds() - (days * HOURSPERDAY * MINUTESPERHOUR * SECONDSPERMINUTE * MILLISECONDSPERSECOND) - (hours * MINUTESPERHOUR * SECONDSPERMINUTE * MILLISECONDSPERSECOND) - (minutes * SECONDSPERMINUTE * MILLISECONDSPERSECOND) - (seconds * MILLISECONDSPERSECOND);

    }

    /**
     * Constructor
     *
     * Creates new Duration from the given values.
     *
     * @param days
     * @param hours
     * @param minutes
     * @param seconds
     * @param milliseconds
     */
    public Duration(long days, int hours, int minutes, int seconds, int milliseconds) {
        this(
                true, days, hours, minutes, seconds, milliseconds
        );
    }

    /**
     * Constructor
     *
     * Creates new Duration from the given values.
     *
     * @param positive
     * @param days
     * @param hours
     * @param minutes
     * @param seconds
     * @param milliseconds
     */
    public Duration(boolean positive, long days, int hours, int minutes, int seconds, int milliseconds) {
        this(
                (positive ? 1 : (-1))
                * (convertDaysToMilliseconds(days)
                + convertHoursToMilliseconds(hours)
                + convertMinutesToMilliseconds(minutes)
                + convertSecondsToMilliseconds(seconds)
                + milliseconds)
        );
        TimeUnitsValidator.checkInputValuesForTimeAndIfThereIsAnInvalidOneThrowException(hours, minutes, seconds, milliseconds);
    }

    /**
     * Constructor
     *
     * Creates new Duration from the String.
     *
     * @param string
     */
    public Duration(String string) {
        String[] splitString = string.split("\\:+");
        if (splitString.length != 5) {
            throw new PowerRuntimeException("Input String has wrong format.");
        }
        try {
            this.days = Integer.parseInt(splitString[0]);
            this.hours = Integer.parseInt(splitString[1]);
            this.minutes = Integer.parseInt(splitString[2]);
            this.seconds = Integer.parseInt(splitString[3]);
            this.milliseconds = Integer.parseInt(splitString[4]);
            this.countOfTotalMilliseconds = convertDaysToMilliseconds(days)
                    + convertHoursToMilliseconds(hours)
                    + convertMinutesToMilliseconds(minutes)
                    + convertSecondsToMilliseconds(seconds)
                    + milliseconds;
            this.positive = string.charAt(0) == '+';
        } catch (Exception e) {//NOSONAR
            throw new PowerRuntimeException("Input String has wrong format.");
        }
        TimeUnitsValidator.checkInputValuesForTimeAndIfThereIsAnInvalidOneThrowException(hours, minutes, seconds, milliseconds);
    }

    /**
     *
     * @return random duration
     */
    public static Duration createRandomDuration() {
        Duration duration;
        PseudoRandomGenerator pseudoRandomNumberGenerator = PseudoRandomGenerator.getInstance();
        long days = pseudoRandomNumberGenerator.getInt(0, 6000);
        int hours = pseudoRandomNumberGenerator.getInt(0, 23);
        int minutes = pseudoRandomNumberGenerator.getInt(0, 59);
        int seconds = pseudoRandomNumberGenerator.getInt(0, 59);
        int milliseconds = pseudoRandomNumberGenerator.getInt(0, 999);
        duration = new Duration(days, hours, minutes, seconds, milliseconds);
        return duration;
    }

    /**
     * Creates new Duration from startUniversalDateTime minus
     * endUniversalDateTime.
     *
     * @param startUniversalDateTime
     * @param endUniversalDateTime
     * @return new instance of Duration
     */
    public static Duration between(UniversalDateTime startUniversalDateTime, UniversalDateTime endUniversalDateTime) {
        java.time.LocalDateTime javaStartLocalDateTime = startUniversalDateTime.toLocalDateTime().toJavaLocalDateTime();
        java.time.LocalDateTime javaEndLocalDateTime = endUniversalDateTime.toLocalDateTime().toJavaLocalDateTime();
        java.time.Duration javaDuration = java.time.Duration.between(javaStartLocalDateTime, javaEndLocalDateTime);
        return new Duration(javaDuration.toMillis());

    }

    /**
     * Creates new Duration from startZonedDateTime minus endZonedDateTime.
     *
     * @param startZonedDateTime
     * @param endZonedDateTime
     * @return new instance of Duration
     */
    public static Duration between(ZonedDateTime startZonedDateTime, ZonedDateTime endZonedDateTime) {
        return between(startZonedDateTime.toUniversalDateTime(), endZonedDateTime.toUniversalDateTime());
    }

    private static int getMillisecondsPerDay() {
        return MILLISECONDSPERDAY;
    }

    private static long convertDaysToMilliseconds(long days) {
        return days * getMillisecondsPerDay();
    }

    /**
     *
     * @param days
     * @return an instance of Duration class with the given count of days
     */
    public static Duration ofDays(long days) {
        return new Duration(convertDaysToMilliseconds(days));
    }

    private static int getMillisecondsPerHour() {
        return MILLISECONDSPERHOUR;
    }

    private static long convertHoursToMilliseconds(long hours) {
        return hours * getMillisecondsPerHour();
    }

    /**
     *
     * @param hours
     * @return an instance of Duration class with the given count of hours
     */
    public static Duration ofHours(long hours) {
        return new Duration(convertHoursToMilliseconds(hours));
    }

    private static int getMillisecondsPerMinute() {
        return MILLISECONDSPERMINUTE;
    }

    private static long convertMinutesToMilliseconds(long minutes) {
        return minutes * getMillisecondsPerMinute();
    }

    /**
     *
     * @param minutes
     * @return an instance of Duration class with the given count of minutes
     */
    public static Duration ofMinutes(long minutes) {
        return new Duration(convertMinutesToMilliseconds(minutes));
    }

    private static int getMillisecondsPerSecond() {
        return MILLISECONDSPERSECOND;
    }

    private static long convertSecondsToMilliseconds(long seconds) {
        return seconds * getMillisecondsPerSecond();
    }

    /**
     *
     * @param seconds
     * @return an instance of Duration class with the given count of seconds
     */
    public static Duration ofSeconds(long seconds) {
        return new Duration(convertSecondsToMilliseconds(seconds));
    }

    /**
     *
     * @param milliseconds
     * @return an instance of Duration class with the given count of
     * milliseconds
     */
    public static Duration ofMilliseconds(long milliseconds) {
        return new Duration(milliseconds);
    }

    /**
     *
     * @param universalDateTime
     * @param duration
     * @return add to universalDateTime duration and return result
     */
    public static UniversalDateTime fromUniversalDateTimePlusDurationCreateNewUniversalDateTime(UniversalDateTime universalDateTime, Duration duration) {
        return addToUniversalDateTimeDuration(universalDateTime, duration, true);
    }

    /**
     *
     * @param universalDateTime
     * @param duration
     * @return subtract from universalDateTime duration and return result
     */
    public static UniversalDateTime fromUniversalDateTimeMinusDurationCreateNewUniversalDateTime(UniversalDateTime universalDateTime, Duration duration) {
        return addToUniversalDateTimeDuration(universalDateTime, duration, false);
    }

    private static UniversalDateTime addToUniversalDateTimeDuration(UniversalDateTime universalDateTime, Duration duration, boolean trueForAddingFalseForSubtracting) {
        java.time.LocalDateTime javaLocalDateTime = universalDateTime.toLocalDateTime().toJavaLocalDateTime();
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
     * @param zonedDateTime
     * @param duration
     * @return add to zonedDateTime duration and return result
     */
    public static ZonedDateTime fromZonedDateTimePlusDurationCreateNewZonedDateTime(ZonedDateTime zonedDateTime, Duration duration) {
        return addToZonedDateTimeDuration(zonedDateTime, duration, true);
    }

    /**
     *
     * @param zonedDateTime
     * @param duration
     * @return subtract from zonedDateTime duration and return result
     */
    public static ZonedDateTime fromZonedDateTimeMinusDurationCreateNewZonedDateTime(ZonedDateTime zonedDateTime, Duration duration) {
        return addToZonedDateTimeDuration(zonedDateTime, duration, false);
    }

    private static ZonedDateTime addToZonedDateTimeDuration(ZonedDateTime zonedDateTime, Duration duration, boolean trueForAddingFalseForSubtracting) {
        UniversalDateTime universalDateTime = zonedDateTime.toUniversalDateTime();
        UniversalDateTime newUniversalDateTime;
        if (trueForAddingFalseForSubtracting) {
            newUniversalDateTime = fromUniversalDateTimePlusDurationCreateNewUniversalDateTime(universalDateTime, duration);
        } else {
            newUniversalDateTime = fromUniversalDateTimeMinusDurationCreateNewUniversalDateTime(universalDateTime, duration);
        }

        return new ZonedDateTime(newUniversalDateTime).toZonedDateTime(zonedDateTime.getTimeZone());
    }

    /**
     *
     * @return count of days
     *
     * <br><br>Example<br>
     * <br>
     * Duration duration=new Duration(6,19,46,12,754);<br>
     * long days=duration.getDays();<br>
     * <br>
     * days is 6
     */
    public long getDays() {
        return days;
    }

    /**
     *
     * @return count of hours
     *
     * <br><br>Example<br>
     * <br>
     * Duration duration=new Duration(6,19,46,12,754);<br>
     * long hours=duration.getHours();<br>
     * <br>
     * hours is 19
     */
    public int getHours() {
        return hours;
    }

    /**
     *
     * @return count of minutes
     *
     * <br><br>Example<br>
     * <br>
     * Duration duration=new Duration(6,19,46,12,754);<br>
     * long minutes=duration.getMinutes();<br>
     * <br>
     * minutes is 46
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     *
     * @return count of seconds
     *
     * <br><br>Example<br>
     * <br>
     * Duration duration=new Duration(6,19,46,12,754);<br>
     * long seconds=duration.getSeconds();<br>
     * <br>
     * seconds is 12
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     *
     * @return count of milliseconds
     *
     * <br><br>Example<br>
     * <br>
     * Duration duration=new Duration(6,19,46,12,754);<br>
     * long milliseconds=duration.Milliseconds();<br>
     * <br>
     * milliseconds is 754
     */
    public int getMilliseconds() {
        return milliseconds;
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
        return new Duration(this.toTotalMilliseconds() * (-1));
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
     * @param durationToAdd
     * @return from this object plus the given durationToAdd new Duration
     */
    public Duration plusDuration(Duration durationToAdd) {
        return new Duration(this.toTotalMilliseconds() + durationToAdd.toTotalMilliseconds());
    }

    /**
     *
     * @param daysToAdd
     * @return from this object plus the given daysToAdd new Duration
     */
    public Duration plusDays(long daysToAdd) {
        return this.plusMilliseconds(Duration.convertDaysToMilliseconds(daysToAdd));
    }

    /**
     *
     * @param hoursToAdd
     * @return from this object plus the given hoursToAdd new Duration
     */
    public Duration plusHours(long hoursToAdd) {
        return this.plusMilliseconds(Duration.convertHoursToMilliseconds(hoursToAdd));
    }

    /**
     *
     * @param minutesToAdd
     * @return from this object plus the given minutesToAdd new Duration
     */
    public Duration plusMinutes(long minutesToAdd) {
        return this.plusMilliseconds(Duration.convertMinutesToMilliseconds(minutesToAdd));
    }

    /**
     *
     * @param secondsToAdd
     * @return from this object plus the given secondsToAdd new Duration
     */
    public Duration plusSeconds(long secondsToAdd) {
        return this.plusMilliseconds(Duration.convertSecondsToMilliseconds(secondsToAdd));
    }

    /**
     *
     * @param millisecondsToAdd
     * @return from this object plus the given millisecondsToAdd new Duration
     */
    public Duration plusMilliseconds(long millisecondsToAdd) {
        return new Duration(this.toTotalMilliseconds() + millisecondsToAdd);
    }

    /**
     *
     * @param durationToSubtract
     * @return from this object minus the given durationToSubtract new Duration
     */
    public Duration minusDuration(Duration durationToSubtract) {
        return new Duration(this.toTotalMilliseconds() - durationToSubtract.toTotalMilliseconds());
    }

    /**
     *
     * @param daysToSubtract
     * @return from this object minus the given daysToSubtract new Duration
     */
    public Duration minusDays(long daysToSubtract) {
        return this.minusMilliseconds(Duration.convertDaysToMilliseconds(daysToSubtract));
    }

    /**
     *
     * @param hoursToSubtract
     * @return from this object minus the given hoursToSubtract new Duration
     */
    public Duration minusHours(long hoursToSubtract) {
        return this.minusMilliseconds(Duration.convertHoursToMilliseconds(hoursToSubtract));
    }

    /**
     *
     * @param minutesToSubtract
     * @return from this object minus the given minutesToSubtract new Duration
     */
    public Duration minusMinutes(long minutesToSubtract) {
        return this.minusMilliseconds(Duration.convertMinutesToMilliseconds(minutesToSubtract));
    }

    /**
     *
     * @param secondsToSubtract
     * @return from this object minus the given secondsToSubtract new Duration
     */
    public Duration minusSeconds(long secondsToSubtract) {
        return this.minusMilliseconds(Duration.convertSecondsToMilliseconds(secondsToSubtract));
    }

    /**
     *
     * @param millisecondsToSubtract
     * @return from this object minus the given millisecondsToSubtract new
     * Duration
     */
    public Duration minusMilliseconds(long millisecondsToSubtract) {
        return new Duration(this.toTotalMilliseconds() - millisecondsToSubtract);
    }

    /**
     *
     * @return representation of this object in days
     */
    public double toTotalDays() {
        return countOfTotalMilliseconds / getMillisecondsPerDay();
    }

    /**
     *
     * @return representation of this object in hours
     */
    public double toTotalHours() {
        return countOfTotalMilliseconds / getMillisecondsPerHour();
    }

    /**
     *
     * @return representation of this object in minutes
     */
    public double toTotalMinutes() {
        return countOfTotalMilliseconds / getMillisecondsPerMinute();
    }

    /**
     *
     * @return representation of this object in seconds
     */
    public double toTotalSeconds() {
        return countOfTotalMilliseconds / getMillisecondsPerSecond();
    }

    /**
     *
     * @return representation of this object in milliseconds
     */
    public long toTotalMilliseconds() {
        return countOfTotalMilliseconds;
    }

    /**
     *
     * @return java.time.duration representation of this object
     */
    java.time.Duration toJavaDuration() {
        java.time.Duration javaDuration = java.time.Duration.ofMillis(this.toTotalMilliseconds());
        if (!this.isPositive()) {
            javaDuration.negated();
        }
        return javaDuration;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        if (this.isPositive()) {
            stringBuilder.append(PLUS);
        } else {
            stringBuilder.append(MINUS);
        }
        stringBuilder.append(this.getDays());
        stringBuilder.append(COLON);
        stringBuilder.append(this.getHours());
        stringBuilder.append(COLON);
        stringBuilder.append(this.getMinutes());
        stringBuilder.append(COLON);
        stringBuilder.append(this.getSeconds());
        stringBuilder.append(COLON);
        stringBuilder.append(this.getMilliseconds());
        return stringBuilder.toString();

    }
}
