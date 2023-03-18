
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

package org.nanoboot.powerframework.view.window.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.nanoboot.powerframework.view.View;
import org.nanoboot.powerframework.view.window.ColourVariant;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class SCheckBox extends HBox {

    private StackPane checkBoxStackPane = new StackPane();
    private SLabel checkBoxSLabel = new SLabel();
    private boolean selected = false;
    private boolean disabled = false;
    Line line1 = new Line(0, 0, 3 * View.getDpmm(), 3 * View.getDpmm());
    Line line2 = new Line(0, 3 * View.getDpmm(), 3 * View.getDpmm(), 0);

    /**
     * Constructor
     */
    public SCheckBox() {
        this.line1.setStroke(Color.rgb(153, 153, 153));
        this.line1.setStrokeWidth(0.5 * View.getDpmm());
        this.line2.setStroke(Color.rgb(153, 153, 153));
        this.line2.setStrokeWidth(0.5 * View.getDpmm());

        this.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().addAll(this.checkBoxStackPane, this.checkBoxSLabel);
        setMargin(checkBoxStackPane, new Insets(0, 1 * View.getDpmm(), 0, 0));
        setOnMouseClicked(this::handleMouseClicked);
        this.checkBoxStackPane.setMinSize(6 * View.getDpmm(), 6 * View.getDpmm());
        this.checkBoxStackPane.setMaxSize(6 * View.getDpmm(), 6 * View.getDpmm());
        this.checkBoxStackPane.setStyle("-fx-background-radius:0;-fx-background-color: rgb(255,255,255);-fx-border-color:rgb(" + View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");-fx-border-width: " + View.getDpmm() / 2 + ";");
    }

    /**
     *
     * @param text
     */
    public SCheckBox(String text) {
        this();
        this.setCheckBoxText(text);
    }

    /**
     *
     * @param text
     */
    public void setCheckBoxText(String text) {
        this.checkBoxSLabel.setText(text);
    }

    /**
     *
     * @return
     */
    public String getCheckBoxText() {
        return this.checkBoxSLabel.getText();
    }

    private void handleMouseClicked(MouseEvent event) {//NOSONAR
        this.setSelected(!this.isSelected());
    }

    /**
     *
     * @param value
     */
    public void setSelected(boolean value) {
        this.selected = value;
        this.checkBoxStackPane.getChildren().clear();
        if(value) {
            this.checkBoxStackPane.getChildren().addAll(this.line1, this.line2);
        }
    }

    /**
     *
     * @return
     */
    public boolean isSelected() {
        return this.selected;
    }

    /**
     *
     * @param value
     */
    public void turnDisabled(boolean value) {
        this.disabled = value;
        if(value) {
            this.checkBoxStackPane.setStyle("-fx-background-color: rgb(192,192,192);-fx-border-color:rgb(153,153,153);-fx-border-width: " + View.getDpmm() / 2 + ";");
            setOnMouseClicked(null);
        } else {
            this.checkBoxStackPane.setStyle("-fx-background-color: rgb(255,255,255);-fx-border-color:rgb(" + View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");-fx-border-width: " + View.getDpmm() / 2 + ";");
            setOnMouseClicked(this::handleMouseClicked);
        }
    }

    /**
     *
     * @return
     */
    public boolean getDisabled() {
        return this.disabled;
    }

}
