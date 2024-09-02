
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

package org.nanoboot.powerframework.utils;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class StringUtils {

    /**
     * "" Constant.
     */
    public static final String EMPTY_STRING = "";

    /**
     * Appends objects.
     * @param objects objects to append
     *
     * @return appended objects
     */
    public static String appendObjects(final Object... objects) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object element : objects) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();
    }

    /**
     * Checks, if a string is empty.
     * @param string string to check
     * @return true, if the string is empty, otherwise false.
     */
    public static boolean isEmpty(final String string) {
        return string.equals(EMPTY_STRING);
    }

    /**
     * Converts string to int.
     * @param string string to convert
     * @return int
     */
    public static int toInt(final String string) {
        return Integer.valueOf(string);
    }

    /**
     * Creates lines from a String.
     * @param string string to split
     * @return splitted string
     */
    public static String[] toLines(final String string) {
        return string.split("\\r?\\n");
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private StringUtils() {
    }
}
