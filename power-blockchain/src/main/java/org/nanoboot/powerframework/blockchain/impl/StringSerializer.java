
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

package org.nanoboot.powerframework.blockchain.impl;

import org.nanoboot.powerframework.blockchain.api.BlockSerializer;
import org.nanoboot.powerframework.blockchain.core.Block;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class StringSerializer implements BlockSerializer {

    public static final String SEPARATOR = "::";

    @Override
    public String serialize(Block block) {
        return block.getBlockchainProtocol().toString() + SEPARATOR +
                block.getHeight() + SEPARATOR +
                block.getPreviousHash() + SEPARATOR +
                block.getTimeStamp() + SEPARATOR +
                block.getDifficultyTarget() + SEPARATOR +
                new String(block.getData()) + SEPARATOR +
                block.getNonce();
    }
}
