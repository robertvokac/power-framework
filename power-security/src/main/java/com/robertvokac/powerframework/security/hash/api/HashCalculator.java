
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

package com.robertvokac.powerframework.security.hash.api;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public interface HashCalculator {
    String UTF_8 = "UTF-8";

    String hash(byte[] dataToHash);

    default String hash(String dataToHash) {
        byte[] byteArray = new byte[0];
        try {
            byteArray = dataToHash.getBytes(UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new SecurityException(e.getMessage());
        }
        return hash(byteArray);
    }

    String getName();
    int getLength();

    default String convertHexStringToDecString(String hex) {
        return new BigInteger(hex, 16).toString();
    }

    default String convertDecStringToHexString(String dec) {
        String str = convertDecStringToBigInteger(dec).toString(16);
        ;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (getLength() - str.length()); i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }

    default BigInteger convertDecStringToBigInteger(String dec) {
        return new BigInteger(dec, 10);
    }

    default String convertBigIntegerToDecString(BigInteger bi) {
        return bi.toString(10);
    }

    /**
     * @param hex1
     * @param hex2
     * @return if 0, then hex1=hex2. if -1, then hex1 &lt; hex2. if 1, then hex1 &gt; hex2.
     */
    default int compareHexNumbers(String hex1, String hex2) {
        int result = hex1.compareTo(hex2);
        if (result == 0) {
            return 0;
        }
        if (result < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("convertHexToDec(F)=" + new BigInteger("F", 16).toString());
        System.out.println("convertDecToHex(15)=" + new BigInteger("15", 10).toString(16));
        HashCalculator hc = new HashCalculator() {
            @Override
            public String hash(byte[] dataToHash) {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getLength() {
                return 0;
            }
        };
        System.out.println("compareHexNumbers(c,c)=" + hc.compareHexNumbers("c", "c"));
        System.out.println("compareHexNumbers(c,e)=" + hc.compareHexNumbers("c", "e"));
        System.out.println("compareHexNumbers(e,c)=" + hc.compareHexNumbers("e", "c"));
    }
}
