
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

package org.nanoboot.powerframework.core.version;
import org.nanoboot.powerframework.core.CoreException;
import lombok.Data;
/*
Examples:
    1.2.0.1 instead of 1.1.2-a1
    1.2.1.2 instead of 1.1.2-b2 (beta with some bug fixes)
    1.2.2.3 instead of 1.1.2-rc3 (release candidate)
    1.2.3.0 instead of 1.1.2-r (commercial distribution)
    1.2.3.5 instead of 1.1.2-r5 (commercial distribution with many bug fixes)
    1.2.3.5 instead of 1.1.2-SNAPSHOT
 */

/**
 * Version object representing a version of a software.
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@Data
public final class Version implements Comparable<Version> {
    /**
     * Dot "." separator.
     */
    public static final String DOT_SEPARATOR = ".";
    /**
     * Dash "-" separator.
     */
    public static final String DASH_SEPARATOR = "-";
    /**
     * Internal constant "Version array length must be".
     * It is used, if one of the possible exception happens.
     */
    private static final String WRONG_ARRAY_LENGTH_EXC_MSG =
            "Version array length must be ";
    /**
     * Constant "VERSION_TYPE_INDEX".
     */
    public static final int VERSION_TYPE_INDEX = 3;
    /**
     * major number.
     */
    private int majorNumber;
    /**
     * minor number.
     */
    private int minorNumber;
    /**
     * patch number.
     */
    private int patchNumber;
    /**
     * Version type.
     */
    private VersionType versionType;

    /**
     * special number.
     * If version type is STANDARD or SNAPSHOT, the special number must be 0.
     */
    private int specialNumber;
    /**
     * Constructor.
     */
    public Version() {
        //Default constructor to keep the no argument constructor.
        this.versionType = VersionType.STANDARD;
    }

    /**
     * Constructor.
     * Version type is STANDARD in this constructor.
     * Special number is 0 in this constructor.
     * @param majorNumberArg mayor number
     * @param minorNumberArg minor number
     * @param patchNumberArg patch number
     */
    public Version(final int majorNumberArg,
                   final int minorNumberArg,
                   final int patchNumberArg) {
        this(majorNumberArg, minorNumberArg,
                patchNumberArg, VersionType.STANDARD);
    }
    /**
     * Constructor.
     * Special number is 0 in this constructor.
     * @param majorNumberArg mayor number
     * @param minorNumberArg minor number
     * @param patchNumberArg patch number
     * @param versionTypeArg version type
     */
    public Version(final int majorNumberArg,
                   final int minorNumberArg,
                   final int patchNumberArg,
                   final VersionType versionTypeArg) {
        this.majorNumber = majorNumberArg;
        this.minorNumber = minorNumberArg;
        this.patchNumber = patchNumberArg;
        this.versionType = versionTypeArg;
        this.specialNumber = 0;
    }
    /**
     * Constructor.
     * @param majorNumberArg mayor number
     * @param minorNumberArg minor number
     * @param patchNumberArg patch number
     * @param versionTypeArg version type
     * @param specialNumberArg special number
     */
    public Version(final int majorNumberArg,
                   final int minorNumberArg,
                   final int patchNumberArg,
                   final VersionType versionTypeArg,
                   final int specialNumberArg) {
        this.majorNumber = majorNumberArg;
        this.minorNumber = minorNumberArg;
        this.patchNumber = patchNumberArg;
        this.versionType = versionTypeArg;
        this.specialNumber = specialNumberArg;
    }

    /**
     * Constructor.
     * @param versionAsString version as string
     */
    public Version(final String versionAsString) {
        String normalized = toNormalizedString(versionAsString);

        String[] versionArray = normalized.split("\\" + DOT_SEPARATOR);
        final int expectedVersionArrayLength = 5;
        if (versionArray.length != expectedVersionArrayLength) {
            String msg = WRONG_ARRAY_LENGTH_EXC_MSG + expectedVersionArrayLength
                    + ", but it is " + versionArray.length;
            throw new CoreException(msg);
        }
        String mayorStr = versionArray[VersionNumberType.MAJOR.getIndex()];
        this.majorNumber = Integer.valueOf(mayorStr);
        String minorStr = versionArray[VersionNumberType.MINOR.getIndex()];
        this.minorNumber = Integer.valueOf(minorStr);
        String patchStr = versionArray[VersionNumberType.PATCH.getIndex()];
        this.patchNumber = Integer.valueOf(patchStr);
        this.versionType = VersionType.of(versionArray[VERSION_TYPE_INDEX]);
        String specialStr = versionArray[VersionNumberType.SPECIAL.getIndex()];
        this.specialNumber = Integer.valueOf(specialStr);
        checkIsValid();
    }

    /**
     * Creates normalized string representation.
     * @param versionAsString classic version String
     * @return normalized string
     */
    private String toNormalizedString(final String versionAsString) {
        String normalized = versionAsString;
        if (normalized.contains("-")) { //not standard
            normalized = normalized.replace(DASH_SEPARATOR, DOT_SEPARATOR);
            if (normalized.endsWith(VersionType.SNAPSHOT.getValue())) {
                normalized = normalized + 0;
            }
        } else {
            //note: is STANDARD
            normalized = normalized + DOT_SEPARATOR
                    + VersionType.STANDARD.getValue()
                    + 0;
        }
        //replace the values
        for (VersionType vt : VersionType.values()) {
            boolean skipLoop = normalized
                    .contains(VersionType.STANDARD.getValue())
                    && vt != VersionType.STANDARD;
            if (skipLoop) {
                //continue needed to avoid transforming standard to sta.nda.rd
                continue;
            }
            String value = vt.getValue();
            if (normalized.contains(value)) {
                this.versionType = vt;
                normalized = normalized.replace(value, value + DOT_SEPARATOR);
            }
        }
        return normalized;
    }

    /**
     * Creates a String representation of the instance.
     * @return version as text
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(majorNumber);
        sb.append(DOT_SEPARATOR);
        sb.append(minorNumber);
        sb.append(DOT_SEPARATOR);
        sb.append(patchNumber);
        if (getVersionType() != VersionType.STANDARD) {
            sb.append(DASH_SEPARATOR);
            sb.append(getVersionType().getValue());
            if (getVersionType() != VersionType.SNAPSHOT) {
                sb.append(this.getSpecialNumber());
            }
        }
        return sb.toString();
    }

    /**
     * Loads version value.
     * @param versionNumberType version sub type
     * @return sub version number.
     */
    public int getValue(final VersionNumberType versionNumberType) {
        switch (versionNumberType) {
            case MAJOR: return majorNumber;
            case MINOR: return minorNumber;
            case PATCH: return patchNumber;
            case SPECIAL: return specialNumber;
            default: throw new UnsupportedOperationException(
                    versionNumberType.toString());
        }
    }
    /**
     * Loads version value.
     * @param versionNumberType version sub type
     * @param value version value
     */
    public void setValue(final VersionNumberType versionNumberType,
                         final int value) {
        switch (versionNumberType) {
            case MAJOR: this.majorNumber = value; break;
            case MINOR: this.minorNumber = value; break;
            case PATCH: this.patchNumber = value; break;
            case SPECIAL: this.specialNumber = value; break;
            default: throw new UnsupportedOperationException(
                    versionNumberType.toString());
        }
    }

    /**
     * Increments a sub version.
     * @param versionNumberType version sub type to be incremented.
     */
    public void increment(final VersionNumberType versionNumberType) {
        if (!getVersionType().isStandard()) {
            String msg =
                    "This operation is not supported for version number type "
                            + versionNumberType;
            throw new UnsupportedOperationException(msg);
        }
        int currentValue = getValue(versionNumberType);
        int incrementedValue = currentValue + 1;
        setValue(versionNumberType, incrementedValue);
        switch (versionNumberType) {
            case MAJOR: this.minorNumber = 0; this.patchNumber = 0; break;
            case MINOR: this.patchNumber = 0; break;
            case PATCH: /*nothing to do*/ break;
            default: throw new UnsupportedOperationException(
                    versionNumberType.toString());
        }
    }
    /**
     * Checks, if the version instance is valid.
     * @throws CoreException thrown, if Version instance is not valid.
     */
    public void checkIsValid() {
        if (!validate()) {
            String msg = "Version instance is not valid and cannot be created.";
            throw new CoreException(msg);
        }
    }
    /**
     * Validates this version instance.
     * @return true, if this version instance is valid, otherwise false.
     */
    public boolean validate() {
        boolean isStandard = this.getVersionType().isStandard();
        boolean isSnapshot = this.getVersionType().isSnapshot();
        if (isStandard || isSnapshot) {
            if (specialNumber != 0) {
                return false;
            }
        } else {
            if (specialNumber <= 0) {
                return false;
            }
        }
        if (majorNumber < 0) {
            return false;
        }
        if (minorNumber < 0) {
            return false;
        }
        if (patchNumber < 0) { //NOSONAR
            return false;
        }
        return true;
    }
    /**
     * Creates exact copy of this version as a new instance.
     * @return version instance
     */
    public Version getCopy() {
        return new Version(toString());
    }

    @Override
    public int compareTo(final Version o) {
        Version v1 = this;
        Version v2 = o;
        Integer mayor1 = v1.getMajorNumber();
        Integer mayor2 = v2.getMajorNumber();
        Integer minor1 = v1.getMinorNumber();
        Integer minor2 = v2.getMinorNumber();
        Integer patch1 = v1.getPatchNumber();
        Integer patch2 = v2.getPatchNumber();
        if (mayor1 != mayor2) {
            return mayor1.compareTo(mayor2);
        }
        if (minor1 != minor2) {
            return minor1.compareTo(minor2);
        }
        return patch1.compareTo(patch2);
    }
}
