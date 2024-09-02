
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class JsonArrayTest {

    /**
     *
     */
    public JsonArrayTest() {
    }

    /**
     * Test of constructor, of class JsonArray.
     */
    @Test
    public void testJsonArray() {
        //arrange
        String expectedString = "[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492]";
        String returnedString;

        JsonArray property;
        //act
        property = new JsonArray(expectedString);
        returnedString = property.toMinimalString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getCountOfItems method, of class JsonArray.
     */
    @Test
    public void testGetCountOfItems() {

        //arrange
        int expectedValue = 4;
        int returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.add("John");
        jsonArray.addString("Black");
        jsonArray.addString("Johny");
        jsonArray.addString("calm");
        //act

        returnedValue = jsonArray.size();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class JsonArray.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        boolean expectedValue = true;
        boolean returnedValue;
        JsonArray jsonArray = new JsonArray();
        //act
        returnedValue = jsonArray.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class JsonArray.
     */
    @Test
    public void testIsEmpty2() {
        //arrange
        boolean expectedValue = false;
        boolean returnedValue;
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("John");
        jsonArray.addString("Black");
        jsonArray.addString("Johny");
        jsonArray.addString("calm");
        for (int i = 1; i <= 3; i++) {
            jsonArray.removeJsonValue(0);
        }
        //act
        returnedValue = jsonArray.isEmpty();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addJsonValue method, of class JsonArray.
     */
    @Test
    public void testAdd() {

        //arrange
        JsonValueType expectedValue = JsonValueType.NULL;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.add(null);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addNull method, of class JsonArray.
     */
    @Test
    public void testAddNull() {
        //arrange
        JsonValueType expectedValue = JsonValueType.NULL;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addObject method, of class JsonArray.
     */
    @Test
    public void testAddObject() {
        //arrange
        JsonValueType expectedValue = JsonValueType.OBJECT;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addObject(new JsonObject());
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addArray method, of class JsonArray.
     */
    @Test
    public void testAddArray() {
        //arrange
        JsonValueType expectedValue = JsonValueType.ARRAY;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addArray(new JsonArray());
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addBoolean method, of class JsonArray.
     */
    @Test
    public void testAddBoolean() {
        //arrange
        JsonValueType expectedValue = JsonValueType.BOOLEAN;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addBoolean(true);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addString method, of class JsonArray.
     */
    @Test
    public void testAddString() {
        //arrange
        JsonValueType expectedValue = JsonValueType.STRING;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addString("String");
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addChar method, of class JsonArray.
     */
    @Test
    public void testAddChar() {
        //arrange
        JsonValueType expectedValue = JsonValueType.CHAR;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addChar('S');
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addInt method, of class JsonArray.
     */
    @Test
    public void testAddInt() {
        //arrange
        JsonValueType expectedValue = JsonValueType.INT;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addInt(10);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addLong method, of class JsonArray.
     */
    @Test
    public void testAddLong() {
        //arrange
        JsonValueType expectedValue = JsonValueType.LONG;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addLong(10l);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addFloat method, of class JsonArray.
     */
    @Test
    public void testAddFloat() {
        //arrange
        JsonValueType expectedValue = JsonValueType.FLOAT;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addFloat(10.4f);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of addDouble method, of class JsonArray.
     */
    @Test
    public void testAddDouble() {
        //arrange
        JsonValueType expectedValue = JsonValueType.DOUBLE;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addDouble(10.4d);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonValueType method, of class JsonArray.
     */
    @Test
    public void testGetJsonValueType() {
        //arrange
        JsonValueType expectedValue = JsonValueType.DOUBLE;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addDouble(10.4d);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getObject method, of class JsonArray.
     */
    @Test
    public void testGetObject() {
        //arrange
        String expectedValue = "object";
        String returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addObject(new JsonObject().addString("key", "object"));
        //act
        returnedValue = jsonArray.getObject(0).getString("key");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getArray method, of class JsonArray.
     */
    @Test
    public void testGetArray() {
        //arrange
        String expectedValue = "array";
        String returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addArray(new JsonArray().addString("array"));
        //act
        returnedValue = jsonArray.getArray(0).getString(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBoolean method, of class JsonArray.
     */
    @Test
    public void testGetBoolean() {
        //arrange
        boolean expectedValue = true;
        boolean returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addBoolean(true);
        //act
        returnedValue = jsonArray.getBoolean(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getString method, of class JsonArray.
     */
    @Test
    public void testGetString() {
        //arrange
        String expectedValue = "String";
        String returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addString("String");
        //act
        returnedValue = jsonArray.getString(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getChar method, of class JsonArray.
     */
    @Test
    public void testGetChar() {
        //arrange
        char expectedValue = 'S';
        char returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addChar('S');
        //act
        returnedValue = jsonArray.getChar(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getInt method, of class JsonArray.
     */
    @Test
    public void testGetInt() {
        //arrange
        int expectedValue = 10;
        int returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addInt(10);
        //act
        returnedValue = jsonArray.getInt(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getLong method, of class JsonArray.
     */
    @Test
    public void testGetLong() {
        //arrange
        long expectedValue = 10l;
        long returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addLong(10l);
        //act
        returnedValue = jsonArray.getLong(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getFloat method, of class JsonArray.
     */
    @Test
    public void testGetFloat() {
        //arrange
        float expectedValue = 10.4f;
        float returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addFloat(10.4f);
        //act
        returnedValue = jsonArray.getFloat(0);
        //assert
        assertEquals(expectedValue, returnedValue, 0);
    }

    /**
     * Test of getDouble method, of class JsonArray.
     */
    @Test
    public void testGetDouble() {
        //arrange
        double expectedValue = 10.4d;
        double returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addDouble(10.4d);
        //act
        returnedValue = jsonArray.getDouble(0);
        //assert
        assertEquals(expectedValue, returnedValue, 0);
    }

    /**
     * Test of updateNull method, of class JsonArray.
     */
    @Test
    public void testUpdateNull() {
        //arrange
        JsonValueType expectedValue = JsonValueType.NULL;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addDouble(10.4d);
        jsonArray.updateNull(0);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateObject method, of class JsonArray.
     */
    @Test
    public void testUpdateObject() {
        //arrange
        JsonValueType expectedValue = JsonValueType.OBJECT;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateObject(0, new JsonObject());
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateArray method, of class JsonArray.
     */
    @Test
    public void testUpdateArray() {
        //arrange
        JsonValueType expectedValue = JsonValueType.ARRAY;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateArray(0, new JsonArray());
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateBoolean method, of class JsonArray.
     */
    @Test
    public void testUpdateBoolean() {
        //arrange
        JsonValueType expectedValue = JsonValueType.BOOLEAN;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateBoolean(0, true);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateString method, of class JsonArray.
     */
    @Test
    public void testUpdateString() {
        //arrange
        JsonValueType expectedValue = JsonValueType.STRING;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateString(0, "String");
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateChar method, of class JsonArray.
     */
    @Test
    public void testUpdateChar() {
        //arrange
        JsonValueType expectedValue = JsonValueType.CHAR;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateChar(0, 'S');
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateInt method, of class JsonArray.
     */
    @Test
    public void testUpdateInt() {
        //arrange
        JsonValueType expectedValue = JsonValueType.INT;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateInt(0, 10);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateLong method, of class JsonArray.
     */
    @Test
    public void testUpdateLong() {
        //arrange
        JsonValueType expectedValue = JsonValueType.LONG;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateLong(0, 10l);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateFloat method, of class JsonArray.
     */
    @Test
    public void testUpdateFloat() {
        //arrange
        JsonValueType expectedValue = JsonValueType.FLOAT;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateFloat(0, 10.4f);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of updateDouble method, of class JsonArray.
     */
    @Test
    public void testUpdateDouble() {
        //arrange
        JsonValueType expectedValue = JsonValueType.DOUBLE;
        JsonValueType returnedValue;

        JsonArray jsonArray = new JsonArray();
        jsonArray.addNull();
        jsonArray.updateDouble(0, 10.4d);
        //act
        returnedValue = jsonArray.getJsonValueType(0);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of removeJsonValue method, of class JsonArray.
     */
    @Test
    public void testRemoveJsonValue() {
        //arrange
        boolean isExceptionThrown = false;
        JsonArray jsonArray = new JsonArray();
        jsonArray.addChar('g');
        //act
        jsonArray.removeJsonValue(0);
        try {
            jsonArray.getChar(0);
        } catch (Exception e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonValue method, of class JsonArray.
     */
    @Test
    public void testGetJsonValue() {
        //arrange
        int expectedValue = 4;
        int returnedValue;
        JsonValue jsonValue;
        JsonArray jsonArray = new JsonArray();
        jsonArray.addInt(4);//act
        jsonValue = jsonArray.getJsonValue(0);
        returnedValue = jsonValue.getJsonInt();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of toMinimalString method, of class JsonArray.
     */
    @Test
    public void testToMinimalString() {
        //arrange
        String expectedString = "[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492]";
        String returnedString;

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

        //act
        returnedString = propertyOfJohnBlack.toMinimalString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of toPrettyString method, of class JsonArray.
     */
    @Test
    public void testToPrettyString() {
        //arrange
        String expectedString = "[\n   null,\n   {\n      \"type\":\"computer\",\n      \"cpu\":\"corei7\",\n      \"ram\":\"16GB\"\n   },\n   [\n      \"8GB memory card\",\n      \"16GB memory card\",\n      \"32GB memory card\",\n      \"128GB memory card\"\n   ],\n   true,\n   \"car\",\n   \"y\",\n   42,\n   9987987998798,\n   4.56,\n   1.646659262492\n]";
        String returnedString;

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

        //act
        returnedString = propertyOfJohnBlack.toPrettyString();
        //assert
        boolean result = expectedString.equals(returnedString);
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getCopy method, of class JsonArray.
     */
    @Test
    public void testGetCopy() {

        String expectedString = "[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492]";
        String returnedString;

        JsonArray property = new JsonArray(expectedString);
        JsonArray propertyCopy;

        //act
        propertyCopy = property.getCopy();
        returnedString = propertyCopy.toMinimalString();
        //assert
        boolean result = expectedString.equals(returnedString);
        //System.out.println(expectedString +"\n"+ returnedString);
        assertEquals(expectedString, returnedString);
    }

}
