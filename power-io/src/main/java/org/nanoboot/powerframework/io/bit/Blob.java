
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

import org.nanoboot.powerframework.core.PowerException;
import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Blob {

    private final byte[] byteArray;
//TODO will hold byte[], but will have methods to set, update, flip, or read every bit of this blob, for example there will be a request to set the fourt bit of the twentieth byte to true (1)

    /**
     *
     * @param byteArrayIn
     */
    public Blob(byte[] byteArrayIn) {
        this.byteArray = byteArrayIn;
    }

    public Blob(int countOfBytes) {
        this.byteArray = new byte[countOfBytes];
        fillAllByZeroes();
    }

    /**
     *
     * @param string The required format are only zeroes and ones. Example: "01011101110100011001111"
     */
    public Blob(String string) {
        this(string.length() / 8);
        int bitPosition = 0;
        for (char element : string.toCharArray()) {
            if(!(element == '1' || element == '0')) {
                throw new PowerException("The string must contain only characters 0 or 1. " + "The character " + element + " does not follow this rule.");
            }
            this.setBits(bitPosition++, new boolean[]{element == '1'});

        }
    }

    public Blob(Blob... blobs) {
        int countOfBytes = 0;
        for (Blob blob : blobs) {
            countOfBytes = +blob.getCountOfBytes();
        }
        this.byteArray = new byte[countOfBytes];
        int index = 0;
        for (Blob blob : blobs) {
            for (int j = 0; j < blob.getCountOfBytes(); j++) {
                this.byteArray[index++] = Byte.booleanArrayToByte(blob.getByte(j));
            }
        }

        fillAllByZeroes();
    }

    public int getCountOfBytes() {
        return this.byteArray.length;
    }

    public int getCountOfBits() {
        return this.byteArray.length * 8;
    }

    public void fillAllByZeroes() {
        fillWith(false, 0, this.byteArray.length - 1);
    }

    public void fillAllByOnes() {
        fillWith(true, 0, this.byteArray.length - 1);
    }

    public void fillWith(boolean value, int byteFrom, int byteTo) {
        byte booleanArray = Byte.booleanArrayToByte(value, value, value, value, value, value, value, value);
        for (int i = byteFrom; i <= byteTo; i++) {
            this.byteArray[i] = booleanArray;
        }
    }

    public void fillRandom() {
        fillRandom(0, this.byteArray.length - 1);

    }

    public void fillRandom(int byteFrom, int byteTo) {
        boolean[] booleanArray;
        W5RandomGenerator pseudoW5RandomGenerator = W5RandomGenerator.getStaticInstance();
        for (int i = byteFrom; i <= byteTo; i++) {

            booleanArray = new boolean[8];
            for (int j = 0; j < 8; j++) {
                booleanArray[j] = pseudoW5RandomGenerator.nextBoolean();
            }

            byte byteValue = Byte.booleanArrayToByte(booleanArray);;
            this.byteArray[i] = byteValue;
        }

    }

    public void flopAll() {
        flop(0, this.byteArray.length - 1);

    }

    public void flop(int byteFrom, int byteTo) {
        for (int bytePosition = byteFrom; bytePosition <= byteTo; bytePosition++) {
            byte byteValue = this.byteArray[bytePosition];
            System.out.println("byteValue=" + byteValue);
            boolean[] booleanArray = Byte.byteValueToBooleanArray(byteValue);
            booleanArray = flopBooleanArray(booleanArray);
            System.out.println("!byteValue=" + byteValue);
            byteValue = Byte.booleanArrayToByte(booleanArray);
            this.byteArray[bytePosition] = byteValue;
        }

    }

    public static boolean[] flopBooleanArray(boolean[] booleanArray) {
        for (int i = 0; i < booleanArray.length; i++) {
            booleanArray[i] = !booleanArray[i];
        }
        return booleanArray;
    }

    public boolean[] getByte(int bytePosition) {
        return Byte.byteValueToBooleanArray(this.byteArray[bytePosition]);
    }

    public void setByte(int bytePosition, boolean[] booleanArray) {
        this.byteArray[bytePosition] = Byte.booleanArrayToByte(booleanArray);
    }

    public boolean[] getBits(int startBit, int endBit) {
        boolean[] booleanArray = new boolean[endBit - startBit + 1];
        int booleanArrayIndex = 0;
        int startBitDividedByEight = ((int) (startBit / 8));
        int startByte = startBitDividedByEight - 1;
        if(startByte < 0) {
            startByte = 0;
        }
        for (int bytePosition = startByte; booleanArrayIndex < (endBit - startBit + 1); bytePosition++) {
            int bitPosition = bytePosition * 8;
            byte byteValue = this.byteArray[bytePosition];
            boolean[] booleanArrayOfByte = Byte.byteValueToBooleanArray(byteValue);
            for (int j = 0; j < 8; j++) {
                boolean booleanValue = booleanArrayOfByte[j];

                if(bitPosition >= startBit && bitPosition <= endBit) {
                    booleanArray[booleanArrayIndex++] = booleanValue;
                }
                bitPosition++;
            }
        }
        return booleanArray;
    }

    public void setBits(int startBit, boolean[] bitsToSetArray) {
        int endBit = startBit + bitsToSetArray.length - 1;
        int booleanArrayIndex = 0;
        int startBitDividedByEight = ((int) (startBit / 8));
        int startByte = startBitDividedByEight - 1;
        if(startByte < 0) {
            startByte = 0;
        }
        for (int bytePosition = startByte; bytePosition < this.byteArray.length && booleanArrayIndex < bitsToSetArray.length; bytePosition++) {
            int bitPosition = bytePosition * 8;
            byte byteValue = this.byteArray[bytePosition];
            boolean[] booleanArrayOfByte = Byte.byteValueToBooleanArray(byteValue);
            for (int j = 0; j < 8; j++) {

                if(bitPosition >= startBit && bitPosition <= endBit) {
                    boolean booleanValue = bitsToSetArray[booleanArrayIndex++];
//                    System.out.println(booleanValue);
                    booleanArrayOfByte[j] = booleanValue;
                }
//                System.out.println(bitPosition);
                bitPosition++;
                this.byteArray[bytePosition] = Byte.booleanArrayToByte(booleanArrayOfByte);
            }
        }
    }

    public boolean getBit(int bitPosition) {
        return getBits(bitPosition, bitPosition)[0];
    }

    public void setBit(int bitPosition, boolean value) {
        setBits(bitPosition, new boolean[]{value});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte byteValue : this.byteArray) {
            for (boolean booleanValue : Byte.byteValueToBooleanArray(byteValue)) {
                stringBuilder.append(booleanValue ? "1" : "0");
            }
        }
        return stringBuilder.toString();
    }
}
