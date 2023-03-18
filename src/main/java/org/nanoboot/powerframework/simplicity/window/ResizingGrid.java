
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

import javafx.scene.layout.GridPane;
import org.nanoboot.powerframework.simplicity.Simplicity;

/**
 * Represents place used to resize window.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 */
public class ResizingGrid extends GridPane {

    /**
     *
     * @param windowColourSkin
     */
    public ResizingGrid() {
        this.setMaxHeight(Simplicity.getDpmm() * 6);
        this.setMaxWidth(Simplicity.getDpmm() * 6);
        this.add(new ResizingGridRectangle(), 3, 0);
        this.add(new ResizingGridRectangle(), 2, 1);
        this.add(new ResizingGridRectangle(), 3, 1);
        this.add(new ResizingGridRectangle(), 1, 2);
        this.add(new ResizingGridRectangle(), 2, 2);
        this.add(new ResizingGridRectangle(), 3, 2);
        this.add(new ResizingGridRectangle(), 0, 3);
        this.add(new ResizingGridRectangle(), 1, 3);
        this.add(new ResizingGridRectangle(), 2, 3);
        this.add(new ResizingGridRectangle(), 3, 3);
        this.setStyle("-fx-padding: 0;-fx-insets: 0;");
        this.setHgap(Simplicity.getDpmm() / 2);
        this.setVgap(Simplicity.getDpmm() / 2);
    }
}
