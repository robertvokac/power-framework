
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

package org.nanoboot.powerframework.db.manager;

import org.nanoboot.powerframework.json.JsonObject;
import java.io.*;
import static org.junit.Assert.*;

import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

@Ignore
public class DatabaseConnectionTest {

    private static final File directory;
    private static final String directoryName;

    static {
        W5RandomGenerator pseudoW5RandomGenerator = W5RandomGenerator.getStaticInstance();
        int randomNumber = pseudoW5RandomGenerator.nextInt(0, 999999);
        directoryName = "./temp" + randomNumber + "/";
        directory = new File(directoryName);
    }

    static public boolean deleteDirectory(File path) {
        if(path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if(files[i].isDirectory()) {
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
        return Integer.toString(W5RandomGenerator.getStaticInstance().nextInt(0, 1000000));
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
        CommandStore sqlCommandQueue = new CommandStore();
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
        CommandStore sqlCommandQueue = new CommandStore();
        sqlCommandQueue.add("create table customers(id integer,name text,surname text,yearofbirth integer)");
        sqlCommandQueue.add("insert into customers values(1,'John','Green',1954);");
        sqlCommandQueue.add("insert into customers values(2,'Anne','Blue',1985);");
        sqlCommandQueue.add("insert into customers values(3,'Peter','Orange',1990);");
        String query = "select * from customers";
        databaseConnection.executeMoreCommands(sqlCommandQueue);

        String expectedString = "{\"query\":\"select * from customers\",\"columns\":[\"id\",\"name\",\"surname\",\"yearofbirth\"],\"rows\":[[\"1\",\"John\",\"Green\",\"1954\"],[\"2\",\"Anne\",\"Blue\",\"1985\"],[\"3\",\"Peter\",\"Orange\",\"1990\"]]}";
        String returnedString;
        Table resultOfSqlQuery;
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
        CommandStore sqlCommandQueue = new CommandStore();
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
        CommandStore sqlCommandQueue = new CommandStore();
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
        Databases.createDatabase(databaseName);
        Database databaseConnection = Databases.getDatabase(databaseName);
        CommandStore sqlCommandQueue = new CommandStore();
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
