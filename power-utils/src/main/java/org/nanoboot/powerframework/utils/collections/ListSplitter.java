
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
