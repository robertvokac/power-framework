
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

package org.nanoboot.powerframework.persistence;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 *
 */
public class MethodInvocation {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(MethodInvocation.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    /**
     * Field description
     */
    private String name;

    public static void setInt(Object object, String javaName, Integer value) {
        set(object, javaName, value, Integer.class);

    }

    public static Integer getInt(Object object, String javaName) {
        return (Integer) get(object, javaName);

    }

    public static void setShort(Object object, String javaName, Short value) {
        set(object, javaName, value, Short.class);

    }

    public static Short getShort(Object object, String javaName) {
        return (Short) get(object, javaName);

    }

    public static void setByte(Object object, String javaName, Byte value) {
        set(object, javaName, value, Byte.class);

    }

    public static Byte getByte(Object object, String javaName) {
        return (Byte) get(object, javaName);

    }

    public static void setLong(Object object, String javaName, Long value) {
        set(object, javaName, value, Long.class);

    }

    public static Long getLong(Object object, String javaName) {
        return (Long) get(object, javaName);

    }

    public static void setFloat(Object object, String javaName, Float value) {
        set(object, javaName, value, float.class);

    }

    public static Float getFloat(Object object, String javaName) {
        return (Float) get(object, javaName);

    }

    public static void setDouble(Object object, String javaName, Double value) {
        set(object, javaName, value, double.class);

    }

    public static Double getDouble(Object object, String javaName) {
        return (Double) get(object, javaName);

    }

    public static void setBoolean(Object object, String javaName, Boolean value) {
        set(object, javaName, value, boolean.class);

    }

    public static Boolean getBoolean(Object object, String javaName) {
        return (Boolean) get(object, javaName);

    }

    public static void setString(Object object, String javaName, String value) {
        set(object, javaName, value, String.class);

    }

    public static String getString(Object object, String javaName) {
        return (String) get(object, javaName);

    }

    private static Object get(Object object, String javaName) {
        java.lang.reflect.Method method = getMethod(object, javaName, false);
        return invokeMethod(method, object);

    }

    private static void set(Object object, String javaName, Object value, Class<?> type) {
        java.lang.reflect.Method method = getMethod(object, javaName, true, type);
        invokeMethod(method, object, value);

    }

    private static Object invokeMethod(Method method, Object obj, Object... args) {

        try {
            return method.invoke(obj, args);
        } catch (IllegalArgumentException e) {
            throw new PersistenceException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new PersistenceException(e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println(method.getName() + args.length);
            e.printStackTrace();
            throw new PersistenceException(e.getMessage());
        }

    }

    private static Method getMethod(Object object, String javaName, boolean isSet, Class<?>... parameterTypes) {
        String getMethodName = isSet ? Utils.createSetMethodName(javaName) : Utils.createGetMethodName(javaName);
        java.lang.reflect.Method method;
        try {
            method = object.getClass().getDeclaredMethod(getMethodName, parameterTypes);

        } catch (SecurityException e) {
            throw new PersistenceException(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage());
        }
        return method;
    }

}
