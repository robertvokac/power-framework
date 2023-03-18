
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

import org.nanoboot.powerframework.PowerRuntimeException;
import org.nanoboot.powerframework.collections.Dictionary;
import org.nanoboot.powerframework.json.*;

/**
 * Represents the result of a sql query.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class ResultOfSqlQuery {

    private final JsonObject table;
    private final JsonArray columns;
    private final JsonArray rows;
    private int currentRowIndex = -1;
    private final Dictionary<Integer> dictionaryOfColumnNamesIndexes = new Dictionary();

    ResultOfSqlQuery(JsonObject jsonObject) {
        this.table = jsonObject;
        this.columns = table.getArray("columns");
        this.rows = table.getArray("rows");
        fillDictionaryOfColumnNamesIndexes();
    }

    private void fillDictionaryOfColumnNamesIndexes() {
        for (int i = 0; i < columns.getCountOfItems(); i++) {
            String currentColumnName = columns.getString(i);
            dictionaryOfColumnNamesIndexes.addValue(currentColumnName, i);
        }
    }

    /**
     *
     * @return column names as json array
     */
    public JsonArray getColumnNames() {
        return columns.getCopy();
    }

    /**
     *
     * @return rows as json array
     */
    public JsonArray getRows() {
        return rows.getCopy();
    }

    /**
     *
     * @return count of rows
     */
    public int getCountOfRows() {
        return rows.getCountOfItems();
    }

    /**
     *
     * @return true, if this result has no row, otherwise false.
     */
    public boolean isEmpty() {
        return this.rows.isEmpty();
    }

    /**
     * Resets the position of the current row to the first.
     */
    public void resetPositionBeforeFirstRow() {
        this.currentRowIndex = -1;
    }

    /**
     *
     * @return true, if there is a row after the current row, otherwise false.
     */
    public boolean hasNextRow() {
        return currentRowIndex + 1 < this.rows.getCountOfItems();
    }

    /**
     * Moves the position of the current Row to the next
     */
    public void moveToTheNextRow() {
        currentRowIndex++;
    }

    private JsonArray getCurrentRow() {
        if (currentRowIndex == -1) {
            throw new PowerRuntimeException("The position of the current row is before the first row");
        }
        return rows.getArray(currentRowIndex);
    }

    /**
     *
     * @return current row as json array
     */
    public JsonArray getRow() {
        return rows.getArray(currentRowIndex).getCopy();
    }

    private int getIndexForTheColumn(String columnName) {
        return this.dictionaryOfColumnNamesIndexes.getValue(columnName);
    }

    /**
     *
     * @param columnName
     * @return the value of the column of the current row as int
     */
    public int getInt(String columnName) {
        int columnIndex = getIndexForTheColumn(columnName);
        return Integer.parseInt(getCurrentRow().getString(columnIndex));
    }

    /**
     *
     * @param columnName
     * @return the value of the column of the current row as double
     */
    public double getDouble(String columnName) {
        int columnIndex = getIndexForTheColumn(columnName);
        return Double.parseDouble(getCurrentRow().getString(columnIndex));
    }

    /**
     *
     * @param columnName
     * @return the value of the column of the current row as String
     */
    public String getString(String columnName) {
        int columnIndex = getIndexForTheColumn(columnName);
        return getCurrentRow().getString(columnIndex);
    }

    /**
     *
     * @return query, which was executed and returned this result
     */
    public String getQuery() {
        return this.table.getString("query");
    }

    /**
     *
     * @return json object representation of this object
     */
    public JsonObject toJsonObject() {
        return this.table.getCopy();
    }
}
