
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

package org.nanoboot.powerframework.log;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public enum Level {

    /**
     *
     */
    OFF(0, "off", "The highest possible rank and is intended to turn off logging."),

    /**
     *
     */
    FATAL(1, "fatal", "Severe errors that cause premature termination. Expect these to be immediately visible on a status console."),

    /**
     *
     */
    ERROR(2, "error", "Other runtime errors or unexpected conditions. Expect these to be immediately visible on a status console."),

    /**
     *
     */
    WARN(3, "warn", "Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or unexpected, but not necessarily \"wrong\". Expect these to be immediately visible on a status console."),

    /**
     *
     */
    INFO(4, "info", "Interesting runtime events (startup/shutdown). Expect these to be immediately visible on a console, so be conservative and keep to a minimum."),

    /**
     *
     */
    DEBUG(5, "debug", "Detailed information on the flow through the system. Expect these to be written to logs only. Generally speaking, most lines logged by your application should be written as DEBUG."),

    /**
     *
     */
    TRACE(6, "trace", "Most detailed information. Expect these to be written to logs only. "),

    /**
     *
     */
    ALL(7, "all", "All possible information will be logged.");
    private final int verbiageIndex;
    private final String name;
    private final String description;

    Level(int verbiageIndex,
            String name,
            String description) {
        this.verbiageIndex = verbiageIndex;
        this.name = name;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getVerbiageIndex() {
        return verbiageIndex;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
