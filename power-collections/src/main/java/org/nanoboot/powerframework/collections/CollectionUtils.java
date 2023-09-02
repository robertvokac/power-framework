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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 2.0.0
 */
public class CollectionUtils {

    private CollectionUtils() {
        //Not meant to be instantiated.
    }

    public static <T> List<T> reverseList(List<T> list) {

        List<T> reversedList = new ArrayList<>();
        ListIterator<T> listIterator
                = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T t = listIterator.previous();
            reversedList.add(t);
        }
        return reversedList;

    }
}
