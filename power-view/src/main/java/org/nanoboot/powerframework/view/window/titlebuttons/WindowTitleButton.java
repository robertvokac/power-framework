
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

package org.nanoboot.powerframework.view.window.titlebuttons;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import org.nanoboot.powerframework.view.View;
import org.nanoboot.powerframework.view.window.ColourVariant;
import org.nanoboot.powerframework.view.window.WindowColourSkin;

/**
 * Represents window title button.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class WindowTitleButton extends StackPane {

    private static final int BUTTONWIDTH = 7;

    /**
     *
     */
    protected WindowColourSkin windowColourSkin;

    /**
     *
     * @param windowColourSkin
     */
    public WindowTitleButton(WindowColourSkin windowColourSkin) {
        this.windowColourSkin = windowColourSkin;
        this.setStyle("-fx-background-color: rgb(" + windowColourSkin.getRGBStringForCSS(ColourVariant.DARK) + ");");
        setMinWidth(BUTTONWIDTH * View.getDpmm());
        setMaxWidth(BUTTONWIDTH * View.getDpmm());

        setOnMouseEntered(this::handleMouseEnteredAction);
        setOnMouseExited(this::handleMMouseExitedAction);
    }

    /**
     * Makes the background of the button active.
     */
    public void makeActiveBackground() {
        this.setStyle("-fx-background-color: rgb(212, 212, 212);");
    }

    /**
     *
     * @param line
     */
    public void makeLine(Line line) {
        line.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        line.setStrokeWidth(0.5 * View.getDpmm());
    }

    private void handleMouseEnteredAction(MouseEvent event) {//NOSONAR
        makeActive();
    }

    private void handleMMouseExitedAction(MouseEvent event) {//NOSONAR
        makeInactive();
    }

    /**
     * Makes button to look active.
     */
    public abstract void makeActive();

    /**
     * Makes button to look inactive.
     */
    public abstract void makeInactive();

}
