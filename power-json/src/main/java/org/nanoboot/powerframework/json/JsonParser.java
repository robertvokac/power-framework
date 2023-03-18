
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
 * Used to parse String representation of JsonObject or JsonArray to their
 * object representation.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
