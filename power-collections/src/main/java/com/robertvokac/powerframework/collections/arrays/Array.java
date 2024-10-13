
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

package com.robertvokac.powerframework.collections.arrays;

//ObjectArray<ObjectArray<ObjectArray<ObjectArray<Human>>>> array3=new ObjectArray<ObjectArray<ObjectArray<ObjectArray<Human>>>>(

import java.util.*;

/**
 * @param <C> if the ArrayType is not Object, this parameter is ignored. In
 *            this case use Object as parameter.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class Array<C> implements Iterable<C> {

    private static final String SPACEDOT = " .";
    private static final String UNKNOWN_ARRAY_TYPE = "Unknown array type ";
    private static final String THE_ARRAY_DIMENSION_COUNT_IS = "The array dimension count is ";
    private static final String BUT_SHOULD_1_2_3_OR_4 = ", but should 1, 2, 3 or 4";
    private static final String DOT = ".";

    private static final int CONSTANT_ONE = 1;

    private ArrayType arrayType;

    private int dimensionCount;
    private int[] arrayLengths;

    private boolean[] booleanArray1;
    private byte[] byteArray1;
    private short[] shortArray1;
    private int[] intArray1;
    private long[] longArray1;
    private float[] floatArray1;
    private double[] doubleArray1;
    private C[] objectArray1;

    private boolean[][] booleanArray2;
    private byte[][] byteArray2;
    private short[][] shortArray2;
    private int[][] intArray2;
    private long[][] longArray2;
    private float[][] floatArray2;
    private double[][] doubleArray2;
    private C[][] objectArray2;

    private boolean[][][] booleanArray3;
    private byte[][][] byteArray3;
    private short[][][] shortArray3;
    private int[][][] intArray3;
    private long[][][] longArray3;
    private float[][][] floatArray3;
    private double[][][] doubleArray3;
    private C[][][] objectArray3;

    private boolean[][][][] booleanArray4;
    private byte[][][][] byteArray4;
    private short[][][][] shortArray4;
    private int[][][][] intArray4;
    private long[][][][] longArray4;
    private float[][][][] floatArray4;
    private double[][][][] doubleArray4;
    private C[][][][] objectArray4;

    /**
     * Constructor
     * <p>
     * Creates array.
     *
     * @param arrayTypeIn    the type of this array
     * @param arrayLengthsIn 1 to 4, length of the arrays
     */
    public Array(ArrayType arrayTypeIn, int... arrayLengthsIn) {
        this.arrayLengths = arrayLengthsIn;
        this.dimensionCount = arrayLengths.length;

        int array1Length = dimensionCount >= 1 ? this.arrayLengths[0] : 0;
        int array2Length = dimensionCount >= 2 ? this.arrayLengths[1] : 0;
        int array3Length = dimensionCount >= 3 ? this.arrayLengths[2] : 0;
        int array4Length = dimensionCount == 4 ? this.arrayLengths[3] : 0;

        throwRuntimeExceptionIfDimensionOutOfRange();
        this.arrayType = arrayTypeIn;
        initArray(array1Length, array2Length, array3Length, array4Length);
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(boolean... values) {
        initDynamicInitialization(values.length, ArrayType.BOOLEAN);
        this.booleanArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(byte... values) {
        initDynamicInitialization(values.length, ArrayType.BYTE);
        this.byteArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(short... values) {
        initDynamicInitialization(values.length, ArrayType.SHORT);
        this.shortArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(int... values) {
        initDynamicInitialization(values.length, ArrayType.INT);
        this.intArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(long... values) {
        initDynamicInitialization(values.length, ArrayType.LONG);
        this.longArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(float... values) {
        initDynamicInitialization(values.length, ArrayType.FLOAT);
        this.floatArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(double... values) {
        initDynamicInitialization(values.length, ArrayType.DOUBLE);
        this.doubleArray1 = values;
    }

    /**
     * Constructor
     * Creates array dynamically based on the parameters and their count.
     *
     * @param values values of array
     */
    public Array(C... values) {
        initDynamicInitialization(values.length, ArrayType.OBJECT);
        this.objectArray1 = values;
    }

    private void initArray(int array1LengthIn, int array2LengthIn, int array3LengthIn, int array4LengthIn) throws ArrayException {
        switch (arrayType) {
            case BOOLEAN:
                initBooleanArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case BYTE:
                initByteArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case SHORT:
                initShortArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case INT:
                initIntArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case LONG:
                initLongArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case FLOAT:
                initFloatArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case DOUBLE:
                initDoubleArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            case OBJECT:
                initObjectArray(array1LengthIn, array2LengthIn, array3LengthIn, array4LengthIn);
                break;
            default:
                throw new ArrayException(UNKNOWN_ARRAY_TYPE + arrayType
                        + SPACEDOT);
        }
    }

    private void initBooleanArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                booleanArray1 = new boolean[array1Length];
                return;
            case 2:
                booleanArray2 = new boolean[array1Length][array2Length];
                return;
            case 3:
                booleanArray3 = new boolean[array1Length][array2Length][array3Length];
                return;
            case 4:
                booleanArray4 = new boolean[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initByteArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                byteArray1 = new byte[array1Length];
                return;
            case 2:
                byteArray2 = new byte[array1Length][array2Length];
                return;
            case 3:
                byteArray3 = new byte[array1Length][array2Length][array3Length];
                return;
            case 4:
                byteArray4 = new byte[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initShortArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                shortArray1 = new short[array1Length];
                return;
            case 2:
                shortArray2 = new short[array1Length][array2Length];
                return;
            case 3:
                shortArray3 = new short[array1Length][array2Length][array3Length];
                return;
            case 4:
                shortArray4 = new short[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initIntArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                intArray1 = new int[array1Length];
                return;
            case 2:
                intArray2 = new int[array1Length][array2Length];
                return;
            case 3:
                intArray3 = new int[array1Length][array2Length][array3Length];
                return;
            case 4:
                intArray4 = new int[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();

        }
    }

    private void initLongArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                longArray1 = new long[array1Length];
                return;
            case 2:
                longArray2 = new long[array1Length][array2Length];
                return;
            case 3:
                longArray3 = new long[array1Length][array2Length][array3Length];
                return;
            case 4:
                longArray4 = new long[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initFloatArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                floatArray1 = new float[array1Length];
                return;
            case 2:
                floatArray2 = new float[array1Length][array2Length];
                return;
            case 3:
                floatArray3 = new float[array1Length][array2Length][array3Length];
                return;
            case 4:
                floatArray4 = new float[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initDoubleArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                doubleArray1 = new double[array1Length];
                return;
            case 2:
                doubleArray2 = new double[array1Length][array2Length];
                return;
            case 3:
                doubleArray3 = new double[array1Length][array2Length][array3Length];
                return;
            case 4:
                doubleArray4 = new double[array1Length][array2Length][array3Length][array4Length];
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initObjectArray(int array1Length, int array2Length, int array3Length, int array4Length) {
        switch (dimensionCount) {
            case 1:
                objectArray1 = (C[]) new Object[array1Length];
                return;
            case 2:
                objectArray2 = (C[][]) new Object[array1Length][array2Length];
                return;
            case 3:
                objectArray3 = (C[][][]) new Object[array1Length][array2Length][array3Length];
                return;
            case 4:
                objectArray4 = (C[][][][]) new Object[array1Length][array2Length][array3Length][array4Length];
                return;

            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initDynamicInitialization(int arrayLength, ArrayType arrayTypeIn) {
        this.arrayLengths = new int[]{arrayLength};
        this.dimensionCount = 1;
        this.arrayType = arrayTypeIn;
    }

    private void throwRuntimeExceptionIfDimensionOutOfRange() {
        if (dimensionCount < 0 || dimensionCount > 4) {
            throw new ArrayException(THE_ARRAY_DIMENSION_COUNT_IS
                    + dimensionCount + BUT_SHOULD_1_2_3_OR_4 + DOT);
        }
    }

    /**
     * @return
     */
    public ArrayType getArrayType() {
        return arrayType;
    }

    public int getDimensions() {
        return dimensionCount;
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public C getObject(int... index) {
        initSettingOrGetting(index, ArrayType.OBJECT);

        switch (index.length) {
            case 1:
                return this.objectArray1[index[0]];
            case 2:
                return this.objectArray2[index[0]][index[1]];
            case 3:
                return this.objectArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.objectArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return null;
        }
    }

    /**
     * Setter for object.
     *
     * @param object object to set
     * @param index  index of the array
     */
    public void setObject(C object, int... index) {
        initSettingOrGetting(index, ArrayType.OBJECT);
        switch (index.length) {
            case 1:
                this.objectArray1[index[0]] = object;
                return;
            case 2:
                this.objectArray2[index[0]][index[1]] = object;
                return;
            case 3:
                this.objectArray3[index[0]][index[1]][index[2]] = object;
                return;
            case 4:
                this.objectArray4[index[0]][index[1]][index[2]][index[3]] = object;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public boolean getBoolean(int... index) {
        initSettingOrGetting(index, ArrayType.OBJECT);
        switch (index.length) {
            case 1:
                return this.booleanArray1[index[0]];
            case 2:
                return this.booleanArray2[index[0]][index[1]];
            case 3:
                return this.booleanArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.booleanArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return false;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setBoolean(boolean value, int... index) {
        initSettingOrGetting(index, ArrayType.BOOLEAN);
        switch (index.length) {
            case 1:
                this.booleanArray1[index[0]] = value;
                return;
            case 2:
                this.booleanArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.booleanArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.booleanArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public byte getByte(int... index) {
        initSettingOrGetting(index, ArrayType.BOOLEAN);
        switch (index.length) {
            case 1:
                return this.byteArray1[index[0]];
            case 2:
                return this.byteArray2[index[0]][index[1]];
            case 3:
                return this.byteArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.byteArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return 0;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setByte(byte value, int... index) {
        initSettingOrGetting(index, ArrayType.BYTE);
        switch (index.length) {
            case 1:
                this.byteArray1[index[0]] = value;
                return;
            case 2:
                this.byteArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.byteArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.byteArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public short getShort(int... index) {
        initSettingOrGetting(index, ArrayType.SHORT);
        switch (index.length) {
            case 1:
                return this.shortArray1[index[0]];
            case 2:
                return this.shortArray2[index[0]][index[1]];
            case 3:
                return this.shortArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.shortArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return 0;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setShort(short value, int... index) {
        initSettingOrGetting(index, ArrayType.SHORT);
        switch (index.length) {
            case 1:
                this.shortArray1[index[0]] = value;
                return;
            case 2:
                this.shortArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.shortArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.shortArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public int getInt(int... index) {
        initSettingOrGetting(index, ArrayType.INT);
        switch (index.length) {
            case 1:
                return this.intArray1[index[0]];
            case 2:
                return this.intArray2[index[0]][index[1]];
            case 3:
                return this.intArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.intArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return 0;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setInt(int value, int... index) {
        initSettingOrGetting(index, ArrayType.INT);
        switch (index.length) {
            case 1:
                this.intArray1[index[0]] = value;
                return;
            case 2:
                this.intArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.intArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.intArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public long getLong(int... index) {
        initSettingOrGetting(index, ArrayType.LONG);
        switch (index.length) {
            case 1:
                return this.longArray1[index[0]];
            case 2:
                return this.longArray2[index[0]][index[1]];
            case 3:
                return this.longArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.longArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return 0;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setLong(long value, int... index) {
        initSettingOrGetting(index, ArrayType.LONG);
        switch (index.length) {
            case 1:
                this.longArray1[index[0]] = value;
                return;
            case 2:
                this.longArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.longArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.longArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public float getFloat(int... index) {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT);
        initSettingOrGetting(index, ArrayType.FLOAT);
        switch (index.length) {
            case 1:
                return this.floatArray1[index[0]];
            case 2:
                return this.floatArray2[index[0]][index[1]];
            case 3:
                return this.floatArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.floatArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return 0;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setFloat(float value, int... index) {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT);
        initSettingOrGetting(index, ArrayType.FLOAT);
        switch (index.length) {
            case 1:
                this.floatArray1[index[0]] = value;
                return;
            case 2:
                this.floatArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.floatArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.floatArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    /**
     * Getter for array value.
     *
     * @param index index of the array
     * @return array value
     */
    public double getDouble(int... index) {
        initSettingOrGetting(index, ArrayType.DOUBLE);
        switch (index.length) {
            case 1:
                return this.doubleArray1[index[0]];
            case 2:
                return this.doubleArray2[index[0]][index[1]];
            case 3:
                return this.doubleArray3[index[0]][index[1]][index[2]];
            case 4:
                return this.doubleArray4[index[0]][index[1]][index[2]][index[3]];
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
                //It should never come here.
                return 0;
        }
    }

    /**
     * Setter for value.
     *
     * @param value value to set
     * @param index index of the array
     */
    public void setDouble(double value, int... index) {
        initSettingOrGetting(index, ArrayType.DOUBLE);
        switch (index.length) {
            case 1:
                this.doubleArray1[index[0]] = value;
                return;
            case 2:
                this.doubleArray2[index[0]][index[1]] = value;
                return;
            case 3:
                this.doubleArray3[index[0]][index[1]][index[2]] = value;
                return;
            case 4:
                this.doubleArray4[index[0]][index[1]][index[2]][index[3]] = value;
                return;
            default:
                throwRuntimeExceptionIfDimensionOutOfRange();
        }
    }

    private void initSettingOrGetting(int[] indexIn, ArrayType arrayTypeIn) {
        throwExceptionIfOperationIsUnsupported(arrayTypeIn);
        throwExceptionIfIndexOutOfRange(indexIn);
        convertOkayToJavaIndexArray(indexIn);
    }

    private void throwExceptionIfOperationIsUnsupported(ArrayType arrayTypeIn) {
        if (arrayTypeIn != this.arrayType) {
            throw new ArrayException("This operation is not supported for the array type " + this.arrayType + ".");
        }
    }

    /**
     * @param arrayTypeIn
     * @param dimensionCountIn
     */
    private void throwExceptionIfOperationIsUnsupported(ArrayType arrayTypeIn, int dimensionCountIn) {
        if (arrayTypeIn != this.arrayType) {
            throw new ArrayException("This operation is not supported for the array type " + this.arrayType + ".");
        }
        if (dimensionCountIn != this.dimensionCount) {
            throw new ArrayException("This operation is not supported for the dimension count " + dimensionCount + ".");
        }
    }

    private void throwExceptionIfIndexOutOfRange(int... index) {
        int startIndex = CONSTANT_ONE;
        int endIndex;
        if (index.length != this.getDimensions()) {
            throw new ArrayException("Wrong count of indexes. It should be " + this.getDimensions() + ", but is " + index.length + ".");
        }
        for (int i = 0; i < this.dimensionCount; i++) {
            endIndex = this.arrayLengths[i];
            if ((index[i] > endIndex) || (index[i] < startIndex)) {
                throw new ArrayException("Index " + index[i] + " is out of range <" + startIndex + ";" + endIndex + "> for dimension " + (i + 1));
            }
        }
    }

    private void convertOkayToJavaIndexArray(int... index) {
        for (int i = 0; i < index.length; i++) {
            index[i] = convertOkayToJavaIndex(index[i]);
        }
    }

    private int convertOkayToJavaIndex(int index) {
        return (index - CONSTANT_ONE);
    }

    /**
     * @return
     */
    public int getLength() {
        return this.arrayLengths[0];
    }

    /**
     * Getter for the length of the array based on the dimension number.
     *
     * @param dimension 1 or 2 or 3 or 4
     * @return array length of the dimension
     */
    public int getLength(int dimension) {
        return this.arrayLengths[dimension - 1];
    }

    public boolean[] getBooleanArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN, 1);
        return booleanArray1;
    }

    public void setBooleanArray1(boolean[] booleanArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN);
        this.booleanArray1 = booleanArray1;
    }

    public byte[] getByteArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE, 1);
        return byteArray1;
    }

    public void setByteArray1(byte[] byteArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE);
        this.byteArray1 = byteArray1;
    }

    public short[] getShortArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT, 1);
        return shortArray1;
    }

    public void setShortArray1(short[] shortArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT);
        this.shortArray1 = shortArray1;
    }

    public int[] getIntArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT, 1);
        return intArray1;
    }

    public void setIntArray1(int[] intArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT);
        this.intArray1 = intArray1;
    }

    public long[] getLongArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG, 1);
        return longArray1;
    }

    public void setLongArray1(long[] longArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG);
        this.longArray1 = longArray1;
    }

    public float[] getFloatArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT, 1);
        return floatArray1;
    }

    public void setFloatArray1(float[] floatArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT);
        this.floatArray1 = floatArray1;
    }

    public double[] getDoubleArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE, 1);
        return doubleArray1;
    }

    public void setDoubleArray1(double[] doubleArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE);
        this.doubleArray1 = doubleArray1;
    }

    public C[] getObjectArray1() {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT, 1);
        return objectArray1;
    }

    public void setObjectArray1(C[] objectArray1) {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT);
        this.objectArray1 = objectArray1;
    }

    public boolean[][] getBooleanArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN, 2);
        return booleanArray2;
    }

    public void setBooleanArray2(boolean[][] booleanArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN);
        this.booleanArray2 = booleanArray2;
    }

    public byte[][] getByteArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE, 2);
        return byteArray2;
    }

    public void setByteArray2(byte[][] byteArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE);
        this.byteArray2 = byteArray2;
    }

    public short[][] getShortArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT, 2);
        return shortArray2;
    }

    public void setShortArray2(short[][] shortArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT);
        this.shortArray2 = shortArray2;
    }

    public int[][] getIntArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT, 2);
        return intArray2;
    }

    public void setIntArray2(int[][] intArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT);
        this.intArray2 = intArray2;
    }

    public long[][] getLongArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG, 2);
        return longArray2;
    }

    public void setLongArray2(long[][] longArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG);
        this.longArray2 = longArray2;
    }

    public float[][] getFloatArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT, 2);
        return floatArray2;
    }

    public void setFloatArray2(float[][] floatArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT);
        this.floatArray2 = floatArray2;
    }

    public double[][] getDoubleArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE, 2);
        return doubleArray2;
    }

    public void setDoubleArray2(double[][] doubleArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT);
        this.doubleArray2 = doubleArray2;
    }

    public C[][] getObjectArray2() {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT, 2);
        return objectArray2;
    }

    public void setObjectArray2(C[][] objectArray2) {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT);
        this.objectArray2 = objectArray2;
    }

    public boolean[][][] getBooleanArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN, 3);
        return booleanArray3;
    }

    public void setBooleanArray3(boolean[][][] booleanArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN);
        this.booleanArray3 = booleanArray3;
    }

    public byte[][][] getByteArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE, 3);
        return byteArray3;
    }

    public void setByteArray3(byte[][][] byteArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE);
        this.byteArray3 = byteArray3;
    }

    public short[][][] getShortArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT, 3);
        return shortArray3;
    }

    public void setShortArray3(short[][][] shortArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT);
        this.shortArray3 = shortArray3;
    }

    public int[][][] getIntArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT, 3);
        return intArray3;
    }

    public void setIntArray3(int[][][] intArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT);
        this.intArray3 = intArray3;
    }

    public long[][][] getLongArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG, 3);
        return longArray3;
    }

    public void setLongArray3(long[][][] longArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG);
        this.longArray3 = longArray3;
    }

    public float[][][] getFloatArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT, 3);
        return floatArray3;
    }

    public void setFloatArray3(float[][][] floatArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT);
        this.floatArray3 = floatArray3;
    }

    public double[][][] getDoubleArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE, 3);
        return doubleArray3;
    }

    public void setDoubleArray3(double[][][] doubleArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE);
        this.doubleArray3 = doubleArray3;
    }

    public C[][][] getObjectArray3() {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT, 4);
        return objectArray3;
    }

    public void setObjectArray3(C[][][] objectArray3) {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT);
        this.objectArray3 = objectArray3;
    }

    public boolean[][][][] getBooleanArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN, 4);
        return booleanArray4;
    }

    public void setBooleanArray4(boolean[][][][] booleanArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BOOLEAN);
        this.booleanArray4 = booleanArray4;
    }

    public byte[][][][] getByteArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE, 4);
        return byteArray4;
    }

    public void setByteArray4(byte[][][][] byteArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.BYTE);
        this.byteArray4 = byteArray4;
    }

    public short[][][][] getShortArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT, 4);
        return shortArray4;
    }

    public void setShortArray4(short[][][][] shortArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.SHORT);
        this.shortArray4 = shortArray4;
    }

    public int[][][][] getIntArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT, 4);
        return intArray4;
    }

    public void setIntArray4(int[][][][] intArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.INT);
        this.intArray4 = intArray4;
    }

    public long[][][][] getLongArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG, 4);
        return longArray4;
    }

    public void setLongArray4(long[][][][] longArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.LONG);
        this.longArray4 = longArray4;
    }

    public float[][][][] getFloatArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT, 4);
        return floatArray4;
    }

    public void setFloatArray4(float[][][][] floatArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.FLOAT);
        this.floatArray4 = floatArray4;
    }

    public double[][][][] getDoubleArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE, 4);
        return doubleArray4;
    }

    public void setDoubleArray4(double[][][][] doubleArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.DOUBLE);
        this.doubleArray4 = doubleArray4;
    }

    public C[][][][] getObjectArray4() {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT, 4);
        return objectArray4;
    }

    public void setObjectArray4(C[][][][] objectArray4) {
        throwExceptionIfOperationIsUnsupported(ArrayType.OBJECT);
        this.objectArray4 = objectArray4;
    }

    //    @Override
//    public Iterator<C> iterator(Array array) {
//
//        Iterator<C> iterator;
//        switch (this.arrayType) {
//            case BOOLEAN:
//                return new BooleanArrayIterator(array);
////            case BYTE:
////                return ByteArrayIterator();
//        }
//    }
//
//    private class BooleanArrayIterator implements Iterator<Boolean> {
//
//        private Array array;
//        int i = 0;
//
//        BooleanArrayIterator(Array arrayIn) {
//            this.array = arrayIn;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return (i + 1) <= array.getLength();
//        }
//
//        public Boolean next() {
//            if(!hasNext()) {
//                throw new ArrayException("There is no next element.");
//            }
//            return array.getBoolean(++i);
//        }
//    }
//
//
    @java.lang.Override
    public Iterator<C> iterator() {
        if (this.dimensionCount != 1) {
            throw new ArrayException("For iterating is only supported for one-dimensional arrays.");
        }
        return new BooleanArrayIterator(this);
    }

    class BooleanArrayIterator<C> implements Iterator<Boolean> {

        private Array array;
        private int index = 0;

        public BooleanArrayIterator(Array arrayIn) {
            this.array = arrayIn;
        }

        @Override
        public boolean hasNext() {
            return (index + 1) <= array.getLength();
        }

        @Override
        public Boolean next() {
            throwExceptionIfNoNextElement();
            return array.getBoolean(++index);
        }

        private void throwExceptionIfNoNextElement() throws ArrayException {
            if (!hasNext()) {
                throw new ArrayException("There is no next element.");
            }
        }
    }

}
