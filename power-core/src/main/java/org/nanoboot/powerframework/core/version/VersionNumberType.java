
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
 * Version subtype.
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum VersionNumberType {
    /**
     * Major version is used for big changes or not backward compatible changes.
     */
    MAJOR(0),
    /**
     * Minor version is used for small changes.
     */
    MINOR(1),
    /**
     * Patch version is used for bug fixed and not for new features.
     */
    PATCH(2),
    //Note: Index 3 is reserved for version type value.
    /**
     * Special version is used for some version types.
     */
    SPECIAL(4),
    /**
     * Enumeration only for special purposes.
     */
    UNKNOWN(100);

    /**
     * Index of the version number type.
     */
    @Getter
    private final int index;

    /**
     * Constructor.
     * @param indexArg index of the version number type
     */
    VersionNumberType(final int indexArg) {
        this.index = indexArg;
    }
}
