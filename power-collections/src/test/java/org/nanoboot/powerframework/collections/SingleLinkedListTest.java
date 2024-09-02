
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

import org.nanoboot.powerframework.core.exceptions.NotYetImplementedException;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class SingleLinkedListTest {
    @Test
    public void addAll_EVarArg() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();

        //act
        linkedList
                .addAll("a", "b", "c", "d", "e");
        //assert
        assertEquals(5, linkedList.size());
        assertEquals("a, b, c, d, e", linkedList.toString());
        assertEquals("a", linkedList.get(0));
        assertEquals("b", linkedList.get(1));
        assertEquals("c", linkedList.get(2));
        assertEquals("d", linkedList.get(3));
        assertEquals("e", linkedList.get(4));
    }

    @Test
    public void contains() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();

        //act
        linkedList
                .addAll("a", "b", "c", "d", "e");
        //assert
        assertTrue(linkedList.contains("a"));
        assertTrue(linkedList.contains("b"));
        assertTrue(linkedList.contains("c"));
        assertTrue(linkedList.contains("d"));
        assertTrue(linkedList.contains("e"));
        assertFalse(linkedList.contains("f"));
    }

    @Test
    public void iterator() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        StringBuilder sb = new StringBuilder();
        String expected = "12345";
        String returned;
        for (int i = 1; i <= 5; i++) {
            linkedList.add(String.valueOf(i));
        }
        //act
        for (String e : linkedList) {
            sb.append(e);
        }
        returned = sb.toString();
        //assert
        assertEquals(expected, returned);
    }

    @Test
    public void toArray_ObjectArray() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        StringBuilder sb = new StringBuilder();
        String expected = "12345";
        String returned;
        Object[] array;
        for (int i = 1; i <= 5; i++) {
            linkedList.add(String.valueOf(i));
        }
        //act
        array = linkedList.toArray();
        for (Object o : array) {
            sb.append(o);
        }
        returned = sb.toString();
        //assert
        assertEquals(5, array.length);
        assertEquals(expected, returned);
    }

    @Test(expected = NotYetImplementedException.class)
    public void toArray_genericArray() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();

        for (int i = 1; i <= 5; i++) {
            linkedList.add(String.valueOf(i));
        }
        //act
        linkedList.toArray(new Object[]{});
        //assert
    }

    @Test
    public void add() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        //assert
        linkedList.add("a");
        assertEquals(1, linkedList.size());
        assertEquals("a", linkedList.toString());
        linkedList.add("b");
        assertEquals(2, linkedList.size());
        assertEquals("a, b", linkedList.toString());
        linkedList.add("c");
        assertEquals(3, linkedList.size());
        assertEquals("a, b, c", linkedList.toString());
    }

    @Test
    public void remove_Object() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        //assert
        //abc
        assertEquals(3, linkedList.size());
        linkedList.remove("b");
        //ac
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains("b"));
        linkedList.add("d");
        //acd
        assertEquals(3, linkedList.size());
        assertTrue(linkedList.contains("d"));
        linkedList.remove("a");
        //cd
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains("a"));
        linkedList.remove("d");
        //c
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.contains("d"));
        assertTrue(linkedList.contains("c"));
        linkedList.remove("c");
        assertEquals(0, linkedList.size());
        assertFalse(linkedList.contains("c"));
        //
        assertEquals("", linkedList.toString());
    }

    @Test
    public void containsAll() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        //assert
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("a", "b", "c")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("b", "c")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("a", "c")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("a", "b")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("a")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("b")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>("c")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("a", "b", "c", "d")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("b", "c", "d")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("a", "c", "d")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("a", "b", "d")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("a", "d")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("b", "d")));
        assertFalse(linkedList.containsAll(new SingleLinkedList<>("c", "d")));
        assertTrue(linkedList.containsAll(new SingleLinkedList<>()));
    }

    @Test
    public void testAddAll_collection() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        linkedList.addAll(new SingleLinkedList<>("a", "b", "c"));
        //assert
        assertEquals(3, linkedList.size());
        assertEquals("a, b, c", linkedList.toString());
    }

    @Test
    public void removeAll() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        linkedList.addAll(new SingleLinkedList<>("a", "b", "c"));
        linkedList.removeAll(new SingleLinkedList<>("a", "c"));
        //assert
        assertEquals(1, linkedList.size());
        assertEquals("b", linkedList.toString());
        linkedList.removeAll(new SingleLinkedList<>("b"));
        assertEquals(0, linkedList.size());
        assertEquals("", linkedList.toString());
    }

    @Test(expected = NotYetImplementedException.class)
    public void retainAll() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        linkedList.addAll(new SingleLinkedList<>("a", "b", "c"));
        linkedList.retainAll(new SingleLinkedList<>("a", "c"));
        //assert
    }

    @Test
    public void clear() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        linkedList.addAll(new SingleLinkedList<>("a", "b", "c"));
        //assert
        assertEquals(3, linkedList.size());
        linkedList.clear();
        assertEquals(0, linkedList.size());
        assertEquals("", linkedList.toString());
        linkedList.add("d");
        assertEquals(1, linkedList.size());
        assertEquals("d", linkedList.toString());
        linkedList.add("e");
        assertEquals(2, linkedList.size());
        assertEquals("d, e", linkedList.toString());
        linkedList.clear();
        assertEquals(0, linkedList.size());
        assertEquals("", linkedList.toString());
    }

    //
    @Test
    public void addBeforeFirst() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();

        //act

        //assert
        linkedList.addBeforeFirst("a");
        assertEquals(1, linkedList.size());
        assertEquals("a", linkedList.toString());
        linkedList.addBeforeFirst("b");
        assertEquals(2, linkedList.size());
        assertEquals("b, a", linkedList.toString());
        linkedList.addBeforeFirst("c");
        assertEquals(3, linkedList.size());
        assertEquals("c, b, a", linkedList.toString());
    }

    @Test
    public void addAfterLast() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();

        //act

        //assert
        linkedList.addAfterLast("a");
        assertEquals(1, linkedList.size());
        assertEquals("a", linkedList.toString());
        linkedList.addAfterLast("b");
        assertEquals(2, linkedList.size());
        assertEquals("a, b", linkedList.toString());
        linkedList.addAfterLast("c");
        assertEquals(3, linkedList.size());
        assertEquals("a, b, c", linkedList.toString());
    }

    @Test
    public void removeFirst() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        String expectedString = "AnneJohnGeorgeKate";
        String returnedString;
        linkedList.addAfterLast("Jack")
        ;
        linkedList.addAfterLast("Anne")
        ;
        linkedList.addAfterLast("John")
        ;
        linkedList.addAfterLast("George")
        ;
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeFirst();
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : linkedList) {
            stringBuilder.append(element);
        }
        returnedString = stringBuilder.toString();
        //assert
        assertEquals(expectedString, returnedString);
        linkedList.removeFirst();
        assertEquals(3, linkedList.size());
        assertEquals("John, George, Kate", linkedList.toString());
    }

    @Test
    public void removeLast() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        String expectedString = "JackAnneJohnGeorge";
        String returnedString;
        linkedList.addAfterLast("Jack")
        ;
        linkedList.addAfterLast("Anne")
        ;
        linkedList.addAfterLast("John")
        ;
        linkedList.addAfterLast("George")
        ;
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeLast();
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : linkedList) {
            stringBuilder.append(element);
        }
        returnedString = stringBuilder.toString();
        //assert
        assertEquals(expectedString, returnedString);
        linkedList.removeLast();

        assertEquals(3, linkedList.size());
        assertEquals("Jack, Anne, John", linkedList.toString());
    }

    @Test
    public void getFirst() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        String expectedString = "Jack";
        String returnedString;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        returnedString = linkedList.getFirst();
        //assert
        assertEquals(expectedString, returnedString);
        linkedList.removeFirst();
        assertEquals("Anne", linkedList.getFirst());
        assertEquals("Anne, John, George, Kate", linkedList.toString());
    }

    @Test
    public void getLast() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        String expectedString = "George";
        String returnedString;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.addAfterLast("Mike");
        linkedList.addBeforeFirst("William");
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.removeFirst();
        linkedList.addAfterLast("Earl");
        linkedList.removeLast();
        linkedList.removeFirst();
        linkedList.removeLast();

        returnedString = linkedList.getLast();
        //assert
        assertEquals(expectedString, returnedString);
    }

    @Test
    public void remove_int() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act
        //assert
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        //abc
        assertEquals(3, linkedList.size());
        linkedList.remove(1);
        assertEquals("a, c", linkedList.toString());
        //ac
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains("b"));
        linkedList.add("d");
        assertEquals("a, c, d", linkedList.toString());
        //acd
        assertEquals(3, linkedList.size());
        assertTrue(linkedList.contains("d"));
        linkedList.remove(0);
        //cd
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains("a"));
        linkedList.remove(1);
        //c
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.contains("d"));
        assertTrue(linkedList.contains("c"));
        linkedList.remove(0);
        assertEquals(0, linkedList.size());
        assertFalse(linkedList.contains("c"));
        //
        assertEquals("", linkedList.toString());
    }

    @Test
    public void get() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act

        //assert
        assertEquals("Jack", linkedList.get(0));
        assertEquals("Anne", linkedList.get(1));
        assertEquals("John", linkedList.get(2));
        assertEquals("George", linkedList.get(3));
        assertEquals("Kate", linkedList.get(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void get2() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        //act

        //assert
        assertEquals("Jack", linkedList.get(0));

    }

    @Test(expected = CollectionException.class)
    public void get3() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.get(4);
        //assert
    }

    @Test
    public void set() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addAfterLast("a");
        linkedList.addAfterLast("b");
        linkedList.addAfterLast("c");
        linkedList.addAfterLast("d");
        linkedList.addAfterLast("e");
        //act

        //assert
        assertEquals("abcde", linkedList.toString(""));
        linkedList.set(2, "f");
        assertEquals("abfde", linkedList.toString(""));
        linkedList.set(3, "g");
        assertEquals("abfge", linkedList.toString(""));
        linkedList.set(0, "h");
        assertEquals("hbfge", linkedList.toString(""));
        linkedList.set(3, "i");
        assertEquals("hbfie", linkedList.toString(""));
        linkedList.set(1, "j");
        assertEquals("hjfie", linkedList.toString(""));
    }

    /**
     * Test of toString method, of class LinkedList.
     */
    @Test
    public void testToString() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        String expectedString = "Jack, Anne, John, George, Kate";
        String returnedString;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        returnedString = linkedList.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of toString method, of class LinkedList.
     */
    @Test
    public void testToString_2() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        String expectedString = "";
        String returnedString;
        //act
        returnedString = linkedList.toString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    //////

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_justCreatedInstanceShouldHaveCountZero() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 0;
        int returnedCountOfItems;
        //act
        returnedCountOfItems = linkedList.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountFive() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 5;
        int returnedCountOfItems;

        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        returnedCountOfItems = linkedList.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountFourAfterFirstRemoved() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 4;
        int returnedCountOfItems;

        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeFirst();
        returnedCountOfItems = linkedList.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountThreeAfterTwoFirstRemoved() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 3;
        int returnedCountOfItems;

        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeFirst();
        linkedList.removeFirst();
        returnedCountOfItems = linkedList.size();
        //assert
        assertEquals(expectedCountOfItems, returnedCountOfItems);
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountFourAfterLastRemoved() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 4;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeLast();
        //assert
        assertEquals(expectedCountOfItems, linkedList.size());
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountThreeAfterLastTwoRemoved() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 3;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeLast();
        linkedList.removeLast();
        //assert
        assertEquals(expectedCountOfItems, linkedList.size());
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountSixAfterAddedBeforeFirst() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 6;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        ;
        linkedList.addBeforeFirst("Mike");
        //assert
        assertEquals(expectedCountOfItems, linkedList.size());
    }

    /**
     * Test of getsize method, of class LinkedList.
     */
    @Test
    public void size_shouldHaveCountSixAfterAddedAfterLast() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        int expectedCountOfItems = 6;
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.addAfterLast("Mike");
        //assert
        assertEquals(expectedCountOfItems, linkedList.size());
    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    @Test
    public void isEmpty_justCreatedInstanceShouldBeEmpty() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        boolean returnedValue;
        //act
        returnedValue = linkedList.isEmpty();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    @Test
    public void isEmpty_linkedListShouldHaveFiveItemsAndShouldNotBeEmpty() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        //assert
        assertFalse(linkedList.isEmpty());
    }

    /**
     * Test of addBeforeFirst method, of class LinkedList.
     */
    @Test
    public void isEmpty_countWasFive_fiveItemsWasRemoved_shouldBeEmpty_1() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeFirst();
        linkedList.removeLast();
        //assert
        assertTrue(linkedList.isEmpty());
    }

    /**
     * Test of addBeforeFirst method, of class LinkedList.
     */
    @Test
    public void isEmpty_countWasFive_fiveItemsWasRemoved_shouldBeEmpty_2() {
        //arrange
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addAfterLast("Jack");
        linkedList.addAfterLast("Anne");
        linkedList.addAfterLast("John");
        linkedList.addAfterLast("George");
        linkedList.addAfterLast("Kate");
        //act
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeFirst();
        linkedList.removeFirst();
        //assert
        assertTrue(linkedList.isEmpty());
    }

}
