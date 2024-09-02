
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
