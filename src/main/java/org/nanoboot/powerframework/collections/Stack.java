
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

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Represents Stack- linear data structure.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 * @param <T> object
 */
public class Stack<T> implements Iterable<T> {

    private int total = 0;

    private Node first;

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {

        private T element;
        private Node next;
    }

    private class StackIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return pop();
        }
    }

    /**
     *
     * @return size of this stack
     */
    public int getCountOfItems() {
        return this.total;
    }

    /**
     *
     * @return true if this stack is empty, otherwise false
     */
    public boolean isEmpty() {
        return this.getCountOfItems() == 0;
    }

    /**
     * Pushes new element.
     *
     * @param element
     * @return pushed element
     */
    public Stack<T> push(T element) {
        Node current = first;
        first = new Node();
        first.element = element;
        first.next = current;
        total++;
        return this;
    }

    /**
     * Pops element.
     *
     * @return popped element
     */
    public T pop() {
        if (first == null) {
            throw new PowerRuntimeException("No such element");
        }
        T element = first.element;
        first = first.next;
        total--;
        return element;
    }

    /**
     *
     * @return the top element of this stack without removing this element
     */
    public T peek() {
        if (first == null) {
            throw new PowerRuntimeException("No such element");
        }
        return first.element;
    }
/**
 * Deletes all items of this stack.
 */
    public void clear() {
        total = 0;
        first = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.element).append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

}
