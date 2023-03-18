
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

import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Represents json value.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonValue {

    private JsonValueType jsonValueType = null;

    private JsonObject jsonObject = null;
    private JsonArray jsonArray = null;
    private JsonBoolean jsonBoolean = null;
    private JsonString jsonString = null;
    private JsonChar jsonChar = null;
    private JsonInt jsonInt = null;
    private JsonLong jsonLong = null;
    private JsonFloat jsonFloat = null;
    private JsonDouble jsonDouble = null;

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

    JsonValue(JsonBoolean jsonBoolean) {
        this.jsonValueType = JsonValueType.BOOLEAN;
        this.jsonBoolean = jsonBoolean;
    }

    JsonValue(JsonString jsonString) {
        this.jsonValueType = JsonValueType.STRING;
        this.jsonString = jsonString;
    }

    JsonValue(JsonChar jsonLiteral) {
        this.jsonValueType = JsonValueType.CHAR;
        this.jsonChar = jsonLiteral;
    }

    JsonValue(JsonInt jsonInt) {
        this.jsonValueType = JsonValueType.INT;
        this.jsonInt = jsonInt;
    }

    JsonValue(JsonLong jsonLong) {
        this.jsonValueType = JsonValueType.LONG;
        this.jsonLong = jsonLong;
    }

    JsonValue(JsonFloat jsonFloat) {
        this.jsonValueType = JsonValueType.FLOAT;
        this.jsonFloat = jsonFloat;
    }

    JsonValue(JsonDouble jsonDouble) {
        this.jsonValueType = JsonValueType.DOUBLE;
        this.jsonDouble = jsonDouble;
    }

    JsonValueType getJsonValueType() {
        return this.jsonValueType;
    }

    boolean isNull() {
        return this.jsonValueType == JsonValueType.NULL;
    }

    boolean isObject() {
        return this.jsonValueType == JsonValueType.OBJECT;
    }

    boolean isArray() {
        return this.jsonValueType == JsonValueType.ARRAY;
    }

    boolean isBoolean() {
        return this.jsonValueType == JsonValueType.BOOLEAN;
    }

    boolean isString() {
        return this.jsonValueType == JsonValueType.STRING;
    }

    boolean isChar() {
        return this.jsonValueType == JsonValueType.CHAR;
    }

    boolean isInt() {
        return this.jsonValueType == JsonValueType.INT;
    }

    boolean isLong() {
        return this.jsonValueType == JsonValueType.LONG;
    }

    boolean isFloat() {
        return this.jsonValueType == JsonValueType.FLOAT;
    }

    boolean isDouble() {
        return this.jsonValueType == JsonValueType.DOUBLE;
    }

    JsonObject getJsonObject() {
        if (this.isObject()) {
            return this.jsonObject;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonObject");
        }
    }

    JsonArray getJsonArray() {
        if (this.isArray()) {
            return this.jsonArray;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonArray");
        }
    }

    JsonBoolean getJsonBoolean() {
        if (this.isBoolean()) {
            return this.jsonBoolean;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonBoolean");
        }
    }

    JsonString getJsonString() {
        if (this.isString()) {
            return this.jsonString;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonString");
        }
    }

    JsonChar getJsonChar() {
        if (this.isChar()) {
            return this.jsonChar;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonChar");
        }
    }

    JsonInt getJsonInt() {
        if (this.isInt()) {
            return this.jsonInt;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonInt");
        }
    }

    JsonLong getJsonLong() {
        if (this.isLong()) {
            return this.jsonLong;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonLong");
        }
    }

    JsonFloat getJsonFloat() {
        if (this.isFloat()) {
            return this.jsonFloat;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonFloat");
        }
    }

    JsonDouble getJsonDouble() {
        if (this.isDouble()) {
            return this.jsonDouble;
        } else {
            throw new PowerRuntimeException("This JsonValue has no type JsonDouble");
        }
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
                return JsonSpecialCharSequences.getNull();
            case OBJECT:
                if (printAsPrettyVersion) {
                    return this.getJsonObject().toPrettyString();
                } else {
                    return this.getJsonObject().toMinimalString();
                }
            case ARRAY:
                if (printAsPrettyVersion) {
                    return this.getJsonArray().toPrettyString();
                } else {
                    return this.getJsonArray().toMinimalString();
                }
            case BOOLEAN:
                return this.getJsonBoolean().toString();

            case STRING:
                return this.getJsonString().toString();
            case CHAR:
                return this.getJsonChar().toString();
            case INT:
                return this.getJsonInt().toString();
            case LONG:
                return this.getJsonLong().toString();
            case FLOAT:
                return this.getJsonFloat().toString();
            case DOUBLE:
                return this.getJsonDouble().toString();
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
                return this.getJsonBoolean().getBoolean();

            case STRING:
                return this.getJsonString().getString();

            case CHAR:
                return this.getJsonChar().getChar();

            case INT:
                return this.getJsonInt().getInt();

            case LONG:
                return this.getJsonLong().getLong();

            case FLOAT:
                return this.getJsonFloat().getFloat();

            case DOUBLE:
                return this.getJsonDouble().getDouble();

            default:
                throw new IllegalStateException("Enum error.");
        }

    }
}
