
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
