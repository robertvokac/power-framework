
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

package org.nanoboot.powerframework.view.layouts;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.nanoboot.powerframework.view.View;

/**
 * Represents a layout.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class SLayout extends GridPane {

    private final RowConstraints dataRowConstraint = new RowConstraints();

    /**
     * Constructor
     */
    public SLayout() {
        this.setSpacing(true);

        dataRowConstraint.setMinHeight(6 * View.getDpmm());
        dataRowConstraint.setMaxHeight(6 * View.getDpmm());
        dataRowConstraint.setValignment(VPos.CENTER);
    }

    /**
     *
     * @param value
     */
    public void setSpacing(boolean value) {
        if(value) {
            this.setVgap(3 * View.getDpmm());
            this.setHgap(3 * View.getDpmm());
            this.setPadding(new Insets(3 * View.getDpmm()));
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
     *
     * @return
     */
    public Node getNodeFromGridPane(GridPane gridPane,
            int col,
            int row) {
        for (Node node : gridPane.getChildren()) {
            if(GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
