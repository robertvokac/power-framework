
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
 * Used to store char and String constants used to parse or print json objects
 * or arrays.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonConstants {

    static final char OBJECTSTART = '{';
    static final char OBJECTEND = '}';
    static final char ARRAYSTART = '[';
    static final char ARRAYEND = ']';
    static final char COMMA = ',';
    static final char COLON = ':';
    static final char APOSTROPHE = '"';
    static final char LINEBREAK = '\n';
    static final String NULL = "null";
    static final String TRUE = "true";
    static final String FALSE = "false";
    static final String TAB = "   ";
    static final char SPACE = ' ';

    private JsonConstants() {
    }
}
