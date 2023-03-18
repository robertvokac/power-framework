
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

package org.nanoboot.powerframework.json;

/**
 * Used to create String representation of a json array.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonArrayPrinter {

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private JsonArrayPrinter() {
        //Not meant to be instantiated.
    }

    /**
     *
     * @return representation of the json array as pretty String
     */
    static String toMinimalString(JsonArray jsonArray) {
        return toString(jsonArray, false);
    }

    /**
     *
     * @return representation of the json array as pretty String
     */
    static String toPrettyString(JsonArray jsonArray) {
        return toString(jsonArray, true);

    }

    /**
     *
     * @return representation of the json array as String
     */
    static String toString(JsonArray jsonArray, boolean printAsPrettyVersion) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JsonSpecialCharSequences.getArrayLeft());
        if (printAsPrettyVersion) {
            stringBuilder.append(JsonSpecialCharSequences.getLineBreak());
        }
        int i = 0;

        String value;
        while (i != jsonArray.getCountOfItems()) {
            if (printAsPrettyVersion) {
                value = jsonArray.getJsonValue(i).toPrettyString();
            } else {
                value = jsonArray.getJsonValue(i).toMinimalString();
            }
            if (printAsPrettyVersion) {
                if (!((jsonArray.getJsonValue(i).isArray()) || (jsonArray.getJsonValue(i).isObject()))) {
                    stringBuilder.append(JsonSpecialCharSequences.getTab());
                } else {
                    value = JsonPrinter.addTabOnEveryLineStart(value);
                }
            }

            stringBuilder.append(value);
            if ((i + 1) != jsonArray.getCountOfItems()) {
                stringBuilder.append(",");
            }
            if (printAsPrettyVersion) {
                stringBuilder.append("\n");
            }
            i++;
        }
        stringBuilder.append(JsonSpecialCharSequences.getArrayRight());

        return stringBuilder.toString();

    }

}
