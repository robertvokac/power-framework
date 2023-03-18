
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
