
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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class PowerList<E> extends PowerCollection<E> implements List<E> {
    /**
     * Linked list, where are stored items of this queue.
     */
    private final SingleLinkedList<E> list = getInternalList();
    /**
     * Constructor.
     *
     * Constructs an empty list.
     */
    public PowerList() {
    }

    /**
     * Constructor.
     *
     * Constructor description
     *
     * @param items elements
     */
    public PowerList(final E... items) {
        super(items);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(
            final int i, final Collection<? extends E> collection) {
        return throwUnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E get(final int i) {
        return list.get(i);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E set(final int i, final E e) {
        list.set(i, e);
        return e;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final int i, final E e) {
        throwUnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E remove(final int i) {
        return list.remove(i);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(final Object o) {
        throwUnsupportedOperationException();
        return 0;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int lastIndexOf(final Object o) {
        throwUnsupportedOperationException();
        return 0;
    }

    private class PowerListIterator<E> implements ListIterator<E> {
        /**
         * Internal iterator.
         */
        private final Iterator<E> iterator;

        PowerListIterator(final Iterator<E> iteratorIn) {
            this.iterator = iteratorIn;
        }
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next();
        }

        @Override
        public boolean hasPrevious() {
            throwUnsupportedOperationException();
            return true;
        }

        @Override
        public E previous() {
            throwUnsupportedOperationException();
            return null;
        }

        @Override
        public int nextIndex() {
            throwUnsupportedOperationException();
            return 0;
        }

        @Override
        public int previousIndex() {
            throwUnsupportedOperationException();
            return 0;
        }

        @Override
        public void remove() {
            throwUnsupportedOperationException();

        }

        @Override
        public void set(final E e) {
            throwUnsupportedOperationException();

        }

        @Override
        public void add(final E e) {

        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator() {
        return new PowerListIterator<>(this.iterator());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator(final int i) {
        throwUnsupportedOperationException();
        return null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> subList(final int i, final int i1) {
        throwUnsupportedOperationException();
        return null;
    }
}
