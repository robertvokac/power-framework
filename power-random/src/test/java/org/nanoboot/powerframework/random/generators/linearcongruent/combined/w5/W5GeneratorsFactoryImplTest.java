
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
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class W5GeneratorsFactoryImplTest {

    private W5GeneratorsFactoryImpl g;

    @Test(expected = RandomException.class)
    public void constructor2() {
        new W5GeneratorsFactoryImpl(null);
    }
    @Test(expected = RandomException.class)
    public void constructor3() {
        new W5GeneratorsFactoryImpl(new long[] {1,2,3,4,5,6,7});
    }

    @Test
    public void getSubGenerators() {
        W5GeneratorsFactoryImpl w5GeneratorsFactory = new W5GeneratorsFactoryImpl(new long[] {1l,2l,3l,4l,5l,6l,7l,8l});
        CPlusPlus11LinearCongruentGenerator[] array = w5GeneratorsFactory.getSubGenerators();
        StringBuilder sb = new StringBuilder();
        for(CPlusPlus11LinearCongruentGenerator e : array) {
            sb.append(e.nextInt(0,9)).append(",");
            sb.append(e.nextInt(0,9)).append(",");
            sb.append(e.nextInt(0,9)).append(",");
        }
        assertEquals("4,8,3,0,3,1,0,0,7,", sb.toString());
    }
}
