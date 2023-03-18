
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

package org.nanoboot.powerframework.core;

import org.nanoboot.powerframework.core.version.Version;
import org.nanoboot.powerframework.core.version.VersionType;

/**
 * Power is the core class of the Power library.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class PowerFramework {

    /**
     * Current mayor number.
     */
    private static final int MAJOR_NUMBER = 1;
    /**
     * Current minor number.
     */
    private static final int MINOR_NUMBER = 0;
    /**
     * Current patch number.
     */
    private static final int PATCH_NUMBER = 0;
    /**
     * Current version of the Power framework.
     */
    private static Version version =
            new Version(
                    MAJOR_NUMBER,
                    MINOR_NUMBER,
                    PATCH_NUMBER,
                    VersionType.SNAPSHOT,
                    0);
    /**
     * Returns the version number of Power library.
     *
     * @return the version number of Power library
     */
    public static String getVersion() {
        return version.toString();
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private PowerFramework() {
        //Not meant to be instantiated.
        //NOSONAR
    }

}
