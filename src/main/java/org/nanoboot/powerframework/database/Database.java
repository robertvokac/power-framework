
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Manipulates with database.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class Database {

    private static final String SQLITEEXTENSION = ".sqlite";

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private Database() {
        //Not meant to be instantiated.        
    }

    /**
     * Creates new database with the given name.
     *
     * @param databaseName
     */
    public static void createDatabase(String databaseName) {
        if (existsDatabase(databaseName)) {
            throw new PowerRuntimeException("A database with the given name already exists.");
        }
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + convertDatabaseNameToFileName(databaseName));
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            throw new PowerRuntimeException("New database was not created.");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Deletes forever the database with the given name.
     *
     * @param databaseName
     */
    public static void dropDatabase(String databaseName) {
        if (!existsDatabase(databaseName)) {
            throw new PowerRuntimeException("There is no database with the given name.");
        }
        File file = new File("./" + convertDatabaseNameToFileName(databaseName));
        boolean delete = file.delete();
        if (!delete) {
            throw new PowerRuntimeException("The database was not dropped.");
        }
    }

    /**
     * @param databaseName
     * @return true, if a database with the name exists, otherwise false.
     */
    public static boolean existsDatabase(String databaseName) {
        File file = new File("./" + convertDatabaseNameToFileName(databaseName));
        return (file.exists()) && !(file.isDirectory());
    }

    /**
     * Creates a database connection for the database with the given name.
     *
     * @param databaseName
     * @return database connection to the database with the given name
     */
    public static DatabaseConnection createDatabaseConnection(String databaseName) {
        if ((databaseName != "") && (!existsDatabase(databaseName))) {
            throw new PowerRuntimeException("There is no database with the given name.");
        }
        return new DatabaseConnection(databaseName);
    }

    /**
     * Creates a new in memory database and return its connection
     *
     * @return database connection
     */
    public static DatabaseConnection createInMemoryDatabaseConnection() {
        return createDatabaseConnection("");
    }

    private static String convertDatabaseNameToFileName(String databaseName) {
        return databaseName + SQLITEEXTENSION;
    }

}
