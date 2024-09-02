
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

package org.nanoboot.powerframework.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nanoboot.powerframework.utils.StringUtils;

import java.util.Map;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

@AllArgsConstructor
public class KeyValue<V> implements Map.Entry<String, V> {
    /**
     * Key used to identify this node, if node with this key is wanted.
     */
    @Getter
    private String key = StringUtils.EMPTY_STRING;
    /**
     * The value this node is holding.
     */
    @Getter
    private V value;
    /**
     * Setter for key.
     * @param k key
     * @return the new key
     */
    public String setKey(final String k) {
        this.key = k;
        return this.key;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public V setValue(final V v) {
        this.value = v;
        return this.value;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return key + "=" + value;
    }
}
