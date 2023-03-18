
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

package org.nanoboot.powerframework.io.bit.base64;

import org.nanoboot.powerframework.core.PowerException;
import org.nanoboot.powerframework.io.bit.Byte;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

class Base64Convertor {

    private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    static char byteToChar(byte byteValue) {
        return ALPHABET[byteValue + 128];
    }

    static boolean[] convertCharToBooleanArray(char charIn) {
        byte byteValue = charToByte(charIn);
        return Byte.byteValueToBooleanArray(byteValue);
    }

    private static byte charToByte(char charIn) {
        if(charIn == '=') {
            return 0;
        }
        int index = 0;
        for (char element : ALPHABET) {
            if(element == charIn) {
//                System.out.println(charIn+" converted to "+(index));
                return (byte) (index - 128);
            }
            index++;
        }

        throw new PowerException(
                "There is no char: " + charIn);
    }

}
