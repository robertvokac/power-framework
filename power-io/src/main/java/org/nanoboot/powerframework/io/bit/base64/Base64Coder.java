
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

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
