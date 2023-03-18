
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

package org.nanoboot.powerframework.json;

import java.util.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class ArrayWithItemsSplitByComma {

    /**
     * Returns list of indexes of commas for the given indentation and the given
     * String
     *
     * @param itemsSplitByComma
     * @return
     */
    static ArrayList<String> getListWithItemsSplitByComma(
            String itemsSplitByComma) {
        ArrayWithItemsSplitByComma arrayWithItemsSplitByComma = new ArrayWithItemsSplitByComma(itemsSplitByComma);
        return arrayWithItemsSplitByComma.arrayList;
    }

    private final ArrayList<String> arrayList = new ArrayList<>();

    private ArrayWithItemsSplitByComma(final String itemsSplitByComma) {
        ArrayList<Integer> listOfCommas = CommasFinder.getListOfIndexesOfCommas(itemsSplitByComma);
        int beginIndex = 0;
        int endIndex;
        for (int element : listOfCommas) {
            endIndex = element;
            arrayList.add(itemsSplitByComma.substring(beginIndex, endIndex).trim());
            beginIndex = ++endIndex;
        }
        endIndex = itemsSplitByComma.length();
        arrayList.add(itemsSplitByComma.substring(beginIndex, endIndex).trim());
    }

}
