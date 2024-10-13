
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

package com.robertvokac.powerframework.core.version;

import com.robertvokac.powerframework.core.CoreException;
import org.junit.Ignore;
import org.junit.Test;

import static com.robertvokac.powerframework.core.version.VersionNumberType.*;
import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class VersionTest {

    @Test
    public void Version_noArg() {
        Version version = new Version();
        assertEquals(0, version.getMajorNumber());
        assertEquals(0, version.getMinorNumber());
        assertEquals(0, version.getPatchNumber());
        assertEquals(VersionType.STANDARD, version.getVersionType());
        assertEquals(0, version.getSpecialNumber());
    }

    @Test
    public void Version_int_int_int() {
        Version version = new Version(1, 2, 3);
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.STANDARD, version.getVersionType());
        assertEquals(0, version.getSpecialNumber());
    }

    @Test
    public void Version_int_int_int_versionType() {
        Version version = new Version(1, 2, 3, VersionType.SNAPSHOT);
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.SNAPSHOT, version.getVersionType());
        assertEquals(0, version.getSpecialNumber());
    }

    @Test
    public void Version_int_int_int_versionType_int() {
        Version version = new Version(1, 2, 3, VersionType.BETA, 4);
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.BETA, version.getVersionType());
        assertEquals(4, version.getSpecialNumber());
    }

    @Test
    public void Version_String() {
        Version version;
        //
        version = new Version("1.2.3-SNAPSHOT");
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.SNAPSHOT, version.getVersionType());
        assertEquals(0, version.getSpecialNumber());
        //
        version = new Version("1.2.3-a5");
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.ALPHA, version.getVersionType());
        assertEquals(5, version.getSpecialNumber());
        //
        version = new Version("1.2.3-b5");
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.BETA, version.getVersionType());
        assertEquals(5, version.getSpecialNumber());
        //
        version = new Version("1.2.3-rc5");
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.RELEASE_CANDIDATE, version.getVersionType());
        assertEquals(5, version.getSpecialNumber());
        //
        version = new Version("1.2.3");
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(VersionType.STANDARD, version.getVersionType());
        assertEquals(0, version.getSpecialNumber());
    }

    @Test(expected = CoreException.class)
    public void Version_Strin__exc() {
        new Version("1.3.4.5");
    }

    @Test
    public void testToString() {
        Version version;
        version = new Version("4.5.6-b7");
        assertEquals(7, version.getSpecialNumber());
        assertEquals("4.5.6-b7", version.toString());
        version = new Version("4.5.6");
        assertEquals("4.5.6", version.toString());
        version = new Version("4.5.6-SNAPSHOT");
        assertEquals("4.5.6-SNAPSHOT", version.toString());
    }

    @Test
    public void getValue() {
        Version version = new Version(1, 2, 3, VersionType.RELEASE_CANDIDATE, 6);
        assertEquals(1, version.getValue(MAJOR));
        assertEquals(2, version.getValue(MINOR));
        assertEquals(3, version.getValue(PATCH));
        assertEquals(6, version.getValue(SPECIAL));
    }

    @Test
    public void setValue() {
        Version version = new Version();
        version.setValue(MAJOR, 1);
        version.setValue(MINOR, 2);
        version.setValue(PATCH, 3);
        version.setValue(SPECIAL, 6);
        //
        assertEquals(1, version.getMajorNumber());
        assertEquals(2, version.getMinorNumber());
        assertEquals(3, version.getPatchNumber());
        assertEquals(6, version.getSpecialNumber());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getValue_Exc() {
        Version version = new Version(1, 2, 3, VersionType.RELEASE_CANDIDATE, 6);
        version.getValue(VersionNumberType.UNKNOWN);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setValue_Exc() {
        Version version = new Version();
        version.setValue(VersionNumberType.UNKNOWN, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void increment() {
        Version version = new Version();
        version.setVersionType(VersionType.BETA);
        version.setSpecialNumber(4);
        version.increment(MAJOR);
    }

    @Test()
    public void increment2() {
        Version version;
        //
        version = new Version();
        version.increment(MAJOR);
        assertEquals("1.0.0", version.toString());
        //
        version = new Version();
        version.increment(MINOR);
        assertEquals("0.1.0", version.toString());
        //
        version = new Version();
        version.increment(PATCH);
        assertEquals("0.0.1", version.toString());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void increment3() {
        Version version = new Version();
        version.increment(SPECIAL);
    }

    @Test
    public void validate() {
        assertFalse(new Version(1, 2, 3, VersionType.STANDARD, 1).validate());
        assertFalse(new Version(1, 2, 3, VersionType.SNAPSHOT, 1).validate());
        assertFalse(new Version(1, 2, 3, VersionType.ALPHA, 0).validate());
        assertFalse(new Version(1, 2, 3, VersionType.BETA, 0).validate());
        assertFalse(new Version(1, 2, 3, VersionType.RELEASE_CANDIDATE, 0).validate());
        assertFalse(new Version(1, 2, 3, VersionType.ALPHA, -1).validate());
        assertFalse(new Version(1, 2, 3, VersionType.BETA, -1).validate());
        assertFalse(new Version(1, 2, 3, VersionType.RELEASE_CANDIDATE, -1).validate());
        assertFalse(new Version(-1, 2, 3).validate());
        assertFalse(new Version(1, -2, 3).validate());
        assertFalse(new Version(1, 2, -3).validate());
        assertTrue(new Version(1, 2, 3).validate());
    }

    @Test(expected = CoreException.class)
    public void checkIsValid() {
        new Version(1, 2, -3, VersionType.STANDARD, 1).checkIsValid();
    }

    @Test
    public void getCopy() {
        assertEquals("4.5.6-b8", new Version("4.5.6-b8").getCopy().toString());
    }

    /**
     * Test of compareTo method, of class Version.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        //prepare
        Version v0_0_0 = new Version("0.0.0");
        Version v0_0_1 = new Version("0.0.1");
        Version v0_0_2 = new Version("0.0.2");
        Version v0_1_0 = new Version("0.1.0");
        Version v0_1_1 = new Version("0.1.1");
        Version v0_1_2 = new Version("0.1.2");
        Version v1_0_0 = new Version("1.0.0");
        Version v1_0_1 = new Version("1.0.1");
        Version v1_0_2 = new Version("1.0.2");
        Version v2_0_0 = new Version("2.0.0");
        Version v2_0_1 = new Version("2.0.1");
        Version v2_0_2 = new Version("2.0.2");
        Version[] versions = new Version[]{
            v0_0_0,
            v0_0_1,
            v0_0_2,
            v0_1_0,
            v0_1_1,
            v0_1_2,
            v1_0_0,
            v1_0_1,
            v1_0_2,
            v2_0_0,
            v2_0_1,
            v2_0_2
        };
        int vmin = 0;
        int vmax = versions.length - 1;
        //execute
        //assert
        for (Version v : versions) {
            assertEquals(0, v.compareTo(v));
        }
        for (int i = vmin; i <= vmax; i++) {
            Version current = versions[i];
            Version previous = i == vmin ? null : versions[i - 1];
            Version next = i == vmax ? null : versions[i + 1];
            String msg = String.format(
                    "current = %s, previous = %s, next = %s",
                    current.toString(), 
                    (previous == null ? null :previous.toString()),
                    (next == null ? null :next.toString())
            );
            //System.out.println(msg);
            if (previous != null) {
                assertEquals("Assertion failed: current > previous : " + msg, 1, current.compareTo(previous));
            }
            if (next != null) {
                assertEquals("Assertion failed: next > current : " + msg, 1, next.compareTo(current));
            }
            //
            if (previous != null) {
                assertEquals("Assertion failed: previous < current : " + msg, -1, previous.compareTo(current));
            }
            if (next != null) {
                assertEquals("Assertion failed: current < next : " + msg, -1, current.compareTo(next));
            }

        }
    }
}
