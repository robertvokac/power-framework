
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

package org.nanoboot.powerframework.simplicity.window.titlebuttons;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import org.nanoboot.powerframework.simplicity.Simplicity;
import org.nanoboot.powerframework.simplicity.window.Window;
import org.nanoboot.powerframework.simplicity.window.WindowColourSkin;

/**
 * Represents maximize/restore button.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class MaximizeRestoreButton extends WindowTitleButton {

    private Polyline restorePolyline = new Polyline(
            1.5 * Simplicity.getDpmm(), 1 * Simplicity.getDpmm(),
            1.5 * Simplicity.getDpmm(), 0,
            5.5 * Simplicity.getDpmm(), 0,
            5.5 * Simplicity.getDpmm(), 2.0 * Simplicity.getDpmm(),
            4 * Simplicity.getDpmm(), 2.0 * Simplicity.getDpmm(),
            4 * Simplicity.getDpmm(), 3.0 * Simplicity.getDpmm(),
            0 * Simplicity.getDpmm(), 3.0 * Simplicity.getDpmm(),
            0 * Simplicity.getDpmm(), 1 * Simplicity.getDpmm(),
            4 * Simplicity.getDpmm(), 1 * Simplicity.getDpmm(),
            4 * Simplicity.getDpmm(), 2.0 * Simplicity.getDpmm()
    );
    private Polyline maximizePolyline = new Polyline(
            0.25 * Simplicity.getDpmm(), 0.25 * Simplicity.getDpmm(),
            5.25 * Simplicity.getDpmm(), 0.25 * Simplicity.getDpmm(),
            5.25 * Simplicity.getDpmm(), 3 * Simplicity.getDpmm(),
            0.25 * Simplicity.getDpmm(), 3 * Simplicity.getDpmm(),
            0.25 * Simplicity.getDpmm(), 0.25 * Simplicity.getDpmm());

    /**
     *
     * @param windowColourSkin
     * @param window
     */
    public MaximizeRestoreButton(WindowColourSkin windowColourSkin, Window window) {
        super(windowColourSkin);
        setOnMouseClicked(window::handleMaximizeRestoreButtonAction);
        restorePolyline.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        restorePolyline.setStrokeWidth(0.5 * Simplicity.getDpmm());
        restorePolyline.setFill(Color.TRANSPARENT);

        maximizePolyline.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        maximizePolyline.setStrokeWidth(0.5 * Simplicity.getDpmm());
        maximizePolyline.setFill(Color.TRANSPARENT);

        this.setAlignment(Pos.CENTER);
        this.setMaximizeRestoreButtonMaximized();

    }

    /**
     * Changes button's look to restored.
     */
    public void setMaximizeRestoreButtonRestored() {
        getChildren().clear();
        getChildren().add(restorePolyline);

    }

    /**
     ** Changes button's look to maximized.
     */
    public void setMaximizeRestoreButtonMaximized() {
        getChildren().clear();
        getChildren().add(maximizePolyline);

    }

    @Override
    public void makeActive() {
        restorePolyline.setStroke(this.windowColourSkin.getColourForActiveWindowTitleButton());
        maximizePolyline.setStroke(this.windowColourSkin.getColourForActiveWindowTitleButton());

    }

    @Override
    public void makeInactive() {
        restorePolyline.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        maximizePolyline.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
    }
}
