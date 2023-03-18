
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

import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import org.nanoboot.powerframework.simplicity.Simplicity;
import org.nanoboot.powerframework.simplicity.window.ColourVariant;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class SComboBox extends ComboBox {

    /**
     * Constructor
     */
    public SComboBox() {
        this.setMaxHeight(6 * Simplicity.getDpmm());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-fx-padding:0;-fx-border-insets:0;-fx-background-insets:0;-fx-background-radius:0;-fx-background-color: rgb(255,255,255);-fx-border-color:rgb(");
        stringBuilder.append(Simplicity.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK));
        stringBuilder.append(");-fx-border-width: ");
        stringBuilder.append(Simplicity.getDpmm() / 2);
        stringBuilder.append(";-fx-font-size: ");
        stringBuilder.append(Font.font(3 * Simplicity.getDpmm()));
        stringBuilder.append(";");
        this.setStyle(stringBuilder.toString());
    }
}
