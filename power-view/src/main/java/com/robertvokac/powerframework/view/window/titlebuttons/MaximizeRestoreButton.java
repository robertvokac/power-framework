
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

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import com.robertvokac.powerframework.view.View;
import com.robertvokac.powerframework.view.window.Window;
import com.robertvokac.powerframework.view.window.WindowColourSkin;

/**
 * Represents maximize/restore button.
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public final class MaximizeRestoreButton extends WindowTitleButton {

    private final Polyline restorePolyline = new Polyline(
            1.5 * View.getDpmm(), 1 * View.getDpmm(),
            1.5 * View.getDpmm(), 0,
            5.5 * View.getDpmm(), 0,
            5.5 * View.getDpmm(), 2.0 * View.getDpmm(),
            4 * View.getDpmm(), 2.0 * View.getDpmm(),
            4 * View.getDpmm(), 3.0 * View.getDpmm(),
            0 * View.getDpmm(), 3.0 * View.getDpmm(),
            0 * View.getDpmm(), 1 * View.getDpmm(),
            4 * View.getDpmm(), 1 * View.getDpmm(),
            4 * View.getDpmm(), 2.0 * View.getDpmm()
    );
    private final Polyline maximizePolyline = new Polyline(
            0.25 * View.getDpmm(), 0.25 * View.getDpmm(),
            5.25 * View.getDpmm(), 0.25 * View.getDpmm(),
            5.25 * View.getDpmm(), 3 * View.getDpmm(),
            0.25 * View.getDpmm(), 3 * View.getDpmm(),
            0.25 * View.getDpmm(), 0.25 * View.getDpmm());

    /**
     *
     * @param windowColourSkin
     * @param window
     */
    public MaximizeRestoreButton(WindowColourSkin windowColourSkin,
            Window window) {
        super(windowColourSkin);
        setOnMouseClicked(window::handleMaximizeRestoreButtonAction);
        restorePolyline.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        restorePolyline.setStrokeWidth(0.5 * View.getDpmm());
        restorePolyline.setFill(Color.TRANSPARENT);

        maximizePolyline.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        maximizePolyline.setStrokeWidth(0.5 * View.getDpmm());
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
