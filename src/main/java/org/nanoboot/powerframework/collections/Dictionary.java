
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
 * Represents dictionary data structure.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 * @param <T>
 */
public class Dictionary<T> {

    private int countOfItems = 0;

    private DictionaryNode<T> currentNode = null;
    private DictionaryNode<T> stopNode = null;

    private DictionaryNode<T> firstNode = null;
    private DictionaryNode<T> lastNode = null;

    private DictionaryNode<T> tempNode = null;
    private DictionaryNode<T> previousTempNode = null;

    /**
     *
     * @return size of this dictionary
     */
    public int getCountOfItems() {
        return countOfItems;
    }

    /**
     *
     * @return result of this control
     */
    public boolean isEmpty() {
        return getCountOfItems() == 0;
    }

    /**
     *
     * @param key
     * @return result of this control
     */
    public boolean containsValueWithKey(String key) {
        DictionaryKeyIterator dictionaryKeyIterator = this.getKeyIterator();
        boolean result = false;
        while (dictionaryKeyIterator.hasNext()) {
            if (dictionaryKeyIterator.getNextKey().equals(key)) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Add new dictionary entry.
     *
     * @param key
     * @param value
     * @return
     */
    public Dictionary<T> addValue(String key, T value) {

        DictionaryNode<T> nodeToAdd = new DictionaryNode<>(key, value);
        tempNode = lastNode;
        lastNode = nodeToAdd;
        if (isEmpty()) {
            firstNode = nodeToAdd;
        } else {
            tempNode.setNext(lastNode);
        }
        countOfItems++;
        return this;
    }

    /**
     * Return a dictionary entry with the given key.
     *
     * @param key
     * @return
     */
    public T getValue(String key) {
        moveCurrentNodeToTheNodeWithTheKey(key);

        return currentNode.getElement();

    }

    private void moveCurrentNodeToTheNodeWithTheKey(String key) {
        stopNode = stopNode == null ? firstNode : stopNode;
        currentNode = stopNode;

        while (!currentNodeIsAtTheEnd(key)) {

            if (currentNode.getNext() == null) {
                currentNode = firstNode;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        this.stopNode = currentNode;

        if (!currentNodeHasTheKey(key)) {
            throw new PowerRuntimeException("There is no element with key: " + key);
        }
    }

    private boolean currentNodeIsAtTheEnd(String key) {
        return (currentNodeHasTheKey(key)) || (currentNodeIsBeforeStopNode());
    }

    private boolean currentNodeHasTheKey(String key) {
        return currentNode.getKey().equals(key);
    }

    private boolean currentNodeIsBeforeStopNode() {
        if ((currentNode == lastNode) && (stopNode == firstNode)) {
            return true;
        }
        return currentNode.getNext() == stopNode;
    }

    /**
     * Updates the dictionary entry with the given key to the given value.
     *
     * @param key
     * @param value
     */
    public void updateValue(String key, T value) {
        moveCurrentNodeToTheNodeWithTheKey(key);
        currentNode.setElement(value);
    }

    /**
     * Removes the dictionary entry with the given key.
     *
     * @param key
     * @return dictionary
     */
    public Dictionary<T> removeValue(String key) {
        if (isEmpty()) {
            throw new PowerRuntimeException("This dictionary is empty. No dictionary entry can be removed.");
        }
        tempNode = firstNode;
        while ((!(tempNode.getKey().equals(key))) && (tempNode.getNext() != null)) {
            this.previousTempNode = tempNode;
            tempNode = tempNode.getNext();
        }
        if (!(tempNode.getKey().equals(key))) {
            throw new PowerRuntimeException("There is no key: " + key);
        } else if (tempNode == firstNode) {
            firstNode = firstNode.getNext();
        } else if (tempNode == lastNode) {
            lastNode = previousTempNode;
            lastNode.setNext(null);
        } else {
            this.previousTempNode.setNext(tempNode.getNext());
        }
        countOfItems--;
        return this;
    }

    /**
     *
     * @return KeyIterator for this dictionary
     */
    public DictionaryKeyIterator getKeyIterator() {
        return new DictionaryKeyIterator(firstNode);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DictionaryKeyIterator dictionaryKeyIterator = this.getKeyIterator();
        String key;
        T value;
        String valueAsString;
        final char colon = ':';
        final String newLine = "\n";

        while (dictionaryKeyIterator.hasNext()) {
            key = dictionaryKeyIterator.getNextKey();
            value = this.getValue(key);
            valueAsString = value.toString();
            stringBuilder.append(key);
            stringBuilder.append(colon);
            stringBuilder.append(valueAsString);
            stringBuilder.append(newLine);
        }
        return stringBuilder.toString();
    }
}
