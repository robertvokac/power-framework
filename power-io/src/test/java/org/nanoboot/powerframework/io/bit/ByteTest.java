
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

package org.nanoboot.powerframework.io.bit;

import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class ByteTest {

    public ByteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getByteValue method, of class Byte.
     */
    @Test
    public void testBooleanArrayToByte() {
        //arrange
        boolean[] booleanArray = new boolean[]{false, false, false, false, false, false, false, false};
        byte expectedValue = -128;
        int returnedValue;
        //act
        returnedValue = Byte.booleanArrayToByte(booleanArray);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getByteValue method, of class Byte.
     */
    @Test
    public void testBooleanArrayToByte2() {
        //arrange
        boolean[] booleanArray = new boolean[]{false, false, false, false, false, false, false, true};
        byte expectedValue = -127;
        int returnedValue;
        //act
        returnedValue = Byte.booleanArrayToByte(booleanArray);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getByteValue method, of class Byte.
     */
    @Test
    public void testBooleanArrayToByte3() {
        //arrange
        boolean[] booleanArray = new boolean[]{true, true, true, true, true, true, true, true};
        byte expectedValue = 127;
        int returnedValue;
        //act
        returnedValue = Byte.booleanArrayToByte(booleanArray);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray() {
        byte byteValue = -128;
        boolean[] expectedValue = new boolean[]{false, false, false, false, false, false, false, false};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert
        System.out.println(Arrays.toString(returnedValue));
        Assert.assertArrayEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray2() {
        byte byteValue = -127;
        boolean[] expectedValue = new boolean[]{false, false, false, false, false, false, false, true};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert

        Assert.assertArrayEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray3() {
        byte byteValue = -124;
        boolean[] expectedValue = new boolean[]{false, false, false, false, false, true, false, false};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert

        Assert.assertArrayEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray4() {
        byte byteValue = 0;
        boolean[] expectedValue = new boolean[]{true, false, false, false, false, false, false, false};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert

        Assert.assertArrayEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray5() {
        byte byteValue = 1;
        boolean[] expectedValue = new boolean[]{true, false, false, false, false, false, false, true};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert

        Assert.assertArrayEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray6() {
        byte byteValue = 126;
        boolean[] expectedValue = new boolean[]{true, true, true, true, true, true, true, false};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert

        Assert.assertArrayEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBooleanArray method, of class Byte.
     */
    @Test
    public void testByteValueToBooleanArray7() {
        byte byteValue = (byte) (127);
        boolean[] expectedValue = new boolean[]{true, true, true, true, true, true, true, true};
        boolean[] returnedValue;
        //act
        returnedValue = Byte.byteValueToBooleanArray(byteValue);
        //assert

        Assert.assertArrayEquals(expectedValue, returnedValue);
    }
}
