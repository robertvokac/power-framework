
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

import org.nanoboot.powerframework.random.RandomException;
import org.nanoboot.powerframework.random.generators.linearcongruent.CPlusPlus11LinearCongruentGenerator;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class W5GeneratorsProcessorImplTest {

    private W5GeneratorsProcessorImpl p;
    @Before
    public void setup() {
        p = new W5GeneratorsProcessorImpl();
    }
    @Test(expected = RandomException.class)
    public void next() {
        p.next(null);
    }
    @Test(expected = RandomException.class)
    public void next2() {
        p.next(
                new CPlusPlus11LinearCongruentGenerator(20),
                new CPlusPlus11LinearCongruentGenerator(30)
        );
    }
}
