
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

import org.nanoboot.powerframework.simplicity.Simplicity;
import org.nanoboot.powerframework.simplicity.window.controls.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 * Represents a alert box- a window used to alarm user.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 */
public class AlertBox extends Box {

    private AlertBox(String titleText, String text) {
        super(titleText, text);
    }

    /**
     *
     * @param windowColourSkin
     * @param titleText
     * @param text
     */
    public static void showBox(String titleText, String text) {
        AlertBox alertBox = new AlertBox(titleText, text);
        alertBox.showAndWait();
    }

    void init() {
        circle.setFill(Color.rgb(237, 103, 103));
        Rectangle rectangle1 = new Rectangle(2 * Simplicity.getDpmm(), 8 * Simplicity.getDpmm());
        Rectangle rectangle2 = new Rectangle(2 * Simplicity.getDpmm(), 8 * Simplicity.getDpmm());
        Rotate rotate45 = new Rotate(45, 1.0 * Simplicity.getDpmm(), 4.0 * Simplicity.getDpmm());
        Rotate rotateMinus45 = new Rotate(-45, 1.0 * Simplicity.getDpmm(), 4.0 * Simplicity.getDpmm());
        rectangle1.getTransforms().addAll(rotate45);
        rectangle2.getTransforms().addAll(rotateMinus45);
        this.icon.getChildren().addAll(rectangle1, rectangle2);

        rectangle1.setFill(Color.rgb(238, 238, 238));
        rectangle2.setFill(Color.rgb(238, 238, 238));

        Button okButton = new Button("OK");

        this.placeForButtons.getChildren().add(okButton);
        okButton.setMaxWidth(20 * Simplicity.getDpmm());
        okButton.setOnAction(this::handleOKButtonAction);
    }
}
