
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
 * Represents json array.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class JsonArray {

    private ArrayList<JsonValue> arrayList = new ArrayList<>();

    /**
     * Constructor
     *
     * Used to create empty jsonObject.
     */
    public JsonArray() {
        //Used to create empty jsonObject.
    }

    /**
     * Constructor
     *
     * From String creates json array.
     *
     * @param stringRepresentationOfThisJsonArray
     */
    public JsonArray(String stringRepresentationOfThisJsonArray) {
        JsonArrayParser.parseStringToJsonArray(this, stringRepresentationOfThisJsonArray);
    }

    /**
     *
     * @return count of items of this json array.
     */
    public int getCountOfItems() {
        return this.arrayList.size();
    }

    /**
     *
     * @return result of this control
     */
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    /**
     * New value is added- object is converted to the most suitable json value
     * type and is set as the new value.
     *
     * @param object
     */
    public void add(Object object) {//NOSONAR
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
                    throw new PowerRuntimeException("I can't add the given object as value.");
            }
        }
    }

    /**
     * Adds null.
     */
    public void addNull() {
        this.arrayList.add(new JsonValue());
    }

    /**
     * Adds json object.
     *
     * @param value
     */
    public void addObject(JsonObject value) {
        this.arrayList.add(new JsonValue(value));
    }

    /**
     * Adds json array.
     *
     * @param value
     * @return
     */
    public JsonArray addArray(JsonArray value) {//this
        this.arrayList.add(new JsonValue(value));
        return this;
    }

    /**
     * Adds boolean.
     *
     * @param value
     */
    public void addBoolean(boolean value) {
        this.arrayList.add(new JsonValue(new JsonBoolean(value)));
    }

    /**
     * Adds String.
     *
     * @param value
     * @return
     */
    public JsonArray addString(String value) {
        this.arrayList.add(new JsonValue(new JsonString(value)));
        return this;
    }

    /**
     * Adds char.
     *
     * @param value
     */
    public void addChar(char value) {
        this.arrayList.add(new JsonValue(new JsonChar(value)));
    }

    /**
     * Adds int.
     *
     * @param value
     */
    public void addInt(int value) {
        this.arrayList.add(new JsonValue(new JsonInt(value)));
    }

    /**
     * Adds long.
     *
     * @param value
     */
    public void addLong(long value) {
        this.arrayList.add(new JsonValue(new JsonLong(value)));
    }

    /**
     * Adds float.
     *
     * @param value
     */
    public void addFloat(float value) {
        this.arrayList.add(new JsonValue(new JsonFloat(value)));
    }

    /**
     * Adds double.
     *
     * @param value
     */
    public void addDouble(double value) {
        this.arrayList.add(new JsonValue(new JsonDouble(value)));
    }

    /**
     *
     * @param index
     * @return json value type of the value at the given index
     */
    public JsonValueType getJsonValueType(int index) {
        return this.arrayList.get(index).getJsonValueType();
    }

    /**
     *
     * @param index
     * @return JsonObject
     */
    public JsonObject getObject(int index) {
        return this.arrayList.get(index).getJsonObject();
    }

    /**
     *
     * @param index
     * @return JsonArraz
     */
    public JsonArray getArray(int index) {
        return this.arrayList.get(index).getJsonArray();
    }

    /**
     *
     * @param index
     * @return boolean
     */
    public boolean getBoolean(int index) {
        return this.arrayList.get(index).getJsonBoolean().getBoolean();
    }

    /**
     *
     * @param index
     * @return String
     */
    public String getString(int index) {
        return this.arrayList.get(index).getJsonString().getString();
    }

    /**
     *
     * @param index
     * @return char
     */
    public char getChar(int index) {
        return this.arrayList.get(index).getJsonChar().getChar();
    }

    /**
     *
     * @param index
     * @return int
     */
    public int getInt(int index) {
        return this.arrayList.get(index).getJsonInt().getInt();
    }

    /**
     *
     * @param index
     * @return long
     */
    public long getLong(int index) {
        return this.arrayList.get(index).getJsonLong().getLong();
    }

    /**
     *
     * @param index
     * @return float
     */
    public float getFloat(int index) {
        return this.arrayList.get(index).getJsonFloat().getFloat();
    }

    /**
     *
     * @param index
     * @return double
     */
    public double getDouble(int index) {
        return this.arrayList.get(index).getJsonDouble().getDouble();
    }

    /**
     *
     * @param index to be updated
     */
    public void updateNull(int index) {
        this.arrayList.set(index, new JsonValue());
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateObject(int index, JsonObject value) {
        this.arrayList.set(index, new JsonValue(value));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateArray(int index, JsonArray value) {
        this.arrayList.set(index, new JsonValue(value));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateBoolean(int index, boolean value) {
        this.arrayList.set(index, new JsonValue(new JsonBoolean(value)));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateString(int index, String value) {
        this.arrayList.set(index, new JsonValue(new JsonString(value)));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateChar(int index, char value) {
        this.arrayList.set(index, new JsonValue(new JsonChar(value)));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateInt(int index, int value) {
        this.arrayList.set(index, new JsonValue(new JsonInt(value)));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateLong(int index, long value) {
        this.arrayList.set(index, new JsonValue(new JsonLong(value)));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateFloat(int index, float value) {
        this.arrayList.set(index, new JsonValue(new JsonFloat(value)));
    }

    /**
     *
     * @param index
     * @param value to be updated
     */
    public void updateDouble(int index, double value) {
        this.arrayList.set(index, new JsonValue(new JsonDouble(value)));
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

    /**
     *
     * @return representation of this json array as minimal String
     */
    public String toMinimalString() {
        return JsonArrayPrinter.toMinimalString(this);
    }

    /**
     *
     * @return representation of this json array as pretty String
     */
    public String toPrettyString() {
        return JsonArrayPrinter.toPrettyString(this);
    }

    /**
     *
     * @return copy of this json array
     */
    public JsonArray getCopy() {
        String stringRepresentationOfThisArray = this.toMinimalString();
        return new JsonArray(stringRepresentationOfThisArray);
    }

}
