
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

import org.nanoboot.powerframework.blockchain.core.BlockChainException;
import lombok.AllArgsConstructor;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

@AllArgsConstructor
public abstract class BlockChainEngine {
    private String blockChainEngineName;
    protected BlockChain blockChain;
    protected BlockTypeVersionList blockTypeVersionList;

    public void addData(String data) {
        BlockFragment blockFragment = createNewBlockFragment(data);
        BlockType blockType = blockTypeVersionList.findBlockType(blockFragment.getBlockHeader().getBlockTypeId());
        if (blockType == null) {
            throw new BlockChainException("blockType " + blockFragment.getBlockHeader().getBlockTypeId() + " was not found.");
        }

        Block block = blockType.getBlockMiner().mine(blockFragment, blockType);
        addBlock(block);
    }

    public abstract BlockFragment createNewBlockFragment(String data);

    public void addBlock(Block newBlock) {
        blockChain.addBlock(newBlock);
    }

}
