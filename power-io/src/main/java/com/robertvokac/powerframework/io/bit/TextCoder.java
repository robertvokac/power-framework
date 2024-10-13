
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

package com.robertvokac.powerframework.io.bit;

/*
 *
 *
 * tab
 * breakline
 * upper letter
 * unicode one char start
 * unicode start
 * unicode end
 * !
 * "
 * #
 * $
 * %
 * '
 *
 * +
 * ,
 * .
 * /
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * :
 * <
 * =
 * ?
 * @
 * a
 * b
 * c
 * d
 * e
 * f
 * g
 * h
 * i
 * j
 * k
 * l
 * m
 * n
 * o
 * p
 * q
 * r
 * s
 * t
 * u
 * v
 * w
 * x
 * y
 * z
 * ~
 * (
 * {
 * {
 * _
 * Reverse
 * +-
 * /\
 * ()
 * []
 * {}
 * <>
 * |_
 * ~^
 * %&
 * :;
 * '`
 *
 *
 * tab
 * breakline
 * upper letter
 * unicode one char start
 * unicode start
 * unicode end
 * !
 * "
 * #
 * $
 * %
 * &
 * '
 *
 * +
 * ,
 * -
 * .
 * /
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * :
 * ;
 * <
 * =
 * >
 * ?
 * @
 * \
 * a
 * b
 * c
 * d
 * e
 * f
 * g
 * h
 * i
 * j
 * k
 * l
 * m
 * n
 * o
 * p
 * q
 * r
 * s
 * t
 * u
 * v
 * w
 * x
 * y
 * z
 * Extension
 * `
 * ~
 * ^
 * (
 * )
 * {
 * }
 * {
 * }
 * _
 * |
 *
 *
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.robertvokac.powerframework.core.exceptions.NotYetImplementedException;
import com.robertvokac.powerframework.core.PowerObject;
import com.robertvokac.powerframework.core.PowerException;

/**
 * Here goes the description of this class.
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 *
 */
public class TextCoder extends PowerObject {

    
    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";
    private static final String ALPHABET = "1234567890abcdefghijklmnopqrstuvwxyz!?\"'#$%+*,./:<=@~({{_";
    private static final char[] charArray = ALPHABET.toCharArray();

    public static Blob encode(String string) {
        return null;
    }

    public static String decode(Blob blob) {
        return null;
    }

    private static boolean[] charToBooleanArray(char charIn) {
        for (int i = 0; i < charArray.length; i++) {
            char value = charArray[i];
            if(value == charIn) {
                int intValue = i + 1;
                String binaryString = String.format("%60s", Integer.toBinaryString(intValue));
                boolean[] returnValue = new boolean[6];
                for (int j = 0; j < 6; j++) {
                    returnValue[j] = binaryString.charAt(j) == '1';
                }
                return returnValue;
            }
        }
        throw new PowerException("Char " + charIn + " was not found.");
    }

//    private static boolean[] booleanArrayToChar(boolean[] booleanArrayIn) {
//        for (int i = 0; i < charArray.length; i++) {
//            char value = charArray[i];
//            if(value == charIn) {
//                int intValue = i + 1;
//                String binaryString = String.format("%60s", Integer.toBinaryString(intValue));
//                boolean[] returnValue = new boolean[6];
//                for (int j = 0; j < 6; j++) {
//                    returnValue[j] = binaryString.charAt(j) == '1';
//                }
//                return returnValue;
//            }
//        }
//        throw new DataStoringException("Char " + charIn + " was not found.");
//    }
    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private TextCoder() {
    }

    /**
     * Field description
     */
    private String name;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     * /
     * private TextCoder() {
     * }
     *
     * /**
     * Constructor
     *
     * Constructor description
     *
     * @param nameIn
     */
    public TextCoder(String nameIn) {
        this.name = nameIn;
    }


    @Override
    public String toString() {
        throw new NotYetImplementedException("toString");
        /**
         * LOG.traceStartOfMethod(this, "toString");
         * return NAMEFIELD+"="+name;
         */
    }

}
