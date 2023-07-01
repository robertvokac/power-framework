
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

import org.nanoboot.powerframework.blockchain.orig.api.BlockData;
import org.nanoboot.powerframework.blockchain.core.BlockChainException;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonObjectSerializable;
import lombok.Getter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Block implements JsonObjectSerializable {
    public static final String BLOCK_TYPE_ID = "blockTypeId";
    public static final String BLOCK_HEADER = "blockHeader";
    public static final String BLOCK_DATA = "blockData";
    public static final String NONCE = "nonce";

    @Getter
    private BlockHeader blockHeader;

    @Getter
    private BlockData blockData;

    private long nonce;

    @Getter
    private String hash;
    @Getter
    private boolean locked = false;

    @Getter
    private BlockType internalBlockType;

    public Block(BlockHeader blockHeader, JsonObject additionBlockHeader, BlockData blockData) {
        this.blockHeader = blockHeader;

        this.blockData = blockData;
    }

    public void injectBlockType(BlockType blockType) {
        this.internalBlockType = blockType;
    }

    public String calculateHashTest(long nonce) {
        this.nonce = nonce;
        String hashedSerializedBlock = internalCalculateHash();
        this.nonce = 0;//todo
        return hashedSerializedBlock;
    }

    private String internalCalculateHash() {
        if (nonce == 0) {
            throw new BlockChainException("Nonce cannot be zero.");
        }
        if (locked) {
            throw new BlockChainException("This block is already locked. Cannot set nonce and calculate nonce.");
        }

        if (internalBlockType == null) {
            throw new BlockChainException("internalBlockType was not injected.");
        }
        String serializedBlock = this.internalBlockType.getBlockSerializer().serialize(this);

        String hashedSerializedBlock = this.internalBlockType.getHashCalculator().hash(serializedBlock);

        //System.out.println("internalCalculateHash - hash for nonce " + nonce + " = " + hashedSerializedBlock);
        return hashedSerializedBlock;
    }

    public void lock(long nonce) {
        this.nonce = nonce;
        String hashedSerializedBlock = internalCalculateHash();
        this.hash = hashedSerializedBlock;

        this.locked = true;
    }

    @Override
    public JsonObject toJsonObject() {
        if (nonce == 0) {
            throw new BlockChainException("Nonce cannot be zero, if json object is created from this block instance.");
        }
        if (internalBlockType == null) {
            throw new BlockChainException("internalBlockType was not injected.");
        }
        JsonObject jo = new JsonObject();
        jo.add(BLOCK_TYPE_ID, internalBlockType.getBlockTypeId());
        jo.add(BLOCK_HEADER, blockHeader.toJsonObject());

        jo.add(BLOCK_DATA, blockData.convertToString());
        jo.add(NONCE, nonce);
        return jo;
    }
}
