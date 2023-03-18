
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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.powerframework.collections.internal.AbstractLinkedList;
import org.nanoboot.powerframework.core.exceptions.NotYetImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Represents linked list data structure.
 *
 * @param <E> The type of the values stored in this list.
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class SingleLinkedList<E> extends AbstractLinkedList<E>
        implements Collection<E> {
    /**
     * The reference to the first node of this list.
     */
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private SingleLinkedListNode<E> firstNode = null;
    /**
     * The reference to the last node of this list.
     */
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private SingleLinkedListNode<E> lastNode = null;

    /**
     * Iterator.
     *
     * @param <T> Node type
     */
    private static class SingleLinkedListIterator<T>
            implements Iterator<T> {
        /**
         * Current node.
         */
        @Getter(AccessLevel.PRIVATE)
        private SingleLinkedListNode<T> currentNode;

        /**
         * @param node start node
         */
        SingleLinkedListIterator(final SingleLinkedListNode<T> node) {
            this.currentNode = new SingleLinkedListNode<>(null);
            this.currentNode.setNext(node);
        }

        @Override
        public boolean hasNext() {
            return currentNode.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.currentNode = currentNode.getNext();
            return this.getCurrentNode().getValue();
        }
    }
    /**
     * Constructor
     *
     * Constructs an empty list.
     */
    public SingleLinkedList() {
    }

    /**
     * Constructor.
     *
     * Constructor description
     *
     * @param items elements
     */
    public SingleLinkedList(final E... items) {
        addAll(items);
    }
    ////
    /**
     * Setter for name.
     *
     * @param items elements
     */
    public void addAll(final E... items) {
        for (E element : items) {
            add(element);
        }
    }
    ////

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(final Object o) {
        for (E e : this) {
            if (e.hashCode() == o.hashCode()) {
                return true;
            }
        }
        return false;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Iterator<E> iterator() {
        return new SingleLinkedListIterator(this.getFirstNode());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        int index = 0;
        for (E e : this) {
            array[index] = e;
            index++;
        }
        return array;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T1> T1[] toArray(final T1[] t1s) {
        throw new NotYetImplementedException("No detail");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(final E e) {
        this.addAfterLast(e);
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(final Object o) {
        int index = 0;
        SingleLinkedListNode<E> nodeToRemove;
        SingleLinkedListNode<E> beforeNode;
        for (E e : this) {
            if (e.hashCode() == o.hashCode()) {
                remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(final Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        for (Object e :collection) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        for (E e : collection) {
            this.add(e);
        }
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(final Collection<?> collection) {
        for (Object e : collection) {
            remove(e);
        }
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(final Collection<?> collection) {
        throw new NotYetImplementedException("No detail");
    }
    /**
     * Clears this list.
     * All elements will be removed.
     */
    public void clear() {
        clearSize();
        firstNode = null;
        lastNode = null;
    }
    ////
    /**
     * Adds new element before first element.
     *
     * @param elementIn element
     * @return this linked list
     */
    public E addBeforeFirst(
            final E elementIn) {
        SingleLinkedListNode<E> oldRootNode = getFirstNode();
        SingleLinkedListNode<E> newRootNode =
                new SingleLinkedListNode<>(elementIn);
        SingleLinkedListNode.link(newRootNode, oldRootNode);
        setFirstNode(newRootNode);
        this.incrementSize();
        if (this.size() == 1) {
            setLastNode(getFirstNode());
        }
        return elementIn;
    }
    /**
     * Adds new element after last element.
     *
     * @param elementIn element
     * @return this linked list
     */
    public E addAfterLast(final E elementIn) {

        SingleLinkedListNode<E> oldLastNode = getLastNode();
        SingleLinkedListNode<E> newNode;
        newNode = new SingleLinkedListNode<>(elementIn);

        if (isEmpty()) {
            setFirstNode(newNode);
        } else {
            SingleLinkedListNode.link(oldLastNode, newNode);
        }
        setLastNode(newNode);
        this.incrementSize();

        return elementIn;
    }

    /**
     * Removes first element.
     *
     * @return removed element
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        SingleLinkedListNode<E> oldFirstNode = getFirstNode();
        SingleLinkedListNode<E> newFirstNode = oldFirstNode.getNext();
        E element = oldFirstNode.getValue();
        if (size() == 1) {
            clear();
            return element;
        }
        setFirstNode(newFirstNode);
        this.decrementSize();

        if (this.size() == 1) {
            setLastNode(getFirstNode());
        }
        return element;
    }

    /**
     * Removes last element.
     *
     * @return removed element
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = getLastNode().getValue();

        if (this.size() == 1) {
            clear();
        } else {
            SingleLinkedListNode<E> tempNode = getFirstNode();
            while (tempNode.getNext() != getLastNode()) {
                tempNode = tempNode.getNext();
            }
            SingleLinkedListNode<E> beforeLastNode = tempNode;
            beforeLastNode.unlinkNext();
            setLastNode(beforeLastNode);
            this.decrementSize();
        }

        return element;
    }

    /**
     * @return first element
     */
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getFirstNode().getValue();
    }

    /**
     * @return last element
     */
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getLastNode().getValue();
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index index param
     * @return the removed element
     */
    public E remove(final int index) {
        SingleLinkedListNode<E> node = getNodeByIndex(index);
        if (node.equals(getFirstNode())) {
            return removeFirst();
        }
        if (node.equals(getLastNode())) {
            return removeLast();
        }
        SingleLinkedListNode<E> beforeNode = getNodeByIndex(index - 1);
        beforeNode.setNext(node.getNext());
        decrementSize();
        return node.getValue();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index starting from 0
     *
     * @return value
     */
    public E get(final int index) {
        return getNodeByIndex(index).getValue();
    }

    private SingleLinkedListNode<E> getNodeByIndex(final int indexIn) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (indexIn > (size() - 1)) {
            throw new CollectionException(
                    "Index " + indexIn + " is out of bounds.");
        }
        int index = 0;
        SingleLinkedListNode<E> node = getFirstNode();
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
     * Replaces the element at the specified position
     * in this list with the specified element.
     *
     * @param index index param
     * @param element element param
     * @return the new value
     */
    public E set(final int index, final E element) {
        SingleLinkedListNode<E> node = getNodeByIndex(index);
        E originalValue = node.getValue();
        node.setValue(element);
        return originalValue;
    }
    @Override
    public final String toString() {
        String commaSpace = ", ";
        return toString(commaSpace);
    }

    /**
     * Creates a String representation of this list using the delimiter.
     * @param delimiter String delimiter
     * @return string representation of the list
     */
    public final String toString(final String delimiter) {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (E e : this) {
            sb.append(e);
            if (!delimiter.isEmpty()) {
                sb.append(delimiter);
            }
        }
        String result = sb.toString();
        result = result.substring(0, result.length() - delimiter.length());
        return result;
    }
}
