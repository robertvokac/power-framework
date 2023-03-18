
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
public class StackTest {

    /**
     *
     */
    public StackTest() {
    }

    /**
     * Test of getCountOfItems method, of class Stack.
     */
    @Test
    public void testGetCountOfItems() {
        //arrange
        Stack<String> stack = new Stack<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        returnedCountOfItems = stack.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Stack.
     */
    @Test
    public void testGetCountOfItems2() {
        //arrange
        Stack<String> stack = new Stack<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        stack.push("John");
        stack.pop();
        returnedCountOfItems = stack.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Stack.
     */
    @Test
    public void testGetCountOfItems3() {
        //arrange
        Stack<String> stack = new Stack<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        stack.push("John");
        stack.pop();
        stack.push("Jack").push("Anne").push("Charlie");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("Jane");
        stack.pop();
        returnedCountOfItems = stack.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Stack.
     */
    @Test
    public void testGetCountOfItems4() {
        //arrange
        Stack<String> stack = new Stack<>();
        int expectedCountOfItems = 1;
        int returnedCountOfItems;
        //act
        stack.push("John");
        stack.pop();
        stack.push("Jack").push("Anne").push("Charlie");

        stack.pop();
        stack.pop();
        stack.push("Jane");
        stack.pop();
        returnedCountOfItems = stack.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Stack.
     */
    @Test
    public void testGetCountOfItems5() {
        //arrange
        Stack<String> stack = new Stack<>();
        int expectedCountOfItems = 3;
        int returnedCountOfItems;
        //act
        stack.push("John");
        stack.pop();
        stack.push("Jack").push("Anne").push("Charlie").push("Susan");

        stack.pop();
        stack.push("Jane");
        stack.pop();
        returnedCountOfItems = stack.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        Stack<String> stack = new Stack<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        returnedValue = stack.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty2() {
        //arrange
        Stack<String> stack = new Stack<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.push("Jane");
        stack.pop();
        returnedValue = stack.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty3() {
        //arrange
        Stack<String> stack = new Stack<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie");

        stack.pop();
        stack.pop();
        stack.pop();

        stack.push("Jane");
        stack.pop();
        returnedValue = stack.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty4() {
        //arrange
        Stack<String> stack = new Stack<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie");

        stack.pop();
        stack.pop();

        stack.push("Jane");
        stack.pop();
        returnedValue = stack.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        //arrange
        Stack<String> stack = new Stack<>();
        String expectedString = "Jack";
        String returnedString;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie");

        stack.pop();
        stack.pop();

        stack.push("Jane");
        stack.pop();
        returnedString = stack.pop();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        //arrange
        Stack<String> stack = new Stack<>();
        String expectedString = "Dennis";
        String returnedString;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie").push("Alice").push("Dennis");

        stack.push("Jane");
        stack.pop();
        returnedString = stack.pop();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        //arrange
        Stack<String> stack = new Stack<>();
        String expectedString = "Dennis";
        String returnedString;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie").push("Alice").push("Dennis");

        stack.push("Jane");
        stack.pop();
        returnedString = stack.peek();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek2() {
        //arrange
        Stack<String> stack = new Stack<>();
        int expectedValue = 6;
        int returnedValue;
        //act
        stack.push("John").push("Jack").push("Anne").push("Charlie").push("Alice").push("Dennis");

        stack.push("Jane");
        stack.pop();
        returnedValue = stack.getCountOfItems();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop2() {

        //arrange
        boolean isExceptionThrown = false;
        Stack<String> stack = new Stack<>();
        //act
        try {
            stack.pop();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void testToString() {
        //arrange
        Stack<String> stack = new Stack<>();
        String expectedString = "Jane, Alice, ";
        String returnedString;
        //act
        stack.push("Alice").push("Jane");
        returnedString = stack.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
