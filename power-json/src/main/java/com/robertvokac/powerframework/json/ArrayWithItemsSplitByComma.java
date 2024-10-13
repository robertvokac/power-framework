
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

package com.robertvokac.powerframework.json;

import java.util.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
