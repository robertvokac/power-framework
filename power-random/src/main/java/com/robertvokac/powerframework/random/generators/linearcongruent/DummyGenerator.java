
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

package com.robertvokac.powerframework.random.generators.linearcongruent;

import com.robertvokac.powerframework.random.RandomException;
import com.robertvokac.powerframework.random.generators.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a seed. Uses linear congruential function.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class DummyGenerator implements RandomGenerator {
    private final List<Long> nextValues;
    private int nextValueIndex = 0;
    private final int maxNextValueIndex;

    public DummyGenerator(List<Long> nextValues) {
        this.nextValues = nextValues;
        this.maxNextValueIndex = nextValues.size() - 1;
    }
    @Override
    public long next() {
        if(nextValueIndex > maxNextValueIndex) {
            throw new RandomException("There is no other value available for next() call.");
        }
        long next = nextValues.get(nextValueIndex);
        nextValueIndex++;
        return next;
    }

    @Override
    public RandomGenerator getItself() {
        return this;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
