
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

package org.nanoboot.powerframework.utils.collections;

import java.util.ArrayList;
import java.util.List;
import org.nanoboot.powerframework.utils.UtilsException;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class ListSplitter {
    private ListSplitter() {
        //Not meant to be instantiated.
    }
    public static <T> List<List<T>> splitListToSublists(List<T> inputList, int sizePerSublist) {
    if(sizePerSublist < 2) {
        throw new UtilsException("sizePerSublist is " + sizePerSublist + ", but it must be 2 or more.");
    }
    List<List<T>> outputList = new ArrayList<>();
    if(inputList.isEmpty()) {
        return outputList;
    }
    List<T> tmpList = null;
    for(int i = 0; i < inputList.size(); i++) {
        if(tmpList == null) {
            tmpList = new ArrayList<>();
        }
        T element = inputList.get(i);
        tmpList.add(element);
        if(tmpList.size() == sizePerSublist) {
            outputList.add(tmpList);
            tmpList = null;
        }
    }
    if(tmpList != null) {
        outputList.add(tmpList);
        tmpList = null;
    }
    return outputList;
}

 
    
}
