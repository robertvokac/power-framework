
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
import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Is used to create json arrays from Strings.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonArrayParser extends JsonParser {

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private JsonArrayParser() {
        //Not meant to be instantiated.
    }

    /**
     * Parses String to empty json object.
     *
     * @param jsonObject
     * @param stringRepresentationOfJsonObject
     * @return json object from parsed String
     */
    static JsonArray parseStringToJsonArray(JsonArray jsonArray, String stringRepresentationOfJsonArray) {
        if (!jsonArray.isEmpty()) {
            throw new PowerRuntimeException("I can't parse. The json array is not empty.");
        }
        String trimmedStringRepresentationOfJsonArray = stringRepresentationOfJsonArray.trim();
        if (!isStringJsonArray(trimmedStringRepresentationOfJsonArray)) {
            throw new PowerRuntimeException("I can't parse. The trimmed String does not start with [ or does not end with ]");
        }
        String collectionsOfValuesOfTheJsonArrayString = deleteTheCharAtTheStartAndTheEnd(trimmedStringRepresentationOfJsonArray);
        if ("".equals(collectionsOfValuesOfTheJsonArrayString)) {
            return jsonArray;
        }
        fillJsonArrayWithParsedValues(jsonArray, collectionsOfValuesOfTheJsonArrayString);
        return jsonArray;
    }

    private static boolean isStringJsonArray(String trimmedStringRepresentationOfJsonArray) {
        return (getFirstCharOfTheString(trimmedStringRepresentationOfJsonArray) == JsonSpecialCharSequences.getArrayLeft()) && (getLastCharOfTheString(trimmedStringRepresentationOfJsonArray) == JsonSpecialCharSequences.getArrayRight());
    }

    private static void fillJsonArrayWithParsedValues(JsonArray jsonArray, String collectionsOfValuesOfTheJsonArrayString) {

        ArrayList<Integer> listOfCommas = getListOfIndexesOfTheStringWhereCharIsCommaAndNestingIsZero(collectionsOfValuesOfTheJsonArrayString);

        int beginIndex;
        int indexOfComma = 0;
        for (int i = 0; i < listOfCommas.size(); i++) {
            beginIndex = ++indexOfComma;
            indexOfComma = listOfCommas.get(i);
            if (i == 0) {
                beginIndex = 0;
            }
            String fraction = collectionsOfValuesOfTheJsonArrayString.substring(beginIndex, indexOfComma);
            Object parsedObject = JsonParser.parseStringToValue(fraction);
            jsonArray.add(parsedObject);
        }

    }

}
