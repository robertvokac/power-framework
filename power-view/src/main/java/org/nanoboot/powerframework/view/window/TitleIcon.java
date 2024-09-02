
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

package org.nanoboot.powerframework.view.window;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.nanoboot.powerframework.view.View;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TitleIcon extends StackPane {

    private static final double TITLEICONHEIGHT = 4.5;
    /**
     * Title bar icon image.
     */
    private final ImageView imageView = new ImageView();

    /**
     * Constructor
     *
     */
    TitleIcon() {
        setStyle("-fx-background-color: rgb(" + View.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");");
        imageView.setFitWidth(View.getDpmm() * TITLEICONHEIGHT);
        imageView.setFitHeight(View.getDpmm() * TITLEICONHEIGHT);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        getChildren().add(imageView);
    }

    /**
     *
     * @param path
     */
    public void setIcon(String path) {
        System.out.println("path="+path);
        Image image = new Image(path);
        imageView.setImage(image);
    }
}
