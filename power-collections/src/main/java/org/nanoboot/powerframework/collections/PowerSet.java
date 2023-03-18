
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

import org.nanoboot.powerframework.collections.arrays.ObjectArray;
import org.nanoboot.powerframework.random.generators.RandomGenerator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Here goes the description of this class.
 * <p>
 * Set is unordered collection of values and contains no duplicates.
 *
 * @param <E> element type
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class PowerSet<E> extends PowerCollection<E> implements Set<E> {
    /**
     * Linked list, where are stored items of this queue.
     */
    private final SingleLinkedList<E> list = getInternalList();

    /**
     * Constructor.
     * <p>
     * Constructor description
     *
     * @param items elements
     */
    public PowerSet(final E... items) {
        super(items);
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(final E item) {
        if (contains(item)) {
            String msg = "Can't add item " + item
                    + ". This object is already stored in this set.";
            throw new CollectionException(msg);
        }
        return this.list.add(item);
    }

    /**
     * Returns random element of this Set.
     *
     * @return value
     */
    public E getRandom() {
        int index = RandomGenerator.getDefaultImplStatic()
                .nextInt(1, list.size());
        return list.get(index);
    }

    /**
     * @return iterator for this list
     */
    @Override
    public Iterator<E> iterator() {
        return new SetIterator(list);
    }

    /**
     * Iterator implementation.
     */
    private class SetIterator implements Iterator<E> {

        /**
         * Internal list.
         */
        private final SingleLinkedList<E> list;
        /**
         * Indexes.
         */
        private final SingleLinkedList<Integer> indexes;

        SetIterator(final SingleLinkedList<E> listIn) {
            this.list = listIn;
            this.indexes = new SingleLinkedList<>();

            for (int i = 0; i < list.size(); i++) {
                indexes.add(i);
            }
        }

        @Override
        public boolean hasNext() {
            return !indexes.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int randomArrayListIndexesListIndex = RandomGenerator
                    .getDefaultImplStatic().nextInt(0, indexes.size() - 1);
            int randomIndex = indexes.get(randomArrayListIndexesListIndex);
            E element = list.get(randomIndex);
            indexes.remove(randomArrayListIndexesListIndex);
            return element;
        }
    }

    /**
     * Creates object array.
     *
     * @return object array
     */
    public final ObjectArray<E> toObjectArray() {
        ObjectArray<E> objectArray = new ObjectArray<>(this.size());
        int index = 1;
        for (E element : this) {
            objectArray.set(element, index++);
        }
        return objectArray;
    }

}
