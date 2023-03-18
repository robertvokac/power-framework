
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

package org.nanoboot.powerframework.time.moment;

import org.nanoboot.powerframework.core.PowerException;
import static org.junit.Assert.*;

import org.nanoboot.powerframework.time.utils.TimeException;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class LocalDateTest {

    /**
     *
     */
    public LocalDateTest() {
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1994, 5, 6);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test(expected = TimeException.class)
    public void testLocalDate_stringIsLonger_ThereShouldBeThrownTimeException() {
        //arrange
        //act
        LocalDate localDate = new LocalDate("1994-05-012");

        //assert
    }
    /**
     * Test of constructor of class LocalDate .
     */
    @Test()
    public void testLocalDate_aDateIsExpected() {
        //arrange
        //act
        String dateAsString = "1994-05-12";
        LocalDate localDate = new LocalDate(dateAsString);
        assertEquals(localDate.getYear(),1994);
        assertEquals(localDate.getMonth(),5);
        assertEquals(localDate.getDay(),12);
        //assert
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsZero_MonthIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1994, 0, 6);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFifty_MonthIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1994, 50, 6);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_DayIsZero_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1994, 5, 0);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_DayIsThirtyTwo_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1994, 5, 32);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsSeptember_DayIsThirtyOne_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1994, 9, 31);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsThirtyOne_YearIsNotLeap_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1992, 2, 31);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsThirty_YearIsNotLeap_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1993, 2, 30);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsTwentyNine_YearIsNotLeap_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1993, 2, 29);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsTwentyEight_YearIsNotLeap_DayIsNotOutOfRange_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1993, 2, 28);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsTwentySeven_YearIsNotLeap_DayIsNotOutOfRange_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1993, 2, 27);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }

    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsThirtyOne_YearIsLeap_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1992, 2, 31);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsThirty_YearIsLeap_DayIsOutOfRange_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1992, 2, 30);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsTwentyNine_YearIsLeap_DayIsNotOutOfRange_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1992, 2, 29);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsTwentyEight_YearIsLeap_DayIsNotOutOfRange_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1992, 2, 28);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of constructor of class LocalDate .
     */
    @Test
    public void testLocalDate_MonthIsFebruary_DayIsTwentySeven_YearIsLeap_DayIsNotOutOfRange_ThereShouldBeThrownNoPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        //act
        try {
            LocalDate localDate = new LocalDate(1992, 2, 27);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of isYearLeap method, of class LocalDate.
     */
    @Test
    public void testIsYearLeap_YearIs1992_ThereShouldBeReturnedTrue() {
        //arrange
        int year = 1992;
        boolean returnedValue;
        //act
        returnedValue = LocalDate.isYearLeap(year);
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of isYearLeap method, of class LocalDate.
     */
    @Test
    public void testIsYearLeap_YearIs1994_ThereShouldBeReturnedFalse() {
        //arrange
        int year = 1995;
        boolean returnedValue;
        //act
        returnedValue = LocalDate.isYearLeap(year);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of getYear method, of class LocalDate.
     */
    @Test
    public void testGetYear() {
        //arrange
        int expectedYear = 1994;
        int returnedYear;
        LocalDate localDate;
        //act
        localDate = new LocalDate(1994, 5, 6);
        returnedYear = localDate.getYear();
        //assert
        assertEquals(expectedYear, returnedYear);
    }

    /**
     * Test of getMonth method, of class LocalDate.
     */
    @Test
    public void testGetMonth() {
        //arrange
        int expectedMonth = 5;
        int returnedMonth;
        LocalDate localDate;
        //act
        localDate = new LocalDate(1994, 5, 6);
        returnedMonth = localDate.getMonth();
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
        LocalDate localDate;
        //act
        localDate = new LocalDate(1994, 5, 6);
        returnedDay = localDate.getDay();
        //assert
        assertEquals(expectedDay, returnedDay);
    }

    /**
     * Test of toString method, of class LocalDate.
     */
    @Test
    public void testToString() { //arrange
        String expectedResult = "1994-05-06";
        String result;
        LocalDate localDate;
        //act
        localDate = new LocalDate(1994, 5, 6);
        result = localDate.toString();
        //assert
        assertEquals(expectedResult, result);
    }

}
