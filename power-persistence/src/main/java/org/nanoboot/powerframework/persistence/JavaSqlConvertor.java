
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

package org.nanoboot.powerframework.persistence;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class JavaSqlConvertor {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(JavaSqlConvertor.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    /**
     * Field description
     */
    private String name;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private JavaSqlConvertor() {
    }

    static String getStringFromJava(Object object, EntityAttribute attribute) {
        String value = "";
        if(attribute.getJavaType().equals("int")) {
            value = String.valueOf(MethodInvocation.getInt(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("byte")) {
            value = String.valueOf(MethodInvocation.getByte(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("short")) {
            value = String.valueOf(MethodInvocation.getShort(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("long")) {
            value = String.valueOf(MethodInvocation.getLong(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("float")) {
            value = String.valueOf(MethodInvocation.getFloat(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("double")) {
            value = String.valueOf(MethodInvocation.getDouble(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("boolean")) {
            value = MethodInvocation.getBoolean(object, attribute.getJavaName()) ? "1" : "0";
        }
        if(attribute.getJavaType().equals("java.lang.Integer")) {
            value = String.valueOf(MethodInvocation.getInt(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("java.lang.Byte")) {
            value = String.valueOf(MethodInvocation.getByte(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("java.lang.Short")) {
            value = String.valueOf(MethodInvocation.getShort(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("java.lang.Long")) {
            value = String.valueOf(MethodInvocation.getLong(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("java.lang.Float")) {
            value = String.valueOf(MethodInvocation.getFloat(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("java.lang.Double")) {
            value = String.valueOf(MethodInvocation.getDouble(object, attribute.getJavaName()));
        }
        if(attribute.getJavaType().equals("java.lang.Boolean")) {
            value = MethodInvocation.getBoolean(object, attribute.getJavaName()) ? "1" : "0";
        }
        if(attribute.getJavaType().equals("java.lang.String")) {
            value = '\'' + MethodInvocation.getString(object, attribute.getJavaName()) + '\'';
        }
        return value;
    }
}
