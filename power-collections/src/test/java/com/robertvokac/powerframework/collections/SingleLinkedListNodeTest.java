
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

import static org.junit.Assert.*;

import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class SingleLinkedListNodeTest {

    /**
     * Test of link method, of class Node.
     */
    @Test
    public void link() {
        //arrange
        SingleLinkedListNode<String> node1 = new SingleLinkedListNode<>("John");
        SingleLinkedListNode<String> node2 = new SingleLinkedListNode<>("Black");
        String expectedString = "Black";
        String returnedString;
        //act
        SingleLinkedListNode.link(node1, node2);
        SingleLinkedListNode<String> returned = node1.getNext();
        returnedString = returned.getValue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getValue method, of class Node.
     */
    @Test
    public void getValue() {
        //arrange
        SingleLinkedListNode<String> node = new SingleLinkedListNode<>("John");
        String expectedString = "John";
        String returnedString;
        //act
        returnedString = node.getValue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of setValue method, of class Node.
     */
    @Test
    public void setValue() {
        //arrange
        SingleLinkedListNode<String> node = new SingleLinkedListNode<>("John");
        String expectedString = "Jack";
        String returnedString;
        //act
        node.setValue("Jack");
        returnedString = node.getValue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getNext method, of class Node.
     */
    @Test
    public void getNext() {
        //arrange
        SingleLinkedListNode<String> node1 = new SingleLinkedListNode<>("John");
        SingleLinkedListNode<String> node2 = new SingleLinkedListNode<>("Black");
        String expectedString = "Black";
        String returnedString;
        //act
        node1.setNext(node2);
        SingleLinkedListNode<String> returnedmapNode = node1.getNext();
        returnedString = returnedmapNode.getValue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of setNext method, of class Node.
     */
    @Test
    public void setNext() {
        //arrange
        SingleLinkedListNode<String> node1 = new SingleLinkedListNode<>("John");
        SingleLinkedListNode<String> node2 = new SingleLinkedListNode<>("White");
        String expectedString = "White";
        String returnedString;
        //act
        node1.setNext(node2);
        SingleLinkedListNode<String> returned = node1.getNext();
        returnedString = returned.getValue();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of hasNext method, of class Node.
     */
    @Test
    public void hasNext() {
        //arrange
        SingleLinkedListNode<String> node1 = new SingleLinkedListNode<>("John");
        //act

        //assert
        assertFalse(node1.hasNext());
    }

    /**
     * Test of hasNext method, of class Node.
     */
    @Test
    public void hasNext2() {
        //arrange
        SingleLinkedListNode<String> node1 = new SingleLinkedListNode<>("John");
        SingleLinkedListNode<String> node2 = new SingleLinkedListNode<>("White");
        //act
        node1.setNext(node2);
        //assert
        assertTrue(node1.hasNext());
    }

    /**
     * Test of unlinkNext method, of class Node.
     */
    @Test
    public void unlinkNext() {
        //arrange
        SingleLinkedListNode<String> node1 = new SingleLinkedListNode<>("John");
        SingleLinkedListNode<String> node2 = new SingleLinkedListNode<>("White");
        //act
        assertFalse(node1.hasNext());
        node1.setNext(node2);
        assertTrue(node1.hasNext());
        node1.unlinkNext();
        //assert
        assertFalse(node1.hasNext());
    }

}
