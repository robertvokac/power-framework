
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

package org.nanoboot.powerframework.collections;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class PropertiesTest {
    private Properties properties;

    @Before
    public void setup() {
        properties=new Properties(PROPERTIES_FILE_TEXT_IN);
    }
    public static final String PROPERTIES_FILE_TEXT_IN = "#Fri Jan 17 22:37:45 MYT 2014\n" +
            "dbpassword=password\n" +
            "database=localhost\n" +
            "dbuser=mkyong";
    @Test
    public void getProperty() {
        //prepare
        //execute
        //assert
        assertEquals(properties.getProperty("dbpassword"), "password");
        assertEquals(properties.getProperty("database"), "localhost");
        assertEquals(properties.getProperty("dbuser"), "mkyong");
        try {
            properties.getProperty("abc");
            throw new AssertionError("NoSuchElementException expected, but not thrown.");
        } catch (NoSuchElementException e) {

        }
    }

    @Test
    public void setProperty() {
        //prepare
        //execute
        properties.setProperty("dbpassword", "newPassword");
        //assert
        assertEquals(properties.getProperty("dbpassword"), "newPassword");
        assertEquals(properties.getProperty("database"), "localhost");
        assertEquals(properties.getProperty("dbuser"), "mkyong");
        try {
            properties.getProperty("abc");
            throw new AssertionError("NoSuchElementException expected, but not thrown.");
        } catch (NoSuchElementException e) {

        }

    }

    @Test
    public void hasProperty() {

        //prepare
        //execute
        properties.setProperty("dbpassword", "newPassword");
        //assert
        assertTrue(properties.hasProperty("dbpassword"));
        assertTrue(properties.hasProperty("database"));
        assertTrue(properties.hasProperty("dbuser"));
        try {
            properties.getProperty("abc");
            throw new AssertionError("NoSuchElementException expected, but not thrown.");
        } catch (NoSuchElementException e) {

        }
    }

    @Test
    public void testToString() {
        //prepare
        String returned;
        //execute
        returned = properties.toString();
        //assert
        assertTrue(returned.contains("dbpassword=password"));
        assertTrue(returned.contains("database=localhost"));
        assertTrue(returned.contains("dbuser=mkyong"));
        assertTrue(returned.contains(", "));
    }

    @Test
    public void getMap() {
        PowerMap<String> map = properties.getMap();
        assertNotNull(map);
        assertTrue(map.containsKey("dbpassword"));
        assertTrue(map.containsKey("database"));
        assertTrue(map.containsKey("dbuser"));
    }
}
