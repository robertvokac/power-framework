
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

package com.robertvokac.powerframework.view.window.titlebuttons;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import com.robertvokac.powerframework.view.View;
import com.robertvokac.powerframework.view.window.ColourVariant;
import com.robertvokac.powerframework.view.window.WindowColourSkin;

/**
 * Represents window title button.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
