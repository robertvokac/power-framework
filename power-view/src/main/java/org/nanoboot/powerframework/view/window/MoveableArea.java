
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

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
package org.nanoboot.powerframework.view.window;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import static javafx.scene.layout.HBox.setHgrow;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.nanoboot.powerframework.view.View;

/**
 * Represents the part of window, where is the window title placed and is used
 * to move window
 *
 * @author Robert Vokáč e-mail: robertvokac@nanoboot.org
 */
public final class MoveableArea extends StackPane {

    private final Text titleText = new Text("");
    private final Window window;
    private boolean moveable;

    /**
     * Constructor
     *
     * @param window
     */
    public MoveableArea(Window window) {
        this.window = window;
        getChildren().add(titleText);
        setStyle("-fx-background-color: rgb(" + View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");");
        setAlignment(Pos.CENTER_LEFT);

        setHgrow(this, Priority.ALWAYS);

        titleText.setFont(Font.font(View.getDpmm() * 3));
        titleText.setFill(View.getDefaultWindowColourSkin().getColourForText(ColourVariant.DARK));
        titleText.setScaleX(1.2);
        setPadding(new Insets(0, 0, 0, View.getDpmm()));
        this.setCanBeMoved(true);
    }

    /**
     *
     * @param value
     */
    public void setCanBeMoved(boolean value) {
        moveable = value;
        if(value) {
            setOnMousePressed(window::handleMovingWindowStarted);
            setOnMouseDragged(window::handleMovingWindowEnded);
        } else {
            setOnMousePressed(null);
            setOnMouseDragged(null);
        }

    }

    /**
     *
     * @return true, if this object is able to move window, otherwise false
     */
    public boolean canBeMoved() {
        return this.moveable;

    }

    /**
     *
     * @param title
     */
    public void setWindowTitle(String title) {
        titleText.setText("  " + title);
    }

    /**
     *
     * @return window title
     */
    public String getWindowTitle() {
        return this.titleText.getText();
    }
}
