
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
import org.nanoboot.powerframework.collections.DictionaryKeyIterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class JsonObjectTest {

    /**
     *
     */
    public JsonObjectTest() {
    }

    /**
     * Test of constructor, of class JsonObject.
     */
    @Test
    public void testJsonObject() {
        //arrange
        String expectedString = "{\"date of death\":null,\"father\":{\"name\":\"Peter\",\"surname\":\"Black\"},\"mother\":{\"name\":\"Sue\",\"surname\":\"Black\"},\"property\":[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492],\"is rich\":true,\"name\":\"John\",\"surname\":\"Black\",\"date of birth\":\"1975-09-23\",\"favorit letter\":\"W\",\"year of birth\":1975,\"favorit very long number\":8798799845647987,\"height\":173.5466,\"height- high precision\":173.54666549879545}";
        String returnedString;

        JsonObject personJohnBlack;

        //act
        personJohnBlack = new JsonObject(expectedString);
        returnedString = personJohnBlack.toMinimalString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getCountOfItems method, of class JsonObject.
     */
    @Test
    public void testGetCountOfItems() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        int expectedValue = 4;
        int returnedValue;
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);
        returnedValue = jsonObject.getCountOfItems();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class JsonObject.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        returnedValue = jsonObject.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class JsonObject.
     */
    @Test
    public void testIsEmpty2() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);
        returnedValue = jsonObject.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsValueWithKey method, of class JsonObject.
     */
    @Test
    public void testContainsValueWithKey() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);
        returnedValue = jsonObject.containsValueWithKey("nick");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsValueWithKey method, of class JsonObject.
     */
    @Test
    public void testContainsValueWithKey2() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = false;
        boolean returnedValue;
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);
        returnedValue = jsonObject.containsValueWithKey("nationality");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of containsValueWithKey method, of class JsonObject.
     */
    @Test
    public void testContainsValueWithKey3() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addString("personality", "calm");
        returnedValue = jsonObject.containsValueWithKey("personality");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsNull() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.NULL;
        JsonValueType returnedValue;
        //act
        jsonObject.add("nothing", null);
        returnedValue = jsonObject.getJsonValueType("nothing");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsJsonObject() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.OBJECT;
        JsonValueType returnedValue;
        //act
        jsonObject.add("object", new JsonObject());
        returnedValue = jsonObject.getJsonValueType("object");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsJsonArray() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.ARRAY;
        JsonValueType returnedValue;
        //act
        jsonObject.add("array", new JsonArray());
        returnedValue = jsonObject.getJsonValueType("array");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsBoolean() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.BOOLEAN;
        JsonValueType returnedValue;
        //act
        jsonObject.add("boolean", true);
        returnedValue = jsonObject.getJsonValueType("boolean");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsString() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.STRING;
        JsonValueType returnedValue;
        //act
        jsonObject.add("String", "some text");
        returnedValue = jsonObject.getJsonValueType("String");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsChar() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.CHAR;
        JsonValueType returnedValue;
        //act
        jsonObject.add("char", 'a');
        returnedValue = jsonObject.getJsonValueType("char");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsInt() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.INT;
        JsonValueType returnedValue;
        //act
        jsonObject.add("int", 2);
        returnedValue = jsonObject.getJsonValueType("int");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsLong() {//arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.LONG;
        JsonValueType returnedValue;
        //act
        jsonObject.add("long", 2l);
        returnedValue = jsonObject.getJsonValueType("long");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsFloat() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.FLOAT;
        JsonValueType returnedValue;
        //act
        jsonObject.add("float", 2.5f);
        returnedValue = jsonObject.getJsonValueType("float");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of add method, of class JsonObject.
     */
    @Test
    public void testAdd_ObjectIsDouble() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.DOUBLE;
        JsonValueType returnedValue;
        //act
        jsonObject.add("double", 2.5d);
        returnedValue = jsonObject.getJsonValueType("double");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addNull method, of class JsonObject.
     */
    @Test
    public void testAddNull() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addNull("nothing");
        returnedValue = jsonObject.containsValueWithKey("nothing");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addObject method, of class JsonObject.
     */
    @Test
    public void testAddObject() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addObject("object", new JsonObject());
        returnedValue = jsonObject.containsValueWithKey("object");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addArray method, of class JsonObject.
     */
    @Test
    public void testAddArray() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addArray("array", new JsonArray());
        returnedValue = jsonObject.containsValueWithKey("array");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addBoolean method, of class JsonObject.
     */
    @Test
    public void testAddBoolean() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addBoolean("boolean", true);
        returnedValue = jsonObject.containsValueWithKey("boolean");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addString method, of class JsonObject.
     */
    @Test
    public void testAddString() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addString("String", "some text");
        returnedValue = jsonObject.containsValueWithKey("String");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addChar method, of class JsonObject.
     */
    @Test
    public void testAddChar() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addChar("char", 'a');
        returnedValue = jsonObject.containsValueWithKey("char");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addInt method, of class JsonObject.
     */
    @Test
    public void testAddInt() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addInt("int", 2);
        returnedValue = jsonObject.containsValueWithKey("int");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addLong method, of class JsonObject.
     */
    @Test
    public void testAddLong() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addLong("long", 2l);
        returnedValue = jsonObject.containsValueWithKey("long");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addFloat method, of class JsonObject.
     */
    @Test
    public void testAddFloat() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addFloat("float", 2.5f);
        returnedValue = jsonObject.containsValueWithKey("float");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addDouble method, of class JsonObject.
     */
    @Test
    public void testAddDouble() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        returnedValue = jsonObject.containsValueWithKey("double");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Null() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.NULL;
        JsonValueType returnedValue;
        //act
        jsonObject.addNull("nothing");
        returnedValue = jsonObject.getJsonValueType("nothing");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Object() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.OBJECT;
        JsonValueType returnedValue;
        //act
        jsonObject.addObject("object", new JsonObject());
        returnedValue = jsonObject.getJsonValueType("object");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Array() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.ARRAY;
        JsonValueType returnedValue;
        //act
        jsonObject.addArray("array", new JsonArray());
        returnedValue = jsonObject.getJsonValueType("array");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Boolean() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.BOOLEAN;
        JsonValueType returnedValue;
        //act
        jsonObject.addBoolean("boolean", true);
        returnedValue = jsonObject.getJsonValueType("boolean");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_String() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.STRING;
        JsonValueType returnedValue;
        //act
        jsonObject.addString("String", "some text");
        returnedValue = jsonObject.getJsonValueType("String");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Char() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.CHAR;
        JsonValueType returnedValue;
        //act
        jsonObject.addChar("char", 'a');
        returnedValue = jsonObject.getJsonValueType("char");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Int() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.INT;
        JsonValueType returnedValue;
        //act
        jsonObject.addInt("int", 2);
        returnedValue = jsonObject.getJsonValueType("int");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Long() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.LONG;
        JsonValueType returnedValue;
        //act
        jsonObject.addLong("long", 2l);
        returnedValue = jsonObject.getJsonValueType("long");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Float() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.FLOAT;
        JsonValueType returnedValue;
        //act
        jsonObject.addFloat("float", 2.5f);
        returnedValue = jsonObject.getJsonValueType("float");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonObject.
     */
    @Test
    public void testGetJsonValueType_Double() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonValueType expectedValue = JsonValueType.DOUBLE;
        JsonValueType returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        returnedValue = jsonObject.getJsonValueType("double");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of get method, of class JsonObject.
     */
    @Test
    public void testGet() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        int expectedValue = 2;
        int returnedValue;
        //act
        jsonObject.addInt("int", 2);
        returnedValue = (int) jsonObject.get("int");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getObject method, of class JsonObject.
     */
    @Test
    public void testGetObject() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObjectToReturn = new JsonObject();
        String expectedString = "object";
        String returnedString;
        //act
        jsonObjectToReturn.addString("name", "object");
        jsonObject.addObject("object to return", jsonObjectToReturn);
        returnedString = jsonObject.getObject("object to return").getString("name");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getArray method, of class JsonObject.
     */
    @Test
    public void testGetArray() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayToReturn = new JsonArray();
        String expectedString = "array";
        String returnedString;
        //act
        jsonArrayToReturn.addString("array");
        jsonObject.addArray("array to return", jsonArrayToReturn);
        returnedString = jsonObject.getArray("array to return").getString(0);
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getBoolean method, of class JsonObject.
     */
    @Test
    public void testGetBoolean() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addBoolean("boolean", true);
        returnedValue = jsonObject.getBoolean("boolean");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getString method, of class JsonObject.
     */
    @Test
    public void testGetString() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        String expectedString = "some text";
        String returnedString;
        //act
        jsonObject.addString("String", "some text");
        returnedString = jsonObject.getString("String");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getChar method, of class JsonObject.
     */
    @Test
    public void testGetChar() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        char expectedValue = 'a';
        char returnedValue;
        //act
        jsonObject.addChar("char", 'a');
        returnedValue = jsonObject.getChar("char");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getInt method, of class JsonObject.
     */
    @Test
    public void testGetInt() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        int expectedValue = 2;
        int returnedValue;
        //act
        jsonObject.addInt("int", 2);
        returnedValue = jsonObject.getInt("int");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getLong method, of class JsonObject.
     */
    @Test
    public void testGetLong() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        long expectedValue = 2l;
        long returnedValue;
        //act
        jsonObject.addLong("long", 2l);
        returnedValue = jsonObject.getLong("long");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getFloat method, of class JsonObject.
     */
    @Test
    public void testGetFloat() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        float expectedValue = 2.5f;
        float returnedValue;
        //act
        jsonObject.addFloat("float", 2.5f);
        returnedValue = jsonObject.getFloat("float");
        //assert
        assertEquals(expectedValue, returnedValue, 0);
    }

    /**
     * Test of getDouble method, of class JsonObject.
     */
    @Test
    public void testGetDouble() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        double expectedValue = 2.5d;
        double returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        returnedValue = jsonObject.getDouble("double");
        //assert
        assertEquals(expectedValue, returnedValue, 0);
    }

    /**
     * Test of update method, of class JsonObject.
     */
    @Test
    public void testUpdate() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        double expectedValue = 2.8d;
        double returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.update("double", 2.8d);
        returnedValue = jsonObject.getDouble("double");
        //assert
        assertEquals(expectedValue, returnedValue, 0);
    }

    /**
     * Test of updateNull method, of class JsonObject.
     */
    @Test
    public void testUpdateNull() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateNull("double");
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.NULL;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateObject method, of class JsonObject.
     */
    @Test
    public void testUpdateObject() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateObject("double", new JsonObject());
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.OBJECT;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateArray method, of class JsonObject.
     */
    @Test
    public void testUpdateArray() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateArray("double", new JsonArray());
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.ARRAY;
        //assert
        assertEquals(expectedValue, returnedValue);

    }

    /**
     * Test of updateString method, of class JsonObject.
     */
    @Test
    public void testUpdateString() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateString("double", "some text");
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.STRING;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateBoolean method, of class JsonObject.
     */
    @Test
    public void testUpdateBoolean() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addString("Is Bob rich?", "no");
        jsonObject.updateBoolean("Is Bob rich?", true);
        returnedValue = jsonObject.getJsonValueType("Is Bob rich?") == JsonValueType.BOOLEAN;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateChar method, of class JsonObject.
     */
    @Test
    public void testUpdateChar() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateChar("double", 'a');
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.CHAR;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateInt method, of class JsonObject.
     */
    @Test
    public void testUpdateInt() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateInt("double", 2);
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.INT;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateLong method, of class JsonObject.
     */
    @Test
    public void testUpdateLong() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateLong("double", 2l);
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.LONG;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateFloat method, of class JsonObject.
     */
    @Test
    public void testUpdateFloat() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addDouble("double", 2.5d);
        jsonObject.updateFloat("double", 2.5f);
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.FLOAT;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateDouble method, of class JsonObject.
     */
    @Test
    public void testUpdateDouble() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        jsonObject.addFloat("double", 2.5f);
        jsonObject.updateDouble("double", 2.5d);
        returnedValue = jsonObject.getJsonValueType("double") == JsonValueType.DOUBLE;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of removeJsonValue method, of class JsonObject.
     */
    @Test
    public void testRemoveJsonValue() {
        //arrange
        boolean isExceptionThrown = false;
        JsonObject jsonObject = new JsonObject();
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);
        jsonObject.removeJsonValue("nick");
        try {
            jsonObject.getString("nick");
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of toMinimalString method, of class JsonObject.
     */
    @Test
    public void testToMinimalString() {
        //arrange
        String expectedString = "{\"date of death\":null,\"father\":{\"name\":\"Peter\",\"surname\":\"Black\"},\"mother\":{\"name\":\"Sue\",\"surname\":\"Black\"},\"property\":[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492],\"is rich\":true,\"name\":\"John\",\"surname\":\"Black\",\"date of birth\":\"1975-09-23\",\"favorit letter\":\"W\",\"year of birth\":1975,\"favorit very long number\":8798799845647987,\"height\":173.5466,\"height- high precision\":173.54666549879545}";
        String returnedString;

        JsonObject personJohnBlack = new JsonObject();
        JsonArray propertyOfJohnBlack = new JsonArray();
        propertyOfJohnBlack.addNull();

        JsonObject computerOfJohnBlack = new JsonObject();
        computerOfJohnBlack.addString("type", "computer");
        computerOfJohnBlack.addString("cpu", "corei7");
        computerOfJohnBlack.addString("ram", "16GB");

        propertyOfJohnBlack.addObject(computerOfJohnBlack);

        JsonArray memoryCards = new JsonArray();
        memoryCards.addString("8GB memory card");
        memoryCards.addString("16GB memory card");
        memoryCards.addString("32GB memory card");
        memoryCards.addString("128GB memory card");

        propertyOfJohnBlack.addArray(memoryCards);

        propertyOfJohnBlack.addBoolean(true);
        propertyOfJohnBlack.addString("car");
        propertyOfJohnBlack.addChar('y');
        propertyOfJohnBlack.addInt(42);
        propertyOfJohnBlack.addLong(9987987998798l);
        propertyOfJohnBlack.addFloat(4.56f);
        propertyOfJohnBlack.addDouble(1.646659262492d);

        JsonObject personPeterBlack = new JsonObject();
        personPeterBlack.addString("name", "Peter");
        personPeterBlack.addString("surname", "Black");

        JsonObject personSueBlack = new JsonObject();
        personSueBlack.addString("name", "Sue");
        personSueBlack.addString("surname", "Black");

        personJohnBlack.addNull("date of death");
        personJohnBlack.addObject("father", personPeterBlack);
        personJohnBlack.addObject("mother", personSueBlack);
        personJohnBlack.addArray("property", propertyOfJohnBlack);
        personJohnBlack.addBoolean("is rich", true);
        personJohnBlack.addString("name", "John");
        personJohnBlack.addString("surname", "Black");
        personJohnBlack.addString("date of birth", "1975-09-23");
        personJohnBlack.addChar("favorit letter", 'W');
        personJohnBlack.addInt("year of birth", 1975);
        personJohnBlack.addLong("favorit very long number", 8798799845647987l);
        personJohnBlack.addFloat("height", 173.5466f);
        personJohnBlack.addDouble("height- high precision", 173.54666549879544659d);
        //act
        returnedString = personJohnBlack.toMinimalString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of toPrettyString method, of class JsonObject.
     */
    @Test
    public void testToPrettyString() {
        //arrange
        String expectedString = "{\n   \"date of death\":null,\n   \"father\":{\n      \"name\":\"Peter\",\n      \"surname\":\"Black\"\n   },\n   \"mother\":{\n      \"name\":\"Sue\",\n      \"surname\":\"Black\"\n   },\n   \"property\":[\n      null,\n      {\n         \"type\":\"computer\",\n         \"cpu\":\"corei7\",\n         \"ram\":\"16GB\"\n      },\n      [\n         \"8GB memory card\",\n         \"16GB memory card\",\n         \"32GB memory card\",\n         \"128GB memory card\"\n      ],\n      true,\n      \"car\",\n      \"y\",\n      42,\n      9987987998798,\n      4.56,\n      1.646659262492\n   ],\n   \"is rich\":true,\n   \"name\":\"John\",\n   \"surname\":\"Black\",\n   \"date of birth\":\"1975-09-23\",\n   \"favorit letter\":\"W\",\n   \"year of birth\":1975,\n   \"favorit very long number\":8798799845647987,\n   \"height\":173.5466,\n   \"height- high precision\":173.54666549879545\n}";
        String returnedString;

        JsonObject personJohnBlack = new JsonObject();
        JsonArray propertyOfJohnBlack = new JsonArray();
        propertyOfJohnBlack.addNull();

        JsonObject computerOfJohnBlack = new JsonObject();
        computerOfJohnBlack.addString("type", "computer");
        computerOfJohnBlack.addString("cpu", "corei7");
        computerOfJohnBlack.addString("ram", "16GB");

        propertyOfJohnBlack.addObject(computerOfJohnBlack);

        JsonArray memoryCards = new JsonArray();
        memoryCards.addString("8GB memory card");
        memoryCards.addString("16GB memory card");
        memoryCards.addString("32GB memory card");
        memoryCards.addString("128GB memory card");

        propertyOfJohnBlack.addArray(memoryCards);

        propertyOfJohnBlack.addBoolean(true);
        propertyOfJohnBlack.addString("car");
        propertyOfJohnBlack.addChar('y');
        propertyOfJohnBlack.addInt(42);
        propertyOfJohnBlack.addLong(9987987998798l);
        propertyOfJohnBlack.addFloat(4.56f);
        propertyOfJohnBlack.addDouble(1.646659262492d);

        JsonObject personPeterBlack = new JsonObject();
        personPeterBlack.addString("name", "Peter");
        personPeterBlack.addString("surname", "Black");

        JsonObject personSueBlack = new JsonObject();
        personSueBlack.addString("name", "Sue");
        personSueBlack.addString("surname", "Black");

        personJohnBlack.addNull("date of death");
        personJohnBlack.addObject("father", personPeterBlack);
        personJohnBlack.addObject("mother", personSueBlack);
        personJohnBlack.addArray("property", propertyOfJohnBlack);
        personJohnBlack.addBoolean("is rich", true);
        personJohnBlack.addString("name", "John");
        personJohnBlack.addString("surname", "Black");
        personJohnBlack.addString("date of birth", "1975-09-23");
        personJohnBlack.addChar("favorit letter", 'W');
        personJohnBlack.addInt("year of birth", 1975);
        personJohnBlack.addLong("favorit very long number", 8798799845647987l);
        personJohnBlack.addFloat("height", 173.5466f);
        personJohnBlack.addDouble("height- high precision", 173.54666549879544659d);
        //act
        returnedString = personJohnBlack.toPrettyString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getCopy method, of class JsonObject.
     */
    @Test
    public void testGetCopy() {
        //arrange
        String expectedString = "{\"date of death\":null,\"father\":{\"name\":\"Peter\",\"surname\":\"Black\"},\"mother\":{\"name\":\"Sue\",\"surname\":\"Black\"},\"property\":[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492],\"is rich\":true,\"name\":\"John\",\"surname\":\"Black\",\"date of birth\":\"1975-09-23\",\"favorit letter\":\"W\",\"year of birth\":1975,\"favorit very long number\":8798799845647987,\"height\":173.5466,\"height- high precision\":173.54666549879545}";
        String returnedString;

        JsonObject personJohnBlack = new JsonObject(expectedString);
        JsonObject personJohnBlackCopy;

        //act
        personJohnBlackCopy = personJohnBlack.getCopy();
        returnedString = personJohnBlackCopy.toMinimalString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getKeyIterator method, of class JsonObject.
     */
    @Test
    public void testGetKeyIterator() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        DictionaryKeyIterator dictionaryKeyIterator;
        String expectedString = "name";
        String returnedString;
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);
        dictionaryKeyIterator = jsonObject.getKeyIterator();
        dictionaryKeyIterator.getNextKey();
        dictionaryKeyIterator.getNextKey();
        returnedString = dictionaryKeyIterator.getNextKey();;
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getJsonValue method, of class JsonObject.
     */
    @Test
    public void testGetJsonValue() {
        //arrange
        JsonObject jsonObject = new JsonObject();
        DictionaryKeyIterator dictionaryKeyIterator;
        String expectedString = "John";
        String returnedString;
        //act
        jsonObject.addString("personality", "calm");
        jsonObject.addString("nick", "Johny");
        jsonObject.addString("name", "John");
        jsonObject.addInt("age", 43);

        returnedString = jsonObject.getJsonValue("name").getJsonString().getString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
