
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

package com.robertvokac.powerframework.sql.core;

import lombok.Getter;
import lombok.Setter;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColumnNameValue {

    /**
     * Field description
     */
    @Getter
    @Setter
    private String name;
    /**
     * Field description
     */
    @Getter
    @Setter
    private String value;

    public ColumnNameValue(String nameIn, String valueIn) {
        this.name = nameIn;
        this.value = valueIn;
    }



    public String toString() {
        return name + '=' + value;
    }
}