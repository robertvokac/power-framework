
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

import org.nanoboot.powerframework.collections.DictionaryKeyIterator;

/**
 * Used to create String representation of a json object.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonObjectPrinter extends JsonPrinter {

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private JsonObjectPrinter() {
        //Not meant to be instantiated.
    }

    /**
     * @param jsonObject
     *
     * @return String representation of this json object in minimal version
     */
    static String toMinimalString(JsonObject jsonObject) {
        return toString(jsonObject, false);
    }

    /**
     * @param jsonObject
     *
     * @return String representation of this json object in pretty print version
     */
    static String toPrettyString(JsonObject jsonObject) {
        return toString(jsonObject, true);
    }

    /**
     * @param jsonObject
     * @param printAsPrettyVersion
     *
     * @return String representation of this json object
     */
    static String toString(JsonObject jsonObject, boolean printAsPrettyVersion) {
        DictionaryKeyIterator keyIterator = jsonObject.getKeyIterator();
        String value;
        String key;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JsonSpecialCharSequences.getObjectLeft());
        if (printAsPrettyVersion) {
            stringBuilder.append(JsonSpecialCharSequences.getLineBreak());
        }

        while (keyIterator.hasNext()) {
            key = keyIterator.getNextKey();
            if (printAsPrettyVersion) {
                value = jsonObject.getJsonValue(key).toPrettyString();
            } else {
                value = jsonObject.getJsonValue(key).toMinimalString();
            }

            if (printAsPrettyVersion) {
                stringBuilder.append(JsonSpecialCharSequences.getTab());
            }
            stringBuilder.append(JsonSpecialCharSequences.getApostrophe());
            stringBuilder.append(key);
            stringBuilder.append(JsonSpecialCharSequences.getApostrophe());
            stringBuilder.append(JsonSpecialCharSequences.getColon());

            if (printAsPrettyVersion && ((jsonObject.getJsonValue(key).isArray()) || (jsonObject.getJsonValue(key).isObject()))) {
                value = addTabOnEveryLineStartWithoutFirst(value);
            }

            stringBuilder.append(value);
            if (keyIterator.hasNext()) {
                stringBuilder.append(",");
            }
            if (printAsPrettyVersion) {
                stringBuilder.append(JsonSpecialCharSequences.getLineBreak());
            }
        }
        stringBuilder.append(JsonSpecialCharSequences.getObjectRight());

        return stringBuilder.toString();
    }
}
