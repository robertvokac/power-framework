
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

import lombok.Getter;
import org.nanoboot.powerframework.random.generators.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a seed. Uses linear congruential function.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class LinearCongruentGenerator implements RandomGenerator {
    /**
     * number multiplying current seed.
     */
    @Getter
    private final long multiplier;

    /**
     * Number to add to the product.
     */
    @Getter
    private final long increment;

    /**
     * modulus used for the total of the product and increment.
     */
    @Getter
    private final long modulus;

    /**
     * Initial seed.
     */
    private final long initialSeed;

    /**
     * Current number.
     */
    private long current;

    @Getter
    private List<Long> nextValues = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param multiplierParam a
     * @param incrementParam c
     * @param modulusParam m
     * @param initialSeedParam the number defining the returned numbers
     */
    public LinearCongruentGenerator(
            final long multiplierParam,
            final long incrementParam,
            final long modulusParam,
            final long initialSeedParam) {
        this.multiplier = multiplierParam;
        this.increment = incrementParam;
        this.modulus = modulusParam;
        this.initialSeed = initialSeedParam;
        this.current = this.initialSeed;
    }

    @Override
    public final long next() {
        long pseudoRandomLong = ((multiplier * current) + increment) % modulus;
        this.current = pseudoRandomLong;
        this.nextValues.add(pseudoRandomLong);
        return pseudoRandomLong;
    }

    /**
     * Returns current number.
     * @return current number
     */
    @Override
    public long current() {
        return current;
    }

    /**
     * Returns initial seed.
     * @return initial seed
     */
    @Override
    public long initialSeed() {
        return initialSeed;
    }

    @Override
    public final RandomGenerator getItself() {
        return this;
    }

    @Override
    public final String getName() {
        return this.getClass().getName();
    }

}
