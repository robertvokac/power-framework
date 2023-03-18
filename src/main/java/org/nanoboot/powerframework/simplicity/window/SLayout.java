
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

package org.nanoboot.powerframework.simplicity.window;

import org.nanoboot.powerframework.simplicity.Simplicity;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Represents a layout.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class SLayout extends GridPane {

    private final RowConstraints dataRowConstraint = new RowConstraints();

    /**
     * Constructor
     */
    public SLayout() {
        this.setSpacing(true);

        dataRowConstraint.setMinHeight(6 * Simplicity.getDpmm());
        dataRowConstraint.setMaxHeight(6 * Simplicity.getDpmm());
        dataRowConstraint.setValignment(VPos.CENTER);
    }

    /**
     *
     * @param value
     */
    public void setSpacing(boolean value) {
        if (value) {
            this.setVgap(3 * Simplicity.getDpmm());
            this.setHgap(3 * Simplicity.getDpmm());
            this.setPadding(new Insets(3 * Simplicity.getDpmm()));
        } else {
            this.setVgap(0);
            this.setHgap(0);
            this.setPadding(Insets.EMPTY);
        }
    }

    /**
     *
     * @return
     */
    public RowConstraints getDataRowConstraint() {
        return this.dataRowConstraint;
    }

    /**
     *
     * @param gridPane
     * @param col
     * @param row
     * @return
     */
    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
