
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

import java.io.*;
import java.sql.*;
import java.util.logging.*;

/**
 * Manipulates with database.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Databases {

    private static final String SQLITEEXTENSION = ".sqlite";

    /**
     * Creates new database with the given name.
     *
     * @param databaseName
     */
    public static void createDatabase(String databaseName) {
        if(existsDatabase(databaseName)) {
            throw new DatabaseOperatingException("A database with the given name already exists.");
        }
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + convertDatabaseNameToFileName(databaseName));
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseOperatingException("New database was not created.");
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
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
        if(!existsDatabase(databaseName)) {
            throw new DatabaseOperatingException("There is no database with the given name.");
        }
        File file = new File("./" + convertDatabaseNameToFileName(databaseName));
        boolean delete = file.delete();
        if(!delete) {
            throw new DatabaseOperatingException("The database was not dropped.");
        }
    }

    /**
     * @param databaseName
     *
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
     *
     * @return database connection to the database with the given name
     */
    public static Database getDatabase(String databaseName) {
        if((!"".equals(databaseName)) && (!existsDatabase(databaseName))) {
            throw new DatabaseOperatingException("There is no database with the given name.");
        }
        return new Database(databaseName);
    }

    /**
     * Creates a new in memory database and return its connection
     *
     * @return database connection
     */
    public static Database createInMemoryDatabaseConnection() {
        return getDatabase("");
    }

    private static String convertDatabaseNameToFileName(String databaseName) {
        return databaseName + SQLITEEXTENSION;
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private Databases() {
        //Not meant to be instantiated.
    }

}
