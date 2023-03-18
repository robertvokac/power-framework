
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

import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class BlobTest {

    public BlobTest() {
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
     * Test of fillAllByZeroes method, of class Blob.
     */
    @Test
    public void testBlobString() {

        //arrange
        Blob blob = new Blob(10);
        blob.fillRandom();
        Blob blob2;
        String expectedString = blob.toString();
        String returnedString;
        //act
        blob2 = new Blob(expectedString);
        returnedString = blob2.toString();
        //assert
        System.out.println(expectedString);
        System.out.println(returnedString);
        assertTrue(expectedString.equals(returnedString));
    }

    /**
     * Test of fillAllByZeroes method, of class Blob.
     */
    @Test
    public void testFillAllByZeroes() {

        //arrange
        Blob blob = new Blob(2);
        String expectedString = "0000000000000000";
        String returnedString;
        //act
        returnedString = blob.toString();
        //assert
        assertTrue(expectedString.equals(returnedString));
    }

    /**
     * Test of fillAllByZeroes method, of class Blob.
     */
    @Test
    public void testFillAllByZeroes2() {
        //arrange
        Blob blob = new Blob(2);
        blob.fillRandom();
        blob.fillAllByZeroes();
        String expectedString = "0000000000000000";
        String returnedString;
        //act
        returnedString = blob.toString();
        //assert
        assertTrue(expectedString.equals(returnedString));
    }

    /**
     * Test of fillAllByOnes method, of class Blob.
     */
    @Test
    public void testFillAllByOnes() {
        //arrange
        Blob blob = new Blob(2);
        blob.fillAllByOnes();
        String expectedString = "1111111111111111";
        String returnedString;
        //act
        returnedString = blob.toString();
        //assert
        assertTrue(expectedString.equals(returnedString));
    }

    /**
     * Test of fillAllByOnes method, of class Blob.
     */
    @Test
    public void testFillAllByOnes2() {
        //arrange
        Blob blob = new Blob(2);
        blob.fillRandom();
        blob.fillAllByOnes();
        String expectedString = "1111111111111111";
        String returnedString;
        //act
        returnedString = blob.toString();
        //assert
        assertTrue(expectedString.equals(returnedString));
    }

    /**
     * Test of fillRandom method, of class Blob.
     */
    @Test
    public void testFillRandom() {
        //arrange
        Blob blob = new Blob(2);
        blob.fillRandom();
        blob.fillAllByOnes();
        String notExpectedString = "0000000000000000";
        String returnedString;
        //act
        returnedString = blob.toString();
        //assert
        assertFalse(notExpectedString.equals(returnedString));
    }

    /**
     * Test of getByte method, of class Blob.
     */
    @Test
    public void testGetByte() {
        //arrange
        Blob blob = new Blob(5);

        boolean[] expectedArray = new boolean[]{true, false, false, false, true, true, false, true};
        boolean[] returnedArray;
        blob.setByte(2, new boolean[]{true, false, false, false, true, true, false, true});
        //act

        returnedArray = blob.getByte(2);
        //assert
        assertArrayEquals(expectedArray, returnedArray);
    }

    /**
     * Test of setByte method, of class Blob.
     */
    @Test
    public void testSetByte() {
        //arrange
        Blob blob = new Blob(5);

        String expectedString = "0000000000000000100011010000000000000000";
        String returnedString;
        //act
        blob.setByte(2, new boolean[]{true, false, false, false, true, true, false, true});
        returnedString = blob.toString();
        //assert
        assertTrue(expectedString.equals(returnedString));
    }

    /**
     * Test of getBits method, of class Blob.
     */
    @Test
    public void testGetBits() {
        //arrange
        Blob blob = new Blob(2);
        blob.setByte(0, new boolean[]{true, true, false, true, false, true, true, false});
        blob.setByte(1, new boolean[]{false, true, true, false, false, false, true, false});

        boolean[] expectedArray = new boolean[]{true, false, false, true, true, false};
        boolean[] returnedArray;

        //act
        returnedArray = blob.getBits(6, 11);
        //assert
        assertArrayEquals(expectedArray, returnedArray);
    }

    /**
     * Test of getBits method, of class Blob.
     */
    @Test
    public void testGetBits2() {
        //arrange
        Blob blob = new Blob(4);
        blob.setByte(0, new boolean[]{true, true, false, true, false, true, true, false});
        blob.setByte(1, new boolean[]{false, true, true, false, false, false, true, false});
        blob.setByte(2, new boolean[]{true, false, true, true, false, true, false, false});
        blob.setByte(3, new boolean[]{false, true, false, true, false, true, false, true});

        boolean[] expectedArray = new boolean[]{false, true, true, false, true, false, false, false, true};
        boolean[] returnedArray;

        //act
        returnedArray = blob.getBits(17, 25);
        //assert
        assertArrayEquals(expectedArray, returnedArray);
    }

    /**
     * Test of getBits method, of class Blob.
     */
    @Test
    public void testSetBits() {
        //arrange
        Blob blob = new Blob(4);
        blob.fillAllByZeroes();

        boolean[] expectedArray = new boolean[]{false, true, true, false, true, false, false, false, true};
        boolean[] returnedArray;

        //act
        blob.setBits(17, new boolean[]{false, true, true, false, true, false, false, false, true});

        returnedArray = blob.getBits(17, 25);

        //assert
        assertArrayEquals(expectedArray, returnedArray);
    }

    /**
     * Test of getBits method, of class Blob.
     */
    @Test
    public void testSetBits2() {

        W5RandomGenerator pseudoW5RandomGenerator = W5RandomGenerator.getStaticInstance();

        for (int i = 0; i < 10; i++) {
            //System.out.println("Iteration number " + i);
            //arrange
            Blob blob = new Blob(4);

            boolean[] randomBooleanArray = new boolean[8];

            for (int j = 0; j < 8; j++) {
                randomBooleanArray[j] = pseudoW5RandomGenerator.nextBoolean();
            }
            //act
            String randomBooleanArrayAsString = new Blob(new byte[]{Byte.booleanArrayToByte(randomBooleanArray)}).toString();
            //System.out.println("Random boolean array is " + randomBooleanArrayAsString);
            int startBit = pseudoW5RandomGenerator.nextInt(0, 24);
            //System.out.println("Start bit is " + startBit);
            blob.setBits(startBit, randomBooleanArray);
            //System.out.println("The blob is now: ");
            String blobAsString = blob.toString();
            for (int k = 0; k < blobAsString.length(); k++) {

                //System.out.print(blobAsString.charAt(k));
                if((k + 1) % 8 == 0) {
                    //System.out.println();
                }
            }
            String blobAsStringSubstring = blobAsString.substring(startBit, startBit + 8);
            //System.out.println("blobAsStringSubstring=" + blobAsStringSubstring);
            //System.out.println("randomBooleanArrayAsString=" + randomBooleanArrayAsString);
            //assert
            assertArrayEquals(randomBooleanArrayAsString.toCharArray(), blobAsStringSubstring.toCharArray());
        }

    }

    /**
     * Test of toString method, of class Blob.
     */
    @Test
    public void testToString() {
        //arrange
        boolean[][] booleanArrays = new boolean[][]{{false, true, true, false, true, false, false, false}, {true, true, false, true, false, true, false, true}};
        Blob blob = new Blob(2);

        String expectedString = "0110100011010101";
        String returnedString;

        //act
        blob.setByte(0, booleanArrays[0]);
        blob.setByte(1, booleanArrays[1]);

        returnedString = blob.toString();

        //assert
        assertEquals(expectedString, returnedString);
    }

//
//    /**
//     * Test of flopAll method, of class Blob.
//     */
//    @Test
//    public void testFlopAll() {
//        //arrange
//        Blob blob = new Blob(2);
//
//        String expectedString = "1111111111111111";
//        String returnedString;
//
//        //act
//        blob.flopAll();
//
//        returnedString = blob.toString();
//
//        //assert
//        assertArrayEquals(expectedString.toCharArray(), returnedString.toCharArray());
//    }
//
//    /**
//     * Test of flopAll method, of class Blob.
//     */
//    @Test
//    public void testFlopAll2() {
//        //arrange
//        Blob blob = new Blob(2);
//
//        String expectedString = "0000000000000000";
//        String returnedString;
//
//        //act
//        blob.fillAllByOnes();
//        blob.flopAll();
//
//        returnedString = blob.toString();
//
//        //assert
//        assertArrayEquals(expectedString.toCharArray(), returnedString.toCharArray());
//    }
//
//    /**
//     * Test of flopAll method, of class Blob.
//     */
//    @Test
//    public void testFlopAll3() {
//        //arrange
//        Blob blob = new Blob("0100100101010001");
//        String expectedString = "1011011010101110";
//        String returnedString;
//
//        //act
//        blob.flopAll();
//
//        returnedString = blob.toString();
//
//        //assert
//        assertArrayEquals(expectedString.toCharArray(), returnedString.toCharArray());
//    }

//    /**
//     * Test of flop method, of class Blob.
//     */
//    @Test
//    public void testFlop() {
//        //arrange
//        Blob blob = new Blob("0100100101010001");
//        String expectedString = "1011011001010001";
//        String returnedString;
//
//        //act
//        blob.flop(0, 0);
//
//        returnedString = blob.toString();
//        System.out.println("###\n" + expectedString + "\n" + returnedString);
//
//        //assert
//        assertArrayEquals(expectedString.toCharArray(), returnedString.toCharArray());
//    }
    /**
     * Test of flopBooleanArray method, of class Blob.
     */
    @Test
    public void testFlopBooleanArray() {
        //arrange

        boolean[] booleanArray = new boolean[]{true, true, false, true, false, true, true, false};
        Blob blob = new Blob(Byte.booleanArrayToByte(booleanArray));

        boolean[] expectedArray = new boolean[]{false, false, true, false, true, false, false, true};
        boolean[] returnedArray;

        //act
        returnedArray = Blob.flopBooleanArray(booleanArray);
        //assert
        assertArrayEquals(expectedArray, returnedArray);
    }

}
