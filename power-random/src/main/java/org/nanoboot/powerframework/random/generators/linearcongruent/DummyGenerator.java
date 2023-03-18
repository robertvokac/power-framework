
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

import org.nanoboot.powerframework.random.RandomException;
import org.nanoboot.powerframework.random.generators.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a seed. Uses linear congruential function.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
