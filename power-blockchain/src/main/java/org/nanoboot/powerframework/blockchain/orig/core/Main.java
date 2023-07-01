
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

package org.nanoboot.powerframework.blockchain.orig.core;

import org.nanoboot.powerframework.blockchain.orig.base.BlockChain;
import org.nanoboot.powerframework.blockchain.orig.impl.TestCash_BlockChainEngine;
import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Main {
    public static void main(String[] args) {
//        HashCalculator.main(null);
//
//        if(true) return;
        BlockChain blockChain = new BlockChain();
        TestCash_BlockChainEngine bce = new TestCash_BlockChainEngine(blockChain);
        bce.addData("ahoj");
        bce.addData("pavle");
        bce.addData("leo");
        for(int i =0;i<100000000;i++){
            bce.addData(W5RandomGenerator.getStaticInstance().nextText(8));
        }

    }
}
