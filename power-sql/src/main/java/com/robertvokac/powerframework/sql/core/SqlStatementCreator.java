
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

package com.robertvokac.powerframework.sql.core;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 *
 */
public class SqlStatementCreator {

    /**
     * Constant description
     */
    private static final String SELECT_ALL_FROM = "SELECT * FROM ";
    private static final String SELECT_UUID_FROM = "SELECT UUID FROM ";
    private static final String INSERT_INTO_TEMPLATE = "INSERT INTO %s VALUES (%s);";
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET ";
    private static final String WHERE = "WHERE";

    /**
     * Field description
     */
    private String name;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private SqlStatementCreator() {
    }

    /**
     * Setter for name.
     */
    public static String createSelect(String tableName, String conditions) {
        String sql = SELECT_ALL_FROM + tableName + (conditions != null ? (" WHERE " + conditions) : "");
        //System.out.println(sql);
        return sql;
    }

    /**
     * Setter for name.
     *
     */
    public static String createSelectUuids(String tableName, String conditions) {
        String sql = SELECT_UUID_FROM + tableName + (conditions != null ? (" WHERE " + conditions) : "");
        //System.out.println(sql);
        return sql;
    }

    /**
     * Setter for name.
     *
     */
    public static String createInsert(String tableName, String... valuesIn) {
        String valuesAsString;
        StringBuilder stringBuilder = new StringBuilder();
        int valuesInMaxIndex = valuesIn.length - 1;

        for (int i = 0; i <= valuesInMaxIndex; i++) {
            String e = valuesIn[i];
            stringBuilder.append(e);
            if(i < valuesInMaxIndex) {
                stringBuilder.append(',').append(' ');
            }

        }
        valuesAsString = stringBuilder.toString();
        String sql = String.format(INSERT_INTO_TEMPLATE, tableName, valuesAsString);
        //System.out.println(sql);
        return sql;
    }

    /**
     * Setter for name.
     *
     */
    public static String createUpdate(String tableName, String conditions, ColumnNameValue... columnNameValues) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(UPDATE_TEMPLATE, tableName));
        int columnNameValuesStringMaxIndex = columnNameValues.length - 1;

        for (int i = 0; i <= columnNameValuesStringMaxIndex; i++) {
            String e = columnNameValues[i].toString();
            stringBuilder.append(e);
            if(i < columnNameValuesStringMaxIndex) {
                stringBuilder.append(',').append(' ');
            }

        }
        if(conditions != null) {
            stringBuilder.append(' ');
            stringBuilder.append(WHERE);
            stringBuilder.append(' ');
            stringBuilder.append(conditions);
        }
        String sql = stringBuilder.toString();
        //System.out.println(sql);
        return sql;
    }

}
