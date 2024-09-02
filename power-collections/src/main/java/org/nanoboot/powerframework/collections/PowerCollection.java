
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

import org.nanoboot.powerframework.core.PowerObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents map data structure. Values of type T are mapped to String and
 * searched by this String.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * @param <E> the type of items, this map will store.
 */
public class PowerCollection<E> extends PowerObject
        implements Collection<E> {

    /**
     * Constructor.
     * <p>
     * Constructor description
     *
     * @param items elements
     */
    public PowerCollection(final E... items) {
        for (E e : items) {
            add(e);
        }
    }
    /**
     * List, where are stored items of this map.
     */
    private final SingleLinkedList<E> list = new SingleLinkedList<>();
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(final Object o) {
        return list.contains(o);
    }

    private class CollectionIterator implements Iterator<E> {

        /**
         * Internal list.
         */
        private final SingleLinkedList<E> list;
        /**
         * Current index.
         */
        private int currentIndex = 0;

        CollectionIterator(final SingleLinkedList<E> listIn) {
            this.list = listIn;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = list.get(currentIndex);
            currentIndex++;
            return result;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new CollectionIterator(this.list);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(final T[] ts) {
        return (T[]) this.list.toArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(final E e) {
        return this.list.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(final Object o) {
        return this.list.remove(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(final Collection<?> collection) {
        for (Object e : collection) {
            if (!contains(e)) {
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
        for (Object e: collection) {
            collection.remove(e);
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        this.list.clear();
    }

    /**
     * Returns internal list.
     * @return internal list
     */
    protected SingleLinkedList<E> getInternalList() {
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return list.toString();
    }
    protected final boolean throwUnsupportedOperationException() {
        throw new UnsupportedOperationException();
    }
}
