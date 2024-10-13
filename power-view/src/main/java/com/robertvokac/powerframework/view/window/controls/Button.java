
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

package com.robertvokac.powerframework.view.window.controls;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import com.robertvokac.powerframework.view.View;
import com.robertvokac.powerframework.view.window.ColourVariant;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class Button extends javafx.scene.control.Button {

    private final String setStyleStartString
            = new StringBuilder("-fx-border-insets:0;-fx-background-insets:0;-fx-background-radius:0;-fx-background-color: rgb(")
                    .append(View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK))
                    .append(");-fx-border-color:rgb(")
                    .toString();
    private final String setStyleEndString = new StringBuilder(");-fx-border-width: ")
            .append(View.getDpmm() / 2)
            .append(";")
            .toString();

    /**
     *
     * @param text
     */
    public Button(String text) {
        super(text);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(6 * View.getDpmm());
        this.setPadding(new Insets(0, 0, 0, 0));
        this.setFont(Font.font(3 * View.getDpmm()));
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
