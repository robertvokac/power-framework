
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

package org.nanoboot.powerframework.pseudorandom;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class SeedTest {

    public SeedTest() {
    }

    /**
     * Test of getNextNumber method, of class Seed.
     */
    @Test
    public void testGetNextNumber() {
        //arrange
        Seed seed = new Seed(5);
        long expectedValue = 1679444804;
        long returnedValue;
        //act
        for (int i = 1; i <= 37; i++) {
            seed.getNextNumber();
        }
        returnedValue = seed.getNextNumber();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of jump method, of class Seed.
     */
    @Test
    public void testJump() {
        //arrange
        Seed seed = new Seed(5);
        long expectedValue = 1679444804;
        long returnedValue;
        //act
        for (int i = 1; i <= 37; i++) {
            seed.jump();
        }
        returnedValue = seed.getNextNumber();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

}
