
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

package com.robertvokac.powerframework.collections;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class QueueTest {

    /**
     *
     */
    public QueueTest() {
    }

    /**
     * Test of size method, of class Queue.
     */
    @Test
    public void testsize() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        returnedCountOfItems = queue.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Queue.
     */
    @Test
    public void testsize2() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        queue.add("John");
        queue.poll();
        returnedCountOfItems = queue.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Queue.
     */
    @Test
    public void testsize3() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        queue.add("John");
        queue.poll();
        queue.addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie");

        queue.poll();
        queue.poll();
        queue.poll();
        queue.add("Jane");
        queue.poll();
        returnedCountOfItems = queue.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Queue.
     */
    @Test
    public void testsize4() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        int expectedCountOfItems = 1;
        int returnedCountOfItems;
        //act
        queue.add("John");
        queue.poll();
        queue.addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie");

        queue.poll();
        queue.poll();
        queue.add("Jane");
        queue.poll();
        returnedCountOfItems = queue.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of size method, of class Queue.
     */
    @Test
    public void testsize5() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        int expectedCountOfItems = 3;
        int returnedCountOfItems;
        //act
        queue.add("John");
        queue.poll();
        queue.addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie").addAndReturn("Susan");

        queue.poll();
        queue.add("Jane");
        queue.poll();
        returnedCountOfItems = queue.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        returnedValue = queue.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmpty2() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        queue.addAndReturn("John").addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie");

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        queue.add("Jane");
        queue.poll();
        returnedValue = queue.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmpty3() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        queue.addAndReturn("John").addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie");

        queue.poll();
        queue.poll();
        queue.poll();

        queue.add("Jane");
        queue.poll();
        returnedValue = queue.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmpty4() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        queue.addAndReturn("John").addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie");

        queue.poll();
        queue.poll();

        queue.add("Jane");
        queue.poll();
        returnedValue = queue.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of enqueue method, of class Queue.
     */
    @Test
    public void testEnqueue() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        String expectedString = "John";
        String returnedString;
        //act
        queue.add("John");
        returnedString = queue.poll();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        String expectedString = "Alice";
        String returnedString;
        //act
        queue.addAndReturn("Alice").addAndReturn("Jane");
        returnedString = queue.poll();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue_ThereShouldBeThrownOkayRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        PowerQueue<String> queue = new PowerQueue<>();
        //act
        try {
            queue.poll();
        } catch (NoSuchElementException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown OkayRuntimeException");
        }
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testClear() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        boolean returnedValue;
        //act
        queue.addAndReturn("John").addAndReturn("Jack").addAndReturn("Anne").addAndReturn("Charlie").addAndReturn("Alice").addAndReturn("Dennis");

        queue.clear();
        returnedValue = queue.isEmpty();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of toString method, of class Queue.
     */
    @Test
    public void testToString() {
        //arrange
        PowerQueue<String> queue = new PowerQueue<>();
        String expectedString = "Alice, Jane";
        String returnedString;
        //act
        queue.addAndReturn("Alice").addAndReturn("Jane");
        returnedString = queue.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
