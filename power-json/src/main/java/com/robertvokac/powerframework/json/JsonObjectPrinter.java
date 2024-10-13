
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

import java.util.List;

/**
 * Used to create String representation of a json object.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonObjectPrinter extends JsonPrinter {

    /**
     * @param jsonObject
     * @return String representation of this json object in minimal version
     */
    static String toMinimalString(JsonObject jsonObject) {
        return toString(jsonObject, false);
    }

    /**
     * @param jsonObject
     * @return String representation of this json object in pretty toString
     * version
     */
    static String toPrettyString(JsonObject jsonObject) {
        return toString(jsonObject, true);
    }

    /**
     * @param jsonObject
     * @param printAsPrettyVersion
     * @return String representation of this json object
     */
    static String toString(JsonObject jsonObject,
                           boolean printAsPrettyVersion) {
        List<String> keyList = jsonObject.keyList();
        String value;
        String key;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JsonConstants.OBJECTSTART);
        if (printAsPrettyVersion) {
            stringBuilder.append(JsonConstants.LINEBREAK);
        }

        int setSize = keyList.size();
        int index = 0;
        int lastIndex = setSize - 1;
        for (String e : keyList){
            key = e;
            value = printAsPrettyVersion ? jsonObject.getJsonValue(key).toPrettyString() : jsonObject.getJsonValue(key).toMinimalString();

            if (printAsPrettyVersion) {
                stringBuilder.append(JsonConstants.TAB);
            }
            stringBuilder.append(JsonConstants.APOSTROPHE);
            stringBuilder.append(key);
            stringBuilder.append(JsonConstants.APOSTROPHE);
            stringBuilder.append(JsonConstants.COLON);

            if (printAsPrettyVersion && ((jsonObject.getJsonValue(key).isArray()) || (jsonObject.getJsonValue(key).isObject()))) {
                value = addTabOnEveryLineStartWithoutFirst(value);
            }

            stringBuilder.append(value);
            boolean hasNext = index != lastIndex;
            if (hasNext) {
                stringBuilder.append(",");
            }
            if (printAsPrettyVersion) {
                stringBuilder.append(JsonConstants.LINEBREAK);
            }
            index++;
        }
        stringBuilder.append(JsonConstants.OBJECTEND);

        return stringBuilder.toString();
    }

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private JsonObjectPrinter() {
        //Not meant to be instantiated.
    }
}
