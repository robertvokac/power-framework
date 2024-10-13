
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

package com.robertvokac.powerframework.reflection;

import com.robertvokac.powerframework.core.PowerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public final class ReflectionUtils {
    /**
     * Constructor.
     */
    private ReflectionUtils() {
        //Not needed to be instantiated.
    }

    /**
     * @param classFullName class full name
     * @return Class instance with the given name
     * @throws PowerException if there is found no such class
     */
    public static Class getClassForName(final String classFullName) {
        Class clazz = null;
        try {
            clazz = Class.forName(classFullName);
        } catch (ClassNotFoundException e) {
            throw new PowerException(e);
        }
        return clazz;
    }
    /**
     * @param clazz Class instance
     * @param parameterTypes parameter types
     *
     * @return Constructor instance with the given parameter types
     * @throws PowerException if there is found no such class
     */
    public static Constructor getConstructor(
            final Class clazz, final Class<?>... parameterTypes) {
        Constructor constructor;
        try {
            constructor = clazz.getConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            StringBuilder sb = new StringBuilder();
            for (Class c :parameterTypes) {
                sb.append(c.getName());
                sb.append(", ");
            }
            String msg = "Class " + clazz
                    + " has no constructor with parameters \""
                    + sb.toString() + "\" " + e.toString();
            throw new PowerException(msg);
        }

        return constructor;
    }

    /**
     * @param constructor constructor
     * @param parameters parameters
     *
     * @return Object instance for the given constructor
     * @throws PowerException if instantiation failed
     */
    public static Object newInstance(
            final Constructor constructor,
            final Object... parameters) {
        Object o;
        try {
            o = constructor.newInstance(parameters);
        } catch (InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            throw new PowerException(e);
        }
        return o;

    }
    /**
     * @param forClass class
     * @param methodName method name
     * @param parameterTypes parameter types
     *
     * @return Constructor instance with the given parameter types
     * @throws PowerException if there is found no such method
     */
    public static Method getMethod(
            final Class forClass,
            final String methodName,
            final Class<?>... parameterTypes) {
        Method method;
        try {
            method = forClass.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new PowerException(e);
        }

        return method;
    }

    /**
     * Invokes a method.
     * @param method method
     * @param o object
     * @param args arguments
     * @return Return object, if there is one
     */
    public static Object invokeMethod(
            final Method method,
            final Object o,
            final Object... args) {
        try {
            return method.invoke(o, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new PowerException(e);
        }

    }

    /**
     * @param beanName bean name
     * @return getter name
     */
    public static String getGetterMethodName(final String beanName) {
        return getBeanMethodName(beanName, BeanMethod.GETTER);
    }
    /**
     * @param beanName bean name
     * @return setter name
     */
    public static String getSetterMethodName(final String beanName) {
        return getBeanMethodName(beanName, BeanMethod.SETTER);
    }

    /**
     * @param beanName bean name
     * @param beanMethod bean method
     * @return bean method name
     */
    private static String getBeanMethodName(
            final String beanName,
            final BeanMethod beanMethod) {
        return beanMethod.getPrefix()
                + makeFirstLetterUpperCase(beanName);
    }

    /**
     * Makes the first letter upper case.
     * @param string input string
     * @return modified string
     */
    private static String makeFirstLetterUpperCase(final String string) {
        return string.substring(0, 1)
                .toUpperCase() + string.substring(1, string.length());
    }

    /**
     * Invoke setter of a object for a bean.
     *
     * @param object object
     * @param beanName bean name
     * @param bean bean
     */
    public static void setBean(
            final Object object, final String beanName, final Object bean) {
        Method method = getMethod(
                object.getClass(),
                getSetterMethodName(beanName),
                bean.getClass());
        invokeMethod(method, object, bean);
    }
    /**
     * Invoke getter of a object for a bean.
     *
     * @param object object
     * @param beanName bean name
     * @return bean
     */
    public static Object getBean(
            final Object object,
            final String beanName) {
        Method method = getMethod(
                object.getClass(), getGetterMethodName(beanName));
        return invokeMethod(method, object);
    }
}
