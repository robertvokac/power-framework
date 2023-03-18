
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nanoboot.powerframework.PowerRuntimeException;
import org.nanoboot.powerframework.json.*;

/**
 * Represents connection to a database.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class DatabaseConnection {

    private Connection connection = null;
    private Statement statement = null;
    private final String databaseName;

    private final String jdbcUrl;

    DatabaseConnection(String databaseName) {
        this.databaseName = databaseName;
        StringBuilder stringBuilder = new StringBuilder().append("jdbc:sqlite:");
        if (databaseName != "") {
            stringBuilder.append(databaseName).append(".sqlite").toString();
        }
        this.jdbcUrl = stringBuilder.toString();
    }

    /**
     *
     * @return name of the database of this database connection
     */
    public String getDatabaseName() {
        return databaseName;
    }

    private void setConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(jdbcUrl);
            statement = connection.createStatement();
            statement.execute("PRAGMA foreign_keys = ON;");
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Executes sql command, which returns no result.
     *
     * @param command
     * @return last inserted row id
     */
    public int execute(String command) {
        int lastInsertedRowId = 0;
        setConnection();
        ResultSet resultSet = null;
        try {
            statement.executeUpdate(command);
            resultSet = statement.executeQuery("SELECT last_insert_rowid() AS LASTINSERTEDROWID;");
            resultSet.next();
            lastInsertedRowId = resultSet.getInt(1);
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return lastInsertedRowId;
    }

    /**
     * Executes sql commands from the command queue.
     *
     * @param commandQueue
     */
    public void executeMoreCommands(SqlCommandQueue commandQueue) {
        setConnection();

        try {
            connection.setAutoCommit(false);
            while (commandQueue.isThereANextCommand()) {
                String command = commandQueue.loadNextCommand();
                statement.executeUpdate(command);

            }

            //No changes has been made in the database yet, so now we will commit
            //the changes.
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            try {
                //An error occured so we rollback the changes.
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex1);
                throw new PowerRuntimeException("Fatal error happened. I was not able to rollback");
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Executes sql commands from the given String, which is split by ;
     * character.
     *
     * @param commands
     */
    public void executeMoreCommands(String commands) {
        SqlCommandQueue commandQueue = new SqlCommandQueue();
        String[] commandsArray = commands.split(";");
        for (String part : commandsArray) {
            commandQueue.add(part);
        }
        this.executeMoreCommands(commandQueue);
    }

    /**
     * Executes sql command, which returns result.
     *
     * @param command
     * @return
     */
    public ResultOfSqlQuery executeAndReturn(String command) {
        JsonObject table = new JsonObject();

        JsonArray columns = new JsonArray();
        JsonArray rows = new JsonArray();

        table.addString("query", command);
        table.addArray("columns", columns);
        table.addArray("rows", rows);

        setConnection();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(command);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columns.addString(columnName);
            }

            while (resultSet.next()) {
                JsonArray row = new JsonArray();
                for (int i = 0; i < columns.getCountOfItems(); i++) {
                    String columnName = columns.getString(i);
                    String value = resultSet.getString(columnName);
                    row.addString(value);
                }
                rows.addArray(row);
            }

            connection.close();
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnectionAndResultSet(resultSet);
        }
        return new ResultOfSqlQuery(table);
    }

    private void closeConnectionAndResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Updates value.
     *
     * @param tableName
     * @param id
     * @param columnName
     * @param newValue
     */
    public void updateValue(String tableName, int id, String columnName, String newValue) {
        String string
                = "UPDATE " + tableName + " SET " + columnName + " = '" + newValue + "' WHERE ID = " + id;
        this.execute(string);
    }

    /**
     * Updates value.
     *
     * @param tableName
     * @param id
     * @param columnName
     * @param newValue
     */
    public void updateValue(String tableName, int id, String columnName, int newValue) {
        String string
                = "UPDATE " + tableName + " SET " + columnName + " = " + newValue + " WHERE ID = " + id;
        this.execute(string);
    }

    /**
     *
     * @param tableName
     * @param id
     * @return row with the given id from the given table as a json object
     */
    public JsonObject getRow(String tableName, int id) {
        JsonObject row = new JsonObject();

        JsonArray columns = new JsonArray();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ");
        stringBuilder.append(tableName);
        stringBuilder.append(" where id=");
        stringBuilder.append(id);

        String command = stringBuilder.toString();

        setConnection();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(command);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columns.addString(columnName);
            }

            if (!resultSet.next()) {
                throw new PowerRuntimeException("There is no row with id " + id + " in table " + tableName);
            }

            for (int i = 0; i < columns.getCountOfItems(); i++) {
                String columnName = columns.getString(i);
                String value = resultSet.getString(columnName);
                row.addString(columnName, value);
            }

            connection.close();
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
            throw new IllegalStateException();
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return row;
    }

    /**
     *
     * @param tableName
     * @return true, if the table is empty, otherwise false.
     */
    public boolean isTableEmpty(String tableName) {
        ResultOfSqlQuery resultOfSqlQuery = this.executeAndReturn("SELECT * FROM " + tableName);
        return resultOfSqlQuery.isEmpty();
    }

    /**
     *
     * @param table table name
     * @param column column name
     * @param whereClause for example: year_of_birth>1995
     * @return String value from a table and first row
     */
    public String getString(String table, String column, String whereClause) {
        String command = "SELECT " + column + " FROM " + table + " WHERE " + whereClause;
        String value = null;

        setConnection();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(command);

            if (resultSet.next()) {
                value = resultSet.getString(column);
            }
            connection.close();
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            closeConnectionAndResultSet(resultSet);

        }

        return value;
    }
}
