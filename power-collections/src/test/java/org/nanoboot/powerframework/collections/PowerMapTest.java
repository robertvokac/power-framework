
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

package org.nanoboot.powerframework.collections;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class PowerMapTest {

    /**
     *
     */
    public PowerMapTest() {
    }

    /**
     * Test of size method, of class map.
     */
    @Test
    public void testsize() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        int expectedValue = 0;
        int returnedValue;
        //act
        returnedValue = map.size();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of size method, of class map.
     */
    @Test
    public void testsize2() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        int expectedValue = 0;
        int returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.remove("name");
        map.remove("surname");
        returnedValue = map.size();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of size method, of class map.
     */
    @Test
    public void testsize3() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        int expectedValue = 2;
        int returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("surname");
        returnedValue = map.size();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of size method, of class map.
     */
    @Test
    public void testsize4() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        int expectedValue = 1;
        int returnedValue;
        //act
        map.put("surname", "Black");
        returnedValue = map.size();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class map.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean returnedValue;
        //act
        returnedValue = map.isEmpty();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of isEmpty method, of class map.
     */
    @Test
    public void testIsEmpty2() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.remove("name");
        map.remove("surname");
        returnedValue = map.isEmpty();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of isEmpty method, of class map.
     */
    @Test
    public void testIsEmpty3() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("surname");
        returnedValue = map.isEmpty();
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of getValue method, of class map.
     */
    @Test
    public void testIsEmpty4() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("name");
        returnedValue = map.isEmpty();
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of containsKey method, of class map.
     */
    @Test
    public void containsKeyKey() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        returnedValue = map.containsKey("surname");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsKey method, of class map.
     */
    @Test
    public void containsKey2() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        returnedValue = map.containsKey("job");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsKey method, of class map.
     */
    @Test
    public void containsKey3() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        map.put("name", "John");
        returnedValue = map.containsKey("name");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class map.
     */
    @Test
    public void testPut() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Johny";
        String returnedString;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("surname");
        returnedString = map.get("nick");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of add method, of class map.
     */
    @Test
    public void testPut2() {
        //arrang
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Johny";
        String returnedString;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("name");
        returnedString = map.get("nick");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of add method, of class map.
     */
    @Test
    public void testPut3() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Black";
        String returnedString;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("nick");
        returnedString = map.get("surname");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getValue method, of class map.
     */
    @Test
    public void testGet() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Black";
        String returnedString;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("name");
        returnedString = map.get("surname");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getValue method, of class map.
     */
    @Test
    public void testGet2() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Johny";
        String returnedString;
        //act
        map.put("nick", "Johny");
        returnedString = map.get("nick");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of updateValue method, of class map.
     */
    @Test
    public void testReplaceValue() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Blue";
        String returnedString;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.replace("surname", "Blue");
        returnedString = map.get("surname");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of remove method, of class map.
     */
    @Test
    public void testRemove() {
        //arrange
        boolean isExceptionThrown = false;
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "Black";
        String returnedString;
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("surname");
        //act
        try {
            returnedString = map.get("surname");
        } catch (NoSuchElementException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown NoSuchElementException");
        }
    }

    /**
     * Test of getKeyIterator method, of class map.
     */
    @Test
    public void testIterator() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        Iterator<KeyValue<String>> mapIterator;
        String expectedString = "Johny";
        String returnedString;
        String secondKey;
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        map.remove("surname");
        mapIterator = map.iterator();
        //act
        mapIterator.next();
        secondKey = mapIterator.next().getKey();
        returnedString = map.get(secondKey);
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of toString method, of class map.
     */
    @Test
    public void testToString() {
        //arrange
        PowerMap<String> map = new PowerMap<>();
        String expectedString = "name=John\nsurname=Black\nnick=Johny";
        String returnedString;
        //act
        map.put("name", "John");
        map.put("surname", "Black");
        map.put("nick", "Johny");
        returnedString = map.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
