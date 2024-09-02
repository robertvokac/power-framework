
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
