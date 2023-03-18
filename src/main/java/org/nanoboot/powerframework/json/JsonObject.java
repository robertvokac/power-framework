
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
import org.nanoboot.powerframework.collections.Dictionary;
import org.nanoboot.powerframework.collections.DictionaryKeyIterator;

/**
 * Represents json object of json. * @author Robert Vokac e-mail:
 * robertvokac@nanoboot.org
 */
public class JsonObject {

    private final Dictionary<JsonValue> dictionary = new Dictionary<>();

    /**
     * Constructor
     *
     * Used to create empty jsonObject.
     */
    public JsonObject() {
        // Used to create empty jsonObject.
    }

    /**
     * Constructor
     *
     * From String creates json object.
     *
     * @param textToParse
     */
    public JsonObject(String textToParse) {
        JsonObjectParser.parseStringToJsonObject(this, textToParse);
    }

    /**
     *
     * @return count of items(keys and its values) of this json object
     */
    public int getCountOfItems() {
        return dictionary.getCountOfItems();
    }

    /**
     *
     * @return result of this control
     */
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    /**
     *
     * @param key
     * @return result of this control
     */
    public boolean containsValueWithKey(String key) {
        return this.dictionary.containsValueWithKey(key);
    }

    /**
     * Add to this json object new key, object is converted to the most suitable
     * json value type and is set as value of the key.
     *
     * @param key
     * @param object
     * @return
     */
    public JsonObject add(String key, Object object) {//NOSONAR
        if (object == null) {
            addNull(key);
        } else {
            switch (object.getClass().getName()) {
                case "org.nanoboot.powerframework.json.JsonObject":
                    addObject(key, (JsonObject) object);
                    break;
                case "org.nanoboot.powerframework.json.JsonArray":
                    addArray(key, (JsonArray) object);
                    break;
                case "java.lang.Boolean":
                    addBoolean(key, (boolean) object);
                    break;
                case "java.lang.String":
                    addString(key, (String) object);
                    break;
                case "java.lang.Character":
                    addChar(key, (char) object);
                    break;
                case "java.lang.Integer":
                    addInt(key, (int) object);
                    break;
                case "java.lang.Long":
                    addLong(key, (long) object);
                    break;
                case "java.lang.Float":
                    addFloat(key, (float) object);
                    break;
                case "java.lang.Double":
                    addDouble(key, (double) object);
                    break;
                default:
                    throw new PowerRuntimeException("I can't add the given object as value.");
            }
        }
        return this;
    }

    /**
     * Add to this json object new key with null as value.
     *
     * @param key
     * @return
     */
    public JsonObject addNull(String key) {
        this.dictionary.addValue(key, new JsonValue());
        return this;
    }

    /**
     * Add to this json object new key with json object as value.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addObject(String key, JsonObject value) {
        this.dictionary.addValue(key, new JsonValue(value));
        return this;
    }

    /**
     **Add to this json object new key with json array as value.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addArray(String key, JsonArray value) {
        this.dictionary.addValue(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the boolean as the
     * value of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addBoolean(String key, boolean value) {
        this.dictionary.addValue(key, new JsonValue(new JsonBoolean(value)));
        return this;
    }

    /**
     * Add to this json object new key with the value of the String as the value
     * of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addString(String key, String value) {
        this.dictionary.addValue(key, new JsonValue(new JsonString(value)));
        return this;
    }

    /**
     * Add to this json object new key with the value of the char as the value
     * of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addChar(String key, char value) {
        this.dictionary.addValue(key, new JsonValue(new JsonChar(value)));
        return this;
    }

    /**
     * Add to this json object new key with the value of the int as the value of
     * the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addInt(String key, int value) {
        this.dictionary.addValue(key, new JsonValue(new JsonInt(value)));
        return this;
    }

    /**
     * Add to this json object new key with the value of the long as the value
     * of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addLong(String key, long value) {
        this.dictionary.addValue(key, new JsonValue(new JsonLong(value)));
        return this;
    }

    /**
     * Add to this json object new key with the value of the float as the value
     * of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addFloat(String key, float value) {
        this.dictionary.addValue(key, new JsonValue(new JsonFloat(value)));
        return this;
    }

    /**
     * Add to this json object new key with the value of the double as the value
     * of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public JsonObject addDouble(String key, double value) {
        this.dictionary.addValue(key, new JsonValue(new JsonDouble(value)));
        return this;
    }

    /**
     *
     * @param key
     * @return value type of the value of the given key
     */
    public JsonValueType getJsonValueType(String key) {
        return dictionary.getValue(key).getJsonValueType();
    }

    /**
     *
     * @param key
     * @return object instance converted from the value of the given key
     */
    public Object get(String key) {
        return dictionary.getValue(key).toObject();
    }

    /**
     *
     * @param key
     * @return json object from the value of the given key
     */
    public JsonObject getObject(String key) {
        return this.dictionary.getValue(key).getJsonObject();
    }

    /**
     *
     * @param key
     * @return json array from the value of the given key
     */
    public JsonArray getArray(String key) {
        return this.dictionary.getValue(key).getJsonArray();
    }

    /**
     *
     * @param key
     * @return boolean from the value of the given key
     */
    public boolean getBoolean(String key) {
        return this.dictionary.getValue(key).getJsonBoolean().getBoolean();
    }

    /**
     *
     * @param key
     * @return String from the value of the given key
     */
    public String getString(String key) {
        return this.dictionary.getValue(key).getJsonString().getString();
    }

    /**
     *
     * @param key
     * @return char from the value of the given key
     */
    public char getChar(String key) {
        return this.dictionary.getValue(key).getJsonChar().getChar();
    }

    /**
     *
     * @param key
     * @return int from the value of the given key
     */
    public int getInt(String key) {
        return this.dictionary.getValue(key).getJsonInt().getInt();
    }

    /**
     *
     * @param key
     * @return long from the value of the given key
     */
    public long getLong(String key) {
        return this.dictionary.getValue(key).getJsonLong().getLong();
    }

    /**
     *
     * @param key
     * @return float from the value of the given key
     */
    public float getFloat(String key) {
        return this.dictionary.getValue(key).getJsonFloat().getFloat();
    }

    /**
     *
     * @param key
     * @return double from the value of the given key
     */
    public double getDouble(String key) {
        return this.dictionary.getValue(key).getJsonDouble().getDouble();
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param object
     */
    public void update(String key, Object object) {//NOSONAR
        if (object == null) {
            updateNull(key);
        } else {
            switch (object.getClass().getName()) {
                case "org.nanoboot.powerframework.json.JsonObject":
                    updateObject(key, (JsonObject) object);
                    break;
                case "org.nanoboot.powerframework.json.JsonArray":
                    updateArray(key, (JsonArray) object);
                    break;
                case "java.lang.Boolean":
                    updateBoolean(key, (boolean) object);
                    break;
                case "java.lang.String":
                    updateString(key, (String) object);
                    break;
                case "java.lang.Character":
                    updateChar(key, (char) object);
                    break;
                case "java.lang.Integer":
                    updateInt(key, (int) object);
                    break;
                case "java.lang.Long":
                    updateLong(key, (long) object);
                    break;
                case "java.lang.Float":
                    updateFloat(key, (float) object);
                    break;
                case "java.lang.Double":
                    updateDouble(key, (double) object);
                    break;
                default:
                    throw new PowerRuntimeException("I can't add the given object as value.");
            }
        }
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     */
    public void updateNull(String key) {
        this.dictionary.updateValue(key, new JsonValue());
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateObject(String key, JsonObject value) {
        this.dictionary.updateValue(key, new JsonValue(value));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateArray(String key, JsonArray value) {
        this.dictionary.updateValue(key, new JsonValue(value));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateBoolean(String key, boolean value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonBoolean(value)));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateString(String key, String value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonString(value)));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateChar(String key, char value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonChar(value)));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateInt(String key, int value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonInt(value)));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateLong(String key, long value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonLong(value)));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateFloat(String key, float value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonFloat(value)));
    }

    /**
     * Updates the value of the given key.
     *
     * @param key
     * @param value
     */
    public void updateDouble(String key, double value) {
        this.dictionary.updateValue(key, new JsonValue(new JsonDouble(value)));
    }

    /**
     * Removes the key and its value.
     *
     * @param key
     */
    public void removeJsonValue(String key) {
        this.dictionary.removeValue(key);
    }

    /**
     *
     * @return String representation of this json object in minimal version
     */
    public String toMinimalString() {
        return JsonObjectPrinter.toMinimalString(this);
    }

    /**
     *
     * @return String representation of this json object in pretty print version
     */
    public String toPrettyString() {
        return JsonObjectPrinter.toPrettyString(this);
    }

    /**
     *
     * @return copy of this json object
     */
    public JsonObject getCopy() {
        String stringRepresentationOfThisObject = this.toMinimalString();
        return new JsonObject(stringRepresentationOfThisObject);
    }

    /**
     *
     * @return key iterator
     */
    public DictionaryKeyIterator getKeyIterator() {
        return this.dictionary.getKeyIterator();
    }

    JsonValue getJsonValue(String key) {
        return this.dictionary.getValue(key);
    }
}
