
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

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
        listOfTimeZoneIDs = org.nanoboot.powerframework.time.moment.TimeZone.getListOfTimeZoneIDs();
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
        listOfTimeZoneIDs = org.nanoboot.powerframework.time.moment.TimeZone.getListOfTimeZoneIDs();
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
        result = org.nanoboot.powerframework.time.moment.TimeZone.isTimeZoneIDValid("Australia/Sydney");
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
        result = org.nanoboot.powerframework.time.moment.TimeZone.isTimeZoneIDValid("Jehjujfdue/Eklfglsdi");
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
        org.nanoboot.powerframework.time.moment.TimeZone timeZone = new org.nanoboot.powerframework.time.moment.TimeZone("Australia/Sydney");
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
        org.nanoboot.powerframework.time.moment.TimeZone timeZone = new TimeZone("Australia/Sydney");
        //act
        result = timeZone.getTimeZoneID();
        //assert
        assertEquals(expectedValue, result);
    }

}
