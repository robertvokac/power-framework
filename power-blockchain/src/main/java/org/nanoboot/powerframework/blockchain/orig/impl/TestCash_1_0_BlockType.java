
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

import org.nanoboot.powerframework.blockchain.orig.base.BlockType;
import org.nanoboot.powerframework.security.hash.locator.HashCalculatorLocator;
import org.nanoboot.powerframework.security.hash.locator.HashImpl;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TestCash_1_0_BlockType extends BlockType {
private static final String TYPE = "test_cash";
private static final int MAYOR_VERSION = 1;
private static final int MINOR_VERSION = 0;
    public TestCash_1_0_BlockType() {
        super(TYPE, MAYOR_VERSION, MINOR_VERSION, HashCalculatorLocator.locate(HashImpl.SHA_256), new JsonBlockSerializer(), null, new TestCash_1_0_BlockMiner());
    }
}
