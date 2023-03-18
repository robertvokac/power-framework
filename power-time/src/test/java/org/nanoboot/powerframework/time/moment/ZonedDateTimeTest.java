
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

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ZonedDateTimeTest {
//
//    /**
//
//     */
//    public ZonedDateTimeTest() {
//    }
//
//    /**
//     Test of convertDateTimeFromOneTimeZoneToAnother method, of class
//     ZonedDateTime.
//     */
//    @Test
//    public void testConvertDateTimeFromOneTimeZoneToAnother() {
//        //arrange
//        TimeZone oldTimeZone = new TimeZone("Australia/West");
//        ZonedDateTime oldZonedDateTime = new ZonedDateTime(new LocalDateTime(1995, 11, 5, 10, 5, 4, 64), oldTimeZone);
//        String stringRepresentationOfOldZonedDateTime = oldZonedDateTime.toString();
//
//        String expectedStringValue = "1995-11-05 13:05:04:064";
//        String returnedStringValue;
//        TimeZone newTimeZone = new TimeZone("Australia/Sydney");
//        //act
//        returnedStringValue = ZonedDateTime.convertDateTimeFromOneTimeZoneToAnother(stringRepresentationOfOldZonedDateTime, oldTimeZone, newTimeZone);
//        //assert
//        assertEquals(expectedStringValue, returnedStringValue);
//    }
//
//    /**
//     Test of getTimeZone method, of class ZonedDateTime.
//     */
//    @Test
//    public void testGetTimeZone() {
//        //arrange
//        String timeZoneID = "Australia/West";
//        TimeZone timeZone = new TimeZone(timeZoneID);
//        ZonedDateTime zonedDateTime = new ZonedDateTime(new LocalDateTime(1995, 8, 5, 10, 5, 4, 64), timeZone);
//        TimeZone returnedTimeZone;
//        String returnedZoneID;
//        //act
//        returnedTimeZone = zonedDateTime.getTimeZone();
//        returnedZoneID = returnedTimeZone.getTimeZoneID();
//        //assert
//        assertEquals(timeZoneID, returnedZoneID);
//
//    }
//
//    /**
//     Test of toUniversalDateTime method, of class ZonedDateTime.
//     */
//    @Test
//    public void testToUniversalDateTime() {
//        //arrange
//        TimeZone oldTimeZone = new TimeZone("Australia/West");
//        ZonedDateTime zonedDateTime = new ZonedDateTime(new LocalDateTime(1995, 8, 5, 10, 5, 4, 64), oldTimeZone);
//        String stringRepresentationOfZonedDateTime = zonedDateTime.toString();
//
//        String expectedStringValue = "1995-08-05 02:05:04:064";
//        String returnedStringValue;
//        //act
//        UniversalDateTime universalDateTime = zonedDateTime.toUniversalDateTime();
//        returnedStringValue = universalDateTime.toString();
//        //assert
//        assertEquals(expectedStringValue, returnedStringValue);
//    }
//
//    /**
//     Test of toLocalDateTime method, of class ZonedDateTime.
//     */
//    @Test
//    public void testToLocalDateTime() {
//        //arrange
//        TimeZone oldTimeZone = new TimeZone("Australia/West");
//        ZonedDateTime zonedDateTime = new ZonedDateTime(new LocalDateTime(1995, 8, 5, 10, 5, 4, 64), oldTimeZone);
//        String stringRepresentationOfZonedDateTime = zonedDateTime.toString();
//
//        String expectedStringValue = "1995-08-05 10:05:04:064";
//        String returnedStringValue;
//        //act
//        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
//        returnedStringValue = localDateTime.toString();
//        //assert
//        assertEquals(expectedStringValue, returnedStringValue);
//    }
//
//    /**
//     Test of toZonedDateTime method, of class ZonedDateTime.
//     */
//    @Test
//    public void testToZonedDateTime() {
//        //arrange
//        TimeZone oldTimeZone = new TimeZone("Australia/West");
//        ZonedDateTime oldZonedDateTime = new ZonedDateTime(new LocalDateTime(1995, 11, 5, 10, 5, 4, 64), oldTimeZone);
//        String stringRepresentationOfOldZonedDateTime = oldZonedDateTime.toString();
//
//        TimeZone newTimeZone = new TimeZone("Australia/Sydney");
//        ZonedDateTime newZonedDateTime = new ZonedDateTime(new LocalDateTime(1995, 11, 5, 13, 5, 4, 64), oldTimeZone);
//
//        String expectedStringValue = "1995-11-05 13:05:04:064";
//        String returnedStringValue;
//        //act
//        String stringRepresentationOfNewZonedDateTime = newZonedDateTime.toString();
//        returnedStringValue = stringRepresentationOfNewZonedDateTime;
//        //assert
//        assertEquals(expectedStringValue, returnedStringValue);
//    }
//
//    /**
//     Test of toJavaZonedDateTime method, of class ZonedDateTime.
//     */
//    @Test
//    public void testToJavaZonedDateTime() {
//        //arrange
//        TimeZone timeZone = new TimeZone("Australia/West");
//        ZonedDateTime zonedDateTime;
//        zonedDateTime = new ZonedDateTime(new LocalDateTime(1994, 5, 6, 21, 45, 6, 32), timeZone);
//        java.time.ZonedDateTime javaZonedDateTime;
//        int expectedDay = 6;
//        int returnedDay;
//        //act
//
//        javaZonedDateTime = zonedDateTime.toJavaZonedDateTime();
//        returnedDay = javaZonedDateTime.getDayOfMonth();
//        //assert
//        assertEquals(expectedDay, returnedDay);
//    }

}
