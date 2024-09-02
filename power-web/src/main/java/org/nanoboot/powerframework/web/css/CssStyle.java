
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

package org.nanoboot.powerframework.web.css;

import org.nanoboot.powerframework.web.PowerWebException;
import lombok.Getter;
import lombok.Setter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class CssStyle {
    @Getter
    private final String name;
    @Getter
    @Setter
    private String value;

    public CssStyle(String nameValue) {
        String[] a=nameValue.split(":");
        if(a.length!=2){
            throw new PowerWebException("nameValue "+nameValue+"is not a valid css style. Because just one colon : is expected");
        }
        this.name=a[0];
        this.value=a[1];

    }

    public CssStyle(String name, String value) {
        this.name=name;
        this.value=value;

    }
    public String build() {
        return name + ':'+ value;
    }

    public String toString() {
        return build();
    }
}
