
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

package org.nanoboot.powerframework.random.choicegenerators;

import org.nanoboot.powerframework.random.RandomException;
import org.nanoboot.powerframework.random.generators.RandomGenerator;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ProbabilityGenerator {
    /**
     * Probability minimum, which is 0.
     */
    public static final int PROBABILITY_MIN = 0;
    /**
     * Probability maximum, which is 100.
     */
    public static final int PROBABILITY_MAX = 100;
    /**
     *
     */
    private final ChoiceGenerator<Boolean> choiceGenerator;
    /**
     * Internal flag, which is true, if the probability given in the constructor is 0.
     * If alwaysFalse is true, random generator won't be used and false will be always returned.
     */
    private final boolean alwaysFalse;

    /**
     * Constructor.
     * @param random CSRandomGenerator implementation used to generate randomness for this probability generator.
     * @param probability Probability- from 0 to 100.
     */
    public ProbabilityGenerator(final RandomGenerator random, final int probability) {
        if (probability < PROBABILITY_MIN) {
            throw new RandomException("Probability is less than minimum: " + probability);
        }
        if (probability > PROBABILITY_MAX) {
            throw new RandomException("Probability is more than maximum: " + probability);
        }
        alwaysFalse = probability == PROBABILITY_MIN;
        ChoiceEntry<Boolean> yes = new ChoiceEntry<>(Boolean.TRUE, probability);
        ChoiceEntry<Boolean> no = new ChoiceEntry<>(Boolean.FALSE, PROBABILITY_MAX - probability);

        this.choiceGenerator = new ChoiceGenerator<>(random, yes, no);
    }

    /**
     * Generates true or false based on the probability.
     *
     * @return true or false based on the given randomness generator and probability
     */
    public boolean generate() {
        if (alwaysFalse) {
            return false;
        }
        return this.choiceGenerator.generate().getObject().booleanValue();
    }
}
