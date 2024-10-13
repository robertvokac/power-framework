
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
import lombok.Setter;
import com.robertvokac.powerframework.core.PowerObject;
import com.robertvokac.powerframework.utils.annotations.ToRemove;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 *
 */
@ToRemove
public class Table extends PowerObject {
    /**
     * Name of the table.
     */
    @Getter
    @Setter
    private String name;
    /**
     * Constructor.
     *
     * Not meant to be instantiated.
     */
    private Table() {
    }

    /**
     * Constructor.
     *
     * Constructor description
     *
     * @param nameIn name
     */
    public Table(final String nameIn) {
        this.setName(nameIn);
    }

}
