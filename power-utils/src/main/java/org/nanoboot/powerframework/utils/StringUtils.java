
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
