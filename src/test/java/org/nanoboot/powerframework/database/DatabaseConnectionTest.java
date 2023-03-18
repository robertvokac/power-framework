
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

package org.nanoboot.powerframework.database;

import java.io.File;
import org.nanoboot.powerframework.json.JsonObject;

import org.nanoboot.powerframework.pseudorandom.PseudoRandomGenerator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class DatabaseConnectionTest {

    private static final File directory;
    private static final String directoryName;

    static {
        PseudoRandomGenerator pseudoRandomGenerator = PseudoRandomGenerator.getInstance();
        int randomNumber = pseudoRandomGenerator.getInt(0, 999999);
        directoryName = "./temp" + randomNumber + "/";
        directory = new File(directoryName);
    }

    static public boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }

    public DatabaseConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        directory.mkdir();
    }

    private String getNextDatabaseName() {
        return Integer.toString(PseudoRandomGenerator.getInstance().getInt(0, 1000000));
    }

    /**
     * Test of getDatabaseName method, of class DatabaseConnection.
     */
    @Test
    public void testGetDatabaseName() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        String expectedString = databaseName;
        String returnedString;
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        //act
        returnedString = databaseConnection.getDatabaseName();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of execute method, of class DatabaseConnection.
     */
    @Test
    public void testExecute_String() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        databaseConnection.execute("create table customers(id integer,name text,surname text,yearofbirth integer)");
        //act
        databaseConnection.execute("insert into customers values(1,'John','Green',1954);");
        //assert
        assertFalse(databaseConnection.isTableEmpty("customers"));
    }

    /**
     * Test of execute method, of class DatabaseConnection.
     */
    @Test
    public void testExecute_SqlCommandQueue() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        sqlCommandQueue.add("create table customers(id integer,name text,surname text,yearofbirth integer)");
        sqlCommandQueue.add("insert into customers values(1,'John','Green',1954);");
        sqlCommandQueue.add("insert into customers values(2,'Anne','Blue',1985);");
        sqlCommandQueue.add("insert into customers values(3,'Peter','Orange',1990);");

        //act
        databaseConnection.executeMoreCommands(sqlCommandQueue);
        //assert
        assertFalse(databaseConnection.isTableEmpty("customers"));
    }

    /**
     * Test of executeAndReturn method, of class DatabaseConnection.
     */
    @Test
    public void testExecuteAndReturn() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        sqlCommandQueue.add("create table customers(id integer,name text,surname text,yearofbirth integer)");
        sqlCommandQueue.add("insert into customers values(1,'John','Green',1954);");
        sqlCommandQueue.add("insert into customers values(2,'Anne','Blue',1985);");
        sqlCommandQueue.add("insert into customers values(3,'Peter','Orange',1990);");
        String query = "select * from customers";
        databaseConnection.executeMoreCommands(sqlCommandQueue);

        String expectedString = "{\"query\":\"select * from customers\",\"columns\":[\"id\",\"name\",\"surname\",\"yearofbirth\"],\"rows\":[[\"1\",\"John\",\"Green\",\"1954\"],[\"2\",\"Anne\",\"Blue\",\"1985\"],[\"3\",\"Peter\",\"Orange\",\"1990\"]]}";
        String returnedString;
        ResultOfSqlQuery resultOfSqlQuery;
        //act
        resultOfSqlQuery = databaseConnection.executeAndReturn(query);
        returnedString = resultOfSqlQuery.toJsonObject().toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of getRow method, of class DatabaseConnection.
     */
    @Test
    public void testGetRow() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        sqlCommandQueue.add("create table customers(id integer,name text,surname text,yearofbirth integer)");
        sqlCommandQueue.add("insert into customers values(1,'John','Green',1954);");
        sqlCommandQueue.add("insert into customers values(2,'Anne','Blue',1985);");
        sqlCommandQueue.add("insert into customers values(3,'Peter','Orange',1990);");

        databaseConnection.executeMoreCommands(sqlCommandQueue);
        JsonObject row;
        String expectedString = "{\"id\":\"2\",\"name\":\"Anne\",\"surname\":\"Blue\",\"yearofbirth\":\"1985\"}";
        String returnedString;
        //act
        row = databaseConnection.getRow("customers", 2);
        returnedString = row.toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     *
     * Test of isTableEmpty method, of class DatabaseConnection.
     */
    @Test
    public void testIsTableEmpty() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        boolean returnedValue;
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        sqlCommandQueue.add("create table customers(id integer,name text,surname text,yearofbirth integer)");
        databaseConnection.executeMoreCommands(sqlCommandQueue);
        //act
        returnedValue = databaseConnection.isTableEmpty("customers");
        //assert
        assertTrue(returnedValue);
    }

    /**
     *
     * Test of isTableEmpty method, of class DatabaseConnection.
     */
    @Test
    public void testIsTableEmpty2() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        boolean returnedValue;
        Database.createDatabase(databaseName);
        DatabaseConnection databaseConnection = Database.createDatabaseConnection(databaseName);
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        sqlCommandQueue.add("create table customers(id integer,name text,surname text,yearofbirth integer)");
        sqlCommandQueue.add("insert into customers values(1,'John','Green',1954);");
        sqlCommandQueue.add("insert into customers values(2,'Anne','Blue',1985);");
        sqlCommandQueue.add("insert into customers values(3,'Peter','Orange',1990);");
        databaseConnection.executeMoreCommands(sqlCommandQueue);
        //act
        returnedValue = databaseConnection.isTableEmpty("customers");
        //assert
        assertFalse(returnedValue);
    }

    @AfterClass
    public static void tearDownClass() {
        deleteDirectory(directory);
    }
}
