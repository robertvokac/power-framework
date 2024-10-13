
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

package com.robertvokac.powerframework.collections;

import lombok.Getter;
import com.robertvokac.powerframework.core.PowerObject;
import com.robertvokac.powerframework.utils.annotations.InProgress;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
@InProgress
public class Properties extends PowerObject {
    /**
     * Constant #.
     */
    private static final String COMMENT_START_CHARACTER = "#";
    /**
     * Constant =.
     */
    private static final String EQUAL = "=";
    /**
     * Constant 0.
     */
    private static final int PROPERTYPOSITION = 0;
    /**
     * Constant 1.
     */
    private static final int VALUEPOSITION = 1;
    /**
     * Map mapping properties and their values.
     */
    @Getter
    private PowerMap<String> map = new PowerMap<>();

    /**
     * @param propertiesFileTextIn input text
     */
    public Properties(final String propertiesFileTextIn) {
        String[] rows = propertiesFileTextIn.split("\\r?\\n");
        for (String row : rows) {
            if (!row.isEmpty() && !row.startsWith(COMMENT_START_CHARACTER)) {
                String[] array = getArrayFromRowIfPossible(row);
                String property = array[PROPERTYPOSITION];

                if (array.length == 2) {
                    String value = array[VALUEPOSITION];
                    map.put(property, value);
                }
            }
        }
    }

    /**
     * Split row by first "=" occurrence.
     *
     * @param rowIn row
     * @return null, if there is no "="
     */
    private String[] getArrayFromRowIfPossible(final String rowIn) {
        return rowIn.split(EQUAL, 2);
    }

    /**
     * @param propertyIn property
     * @return
     */
    public String getProperty(final String propertyIn) {
        return map.get(propertyIn);
    }

    /**
     * @param propertyIn property
     * @param valueIn value
     */
    public void setProperty(final String propertyIn,
                            final String valueIn) {
        map.replace(propertyIn, valueIn);
    }

    /**
     * @param propertyIn property
     * @return true, if the property is present, otherwise false
     */
    public boolean hasProperty(final String propertyIn) {
        return map.containsKey(propertyIn);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (this.getMap().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        String commaSpace = ", ";
        for (String key : this.getMap().keySet()) {
            sb
                    .append(key)
                    .append(EQUAL)
                    .append(this.getMap().get(key))
                    .append(commaSpace);
        }
        String result = sb.toString();
        return result.substring(0, result.length() - commaSpace.length());
    }


}
