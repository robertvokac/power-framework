
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

import org.nanoboot.powerframework.core.PowerException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
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
        String jsonString;
        //act
        jsonString = "hello";
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
        boolean jsonBoolean;
        //act
        jsonBoolean = true;
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
        String jsonString;
        //act
        jsonString = "hello";
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
        char jsonChar;
        //act
        jsonChar = 'h';
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
        int jsonInt;
        //act
        jsonInt = 549;
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
        long jsonLong;
        //act
        jsonLong = 4l;
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
        float jsonFloat;
        //act
        jsonFloat = 8.6f;
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
        double jsonDouble;
        //act
        jsonDouble = 8.6d;
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonObject();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonArray();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonBoolean();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonString();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonChar();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonInt();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonLong();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonFloat();
        } catch (PowerException e) {
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
        String jsonString = "hello";
        JsonValue jsonValue = new JsonValue(jsonString);
        //act
        try {
            jsonValue.getJsonDouble();
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

}
