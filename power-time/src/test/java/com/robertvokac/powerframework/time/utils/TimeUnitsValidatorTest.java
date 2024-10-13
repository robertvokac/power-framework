
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
public class TimeUnitsValidatorTest {
//
//    /**
//
//     */
//    public TimeUnitsValidatorTest() {
//    }
//
//    /**
//     Test of isHourValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsHourValid_HourIs13_ThereShouldBeReturnedTrue() {
//        //arrange
//        int hour = 13;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isHourValid(hour);
//        //assert
//        assertTrue(returnedValue);
//    }
//
//    /**
//     Test of isHourValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsHourValid_HourIsMinus1_ThereShouldBeReturneFalse() {
//        //arrange
//        int hour = -1;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isHourValid(hour);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isHourValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsHourValid_HourIs24_ThereShouldBeReturneFalse() {
//        //arrange
//        int hour = 24;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isHourValid(hour);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isMinuteValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsMinuteValid_MinuteIs34__ThereShouldBeReturnedTrue() {
//        //arrange
//        int minute = 34;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isMinuteValid(minute);
//        //assert
//        assertTrue(returnedValue);
//    }
//
//    /**
//     Test of isMinuteValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsMinuteValid_MinuteIsMinus1_ThereShouldBeReturneFalse() {
//        //arrange
//        int minute = -1;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isMinuteValid(minute);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isMinuteValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsMinuteValid_MinuteIs60_ThereShouldBeReturneFalse() {
//        //arrange
//        int minute = 60;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isMinuteValid(minute);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isSecondValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsSecondValid_SecondIs46__ThereShouldBeReturnedTrue() {
//        //arrange
//        int second = 46;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isSecondValid(second);
//        //assert
//        assertTrue(returnedValue);
//    }
//
//    /**
//     Test of isSecondValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsSecondValid_SecondIsMinus1__ThereShouldBeReturneFalse() {
//        //arrange
//        int second = -1;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isSecondValid(second);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isSecondValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsSecondValid_SecondIs60__ThereShouldBeReturneFalse() {
//        //arrange
//        int second = 60;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isSecondValid(second);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isMillisecondValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsMillisecondValid_MillisecondIs843__ThereShouldBeReturnedTrue() {
//        //arrange
//        int millisecond = 843;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isMillisecondValid(millisecond);
//        //assert
//        assertTrue(returnedValue);
//    }
//
//    /**
//     Test of isMillisecondValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsMillisecondValid_MillisecondIsMinus1_ThereShouldBeReturneFalse() {
//        //arrange
//        int millisecond = -1;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isMillisecondValid(millisecond);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of isMillisecondValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testIsMillisecondValid_MillisecondIs1000_ThereShouldBeReturneFalse() {
//        //arrange
//        int millisecond = 1000;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.isMillisecondValid(millisecond);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of areAllTimeUnitsValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testAreAllTimeUnitsValid_ThereShouldBeReturneTrue() {
//        //arrange
//        int hour = 2;
//        int minute = 34;
//        int second = 23;
//        int millisecond = 428;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.areAllTimeUnitsValid(hour, minute, second, millisecond);
//        //assert
//        assertTrue(returnedValue);
//    }
//
//    /**
//     Test of areAllTimeUnitsValid method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testAreAllTimeUnitsValid_ThereShouldBeReturneFalse() {
//        //arrange
//        int hour = 112;
//        int minute = 134;
//        int second = 123;
//        int millisecond = 1428;
//        boolean returnedValue;
//        //act
//        returnedValue = TimeUnitsValidator.areAllTimeUnitsValid(hour, minute, second, millisecond);
//        //assert
//        assertFalse(returnedValue);
//    }
//
//    /**
//     Test of checkInputValuesForTimeAndIfThereIsAnInvalidOneThrowException
//     method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testCheckInputValuesForTimeAndIfThereIsAnInvalidOneThrowException_ThereShouldBeThrownNoPowerRuntimeException() {
//        //arrange
//        int hour = 12;
//        int minute = 34;
//        int second = 23;
//        int millisecond = 428;
//        boolean isExceptionThrown = false;
//        //act
//        try {
//            TimeUnitsValidator.validate(hour, minute, second, millisecond);
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
//     Test of checkInputValuesForTimeAndIfThereIsAnInvalidOneThrowException
//     method, of class TimeUnitsValidator.
//     */
//    @Test
//    public void testCheckInputValuesForTimeAndIfThereIsAnInvalidOneThrowException_ThereShouldBeThrownPowerRuntimeException() {
//        //arrange
//        int hour = 112;
//        int minute = 134;
//        int second = 123;
//        int millisecond = 1428;
//        boolean isExceptionThrown = false;
//        //act
//        try {
//            TimeUnitsValidator.validate(hour, minute, second, millisecond);
//        } catch (PowerException e) {
//            isExceptionThrown = true;
//        }
//        //assert
//        if(!isExceptionThrown) {
//            fail("There should be thrown PowerRuntimeException");
//        }
//    }
}
