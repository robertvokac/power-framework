
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
public class DictionaryNodeTest {

    /**
     *
     */
    public DictionaryNodeTest() {
    }

    /**
     * Test of getElement method, of class DictionaryNode.
     */
    @Test
    public void testGetElement() {
        //arrange
        DictionaryNode<String> dictionaryNode = new DictionaryNode<>("name", "John");
        String expectedString = "John";
        String returnedString;
        //act
        returnedString = dictionaryNode.getElement();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of setElement method, of class DictionaryNode.
     */
    @Test
    public void testSetElement() {
        //arrange
        DictionaryNode<String> dictionaryNode = new DictionaryNode<>("name", "John");
        String expectedString = "Jack";
        String returnedString;
        //act
        dictionaryNode.setElement("Jack");
        returnedString = dictionaryNode.getElement();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getNext method, of class DictionaryNode.
     */
    @Test
    public void testGetNext() {
        //arrange
        DictionaryNode<String> dictionaryNode = new DictionaryNode<>("name", "John");
        DictionaryNode<String> dictionaryNode2 = new DictionaryNode<>("surname", "Black");
        String expectedString = "Black";
        String returnedString;
        //act
        dictionaryNode.setNext(dictionaryNode2);
        DictionaryNode<String> returnedDictionaryNode = dictionaryNode.getNext();
        returnedString = returnedDictionaryNode.getElement();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of setNext method, of class DictionaryNode.
     */
    @Test
    public void testSetNext() {
        //arrange
        DictionaryNode<String> dictionaryNode = new DictionaryNode<>("name", "John");
        DictionaryNode<String> dictionaryNode2 = new DictionaryNode<>("surname", "White");
        String expectedString = "White";
        String returnedString;
        //act
        dictionaryNode.setNext(dictionaryNode2);
        DictionaryNode<String> returnedDictionaryNode = dictionaryNode.getNext();
        returnedString = returnedDictionaryNode.getElement();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getKey method, of class DictionaryNode.
     */
    @Test
    public void testGetKey() {
        //arrange
        DictionaryNode<String> dictionaryNode = new DictionaryNode<>("name", "John");
        String expectedString = "name";
        String returnedString;
        //act
        returnedString = dictionaryNode.getKey();
        //assert
        assertEquals(expectedString, returnedString);

    }

    /**
     * Test of setKey method, of class DictionaryNode.
     */
    @Test
    public void testSetKey() {
        //arrange
        DictionaryNode<String> dictionaryNode = new DictionaryNode<>("name", "John");
        String expectedString = "nick";
        String returnedString;
        //act
        dictionaryNode.setKey("nick");
        returnedString = dictionaryNode.getKey();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
