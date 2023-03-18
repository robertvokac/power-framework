
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

package org.nanoboot.powerframework.view.window;

import javafx.scene.layout.GridPane;
import org.nanoboot.powerframework.view.View;

/**
 * Represents place used to resize window.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ResizingGrid extends GridPane {

    /**
     *
     */
    public ResizingGrid() {
        this.setMaxHeight(View.getDpmm() * 6);
        this.setMaxWidth(View.getDpmm() * 6);
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
        this.setHgap(View.getDpmm() / 2);
        this.setVgap(View.getDpmm() / 2);
    }
}
