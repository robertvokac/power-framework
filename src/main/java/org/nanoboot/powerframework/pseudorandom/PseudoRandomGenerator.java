
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

package org.nanoboot.powerframework.pseudorandom;

import org.nanoboot.powerframework.PowerRuntimeException;
import org.nanoboot.powerframework.datetime.DateTime;
import org.nanoboot.powerframework.datetime.UniversalDateTime;

/**
 * Used to generate pseudo random values.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class PseudoRandomGenerator {

    private final Seed magicSeed;
    private final Seed[] seed = new Seed[2];
    private static final PseudoRandomGenerator pseudoRandomGenerator;

    /**
     * Constructor
     *
     * @param magicNumber
     * @param dateTime
     */
    public PseudoRandomGenerator(long magicNumber, DateTime dateTime) {
        this.magicSeed = new Seed(magicNumber);
        long year = dateTime.getYear();
        long month = dateTime.getMonth();
        long day = dateTime.getDay();
        long hour = dateTime.getHour();
        long minute = dateTime.getMinute();
        long second = dateTime.getSecond();
        long millisecond = dateTime.getMillisecond();
        this.seed[0] = new Seed(1000 * (minute + day) + millisecond);
        this.seed[1] = new Seed(hour * 100000000 + year * 10000 + second * 100 + month);

    }

    static {
        UniversalDateTime currentUniversalDateTime = UniversalDateTime.getCurrentUniversalDateTime();
        int currentDay = currentUniversalDateTime.getMonth();
        int currentMillisecond = currentUniversalDateTime.getMillisecond();
        long magicNumber = (long) currentDay * 1000 + (long) currentMillisecond;
        pseudoRandomGenerator = new PseudoRandomGenerator(magicNumber, currentUniversalDateTime);
    }

    /**
     * @return static instance
     */
    public static PseudoRandomGenerator getInstance() {
        return pseudoRandomGenerator;
    }

    /**
     *
     * @param from
     * @param to
     * @return pseudo random long
     */
    public long getLong(long from, long to) {
        if (from > to) {
            throw new IllegalArgumentException("from is greater than to.");
        }

        long[] numberFractions = new long[2];

        for (int i = 0; i <= 1; i++) {
            this.seed[0].jump();
            this.seed[1].jump();

            if (((magicSeed.getNextNumber()) % 2) == 0) {
                this.seed[0].jump();
            }
            if (((magicSeed.getNextNumber()) % 2) == 1) {
                this.seed[1].jump();
            }
            long number1 = seed[0].getNextNumber();
            long number2 = seed[1].getNextNumber();
            if ((magicSeed.getNextNumber() % 2) == 1) {
                number2 = number2 * (-1);
            }
            numberFractions[i] = (Math.abs(number1 + number2)) % 1000000000;
        }
        long number = (numberFractions[0] * 1000000000) + numberFractions[1];

        number = (number % (to - from + 1)) + from;

        return number;
    }

    /**
     *
     * @param from
     * @param to
     * @return pseudo random int
     */
    public int getInt(int from, int to) {
        if (to > Integer.MAX_VALUE) {
            throw new PowerRuntimeException("The parameter \"to\" is too big.");
        }
        return (int) getLong(from, to);
    }

    /**
     *
     * @return pseudo random boolean
     */
    public boolean getBoolean() {
        int value = getInt(0, 1);
        return value == 1;
    }
}
