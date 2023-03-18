
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

package org.nanoboot.powerframework.blockchain.orig.base;

import org.nanoboot.powerframework.blockchain.orig.api.BlockDeserializer;
import org.nanoboot.powerframework.blockchain.orig.api.BlockMiner;
import org.nanoboot.powerframework.blockchain.orig.api.BlockSerializer;
import org.nanoboot.powerframework.security.hash.api.HashCalculator;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class BlockType {
    @Getter
    private String type;
    @Getter
    private int mayorVersion;
    @Getter
    private int minorVersion;
    @Getter
    private HashCalculator hashCalculator;
    @Getter
    private BlockSerializer blockSerializer;
    @Getter
    private BlockDeserializer blockDeserializer;
    @Getter
    BlockMiner blockMiner;
    public String getBlockTypeId() {
        return type + ":" + mayorVersion + ":" + minorVersion;
    }
}
