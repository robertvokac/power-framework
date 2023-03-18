
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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class DictionaryKeyIteratorTest {

    /**
     *
     */
    public DictionaryKeyIteratorTest() {
    }

    /**
     * Test of getNextKey method, of class DictionaryKeyIterator.
     */
    @Test
    public void testGetNextKey() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        StringBuilder stringBuilder = new StringBuilder();
        String key1;
        String key2;
        String key3;
        String value1;
        String value2;
        String value3;
        String expectedString = "JohnJohnycalm";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        dictionary.addValue("personality", "calm");
        dictionaryKeyIterator = dictionary.getKeyIterator();
        key1 = dictionaryKeyIterator.getNextKey();
        key2 = dictionaryKeyIterator.getNextKey();
        key3 = dictionaryKeyIterator.getNextKey();

        value1 = dictionary.getValue(key1);
        value2 = dictionary.getValue(key2);
        value3 = dictionary.getValue(key3);

        stringBuilder.append(value1);
        stringBuilder.append(value2);
        stringBuilder.append(value3);
        returnedString = stringBuilder.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of hasNext method, of class DictionaryKeyIterator.
     */
    @Test
    public void testHasNext() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        dictionary.addValue("personality", "calm");
        dictionaryKeyIterator = dictionary.getKeyIterator();
        dictionaryKeyIterator.getNextKey();
        dictionaryKeyIterator.getNextKey();
        returnedValue = dictionaryKeyIterator.hasNext();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of hasNext method, of class DictionaryKeyIterator.
     */
    @Test
    public void testHasNext2() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        dictionary.addValue("personality", "calm");
        dictionaryKeyIterator = dictionary.getKeyIterator();
        dictionaryKeyIterator.getNextKey();
        dictionaryKeyIterator.getNextKey();
        dictionaryKeyIterator.getNextKey();
        returnedValue = dictionaryKeyIterator.hasNext();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of hasNext method, of class DictionaryKeyIterator.
     */
    @Test
    public void testHasNext3() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John");
        dictionaryKeyIterator = dictionary.getKeyIterator();
        dictionaryKeyIterator.getNextKey();
        returnedValue = dictionaryKeyIterator.hasNext();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of hasNext method, of class DictionaryKeyIterator.
     */
    @Test
    public void testHasNext4() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        boolean expectedValue = false;
        boolean returnedValue;
        //act

        dictionaryKeyIterator = dictionary.getKeyIterator();

        returnedValue = dictionaryKeyIterator.hasNext();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of hasNext method, of class DictionaryKeyIterator.
     */
    @Test
    public void testHasNext5() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        dictionary.addValue("name", "John");
        dictionaryKeyIterator = dictionary.getKeyIterator();

        returnedValue = dictionaryKeyIterator.hasNext();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of reset method, of class DictionaryKeyIterator.
     */
    @Test
    public void testReset() {
        //arrange
        Dictionary<String> dictionary = new Dictionary<>();
        DictionaryKeyIterator dictionaryKeyIterator;
        String firstKey;

        String expectedString = "John";
        String returnedString;
        //act
        dictionary.addValue("name", "John").addValue("surname", "Black").addValue("nick", "Johny");
        dictionary.removeValue("surname");
        dictionary.addValue("personality", "calm");
        dictionaryKeyIterator = dictionary.getKeyIterator();
        for (int i = 0; i < 3; i++) {
            dictionaryKeyIterator.getNextKey();
        }
        dictionaryKeyIterator.reset();
        firstKey = dictionaryKeyIterator.getNextKey();
        returnedString = dictionary.getValue(firstKey);
        //assert
        assertEquals(expectedString, returnedString);
    }

}
