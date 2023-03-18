
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

import org.nanoboot.powerframework.datetime.DateTime;
import org.nanoboot.powerframework.datetime.LocalDateTime;
import org.nanoboot.powerframework.datetime.UniversalDateTime;
import org.nanoboot.powerframework.json.JsonArray;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class PseudoRandomGeneratorTest {

    public PseudoRandomGeneratorTest() {
    }

    /**
     * Test of getLong method, of class PseudoRandomGenerator.
     */
    @Test
    public void testGetLong() {
        //arrange
        PseudoRandomGenerator pseudoRandomGenerator = new PseudoRandomGenerator(987, new LocalDateTime(1991, 5, 24, 6, 28, 53, 862));

        long expectedValue = 420726198994l;
        long returnedValue;
        //act
        for (int i = 1; i <= 4; i++) {
            pseudoRandomGenerator.getLong(0, 499999999999l);
        }
        returnedValue = pseudoRandomGenerator.getLong(0, 499999999999l);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getInt method, of class PseudoRandomGenerator.
     */
    @Test
    public void testGetInt() {
        //arrange
        PseudoRandomGenerator pseudoRandomGenerator = new PseudoRandomGenerator(987, new LocalDateTime(1991, 5, 24, 6, 28, 53, 862));

        int expectedValue = 198994;
        int returnedValue;
        //act
        for (int i = 1; i <= 4; i++) {
            pseudoRandomGenerator.getInt(0, 499999);
        }
        returnedValue = pseudoRandomGenerator.getInt(0, 499999);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getBoolean method, of class PseudoRandomGenerator.
     */
    @Test
    public void testGetBoolean() {
        //arrange
        PseudoRandomGenerator pseudoRandomGenerator = new PseudoRandomGenerator(987, new LocalDateTime(1991, 5, 24, 6, 28, 53, 862));
        JsonArray jsonArray = new JsonArray();
        String expectedString = "[true,false,false,true,false,false,false,false,true,true,false,true,false,false,true,true,true,true,true,false,true,true,false,true,true,false,false,true,true,false,false,false,false,false,false,true,false,true,true,true,false,false,false,true,false,true,true,false,false,false]";
        String returnedString;
        //act
        for (int i = 1; i <= 50; i++) {
            jsonArray.addBoolean(pseudoRandomGenerator.getBoolean());
        }
        returnedString = jsonArray.toMinimalString();
        //assert
        assertEquals(expectedString, returnedString);
    }

    @Test
    public void testTheSame100thOrderHasTheSame() {
        //arrange
        int magicNumber = PseudoRandomGenerator.getInstance().getInt(0, 1000000);
        DateTime dateTime = UniversalDateTime.getRandomUniversalDateTime();
        PseudoRandomGenerator pseudoRandomGenerator;
        pseudoRandomGenerator = new PseudoRandomGenerator(magicNumber, dateTime);
        for (int i = 1; i < 100; i++) {
            pseudoRandomGenerator.getInt(0, 1000000);
        }
        int expectedValue = pseudoRandomGenerator.getInt(0, 1000000);
        int returnedValue;

        pseudoRandomGenerator = new PseudoRandomGenerator(magicNumber, dateTime);
        for (int i = 1; i < 100; i++) {
            if (PseudoRandomGenerator.getInstance().getBoolean()) {
                pseudoRandomGenerator.getBoolean();
            } else if (PseudoRandomGenerator.getInstance().getBoolean()) {
                pseudoRandomGenerator.getInt(0, PseudoRandomGenerator.getInstance().getInt(0, 1000000));
            } else {
                pseudoRandomGenerator.getLong(0, PseudoRandomGenerator.getInstance().getInt(0, 1000000));
            }
        }
        //act
        returnedValue = pseudoRandomGenerator.getInt(0, 1000000);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

}
