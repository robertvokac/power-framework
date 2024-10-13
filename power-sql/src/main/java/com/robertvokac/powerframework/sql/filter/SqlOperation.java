
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

package com.robertvokac.powerframework.sql.filter;

/**
 * SqlOperation Class.
 * 
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class SqlOperation extends AbstractFilter {
    public static final String EQUAL = "=";
    public static final String GREATER_OR_EQUAL = ">=";
    public static final String GREATER = ">";
    public static final String LESS_OR_EQUAL = "<=";
    public static final String LESS = "<";

    private static final String IN = " IN ";
    private static final String NOT_IN = " NOT IN ";

    public static SqlOperation createNotInSqlOperation(final String what, final Object[] where) {
        return createInSqlOperation(what, where, true);
    }

    public static SqlOperation createInSqlOperation(final String what, final Object[] where) {
        return createInSqlOperation(what, where, false);
    }

    private static SqlOperation createInSqlOperation(final String what, final Object[] where, final boolean not) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(what);
        stringBuilder.append(not ? NOT_IN : IN);
        stringBuilder.append("(");
        int index = 0;
        int maxIndex = where.length - 1;
        for (Object e : where) {
            stringBuilder.append(e);
            if (index != maxIndex) {
                stringBuilder.append(", ");
            }

            index++;
        }
        stringBuilder.append("))");
        SqlOperation sqlOperation = new SqlOperation();
        sqlOperation.result = stringBuilder.toString();
        return sqlOperation;
    }

    private SqlOperation() {

    }

    public SqlOperation(final String operation, final Object object1, final Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(object1);
        stringBuilder.append(' ');
        stringBuilder.append(operation);
        stringBuilder.append(' ');
        stringBuilder.append(object2);
        stringBuilder.append(')');
        this.result = stringBuilder.toString();
    }

    public SqlOperation(final String raw) {
        this.result = raw;
    }

    public static String quote(final String string) {
        return '\'' + string + '\'';
    }
}
