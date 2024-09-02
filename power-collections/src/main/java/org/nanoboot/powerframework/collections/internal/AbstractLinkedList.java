
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

package org.nanoboot.powerframework.collections.internal;

import org.nanoboot.powerframework.collections.arrays.ObjectArray;

/**
 * Represents linked list data structure.
 * @param <E> element type
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class AbstractLinkedList<E> implements Iterable<E>  {
    /**
     * Size of this list.
     */
    private int size = 0;

    /**
     * Returns size of this list.
     * @return size of this list
     */
    public final int size() {
        return this.size;
    }
    /**
     * Checks, if this list is empty.
     * @return true, if this list is empty, otherwise false
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
    /**
     * Deletes all elements of this linked list.
     */
    public abstract void clear();
    /**
     * Increments the size of this list by one.
     */
    protected void incrementSize() {
        ++size;
    }

    /**
     * Decrements the size of this list by one.
     */
    protected void decrementSize() {
        --size;
    }

    /**
     * Sets the size to 0.
     */
    protected void clearSize() {
        size = 0;
    }
    /**
     * Adds new element before first element.
     *
     * @param elementIn element
     * @return this linked list
     */
    public abstract E addBeforeFirst(E elementIn);

    /**
     * Adds new element after last element.
     *
     * @param elementIn element
     * @return this linked list
     */
    public abstract E addAfterLast(E elementIn);
    /**
     * Removes first element.
     *
     * @return removed element
     */
    public abstract E removeFirst();

    /**
     * Removes last element.
     *
     * @return removed element
     */
    public abstract E removeLast();
    /**
     * @return first element
     */
    public abstract E getFirst();

    /**
     * @return last element
     */
    public abstract E getLast();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index index param
     * @return the removed element
     */
    public abstract E remove(int index);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index starting from 1
     *
     * @return value
     */
    public abstract E get(int index);

    /**
     * Replaces the element at the specified position
     * in this list with the specified element.
     *
     * @param index index param
     * @param element element param
     * @return the new value
     */
    public abstract E set(int index, E element);

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int lastIndex = this.size() - 1;
        for (E element : this) {
            stringBuilder.append(element.toString());
            if (index < lastIndex) {
                stringBuilder.append(", ");
            }
            ++index;
        }
        return stringBuilder.toString();
    }
    /**
     * Converts this list to an ObjectArray.
     * @return ObjectArray
     */
    public ObjectArray<E> toObjectArray() {
        ObjectArray<E> objectArray = new ObjectArray<>(this.size());
        int index = 1;
        for (E element : this) {
            objectArray.set(element, index++);
        }
        return objectArray;
    }

}
