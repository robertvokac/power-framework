
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

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class CharacterRangeTest {

    @Test(expected = AssertionError.class)
    public void constructor() {
        Constructor<CharacterRange> constructor= (Constructor<CharacterRange>) CharacterRange.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        try {
            CharacterRange obj = constructor.newInstance(CharacterType.OTHER_PRINTABLE, 10, 5);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new AssertionError("UnexpectedException: " + e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new AssertionError("UnexpectedException: " + e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new AssertionError("UnexpectedException: " + e);
        }
    }

    @Test
    public void constructor2() {
        Constructor<CharacterRange> constructor= (Constructor<CharacterRange>) CharacterRange.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        try {
            CharacterRange obj = constructor.newInstance(CharacterType.OTHER_PRINTABLE, 10, 15);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new AssertionError("UnexpectedException: " + e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new AssertionError("UnexpectedException: " + e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new AssertionError("UnexpectedException: " + e);
        }
        assertTrue("passed", true);
    }
    @Test
    public void getInstance() {
        assertEquals(CharacterRange.NUMBERS,
                CharacterRange.getInstance(CharacterType.NUMBER));
        assertEquals(CharacterRange.LOWER_LETTERS,
                CharacterRange.getInstance(CharacterType.LOWER_LETTER));
        assertEquals(CharacterRange.UPPER_LETTERS,
                CharacterRange.getInstance(CharacterType.UPPER_LETTER));
        assertEquals(CharacterRange.PRINTABLE_CHARACTERS_LETTERS,
                CharacterRange.getInstance(CharacterType.OTHER_PRINTABLE));

        try {
            CharacterRange.getInstance(CharacterType.OTHER_NOT_PRINTABLE);
            String msg =
                    "Exception TextException expected, because the following type is not supported: "
                    + CharacterType.OTHER_NOT_PRINTABLE;
            throw new AssertionError(msg);
        } catch (TextException e) {
            //passed
        }
    }

    @Test
    public void size() {
        int expected = CharacterRange.NUMBERS.getAsciiTo() - CharacterRange.NUMBERS.getAsciiFrom() + 1;
        int returned = CharacterRange.NUMBERS.size();
        assertEquals(expected, returned);
    }

    @Test
    public void getArray_numbers() {
        char[] expected = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] returned = CharacterRange.NUMBERS.getArray();

        assertArrayEquals(expected, returned);
    }
    @Test
    public void getArray_lowerLetters() {
        char[] expected = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] returned = CharacterRange.UPPER_LETTERS.getArray();

        assertArrayEquals(expected, returned);
    }
    @Test
    public void getArray_upperLetters() {
        char[] expected = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] returned = CharacterRange.LOWER_LETTERS.getArray();

        assertArrayEquals(expected, returned);
    }
    @Test
    public void getArray_printableCharacters() {
        char[] expected = new char[] {'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};
        char[] returned = CharacterRange.PRINTABLE_CHARACTERS_LETTERS.getArray();

        assertArrayEquals(expected, returned);
    }

    @Test
    public void getType() {
        assertEquals(CharacterType.NUMBER, CharacterRange.NUMBERS.getType());
        assertEquals(CharacterType.LOWER_LETTER, CharacterRange.LOWER_LETTERS.getType());
        assertEquals(CharacterType.UPPER_LETTER, CharacterRange.UPPER_LETTERS.getType());
        assertEquals(CharacterType.OTHER_PRINTABLE, CharacterRange.PRINTABLE_CHARACTERS_LETTERS.getType());
    }

    @Test
    public void getAsciiFrom() {
        assertEquals(48, CharacterRange.NUMBERS.getAsciiFrom());
    }

    @Test
    public void getAsciiTo() {
        assertEquals(57, CharacterRange.NUMBERS.getAsciiTo());
    }

}
