
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

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class StackTest {

    /**
     *
     */
    public StackTest() {
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testsize() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        returnedCountOfItems = stack.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testsize2() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        stack.pushAndReturn("John");
        stack.pop();
        returnedCountOfItems = stack.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testsize3() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        stack.pushAndReturn("John");
        stack.pop();
        stack.pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pushAndReturn("Jane");
        stack.pop();
        returnedCountOfItems = stack.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testsize4() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        int expectedCountOfItems = 1;
        int returnedCountOfItems;
        //act
        stack.pushAndReturn("John");
        stack.pop();
        stack.pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie");

        stack.pop();
        stack.pop();
        stack.pushAndReturn("Jane");
        stack.pop();
        returnedCountOfItems = stack.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testsize5() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        int expectedCountOfItems = 3;
        int returnedCountOfItems;
        //act
        stack.pushAndReturn("John");
        stack.pop();
        stack.pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie").pushAndReturn("Susan");

        stack.pop();
        stack.pushAndReturn("Jane");
        stack.pop();
        returnedCountOfItems = stack.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
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
        PowerStack<String> stack = new PowerStack<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.pushAndReturn("Jane");
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
        PowerStack<String> stack = new PowerStack<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie");

        stack.pop();
        stack.pop();
        stack.pop();

        stack.pushAndReturn("Jane");
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
        PowerStack<String> stack = new PowerStack<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie");

        stack.pop();
        stack.pop();

        stack.pushAndReturn("Jane");
        stack.pop();
        returnedValue = stack.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testpushAndReturn() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        String expectedString = "Jack";
        String returnedString;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie");

        stack.pop();
        stack.pop();

        stack.pushAndReturn("Jane");
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
        PowerStack<String> stack = new PowerStack<>();
        String expectedString = "Dennis";
        String returnedString;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie").pushAndReturn("Alice").pushAndReturn("Dennis");

        stack.pushAndReturn("Jane");
        stack.pop();
        returnedString = stack.pop();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop2() {

        //arrange
        boolean isExceptionThrown = false;
        PowerStack<String> stack = new PowerStack<>();
        //act
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown NoSuchElementException");
        }
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        String expectedString = "Dennis";
        String returnedString;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie").pushAndReturn("Alice").pushAndReturn("Dennis");

        stack.pushAndReturn("Jane");
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
        PowerStack<String> stack = new PowerStack<>();
        int expectedValue = 6;
        int returnedValue;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie").pushAndReturn("Alice").pushAndReturn("Dennis");

        stack.pushAndReturn("Jane");
        stack.pop();
        returnedValue = stack.size();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testClear() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        boolean returnedValue;
        //act
        stack.pushAndReturn("John").pushAndReturn("Jack").pushAndReturn("Anne").pushAndReturn("Charlie").pushAndReturn("Alice").pushAndReturn("Dennis");

        stack.clear();
        returnedValue = stack.isEmpty();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void testToString() {
        //arrange
        PowerStack<String> stack = new PowerStack<>();
        String expectedString = "Jane, Alice";
        String returnedString;
        //act
        stack.pushAndReturn("Alice").pushAndReturn("Jane");
        returnedString = stack.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
