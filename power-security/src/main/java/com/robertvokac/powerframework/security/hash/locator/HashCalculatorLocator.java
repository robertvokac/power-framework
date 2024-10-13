
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

package com.robertvokac.powerframework.security.hash.locator;

import com.robertvokac.powerframework.security.hash.api.HashCalculator;
import com.robertvokac.powerframework.security.hash.impl.Sha256HashCalculator;

import java.util.HashMap;
import java.util.Map;
import com.robertvokac.powerframework.security.hash.impl.Sha1HashCalculator;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class HashCalculatorLocator {

    private static final Map<String, HashCalculator> map = new HashMap<>();

    public static HashCalculator locate(String hashImplname) {
        return locate(HashImpl.valueOf(hashImplname));
    }

    public static HashCalculator locate(HashImpl hashImpl) {
        String name = hashImpl.getName();
        if (!map.containsKey(name)) {
            switch (name) {
                case "SHA-1":
                    map.put(name, new Sha1HashCalculator());
                    break;
                case "SHA-256":
                    map.put(name, new Sha256HashCalculator());
                    break;
                default: {
                    //nothing to do
                }
            }
        }
        HashCalculator hashCalculator = map.get(name);
        if (hashCalculator == null) {
            String msg = "HashCalculator with name " + name + " was not found.";
            throw new SecurityException(msg);
        }
        return hashCalculator;
    }
}
