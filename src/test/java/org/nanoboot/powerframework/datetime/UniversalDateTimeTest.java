
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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class UniversalDateTimeTest {

    /**
     *
     */
    public UniversalDateTimeTest() {
    }

    /**
     * Test of constructor of class UniversalDateTime. (String dateTimeInString)
     */
    @Test
    public void testUniversalDateTime_1argString_day6MustBeReturned() {
        //arrange
        UniversalDateTime universalDateTime;
        int expectedDay = 6;
        int returnedDay;
        //act
        universalDateTime = new UniversalDateTime("1994-05-06 21:45:06:032");
        returnedDay = universalDateTime.getDay();
        //assert
        assertEquals(expectedDay, returnedDay);
    }

    /**
     * Test of constructor of class UniversalDateTime. (int year, int month, int
     * day, int hour24Format, int minute, int second, int millisecond)
     */
    @Test
    public void testUniversalDateTime_7args_day6MustBeReturned() {
        //arrange
        UniversalDateTime universalDateTime;
        int expectedDay = 6;
        int returnedDay;
        //act
        universalDateTime = new UniversalDateTime(1994, 5, 6, 21, 45, 6, 32);
        returnedDay = universalDateTime.getDay();
        //assert
        assertEquals(expectedDay, returnedDay);
    }

    /**
     * Test of constructor of class UniversalDateTime. (ZonedDateTime
     * zonedDateTime)
     */
    @Test
    public void testUniversalDateTime_1argZonedDateTime_day6MustBeReturned() {
        //arrange
        UniversalDateTime universalDateTime;
        TimeZone timeZone;
        ZonedDateTime zonedDateTime;
        int expectedDay = 5;
        int returnedDay;
        //act
        timeZone = new TimeZone("Australia/Sydney");
        zonedDateTime = new ZonedDateTime(new LocalDateTime(1994, 5, 6, 21, 45, 6, 32), timeZone);
        universalDateTime = new UniversalDateTime(zonedDateTime);
        returnedDay = universalDateTime.getMonth();
        //assert
        assertEquals(expectedDay, returnedDay);
    }

    /**
     * Test of constructor of class UniversalDateTime. (LocalDateTime
     * localDateTime)
     */
    @Test
    public void testUniversalDateTime_1argLocalDateTime_day6MustBeReturned() {
        //arrange
        UniversalDateTime universalDateTime;
        LocalDateTime localDateTime;
        int expectedDay = 6;
        int returnedDay;
        //act
        localDateTime = new LocalDateTime(1994, 5, 6, 21, 45, 6, 32);
        universalDateTime = new UniversalDateTime(localDateTime);

        returnedDay = localDateTime.getDay();
        //assert
        assertEquals(expectedDay, returnedDay);
    }

    /**
     * Test of toZonedDateTime method, of class LocalDateTime.
     */
    @Test
    public void testToZonedDateTime() {
        //arrange
        UniversalDateTime universalDateTime;
        ZonedDateTime zonedDateTime;
        int expectedMonth = 5;
        int returnedMonth;
        //act
        universalDateTime = new UniversalDateTime(1994, 5, 6, 21, 45, 6, 32);
        zonedDateTime = universalDateTime.toZonedDateTime();
        returnedMonth = zonedDateTime.getMonth();
        //assert
        assertEquals(expectedMonth, returnedMonth);
    }

    /**
     * Test of testToLocalDateTime method, of class LocalDateTime.
     */
    @Test
    public void testToLocalDateTime() {
        //arrange
        UniversalDateTime universalDateTime;
        LocalDateTime localDateTime;

        int expectedMonth = 5;
        int returnedMonth;
        //act
        universalDateTime = new UniversalDateTime(1994, 5, 6, 21, 45, 6, 32);
        localDateTime = universalDateTime.toLocalDateTime();
        returnedMonth = universalDateTime.getMonth();
        //assert
        assertEquals(expectedMonth, returnedMonth);
    }
}
