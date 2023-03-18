
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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class JsonValueTest {

    /**
     *
     */
    public JsonValueTest() {
    }

    /**
     * Test of getJsonValueType method, of class JsonValue.
     */
    @Test
    public void testGetJsonValueType() {
        //arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.STRING;
        JsonString jsonString;
        //act
        jsonString = new JsonString("hello");
        jsonValue = new JsonValue(jsonString);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isNull method, of class JsonValue.
     */
    @Test
    public void testIsNull() {
        //arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.NULL;
        //act
        jsonValue = new JsonValue();
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isObject method, of class JsonValue.
     */
    @Test
    public void testIsObject() {
        //arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.OBJECT;
        JsonObject jsonObject;
        //act
        jsonObject = new JsonObject();
        jsonValue = new JsonValue(jsonObject);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isArray method, of class JsonValue.
     */
    @Test
    public void testIsArray() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.ARRAY;
        JsonArray jsonArray;
        //act
        jsonArray = new JsonArray();
        jsonValue = new JsonValue(jsonArray);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isBoolean method, of class JsonValue.
     */
    @Test
    public void testIsBoolean() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.BOOLEAN;
        JsonBoolean jsonBoolean;
        //act
        jsonBoolean = new JsonBoolean(true);
        jsonValue = new JsonValue(jsonBoolean);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isString method, of class JsonValue.
     */
    @Test
    public void testIsString() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.STRING;
        JsonString jsonString;
        //act
        jsonString = new JsonString("hello");
        jsonValue = new JsonValue(jsonString);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isChar method, of class JsonValue.
     */
    @Test
    public void testIsChar() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.CHAR;
        JsonChar jsonChar;
        //act
        jsonChar = new JsonChar('h');
        jsonValue = new JsonValue(jsonChar);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isInt method, of class JsonValue.
     */
    @Test
    public void testIsInt() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.INT;
        JsonInt jsonInt;
        //act
        jsonInt = new JsonInt(549);
        jsonValue = new JsonValue(jsonInt);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isLong method, of class JsonValue.
     */
    @Test
    public void testIsLong() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.LONG;
        JsonLong jsonLong;
        //act
        jsonLong = new JsonLong(4l);
        jsonValue = new JsonValue(jsonLong);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isFloat method, of class JsonValue.
     */
    @Test
    public void testIsFloat() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.FLOAT;
        JsonFloat jsonFloat;
        //act
        jsonFloat = new JsonFloat(8.6f);
        jsonValue = new JsonValue(jsonFloat);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isDouble method, of class JsonValue.
     */
    @Test
    public void testIsDouble() {
//arrange
        JsonValue jsonValue;
        JsonValueType expectedValue;
        JsonValueType returnedValue = JsonValueType.DOUBLE;
        JsonDouble jsonDouble;
        //act
        jsonDouble = new JsonDouble(8.6d);
        jsonValue = new JsonValue(jsonDouble);
        expectedValue = jsonValue.getJsonValueType();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getJsonObject method, of class JsonValue.
     */
    @Test
    public void testGetJsonObject() {
        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonObject();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonArray method, of class JsonValue.
     */
    @Test
    public void testGetJsonArray() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonArray();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonBoolean method, of class JsonValue.
     */
    @Test
    public void testGetJsonBoolean() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonBoolean();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonString method, of class JsonValue.
     */
    @Test
    public void testGetJsonString() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonString();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonChar method, of class JsonValue.
     */
    @Test
    public void testGetJsonChar() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonChar();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonInt method, of class JsonValue.
     */
    @Test
    public void testGetJsonInt() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonInt();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonLong method, of class JsonValue.
     */
    @Test
    public void testGetJsonLong() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonLong();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonFloat method, of class JsonValue.
     */
    @Test
    public void testGetJsonFloat() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonFloat();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of getJsonDouble method, of class JsonValue.
     */
    @Test
    public void testGetJsonDouble() {

        //arrange
        boolean isExceptionThrown = false;
        JsonString jsonString = new JsonString("hello");
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonDouble();
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

}
