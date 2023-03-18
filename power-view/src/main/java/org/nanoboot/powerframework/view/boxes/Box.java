
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

package org.nanoboot.powerframework.view.boxes;

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
import org.nanoboot.powerframework.view.View;
import org.nanoboot.powerframework.view.layouts.SLayout;
import org.nanoboot.powerframework.view.window.Window;

/**
 * Represents a box- a window used to give information to user.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
abstract class Box extends Window {

    protected String titleText;
    protected String text;
    protected StackPane icon = new StackPane();
    protected StackPane icon2 = new StackPane();
    protected SLayout gridLayout = new SLayout();
    Circle circle = new Circle(6 * View.getDpmm());
    protected StackPane placeForButtons = new StackPane();

    Box(String titleText,
            String text) {
        initModality(Modality.APPLICATION_MODAL);
        this.setWindowTitle(titleText);
        this.text = text;

        this.setCloseable(false);
        this.showOnlyTheCloseButton();

        RowConstraints rc2 = new RowConstraints();
        rc2.setMinHeight(12 * View.getDpmm());
        rc2.setMaxHeight(12 * View.getDpmm());
        rc2.setValignment(VPos.CENTER);
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setMinWidth(12 * View.getDpmm());
        cc1.setMaxWidth(12 * View.getDpmm());

        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setMinWidth(text.length() * 4 * View.getDpmm());
        cc2.setMaxWidth(text.length() * 4 * View.getDpmm());

        this.gridLayout.getRowConstraints().addAll(rc2, this.gridLayout.getDataRowConstraint());
        this.gridLayout.getColumnConstraints().addAll(cc1, cc2);

        this.icon.getChildren().add(circle);

        this.gridLayout.add(icon, 0, 0);

        Text newText = new Text(text);
        newText.setFont(Font.font(3 * View.getDpmm()));
        newText.setText(text);
        this.gridLayout.add(newText, 1, 0);
        this.gridLayout.add(this.placeForButtons, 0, 1, 2, 1);
        this.placeForButtons.setAlignment(Pos.CENTER);
        this.applicationArea.getChildren().add(gridLayout);

        this.setHeight(4.5 * View.getDpmm() + 3 * 3 * View.getDpmm() + 12 * View.getDpmm() + 6 * View.getDpmm() + 2 / 3 * View.getDpmm());
        this.setWidth(text.length() * 2 * View.getDpmm() + 2 / 3 * View.getDpmm() + 9 * View.getDpmm() + 16 * View.getDpmm());

        this.initBox();
    }

    abstract void initBox();

    protected void handleOKButtonAction(ActionEvent event) {
        // Button was clicked, do something...

        this.close();
    }

    @Override
    public void initAreaForUserInteraction(Object... args) {

    }
}
