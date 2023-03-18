
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
import java.util.Queue;

/**
 * Represents Queue- linear data structure.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * @param <E> object
 */
public class PowerQueue<E> extends PowerCollection<E> implements Queue<E> {

    /**
     * Linked list, where are stored items of this queue.
     */
    private final SingleLinkedList<E> list = getInternalList();
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean offer(final E e) {
        return add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove() {
        return list.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E poll() {
        return list.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E element() {
        return list.getFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    /**
     * Adds and returns.
     * @param item element to add
     * @return this
     */
    public PowerQueue<E> addAndReturn(final E item) {
        add(item);
        return this;
    }

}
