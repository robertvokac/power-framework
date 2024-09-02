
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nanoboot.powerframework.json.JsonArray;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.core.PowerException;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import static org.nanoboot.powerframework.utils.StringUtils.EMPTY_STRING;

/**
 * Represents connection to a database.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Database {

    private Connection connection = null;
    private Statement statement = null;
    private final String databaseName;

    private final String jdbcUrl;

    private static final String DOT_SQLITE = ".sqlite";

    Database(String databaseName) {
        this.databaseName = databaseName;
        StringBuilder stringBuilder = new StringBuilder().append("jdbc:sqlite:");
        if(!databaseName.equals(EMPTY_STRING)) {
            stringBuilder.append(databaseName).append(DOT_SQLITE).toString();
        }
        this.jdbcUrl = stringBuilder.toString();
    }

    public UniversalDateTime backup() {
        UniversalDateTime universalDateTime = UniversalDateTime.now();
        String dateTimeString = universalDateTime.toString().replace(":", " ");
        File databaseFile = new File("." + File.separator + databaseName + DOT_SQLITE);

        File backupDatabaseFile = new File("." + File.separator + databaseFile.getName() + "." + dateTimeString + "." + "sqlitebackup");
        try {
            copyFileUsingStream(databaseFile, backupDatabaseFile);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return universalDateTime;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    /**
     *
     * @return name of the database of this database connection
     */
    public String getDatabaseName() {
        return databaseName;
    }

    private void setConnection() {
        setConnection(false);
    }

    private void setConnection(boolean foreignKeysOn) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(jdbcUrl);
            statement = connection.createStatement();
            if(foreignKeysOn) {
                statement.execute("PRAGMA foreign_keys = ON;");
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Executes sql command, which returns no result.
     *
     * @param command
     *
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
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.err.println(command);
        return lastInsertedRowId;
    }

    /**
     * Executes sql command, which returns no result.
     *
     * @param command
     *
     * @return last inserted row id
     */
    public int executeWithForeingKeysOff(String command) {
        int lastInsertedRowId = 0;
        setConnection(false);
        ResultSet resultSet = null;
        try {
            statement.executeUpdate(command);
            resultSet = statement.executeQuery("SELECT last_insert_rowid() AS LASTINSERTEDROWID;");
            resultSet.next();
            lastInsertedRowId = resultSet.getInt(1);
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.err.println(command);
        return lastInsertedRowId;
    }

    /**
     * Executes sql commands from the command queue.
     *
     * @param commandQueue
     */
    public void executeMoreCommands(CommandStore commandQueue) {
        setConnection();

        try {
            connection.setAutoCommit(false);
            while (commandQueue.hasNextCommand()) {
                String command = commandQueue.getNextCommand();
                System.err.println(command);
                statement.executeUpdate(command);

            }

            //No changes has been made in the database yet, so now we will commit
            //the changes.
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            try {
                //An error occured so we rollback the changes.
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex1);
                throw new DatabaseOperatingException("Fatal error happened. I was not able to rollback");
            }
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
        CommandStore commandQueue = new CommandStore(commands);

        this.executeMoreCommands(commandQueue);
    }

    /**
     * Executes sql command, which returns result.
     *
     * @param command
     *
     * @return
     */
    public Table executeAndReturn(String command) {
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
                for (int i = 0; i < columns.size(); i++) {
                    String columnName = columns.getString(i);
                    String value = resultSet.getString(columnName);
                    row.addString(value);
                }
                rows.addArray(row);
            }

            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnectionAndResultSet(resultSet);
        }
        System.err.println(command);
        return new Table(table);
    }

    public ArrayList<String> executeAndReturnIds(String command, String idColumnName) {
        Table table = executeAndReturn(command);
        ArrayList<String> list = new ArrayList<>();
        while (table.hasNextRow()) {
            table.moveToTheNextRow();
            list.add(table.getString(idColumnName));
        }

        return list;
    }

    private void closeConnectionAndResultSet(ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
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
    public void updateValue(String tableName,
            int id,
            String columnName,
            String newValue) {
        String command
                = "UPDATE " + tableName + " SET " + columnName + " = '" + newValue + "' WHERE ID = " + id;
        this.execute(command);
        System.err.println(command);
    }

    /**
     * Updates value.
     *
     * @param tableName
     * @param id
     * @param columnName
     * @param newValue
     */
    public void updateValue(String tableName,
            int id,
            String columnName,
            int newValue) {
        String command
                = "UPDATE " + tableName + " SET " + columnName + " = " + newValue + " WHERE ID = " + id;
        this.execute(command);
        System.err.println(command);
    }

    /**
     *
     * @param tableName
     * @param id
     *
     * @return row with the given id from the given table as a json object
     */
    public JsonObject getRow(String tableName,
            int id) {
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
            System.err.println(command);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columns.addString(columnName);
            }

            if(!resultSet.next()) {
                throw new DatabaseOperatingException("There is no row with id " + id + " in table " + tableName);
            }

            for (int i = 0; i < columns.size(); i++) {
                String columnName = columns.getString(i);
                String value = resultSet.getString(columnName);
                row.addString(columnName, value);
            }

            connection.close();
        } catch (SQLException | PowerException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            throw new IllegalStateException();
        } finally {

            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return row;
    }

    public JsonObject getRow(String tableName, String uidIn) {

        JsonObject row = new JsonObject();

        JsonArray columns = new JsonArray();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ");
        stringBuilder.append(tableName);
        stringBuilder.append(" where UUID='");
        stringBuilder.append(uidIn);
        stringBuilder.append("'");

        String command = stringBuilder.toString();

        setConnection();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(command);
            System.err.println(command);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columns.addString(columnName);
            }

            if(!resultSet.next()) {
                throw new DatabaseOperatingException("There is no row with uid " + uidIn + " in table " + tableName);
            }

            for (int i = 0; i < columns.size(); i++) {
                String columnName = columns.getString(i);
                String value = resultSet.getString(columnName);
                row.addString(columnName, value);
            }

            connection.close();
        } catch (SQLException | PowerException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            throw new IllegalStateException();
        } finally {

            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return row;
    }

    /**
     *
     * @param tableName
     *
     * @return true, if the table is empty, otherwise false.
     */
    public boolean isTableEmpty(String tableName) {
        Table resultOfSqlQuery = this.executeAndReturn("SELECT * FROM " + tableName);
        return resultOfSqlQuery.isEmpty();
    }

    /**
     *
     * @param table table name
     * @param column column name
     * @param whereClause for example: year_of_birth is greater than 1995
     *
     * @return String value from a table and first row
     */
    public String getString(String table,
            String column,
            String whereClause) {
        String command = "SELECT " + column + " FROM " + table + " WHERE " + whereClause;
        String value = null;

        setConnection();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(command);

            if(resultSet.next()) {
                value = resultSet.getString(column);
            }
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            closeConnectionAndResultSet(resultSet);

        }
        System.err.println(command);
        return value;
    }

    public boolean existTable(String tableName) {
        Table table = executeAndReturn("SELECT name FROM sqlite_master WHERE type='table' AND name='" + tableName + "'");
        return !table.isEmpty();
    }

}
