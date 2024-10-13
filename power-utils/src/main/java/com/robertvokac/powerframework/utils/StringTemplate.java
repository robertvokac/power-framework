
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

package com.robertvokac.powerframework.utils;

/**
 *
 * @author robertvokac
 */

import java.util.HashMap;
import java.util.Map;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class StringTemplate {
    public static final String VAR_START = "{{{{";
    public static final String VAR_END = "}}}}";
    private final String template;

    public StringTemplate(String template) {
        this.template = template;
    }
    public String apply(Map<String, String> map) {
        String result = template;
        for(String key:map.keySet()) {
            String var = VAR_START + key + VAR_END;
            String value = map.get(key);
            result = result.replace(var, value);
        }
        if(result.contains(VAR_START)) {
            throw new UtilsException("Template \"" + result + "\"still contains \"" + VAR_START + "\".");
        }

        if(result.contains(VAR_END)) {
            throw new UtilsException("Template \"" + result + "\"still contains \"" + VAR_END + "\".");
        }
        return result;
    }
    public Map<String, String> createEmptyMap() {
        return new HashMap<>();
    }
}

 
