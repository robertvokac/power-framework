
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

package org.nanoboot.powerframework.view.window.controls;

import javafx.scene.text.Font;
import org.nanoboot.powerframework.view.View;
import org.nanoboot.powerframework.view.window.ColourVariant;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class PasswordField extends javafx.scene.control.PasswordField {

    /**
     * Constructor
     */
    public PasswordField() {
        this.setFont(Font.font(3 * View.getDpmm()));
        this.setMaxHeight(6 * View.getDpmm());
        this.setStyle("-fx-padding:0;-fx-border-insets:0;-fx-background-insets:0;-fx-background-radius:0;-fx-background-color: rgb(255,255,255);-fx-border-color:rgb(" + View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");-fx-border-width: " + View.getDpmm() / 2 + ";");
    }
}
