
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

package org.nanoboot.powerframework.simplicity.boxes;

import org.nanoboot.powerframework.simplicity.window.SLayout;
import org.nanoboot.powerframework.simplicity.Simplicity;
import org.nanoboot.powerframework.simplicity.window.Window;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;

/**
 * Represents a box- a window used to give information to user.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 */
abstract class Box extends Window {

    protected String titleText;
    protected String text;
    protected StackPane icon = new StackPane();
    protected StackPane icon2 = new StackPane();
    protected SLayout gridLayout = new SLayout();
    Circle circle = new Circle(6 * Simplicity.getDpmm());
    protected StackPane placeForButtons = new StackPane();

    Box(String titleText, String text) {
        initModality(Modality.APPLICATION_MODAL);
        this.setWindowTitle(titleText);
        this.text = text;

        this.setCloseable(false);
        this.showOnlyTheCloseButton();

        RowConstraints rc2 = new RowConstraints();
        rc2.setMinHeight(12 * Simplicity.getDpmm());
        rc2.setMaxHeight(12 * Simplicity.getDpmm());
        rc2.setValignment(VPos.CENTER);
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setMinWidth(12 * Simplicity.getDpmm());
        cc1.setMaxWidth(12 * Simplicity.getDpmm());

        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setMinWidth(text.length() * 4 * Simplicity.getDpmm());
        cc2.setMaxWidth(text.length() * 4 * Simplicity.getDpmm());

        this.gridLayout.getRowConstraints().addAll(rc2, this.gridLayout.getDataRowConstraint());
        this.gridLayout.getColumnConstraints().addAll(cc1, cc2);

        this.icon.getChildren().add(circle);

        this.gridLayout.add(icon, 0, 0);

        Text newText = new Text(text);
        newText.setFont(Font.font(3 * Simplicity.getDpmm()));
        newText.setText(text);
        this.gridLayout.add(newText, 1, 0);
        this.gridLayout.add(this.placeForButtons, 0, 1, 2, 1);
        this.placeForButtons.setAlignment(Pos.CENTER);
        this.applicationArea.getChildren().add(gridLayout);

        this.setHeight(4.5 * Simplicity.getDpmm() + 3 * 3 * Simplicity.getDpmm() + 12 * Simplicity.getDpmm() + 6 * Simplicity.getDpmm() + 2 / 3 * Simplicity.getDpmm());
        this.setWidth(text.length() * 2 * Simplicity.getDpmm() + 2 / 3 * Simplicity.getDpmm() + 9 * Simplicity.getDpmm() + 16 * Simplicity.getDpmm());

        this.init();
    }

    abstract void init();

    protected void handleOKButtonAction(ActionEvent event) {
        // Button was clicked, do something...

        this.close();
    }

    @Override
    public void initAreaForUserInteraction() {

    }
}
