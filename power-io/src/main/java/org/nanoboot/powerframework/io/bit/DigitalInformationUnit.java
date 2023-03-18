
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

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public enum DigitalInformationUnit {

    /**
     *
     */
    BIT(null, 1),

    /**
     *
     */
    BYTE(BIT, 8),

    /**
     *
     */
    KILOBYTE(BYTE),

    /**
     *
     */
    MEGABYTE(KILOBYTE),

    /**
     *
     */
    GIGABYTE(MEGABYTE),

    /**
     *
     */
    TERABYTE(GIGABYTE),

    /**
     *
     */
    PETABYTE(TERABYTE),

    /**
     *
     */
    EXABYTE(PETABYTE);
    private static final int CONSTANT1024 = 1024;
    private static final int BYTEHASBYTES = 8;
    private final long bits;
    private final DigitalInformationUnit subordinateUnit;
    //TODO
    //private final DigitalInformationUnit superiorUnit;

    DigitalInformationUnit(DigitalInformationUnit subordinateUnit,
            int bits) {
        this.subordinateUnit = subordinateUnit;
        this.bits = bits;
    }

    DigitalInformationUnit(DigitalInformationUnit subordinateUnit) {
        this.subordinateUnit = subordinateUnit;
        this.bits = subordinateUnit.getBits() * CONSTANT1024;
    }

    /**
     *
     * @return count of bits of the given unit
     */
    public long getBits() {
        return bits;
    }

    /**
     *
     * @return count of bytes of the given unit
     */
    public long getBytes() {
        return bits / BYTEHASBYTES;
    }

    /**
     *
     * @return subordinate unit of this unit. Example KiloByte has subordinate unit Byte.
     */
    public DigitalInformationUnit getSubordinateUnit() {
        return subordinateUnit;
    }

    /**
     *
     * @param value count of input unit
     * @param inputUnit input unit
     * @param outputUnit output unit
     *
     * @return count of output unit
     */
    public static long convert(long value,
            DigitalInformationUnit inputUnit,
            DigitalInformationUnit outputUnit) {
        return 0;
        //TODO
    }
}
