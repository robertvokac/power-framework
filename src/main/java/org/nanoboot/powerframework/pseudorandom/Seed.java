
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

/**
 * Represents seed. Uses linear congruential function.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class Seed {

    private long currentSeed;
    private static final int A = 16807;
    private static final int C = 0;
    private static final long M = 2147483647;

    Seed(long seed) {
        this.currentSeed = seed;
    }

    long getNextNumber() {
        long number = ((A * currentSeed) + C) % M;
        this.currentSeed = number;
        return number;
    }

    void jump() {
        getNextNumber();
    }
}
