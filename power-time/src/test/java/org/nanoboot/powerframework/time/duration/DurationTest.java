
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

package org.nanoboot.powerframework.time.duration;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class DurationTest {
//
//    /**
//
//     */
//    public DurationTest() {
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_5Args_ThereShouldBeThrownNoPowerRuntimeException() {
//        //arrange
//        boolean isExceptionThrown = false;
//        //act
//        try {
//            Duration duration = new Duration(23, 5, 3, 43, 97);
//        } catch (PowerException e) {
//            isExceptionThrown = true;
//        }
//        //assert
//        if(isExceptionThrown) {
//            fail("There should be thrown no PowerRuntimeException");
//        }
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_5Args_ThereShouldBeThrownPowerRuntimeException() {
//        //arrange
//        boolean isExceptionThrown = false;
//        //act
//        try {
//            Duration duration = new Duration(23, 5, 3, 143, 97);
//        } catch (PowerException e) {
//            isExceptionThrown = true;
//        }
//        //assert
//        if(!isExceptionThrown) {
//            fail("There should be thrown PowerRuntimeException");
//        }
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_5Args_ThereShouldBeReturnedIsPositive() {
//        //arrange
//        boolean expectedValue = true;
//        boolean returnedValue;
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        //act
//        returnedValue = duration.isPositive();
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_6Args_ThereShouldBeReturnedIsPositive() {
//        //arrange
//        boolean expectedValue = true;
//        boolean returnedValue;
//        Duration duration = new Duration(true, 23, 5, 3, 43, 97);
//        //act
//        returnedValue = duration.isPositive();
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_6Args_ThereShouldBeReturnedIsNotPositive() {
//        //arrange
//        boolean expectedValue = false;
//        boolean returnedValue;
//        Duration duration = new Duration(false, 23, 5, 3, 43, 97);
//        //act
//        returnedValue = duration.isPositive();
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_StringArg() {
//        //arrange
//        String argString = "+00023:05:03:43:097";
//        String expectedString = "+23:5:3:43:97";
//        String returnedString;
//
//        Duration duration = new Duration(argString);
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of constructor, of class Duration.
//     */
//    @Test
//    public void TestDuration_StringArg_ThereShouldBeThrownPowerRuntimeException() {
//        //arrange
//        boolean isExceptionThrown = false;
//        //act
//        try {
//            String argString = "+23:5:60:43:97";
//            Duration duration = new Duration(argString);
//        } catch (PowerException e) {
//            isExceptionThrown = true;
//        }
//        //assert
//        if(!isExceptionThrown) {
//            fail("There should be thrown PowerRuntimeException");
//        }
//    }
//
//    /**
//     Test of between method, of class Duration.
//     */
//    @Test
//    public void testBetween1_UniversalDateTime_UniversalDateTime() {
//        //arrange
//        UniversalDateTime startUniversalDateTime = new UniversalDateTime(1949, 8, 6, 4, 23, 7, 654);
//        UniversalDateTime endUniversalDateTime = new UniversalDateTime(2007, 4, 21, 9, 17, 58, 954);
//        String expectedString = "+21077:4:54:51:300";
//        String returnedString;
//        //act
//        returnedString = Duration.between(startUniversalDateTime, endUniversalDateTime).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of between method, of class Duration.
//     */
//    @Test
//    public void testBetween2_UniversalDateTime_UniversalDateTime() {
//        //arrange
//        UniversalDateTime startUniversalDateTime = new UniversalDateTime(2007, 4, 21, 9, 17, 58, 954);
//        UniversalDateTime endUniversalDateTime = new UniversalDateTime(1949, 8, 6, 4, 23, 7, 654);
//        String expectedString = "-21077:4:54:51:300";
//        String returnedString;
//        //act
//        returnedString = Duration.between(startUniversalDateTime, endUniversalDateTime).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of between method, of class Duration.
//     */
//    @Test
//    public void testBetween1_ZonedDateTime_ZonedDateTime() {
//        //arrange
//        LocalDateTime localDateTime = new LocalDateTime(2016, 10, 29, 11, 19, 34, 276);
//        ZonedDateTime startZonedDateTime = new ZonedDateTime(localDateTime, new TimeZone("Europe/Prague"));
//        ZonedDateTime endZonedDateTime = new ZonedDateTime(localDateTime, new TimeZone("Australia/Sydney"));
//        String expectedString = "-0:9:0:0:0";
//        String returnedString;
//        //act
//        returnedString = Duration.between(startZonedDateTime, endZonedDateTime).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of between method, of class Duration.
//     */
//    @Test
//    public void testBetween2_ZonedDateTime_ZonedDateTime() {
//        //arrange
//        LocalDateTime localDateTime = new LocalDateTime(2016, 10, 29, 11, 19, 34, 276);
//        ZonedDateTime startZonedDateTime = new ZonedDateTime(localDateTime, new TimeZone("Australia/Sydney"));
//        ZonedDateTime endZonedDateTime = new ZonedDateTime(localDateTime, new TimeZone("Europe/Prague"));
//        String expectedString = "+0:9:0:0:0";
//        String returnedString;
//        //act
//        returnedString = Duration.between(startZonedDateTime, endZonedDateTime).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of ofDays method, of class Duration.
//     */
//    @Test
//    public void testOfDays() {
//        //arrange
//        int days = 13;
//
//        Duration duration = Duration.ofDays(days);
//        String expectedString = "+13:0:0:0:0";
//        String returnedString;
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of ofHours method, of class Duration.
//     */
//    @Test
//    public void testOfHours() {
//        //arrange
//        int hours = 17;
//
//        Duration duration = Duration.ofHours(hours);
//        String expectedString = "+0:17:0:0:0";
//        String returnedString;
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of ofMinutes method, of class Duration.
//     */
//    @Test
//    public void testOfMinutes() {
//        //arrange
//        int minutes = 42;
//
//        Duration duration = Duration.ofMinutes(minutes);
//        String expectedString = "+0:0:42:0:0";
//        String returnedString;
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of ofSeconds method, of class Duration.
//     */
//    @Test
//    public void testOfSeconds() {
//        //arrange
//        int seconds = 9;
//
//        Duration duration = Duration.ofSeconds(seconds);
//        String expectedString = "+0:0:0:9:0";
//        String returnedString;
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of ofMilliseconds method, of class Duration.
//     */
//    @Test
//    public void testOfMilliseconds() {
//        //arrange
//        int milliseconds = 4;
//
//        Duration duration = Duration.ofMilliseconds(milliseconds);
//        String expectedString = "+0:0:0:0:4";
//        String returnedString;
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of fromUniversalDateTimePlusDurationCreateNewUniversalDateTime
//     method, of class Duration.
//     */
//    @Test
//    public void testFromUniversalDateTimePlusDurationCreateNewUniversalDateTime() {
//        //arrange
//        UniversalDateTime universalDateTime = new UniversalDateTime(2007, 4, 21, 9, 17, 58, 954);
//        Duration duration = Duration.ofHours(7);
//        String expectedString = "2007-04-21 16:17:58:954";
//        String returnedString;
//        //act
//        returnedString = Duration.fromUniversalDateTimePlusDurationCreateNewUniversalDateTime(universalDateTime, duration).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of fromUniversalDateTimeMinusDurationCreateNewUniversalDateTime
//     method, of class Duration.
//     */
//    @Test
//    public void testFromUniversalDateTimeMinusDurationCreateNewUniversalDateTime() {
//        //arrange
//        UniversalDateTime universalDateTime = new UniversalDateTime(2007, 4, 21, 9, 17, 58, 954);
//        Duration duration = Duration.ofHours(7);
//        String expectedString = "2007-04-21 02:17:58:954";
//        String returnedString;
//        //act
//        returnedString = Duration.fromUniversalDateTimeMinusDurationCreateNewUniversalDateTime(universalDateTime, duration).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of fromZonedDateTimePlusDurationCreateNewZonedDateTime method, of
//     class Duration.
//     */
//    @Test
//    public void testFromZonedDateTimePlusDurationCreateNewZonedDateTime() {
//        //arrange
//        LocalDateTime localDateTime = new LocalDateTime(2007, 4, 21, 9, 17, 58, 954);
//        TimeZone timeZone = new TimeZone("Australia/Sydney");
//        ZonedDateTime zonedDateTime = new ZonedDateTime(localDateTime, timeZone);
//        Duration duration = Duration.ofHours(7);
//        String expectedString = "2007-04-21 16:17:58:954";
//        String returnedString;
//        //act
//        returnedString = Duration.fromZonedDateTimePlusDurationCreateNewZonedDateTime(zonedDateTime, duration).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of fromZonedDateTimeMinusDurationCreateNewZonedDateTime method, of
//     class Duration.
//     */
//    @Test
//    public void testFromZonedDateTimeMinusDurationCreateNewZonedDateTime() {
//        //arrange
//        LocalDateTime localDateTime = new LocalDateTime(2007, 4, 21, 9, 17, 58, 954);
//        TimeZone timeZone = new TimeZone("Australia/Sydney");
//        ZonedDateTime zonedDateTime = new ZonedDateTime(localDateTime, timeZone);
//        Duration duration = Duration.ofHours(7);
//        String expectedString = "2007-04-21 02:17:58:954";
//        String returnedString;
//        //act
//        returnedString = Duration.fromZonedDateTimeMinusDurationCreateNewZonedDateTime(zonedDateTime, duration).toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of getDays method, of class Duration.
//     */
//    @Test
//    public void testGetDays() {
//        //arrange
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        long expectedDays = 23;
//        long returnedDays;
//        //act
//        returnedDays = duration.getDays();
//        //assert
//        assertEquals(expectedDays, returnedDays);
//    }
//
//    /**
//     Test of getHours method, of class Duration.
//     */
//    @Test
//    public void testGetHours() {
//        //arrange
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        int expectedHours = 5;
//        int returnedHours;
//        //act
//        returnedHours = duration.getHours();
//        //assert
//        assertEquals(expectedHours, returnedHours);
//    }
//
//    /**
//     Test of getMinutes method, of class Duration.
//     */
//    @Test
//    public void testGetMinutes() {
//        //arrange
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        int expectedMinutes = 3;
//        int returnedMinutes;
//        //act
//        returnedMinutes = duration.getMinutes();
//        //assert
//        assertEquals(expectedMinutes, returnedMinutes);
//    }
//
//    /**
//     Test of getSeconds method, of class Duration.
//     */
//    @Test
//    public void testGetSeconds() {
//        //arrange
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        int expectedSeconds = 43;
//        int returnedSeconds;
//        //act
//        returnedSeconds = duration.getSeconds();
//        //assert
//        assertEquals(expectedSeconds, returnedSeconds);
//    }
//
//    /**
//     Test of getMilliseconds method, of class Duration.
//     */
//    @Test
//    public void testGetMilliseconds() {
//        //arrange
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        int expectedMilliseconds = 97;
//        int returnedMilliseconds;
//        //act
//        returnedMilliseconds = duration.getMilliseconds();
//        //assert
//        assertEquals(expectedMilliseconds, returnedMilliseconds);
//    }
//
//    /**
//     Test of isPositive method, of class Duration.
//     */
//    @Test
//    public void testIsPositive() {
//        //arrange
//        Duration duration = new Duration(false, 23, 5, 3, 43, 97);
//        boolean expectedValue = false;
//        boolean returnedValue;
//        //act
//        returnedValue = duration.isPositive();
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of negated method, of class Duration.
//     */
//    @Test
//    public void testNegated() {
//        //arrange
//        Duration duration = new Duration(23, 5, 3, 43, 97);
//        Duration negatedDuration;
//
//        boolean expectedValue = false;
//        boolean returnedValue;
//        //act
//        negatedDuration = duration.negated();
//        returnedValue = negatedDuration.isPositive();
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of abs method, of class Duration.
//     */
//    @Test
//    public void testAbs() {
//        //arrange
//        Duration duration = new Duration(false, 23, 5, 3, 43, 97);
//        Duration absDuration;
//
//        boolean expectedValue = true;
//        boolean returnedValue;
//        //act
//        absDuration = duration.abs();
//        returnedValue = absDuration.isPositive();
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of plusDuration method, of class Duration.
//     */
//    @Test
//    public void testPlusDuration() {
//        //arrange
//        Duration duration = new Duration(12, 0, 0, 0, 0);
//        Duration durationToAdd = new Duration(0, 5, 4, 2, 7);
//        Duration returnedDuration;
//        String expectedString = "+12:5:4:2:7";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.plusDuration(durationToAdd);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of plusDays method, of class Duration.
//     */
//    @Test
//    public void testPlusDays() {
//        //arrange
//        Duration duration = new Duration(12, 0, 0, 0, 0);
//        long daysToAdd = 1;
//        Duration returnedDuration;
//        String expectedString = "+13:0:0:0:0";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.plusDays(daysToAdd);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of plusHours method, of class Duration.
//     */
//    @Test
//    public void testPlusHours() {
//        //arrange
//        Duration duration = new Duration(12, 0, 0, 0, 0);
//        int hoursToAdd = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:1:0:0:0";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.plusHours(hoursToAdd);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of plusMinutes method, of class Duration.
//     */
//    @Test
//    public void testPlusMinutes() {
//        //arrange
//        Duration duration = new Duration(12, 0, 0, 0, 0);
//        int minutesToAdd = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:0:1:0:0";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.plusMinutes(minutesToAdd);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of plusSeconds method, of class Duration.
//     */
//    @Test
//    public void testPlusSeconds() {
//        //arrange
//        Duration duration = new Duration(12, 0, 0, 0, 0);
//        int secondsToAdd = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:0:0:1:0";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.plusSeconds(secondsToAdd);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of plusMilliseconds method, of class Duration.
//     */
//    @Test
//    public void testPlusMilliseconds() {
//        //arrange
//        Duration duration = new Duration(12, 0, 0, 0, 0);
//        int millisecondsToAdd = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:0:0:0:1";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.plusMilliseconds(millisecondsToAdd);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of minusDuration method, of class Duration.
//     */
//    @Test
//    public void testMinusDuration() {
//        //arrange
//        Duration duration = new Duration(12, 5, 4, 2, 7);
//        Duration durationToSubtract = new Duration(0, 5, 4, 2, 7);
//        Duration returnedDuration;
//        String expectedString = "+12:0:0:0:0";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.minusDuration(durationToSubtract);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of minusDays method, of class Duration.
//     */
//    @Test
//    public void testMinusDays() {
//        //arrange
//        Duration duration = new Duration(12, 5, 4, 2, 7);
//        long daysToSubtract = 1;
//        Duration returnedDuration;
//        String expectedString = "+11:5:4:2:7";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.minusDays(daysToSubtract);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of minusHours method, of class Duration.
//     */
//    @Test
//    public void testMinusHours() {
//        //arrange
//        Duration duration = new Duration(12, 5, 4, 2, 7);
//        int hoursToSubtract = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:4:4:2:7";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.minusHours(hoursToSubtract);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of minusMinutes method, of class Duration.
//     */
//    @Test
//    public void testMinusMinutes() {
//        //arrange
//        Duration duration = new Duration(12, 5, 4, 2, 7);
//        int minutesToSubtract = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:5:3:2:7";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.minusMinutes(minutesToSubtract);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of minusSeconds method, of class Duration.
//     */
//    @Test
//    public void testMinusSeconds() {
//        //arrange
//        Duration duration = new Duration(12, 5, 4, 2, 7);
//        int secondsToSubtract = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:5:4:1:7";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.minusSeconds(secondsToSubtract);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of minusMilliseconds method, of class Duration.
//     */
//    @Test
//    public void testMinusMilliseconds() {
//        //arrange
//        Duration duration = new Duration(12, 5, 4, 2, 7);
//        int millisecondsToSubtract = 1;
//        Duration returnedDuration;
//        String expectedString = "+12:5:4:2:6";
//        String returnedString;
//
//        //act
//        returnedDuration = duration.minusMilliseconds(millisecondsToSubtract);
//        returnedString = returnedDuration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of toTotalDays method, of class Duration.
//     */
//    @Test
//    public void testToTotalDays() {
//        //arrange
//        Duration duration = new Duration(14, 9, 17, 53, 834);
//        long expectedValue = 14;
//        long returnedValue;
//        //act
//        returnedValue = (long) Math.floor(duration.toTotalDays());
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of toTotalHours method, of class Duration.
//     */
//    @Test
//    public void testToTotalHours() {
//        //arrange
//        Duration duration = new Duration(14, 9, 17, 53, 834);
//        long expectedValue = 345;
//        long returnedValue;
//        //act
//        returnedValue = (long) Math.floor(duration.toTotalHours());
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of toTotalMinutes method, of class Duration.
//     */
//    @Test
//    public void testToTotalMinutes() {
//        //arrange
//        Duration duration = new Duration(14, 9, 17, 53, 834);
//        long expectedValue = 20717;
//        long returnedValue;
//        //act
//        returnedValue = (long) Math.floor(duration.toTotalMinutes());
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of toTotalSeconds method, of class Duration.
//     */
//    @Test
//    public void testToTotalSeconds() {
//        //arrange
//        Duration duration = new Duration(14, 9, 17, 53, 834);
//        long expectedValue = 1243073;
//        long returnedValue;
//        //act
//        returnedValue = (long) Math.floor(duration.toTotalSeconds());
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of toTotalMilliseconds method, of class Duration.
//     */
//    @Test
//    public void testToTotalMilliseconds() {
//        //arrange
//        Duration duration = new Duration(14, 9, 17, 53, 834);
//        long expectedValue = 1243073834;
//        long returnedValue;
//        //act
//        returnedValue = (long) Math.floor(duration.toTotalMilliseconds());
//        //assert
//        assertEquals(expectedValue, returnedValue);
//    }
//
//    /**
//     Test of toJavaDuration method, of class Duration.
//     */
//    @Test
//    public void testToJavaDuration() {
//        //arrange
//        Duration duration = new Duration(14, 9, 17, 53, 834);
//        long expectedTotalSeconds = (long) Math.floor(duration.toTotalSeconds());
//        long returnedSeconds;
//        java.time.Duration javaDuration;
//        //act
//        javaDuration = duration.toJavaDuration();
//        returnedSeconds = javaDuration.getSeconds();
//        //assert
//        assertEquals(expectedTotalSeconds, returnedSeconds);
//    }
//
//    /**
//     Test of toString method, of class Duration.
//     */
//    @Test
//    public void testToString1_ConstructorWithLongArgUsed() {
//        //arrange
//        String expectedString = "+23:5:3:43:97";
//        String returnedString;
//        long countOfTotalMilliseconds = 2005423097;
//
//        Duration duration = new Duration(countOfTotalMilliseconds);
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of toString method, of class Duration.
//     */
//    @Test
//    public void testToString2_ConstructorWithLongArgUsed() {
//        //arrange
//        String expectedString = "-23:5:3:43:97";
//        String returnedString;
//        long countOfTotalMilliseconds = -2005423097;
//
//        Duration duration = new Duration(countOfTotalMilliseconds);
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
//
//    /**
//     Test of toString method, of class Duration.
//     */
//    @Test
//    public void testToString3_ConstructorWithLongArgUsed() {
//        //arrange
//        String expectedString = "+0:0:0:0:0";
//        String returnedString;
//        long countOfTotalMilliseconds = 0;
//
//        Duration duration = new Duration(countOfTotalMilliseconds);
//        //act
//        returnedString = duration.toString();
//        //assert
//        assertEquals(expectedString, returnedString);
//    }
}
