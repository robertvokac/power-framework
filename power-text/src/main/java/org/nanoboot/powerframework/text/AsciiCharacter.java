
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

package org.nanoboot.powerframework.text;

import lombok.Getter;

/**
 * Enumeration for Ascii characters.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum AsciiCharacter {
    /**
     * Constant for ascii character constant ' '.
     */
    SPACE(32, "space", CharacterType.OTHER_NOT_PRINTABLE),
    /**
     * Constant for ascii character constant '!'.
     */
    EXCLAMATION_MARK(33, "exclamation mark", CharacterType.OTHER_PRINTABLE,
            '?'),
    /**
     * Constant for ascii character constant '"'.
     */
    QUOTATION_MARK(34, "quotation mark",
            CharacterType.OTHER_PRINTABLE,
            '\''),
    /**
     * Constant for ascii character constant '#'.
     */
    NUMBER_SIGN(35, "number sign", CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '$'.
     */
    DOLLAR_SIGN(36, "dollar sign", CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '%'.
     */
    PERCENT_SIGN(37, "percent sign", CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '&'.
     */
    AMPERSAND(38, "ampersand", CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '''.
     */
    APOSTROPHE(39, "apostrophe", CharacterType.OTHER_PRINTABLE,
            '"'),
    /**
     * Constant for ascii character constant '('.
     */
    ROUND_BRACKET_START(40, "round bracket start",
            CharacterType.OTHER_PRINTABLE,
            ')'),
    /**
     * Constant for ascii character constant ')'.
     */
    ROUND_BRACKET_END(41, "round bracket end",
            CharacterType.OTHER_PRINTABLE,
            '('),
    /**
     * Constant for ascii character constant '*'.
     */
    ASTERISK(42, "asterisk",
            CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '+'.
     */
    PLUS_SIGN(43, "plus sign",
            CharacterType.OTHER_PRINTABLE,
            '-'),
    /**
     * Constant for ascii character constant ','.
     */
    COMMA(44, "comma",
            CharacterType.OTHER_PRINTABLE,
            '.'),
    /**
     * Constant for ascii character constant '-'.
     */
    MINUS_SIGN(45, "minus sign",
            CharacterType.OTHER_PRINTABLE,
            '+'),
    /**
     * Constant for ascii character constant '.'.
     */
    FULL_STOP(46, "full stop",
            CharacterType.OTHER_PRINTABLE,
            ','),
    /**
     * Constant for ascii character constant '/'.
     */
    SLASH(47, "slash",
            CharacterType.OTHER_PRINTABLE,
            '\\'),
    /**
     * Constant for ascii character constant '0'.
     */
    ZERO(48, "zero",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '1'.
     */
    ONE(49, "one",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '2'.
     */
    TWO(50, "two",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '3'.
     */
    THREE(51, "three",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '4'.
     */
    FOUR(52, "four",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '5'.
     */
    FIVE(53, "five",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '6'.
     */
    SIX(54, "six",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '7'.
     */
    SEVEN(55, "seven",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '8'.
     */
    EIGHT(56, "eight",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant '9'.
     */
    NINE(57, "nine",
            CharacterType.NUMBER),
    /**
     * Constant for ascii character constant ':'.
     */
    COLON(58, "colon",
            CharacterType.OTHER_PRINTABLE,
            ';'),
    /**
     * Constant for ascii character constant ';'.
     */
    SEMICOLON(59, "semicolon",
            CharacterType.OTHER_PRINTABLE,
            ':'),
    /**
     * Constant for ascii character constant '<'.
     */
    LESS_THAN_SIGN(60, "less than sign",
            CharacterType.OTHER_PRINTABLE,
            '>'),
    /**
     * Constant for ascii character constant '='.
     */
    EQUALS_SIGN(61, "equals sign",
            CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '>'.
     */
    GREATER_THAN_SIGN(62, "greater than sign",
            CharacterType.OTHER_PRINTABLE,
            '<'),
    /**
     * Constant for ascii character constant '?'.
     */
    QUESTION_MARK(63, "question mark",
            CharacterType.OTHER_PRINTABLE,
            '!'),
    /**
     * Constant for ascii character constant '@'.
     */
    AT_SIGN(64, "at sign",
            CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant 'A'.
     */
    A_UPPER(65, "a upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'B'.
     */
    B_UPPER(66, "b upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'C'.
     */
    C_UPPER(67, "c upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'D'.
     */
    D_UPPER(68, "d upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'E'.
     */
    E_UPPER(69, "e upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'F'.
     */
    F_UPPER(70, "f upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'G'.
     */
    G_UPPER(71, "g upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'H'.
     */
    H_UPPER(72, "h upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'I'.
     */
    I_UPPER(73, "i upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'J'.
     */
    J_UPPER(74, "j upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'K'.
     */
    K_UPPER(75, "k upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'L'.
     */
    L_UPPER(76, "l upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'M'.
     */
    M_UPPER(77, "m upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'N'.
     */
    N_UPPER(78, "n upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'O'.
     */
    O_UPPER(79, "o upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'P'.
     */
    P_UPPER(80, "p upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'Q'.
     */
    Q_UPPER(81, "q upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'R'.
     */
    R_UPPER(82, "r upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'S'.
     */
    S_UPPER(83, "s upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'T'.
     */
    T_UPPER(84, "t upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'U'.
     */
    U_UPPER(85, "u upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'V'.
     */
    V_UPPER(86, "v upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'W'.
     */
    W_UPPER(87, "w upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'X'.
     */
    X_UPPER(88, "x upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'Y'.
     */
    Y_UPPER(89, "y upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant 'Z'.
     */
    Z_UPPER(90, "z upper",
            CharacterType.UPPER_LETTER),
    /**
     * Constant for ascii character constant '['.
     */
    SQUARE_BRACKET_START(91,
            "square bracket start",
            CharacterType.OTHER_PRINTABLE,
            ']'),
    /**
     * Constant for ascii character constant '\'.
     */
    BACKSLASH(92, "backslash",
            CharacterType.OTHER_PRINTABLE,
            '/'),
    /**
     * Constant for ascii character constant ']'.
     */
    SQUARE_BRACKET_END(93, "square bracket end",
            CharacterType.OTHER_PRINTABLE,
            '['),
    /**
     * Constant for ascii character constant '^'.
     */
    CARET(94, "caret",
            CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant '_'.
     */
    UNDERSCORE(95, "underscore",
            CharacterType.OTHER_PRINTABLE,
            '|'),
    /**
     * Constant for ascii character constant '`'.
     */
    GRAVE_ACCENT(96, "grave accent",
            CharacterType.OTHER_PRINTABLE),
    /**
     * Constant for ascii character constant 'a'.
     */
    A_LOWER(97, "a lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'b'.
     */
    B_LOWER(98, "b lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'c'.
     */
    C_LOWER(99, "c lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'd'.
     */
    D_LOWER(100, "d lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'e'.
     */
    E_LOWER(101, "e lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'f'.
     */
    F_LOWER(102, "f lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'g'.
     */
    G_LOWER(103, "g lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'h'.
     */
    H_LOWER(104, "h lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'i'.
     */
    I_LOWER(105, "i lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'j'.
     */
    J_LOWER(106, "j lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'k'.
     */
    K_LOWER(107, "k lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'l'.
     */
    L_LOWER(108, "l lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'm'.
     */
    M_LOWER(109, "m lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'n'.
     */
    N_LOWER(110, "n lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'o'.
     */
    O_LOWER(111, "o lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'p'.
     */
    P_LOWER(112, "p lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'q'.
     */
    Q_LOWER(113, "q lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'r'.
     */
    R_LOWER(114, "r lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 's'.
     */
    S_LOWER(115, "s lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 't'.
     */
    T_LOWER(116, "t lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'u'.
     */
    U_LOWER(117, "u lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'v'.
     */
    V_LOWER(118, "v lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'w'.
     */
    W_LOWER(119, "w lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'x'.
     */
    X_LOWER(120, "x lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'y'.
     */
    Y_LOWER(121, "y lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant 'z'.
     */
    Z_LOWER(122, "z lower",
            CharacterType.LOWER_LETTER),
    /**
     * Constant for ascii character constant '{'.
     */
    CURLY_BRACKET_START(123,
            "curly bracket start",
            CharacterType.OTHER_PRINTABLE,
            '}'),
    /**
     * Constant for ascii character constant '|'.
     */
    VERTICAL_BAR(124, "vertical bar",
            CharacterType.OTHER_PRINTABLE,
            '_'),
    /**
     * Constant for ascii character constant '}'.
     */
    CURLY_BRACKET_END(125, "curly bracket end",
            CharacterType.OTHER_PRINTABLE,
            '{');
    /**
     * The position of the character.
     */
    @Getter
    private final int asciiPosition;

    /**
     * The character.
     */
    @Getter
    private final Character character;
    /**
     * Description of the character.
     */
    @Getter
    private final String description;

    /**
     * Character type.
     */
    @Getter
    private final CharacterType characterType;

    /**
     * Opposite character.
     */
    @Getter
    private final Character oppositeCharacter;

    /**
     * Constructor.
     *
     * @param asciiPositionIn position in ascii
     * @param descriptionIn   description of the character
     * @param characterTypeIn character type
     *                        asciiCharacter
     * @param oppositeCharIn  opposite ascii character
     */
    AsciiCharacter(final int asciiPositionIn, final String descriptionIn,
                   final CharacterType characterTypeIn,
                   final Character oppositeCharIn) {
        this.asciiPosition = asciiPositionIn;
        this.description = descriptionIn;
        this.character = (char) asciiPositionIn;
        this.characterType = characterTypeIn;

        if (oppositeCharIn == null) {
            if (this.characterType == CharacterType.UPPER_LETTER) {
                this.oppositeCharacter = Character.toLowerCase(character);
            } else if (this.characterType == CharacterType.LOWER_LETTER) {
                this.oppositeCharacter = Character.toUpperCase(character);
            } else {
                this.oppositeCharacter = null;
            }
        } else {
            this.oppositeCharacter = oppositeCharIn;
        }
    }

    /**
     * Constructor.
     *
     * @param asciiPositionIn position in ascii
     * @param descriptionIn   name of the character
     * @param characterTypeIn character type
     *                        asciiCharacter
     */
    AsciiCharacter(final int asciiPositionIn, final String descriptionIn,
                   final CharacterType characterTypeIn) {
        this(asciiPositionIn, descriptionIn, characterTypeIn, null);
    }

    /**
     * Returns character.
     *
     * @return character
     */
    public char toChar() {
        return getCharacter();
    }
    /**
     * Returns string.
     *
     * @return string
     */
    public String asString() {
        return String.valueOf(toChar());
    }

    /**
     * Returns AsciiCharacter based on the ch parameter, if possible,
     * otherwise returns null.
     *
     * @param ch input character
     * @return AsciiCharacter, if possible, otherwise null
     */
    public static AsciiCharacter ofCharacter(final char ch) {
        for (AsciiCharacter ac : AsciiCharacter.values()) {
            if (ac.getCharacter() == ch) {
                return ac;
            }
        }
        return null;
    }
}
