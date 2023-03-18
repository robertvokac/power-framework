
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

import java.util.List;

/**
 * Used to create String representation of a json object.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
