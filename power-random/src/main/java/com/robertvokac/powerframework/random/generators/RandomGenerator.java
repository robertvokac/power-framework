
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

package com.robertvokac.powerframework.random.generators;

import com.robertvokac.powerframework.core.exceptions.UnsupportedMethodException;
import com.robertvokac.powerframework.random.RandomException;
import com.robertvokac.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import com.robertvokac.powerframework.random.internal.RandomNumberUtils;
import com.robertvokac.powerframework.random.internal.RandomTextUtils;
import com.robertvokac.powerframework.text.CharacterType;

import java.util.ArrayList;
import java.util.List;

/**
 * Random Generator interface with some default methods.
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public interface RandomGenerator {

    /**
     * Returns next number.
     *
     * @return next number
     */
    long next();

    /**
     * Skips next number.
     */
    default void skip() {
        next();
    }

    /**
     * Returns current number.
     *
     * @return current number
     */
    default long current() {
        String msg = "Current number cannot be returned again.";
        throw new UnsupportedMethodException(msg);
    }

    /**
     * Returns initial number.
     *
     * @return initial number
     */
    default long initialSeed() {
        String msg = "Initial number cannot be returned.";
        throw new UnsupportedMethodException(msg);
    }

    /**
     * Returns number of calls of the next() method.
     *
     * @return initial number
     */
    default long numberOfNextCalls() {
        String msg = "numberOfNextCalls is not supported.";
        throw new UnsupportedMethodException(msg);
    }

    /**
     * Returns number of calls of the next() method.
     *
     * @return initial number
     */
    default List<Long> valuesOfNextCalls() {
        String msg = "valuesOfNextCalls is not supported.";
        throw new UnsupportedMethodException(msg);
    }

    /**
     * Returns itself.
     * @return itself
     */
    RandomGenerator getItself();

    /**
     * Returns next number using the range.
     *
     * @param from start
     * @param to   end
     * @return next number in the range
     */
    default long next(final long from, final long to) {
        return RandomNumberUtils.next(getItself(), from, to);
    }

    /**
     * Returns next number.
     *
     * @return next number
     */

    default int nextInt() {
        return RandomNumberUtils.nextInt(getItself());
    }

    /**
     * Return number in the given range.
     *
     * @param from starting position
     * @param to ending position
     * @return pseudo random int
     */
    default int nextInt(final int from, final int to) {
        return RandomNumberUtils.nextInt(getItself(), from, to);
    }

    /**
     * @return pseudo random boolean
     */
    default boolean nextBoolean() {
        return RandomNumberUtils.nextBoolean(getItself());
    }
    /**
     * Returns random character.
     *
     * @return random character
     */
    default char nextChar() {
        return RandomTextUtils.nextChar(getItself());
    }
    /**
     * Returns random character.
     *
     * @param types type of characters to be used.
     * @return random character
     */
    default char nextChar(final CharacterType... types) {
        return RandomTextUtils.nextChar(getItself(), types);
    }
    /**
     * Returns random text consisting of letters or numbers.
     *
     * @param length the size of the return String
     * @return random text using the given parameters
     */
    default String nextText(final int length) {
        return RandomTextUtils.nextText(getItself(), length);
    }
    /**
     * Returns random text.
     *
     * @param length the size of the return String
     * @param types  character types
     *               to use for the string to be returned.
     *               If empty or null: lower and upper
     *               letters and number only will be used.
     *               Note: CharacterType.OTHER_NOT_PRINTABLE
     *               is not supported.
     * @return random text using the given parameters
     */
    default String nextText(final int length,
                            final CharacterType... types) {
        return RandomTextUtils.nextText(getItself(), length, types);
    }
    /**
     * Returns random element of an array.
     * @param elements generic array
     * @param <T> type of the array and type to return
     * @return random element
     */
    default <T> T randomElement(T... elements) {
        int to = elements.length - 1;
        int randomIndex = nextInt(0, to);
        return elements[randomIndex];
    }
    default <T> List<T> getRandomItemsFromList(List<T> list, int itemCount) {
        if (itemCount > list.size()) {
            throw new RandomException("itemCount > list.size()");
        }
        List<T> listCopy = new ArrayList<>();
        for (T e : list) {
            listCopy.add(e);
        }
        List<T> result = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            int randomListCopyIndex = nextInt(0, listCopy.size() - 1);
            T randomItem = listCopy.get(randomListCopyIndex);
            listCopy.remove(randomListCopyIndex);
            result.add(randomItem);
        }
        return result;
    }

    default <T> T getRandomItemFromList(List<T> list) {
        if (list.isEmpty()) {
            throw new RandomException("list is empty");
        }

        int randomListCopyIndex = nextInt(0, list.size() - 1);
        T randomItem = list.get(randomListCopyIndex);

        return randomItem;
    }
    /**
     * Returns W5RandomGenerator instance.
     * @return instance of W5RandomGenerator
     */
    static RandomGenerator getDefaultImplStatic() {
        return W5RandomGenerator.getStaticInstance();
    }

    /**
     * Returns unique string identification of the given random generator type.
     * Instances of the same implementation should return same value.
     * @return name of the implementation
     */
    String getName();
}
