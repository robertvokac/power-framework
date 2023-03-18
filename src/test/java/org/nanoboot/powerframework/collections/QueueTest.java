
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
public class QueueTest {

    /**
     *
     */
    public QueueTest() {
    }

    /**
     * Test of getCountOfItems method, of class Queue.
     */
    @Test
    public void testGetCountOfItems() {
        //arrange
        Queue<String> queue = new Queue<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        returnedCountOfItems = queue.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Queue.
     */
    @Test
    public void testGetCountOfItems2() {
        //arrange
        Queue<String> queue = new Queue<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        queue.enqueue("John");
        queue.dequeue();
        returnedCountOfItems = queue.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Queue.
     */
    @Test
    public void testGetCountOfItems3() {
        //arrange
        Queue<String> queue = new Queue<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        queue.enqueue("John");
        queue.dequeue();
        queue.enqueue("Jack").enqueue("Anne").enqueue("Charlie");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Jane");
        queue.dequeue();
        returnedCountOfItems = queue.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Queue.
     */
    @Test
    public void testGetCountOfItems4() {
        //arrange
        Queue<String> queue = new Queue<>();
        int expectedCountOfItems = 1;
        int returnedCountOfItems;
        //act
        queue.enqueue("John");
        queue.dequeue();
        queue.enqueue("Jack").enqueue("Anne").enqueue("Charlie");

        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Jane");
        queue.dequeue();
        returnedCountOfItems = queue.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getCountOfItems method, of class Queue.
     */
    @Test
    public void testGetCountOfItems5() {
        //arrange
        Queue<String> queue = new Queue<>();
        int expectedCountOfItems = 3;
        int returnedCountOfItems;
        //act
        queue.enqueue("John");
        queue.dequeue();
        queue.enqueue("Jack").enqueue("Anne").enqueue("Charlie").enqueue("Susan");

        queue.dequeue();
        queue.enqueue("Jane");
        queue.dequeue();
        returnedCountOfItems = queue.getCountOfItems();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        Queue<String> queue = new Queue<>();
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
        Queue<String> queue = new Queue<>();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        queue.enqueue("John").enqueue("Jack").enqueue("Anne").enqueue("Charlie");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue("Jane");
        queue.dequeue();
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
        Queue<String> queue = new Queue<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        queue.enqueue("John").enqueue("Jack").enqueue("Anne").enqueue("Charlie");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue("Jane");
        queue.dequeue();
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
        Queue<String> queue = new Queue<>();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        queue.enqueue("John").enqueue("Jack").enqueue("Anne").enqueue("Charlie");

        queue.dequeue();
        queue.dequeue();

        queue.enqueue("Jane");
        queue.dequeue();
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
        Queue<String> queue = new Queue<>();
        String expectedString = "John";
        String returnedString;
        //act
        queue.enqueue("John");
        returnedString = queue.dequeue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue() {
        //arrange
        Queue<String> queue = new Queue<>();
        String expectedString = "Alice";
        String returnedString;
        //act
        queue.enqueue("Alice").enqueue("Jane");
        returnedString = queue.dequeue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue_ThereShouldBeThrownPowerRuntimeException() {
        //arrange
        boolean isExceptionThrown = false;
        Queue<String> queue = new Queue<>();
        //act
        try {
            queue.dequeue();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of toString method, of class Queue.
     */
    @Test
    public void testToString() {
        //arrange
        Queue<String> queue = new Queue<>();
        String expectedString = "Alice, Jane, ";
        String returnedString;
        //act
        queue.enqueue("Alice").enqueue("Jane");
        returnedString = queue.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
