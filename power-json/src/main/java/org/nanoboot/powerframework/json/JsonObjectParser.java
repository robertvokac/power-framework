
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
