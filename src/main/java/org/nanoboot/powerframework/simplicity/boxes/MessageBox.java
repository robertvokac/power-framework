
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
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents a message box- a window used to inform user about something.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 */
public class MessageBox extends Box {

    private MessageBox(String titleText, String text) {
        super(titleText, text);
    }

    /**
     *
     * @param windowColourSkin
     * @param titleText
     * @param text
     */
    public static void showBox(String titleText, String text) {
        MessageBox messageBox = new MessageBox(titleText, text);
        messageBox.showAndWait();
    }

    void init() {
        circle.setFill(Color.rgb(114, 159, 207));
        Rectangle rectangle1 = new Rectangle(2 * Simplicity.getDpmm(), 5 * Simplicity.getDpmm());
        Rectangle rectangle2 = new Rectangle(2 * Simplicity.getDpmm(), 2 * Simplicity.getDpmm());
        this.icon2.getChildren().addAll(rectangle1, rectangle2);
        this.icon.getChildren().add(icon2);

        this.icon2.setAlignment(rectangle1, Pos.BOTTOM_CENTER);
        this.icon2.setAlignment(rectangle2, Pos.TOP_CENTER);
        this.icon2.setMaxHeight(8 * Simplicity.getDpmm());
        rectangle1.setFill(Color.rgb(238, 238, 238));

        rectangle2.setFill(Color.rgb(238, 238, 238));
        Button okButton = new Button("OK");

        this.placeForButtons.getChildren().add(okButton);
        okButton.setMaxWidth(20 * Simplicity.getDpmm());
        okButton.setOnAction(this::handleOKButtonAction);
    }
}
