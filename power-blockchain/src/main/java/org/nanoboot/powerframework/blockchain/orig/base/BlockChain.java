
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

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class BlockChain {
    private String blockChainEngineName;
    private List<Block> blocks = new ArrayList<>();

    public int getTotalHeight() {
        return blocks.size() - 1;
    }

    public boolean isEmpty() {
        return blocks.isEmpty();
    }

    public Block getGenesisBlock() {
        if (isEmpty()) {
            return null;
        }
        return getBlock(0);
    }

    public Block getLastBlock() {
        if (isEmpty()) {
            return null;
        }
        return getBlock(blocks.size() - 1);
    }

    public List<Block> getLastXBlocks(int xCount) {
        List<Block> result = new ArrayList<>();

        if (isEmpty()) {
            return result;
        }
        if (xCount <= blocks.size()) {
            for (Block b : blocks) {
                result.add(b);
            }
            return result;
        }
        for (int i = blocks.size() - xCount; i <= (blocks.size() - 1); i++) {
            result.add(blocks.get(i));
        }
        return result;
    }

    public void addBlock(Block block) {
        if (!block.isLocked()) {
            throw new BlockChainException("Block is not locked. It cannot be added");
        }
        if (blocks.isEmpty() && block.getBlockHeader().getHeight() != 0) {
            throw new BlockChainException("New block is a genesis block, but its height is not zero.");
        }
        Block lastBlock = getLastBlock();
        String previousBlockHash = lastBlock == null ? "0" : lastBlock.getHash();

        if (!block.getBlockHeader().getPreviousHash().equals(previousBlockHash)) {
            throw new BlockChainException("Block previous hash is not equal to the hash of the previous block. It cannot be added to the blockchain.");
        }
        blocks.add(block);
    }

    public Block getBlock(int blockHeight) {
        if (blockHeight >= blocks.size()) {
            throw new BlockChainException("There is no block with height " + blockHeight);
        }
        return blocks.get(blockHeight);
    }
}
