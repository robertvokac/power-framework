
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

package org.nanoboot.powerframework.db.manager;

import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonArray;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@Ignore
public class TableTest {

    private static final String jsonObjectAsString;

    static {
        JsonObject jsonObject = new JsonObject();

        String command = "select * from customers";
        JsonArray columns = new JsonArray();
        columns.addString("id").addString("name").addString("surname").addString("yearofbirth");

        JsonArray rows = new JsonArray();
        JsonArray row1 = new JsonArray();
        row1.addString("1").addString("John").addString("Green").addString("1954");

        JsonArray row2 = new JsonArray();
        row2.addString("2").addString("Anne").addString("Blue").addString("1985");

        JsonArray row3 = new JsonArray();
        row3.addString("3").addString("Peter").addString("Orange").addString("1990");

        rows.addArray(row1).addArray(row2).addArray(row3);

        jsonObject.addString("query", command);
        jsonObject.addArray("columns", columns);
        jsonObject.addArray("rows", rows);

        jsonObjectAsString = jsonObject.toMinimalString();
    }

    public TableTest() {
    }

    /**
     *
     */
    @Test
    public void testJsonObjectAsString() {
        //arrange
        String expectedString = "{\"query\":\"select * from customers\",\"columns\":[\"id\",\"name\",\"surname\",\"yearofbirth\"],\"rows\":[[\"1\",\"John\",\"Green\",\"1954\"],[\"2\",\"Anne\",\"Blue\",\"1985\"],[\"3\",\"Peter\",\"Orange\",\"1990\"]]}";
        String returnedString;
        //act
        returnedString = jsonObjectAsString;
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getColumnNames method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetColumnNames() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = "[\"id\",\"name\",\"surname\",\"yearofbirth\"]";
        String returnedString;
        //act
        returnedString = resultOfSqlQuery.getColumnNames().toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getRows method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetRows() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = "[[\"1\",\"John\",\"Green\",\"1954\"],[\"2\",\"Anne\",\"Blue\",\"1985\"],[\"3\",\"Peter\",\"Orange\",\"1990\"]]";
        String returnedString;
        //act
        returnedString = resultOfSqlQuery.getRows().toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getCountOfRows method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetCountOfRows() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        int expectedValue = 3;
        int returnedValue;
        //act
        returnedValue = resultOfSqlQuery.getCountOfRows();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isEmpty method, of class ResultOfSqlQuery.
     */
    @Test
    public void testIsEmpty() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        boolean returnedValue;
        //act
        returnedValue = resultOfSqlQuery.isEmpty();
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of resetPosition method, of class ResultOfSqlQuery.
     */
    @Test
    public void testResetPosition() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = "[\"1\",\"John\",\"Green\",\"1954\"]";
        String returnedString;
        //act
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.resetPositionBeforeFirstRow();
        resultOfSqlQuery.moveToTheNextRow();
        returnedString = resultOfSqlQuery.getRow().toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of hasNextRow method, of class ResultOfSqlQuery.
     */
    @Test
    public void testHasNextRow() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        boolean returnedValue;
        //act
        returnedValue = resultOfSqlQuery.hasNextRow();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of hasNextRow method, of class ResultOfSqlQuery.
     */
    @Test
    public void testHasNextRow2() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        resultOfSqlQuery.moveToTheNextRow();
        boolean returnedValue;
        //act
        returnedValue = resultOfSqlQuery.hasNextRow();
        //assert
        assertTrue(returnedValue);
    }

    /**
     * Test of hasNextRow method, of class ResultOfSqlQuery.
     */
    @Test
    public void testHasNextRow3() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        boolean returnedValue;
        //act
        returnedValue = resultOfSqlQuery.hasNextRow();
        //assert
        assertFalse(returnedValue);
    }

    /**
     * Test of moveToTheNextRow method, of class ResultOfSqlQuery.
     */
    @Test
    public void testMoveToTheNextRow() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = "[\"2\",\"Anne\",\"Blue\",\"1985\"]";
        String returnedString;
        //act
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        returnedString = resultOfSqlQuery.getRow().toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getInt method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetInt() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        int expectedValue = 1985;
        int returnedValue;
        //act
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        returnedValue = resultOfSqlQuery.getInt("yearofbirth");
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getDouble method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetDouble() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        double expectedValue = 1985d;
        double returnedValue;
        //act
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        returnedValue = resultOfSqlQuery.getDouble("yearofbirth");
        //assert
        assertEquals(expectedValue, returnedValue, 0);
    }

    /**
     * Test of getString method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetString() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = "Anne";
        String returnedString;
        //act
        resultOfSqlQuery.moveToTheNextRow();
        resultOfSqlQuery.moveToTheNextRow();
        returnedString = resultOfSqlQuery.getString("name");
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getQuery method, of class ResultOfSqlQuery.
     */
    @Test
    public void testGetQuery() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = "select * from customers";
        String returnedString;
        //act
        returnedString = resultOfSqlQuery.getQuery();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of toJsonObject method, of class ResultOfSqlQuery.
     */
    @Test
    public void testToJsonObject() {
        //arrange
        JsonObject jsonObject = new JsonObject(jsonObjectAsString);
        Table resultOfSqlQuery = new Table(jsonObject);
        String expectedString = jsonObjectAsString;
        String returnedString;
        //act
        returnedString = resultOfSqlQuery.toJsonObject().toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

}
