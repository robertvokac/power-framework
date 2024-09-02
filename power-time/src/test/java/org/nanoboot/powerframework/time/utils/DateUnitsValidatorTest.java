
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

package org.nanoboot.powerframework.time.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class DateUnitsValidatorTest {

    /**
     *
     */
    public DateUnitsValidatorTest() {
    }

    /**
     * Test of isMonthValid method, of class DateUnitsValidator.
     */
    @Test
    public void testIsMonthValid_MonthIs3_ThereShouldBeReturnedTrue() {
        //arrange
        int month = 3;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.isMonthValid(month);
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of isMonthValid method, of class DateUnitsValidator.
     */
    @Test
    public void testIsMonthValid_MonthIs0_ThereShouldBeReturnedFalse() {
        //arrange
        int month = 0;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.isMonthValid(month);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of isMonthValid method, of class DateUnitsValidator.
     */
    @Test
    public void testIsMonthValid_MonthIs13_ThereShouldBeReturnedFalse() {
        //arrange
        int month = 13;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.isMonthValid(month);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of isDayValid method, of class DateUnitsValidator.
     */
    @Test
    public void testIsDayValid_DayIs3_ThereShouldBeReturnedTrue() {
        //arrange
        int day = 3;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.isDayValid(day);
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of isDayValid method, of class DateUnitsValidator.
     */
    @Test
    public void testIsDayValid_DayIs0_ThereShouldBeReturnedFalse() {
        //arrange
        int day = 0;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.isDayValid(day);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of isDayValid method, of class DateUnitsValidator.
     */
    @Test
    public void testIsDayValid_DayIs32_ThereShouldBeReturnedFalse() {
        //arrange
        int day = 32;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.isDayValid(day);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of hasDateValidCombination method, of class DateUnitsValidator.
     */
    @Test
    public void testHasDateValidCombination_YearIs1992AndMonthIs3AndDayIs3_ThereShouldBeReturnedTrue() {
        //arrange
        int year = 1992;
        int month = 3;
        int day = 3;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.hasDateValidCombination(year, month, day);
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of hasDateValidCombination method, of class DateUnitsValidator.
     */
    @Test
    public void testHasDateValidCombination_YearIs1992AndMonthIs6AndDayIs31_ThereShouldBeReturnedFalse() {
        //arrange
        int year = 1992;
        int month = 6;
        int day = 31;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.hasDateValidCombination(year, month, day);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of hasDateValidCombination method, of class DateUnitsValidator.
     */
    @Test
    public void testHasDateValidCombination_YearIs01992AndMonthIs2AndDayIs28_ThereShouldBeReturnedTrue() {
        //arrange
        int year = 1992;
        int month = 2;
        int day = 28;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.hasDateValidCombination(year, month, day);
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of hasDateValidCombination method, of class DateUnitsValidator.
     */
    @Test
    public void testHasDateValidCombination_YearIs1993AndMonthIs2AndDayIs28_ThereShouldBeReturnedTrue() {
        //arrange
        int year = 1993;
        int month = 2;
        int day = 28;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.hasDateValidCombination(year, month, day);
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of hasDateValidCombination method, of class DateUnitsValidator.
     */
    @Test
    public void testHasDateValidCombination_YearIs01993AndMonthIs2AndDayIs29_ThereShouldBeReturnedFalse() {
        //arrange
        int year = 1993;
        int month = 2;
        int day = 29;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.hasDateValidCombination(year, month, day);
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of hasDateValidCombination method, of class DateUnitsValidator.
     */
    @Test
    public void testHasDateValidCombination_YearIs01992AndMonthIs2AndDayIs29_ThereShouldBeReturnedTrue() {
        //arrange
        int year = 1992;
        int month = 2;
        int day = 29;
        boolean returnedValue;
        //act
        returnedValue = DateUnitsValidator.hasDateValidCombination(year, month, day);
        //assert
        assertTrue(returnedValue);
    }

}
