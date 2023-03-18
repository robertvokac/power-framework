
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

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static org.nanoboot.powerframework.json.JsonParser.deleteTheCharAtTheStartAndTheEnd;
import static org.nanoboot.powerframework.json.JsonParser.getFirstCharOfTheString;

/**
 * Represents json value.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonValue {

    static JsonValue parseStringToJsonValue(final String stringToParse) {//NOSONAR
        String trimmedStringToParse = stringToParse.trim();
        final char firstChar = getFirstCharOfTheString(trimmedStringToParse);

        if ("null".equals(trimmedStringToParse)) {
            return new JsonValue();
        }
        if (JsonConstants.OBJECTSTART == firstChar) {
            return new JsonValue(new JsonObject(trimmedStringToParse));
        }
        if (JsonConstants.ARRAYSTART == firstChar) {
            return new JsonValue(new JsonArray(trimmedStringToParse));
        }
        if ("true".equals(trimmedStringToParse)) {
            return new JsonValue(true);
        }
        if ("false".equals(trimmedStringToParse)) {
            return new JsonValue(false);
        }
        if (JsonConstants.APOSTROPHE == firstChar) {
            return parseStringToStringOrChar(trimmedStringToParse);
        }
        try {
            return parseStringToIntOrLongOrFloatOrDouble(trimmedStringToParse);
        } catch (Exception e) {
            throw new JsonException("Something went wrong. I am not able to parse: \"" + stringToParse + "\". " + e);
        }

    }

    private static JsonValue parseStringToStringOrChar(final String stringToParse) {
        String stringWithoutQuotes = deleteTheCharAtTheStartAndTheEnd(stringToParse);
        if (stringWithoutQuotes.length() == 1) {
            return new JsonValue(stringWithoutQuotes.charAt(0));
        } else {
            return new JsonValue(stringWithoutQuotes);
        }
    }

    private static JsonValue parseStringToIntOrLongOrFloatOrDouble(
            String stringToParse) {
        String intOrLongPattern = "-?[0-9]*";
        String floatOrDoublePattern = "-?([0-9]*)\\.([0-9]*)";

        if (Pattern.matches(floatOrDoublePattern, stringToParse)) {
            return parseStringToFloatOrDouble(stringToParse);
        }
        if (Pattern.matches(intOrLongPattern, stringToParse)) {
            return parseStringToIntOrLong(stringToParse);
        }
        throw new JsonException("I am not able to parse the number: \"" + stringToParse + "\".");
    }

    private static JsonValue parseStringToIntOrLong(final String stringToParse) {
        try {
            return new JsonValue(Integer.parseInt(stringToParse));
        } catch (NumberFormatException e) {
            //Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, e);
            try {
                return new JsonValue(Long.parseLong(stringToParse));
            } catch (NumberFormatException e2) {
                Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, e2);
                throw new JsonException("The number is too long.");
            }
        }
    }

    private static JsonValue parseStringToFloatOrDouble(final String stringToParse) {
        int digitsPrecision = 0;
        String stringToParseWithoutMinus = stringToParse;
        if (stringToParseWithoutMinus.startsWith("-")) {
            stringToParseWithoutMinus = stringToParseWithoutMinus.substring(1);
        }
        for (int i = 0; i < stringToParseWithoutMinus.length(); i++) {
            char currentChar = stringToParseWithoutMinus.charAt(i);
            if (currentChar == '.') {
                digitsPrecision = stringToParseWithoutMinus.length() - 1 - i;
                break;
            }
        }
        if (digitsPrecision > 6) {
            try {
                return new JsonValue(Double.parseDouble(stringToParse));
            } catch (NumberFormatException e) {
                //NOSONAR
                throw new JsonException("The number is too long.");
            }
        } else {
            return new JsonValue(Float.parseFloat(stringToParse));
        }
    }

    private JsonValueType jsonValueType = null;

    private JsonObject jsonObject;
    private JsonArray jsonArray;
    private boolean jsonBoolean;
    private String jsonString;
    private char jsonChar;
    private int jsonInt;
    private long jsonLong;
    private float jsonFloat;
    private double jsonDouble;

    JsonValue() {
        this.jsonValueType = JsonValueType.NULL;
    }

    JsonValue(JsonObject jsonObject) {
        this.jsonValueType = JsonValueType.OBJECT;
        this.jsonObject = jsonObject;
    }

    JsonValue(JsonArray jsonArray) {
        this.jsonValueType = JsonValueType.ARRAY;
        this.jsonArray = jsonArray;
    }

    JsonValue(boolean jsonBoolean) {
        this.jsonValueType = JsonValueType.BOOLEAN;
        this.jsonBoolean = jsonBoolean;
    }

    JsonValue(final String jsonString) {
        this.jsonValueType = JsonValueType.STRING;
        this.jsonString = jsonString;
    }

    JsonValue(char jsonLiteral) {
        this.jsonValueType = JsonValueType.CHAR;
        this.jsonChar = jsonLiteral;
    }

    JsonValue(int jsonInt) {
        this.jsonValueType = JsonValueType.INT;
        this.jsonInt = jsonInt;
    }

    JsonValue(long jsonLong) {
        this.jsonValueType = JsonValueType.LONG;
        this.jsonLong = jsonLong;
    }

    JsonValue(float jsonFloat) {
        this.jsonValueType = JsonValueType.FLOAT;
        this.jsonFloat = jsonFloat;
    }

    JsonValue(double jsonDouble) {
        this.jsonValueType = JsonValueType.DOUBLE;
        this.jsonDouble = jsonDouble;
    }

    JsonValueType getJsonValueType() {
        return this.jsonValueType;
    }

    boolean isJsonValueType(JsonValueType jsonValueType) {
        return this.jsonValueType == jsonValueType;
    }

    boolean isNull() {
        return isJsonValueType(JsonValueType.NULL);
    }

    boolean isObject() {
        return isJsonValueType(JsonValueType.OBJECT);
    }

    boolean isArray() {
        return isJsonValueType(JsonValueType.ARRAY);
    }

    boolean isBoolean() {
        return isJsonValueType(JsonValueType.BOOLEAN);
    }

    boolean isString() {
        return isJsonValueType(JsonValueType.STRING);
    }

    boolean isChar() {
        return isJsonValueType(JsonValueType.CHAR);
    }

    boolean isInt() {
        return isJsonValueType(JsonValueType.INT);
    }

    boolean isLong() {
        return isJsonValueType(JsonValueType.LONG);
    }

    boolean isFloat() {
        return isJsonValueType(JsonValueType.FLOAT);
    }

    boolean isDouble() {
        return isJsonValueType(JsonValueType.DOUBLE);
    }

    JsonObject getJsonObject() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.OBJECT);
        return this.jsonObject;
    }

    JsonArray getJsonArray() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.ARRAY);
        return this.jsonArray;
    }

    boolean getJsonBoolean() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.BOOLEAN);
        return this.jsonBoolean;
    }

    String getJsonString() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.STRING);
        return this.jsonString;
    }

    char getJsonChar() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.CHAR);
        return this.jsonChar;
    }

    int getJsonInt() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.INT);
        return this.jsonInt;
    }

    long getJsonLong() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.LONG);
        return this.jsonLong;
    }

    float getJsonFloat() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.FLOAT);
        return this.jsonFloat;
    }

    double getJsonDouble() {
        throwExceptionIfTypeDoesNotMatch(JsonValueType.DOUBLE);
        return this.jsonDouble;
    }

    private void throwExceptionIfTypeDoesNotMatch(
            JsonValueType wantedJsonValueType) {
        if (this.getJsonValueType().equals(wantedJsonValueType)) {
            return;
        }
        throw new JsonException("This JsonValue has no type " + wantedJsonValueType + " The value type is " + this.getJsonValueType().name());
    }

    String toPrettyString() {
        return toString(true);
    }

    String toMinimalString() {
        return toString(false);
    }

    String toString(boolean printAsPrettyVersion) {//NOSONAR
        switch (this.jsonValueType) {
            case NULL:
                return JsonConstants.NULL;
            case OBJECT:
                return printAsPrettyVersion ? this.getJsonObject().toPrettyString() : this.getJsonObject().toMinimalString();
            case ARRAY:
                return printAsPrettyVersion ? this.getJsonArray().toPrettyString() : this.getJsonArray().toMinimalString();
            case BOOLEAN:
                return JsonBoolean.toString(jsonBoolean);
            case STRING:
                return JsonString.toString(jsonString);
            case CHAR:
                return JsonChar.toString(jsonChar);
            case INT:
                return JsonInt.toString(jsonInt);
            case LONG:
                return JsonLong.toString(jsonLong);
            case FLOAT:
                return JsonFloat.toString(jsonFloat);
            case DOUBLE:
                return JsonDouble.toString(jsonDouble);
            default:
                throw new IllegalStateException("Enum error.");
        }
    }

    Object toObject() {//NOSONAR
        switch (jsonValueType) {
            case NULL:
                return null;

            case OBJECT:
                return this.getJsonObject();

            case ARRAY:
                return this.getJsonArray();

            case BOOLEAN:
                return this.jsonBoolean;

            case STRING:
                return this.jsonString;

            case CHAR:
                return this.jsonChar;

            case INT:
                return this.jsonInt;

            case LONG:
                return this.jsonLong;

            case FLOAT:
                return this.jsonFloat;

            case DOUBLE:
                return this.jsonDouble;

            default:
                throw new IllegalStateException("Enum error.");
        }

    }
}
