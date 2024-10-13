
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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import com.robertvokac.powerframework.collections.internal.AbstractLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents double linked list data structure
 * TODO !!!
 *
 * @param <E> The type of the values stored in this list.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class DoubleLinkedList<E> extends AbstractLinkedList<E>
        implements Iterable<E> {
//https://www.javatpoint.com/doubly-linked-list
//https://www.studytonight.com/data-structures/doubly-linked-list
//https://www.geeksforgeeks.org/doubly-linked-list/
//https://www.tutorialspoint.com/data_structures_algorithms/doubly_linked_list_algorithm.htm

    /**
     * The reference to the first node of this list.
     */
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private DoubleLinkedListNode<E> firstNode = null;
    /**
     * The reference to the last node of this list.
     */
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private DoubleLinkedListNode<E> lastNode = null;

    /**
     * Iterator.
     *
     * @param <E> Node type
     */
    private class DoubleLinkedListIterator<E>
            implements Iterator<E> {
        /**
         * Current node.
         */
        @Getter(AccessLevel.PRIVATE)
        private DoubleLinkedListNode<E> currentNode;

        /**
         * @param node start node
         */
        DoubleLinkedListIterator(final DoubleLinkedListNode<E> node) {
            this.currentNode = new DoubleLinkedListNode<>(null);
            this.currentNode.setNext(node);
        }

        @Override
        public boolean hasNext() {
            return currentNode.hasNext();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.currentNode = currentNode.getNext();
            return this.getCurrentNode().getValue();
        }
    }

    /**
     * Iterator. Iterates from end to start.
     *
     * @param <E> Node type
     */
    private class ReversDoubleLinkedListIterator<E>
            implements Iterator<E> {
        /**
         * Current node.
         */
        @Getter(AccessLevel.PRIVATE)
        private DoubleLinkedListNode<E> currentNode;

        /**
         * @param lastNodeIn end node
         */
        ReversDoubleLinkedListIterator(
                final DoubleLinkedListNode<E> lastNodeIn) {
            this.currentNode = new DoubleLinkedListNode<>(null);
            this.currentNode.setPrevious(lastNodeIn);
        }

        @Override
        public boolean hasNext() {
            return currentNode.hasPrevious();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.currentNode = currentNode.getPrevious();
            return this.getCurrentNode().getValue();
        }
    }

    /**
     * @return iterator for this list
     */
    @Override
    public Iterator<E> iterator() {
        return new DoubleLinkedListIterator(this.firstNode);
    }

    /**
     * @return reverse iterator for this list
     */
    public Iterator<E> reverseIterator() {
        return new ReversDoubleLinkedListIterator(this.firstNode);
    }

    /**
     * Deletes all elements of this linked list.
     */
    public void clear() {
        clearSize();
        firstNode = null;
        lastNode = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E addBeforeFirst(final E elementIn) {
        DoubleLinkedListNode<E> oldFirstNode = getFirstNode();
        DoubleLinkedListNode<E> newFirstNode =
                new DoubleLinkedListNode<>(elementIn);
        DoubleLinkedListNode.link(newFirstNode, oldFirstNode);
        setFirstNode(newFirstNode);
        this.incrementSize();
        return elementIn;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E addAfterLast(final E elementIn) {
        DoubleLinkedListNode<E> oldLastNode = getLastNode();
        DoubleLinkedListNode<E> newLastNode =
                new DoubleLinkedListNode<>(elementIn);

        setLastNode(newLastNode);

        if (isEmpty()) {
            setFirstNode(getLastNode());
        } else {
            DoubleLinkedListNode.link(oldLastNode, newLastNode);
        }

        this.incrementSize();

        return elementIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DoubleLinkedListNode<E> oldFirstNode = getFirstNode();
        DoubleLinkedListNode<E> newFirstNode = oldFirstNode.getNext();
        E element = oldFirstNode.getValue();
        if (size() == 1) {
            clear();
            return element;
        }
        setFirstNode(newFirstNode);
        this.incrementSize();

        if (this.size() == 1) {
            setLastNode(getFirstNode());
        }
        newFirstNode.unlinkPrevious();
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = getLastNode().getValue();

        if (this.size() == 1) {
            clear();
            return element;
        }
        DoubleLinkedListNode<E> beforeLastNode = getLastNode().getPrevious();
        beforeLastNode.unlinkNext();
        setLastNode(beforeLastNode);
        this.decrementSize();


        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return firstNode.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return lastNode.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove(final int index) {
        DoubleLinkedListNode<E> node = getNodeByIndex(index);
        if (node.equals(getFirstNode())) {
            return removeFirst();
        }
        if (node.equals(getLastNode())) {
            return removeLast();
        }
        DoubleLinkedListNode beforeNode = node.getPrevious();
        DoubleLinkedListNode.link(beforeNode, node.getNext());
        return node.getValue();
    }

    private DoubleLinkedListNode<E> getNodeByIndex(final int indexIn) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (indexIn > (size() - 1)) {
            throw new CollectionException(
                    "Index " + indexIn + " is out of bounds.");
        }
        int index = 0;
        DoubleLinkedListNode<E> node = getFirstNode();
        while (node != null) {
            if (index == indexIn) {
                return node;
            }
            node = node.getNext();
            index++;
        }
        return null;
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index starting from 1
     *
     * @return value
     */
    public E get(final int index) {
        return getNodeByIndex(index).getValue();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E set(final int index, final E element) {
        getNodeByIndex(index).setValue(element);
        return element;
    }
}
