
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

package org.nanoboot.powerframework.blockchain.core;

import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonObjectSerializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

@AllArgsConstructor
public class BlockchainProtocol implements JsonObjectSerializable {
    private static final String PROTOCOL_NAME = "protocolName";
    private static final String PROTOCOL_MAYOR_VERSION = "protocolMayorVersion";
    private static final String PROTOCOL_MINOR_VERSION = "protocolMinorVersion";
    @Getter
    private final String protocolName;
    @Getter
    private final int protocolMayorVersion;
    @Getter
    private final int protocolMinorVersion;
    @Override
    public JsonObject toJsonObject() {

        JsonObject jo = new JsonObject();

        jo.add(PROTOCOL_NAME, protocolName);
        jo.add(PROTOCOL_MAYOR_VERSION, protocolMayorVersion);
        jo.add(PROTOCOL_MINOR_VERSION, protocolMinorVersion);

        return jo;
    }
}
