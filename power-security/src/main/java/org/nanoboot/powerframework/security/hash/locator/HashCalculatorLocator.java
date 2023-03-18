
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

package org.nanoboot.powerframework.security.hash.locator;

import org.nanoboot.powerframework.security.hash.api.HashCalculator;
import org.nanoboot.powerframework.security.hash.impl.Sha256HashCalculator;

import java.util.HashMap;
import java.util.Map;
import org.nanoboot.powerframework.security.hash.impl.Sha1HashCalculator;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
