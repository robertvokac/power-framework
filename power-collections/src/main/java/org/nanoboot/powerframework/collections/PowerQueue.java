
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
