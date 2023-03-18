
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

/**
 * Represents Stack- linear data structure.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * @param <E> object
 */
public class PowerStack<E> extends PowerCollection<E> implements StackI<E> {

    /**
     * Linked list, where are stored items of this queue.
     */
    private final SingleLinkedList<E> list = getInternalList();
    /**
     * {@inheritDoc}
     */
    @Override
    public E push(final E item) {
        list.addBeforeFirst(item);
        return item;
    }

    /**
     * Pushes and returns.
     * @param item element to push
     * @return this
     */
    public PowerStack<E> pushAndReturn(final E item) {
        push(item);
        return this;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        return list.getFirst();
    }
}
