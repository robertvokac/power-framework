
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

import org.nanoboot.powerframework.collections.PowerMap;
import org.nanoboot.powerframework.core.PowerObject;


import java.util.List;
import java.util.Map;

/**
 * Represents json object of json. 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class JsonObject extends PowerObject {
    /**
     * Constant for Double.
     */
    private static final String JAVALANG_DOUBLE = "java.lang.Double";
    /**
     * Constant for double.
     */
    private static final String JAVALANG_FLOAT = "java.lang.Float";
    /**
     * Constant for Long.
     */
    private static final String JAVALANG_LONG = "java.lang.Long";
    /**
     * Constant for Integer.
     */
    private static final String JAVALANG_INTEGER = "java.lang.Integer";
    /**
     * Constant for Character.
     */
    private static final String JAVALANG_CHARACTER = "java.lang.Character";
    /**
     * Constant for String.
     */
    private static final String JAVALANG_STRING = "java.lang.String";
    /**
     * Constant for Boolean.
     */
    private static final String JAVALANG_BOOLEAN = "java.lang.Boolean";
    /**
     * Constant for JsonArray.
     */
    private static final String POWERJSON_JSON_ARRAY =
            "org.nanoboot.powerframework.json.JsonArray";
    /**
     * Constant for JsonObject.
     */
    private static final String POWERJSON_JSON_OBJECT =
            "org.nanoboot.powerframework.json.JsonObject";
    /**
     * Internal map.
     */
    private final Map<String, JsonValue> map = new PowerMap<>();
    /**
     * Json validation schema.
     */
    private JsonObject validationByJsonObject = null;

    /**
     * Constructor
     * <p>
     * Used to create empty jsonObject.
     */
    public JsonObject() {
        // Used to create empty jsonObject.
    }

    //todo
    //
//    /**
//     * Test of toJsonObject method, of class LinkedList.
//     */
//    @Test
//    public void testToJsonObject() {
//        //arrange
//        SingleLinkedList<String> linkedList0 = new SingleLinkedList<>();
//        String expectedString = "{\"firstNode\":{\"key\":\"\",\"element\":\"Jack\",\"next\":{\"key\":\"\",\"element\":\"Anne\",\"next\":{\"key\":\"\",\"element\":\"John\",\"next\":{\"key\":\"\",\"element\":\"George\",\"next\":{\"key\":\"\",\"element\":\"Kate\",\"next\":null}}}}},\"lastNode\":{\"key\":\"\",\"element\":\"Kate\",\"next\":null}}";
//        String returnedString;
//        //act
//        linkedList0
//                ;linkedList.addAfterLast("Jack")
//                ;linkedList.addAfterLast("Anne")
//                ;linkedList.addAfterLast("John")
//                ;linkedList.addAfterLast("George")
//                ;linkedList.addAfterLast("Kate");
//        returnedString = linkedList0.toJsonObject().toMinimalString();
//        //assert
//        assertEquals(expectedString, returnedString);
//
//    }



    /**
     * Constructor
     * <p>
     * From String creates json object.
     *
     * @param textToParse json as text
     */
    public JsonObject(final String textToParse) {
        JsonObjectParser.parseStringToJsonObject(this, textToParse);
    }

    /**
     * @param jsonObject json validating schema
     */
    public void setValidationJsonObject(final JsonObject jsonObject) {
        if (this.validationByJsonObject == null) {
            String msg = "The validation json object has been already set.";
            throw new JsonException(msg);
        }
        this.validationByJsonObject = jsonObject;
    }

    /**
     * @return copy of validating json
     */
    public JsonObject getValidationJsonObjectCopy() {
        return this.validationByJsonObject.getCopy();
    }

    /**
     * @return result of the validation
     */
    public boolean validate() {
        return false;
    }

    /**
     * @return count of items(keys and its values) of this json object
     */
    public int size() {
        return map.size();
    }

    /**
     * @return result of this control
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Removes all values of this json object.
     */
    public void clear() {
        this.map.clear();
    }

    /**
     * @param key key to use
     * @return result of this control
     */
    public boolean hasKey(final String key) {
        return this.map.containsKey(key);
    }

    /**
     * Add to this json object new key, object is converted to the most suitable
     * json value type and is set as value of the key.
     *
     * @param key key to use
     * @param object object to use
     * @return json object, which was added
     */
    public JsonObject add(final String key,
                          final Object object) {
        if (object == null) {
            addNull(key);
        } else {
            switch (object.getClass().getName()) {
                case POWERJSON_JSON_OBJECT:
                    addObject(key, (JsonObject) object);
                    break;
                case POWERJSON_JSON_ARRAY:
                    addArray(key, (JsonArray) object);
                    break;
                case JAVALANG_BOOLEAN:
                    addBoolean(key, (boolean) object);
                    break;
                case JAVALANG_STRING:
                    addString(key, (String) object);
                    break;
                case JAVALANG_CHARACTER:
                    addChar(key, (char) object);
                    break;
                case JAVALANG_INTEGER:
                    addInt(key, (int) object);
                    break;
                case JAVALANG_LONG:
                    addLong(key, (long) object);
                    break;
                case JAVALANG_FLOAT:
                    addFloat(key, (float) object);
                    break;
                case JAVALANG_DOUBLE:
                    addDouble(key, (double) object);
                    break;
                default:
                    String msg =
                            object.getClass().getName()
                                    + " I can't add the given object as value.";
                    throw new JsonException(msg);
            }
        }
        return this;
    }

    final void addJsonValue(final String key,
                      final JsonValue jsonValue) {
        this.map.put(key, jsonValue);
    }

    /**
     * Add to this json object new key with null as value.
     *
     * @param key key to use
     * @return this
     */
    public JsonObject addNull(final String key) {
        this.map.put(key, new JsonValue());
        return this;
    }

    /**
     * Add to this json object new key with json object as value.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addObject(final String key,
                                final JsonObject value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * *Add to this json object new key with json array as value.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addArray(final String key,
                               final JsonArray value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the boolean as the
     * value of the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addBoolean(final String key,
                                 final boolean value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the String as the value
     * of the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addString(final String key,
                                final String value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the char as the value
     * of the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addChar(final String key,
                              final char value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the int as the value of
     * the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addInt(final String key,
                             final int value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the long as the value
     * of the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addLong(final String key,
                              final long value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the float as the value
     * of the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addFloat(final String key,
                               final float value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    /**
     * Add to this json object new key with the value of the double as the value
     * of the key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject addDouble(final String key,
                                final double value) {
        this.map.put(key, new JsonValue(value));
        return this;
    }

    public boolean isNull(final String key) {
        return getJsonValueType(key) == JsonValueType.NULL;
    }
    /**
     * @param key key to use
     * @return value type of the value of the given key
     */
    public JsonValueType getJsonValueType(final String key) {
        return map.get(key).getJsonValueType();
    }

    final boolean isJsonValueType(final String key,
                            final JsonValueType jsonValueType) {
        return this.getJsonValueType(key) == jsonValueType;
    }

    /**
     * @param key key to use
     * @return object instance converted from the value of the given key
     */
    public Object get(final String key) {
        return map.get(key).toObject();
    }

    /**
     * @param key key to use
     * @return json object from the value of the given key
     */
    public JsonObject getObject(final String key) {
        return this.map.get(key).getJsonObject();
    }

    /**
     * @param key key to use
     * @return json array from the value of the given key
     */
    public JsonArray getArray(final String key) {
        return this.map.get(key).getJsonArray();
    }

    /**
     * @param key key to use
     * @return boolean from the value of the given key
     */
    public boolean getBoolean(final String key) {
        return this.map.get(key).getJsonBoolean();
    }

    /**
     * @param key key to use
     * @return String from the value of the given key
     */
    public String getString(final String key) {
        return this.map.get(key).getJsonString();
    }

    /**
     * @param key key to use
     * @return char from the value of the given key
     */
    public char getChar(final String key) {
        return this.map.get(key).getJsonChar();
    }

    /**
     * @param key key to use
     * @return int from the value of the given key
     */
    public int getInt(final String key) {
        return this.map.get(key).getJsonInt();
    }

    /**
     * @param key key to use
     * @return long from the value of the given key
     */
    public long getLong(final String key) {
        return this.map.get(key).getJsonLong();
    }

    /**
     * @param key key to use
     * @return float from the value of the given key
     */
    public float getFloat(final String key) {
        return this.map.get(key).getJsonFloat();
    }

    /**
     * @param key key to use
     * @return double from the value of the given key
     */
    public double getDouble(final String key) {
        return this.map.get(key).getJsonDouble();
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param object object to use
     * @return this
     */
    public JsonObject update(final String key,
                             final Object object) {
        if (object == null) {
            updateNull(key);
        } else {
            switch (object.getClass().getName()) {
                case POWERJSON_JSON_OBJECT:
                    updateObject(key, (JsonObject) object);
                    break;
                case POWERJSON_JSON_ARRAY:
                    updateArray(key, (JsonArray) object);
                    break;
                case JAVALANG_BOOLEAN:
                    updateBoolean(key, (boolean) object);
                    break;
                case JAVALANG_STRING:
                    updateString(key, (String) object);
                    break;
                case JAVALANG_CHARACTER:
                    updateChar(key, (char) object);
                    break;
                case JAVALANG_INTEGER:
                    updateInt(key, (int) object);
                    break;
                case JAVALANG_LONG:
                    updateLong(key, (long) object);
                    break;
                case JAVALANG_FLOAT:
                    updateFloat(key, (float) object);
                    break;
                case JAVALANG_DOUBLE:
                    updateDouble(key, (double) object);
                    break;
                default:
                    String msg = "I can't add the given object as value.";
                    throw new JsonException(msg);
            }
        }
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @return this
     */
    public JsonObject updateNull(final String key) {
        this.map.replace(key, new JsonValue());
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateObject(final String key,
                                   final JsonObject value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateArray(final String key,
                                  final JsonArray value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateBoolean(final String key,
                                    final boolean value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateString(final String key,
                                   final String value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateChar(final String key,
                                 final char value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateInt(final String key,
                                final int value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateLong(final String key,
                                 final long value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateFloat(final String key,
                                  final float value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Updates the value of the given key.
     *
     * @param key key to use
     * @param value value to use
     * @return this
     */
    public JsonObject updateDouble(final String key,
                                   final double value) {
        this.map.replace(key, new JsonValue(value));
        return this;
    }

    /**
     * Removes the key and its value.
     *
     * @param key key to use
     */
    public void removeJsonValue(final String key) {
        this.map.remove(key);
    }

    /**
     * @param jsonPrint object, which text representation will be created
     * @return string representation of this json object
     */
    public String toString(final JsonPrint jsonPrint) {
        switch (jsonPrint) {
            case MINIMAL: return toMinimalString();
            case PRETTY: return toPrettyString();
            default:
                throw new JsonException("Unknown JsonPrint: " + jsonPrint);
        }
    }

    /**
     * @return String representation of this json object in minimal version
     */
    public String toMinimalString() {
        return JsonObjectPrinter.toMinimalString(this);
    }

    /**
     * @return String representation of this json object in pretty toString
     * version
     */
    public String toPrettyString() {
        return JsonObjectPrinter.toPrettyString(this);
    }

    /**
     * @return copy of this json object
     */
    public JsonObject getCopy() {
        String stringRepresentationOfThisObject = this.toMinimalString();
        return new JsonObject(stringRepresentationOfThisObject);
    }

    /**
     * @return key iterator
     */
    public List<String> keyList() {
        return ((PowerMap) this.map).keyList();
    }

    final JsonValue getJsonValue(final String key) {
        return this.map.get(key);
    }

    @Override
    public final String toString() {
        return this.toMinimalString();
    }

}
