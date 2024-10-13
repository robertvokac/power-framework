
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

package com.robertvokac.powerframework.json;

/**
 * Used to create String representation of a json array.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonArrayPrinter {

    /**
     * @return representation of the json array as pretty String
     */
    static String toMinimalString(JsonArray jsonArray) {
        return toString(jsonArray, false);
    }

    /**
     * @return representation of the json array as pretty String
     */
    static String toPrettyString(JsonArray jsonArray) {
        return toString(jsonArray, true);

    }

    /**
     * @return representation of the json array as String
     */
    static String toString(JsonArray jsonArray,
                           boolean printAsPrettyVersion) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JsonConstants.ARRAYSTART);
        if (printAsPrettyVersion) {
            stringBuilder.append(JsonConstants.LINEBREAK);
        }
        int i = 0;

        String value;
        while (i != jsonArray.size()) {

            value = printAsPrettyVersion ? jsonArray.getJsonValue(i).toPrettyString() : jsonArray.getJsonValue(i).toMinimalString();
            if (printAsPrettyVersion) {
                if (!((jsonArray.getJsonValue(i).isArray()) || (jsonArray.getJsonValue(i).isObject()))) {
                    stringBuilder.append(JsonConstants.TAB);
                } else {
                    value = JsonPrinter.addTabOnEveryLineStart(value);
                }
            }

            stringBuilder.append(value);
            if ((i + 1) != jsonArray.size()) {
                stringBuilder.append(",");
            }
            if (printAsPrettyVersion) {
                stringBuilder.append("\n");
            }
            i++;
        }

        stringBuilder.append(JsonConstants.ARRAYEND);

        return stringBuilder.toString();

    }

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private JsonArrayPrinter() {
        //Not meant to be instantiated.
    }

}
