
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

package com.robertvokac.powerframework.random.generators.linearcongruent.combined.w5;

import com.robertvokac.powerframework.random.RandomException;
import com.robertvokac.powerframework.random.generators.linearcongruent.CPlusPlus11LinearCongruentGenerator;
/**
 * W5 generator processor implementation.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class W5GeneratorsProcessorImpl implements W5GeneratorsProcessor {

    /**
     * One million.
     */
    private static final int MILLION = 1_000_000_000;
    /**
     * Expected count of generators.
     */
    private static final int EXPECTED_COUNT_OF_GENERATORS = 3;

    @Override
    public final long next(
            final CPlusPlus11LinearCongruentGenerator... generators) {
        if (generators == null) {
            throw new RandomException("Generators must not be null.");
        }
        if (generators.length != EXPECTED_COUNT_OF_GENERATORS) {
            String msg =
                    "Param generators is an array, which has invalid count: "
                            + generators.length;
            throw new RandomException(msg);
        }

        long[] numberFractions = new long[2];

        CPlusPlus11LinearCongruentGenerator g0 = generators[0];
        CPlusPlus11LinearCongruentGenerator g1 = generators[1];
        CPlusPlus11LinearCongruentGenerator g2 = generators[2];
        for (int i = 0; i <= 1; i++) {
            if (g0.nextBoolean()) {
                g1.skip();
            } else {
                g2.skip();
            }
            int number1 = g2.nextInt();
            int number2 = g1.nextInt();
            if (g0.nextBoolean()) {
                number2 *= (-1);
            }
            numberFractions[i] = (Math.abs(number1 + number2)) % MILLION;
        }

        return (numberFractions[0] * MILLION) + numberFractions[1];
    }
}
