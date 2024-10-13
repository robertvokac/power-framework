
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
import com.robertvokac.powerframework.collections.internal.AbstractTreeNode;

/**
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 * @param <T>
 */
public final class TreeNode<T> extends AbstractTreeNode<T> {
    /**
     * Children nodes.
     */
    @Getter
    @Setter
    private PowerList<TreeNode<T>> children = new PowerList<>();
    /**
     *
     */
    private boolean ableToHaveChildren = true;

    /**
     *
     */
    public TreeNode() {
    }

    /**
     *
     * @param valueIn the value
     */
    public TreeNode(final T valueIn) {
        this.setValue(valueIn);
    }

    /**
     *
     * @param valueIn value
     * @param childIn child
     */
    public TreeNode(final T valueIn, final TreeNode<T> childIn) {
        this.setValue(valueIn);
        addChild(childIn);
    }

    /**
     * @param valueIn value
     * @param childrenIn children
     */
    public TreeNode(final T valueIn, final TreeNode<T>... childrenIn) {
        this.setValue(valueIn);
        addChildren(childrenIn);
    }

    /**
     *
     * @param childIn child to add
     */
    public void addChild(final TreeNode<T> childIn) {
        getChildren().add(childIn);
        childIn.setParent(this);
    }

    /**
     *
     * @param childrenIn children to add
     */
    public void addChildren(final TreeNode<T>... childrenIn) {
        for (TreeNode<T> element : childrenIn) {
            addChild(element);
        }
    }
    /**
     *
     * @return true, if this node has some children, otherwise false
     */
    public boolean hasChildren() {
        return !getChildren().isEmpty();
    }

}
