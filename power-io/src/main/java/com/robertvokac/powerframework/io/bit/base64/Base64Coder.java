
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

package com.robertvokac.powerframework.io.bit.base64;

import com.robertvokac.powerframework.core.PowerException;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class Base64Coder {

    private static Base64Implementation BASE64_IMPLEMENTATION = Base64Implementation.JAVA;

    static {
        //setBase64Implementation(Base64Implementation.JAVA);
    }

    /**
     *
     * @param encodedDataIn
     *
     * @return
     */
    public static byte[] decode(String encodedDataIn) {
        switch (BASE64_IMPLEMENTATION) {
            case OKAY:
                return OkayBase64Decoder.decode(encodedDataIn);
            case JAVA:
                return JavaBase64Coder.decode(encodedDataIn);
            default: {
                throw new PowerException("Unknown Base64Implementation " + BASE64_IMPLEMENTATION.name() + ".");
            }
        }
    }

    /**
     *
     * @param byteArrayIn
     *
     * @return
     */
    public static String encode(byte[] byteArrayIn) {
        switch (BASE64_IMPLEMENTATION) {
            case OKAY:
                return OkayBase64Encoder.encode(byteArrayIn);
            case JAVA:
                return JavaBase64Coder.encode(byteArrayIn);
            default: {
                throw new PowerException("Unknown Base64Implementation " + BASE64_IMPLEMENTATION.name() + ".");
            }
        }

    }

    public static Base64Implementation getBase64Implementation() {
        return BASE64_IMPLEMENTATION;
    }

    public static void setBase64Implementation(
            Base64Implementation base64Implementation) {
        Base64Coder.BASE64_IMPLEMENTATION = base64Implementation;
    }

}
