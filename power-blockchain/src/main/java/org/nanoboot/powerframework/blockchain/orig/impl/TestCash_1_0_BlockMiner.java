
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

package org.nanoboot.powerframework.blockchain.orig.impl;

import org.nanoboot.powerframework.blockchain.orig.api.BlockMiner;
import org.nanoboot.powerframework.blockchain.orig.base.Block;
import org.nanoboot.powerframework.blockchain.orig.base.BlockFragment;
import org.nanoboot.powerframework.blockchain.orig.base.BlockType;
import org.nanoboot.powerframework.blockchain.core.BlockChainException;
import org.nanoboot.powerframework.security.hash.api.HashCalculator;
import org.nanoboot.powerframework.time.duration.Duration;
import org.nanoboot.powerframework.time.duration.StopWatch;
import org.nanoboot.powerframework.time.utils.TimeUnit;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TestCash_1_0_BlockMiner implements BlockMiner {
    public static List<Integer> lastFiveBlockMiningTimesInMilliseconds = new ArrayList<>();

    @Override
    public Block mine(BlockFragment blockFragment, BlockType blockType) {

        TestCash_1_0_Block block = new TestCash_1_0_Block(blockFragment.getBlockHeader(), blockFragment.getBlockData());
        block.injectBlockType(blockType);

        ////System.out.println("Starting mining block # " + block.getBlockHeader().getHeight());
        //System.out.println("Note: One block should be mined in 1 minute, but the last time was " + countOfSecondsToMineLastBlock + " second(s).");
        //System.out.println("Starting mining block # " + block.getBlockHeader().getHeight());
        StopWatch sw = new StopWatch();

        //System.out.println("start: " + UniversalDateTime.now().toString());
        sw.start();

        ////System.out.println("Searching hash equal or less than " + block.getBlockHeader().getDifficulty());
        for (long nonce = 1; nonce <= Long.MAX_VALUE; nonce++) {
            if (nonce == Integer.MAX_VALUE) {
                throw new BlockChainException("Nonce was not found.");
            }
            if (nonce % 1000000 == 0) {
                System.out.println("Nonce # " + nonce);
            }


            HashCalculator hashCalculator = block.getInternalBlockType().getHashCalculator();
            String hash = block.calculateHashTest(nonce);
            //System.err.println("hashCalculator.compareHexNumbers("+hash+"+, block.getBlockHeader().getDifficulty()="+block.getBlockHeader().getDifficulty()+")="+hashCalculator.compareHexNumbers(hash, block.getBlockHeader().getDifficulty()));
            if (hashCalculator.compareHexNumbers(hash, block.getBlockHeader().getDifficulty()) <= 0) {

                //System.err.println("hashCalculator.compareHexNumbers("+hash+"+, block.getBlockHeader().getDifficulty()="+block.getBlockHeader().getDifficulty()+")="+hashCalculator.compareHexNumbers(hash, block.getBlockHeader().getDifficulty()));
                block.lock(nonce);
                ////System.out.println("Found nonce: " + nonce + " A new block was just mined: " + block.getHash() + "\n" /*+ block.toJsonObject().toPrettyString()*/);

                break;
            }
        }

        //System.out.println("end: " + UniversalDateTime.now().toString());
        sw.stop();
        Duration lastDuration = sw.getCurrentDuration();
        if (lastFiveBlockMiningTimesInMilliseconds.size() == 1000) {
            lastFiveBlockMiningTimesInMilliseconds.remove(0);
        }
        lastFiveBlockMiningTimesInMilliseconds.add((int) lastDuration.toTotal(TimeUnit.MILLISECOND));
        //countOfSecondsToMineLastBlock = (int) lastDuration.toTotal(TimeUnit.SECOND);
        if (block.getBlockHeader().getHeight() % 100 == 0)
            System.out.println("Mining block " + block.getBlockHeader().getHeight() + " + took " + lastDuration.toString() + " .");
        return block;
    }


}
