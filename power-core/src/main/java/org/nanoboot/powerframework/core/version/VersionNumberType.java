
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
