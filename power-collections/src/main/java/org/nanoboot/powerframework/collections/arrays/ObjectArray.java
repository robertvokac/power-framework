
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

package org.nanoboot.powerframework.collections.arrays;

/**
 * There will be the choice to select the starting index:0 will be default
 * (maybe), but 1 or something else will be possible.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * @param <C>
 */
public class ObjectArray<C> {

    private Array<C> array;

    public ObjectArray(int... lengthIn) {
        array = new Array<C>(ArrayType.OBJECT, lengthIn);
    }

    public static <C> ObjectArray ofValues(C... values) {
        ObjectArray<C> objectArray = new ObjectArray<>(values.length);
        int index = 1;
        for (C element : values) {
            objectArray.set(element, index++);
        }
        return objectArray;

    }
//    public ObjectArray(C... values) {
//        array = new Array<C>(values);
//    }

    public C get(int... index) {
        return array.getObject(index);
    }

    public void set(C value,
                    int... index) {
        array.setObject(value, index);
    }

    /**
     * @param dimension 1 or 2 or 3 or 4
     * @return
     */
    public int getLength(int dimension) {
        return this.array.getLength(dimension);
    }

    /**
     * @return
     */
    public int getLength() {
        return this.array.getLength();
    }
}
