
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

package org.nanoboot.powerframework.log;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

class MethodStartMessageCreator {

    private static final String ARGUMENTSSTART = "(";
    private static final String ARGUMENTSEND = ")";

    private static final Object[] emptyObjectArray = new Object[]{};

    static String createMethodStartMessage(String methodName) {
        return createMethodStartMessage(methodName, emptyObjectArray);
    }

    static String createMethodStartMessage(String methodName,
            Object... typeValue) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("method ").append(methodName).append(" - start - ").append(ARGUMENTSSTART);

        {
            for (int i = 0; i < typeValue.length; i++) {
                if(i == typeValue.length) {
                    break;
                }
                stringBuilder.append(typeValue[i]);

                i++;
                if(i == typeValue.length) {
                    break;
                }
                stringBuilder.append("=");
                stringBuilder.append(typeValue[i]);

                if((i + 1) != typeValue.length) {
                    stringBuilder.append(", ");
                } else {
                    break;
                }
            }
        }

        stringBuilder.append(ARGUMENTSEND);
        if(typeValue.length % 2 != 0) {
            stringBuilder.append(" There is a mismatch: The length of typeValue.length%2!=0;");
        }
        return stringBuilder.toString();
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private MethodStartMessageCreator() {
    }

}
