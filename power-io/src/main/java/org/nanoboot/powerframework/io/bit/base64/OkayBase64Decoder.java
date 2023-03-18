
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

package org.nanoboot.powerframework.io.bit.base64;

import java.util.Arrays;
import org.nanoboot.powerframework.collections.PowerQueue;
import org.nanoboot.powerframework.core.PowerException;
import org.nanoboot.powerframework.io.bit.Byte;

/**
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

class OkayBase64Decoder {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(OkayBase64Decoder.class);

    /**
     *
     * @param encodedDataIn
     *
     * @return
     */
    public static byte[] decode(String encodedDataIn) {
        LOG.traceStartOfMethod(null, "decode", "encodedDataIn", encodedDataIn);
        if(encodedDataIn.length() % 4 != 0) {
            throw new PowerException("The string length is " + encodedDataIn.length() + ". This length is not divisible four and it must be.");
        }
        String encodedData = encodedDataIn;
        Base64Padding base64Padding = Base64Padding.getBase64Padding(encodedData);
        int byteArrayLength = getByteArrayLength(encodedDataIn, base64Padding);
        System.out.println("byteArrayLength=" + byteArrayLength);
        byte[] byteArray = new byte[byteArrayLength];

        PowerQueue<Boolean> bitQueue = new PowerQueue<>();
        processChars(byteArray, encodedData, bitQueue);

        return byteArray;
    }

    private static int getByteArrayLength(String encodedDataIn,
            Base64Padding base64Padding) {
        LOG.traceStartOfMethod(null, "getByteArrayLength", "encodedDataIn", encodedDataIn, "base64Padding", base64Padding);
        int stringLength = encodedDataIn.length();
        int byteArrayLength = stringLength / 4 * 3;
        switch (base64Padding) {
            case NO: {
                return byteArrayLength;
            }
            case ONEBYTE: {
                return byteArrayLength - 2;
            }
            case TWOBYTE: {
                return byteArrayLength - 1;
            }
            default: {
                throw new PowerException("Unknown Base64Padding " + base64Padding.name() + ".");
            }
        }
    }

    private static void processChars(byte[] byteArray,
            String encodedDataIn,
            PowerQueue<Boolean> bitQueue) {
        LOG.traceStartOfMethod(null, "processChars", "encodedDataIn", encodedDataIn, "bitQueue", bitQueue);
        int byteArrayIndex = 0;
        for (int i = 0; i < encodedDataIn.length(); i++) {
            if(i % 100000 == 0) {
                System.out.println(i + "/" + encodedDataIn.length());
            }
            char charValue = encodedDataIn.charAt(i);
            processChar(charValue, bitQueue);
            byteArrayIndex = feedQueue(byteArray, byteArrayIndex, bitQueue);
        }
    }

    private static void processChar(char charValue,
            PowerQueue<Boolean> bitQueue) {
        LOG.traceStartOfMethod(null, "processChar", "charValue", charValue, "bitQueue", bitQueue.toString());
//        System.out.println("processChar " + charValue);

//        System.out.println(charValue + " transformed to " + sixBits.toString());
//        System.out.println("sixBits for "+charValue+":" + sixBits.toString());
        boolean[] booleanArray = Base64Convertor.convertCharToBooleanArray(charValue);
        for (int j = 2; j < 8; j++) {
            boolean element = booleanArray[j];
//            System.out.println("to queue added: " + element);
            bitQueue.add(element);
        }
    }

    private static int feedQueue(byte[] byteArray,
            int startByteArrayIndex,
            PowerQueue<Boolean> bitQueue) {
        LOG.traceStartOfMethod(null, "feedQueue", "byteArray", Arrays.asList(byteArray).toString(), "bitQueue", bitQueue.toString());
        int index = startByteArrayIndex;
        while (index < byteArray.length && bitQueue.size() >= 8) {

            boolean[] booleanArray = new boolean[]{bitQueue.poll(), bitQueue.poll(), bitQueue.poll(), bitQueue.poll(), bitQueue.poll(), bitQueue.poll(), bitQueue.poll(), bitQueue.poll()};
//            System.out.println("feeding with "+(byteInstance.getByteValue()+128));
            byteArray[index] = (byte) (Byte.booleanArrayToByte(booleanArray) + 128);
            index++;

        }
        startByteArrayIndex = index;
        return startByteArrayIndex;
    }
}
