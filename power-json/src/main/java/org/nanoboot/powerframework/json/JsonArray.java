
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

import java.util.ArrayList;

/**
 * Represents json array.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class JsonArray {
//TODO implement serializable interface

    private ArrayList<JsonValue> arrayList = new ArrayList<>();

    /**
     * Constructor
     * <p>
     * Used to create empty jsonObject.
     */
    public JsonArray() {
        //Used to create empty jsonObject.
    }

    /**
     * Constructor
     * <p>
     * From String creates json array.
     *
     * @param stringRepresentationOfThisJsonArray
     */
    public JsonArray(final String stringRepresentationOfThisJsonArray) {
        JsonArrayParser.parseStringToJsonArray(this, stringRepresentationOfThisJsonArray);
    }

    /**
     * @return count of items of this json array.
     */
    public int size() {
        return this.arrayList.size();
    }

    /**
     * @return result of this control
     */
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    public void clear() {
        this.arrayList.clear();
    }

    /**
     * New value is added- object is converted to the most suitable json value
     * type and is set as the new value.
     *
     * @param object
     * @return
     */
    public JsonArray add(Object object) {//NOSONAR
        if (object == null) {
            addNull();
        } else {
            switch (object.getClass().getName()) {
                case "org.nanoboot.powerframework.json.JsonObject":
                    addObject((JsonObject) object);
                    break;
                case "org.nanoboot.powerframework.json.JsonArray":
                    addArray((JsonArray) object);
                    break;
                case "java.lang.Boolean":
                    addBoolean((boolean) object);
                    break;
                case "java.lang.String":
                    addString((String) object);
                    break;
                case "java.lang.Character":
                    addChar((char) object);
                    break;
                case "java.lang.Integer":
                    addInt((int) object);
                    break;
                case "java.lang.Long":
                    addLong((long) object);
                    break;
                case "java.lang.Float":
                    addFloat((float) object);
                    break;
                case "java.lang.Double":
                    addDouble((double) object);
                    break;
                default:
                    throw new JsonException(object.getClass().getName() + " I can't add the given object (" + object.getClass().getName() + ") as value.");
            }
        }
        return this;
    }

    void addJsonValue(JsonValue jsonValue) {
        this.arrayList.add(jsonValue);
    }

    /**
     * Adds null.
     *
     * @return
     */
    public JsonArray addNull() {
        this.arrayList.add(new JsonValue());
        return this;
    }

    /**
     * Adds json object.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addObject(JsonObject value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds json array.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addArray(JsonArray value) {//this
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds boolean.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addBoolean(boolean value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds String.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addString(final String value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds char.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addChar(char value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds int.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addInt(int value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds long.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addLong(long value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds float.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addFloat(float value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds double.
     *
     * @param value value to use
     * @return
     */
    public JsonArray addDouble(double value) {
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @return json value type of the value at the given index
     */
    public JsonValueType getJsonValueType(int index) {
        return this.arrayList
                .get(index)
                .getJsonValueType();
    }

    /**
     * @param index
     * @return JsonObject
     */
    public JsonObject getObject(int index) {
        return this.arrayList.get(index).getJsonObject();
    }

    /**
     * @param index
     * @return JsonArraz
     */
    public JsonArray getArray(int index) {
        return this.arrayList.get(index).getJsonArray();
    }

    /**
     * @param index
     * @return boolean
     */
    public boolean getBoolean(int index) {
        return this.arrayList.get(index).getJsonBoolean();
    }

    /**
     * @param index
     * @return String
     */
    public String getString(int index) {
        return this.arrayList.get(index).getJsonString();
    }

    /**
     * @param index
     * @return char
     */
    public char getChar(int index) {
        return this.arrayList.get(index).getJsonChar();
    }

    /**
     * @param index
     * @return int
     */
    public int getInt(int index) {
        return this.arrayList.get(index).getJsonInt();
    }

    /**
     * @param index
     * @return long
     */
    public long getLong(int index) {
        return this.arrayList.get(index).getJsonLong();
    }

    /**
     * @param index
     * @return float
     */
    public float getFloat(int index) {
        return this.arrayList.get(index).getJsonFloat();
    }

    /**
     * @param index
     * @return double
     */
    public double getDouble(int index) {
        return this.arrayList.get(index).getJsonDouble();
    }

    /**
     * @param index to be updated
     * @return
     */
    public JsonArray updateNull(int index) {
        this.arrayList.set(index, new JsonValue());
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateObject(int index,
                                  JsonObject value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateArray(int index,
                                 JsonArray value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateBoolean(int index,
                                   boolean value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateString(int index,
                                  String value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateChar(int index,
                                char value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateInt(int index,
                               int value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateLong(int index,
                                long value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateFloat(int index,
                                 float value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * @param index
     * @param value value to use to be updated
     * @return
     */
    public JsonArray updateDouble(int index,
                                  double value) {
        this.arrayList.set(index, new JsonValue(value));
        return this;
    }

    /**
     * Removes value with the given index.
     *
     * @param index
     */
    public void removeJsonValue(int index) {
        this.arrayList.remove(index);
    }

    JsonValue getJsonValue(int index) {
        return this.arrayList.get(index);
    }

    boolean isJsonValueType(int index,
                            JsonValueType jsonValueType) {
        return this.getJsonValueType(index) == jsonValueType;
    }

    public String toString(JsonPrint jsonPrint) {
        switch (jsonPrint) {
            case MINIMAL: {
                return toMinimalString();
            }
            case PRETTY: {
                return toPrettyString();
            }
            default:
                throw new JsonException("Unknown JsonPrint: " + jsonPrint);
        }
    }

    /**
     * @return representation of this json array as minimal String
     */
    public String toMinimalString() {
        return JsonArrayPrinter.toMinimalString(this);
    }

    /**
     * @return representation of this json array as pretty String
     */
    public String toPrettyString() {
        return JsonArrayPrinter.toPrettyString(this);
    }

    /**
     * @return copy of this json array
     */
    public JsonArray getCopy() {
        String stringRepresentationOfThisArray = this.toMinimalString();
        return new JsonArray(stringRepresentationOfThisArray);
    }

}
