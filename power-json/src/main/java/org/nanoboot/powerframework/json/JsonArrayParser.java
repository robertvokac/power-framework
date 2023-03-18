
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

import java.util.ArrayList;

/**
 * Is used to create json arrays from Strings.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
