
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

import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Is used to iterate entries through dictionary.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class DictionaryKeyIterator {

    private final DictionaryNode firstNode;
    private DictionaryNode currentNode;
    private boolean currentNodeIsNotFirst = false;

    DictionaryKeyIterator(DictionaryNode value) {
        this.firstNode = value;
        this.reset();
    }

    /**
     *
     * @return next key
     */
    public String getNextKey() {
        String key;
        if (firstNode == null) {
            throw new PowerRuntimeException("Dictionary is empty. There is no key.");
        }
        if ((currentNode == firstNode) && (!this.currentNodeIsNotFirst)) {
            key = currentNode.getKey();
            this.currentNodeIsNotFirst = true;
        } else {
            if (!hasNext()) {
                throw new PowerRuntimeException("There is no next key.");
            }
            this.currentNode = this.currentNode.getNext();
            key = currentNode.getKey();
        }
        return key;
    }

    /**
     *
     * @return true if there is a next key, otherwise false
     */
    public boolean hasNext() {
        if (this.firstNode == null) {
            return false;
        }
        if ((firstNode.getNext() == null) && (!currentNodeIsNotFirst)) {
            return true;
        }
        if ((firstNode.getNext() == null) && (currentNodeIsNotFirst)) {
            return false;
        }
        return this.currentNode.getNext() != null;
    }

    /**
     * Moves the current key to the first.
     */
    public void reset() {
        this.currentNode = this.firstNode;
        currentNodeIsNotFirst = false;
    }
}
