
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

package com.robertvokac.powerframework.random.internal;

import com.robertvokac.powerframework.random.RandomException;
import com.robertvokac.powerframework.random.generators.RandomGenerator;

/**
 * Utility for number randomness.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public final class RandomNumberUtils {

    /**
     * Private constructor.
     */
    private RandomNumberUtils() {
        //Instantiation not needed
    }

    /**
     * Returns next number using the range.
     * @param rg random generator
     * @param from start
     * @param to   end
     * @return random number in the range
     */
    public static long next(
            final RandomGenerator rg,
            final long from,
            final long to) {
        if (from > to) {
            throw new RandomException("from is greater than to.");
        }
        long range = to - from;
        long randomLong = rg.next();
        long randomRange = randomLong % (range + 1);
        long randomLongInRange;
        randomLongInRange = from + randomRange;

        return randomLongInRange;
    }

    /**
     * Returns next number.
     *
     * @param rg random generator
     * @return next number
     */
    public static int nextInt(final RandomGenerator rg) {
        return (int) (rg.next() % Integer.MAX_VALUE);
    }

    /**
     * Return number in the given range.
     *
     * @param rg random generator
     * @param from start position
     * @param to end position
     * @return pseudo random int
     */
    public static int nextInt(final RandomGenerator rg,
                               final int from, final int to) {
        return (int) rg.next(from, to);
    }

    /**
     * Returns random boolean.
     *
     * @param rg random generator
     * @return pseudo random boolean
     */
    public static boolean nextBoolean(final RandomGenerator rg) {
        long randomLong = rg.next(0, 1);
        return randomLong == 1;
    }
}
