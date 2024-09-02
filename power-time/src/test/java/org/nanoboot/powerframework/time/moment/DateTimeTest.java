
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
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class DateTimeTest {

    private class DateTimeImpl extends DateTime {

        public DateTimeImpl(LocalDate localDate,
                LocalTime localTime) {
            super(localDate, localTime);
        }

        public DateTimeImpl(int year,
                int month,
                int day,
                int hour24Format,
                int minute,
                int second,
                int millisecond) {
            super(year, month, day, hour24Format, minute, second, millisecond);
        }

        public DateTimeImpl(DateTime dateTime) {
            super(dateTime);
        }

        public DateTimeImpl(String dateTimeInString) {
            super(dateTimeInString);
        }
        public DateTimeImpl(long dateTimeAsLong) {
            super(dateTimeAsLong);
        }

    }

    /**
     *
     */
    public DateTimeTest() {
    }

    /**
     * Test of constructor of class DateTime. (LocalDate localDate, LocalTime
     * localTime)
     */
    @Test
    public void testDateTime_2args_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl(new LocalDate(1994, 5, 6), new LocalTime(21, 45, 6, 32));
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (LocalDate localDate, LocalTime
     * localTime)
     */
    @Test
    public void testDateTime_2args_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl(new LocalDate(1994, 15, 6), new LocalTime(21, 45, 6, 32));
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (int year, int month, int day, int
     * hour24Format, int minute, int second, int millisecond)
     */
    @Test
    public void testDateTime_7args_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (int year, int month, int day, int
     * hour24Format, int minute, int second, int millisecond)
     */
    @Test
    public void testDateTime_7args_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl(1994, 15, 6, 21, 45, 6, 32);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (DateTime dateTime)
     */
    @Test
    public void testDateTime_1argsFromAnotherObject_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl(new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32));
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (DateTime dateTime)
     */
    @Test
    public void testDateTime_1argsFromAnotherObject_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl(new DateTimeImpl(1994, 15, 6, 21, 45, 6, 32));
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (String dateTimeInString)
     */
    @Test
    public void testDateTime_1argsFromString_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl("1994-05-06 21:45:06:032");
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class DateTime. (String dateTimeInString)
     */
    @Test
    public void testDateTime_1argsFromString_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            DateTimeImpl dateTimeImpl = new DateTimeImpl("1994-15-06 21:45:06:032");
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }
    /**
     * Test of constructor of class DateTime. (String dateTimeInString)
     */
    @Test
    public void testDateTime_longConstructor() {
        String expectedResult = "19940506214506032";
        String result;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(19940506214506032l);
        result = String.valueOf(dateTimeImpl.toLong());
        //assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getYear method, of class LocalDate.
     */
    @Test
    public void testGetYear() {
        //arrange
        int expectedYear = 1994;
        int returnedYear;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedYear = dateTimeImpl.getYear();
        //assert
        assertEquals(expectedYear, returnedYear);
    }

    /**
     * Test of getYear method, of class LocalDate.
     */
    @Test
    public void testGetMonth() {
        //arrange
        int expectedMonth = 5;
        int returnedMonth;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedMonth = dateTimeImpl.getMonth();
        //assert
        assertEquals(expectedMonth, returnedMonth);
    }

    /**
     * Test of getDay method, of class LocalDate.
     */
    @Test
    public void testGetDay() {
        //arrange
        int expectedDay = 6;
        int returnedDay;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedDay = dateTimeImpl.getDay();
        //assert
        assertEquals(expectedDay, returnedDay);
    }

    /**
     * Test of getHour method, of class DateTime.
     */
    @Test
    public void testGetHour() {
        //arrange
        int expectedHour = 21;
        int returnedHour;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedHour = dateTimeImpl.getHour();
        //assert
        assertEquals(expectedHour, returnedHour);
    }

    /**
     * Test of getMinute method, of class DateTime.
     */
    @Test
    public void testGetMinute() {
        //arrange
        int expectedMinute = 45;
        int returnedMinute;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedMinute = dateTimeImpl.getMinute();
        //assert
        assertEquals(expectedMinute, returnedMinute);
    }

    /**
     * Test of getSecond method, of class DateTime.
     */
    @Test
    public void testGetSecond() {
        //arrange
        int expectedSecond = 6;
        int returnedSecond;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedSecond = dateTimeImpl.getSecond();
        //assert
        assertEquals(expectedSecond, returnedSecond);
    }

    /**
     * Test of getMillisecond method, of class DateTime.
     */
    @Test
    public void testGetMillisecond() {
        //arrange
        int expectedMillisecond = 32;
        int returnedMillisecond;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        returnedMillisecond = dateTimeImpl.getMillisecond();
        //assert
        assertEquals(expectedMillisecond, returnedMillisecond);
    }

    /**
     * Test of toString method, of class LocalDate.
     */
    @Test
    public void testToString() { //arrange
        String expectedResult = "1994-05-06 21:45:06:032";
        String result;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        result = dateTimeImpl.toString();
        //assert
        assertEquals(expectedResult, result);
    }


    /**
     * Test of toString method, of class LocalDate.
     */
    @Test
    public void testToLong() { //arrange
        String expectedResult = "19940506214506032";
        String result;
        DateTimeImpl dateTimeImpl;
        //act
        dateTimeImpl = new DateTimeImpl(1994, 5, 6, 21, 45, 6, 32);
        result = String.valueOf(dateTimeImpl.toLong());
        //assert
        assertEquals(expectedResult, result);
    }
}
