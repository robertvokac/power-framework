
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

package com.robertvokac.powerframework.random.choicegenerators;

import com.robertvokac.powerframework.random.RandomException;
import com.robertvokac.powerframework.random.generators.RandomGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class ChoiceGeneratorTest {
    private RandomGenerator random;

    @Before
    public void setup() {
        random = RandomGenerator.getDefaultImplStatic();
    }

    @Test(expected = RandomException.class)
    public void constructor_generator_choiceEntries_choiceEntriesMustNotBeEmptyAndIsEmpty() {
        //prepare
        assertNotNull(new ChoiceGenerator(random));
        //execute
        //assert
    }

    @Test()
    public void constructor_generator_choiceEntries_choiceEntriesMustNotBeEmptyAndIsNotEmpty() {
        //prepare

        assertNotNull(new ChoiceGenerator(random, new ChoiceEntry<>("a", 50)));
        //execute
        //assert
    }

    @Test()
    public void constructor_generator_choiceEntries_choiceEntriesMustNotBeEmptyAndIsNotEmpty2() {
        //prepare

        assertNotNull(new ChoiceGenerator(random, new ChoiceEntry<>("a", 50), new ChoiceEntry<>("b", 75)));
        //execute
        //assert
    }

    @Test
    public void generate_hasOnlyOneEntry() {
        //prepare

        ChoiceGenerator<String> choiceGenerator = new ChoiceGenerator(random, new ChoiceEntry<>("a", 50));
        //execute

        //assert
        assertEquals("a", choiceGenerator.generate().getObject());
    }

    @Test
    public void generate_hasTwoEntries() {
        //prepare

        ChoiceGenerator choiceGenerator = new ChoiceGenerator(random, new ChoiceEntry<>("a", 50), new ChoiceEntry<>("b", 75));
        //execute
        Object generatedString = choiceGenerator.generate().getObject();
        assertTrue("a".equals(generatedString) || "b".equals(generatedString));
        //assert
    }

    @Test
    public void generate_mockedCheck() {
//        //prepare
        class ARandomGeneratorImpl implements RandomGenerator {
            private int[] intArray = new int[]{0, 24, 25, 26, 60, 74, 75, 76, 149, 150};
            private int nextIndex = 0;
            private boolean fromToChecked = false;

            @Override
            public long next() {
                return 0;
            }

            public int nextInt(int from, int to) {
                if (!fromToChecked) {
                    assertEquals(0, from);
                    assertEquals(150, to);
                    fromToChecked = true;
                }
                if (nextIndex >= intArray.length) {
                    fail("next index is " + nextIndex + ", but the intArray has length " + intArray.length);
                }
                int result = intArray[nextIndex];
                ++nextIndex;
                return result;
            }

            @Override
            public RandomGenerator getItself() {
                return this;
            }

            @Override
            public String getName() {
                return "choiceRandomGenerator";
            }
        }
        RandomGenerator randomArg = new ARandomGeneratorImpl();
        ChoiceEntry green = new ChoiceEntry<>("green", 25);//0-25
        ChoiceEntry orange = new ChoiceEntry<>("orange", 50);//26-75
        ChoiceEntry red = new ChoiceEntry<>("red", 75);//76/150

        ChoiceGenerator choiceGenerator = new ChoiceGenerator(randomArg, green, orange, red);
//        //execute
//        //assert
        assertTrue("green".equals(choiceGenerator.generate().getObject()));
        assertTrue("green".equals(choiceGenerator.generate().getObject()));
        assertTrue("green".equals(choiceGenerator.generate().getObject()));
        assertTrue("orange".equals(choiceGenerator.generate().getObject()));
        assertTrue("orange".equals(choiceGenerator.generate().getObject()));
        assertTrue("orange".equals(choiceGenerator.generate().getObject()));
        assertTrue("orange".equals(choiceGenerator.generate().getObject()));
        assertTrue("red".equals(choiceGenerator.generate().getObject()));
        assertTrue("red".equals(choiceGenerator.generate().getObject()));
        assertTrue("red".equals(choiceGenerator.generate().getObject()));
    }
    @Test(expected = RandomException.class)
    public void generate_entryNotFound() {
//        //prepare
        class ARandomGeneratorImpl implements RandomGenerator {
           @Override
            public long next() {
                return 0;
            }

            public int nextInt(int from, int to) {
                return to + 1;
            }

            @Override
            public RandomGenerator getItself() {
                return this;
            }

            @Override
            public String getName() {
                return "choiceRandomGenerator";
            }
        }
        RandomGenerator randomArg = new ARandomGeneratorImpl();
        ChoiceEntry green = new ChoiceEntry<>("green", 25);//0-25
        ChoiceEntry orange = new ChoiceEntry<>("orange", 50);//26-75
        ChoiceEntry red = new ChoiceEntry<>("red", 75);//76/150

        ChoiceGenerator choiceGenerator = new ChoiceGenerator(randomArg, green, orange, red);
//        //execute
        choiceGenerator.generate().getObject();
//        //assert
    }
//    @Test
//    public void generate() {
//        //todo
//
//        //prepare
//        ChoiceEntry<String> colored = new ChoiceEntry<>("colored", 80);
//        ChoiceEntry<String> joker = new ChoiceEntry<>("joker", 10);
//        ChoiceEntry<String> automaticBomb = new ChoiceEntry<>("automaticBomb", 15);
//        ChoiceEntry<String> manualBomb = new ChoiceEntry<>("manualBomb", 40);
//
//        //execute
//
//        int coloredCount = 0;
//        int jokerCount = 0;
//        int automaticBombCount = 0;
//        int manualBombCount = 0;
//        ChoiceGenerator<String> choiceGenerator = new ChoiceGenerator<>(random, colored, joker, automaticBomb, manualBomb);
//
//        int multi = 10000;
//        for (int i = 0; i < 145 * multi; i++) {
//            //System.out.println(choiceGenerator.generate().getName());
//            switch (choiceGenerator.generate().getObject()) {
//                case "colored":
//                    coloredCount++;
//                    break;
//                case "joker":
//                    jokerCount++;
//                    break;
//                case "automaticBomb":
//                    automaticBombCount++;
//                    break;
//                case "manualBomb":
//                    manualBombCount++;
//                    break;
//            }
//        }
//        System.out.println("colored=80 joker=10 automaticBomb=15 manualBomb=40");
//        System.out.println(coloredCount / multi + " " + jokerCount / multi + " " + automaticBombCount / multi + " " + manualBombCount / multi);
//        //assert
//        assertTrue(true);
//    }
}
