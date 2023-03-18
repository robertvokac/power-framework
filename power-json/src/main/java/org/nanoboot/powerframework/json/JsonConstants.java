
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

package org.nanoboot.powerframework.json;

/**
 * Used to store char and String constants used to parse or print json objects
 * or arrays.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
