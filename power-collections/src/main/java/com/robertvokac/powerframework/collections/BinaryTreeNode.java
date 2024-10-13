
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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import com.robertvokac.powerframework.collections.internal.AbstractTreeNode;

/**
 *
 * @param <T>
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public final class BinaryTreeNode<T> extends AbstractTreeNode<T> {
    /**
     * Left node.
     */
    @Getter
    private BinaryTreeNode<T> left = null;
    /**
     * Right node.
     */
    @Getter
    private BinaryTreeNode<T> right = null;
    /**
     * Type of the node.
     *
     */
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private BinaryTreeNodeType type = BinaryTreeNodeType.UNDEFINED;
    /**
     *
     */
    public BinaryTreeNode() {
    }

    /**
     *
     * @param valueIn the value
     */
    public BinaryTreeNode(final T valueIn) {
        this.setValue(valueIn);
    }

    /**
     *
     * @param valueIn value
     * @param leftIn left child
     * @param rightIn right child
     */
    public BinaryTreeNode(
            final T valueIn,
            final BinaryTreeNode<T> leftIn,
            final BinaryTreeNode<T> rightIn) {
        this(valueIn);
        this.setLeft(leftIn);
        this.setRight(rightIn);
    }

    /**
     *
     * @param valueIn value
     * @param typeIn type of node
     * @param nodeIn node to add
     */
    public BinaryTreeNode(
            final T valueIn,
            final BinaryTreeNodeType typeIn,
            final BinaryTreeNode<T> nodeIn) {
        this(valueIn);
        this.setNode(typeIn, nodeIn);
    }


    /**
     * @param typeIn node type
     * @return
     */
    public BinaryTreeNode<T> getNode(
            final BinaryTreeNodeType typeIn) {
        switch (typeIn) {
            case LEFT: return getLeft();
            case RIGHT: return getRight();
            default:
                String msg = "Unsupported "
                        + BinaryTreeNode.class.getName() + type;
                throw new CollectionException(msg);
        }
    }
    /**
     *
     * @param node left node to add
     */
    public void setLeft(final BinaryTreeNode<T> node) {
        setNode(BinaryTreeNodeType.LEFT, node);
    }
    /**
     *
     * @param node left node to add
     */
    public void setRight(final BinaryTreeNode<T> node) {
        setNode(BinaryTreeNodeType.RIGHT, node);
    }
    /**
     * @param typeIn node type
     * @param nodeIn node to set
     */
    public void setNode(
            final BinaryTreeNodeType typeIn,
            final BinaryTreeNode<T> nodeIn) {
        switch (typeIn) {
            case LEFT: this.left = nodeIn; break;
            case RIGHT: this.right = nodeIn; break;
            default:
                String msg = "Unsupported "
                        + BinaryTreeNode.class.getName() + type;
                throw new CollectionException(msg);
        }
        nodeIn.setParent(this);
    }
    /**
     *
     * @return true, if this node has left node, otherwise false
     */
    public boolean hasLeft() {
        return hasNode(BinaryTreeNodeType.LEFT);
    }
    /**
     *
     * @return true, if this node has right node, otherwise false
     */
    public boolean hasRight() {
        return hasNode(BinaryTreeNodeType.RIGHT);
    }
    /**
     * @param typeIn node type
     * @return
     */
    public boolean hasNode(
            final BinaryTreeNodeType typeIn) {
        BinaryTreeNode<T> node = getNode(typeIn);
        return node != null;
    }
    /**
     * @param type node type
     * @return true, if this node has right node, otherwise false
     */
    public boolean has(final BinaryTreeNodeType type) {
        return getRight() != null;
    }


}
