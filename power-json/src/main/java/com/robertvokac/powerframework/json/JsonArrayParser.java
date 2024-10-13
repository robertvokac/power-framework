
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

import java.util.ArrayList;

/**
 * Is used to create json arrays from Strings.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonArrayParser extends JsonParser {

    /**
     * Parses String to empty json object.
     *
     * @param jsonArray
     * @param stringRepresentationOfJsonArray
     * @return json object from parsed String
     */
    static JsonArray parseStringToJsonArray(JsonArray jsonArray,
                                            String stringRepresentationOfJsonArray) {
        if (!jsonArray.isEmpty()) {
            throw new JsonException("I can't parse. The json array is not empty.");
        }
        String trimmedStringRepresentationOfJsonArray = stringRepresentationOfJsonArray.trim();
        if (!isStringJsonArray(trimmedStringRepresentationOfJsonArray)) {
            throw new JsonException("I can't parse. The trimmed String does not start with [ or does not end with ]: " + trimmedStringRepresentationOfJsonArray);
        }
        String collectionsOfValuesOfTheJsonArrayString = deleteTheCharAtTheStartAndTheEnd(trimmedStringRepresentationOfJsonArray);
        if ("".equals(collectionsOfValuesOfTheJsonArrayString)) {
            return jsonArray;
        }
        if ("".equals(collectionsOfValuesOfTheJsonArrayString.trim())) {
            return jsonArray;
        }
        fillJsonArrayWithParsedValues(jsonArray, collectionsOfValuesOfTheJsonArrayString);
        return jsonArray;
    }

    private static boolean isStringJsonArray(
            String trimmedStringRepresentationOfJsonArray) {
        return (getFirstCharOfTheString(trimmedStringRepresentationOfJsonArray) == JsonConstants.ARRAYSTART) && (getLastCharOfTheString(trimmedStringRepresentationOfJsonArray) == JsonConstants.ARRAYEND);
    }

    private static void fillJsonArrayWithParsedValues(JsonArray jsonArray,
                                                      String collectionsOfValuesOfTheJsonArrayString) {
        ArrayList<String> array = ArrayWithItemsSplitByComma.getListWithItemsSplitByComma(collectionsOfValuesOfTheJsonArrayString);
        for (final String element : array) {

            JsonValue jsonValue = JsonValue.parseStringToJsonValue(element);

            jsonArray.addJsonValue(jsonValue);
        }

    }

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private JsonArrayParser() {
        //Not meant to be instantiated.
    }

}
