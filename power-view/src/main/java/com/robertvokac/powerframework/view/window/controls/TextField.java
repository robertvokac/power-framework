
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

import javafx.scene.text.Font;
import com.robertvokac.powerframework.view.View;
import com.robertvokac.powerframework.view.window.ColourVariant;

/**
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class TextField extends javafx.scene.control.TextField {

    /**
     * Constructor
     *
     * @param value
     */
    public TextField(String value) {
        super(value);
        setTextField();
    }

    /**
     * Constructor
     */
    public TextField() {
        setTextField();
    }

    private void setTextField() {
        this.setFont(Font.font(3 * View.getDpmm()));
        this.setMaxHeight(6 * View.getDpmm());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-fx-padding:0;-fx-border-insets:0;-fx-background-insets:0;-fx-background-radius:0;-fx-background-color: rgb(255,255,255);-fx-border-color:rgb(");
        stringBuilder.append(View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK));
        stringBuilder.append(");-fx-border-width: ");
        stringBuilder.append(View.getDpmm() / 2);
        stringBuilder.append(";");
        this.setStyle(stringBuilder.toString());
    }
}
