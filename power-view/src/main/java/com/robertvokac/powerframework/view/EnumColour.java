
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

package com.robertvokac.powerframework.view;

import com.robertvokac.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;

/**
 * Represents one of 16 colours, or there is no colour.
 *
 * @author Robert Vokáč robertvokac@robertvokac.com
 */
//To be removed
@Deprecated
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public enum EnumColour {

    /**
     * No colour is selected.
     */
    NOCOLOUR,
    /**
     * Light Green
     */
    LIGHTGREEN,
    /**
     * Red
     */
    RED,
    /**
     * Dark Blue
     */
    DARKBLUE,
    /**
     * Yellow
     */
    YELLOW,
    /**
     * Light Blue
     */
    LIGHTBLUE,
    /**
     * Purple
     */
    PURPLE,
    /**
     * Brown
     */
    BROWN,
    /**
     * Pink
     */
    PINK,
    /**
     * Green
     */
    GREEN,
    /**
     * Gold
     */
    GOLD,
    /**
     * Orange
     */
    ORANGE,
    /**
     * White
     */
    WHITE,
    /**
     * Grey
     */
    GREY,
    /**
     * Black
     */
    BLACK,
    /**
     * Blue
     */
    BLUE,
    /**
     * OliveGreen
     */
    OLIVEGREEN;

    /**
     *
     * @return
     * <p>
     * ordinal number of enum colour</p>
     * <p>
     * Converts EnumColour to int.</p>
     */
    public int getNumber() {
        return this.ordinal();
    }

    /**
     *
     * @param numberIn number representation of the enum EnumColour
     *
     * @return EnumColour instance based on the numberIn value
     */
    public static EnumColour convertNumberToEnumColour(int numberIn) {//NOSONAR
        if(!isNumberRepresentationValid(numberIn)) {
            throw new ViewException("Number you want co convert to EnumColour must be at least 0 and at most 16.");
        }
        switch (numberIn) {
            case 0:
                return EnumColour.NOCOLOUR;
            case 1:
                return EnumColour.LIGHTGREEN;
            case 2:
                return EnumColour.RED;
            case 3:
                return EnumColour.DARKBLUE;
            case 4:
                return EnumColour.YELLOW;
            case 5:
                return EnumColour.LIGHTBLUE;
            case 6:
                return EnumColour.PURPLE;
            case 7:
                return EnumColour.BROWN;
            case 8:
                return EnumColour.PINK;
            case 9:
                return EnumColour.GREEN;
            case 10:
                return EnumColour.GOLD;
            case 11:
                return EnumColour.ORANGE;
            case 12:
                return EnumColour.WHITE;
            case 13:
                return EnumColour.GREY;
            case 14:
                return EnumColour.BLACK;
            case 15:
                return EnumColour.BLUE;
            case 16:
                return EnumColour.OLIVEGREEN;
            default:
                return null;

        }
    }

    private static boolean isNumberRepresentationValid(int number) {
        return (number >= 0) && (number <= 16);
    }

    /**
     *
     * @return random EnumColour
     */
    public static EnumColour getRandom() {
        int i = W5RandomGenerator.getStaticInstance().nextInt(1, 16);
        return EnumColour.convertNumberToEnumColour(i);
    }
}
