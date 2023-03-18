
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

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
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
        listOfTimeZoneIDs = TimeZone.getListOfTimeZoneIDs();
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
        listOfTimeZoneIDs = TimeZone.getListOfTimeZoneIDs();
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
        result = TimeZone.isTimeZoneIDValid("Australia/Sydney");
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
        result = TimeZone.isTimeZoneIDValid("Jehjujfdue/Eklfglsdi");
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
        TimeZone timeZone = new TimeZone("Australia/Sydney");
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
        TimeZone timeZone = new TimeZone("Australia/Sydney");
        //act
        result = timeZone.getTimeZoneID();
        //assert
        assertEquals(expectedValue, result);
    }

}
