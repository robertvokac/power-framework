
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

package org.nanoboot.powerframework.random.internal;

import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.text.CharacterType;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class RandomTextUtilsTest {

    @Test
    public void nextChar() {
        RandomGenerator rg = RandomGenerator.getDefaultImplStatic();
        char ch = RandomTextUtils.nextChar(rg, null);
        assertTrue(Character.isDigit(ch) || Character.isUpperCase(ch) || Character.isLowerCase(ch));
        ch = RandomTextUtils.nextChar(rg, new CharacterType[] {});
        assertTrue(Character.isDigit(ch) || Character.isUpperCase(ch) || Character.isLowerCase(ch));
        ch = RandomTextUtils.nextChar(rg, CharacterType.LOWER_LETTER);
        assertTrue(Character.isLowerCase(ch));
        ch = RandomTextUtils.nextChar(rg, CharacterType.LOWER_LETTER, CharacterType.NUMBER);
        assertTrue(Character.isDigit(ch) || Character.isLowerCase(ch));

    }
}
