
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

package com.robertvokac.powerframework.json;

import java.util.*;

import static org.junit.Assert.assertTrue;

import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class CommasFinderTest {

    public CommasFinderTest() {
    }

    /**
     * Test of getListOfIndexesOfCommas method, of class CommasFinder.
     */
    @Test
    public void testGetListOfIndexesOfCommas() {
        String stringToSplit = "\"date of death\":null,\"father\":{\"name\":\"Peter\",\"surname\":\"Black\"},\"mother\":{\"name\":\"Sue\",\"surname\":\"Black\"},\"property\":[null,{\"type\":\"computer\",\"cpu\":\"corei7\",\"ram\":\"16GB\"},[\"8GB memory card\",\"16GB memory card\",\"32GB memory card\",\"128GB memory card\"],true,\"car\",\"y\",42,9987987998798,4.56,1.646659262492],\"is rich\":true,\"name\":\"John\",\"surname\":\"Black\",\"date of birth\":\"1975-09-23\",\"favorit letter\":\"W\",\"year of birth\":1975,\"favorit very long number\":8798799845647987,\"height\":173.5466,\"height- high precision\":173.54666549879545";
        //arrange
        String expectedString = "20,64,106,302,317,331,349,378,399,420,464,482,";
        String returnedString;
        StringBuilder stringBuilder = new StringBuilder();
        //act
        ArrayList<Integer> listOfCommas = CommasFinder.getListOfIndexesOfCommas(stringToSplit);
        for (int element : listOfCommas) {
            stringBuilder.append(element);
            stringBuilder.append(JsonConstants.COMMA);
        }

        returnedString = stringBuilder.toString();
        //System.out.println("a"+expectedString+"b"+"\n"+"c"+returnedString+"d");
        //assert
        assertTrue(expectedString.equals(returnedString));
    }

}
