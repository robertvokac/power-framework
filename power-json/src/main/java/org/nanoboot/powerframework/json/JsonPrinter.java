
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

package org.nanoboot.powerframework.json;

/**
 * Used for JsonObjectPrinter and JsonArrayPrinter to extend.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
class JsonPrinter {

    private static final String BREAKTAB = "\n" + JsonConstants.TAB;

    protected static String addTabOnEveryLineStart(final String value) {
        return JsonConstants.TAB + addTabOnEveryLineStartWithoutFirst(value);
    }

    protected static String addTabOnEveryLineStartWithoutFirst(final String value) {
        return value.replace("\n", BREAKTAB);
    }

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    JsonPrinter() {
        //Not meant to be instantiated.
    }
}
