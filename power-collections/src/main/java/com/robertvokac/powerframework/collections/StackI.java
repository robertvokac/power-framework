
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
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public interface StackI<E> {

    /**
     * Pushes new element.
     * @param item element to add
     * @return element to add
     */
    E push(E item);

    /**
     * Pops element.
     * Remove first element.
     * @return element to remove
     */
    E pop();
    /**
     * Returns the top element of this stack without removing this element.
     * @return the top element of this stack without removing this element
     */
    E peek();

    /**
     * Checks, if the stack is empty.
     * @return true, if this stack is empty, otherwise false
     */
    boolean isEmpty();
}
