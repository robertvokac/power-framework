
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

import com.robertvokac.powerframework.json.JsonObject;
import lombok.Getter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class OrderBy {
    @Getter
    private final String property;
    @Getter
    private final OrderByType orderByType;

    public OrderBy(JsonObject jo) {
        this.property = jo.getString("property");
        this.orderByType = OrderByType.valueOf(jo.getString("orderByType"));
    }

    public OrderBy(String property, OrderByType orderByType) {
        this.property = property;
        this.orderByType = orderByType;
    }

    public OrderBy(String property) {
        this(property, OrderByType.DEFAULT);
    }

    public JsonObject toJsonObject() {
        JsonObject jo = new JsonObject();
        jo.addString("property", property);
        jo.addString("orderByType", orderByType.name());
        return jo;
    }
}
