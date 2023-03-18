
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
import org.nanoboot.powerframework.PowerRuntimeException;
import org.nanoboot.powerframework.pseudorandom.PseudoRandomGenerator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class DatabaseTest {

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

    public DatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        directory.mkdir();
    }

    private String getNextDatabaseName() {
        return Integer.toString(PseudoRandomGenerator.getInstance().getInt(0, 1000000));
    }

    /**
     * Test of createDatabase method, of class Database.
     */
    @Test
    public void testCreateDatabase() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        //act
        Database.createDatabase(databaseName);
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
        Database.createDatabase(databaseName);
        try {
            Database.createDatabase(databaseName);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of dropDatabase method, of class Database.
     */
    @Test
    public void testDropDatabase() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        Database.createDatabase(databaseName);
        //act
        Database.dropDatabase(databaseName);
        //assert
        assertFalse(Database.existsDatabase(databaseName));
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
            Database.dropDatabase(databaseName);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    /**
     * Test of existsDatabaseWithThisName method, of class Database.
     */
    @Test
    public void testExistsDatabaseWithThisName() {
        //arrange
        String databaseName = directoryName + getNextDatabaseName();
        //act
        Database.createDatabase(databaseName);
        //assert
        assertTrue(Database.existsDatabase(databaseName));
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
        assertFalse(Database.existsDatabase(databaseName));
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
        Database.createDatabase(databaseName);
        try {
            Database.createDatabaseConnection(databaseName);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (isExceptionThrown) {
            fail("There should be thrown no PowerRuntimeException");
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
            Database.createDatabaseConnection(databaseName);
        } catch (PowerRuntimeException e) {
            isExceptionThrown = true;
        }
        //assert
        if (!isExceptionThrown) {
            fail("There should be thrown PowerRuntimeException");
        }
    }

    @AfterClass
    public static void tearDownClass() {
        deleteDirectory(directory);
    }
}
