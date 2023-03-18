
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
