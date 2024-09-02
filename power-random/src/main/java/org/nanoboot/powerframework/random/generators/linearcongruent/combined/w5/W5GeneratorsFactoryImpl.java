
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

package org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5;

import lombok.Getter;
import org.nanoboot.powerframework.random.RandomException;
import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.random.generators.linearcongruent.CPlusPlus11LinearCongruentGenerator;

import java.security.SecureRandom;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
final class W5GeneratorsFactoryImpl implements W5GeneratorsFactory {

    /**
     * Plus character.
     */
    private static final char PLUS = '+';
    /**
     * Asterisk character.
     */
    private static final char TIMES = '*';
    /**
     *0.
     */
    private static final int SEED0_INDEX = 0;
    /**
     * 1.
     */
    private static final int SEED0_START = 1;
    /**
     * 3.
     */
    private static final int SEED0_END = 3;
    /**
     * 4.
     */
    private static final int SEED1_INDEX = 4;
    /**
     * 5.
     */
    private static final int SEED1_START = 5;
    /**
     * 7.
     */
    private static final int SEED1_END = 7;

    /**
     * Count of numbers.
     */
    private static final int NUMBER_COUNT = 8;

    /**
     * w5 generators.
     */
    @Getter
    private CPlusPlus11LinearCongruentGenerator[] subGenerators;
    /**
     * Constructor.
     */
    W5GeneratorsFactoryImpl() {
        SecureRandom random = new SecureRandom();
        long[] randomNumbers = new long[NUMBER_COUNT];
        for (int i = 0; i < NUMBER_COUNT; i++) {
            randomNumbers[i] = random.nextLong();
        }
        process(randomNumbers);
    }

    /**
     * Constructor.
     * @param numbers input numbers
     */
    W5GeneratorsFactoryImpl(final long[] numbers) {
        process(numbers);
    }

    /**
     * Methods processing the input numbers.
     * @param randomNumbers random numbers
     */
    private void process(final long[] randomNumbers) {
        if (randomNumbers == null || randomNumbers.length != NUMBER_COUNT) {
            String msg = "Count of numbers must be " + NUMBER_COUNT + ".";
            throw new RandomException(msg);
        }
        long magicNumber = randomNumbers[0];
        CPlusPlus11LinearCongruentGenerator magicGenerator =
                new CPlusPlus11LinearCongruentGenerator(magicNumber);
        long seed0;
        long seed1;

        long number1;
        long number2;
        long number3;
        long number4;

        seed0 = randomNumbers[SEED0_INDEX];
        for (int i = SEED0_START; i <= SEED0_END; i++) {
            number1 = seed0;
            number2 = randomNumbers[i];
            seed0 = executeRandomPlusOrMultiply(
                    magicGenerator, number1, number2);
        }

        CPlusPlus11LinearCongruentGenerator generator0 =
                new CPlusPlus11LinearCongruentGenerator(seed0);

        seed1 = randomNumbers[SEED1_INDEX];
        for (int i = SEED1_START; i <= SEED1_END; i++) {
            number3 = seed1;
            number4 = randomNumbers[i];
            seed1 = executeRandomPlusOrMultiply(
                    magicGenerator, number3, number4);
        }
        CPlusPlus11LinearCongruentGenerator generator1 =
                new CPlusPlus11LinearCongruentGenerator(seed1);
        this.subGenerators = new CPlusPlus11LinearCongruentGenerator[]{
                magicGenerator, generator0, generator1};
    }

    /**
     * Uses total or product of the two given numbers.
     * @param rg random number generator
     * @param number1 number 1
     * @param number2 number 2
     * @return processes the numbers using the random number generator
     */
    private static long executeRandomPlusOrMultiply(final RandomGenerator rg,
                                             final long number1,
                                             final long number2) {
        char operation = rg.nextBoolean() ? PLUS : TIMES;
        if (operation == PLUS) {
            return number1 + number2;
        } else {
            return number1 * number2;
        }
    }
}
