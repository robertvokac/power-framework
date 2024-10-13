
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

import javafx.scene.paint.Color;
import com.robertvokac.powerframework.view.EnumColour;

/**
 * Represents colour skin of Window.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class WindowColourSkin {

    /**
     * 16 variants of colour for window skin.
     *
     * colour[0] is used for light colours colour[1] is used for light colours
     */
    private static final Color[][] colour = new Color[2][17];

    /**
     * Filling colour variable.
     */
    static {
        colour[0][1] = Color.rgb(142, 255, 142);
        colour[1][1] = Color.rgb(0, 255, 0);
        colour[0][2] = Color.rgb(255, 105, 105);
        colour[1][2] = Color.rgb(255, 71, 71);
        colour[0][3] = Color.rgb(43, 128, 213);
        colour[1][3] = Color.rgb(0, 70, 255);
        colour[0][4] = Color.rgb(255, 255, 164);
        colour[1][4] = Color.rgb(244, 244, 0);
        colour[0][5] = Color.rgb(98, 255, 255);
        colour[1][5] = Color.rgb(0, 225, 225);
        colour[0][6] = Color.rgb(178, 113, 178);
        colour[1][6] = Color.rgb(139, 73, 139);
        colour[0][7] = Color.rgb(133, 84, 57);
        colour[1][7] = Color.rgb(107, 37, 4);
        colour[0][8] = Color.rgb(255, 218, 236);
        colour[1][8] = Color.rgb(255, 171, 213);
        colour[0][9] = Color.rgb(0, 204, 0);
        colour[1][9] = Color.rgb(0, 153, 0);
        colour[0][10] = Color.rgb(255, 228, 119);
        colour[1][10] = Color.rgb(255, 185, 0);
        colour[0][11] = Color.rgb(253, 154, 73);
        colour[1][11] = Color.rgb(244, 128, 32);
        colour[0][12] = Color.rgb(255, 255, 255);
        colour[1][12] = Color.rgb(238, 238, 238);
        colour[0][13] = Color.rgb(204, 204, 204);
        colour[1][13] = Color.rgb(178, 178, 178);
        colour[0][14] = Color.rgb(32, 32, 32);
        colour[1][14] = Color.rgb(0, 0, 0);
        colour[0][15] = Color.rgb(111, 183, 255);
        colour[1][15] = Color.rgb(0, 128, 255);
        colour[0][16] = Color.rgb(108, 119, 46);
        colour[1][16] = Color.rgb(75, 83, 32);

    }
    private final EnumColour enumColour;

    /**
     *
     * @param colour
     */
    public WindowColourSkin(EnumColour colour) {
        this.enumColour = colour;
    }

    /**
     *
     * @param colourVariant
     *
     * @return
     */
    public Color getColour(ColourVariant colourVariant) {
        if(colourVariant == ColourVariant.LIGHT) {
            return colour[0][enumColour.ordinal()];
        } else {
            return colour[1][enumColour.ordinal()];
        }
    }

    /**
     *
     * @return
     */
    public Color getColourForActiveWindowTitleButton() {
        return Color.rgb(128, 128, 128);
    }

    /**
     *
     * @return
     */
    public Color getColourForInactiveWindowTitleButton() {
        return Color.rgb(153, 153, 153);
    }

    /**
     *
     * @return
     */
    public Color getColourForActiveWindowTitleCloseButton() {
        return Color.rgb(255, 102, 102);
    }

    /**
     *
     * @param lightOrDarkBackground
     *
     * @return
     */
    public Color getColourForText(ColourVariant lightOrDarkBackground) {
        int colourNumber = this.getEnumColour().getNumber();
        if(lightOrDarkBackground == ColourVariant.DARK) {
            int[] intArray = {3, 6, 7, 14, 16};
            for (int element : intArray) {
                if(colourNumber == element) {
                    return Color.rgb(255, 255, 255);
                }
            }
        } else {
            if(colourNumber == 14) {
                return Color.rgb(255, 255, 255);
            }
        }

        return Color.rgb(0, 0, 0);
    }

    /**
     * Convert EnumColour Instance to Color Instance. Its RGB values combine
     * with commas.
     *
     * @param lightOrDark
     *
     * @return css String representation of colour
     */
    public String getRGBStringForCSS(ColourVariant lightOrDark) {
        return Integer.toString((int) (getColour(lightOrDark).getRed() * 255))
                + ","
                + Integer.toString((int) (getColour(lightOrDark).getGreen() * 255))
                + ","
                + Integer.toString((int) (getColour(lightOrDark).getBlue() * 255));
    }

    /**
     *
     * @param color
     *
     * @return
     */
    public String getRGBStringForCSS(Color color) {
        return Integer.toString((int) (color.getRed() * 255))
                + ","
                + Integer.toString((int) (color.getGreen() * 255))
                + ","
                + Integer.toString((int) (color.getBlue() * 255));
    }

    /**
     *
     * @return
     */
    public EnumColour getEnumColour() {
        return this.enumColour;
    }

    @Override
    public String toString() {
        return this.enumColour.toString();
    }
}
