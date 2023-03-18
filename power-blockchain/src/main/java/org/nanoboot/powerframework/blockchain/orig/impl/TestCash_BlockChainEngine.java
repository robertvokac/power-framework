
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

import org.nanoboot.powerframework.blockchain.orig.base.*;
import org.nanoboot.powerframework.security.hash.api.HashCalculator;
import org.nanoboot.powerframework.time.duration.Duration;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import org.nanoboot.powerframework.time.utils.TimeUnit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TestCash_BlockChainEngine extends BlockChainEngine {

    public static final String TEST_CASH = "TestCash";
    public static final int COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK = 10;
    //public static final String DEFAULT_DIFFICULTY = "0fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
    public static final String DEFAULT_DIFFICULTY = "00184f329993e8d38cd0a31969b54367b4fc5af6ed86d827c1343dbf8b66a4a5";

    public static float DIFFICULTY_PERCENT_CHANGE = (float) 1;

    public TestCash_BlockChainEngine(BlockChain blockChain) {
        super(TEST_CASH, blockChain, new BlockTypeVersionList(List.of(new TestCash_1_0_BlockType())));
    }

    @Override
    public BlockFragment createNewBlockFragment(String data) {
        Block lastBlock = blockChain.getLastBlock();
        int newBlockHeight = lastBlock == null ? 0 : lastBlock.getBlockHeader().getHeight() + 1;
        long newTimeStamp = UniversalDateTime.now().toLong();
        String previousBlockHash = lastBlock == null ? "0" : lastBlock.getHash();
        String oldDifficulty = lastBlock == null ? DEFAULT_DIFFICULTY : lastBlock.getBlockHeader().getDifficulty();
        String newDifficulty = oldDifficulty;

        int newDifficultyPeriod = 1000;
        if (lastBlock != null && newBlockHeight % newDifficultyPeriod == 0) {

            List<Block> lastBlocks = blockChain.getLastXBlocks(newDifficultyPeriod);
            int lastBlocksCount = lastBlocks.size();
            Block blockStart = lastBlocks.get(0);
            Block blockEnd = lastBlocks.get(lastBlocks.size() - 1);
            long moment1 = blockStart.getBlockHeader().getTimeStamp();
            long moment2 = blockEnd.getBlockHeader().getTimeStamp();
            UniversalDateTime udt1 = new UniversalDateTime(moment1);
            UniversalDateTime udt2 = new UniversalDateTime(moment2);
            Duration duration = new org.nanoboot.powerframework.time.duration.Period(udt1, udt2).getDuration();
            duration.toTotal(TimeUnit.SECOND);
            double averageCountOfMillisecondsToMineABlockForTenLastBlocks = (duration.toTotal(TimeUnit.SECOND) / (lastBlocksCount - 1));

            int countX = 0;
            int sum = 0;
            for (Integer i : TestCash_1_0_BlockMiner.lastFiveBlockMiningTimesInMilliseconds) {
                sum = sum + i;
                countX = countX + 1;
            }
            System.out.println("sumInSeconds="+((double)sum));

            averageCountOfMillisecondsToMineABlockForTenLastBlocks =  ((((double) sum) / ((double) countX)) /*/ 1*/);
            System.out.println("averageCountOfMillisecondsToMineABlockForTenLastBlocks=" + averageCountOfMillisecondsToMineABlockForTenLastBlocks);
            boolean plus = false;
            if(((int)Math.round(averageCountOfMillisecondsToMineABlockForTenLastBlocks))==COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK) {
                DIFFICULTY_PERCENT_CHANGE=1f/16;
            } else {
                if(DIFFICULTY_PERCENT_CHANGE != (float) 1f/1f) {
                    DIFFICULTY_PERCENT_CHANGE = (float) 1f/1f;
                }
            }
            if (averageCountOfMillisecondsToMineABlockForTenLastBlocks < COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK) {
                plus = false;
                System.out.println("Difficulty +++ increasing");

            }
            if (averageCountOfMillisecondsToMineABlockForTenLastBlocks > COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK) {
                plus = true;
                System.out.println("Difficulty --- decreasing");
            }
//            if (DIFFICULTY_PERCENT_CHANGE >= 16) {
//                DIFFICULTY_PERCENT_CHANGE = 4;
//            }

            System.out.println("averageCountOfSecondsToMineABlockForTenLastBlocks=" + averageCountOfMillisecondsToMineABlockForTenLastBlocks);
            if (averageCountOfMillisecondsToMineABlockForTenLastBlocks != COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK) {
                //DIFFICULTY_PERCENT_CHANGE = DIFFICULTY_PERCENT_CHANGE * 2;
                double realDifficultyPercentChange = DIFFICULTY_PERCENT_CHANGE;
                double more = averageCountOfMillisecondsToMineABlockForTenLastBlocks > COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK ? averageCountOfMillisecondsToMineABlockForTenLastBlocks : COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK;
                double less = averageCountOfMillisecondsToMineABlockForTenLastBlocks < COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK ? averageCountOfMillisecondsToMineABlockForTenLastBlocks : COUNT_OF_MILLISECONDS_TO_MINE_A_BLOCK;

                if ((less / more) < 0.5) {
                    realDifficultyPercentChange = 50;
                }
                double change = 1 + ((plus ? 1 : (-1)) * (realDifficultyPercentChange / 100));
//                if((double)(averageCountOfSecondsToMineABlockForTenLastBlocks) / (double)(COUNT_OF_SECONDS_TO_MINE_A_BLOCK)<0.9 || (double)(averageCountOfSecondsToMineABlockForTenLastBlocks) / (double)(COUNT_OF_SECONDS_TO_MINE_A_BLOCK)> 1.1){
//                    change = 1 + ((plus ? 1 : (-1)) * (25f / 100));
//                }
                System.out.println(" Changing to " + change);
                BlockType blockType = blockTypeVersionList.findBlockType("test_cash:1:0");
                HashCalculator hashCalculator = blockType.getHashCalculator();
                String oldDifficultyAsDec = hashCalculator.convertHexStringToDecString(oldDifficulty);
                System.out.println("oldDifficultyAsDec=" + oldDifficultyAsDec);
                BigInteger bi = new BigDecimal(oldDifficultyAsDec).multiply(new BigDecimal(change)).toBigInteger();
                System.out.println("newDifficultyAsDec=" + bi.toString());
                newDifficulty = hashCalculator.convertDecStringToHexString(bi.toString());
                System.err.println("NEW_DIFFICULTY = "  + newDifficulty);
            } else {
                //DIFFICULTY_PERCENT_CHANGE = DIFFICULTY_PERCENT_CHANGE / 2;
            }
        }
        BlockHeader blockHeader = new BlockHeader("test_cash:1:0", newBlockHeight, newTimeStamp, previousBlockHash, newDifficulty);
        return new BlockFragment(blockHeader, new SimpleBlockData(data));
    }
}
