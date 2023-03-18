
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

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.nanoboot.powerframework.PowerRuntimeException;
import org.nanoboot.powerframework.simplicity.Simplicity;

/**
 *
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class CellLayout extends AnchorPane {

    private static final RowConstraints dataRowConstraint = new RowConstraints();
    private static final String PERCENT = "%";
    private static final String MM = "mm";

    private final GridPane gridPane = new GridPane();

    static {
        dataRowConstraint.setMinHeight(6 * Simplicity.getDpmm());
        dataRowConstraint.setMaxHeight(6 * Simplicity.getDpmm());
        dataRowConstraint.setValignment(VPos.CENTER);
    }

    private final int rows;
    private final int columns;

    /**
     *
     * @param rows
     * @param columns
     * @param columnConstraintsString
     */
    public CellLayout(int columns, int rows, String columnConstraintsString) {
        this.getChildren().add(gridPane);

        AnchorPane.setTopAnchor(gridPane, 0d);
        AnchorPane.setRightAnchor(gridPane, 0d);
        AnchorPane.setBottomAnchor(gridPane, 0d);
        AnchorPane.setLeftAnchor(gridPane, 0d);

        this.columns = columns;
        setColumnConstraints(columnConstraintsString);

        this.rows = rows;
        setRowConstraints();

        this.setSpacing(true);
        this.setWidth(Double.MAX_VALUE);
    }

    private void setRowConstraints() {
        List list = new ArrayList<RowConstraints>();
        for (int i = 1; i <= rows; i++) {
            list.add(dataRowConstraint);
        }
        gridPane.getRowConstraints().addAll(list);
    }

    private void setColumnConstraints(String columnConstraintsString) {
        String[] columnConstraint = columnConstraintsString.split("\\s+");
        List list = new ArrayList<ColumnConstraints>();
        for (String element : columnConstraint) {
            int number;
            ColumnConstraints tempColumnConstraints = new ColumnConstraints();
            if (element.endsWith(PERCENT)) {
                number = Integer.parseInt(element.substring(0, element.length() - 1));
                tempColumnConstraints.setPercentWidth(number);
            } else if (element.endsWith(MM)) {
                number = Integer.parseInt(element.substring(0, element.length() - 2));
                double mmLenght = number * Simplicity.getDpmm();
                tempColumnConstraints.setMaxWidth(mmLenght);
                tempColumnConstraints.setMinWidth(mmLenght);
            } else {
                throw new PowerRuntimeException("Column constraint string is not valid. " + element + " is not valid.");
            }
            list.add(tempColumnConstraints);
        }
        gridPane.getColumnConstraints().addAll(list);
    }

    /**
     *
     * @param node
     * @param column from 1
     * @param row from 1
     */
    public void addNode(Node node, int column, int row) {
        gridPane.add(node, column - 1, row - 1);
    }

    /**
     *
     * @param node
     * @param column from 1
     * @param row from 1
     * @param columnSpan
     * @param rowSpan
     */
    public void addNode(Node node, int column, int row, int columnSpan, int rowSpan) {
        gridPane.add(node, column - 1, row - 1, columnSpan, rowSpan);
    }

    /**
     * Adds collection of nodes.
     *
     * @param row starting from 1
     * @param nodes
     */
    public void addNodes(int row, Node... nodes) {
        gridPane.addRow(row - 1, nodes);
    }

    /**
     *
     * @param value
     */
    public void setSpacing(boolean value) {
        if (value) {
            gridPane.setVgap(3 * Simplicity.getDpmm());
            gridPane.setHgap(3 * Simplicity.getDpmm());
            gridPane.setPadding(new Insets(3 * Simplicity.getDpmm()));
        } else {
            gridPane.setVgap(0);
            gridPane.setHgap(0);
            gridPane.setPadding(Insets.EMPTY);
        }
    }

    /**
     *
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     *
     * @return
     */
    public int getColumns() {
        return columns;
    }

    /**
     *
     * @param col
     * @param row
     * @return
     */
    public Node getNodeFromGridPane(int col, int row) {
        for (Node node : this.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
