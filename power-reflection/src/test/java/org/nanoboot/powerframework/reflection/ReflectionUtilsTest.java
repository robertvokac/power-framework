
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

package org.nanoboot.powerframework.reflection;

import org.nanoboot.powerframework.core.PowerException;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ReflectionUtilsTest {

    @Test(expected = PowerException.class)
    public void getClassForName() {
        //prepare
        //execute
        ReflectionUtils.getClassForName("abc.Def");
        //verify
    }

    @Test(expected = PowerException.class)
    public void getConstructor() {
        //prepare
        //execute
        ReflectionUtils.getConstructor(Integer.class, Boolean.class);
        //verify
    }

    @Test(expected = PowerException.class)
    public void newInstance() {
        //prepare

        //execute
        Constructor<TestClassWithBadConstructorAndMethods> constructor;
        try {
            constructor = TestClassWithBadConstructorAndMethods.class.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
        ReflectionUtils.newInstance(constructor);
        //verify
    }

    @Test(expected = PowerException.class)
    public void getMethod() {
        //prepare
        //execute
        ReflectionUtils.getMethod(Integer.class, "abc");
        //assert
    }

    @Test(expected = PowerException.class)
    public void invokeMethod() {
        //prepare
        TestClassWithBadConstructorAndMethods testClassWithBadConstructorAndMethods =
                new TestClassWithBadConstructorAndMethods(true);
        //execute
        Method method = ReflectionUtils.getMethod(
                TestClassWithBadConstructorAndMethods.class,
                "throwIllegalAccessException");
        ReflectionUtils.invokeMethod(method, testClassWithBadConstructorAndMethods);
        //assert
    }

    @Test
    public void getGetterMethodName() {
        //prepare
        //execute
        //assert
        assertEquals("getMyName", ReflectionUtils.getGetterMethodName("myName"));
    }

    @Test
    public void getSetterMethodName() {
        //prepare
        //execute
        //assert
        assertEquals("setMyName", ReflectionUtils.getSetterMethodName("myName"));
    }

    @Test
    public void setBean() {
        //prepare
        TestClassWithBadConstructorAndMethods testClassWithBadConstructorAndMethods =
                new TestClassWithBadConstructorAndMethods(true);
        //execute
        //assert
        ReflectionUtils.
                setBean(testClassWithBadConstructorAndMethods, "name", "testName");
        String returned = testClassWithBadConstructorAndMethods.getName();
        assertEquals("testName", returned);
    }

    @Test
    public void getBean() {
        //prepare
        TestClassWithBadConstructorAndMethods testClassWithBadConstructorAndMethods =
                new TestClassWithBadConstructorAndMethods(true);
        testClassWithBadConstructorAndMethods.setName("testName");
        //execute
        //assert
        Object returned = ReflectionUtils.
                getBean(testClassWithBadConstructorAndMethods, "name");
        assertEquals("testName",returned);
    }
}
