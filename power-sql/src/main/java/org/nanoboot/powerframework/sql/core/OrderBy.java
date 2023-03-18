
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

package org.nanoboot.powerframework.sql.core;

import org.nanoboot.powerframework.json.JsonObject;
import lombok.Getter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
