
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

package com.robertvokac.powerframework.view.window;

import javafx.scene.layout.GridPane;
import com.robertvokac.powerframework.view.View;

/**
 * Represents place used to resize window.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
