
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

/**
 * Represents Stack- linear data structure.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
