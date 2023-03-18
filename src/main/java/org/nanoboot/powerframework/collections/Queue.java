
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

/**
 * Represents Queue- linear data structure.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 * @param <T> object
 */
public class Queue<T> {

    private int total;

    private Node first;
    private Node last;

    private class Node {

        private T element;
        private Node next;
    }

    /**
     *
     * @return size of this queue
     */
    public int getCountOfItems() {
        return this.total;
    }

    /**
     *
     * @return true if this queue is empty, otherwise false
     */
    public boolean isEmpty() {
        return this.getCountOfItems() == 0;
    }

    /**
     * Enqueues new element.
     *
     * @param element
     * @return new element
     */
    public Queue<T> enqueue(T element) {
        Node current = last;
        last = new Node();
        last.element = element;

        if (total++ == 0) {
            first = last;
        } else {
            current.next = last;
        }

        return this;
    }

    /**
     * Dequeues element.
     *
     * @return removed element
     */
    public T dequeue() {
        if (total == 0) {
            throw new PowerRuntimeException("No such element");
        }
        T ele = first.element;
        first = first.next;
        if (--total == 0) {
            last = null;
        }
        return ele;
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
