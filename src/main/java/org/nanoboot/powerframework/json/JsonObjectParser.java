
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
 * Is used to create json objects from strings.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonObjectParser extends JsonParser {

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private JsonObjectParser() {
        //Not meant to be instantiated.
    }

    /**
     * Parses String to empty json object.
     *
     * @param jsonObject
     * @param stringRepresentationOfJsonObject
     * @return json object from parsed String
     */
    static JsonObject parseStringToJsonObject(JsonObject jsonObject, String stringRepresentationOfJsonObject) {
        if (!jsonObject.isEmpty()) {
            throw new PowerRuntimeException("I can't parse. The json object is not empty.");
        }
        String trimmedStringRepresentationOfJsonObject = stringRepresentationOfJsonObject.trim();
        if (!isStringJsonObject(trimmedStringRepresentationOfJsonObject)) {
            throw new PowerRuntimeException("I can't parse. The trimmed String does not start with { or does not end with }");
        }
        String collectionsOfValuesOfTheJsonObjectString = deleteTheCharAtTheStartAndTheEnd(trimmedStringRepresentationOfJsonObject);

        fillJsonObjectWithParsedValues(jsonObject, collectionsOfValuesOfTheJsonObjectString);
        return jsonObject;
    }

    private static boolean isStringJsonObject(String trimmedStringRepresentationOfJsonObject) {
        return (getFirstCharOfTheString(trimmedStringRepresentationOfJsonObject) == JsonSpecialCharSequences.getObjectLeft()) && (getLastCharOfTheString(trimmedStringRepresentationOfJsonObject) == JsonSpecialCharSequences.getObjectRight());
    }

    private static void fillJsonObjectWithParsedValues(JsonObject jsonObject, String collectionsOfValuesOfTheJsonObjectString) {

        ArrayList<Integer> listOfCommas = getListOfIndexesOfTheStringWhereCharIsCommaAndNestingIsZero(collectionsOfValuesOfTheJsonObjectString);
        int beginIndex;
        int indexOfComma = 0;
        for (int i = 0; i < listOfCommas.size(); i++) {
            beginIndex = ++indexOfComma;
            indexOfComma = listOfCommas.get(i);
            if (i == 0) {
                beginIndex = 0;
            }
            String fraction = collectionsOfValuesOfTheJsonObjectString.substring(beginIndex, indexOfComma);

            String key = getKeyFromKeyValue(fraction).trim();
            key = key.substring(1, key.length() - 1);
            Object parsedObject = JsonParser.parseStringToValue(getValueFromKeyValue(fraction));

            jsonObject.add(key, parsedObject);
        }

    }

    private static String getKeyFromKeyValue(String string) {
        return getKeyOrValueFromKeyValue(string, true);
    }

    private static String getValueFromKeyValue(String string) {
        return getKeyOrValueFromKeyValue(string, false);
    }

    private static String getKeyOrValueFromKeyValue(String string, boolean trueForKeyFalseForValue) {
        String stringToReturn;
        int intToSaveColonIndex;
        for (intToSaveColonIndex = 0; intToSaveColonIndex < string.length(); intToSaveColonIndex++) {
            char currentChar = string.charAt(intToSaveColonIndex);
            if (currentChar == JsonSpecialCharSequences.getColon()) {
                break;
            }
        }
        stringToReturn = trueForKeyFalseForValue ? string.substring(0, intToSaveColonIndex) : string.substring(++intToSaveColonIndex, string.length());

        return stringToReturn;
    }
}
