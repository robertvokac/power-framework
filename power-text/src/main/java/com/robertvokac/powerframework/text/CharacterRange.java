
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

package com.robertvokac.powerframework.text;

import lombok.Getter;

import java.util.Arrays;

/**
 * Representing ascii characters of a type.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
@Getter
public final class CharacterRange {
    /**
     * Ascii starting position for number characters.
     */
    private static final int NUMERIC_CHARS_FROM = 48;
    /**
     * Ascii ending position for number characters.
     */
    private static final int NUMERIC_CHARS_TO = 57;
    /**
     * Ascii starting position for lower letter characters.
     */
    private static final int LOWER_LETTERS_CHARS_FROM = 97;
    /**
     * Ascii ending position for lower letter characters.
     */
    private static final int LOWER_LETTERS_CHARS_TO = 122;
    /**
     * Ascii starting position for upper letter characters.
     */
    private static final int UPPER_LETTERS_CHARS_FROM = 65;
    /**
     * Ascii ending position for upper letter characters.
     */
    private static final int UPPER_LETTERS_CHARS_TO = 90;
    /**
     * Ascii starting position for printable characters.
     */
    private static final int PRINTABLE_ASCII_CHARS_FROM = 33;
    /**
     * Ascii ending position for printable characters.
     */
    private static final int PRINTABLE_ASCII_CHARS_TO = 126;

    /**
     * Range for numbers.
     */
    public static final CharacterRange NUMBERS;
    /**
     * Range for lower letters.
     */
    public static final CharacterRange LOWER_LETTERS;
    /**
     * Range for upper letters.
     */
    public static final CharacterRange UPPER_LETTERS;
    /**
     * Range for printable characters.
     */
    public static final CharacterRange PRINTABLE_CHARACTERS_LETTERS;

    /**
     * Character type.
      */
    private final CharacterType type;

    /**
     * Ascii starting position.
     */
    private final int asciiFrom;

    /**
     * Ascii ending position.
     */
    private final int asciiTo;

    /**
     * Char array of the character of this type.
     */
    private final char[] array;

    static {
        NUMBERS = new CharacterRange(
                CharacterType.NUMBER, NUMERIC_CHARS_FROM, NUMERIC_CHARS_TO
        );
        LOWER_LETTERS = new CharacterRange(
                CharacterType.LOWER_LETTER,
                LOWER_LETTERS_CHARS_FROM, LOWER_LETTERS_CHARS_TO
        );
        UPPER_LETTERS = new CharacterRange(
                CharacterType.UPPER_LETTER,
                UPPER_LETTERS_CHARS_FROM, UPPER_LETTERS_CHARS_TO
        );
        PRINTABLE_CHARACTERS_LETTERS = new CharacterRange(
                CharacterType.OTHER_PRINTABLE,
                PRINTABLE_ASCII_CHARS_FROM, PRINTABLE_ASCII_CHARS_TO
        );
    }

    /**
     * Returns instance of CharacterRange
     * based on the given type.
     *
     * @param type type of the character range to return
     *             Note: printable characters
     *             are not supported.
     * @return CharacterRange instance
     */
    public static CharacterRange getInstance(
            final CharacterType type) {
        switch (type) {
            case NUMBER: return NUMBERS;
            case LOWER_LETTER: return LOWER_LETTERS;
            case UPPER_LETTER: return UPPER_LETTERS;
            case OTHER_PRINTABLE: return PRINTABLE_CHARACTERS_LETTERS;
            default:
                String msg = "Type " + type + " is not supported.";
                throw new TextException(msg);
        }
    }

    /**
     * Constructor.
     * @param characterType type of the character range to return
     *      *             Note: printable characters
     *      *             are not supported.
     * @param asciiFromParam starting position
     * @param asciiToParam ending position
     */
    private CharacterRange(final CharacterType characterType,
                           final int asciiFromParam, final int asciiToParam) {
        boolean numbersAreInRange = asciiFromParam <= asciiToParam;
        if (!numbersAreInRange) {
            String msg = "asciiFromParam must be less or equal to asciiToParam";
            throw new TextException(msg);
        }
        this.type = characterType;
        this.asciiFrom = asciiFromParam;
        this.asciiTo = asciiToParam;
        this.array = new char[this.size()];
        int index = 0;
        for (int i = asciiFrom; i <= asciiTo; i++) {
            char ch = (char) i;
            array[index++] = ch;
        }
    }

    /**
     * Returns size of the range.
     * @return size of the characters in the range
     */
    public int size() {
        return asciiTo - asciiFrom + 1;
    }

    /**
     * Returns the character array.
     * @return array
     */
    public char[] getArray() {
        return Arrays.copyOf(this.array, this.array.length);
    }
}
