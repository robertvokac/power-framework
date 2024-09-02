
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

package org.nanoboot.powerframework.core.version;

import lombok.Getter;

/**
 * Version type.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum VersionType {
    /**
     * Snapshot version.
     *
     * Description: Development version, which may not be stable.
     */
    SNAPSHOT("SNAPSHOT"),
    /**
     * Alpha version.
     *
     * Description: alpha version.
     */
    ALPHA("a"),
    /**
     * Beta version.
     *
     * Description: beta version.
     */
    BETA("b"),
    /**
     * Release candidate version.
     *
     * Description: release candidate version.
     */
    RELEASE_CANDIDATE("rc"),
    /**
     * Standard version.
     *
     * Description: standard version, which should be stable.
     */
    STANDARD("standard");

    /**
     * Value of the version type.
     */
    @Getter
    private final String value;

    /**
     * Constructor.
     * @param valueArg of version type.
     */
    VersionType(final String valueArg) {
        this.value = valueArg;
    }

    /**
     * Returns version type of value string.
     * @param string value as string
     * @return version type
     */
    public static VersionType of(final String string) {
        for (VersionType e : VersionType.values()) {
            if (string.equals(e.getValue())) {
                return e;
            }
        }
        String msg = "Found no VersionType with value " + string;
        throw new UnsupportedOperationException(msg);
    }

    /**
     * Checks, the version type is SNAPSHOT.
     * @return true, it the condition is true, otherwise false
     */
    public boolean isSnapshot() {
        return this == SNAPSHOT;
    }
    /**
     * Checks, the version type is ALPHA.
     * @return true, it the condition is true, otherwise false
     */
    public boolean isAlpha() {
        return this == ALPHA;
    }
    /**
     * Checks, the version type is BETA.
     * @return true, it the condition is true, otherwise false
     */
    public boolean isBeta() {
        return this == BETA;
    }
    /**
     * Checks, the version type is RELEASE_CANDIDATE.
     * @return true, it the condition is true, otherwise false
     */
    public boolean isReleaseCandidate() {
        return this == RELEASE_CANDIDATE;
    }
    /**
     * Checks, the version type is STANDARD.
     * @return true, it the condition is true, otherwise false
     */
    public boolean isStandard() {
        return this == STANDARD;
    }
}
