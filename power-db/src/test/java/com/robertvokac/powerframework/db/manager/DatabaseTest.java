
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

package com.robertvokac.powerframework.db.manager;

import com.robertvokac.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import com.robertvokac.powerframework.core.PowerException;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class DatabaseTest {

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

    public DatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        directory.mkdir();
    }

    private String getNextDatabaseName() {
        return Integer.toString(W5RandomGenerator.getStaticInstance().nextInt(0, 1000000));
    }

    /**
     * Test of createDatabase method, of class Database.
     */
    @Test
    public void testCreateDatabase() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        //act
        Databases.createDatabase(databaseName);
        //assert
        assertTrue(new File(databaseName + ".sqlite").exists());
    }

    /**
     * Test of createDatabase method, of class Database.
     */
    @Test
    public void testCreateDatabase2() {
        //arrange
        boolean isExceptionThrown = false;
        String databaseName = directoryName + getNextDatabaseName();
        //act
        Databases.createDatabase(databaseName);
        try {
            Databases.createDatabase(databaseName);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown OkayRuntimeException");
        }
    }

    /**
     * Test of dropDatabase method, of class Database.
     */
    @Test
    public void testDropDatabase() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        Databases.createDatabase(databaseName);
        //act
        Databases.dropDatabase(databaseName);
        //assert
        assertFalse(Databases.existsDatabase(databaseName));
    }

    /**
     * Test of dropDatabase method, of class Database.
     */
    @Test
    public void testDropDatabase2() {
        //arrange
        boolean isExceptionThrown = false;
        String databaseName = directoryName + getNextDatabaseName();
        //act
        try {
            Databases.dropDatabase(databaseName);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown OkayRuntimeException");
        }
    }

    /**
     * Test of existsDatabaseWithThisName method, of class Database.
     */
    @Test
    public void testExistsDatabase() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        //act
        Databases.createDatabase(databaseName);
        //assert
        assertTrue(Databases.existsDatabase(databaseName));
    }

    /**
     * Test of existsDatabaseWithThisName method, of class Database.
     */
    @Test
    public void testExistsDatabaseWithThisName2() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        //act
        //assert
        assertFalse(Databases.existsDatabase(databaseName));
    }

    /**
     * Test of createDatabaseConnection method, of class Database.
     */
    @Test
    public void testCreateDatabaseConnection() {
        //arrange
        boolean isExceptionThrown = false;
        String databaseName = directoryName + getNextDatabaseName();
        //act
        Databases.createDatabase(databaseName);
        try {
            Databases.getDatabase(databaseName);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(isExceptionThrown) {
            fail("There should be thrown no OkayRuntimeException");
        }
    }

    /**
     * Test of createDatabaseConnection method, of class Database.
     */
    @Test
    public void testCreateDatabaseConnection2() {
        //arrange
        boolean isExceptionThrown = false;
        String databaseName = directoryName + getNextDatabaseName();
        //act
        try {
            Databases.getDatabase(databaseName);
        } catch (PowerException e) {
            isExceptionThrown = true;
        }
        //assert
        if(!isExceptionThrown) {
            fail("There should be thrown OkayRuntimeException");
        }
    }

    @AfterClass
    public static void tearDownClass() {
        deleteDirectory(directory);
    }
}
