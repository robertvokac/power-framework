
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
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonSpecialCharSequences {

    private static final char OBJECTLEFT = '{';
    private static final char OBJECTRIGHT = '}';
    private static final char ARRAYLEFT = '[';
    private static final char ARRAYRIGHT = ']';
    private static final char COMMA = ',';
    private static final char COLON = ':';
    private static final char APOSTROPHE = '"';
    private static final String LINEBREAK = "\n";
    private static final String NULL = "null";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final String TAB = "   ";
    private static final char SPACE = ' ';

    private JsonSpecialCharSequences() {
    }

    static char getObjectLeft() {
        return OBJECTLEFT;
    }

    static char getObjectRight() {
        return OBJECTRIGHT;
    }

    static char getArrayLeft() {
        return ARRAYLEFT;
    }

    static char getArrayRight() {
        return ARRAYRIGHT;
    }

    static char getComma() {
        return COMMA;
    }

    static char getColon() {
        return COLON;
    }

    static char getApostrophe() {
        return APOSTROPHE;
    }

    static String getLineBreak() {
        return LINEBREAK;
    }

    static String getNull() {
        return NULL;
    }

    static String getTrue() {
        return TRUE;
    }

    static String getFalse() {
        return FALSE;
    }

    static String getTab() {
        return TAB;
    }

    static char getSpace() {
        return SPACE;
    }
}
