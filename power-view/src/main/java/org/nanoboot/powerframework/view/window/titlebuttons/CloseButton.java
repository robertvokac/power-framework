
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

import javafx.geometry.Pos;
import javafx.scene.shape.Line;
import org.nanoboot.powerframework.view.View;
import org.nanoboot.powerframework.view.window.Window;
import org.nanoboot.powerframework.view.window.WindowColourSkin;

/**
 * Represents close button.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CloseButton extends WindowTitleButton {

    Line line1 = new Line(0, 0, 5 * View.getDpmm(), 2.5 * View.getDpmm());
    Line line2 = new Line(0, 2.5 * View.getDpmm(), 5 * View.getDpmm(), 0);

    /**
     *
     * @param windowColourSkin
     * @param window
     */
    public CloseButton(WindowColourSkin windowColourSkin,
            Window window) {
        super(windowColourSkin);
        setOnMouseClicked(window::handleCloseButtonAction);
        line1.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        line1.setStrokeWidth(0.5 * View.getDpmm());
        line2.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        line2.setStrokeWidth(0.5 * View.getDpmm());
        getChildren().addAll(line1, line2);
        setAlignment(line1, Pos.CENTER);
        setAlignment(line2, Pos.CENTER);
    }

    @Override
    public void makeActive() {
        line1.setStroke(this.windowColourSkin.getColourForActiveWindowTitleCloseButton());
        line2.setStroke(this.windowColourSkin.getColourForActiveWindowTitleCloseButton());
    }

    @Override
    public void makeInactive() {
        line1.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
        line2.setStroke(this.windowColourSkin.getColourForInactiveWindowTitleButton());
    }

}
