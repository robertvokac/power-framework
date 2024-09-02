
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
import org.nanoboot.powerframework.json.JsonArray;
import org.nanoboot.powerframework.collections.PowerMap;

/**
 * Represents the result of a sql query.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Table {

    private final JsonObject table;
    private final JsonArray columns;
    private final JsonArray rows;
    private int currentRowIndex = -1;
    private final PowerMap<Integer> dictionaryOfColumnNamesIndexes = new PowerMap();

    Table(JsonObject jsonObject) {
        this.table = jsonObject;
        this.columns = table.getArray("columns");
        this.rows = table.getArray("rows");
        fillDictionaryOfColumnNamesIndexes();
    }

    private void fillDictionaryOfColumnNamesIndexes() {
        for (int i = 0; i < columns.size(); i++) {
            String currentColumnName = columns.getString(i);
            dictionaryOfColumnNamesIndexes.put(currentColumnName, i);
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
        return rows.size();
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
        return currentRowIndex + 1 < this.rows.size();
    }

    /**
     * Moves the position of the current Row to the next
     */
    public void moveToTheNextRow() {
        currentRowIndex++;
    }

    private JsonArray getCurrentRow() {
        if(currentRowIndex == -1) {
            throw new DatabaseOperatingException("The position of the current row is before the first row");
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
        return this.dictionaryOfColumnNamesIndexes.get(columnName);
    }

    /**
     *
     * @param columnName
     *
     * @return the value of the column of the current row as int
     */
    public int getInt(String columnName) {
        int columnIndex = getIndexForTheColumn(columnName);
        return Integer.parseInt(getCurrentRow().getString(columnIndex));
    }

    /**
     *
     * @param columnName
     *
     * @return the value of the column of the current row as double
     */
    public double getDouble(String columnName) {
        int columnIndex = getIndexForTheColumn(columnName);
        return Double.parseDouble(getCurrentRow().getString(columnIndex));
    }

    /**
     *
     * @param columnName
     *
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
