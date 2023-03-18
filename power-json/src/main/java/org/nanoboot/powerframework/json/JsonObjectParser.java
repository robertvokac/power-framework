
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

import java.util.*;

/**
 * Is used to create json objects from strings.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonObjectParser extends JsonParser {

    /**
     * Parses String to empty json object.
     *
     * @param jsonObject
     * @param stringRepresentationOfJsonObject
     * @return json object from parsed String
     */
    static JsonObject parseStringToJsonObject(JsonObject jsonObject,
                                              String stringRepresentationOfJsonObject) {
        if (!jsonObject.isEmpty()) {
            throw new JsonException("I can't parse. The json object is not empty.");
        }
        String trimmedStringRepresentationOfJsonObject = stringRepresentationOfJsonObject.trim();
        if (!isStringJsonObject(trimmedStringRepresentationOfJsonObject)) {
            throw new JsonException("I can't parse. The trimmed String does not start with { or does not end with }");
        }
        String collectionsOfValuesOfTheJsonObjectString = deleteTheCharAtTheStartAndTheEnd(trimmedStringRepresentationOfJsonObject);

        ArrayList<String> array = ArrayWithItemsSplitByComma.getListWithItemsSplitByComma(collectionsOfValuesOfTheJsonObjectString);
        for (final String element : array) {
            JsonObjectKeyValue jsonObjectKeyValue = new JsonObjectKeyValue(element);
            String key = jsonObjectKeyValue.getKey();
            String value = jsonObjectKeyValue.getValue();
            JsonValue jsonValue = JsonValue.parseStringToJsonValue(value);
            //System.out.println("\n\nelement: " + element + "\nkey: " + key + " \nvalue: " + value + " " + jsonValue.getJsonValueType() + " " + jsonValue.toMinimalString());

            jsonObject.addJsonValue(key, jsonValue);
        }
        return jsonObject;
    }

    private static boolean isStringJsonObject(
            String trimmedStringRepresentationOfJsonObject) {
        return (getFirstCharOfTheString(trimmedStringRepresentationOfJsonObject) == JsonConstants.OBJECTSTART) && (getLastCharOfTheString(trimmedStringRepresentationOfJsonObject) == JsonConstants.OBJECTEND);
    }

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private JsonObjectParser() {
        //Not meant to be instantiated.
    }
}
