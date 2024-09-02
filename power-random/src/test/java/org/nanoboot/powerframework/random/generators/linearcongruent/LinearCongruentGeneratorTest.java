
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

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class LinearCongruentGeneratorTest {

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
     * initial seed.
     */
    private static final long INITIAL_SEED = 100000;

    private LinearCongruentGenerator g;
    @Before
    public void setup() {
        g = new LinearCongruentGenerator(MULTIPLIER, INCREMENT, MODULUS, INITIAL_SEED);
    }
    @Test
    public void next() {
        assertEquals(((MULTIPLIER * INITIAL_SEED) + INCREMENT) % MODULUS, g.next());
    }

    @Test
    public void current() {
        g.next();
        assertEquals(((MULTIPLIER * INITIAL_SEED) + INCREMENT) % MODULUS, g.current());
    }

    @Test
    public void initialSeed() {
        IntStream.range(0, 100).forEach(i -> g.next());
        assertEquals(INITIAL_SEED, g.initialSeed());
    }

    @Test
    public void getItself() {
        assertEquals(g, g.getItself());
    }

    @Test
    public void getName() {
        assertEquals(g.getClass().getName(), g.getName());
    }

    @Test
    public void getMultiplier() {
        assertEquals(MULTIPLIER, g.getMultiplier());
    }

    @Test
    public void getIncrement() {
        assertEquals(INCREMENT, g.getIncrement());
    }

    @Test
    public void getModulus() {
        assertEquals(MODULUS, g.getModulus());
    }
}
