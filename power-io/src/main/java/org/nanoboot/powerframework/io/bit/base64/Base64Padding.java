
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

enum Base64Padding {

    NO(""),
    ONEBYTE("=="),
    TWOBYTE("=");

    private final String padding;

    Base64Padding(String paddingIn) {
        this.padding = paddingIn;
    }

    public String getPadding() {
        return padding;
    }

    static Base64Padding getBase64Padding(byte[] byteArrayIn) {
        int byteArrayInLength = byteArrayIn.length;
        switch (byteArrayInLength % 3) {
            case 0: {
                return NO;
            }
            case 1: {
                return ONEBYTE;
            }
            case 2: {
                return TWOBYTE;
            }
            default: {
                throw new PowerException("getPadding method: switch command went to default section. ");
            }
        }
    }

    static Base64Padding getBase64Padding(String encodedData) {
        if(org.nanoboot.powerframework.utils.StringUtils.isEmpty(encodedData)) {
            return NO;
        };
        boolean lastCharIsEqual = encodedData.charAt(encodedData.length() - 1) == '=';

        boolean beforeLastCharIsEqual = encodedData.charAt(encodedData.length() - 1 - 1) == '=';

        if(lastCharIsEqual) {
            if(beforeLastCharIsEqual) {
                return ONEBYTE;
            } else {
                return TWOBYTE;
            }
        } else {
            if(beforeLastCharIsEqual) {
                throw new PowerException("The last character is not \"=\", but the before last is.");
            } else {
                return NO;
            }
        }
    }
}
