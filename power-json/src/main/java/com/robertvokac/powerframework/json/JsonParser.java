
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

package com.robertvokac.powerframework.json;

/**
 * Used to parse String representation of JsonObject or JsonArray to their
 * object representation.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonParser {

    static char getFirstCharOfTheString(final String string) {
        return string.charAt(0);
    }

    static char getLastCharOfTheString(final String string) {
        return string.charAt(string.length() - 1);
    }

    protected static String deleteTheCharAtTheStartAndTheEnd(final String string) {
        return string.substring(1, string.length() - 1);
    }

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    JsonParser() {
        //Not meant to be instantiated.
    }

}
