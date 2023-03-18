
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

package org.nanoboot.powerframework.simplicity.window.controls;

import org.nanoboot.powerframework.simplicity.Simplicity;
import org.nanoboot.powerframework.simplicity.window.ColourVariant;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class Button extends javafx.scene.control.Button {

    private String setStyleStartString
            = new StringBuilder("-fx-border-insets:0;-fx-background-insets:0;-fx-background-radius:0;-fx-background-color: rgb(")
                    .append(Simplicity.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK))
                    .append(");-fx-border-color:rgb(")
                    .toString();
    private String setStyleEndString = new StringBuilder(");-fx-border-width: ")
            .append(Simplicity.getDpmm() / 2)
            .append(";")
            .toString();

    /**
     *
     * @param windowColourSkin
     * @param text
     */
    public Button(String text) {
        super(text);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(6 * Simplicity.getDpmm());
        this.setPadding(new Insets(0, 0, 0, 0));
        this.setFont(Font.font(3 * Simplicity.getDpmm()));
        this.setStyle(getSetStyleString("186, 186, 186"));
        setOnMouseEntered(this::handleMouseEnteredAction);
        setOnMouseExited(this::handleMouseExitedAction);
    }

    private void handleMouseEnteredAction(MouseEvent event) {//NOSONAR
        this.setStyle(getSetStyleString("0,0,0"));
    }

    private void handleMouseExitedAction(MouseEvent event) {//NOSONAR
        this.setStyle(getSetStyleString("186, 186, 186"));
    }

    private String getSetStyleString(String fxBorderColorString) {
        return new StringBuilder(setStyleStartString)
                .append(fxBorderColorString)
                .append(setStyleEndString)
                .toString();
    }
}
