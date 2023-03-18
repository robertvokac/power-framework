
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

import org.nanoboot.powerframework.PowerRuntimeException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class DictionaryTest {

    /**
     *
     */
    public DictionaryTest() {
    }

    /**
     * Test of getCountOfItems method, of class Dictionary.
     */
    @Test
    public void testGetCountOfItems() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        int expectedValue = 0;
        int returnedValue;
        //act
        returnedValue = dictionary.getCountOfItems();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getCountOfItems method, of class Dictionary.
     */
    @Test
    public void testGetCountOfItems2() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        int expectedValue = 0;
        int returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black");
        dictionary.removeValue("name").removeValue("surname");
        returnedValue = dictionary.getCountOfItems();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getCountOfItems method, of class Dictionary.
     */
    @Test
    public void testGetCountOfItems3() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        int expectedValue = 2;
        int returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        returnedValue = dictionary.getCountOfItems();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getCountOfItems method, of class Dictionary.
     */
    @Test
    public void testGetCountOfItems4() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        int expectedValue = 1;
        int returnedValue;
        //act
        dictionary.addValue("surname", "Black");
        returnedValue = dictionary.getCountOfItems();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Dictionary.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        returnedValue = dictionary.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Dictionary.
     */
    @Test
    public void testIsEmpty2() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black");
        dictionary.removeValue("name").removeValue("surname");
        returnedValue = dictionary.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Dictionary.
     */
    @Test
    public void testIsEmpty3() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        returnedValue = dictionary.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getValue method, of class Dictionary.
     */
    @Test
    public void testIsEmpty4() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("name");
        returnedValue = dictionary.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsValueWithKey method, of class Dictionary.
     */
    @Test
    public void containsValueWithKey() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        returnedValue = dictionary.containsValueWithKey("surname");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsValueWithKey method, of class Dictionary.
     */
    @Test
    public void containsValueWithKey2() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        returnedValue = dictionary.containsValueWithKey("job");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsValueWithKey method, of class Dictionary.
     */
    @Test
    public void containsValueWithKey3() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John");
        returnedValue = dictionary.containsValueWithKey("name");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addValue method, of class Dictionary.
     */
    @Test
    public void testAddValue() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Johny";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        returnedString = dictionary.getValue("nick");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of addValue method, of class Dictionary.
     */
    @Test
    public void testAddValue2() {
        //arrang
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Johny";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("name");
        returnedString = dictionary.getValue("nick");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of addValue method, of class Dictionary.
     */
    @Test
    public void testAddValue3() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Black";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("nick");
        returnedString = dictionary.getValue("surname");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getValue method, of class Dictionary.
     */
    @Test
    public void testGetValue() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Black";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("name");
        returnedString = dictionary.getValue("surname");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getValue method, of class Dictionary.
     */
    @Test
    public void testGetValue2() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Johny";
        String returnedString;
        //act
        dictionary.addValue("nick", "Johny");
        returnedString = dictionary.getValue("nick");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of updateValue method, of class Dictionary.
     */
    @Test
    public void testUpdateValue() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Blue";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.updateValue("surname", "Blue");
        returnedString = dictionary.getValue("surname");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of removeValue method, of class Dictionary.
     */
    @Test
    public void testRemoveValue() {
        //arrange
        boolean isExceptionThrown = false;
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "Black";
        String returnedString;
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        //act
        try {
            returnedString = dictionary.getValue("surname");
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getKeyIterator method, of class Dictionary.
     */
    @Test
    public void testGetKeyIterator() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        String expectedString = "Johny";
        String returnedString;
        String secondKey;
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        dictionaryKeyIterator = dictionary.getKeyIterator();
        //act
        dictionaryKeyIterator.getNextKey();
        secondKey = dictionaryKeyIterator.getNextKey();
        returnedString = dictionary.getValue(secondKey);
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of toString method, of class Dictionary.
     */
    @Test
    public void testToString() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        String expectedString = "name:John\nsurname:Black\nnick:Johny\n";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        returnedString = dictionary.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
