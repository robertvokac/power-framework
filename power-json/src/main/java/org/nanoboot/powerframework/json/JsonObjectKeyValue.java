
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
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class JsonObjectKeyValue {

    private String key;
    private String value;

    JsonObjectKeyValue(final String string) {
        int colonIndex = findColonIndex(string);
        parseKey(string, colonIndex);
        parseValue(string, colonIndex);
    }

    private void parseKey(final String string,
                          int colonIndex) {
        final int keyStartIndex = 0;
        final int keyEndIndex = colonIndex;
        key = string.substring(keyStartIndex, keyEndIndex).trim();
        key = cleanKey(key);
    }

    private void parseValue(final String string,
                            int colonIndex) {
        final int valueStartIndex = ++colonIndex;
        final int valueEndIndex = string.length();
        value = string.substring(valueStartIndex, valueEndIndex).trim();
    }

    private int findColonIndex(final String string) {
        int colonIndex;
        for (colonIndex = 0; colonIndex < string.length(); colonIndex++) {
            char currentChar = string.charAt(colonIndex);
            if (currentChar == JsonConstants.COLON) {
                return colonIndex;
            }
        }
        throw new JsonException("Colon was not found in " + string);
    }

    /**
     * Removes the apostrophe from the key.
     *
     * @param key
     * @return
     */
    private String cleanKey(final String key) {
        return JsonParser.deleteTheCharAtTheStartAndTheEnd(key);
    }

    String getKey() {
        return key;
    }

    String getValue() {
        return value;
    }
}
