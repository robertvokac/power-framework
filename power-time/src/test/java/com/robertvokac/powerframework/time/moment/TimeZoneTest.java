
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

package com.robertvokac.powerframework.time.moment;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class TimeZoneTest {

    /**
     *
     */
    public TimeZoneTest() {
    }

    /**
     * Test of getListOfTimeZoneIDs method, of class TimeZone.
     */
    @Test
    public void testGetListOfTimeZoneIDs_mustContain() {
        //arrange
        List<String> listOfTimeZoneIDs;
        boolean expectedValue = true;
        boolean result;
        //act
        listOfTimeZoneIDs = com.robertvokac.powerframework.time.moment.TimeZone.getListOfTimeZoneIDs();
        result = listOfTimeZoneIDs.contains("Australia/Sydney");
        //assert
        assertEquals(expectedValue, result);
    }

    /**
     * Test of getListOfTimeZoneIDs method, of class TimeZone.
     */
    @Test
    public void testGetListOfTimeZoneIDs_mustNotContain() {
        //arrange
        List<String> listOfTimeZoneIDs;
        boolean expectedValue = false;
        boolean result;
        //act
        listOfTimeZoneIDs = com.robertvokac.powerframework.time.moment.TimeZone.getListOfTimeZoneIDs();
        result = listOfTimeZoneIDs.contains("Amflkfd/Adfkjldfk");
        //assert
        assertEquals(expectedValue, result);
    }

    /**
     * Test of isTimeZoneIDValid method, of class TimeZone.
     */
    @Test
    public void testIsTimeZoneIDValid_mustReturnTrue() {
        //arrange
        boolean expectedValue = true;
        boolean result;
        //act
        result = com.robertvokac.powerframework.time.moment.TimeZone.isTimeZoneIDValid("Australia/Sydney");
        //assert
        assertEquals(expectedValue, result);
    }

    /**
     * Test of isTimeZoneIDValid method, of class TimeZone.
     */
    @Test
    public void testIsTimeZoneIDValid_mustReturnFalse() {
        //arrange
        boolean expectedValue = false;
        boolean result;
        //act
        result = com.robertvokac.powerframework.time.moment.TimeZone.isTimeZoneIDValid("Jehjujfdue/Eklfglsdi");
        //assert
        assertEquals(expectedValue, result);
    }

    /**
     * Test of toString method, of class TimeZone.
     */
    @Test
    public void testToString() {
        //arrange
        String expectedValue = "Australia/Sydney";
        String result;
        com.robertvokac.powerframework.time.moment.TimeZone timeZone = new com.robertvokac.powerframework.time.moment.TimeZone("Australia/Sydney");
        //act
        result = timeZone.toString();
        //assert
        assertEquals(expectedValue, result);
    }

    /**
     * Test of getTimeZoneID method, of class TimeZone.
     */
    @Test
    public void testGetTimeZoneID() {
        //arrange
        String expectedValue = "Australia/Sydney";
        String result;
        com.robertvokac.powerframework.time.moment.TimeZone timeZone = new TimeZone("Australia/Sydney");
        //act
        result = timeZone.getTimeZoneID();
        //assert
        assertEquals(expectedValue, result);
    }

}
