
///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2016-2024 the original author or authors.
//
// This program is free software: you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation, either version 3
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program. If not, see 
// <https://www.gnu.org/licenses/> or write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
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
