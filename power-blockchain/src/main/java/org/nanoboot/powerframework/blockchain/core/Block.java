
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

import org.nanoboot.powerframework.blockchain.api.BlockSerializer;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonObjectSerializable;
import org.nanoboot.powerframework.security.hash.api.HashCalculator;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import lombok.Getter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Block implements JsonObjectSerializable {
    private static final String BLOCKCHAIN_PROTOCOL = "blockchainProtocol";

    private static final String HEIGHT = "height";

    private static final String PREVIOUS_HASH = "previousHash";
    private static final String TIMESTAMP = "timestamp";
    private static final String DIFFICULTY = "difficulty";
    private static final String DATA = "data";
    private static final String NONCE = "nonce";

    @Getter
    private final BlockchainProtocol blockchainProtocol;

    @Getter
    private final long height;
    @Getter
    private final String previousHash;
    @Getter
    private final String timeStamp;
    @Getter
    private final String difficultyTarget;
    @Getter
    private final byte[] data;

    @Getter
    private long nonce;

    //
    @Getter
    private String hash = null;

    //Block Constructor.
    public Block(BlockchainProtocol blockchainProtocol,
                 long height,
                 String previousHash,
                 String difficultyTarget,
                 byte[] data) {
        this.blockchainProtocol=blockchainProtocol;
        this.height = height;
        this.previousHash = previousHash;
        this.timeStamp = UniversalDateTime.now().toString();
        this.difficultyTarget = difficultyTarget;
        this.data = data;
    }

    //Calculate new hash based on blocks contents
    public String calculateHash(HashCalculator hashCalculator, BlockSerializer blockSerializer) {
        String serializedBlock = blockSerializer.serialize(this);
        String calculatedhash = hashCalculator.hash(serializedBlock);
        return calculatedhash;
    }

    //Increases nonce value until hash target is reached.
    public void mineBlock(HashCalculator hashCalculator, BlockSerializer blockSerializer) {
        String target = this.difficultyTarget;

        for (long i = 0; i <= Long.MAX_VALUE; i++) {
            this.nonce = i;
            if (nonce == Integer.MAX_VALUE) {
                throw new BlockChainException("Nonce was not found.");
            }
            if (nonce % 1000000 == 0) {
                System.out.println("Nonce # " + nonce);
            }



            String hash = calculateHash(hashCalculator, blockSerializer);

            if (hashCalculator.compareHexNumbers(hash, this.getDifficultyTarget()) <= 0) {
                System.out.println("Found nonce: " + nonce + " A new block was just mined: " + getHash() + "\n" /*+ block.toJsonObject().toPrettyString()*/);
                System.out.println("Block Mined!!! : " + hash);
                break;
            }
        }

    }

    @Override
    public JsonObject toJsonObject() {

        JsonObject jo = new JsonObject();

        jo.add(BLOCKCHAIN_PROTOCOL, blockchainProtocol.toJsonObject());

        jo.add(HEIGHT, height);

        jo.add(PREVIOUS_HASH, previousHash);
        jo.add(TIMESTAMP, timeStamp);
        jo.add(DIFFICULTY, difficultyTarget);
        jo.add(DATA, new String(data));
        jo.add(NONCE, nonce);

        return jo;
    }
}
