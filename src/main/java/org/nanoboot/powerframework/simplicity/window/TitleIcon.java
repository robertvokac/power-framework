
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

package org.nanoboot.powerframework.simplicity.window;

import org.nanoboot.powerframework.simplicity.Simplicity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class TitleIcon extends StackPane {

    /**
     * Title bar icon image.
     */
    private final ImageView imageView = new ImageView();
    private static final double TITLEICONHEIGHT = 4.5;

    /**
     * Constructor
     *
     * @param windowColourSkin
     */
    TitleIcon() {
        setStyle("-fx-background-color: rgb(" + Simplicity.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");");
        imageView.setFitWidth(Simplicity.getDpmm() * TITLEICONHEIGHT);
        imageView.setFitHeight(Simplicity.getDpmm() * TITLEICONHEIGHT);
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
        Image image = new Image(path);
        imageView.setImage(image);
    }
}
