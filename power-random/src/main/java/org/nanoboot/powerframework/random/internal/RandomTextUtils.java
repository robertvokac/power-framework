
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

package org.nanoboot.powerframework.random.internal;

import org.nanoboot.powerframework.random.RandomException;
import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.text.CharacterRange;
import org.nanoboot.powerframework.text.CharacterType;
/**
 * Utility for text randomness.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class RandomTextUtils {
    /**
     * Private constructor.
     */
    private RandomTextUtils() {
        //Instantiation not needed
    }
    /**
     * Returns random character.
     *
     * @param rg random generator to be used
     * @return random character
     */
    public static char nextChar(
            final RandomGenerator rg) {
        return nextChar(rg, null);
    }
    /**
     * Returns random character.
     *
     * @param rg random generator to be used
     * @param types type of characters to be used.
     * @return random character
     */
    public static char nextChar(
            final RandomGenerator rg, final CharacterType... types) {
        CharacterType[] characterTypes;
        if (types == null || types.length == 0) {
            characterTypes = new CharacterType[]{
                    CharacterType.NUMBER, CharacterType.LOWER_LETTER,
                    CharacterType.UPPER_LETTER};
        } else {
            characterTypes = types;
        }

        int charCount = 0;
        for (CharacterType type : characterTypes) {
            if (type == CharacterType.OTHER_NOT_PRINTABLE) {
                String msg =
                        "CharacterType.OTHER_NOT_PRINTABLE is not supported";
                throw new UnsupportedOperationException(msg);
            }
            charCount = charCount + CharacterRange.getInstance(type).size();
        }

        int randomPosition = rg.nextInt(1, charCount);
        int currentPosition = 0;

        for (CharacterType type : characterTypes) {
            char[] array = CharacterRange.getInstance(type).getArray();
            for (char ch : array) {
                currentPosition++;
                if (currentPosition == randomPosition) {
                    return ch;
                }
            }
        }

        throw new RandomException("nextChar method failed."); //NOSONAR
    }
    /**
     * Returns random text consisting of letters or numbers.
     *
     * @param rg random generator to be used
     * @param length the size of the return String
     * @return random text using the given parameters
     */
    public static String nextText(
            final RandomGenerator rg, final int length) {
        return nextText(rg, length, null);
    }

    /**
     * Returns random text.
     *
     * @param rg random generator to be used
     * @param length the size of the return String
     * @param types  character types
     *               to use for the string to be returned.
     *               If empty or null: lower and upper
     *               letters and number only will be used.
     *               Note: CharacterType.OTHER_NOT_PRINTABLE
     *               is not supported.
     * @return random text using the given parameters
     */
    public static String nextText(
            final RandomGenerator rg, final int length,
            final CharacterType... types) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = nextChar(rg, types);
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}

