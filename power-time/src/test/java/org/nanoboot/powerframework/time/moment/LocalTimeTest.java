
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

import org.nanoboot.powerframework.core.PowerException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.nanoboot.powerframework.time.utils.TimeException;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }
    /**
     * Test of constructor of class LocalTime .
     */
    @Test(expected = TimeException.class)
    public void testLocalTime_stringIsLonger_ThereShouldBeThrownTimeException() {
        //arrange
        //act
        LocalTime localTime = new LocalTime("21:45:06:0037");

        //assert
    }
    /**
     * Test of constructor of class LocalTime .
     */
    @Test()
    public void testLocalTime_aTimeIsExpected() {
        //arrange
        //act
        String timeAsString = "21:45:06:037";
        LocalTime localTime = new LocalTime(timeAsString);
        assertEquals(localTime.getHour(),21);
        assertEquals(localTime.getMinute(),45);
        assertEquals(localTime.getSecond(),06);
        assertEquals(localTime.getMillisecond(),37);
        //assert
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
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
