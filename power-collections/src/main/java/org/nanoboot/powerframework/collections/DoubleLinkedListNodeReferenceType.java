
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
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public enum DoubleLinkedListNodeReferenceType {
    /**
     * Previous node.
     */
    PREVIOUS,
    /**
     * Next node.
     */
    NEXT;

    /**
     * Checks the type.
     * @return true, if it the previous type, otherwise false.
     */
    public boolean isPrevious() {
        return this == PREVIOUS;
    }
    /**
     * Checks the type.
     * @return true, if it the next type, otherwise false.
     */
    public boolean isNext() {
        return this == NEXT;
    }
    /**
     * Returns the opposite reference.
     * @return opposite reference
     */
    public DoubleLinkedListNodeReferenceType opposite() {
        if (this.isPrevious()) {
            return NEXT;
        } else {
            return PREVIOUS;
        }
    }
}
