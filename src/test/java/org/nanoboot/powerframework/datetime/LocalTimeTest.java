
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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class LocalTimeTest {

    /**
     *
     */
    public LocalTimeTest() {
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, 45, 6, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_HourIsMinusOne_HourIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(-1, 45, 6, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_HourIsTwentyFour_HourIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(24, 45, 6, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_MinuteIsMinusOne_MinuteIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {

        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, -1, 6, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_MinuteIsSixty_MinuteIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, 60, 6, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_SecondIsMinusOne_SecondIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, 45, -1, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_SecondIsSixty_SecondIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, 45, 60, 32);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_MillisecondIsMinusOne_MillisecondIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, 45, 6, -1);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalTime.
     */
    @Test
    public void testDateTime_MillisecondIsOneThousand_MillisecondIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalTime localTime = new LocalTime(21, 45, 6, 1000);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getHour method, of class LocalTime.
     */
    @Test
    public void testGetHour() {
        //arrange
        int expectedHour = 9;
        int returnedHour;
        LocalTime localTime;
        //act
        localTime = new LocalTime(9, 23, 14, 354);
        returnedHour = localTime.getHour();
        //assert
        assertEquals(expectedHour, returnedHour);
    }

    /**
     * Test of getMinute method, of class LocalTime.
     */
    @Test
    public void testGetMinute() {
        //arrange
        int expectedMinute = 23;
        int returnedMinute;
        LocalTime localTime;
        //act
        localTime = new LocalTime(9, 23, 14, 354);
        returnedMinute = localTime.getMinute();
        //assert
        assertEquals(expectedMinute, returnedMinute);
    }

    /**
     * Test of getSecond method, of class LocalTime.
     */
    @Test
    public void testGetSecond() {
        //arrange
        int expectedSecond = 14;
        int returnedSecond;
        LocalTime localTime;
        //act
        localTime = new LocalTime(9, 23, 14, 354);
        returnedSecond = localTime.getSecond();
        //assert
        assertEquals(expectedSecond, returnedSecond);
    }

    /**
     * Test of getMillisecond method, of class LocalTime.
     */
    @Test
    public void testGetMillisecond() {
        //arrange
        int expectedMillisecond = 354;
        int returnedMillisecond;
        LocalTime localTime;
        //act
        localTime = new LocalTime(9, 23, 14, 354);
        returnedMillisecond = localTime.getMillisecond();
        //assert
        assertEquals(expectedMillisecond, returnedMillisecond);
    }

    /**
     * Test of toString method, of class DateTime.
     */
    @Test
    public void testToString() {
        //arrange
        String expectedResult = "09:23:14:354";
        String result;
        LocalTime localTime;
        //act
        localTime = new LocalTime(9, 23, 14, 354);
        result = localTime.toString();
        //assert
        assertEquals(expectedResult, result);
    }
}
