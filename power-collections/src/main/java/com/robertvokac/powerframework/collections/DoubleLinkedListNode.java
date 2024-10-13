
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

import lombok.Getter;
import lombok.Setter;
import com.robertvokac.powerframework.collections.internal.AbstractLinkedListNode;

/**
 * Represents one node of linked list.
 *
 * It is used to store a value based on the T.
 *
 * These nodes are linked (forward direction only).
 *
 * @param <E> The type of the value this node holds
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class DoubleLinkedListNode<E> extends AbstractLinkedListNode<E> {

    /**
     * Adds the reference for the node2 to the node1. The node1 will be
     * connected to the node2
     *
     * @param node1 The node, which field next will be set to node2.
     * @param node2 The node, which will be set as the next node of the node1
     */
    static void link(final DoubleLinkedListNode node1,
                     final DoubleLinkedListNode node2) {
        if (node1 != null) {
            node1.setNext(node2);
        }
        if (node2 != null) {
            node2.setPrevious(node1);
        }
    }
    /**
     * Reference for the previous node.
     */
    @Getter
    @Setter
    private DoubleLinkedListNode<E> previous = null;

    /**
     * Reference for the next node.
     */
    @Getter
    @Setter
    private DoubleLinkedListNode<E> next = null;

    /**
     * Constructor
     *
     * Used to create node without key (Key is empty String), used in linked
     * list, which does not need keys.
     *
     * @param valueIn the appropriate field key will be set by this value
     */
    DoubleLinkedListNode(final E valueIn) {
        this.setValue(valueIn);
    }

    /**
     * @param type type of the node to get
     * @return node by type
     */
    public DoubleLinkedListNode<E> getNodeByType(
            final DoubleLinkedListNodeReferenceType type) {
        if (type.isPrevious()) {
            return previous;
        } else {
            return next;
        }
    }

    /**
     * @param type type of the node to get
     * @param node to set
     */
    public void setNodeByType(
            final DoubleLinkedListNodeReferenceType type,
            final DoubleLinkedListNode<E> node) {
        if (type.isPrevious()) {
            setPrevious(node);
        } else {
            setNext(node);
        }
    }

    /**
     * Return true if this node has next node, otherwise false.
     *
     * @return boolean value
     */
    boolean hasPrevious() {
        return has(DoubleLinkedListNodeReferenceType.PREVIOUS);
    }

    /**
     * Return true if this node has next node, otherwise false.
     *
     * @return boolean value
     */
    boolean hasNext() {
        return has(DoubleLinkedListNodeReferenceType.NEXT);
    }
    /**
     * Return true if this node has node with this type, otherwise false.
     * @param type type of the node to get
     * @return boolean value
     */
    boolean has(final DoubleLinkedListNodeReferenceType type) {
        DoubleLinkedListNode<E> node = getNodeByType(type);
        return node != null;
    }

    /**
     * Removes the reference of the next node from this node.
     */
    void unlinkAll() {
        unlinkPrevious();
        unlinkNext();
    }

    /**
     * Removes the reference of the next node from this node.
     */
    void unlinkPrevious() {
        unlink(DoubleLinkedListNodeReferenceType.PREVIOUS);
    }

    /**
     * Removes the reference of the next node from this node.
     */
    void unlinkNext() {
        unlink(DoubleLinkedListNodeReferenceType.NEXT);
    }

    /**
     * Unlinks node.
     * @param type type of the node to unlink
     */
    void unlink(final DoubleLinkedListNodeReferenceType type) {
        setNodeByType(type, null);
    }
}
