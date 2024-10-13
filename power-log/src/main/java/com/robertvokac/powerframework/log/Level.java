
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

package com.robertvokac.powerframework.log;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
