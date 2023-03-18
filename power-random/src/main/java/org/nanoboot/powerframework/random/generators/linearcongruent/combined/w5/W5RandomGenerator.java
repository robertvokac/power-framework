
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

package org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5;

import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.random.generators.linearcongruent.CPlusPlus11LinearCongruentGenerator;

/**
 * Used to generate pseudo random values.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class W5RandomGenerator implements RandomGenerator {

    /**
     * Static instance of the generator.
     */
    private static final W5RandomGenerator INSTANCE;
    /**
     *generators.
     */
    private final CPlusPlus11LinearCongruentGenerator[] generators;

    /**
     * next() processor.
     */
    private final W5GeneratorsProcessor processor;

    /**
     * Constructor using random input parameters.
     *
     */
    public W5RandomGenerator() {
        W5GeneratorsFactoryImpl gc = new W5GeneratorsFactoryImpl();
        this.generators = gc.getSubGenerators();
        this.processor = new W5GeneratorsProcessorImpl();
    }

    /**
     * Constructor.
     *
     * @param numbers numbers
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public W5RandomGenerator(
                             final long... numbers) {
        this(new W5GeneratorsFactoryImpl(numbers),
                new W5GeneratorsProcessorImpl()
                );
    }

    /**
     * Constructor.
     *
     * @param factory a factory
     * @param processorIn a processor
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public W5RandomGenerator(final W5GeneratorsFactory factory,
                             final W5GeneratorsProcessor processorIn) {
        this.generators = factory.getSubGenerators();
        this.processor = processorIn;
    }

    static {
        INSTANCE = new W5RandomGenerator();
    }

    /**
     * @return static instance
     */
    public static W5RandomGenerator getStaticInstance() {
        return INSTANCE;
    }

    @Override
    public final RandomGenerator getItself() {
        return this;
    }

    @Override
    public final String getName() {
        return this.getClass().getName();
    }

    /**
     * @return pseudo random long
     */
    public long next() {
        return processor.next(generators);
    }

}
