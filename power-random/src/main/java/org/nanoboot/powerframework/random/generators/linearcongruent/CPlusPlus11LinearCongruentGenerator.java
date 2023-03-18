
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

package org.nanoboot.powerframework.random.generators.linearcongruent;

import org.nanoboot.powerframework.core.exceptions.UnsupportedMethodException;

/**
 * Represents a seed. Uses linear congruential function.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CPlusPlus11LinearCongruentGenerator
        extends LinearCongruentGenerator {

    /**
     * multiplier constant.
     */
    private static final long MULTIPLIER = 16807;

    /**
     * increment constant.
     */
    private static final long INCREMENT = 0;

    /**
     * modulus constant.
     */
    private static final long MODULUS = 2147483647;

    /**
     * Constructor.
     *
     * @param initialSeedParam the number defining the returned numbers
     */
    public CPlusPlus11LinearCongruentGenerator(
            final long initialSeedParam) {
        super(MULTIPLIER, INCREMENT, MODULUS, initialSeedParam);
    }

    /**
     * Returns current number.
     *
     * @return current number
     */
    @Override
    public long current() {
        throw new UnsupportedMethodException("");
    }

    /**
     * Returns initial seed.
     *
     * @return initial seed
     */
    @Override
    public long initialSeed() {
        throw new UnsupportedMethodException("");
    }

}
