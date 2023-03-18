
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

import org.nanoboot.powerframework.core.PowerObject;
import org.nanoboot.powerframework.core.exceptions.NotYetImplementedException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Represents map data structure. Values of type T are mapped to String and
 * searched by this String.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * @param <T> the type of items, this map will store.
 */
public class PowerMap<T> extends PowerObject implements Map<String, T> {

    /**
     * List, where are stored items of this map.
     */
    private final SingleLinkedList<KeyValue<T>> list = new SingleLinkedList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(final Object o) {
        for (KeyValue<T>  e : list) {
            if (e.getKey().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsValue(final Object o) {
        for (KeyValue<T>  e : list) {
            if (e.getValue().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(final Object o) {
        for (KeyValue<T> e : list) {
            if (e.getKey().equals(o)) {
                return e.getValue();
            }
        }
        throw new NoSuchElementException("There is no key " + o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T put(final String s, final T t) {
        this.list.add(new KeyValue(s, t));
        return t;
    }
    /**
     * Puts and return this.
     * @param s key
     * @param t value
     * @return this
     */
    public PowerMap<T> putAndReturn(final String s, final T t) {
        put(s, t);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(final Object o) {
        for (KeyValue<T> e : list) {
            if (e.getKey().equals(o)) {
                this.list.remove(e);
                return e.getValue();
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putAll(final Map<? extends String, ? extends T> map) {
        for (Entry<? extends String, ? extends T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            put(key, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        this.list.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> keySet() {
        Set set = new HashSet<String>();
        for (Entry<? extends String, ? extends T> entry : this.entrySet()) {
            String key = entry.getKey();
            set.add(key);
        }
        return set;
    }

    /**
     * {@inheritDoc}
     */
    public List<String> keyList() {
        List<String> list2 = new PowerList<>();
        for (KeyValue e : list) {
            String key = e.getKey();
            list2.add(key);
        }
        return list2;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<T> values() {
        throw new NotYetImplementedException("Not implemented.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entry<String, T>> entrySet() {
        Set<Entry<String, T>> set = new HashSet<>();
        Iterator<KeyValue<T>> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next());
        }
        return set;
    }
////
    /**
     * Iterator.
     * @return iterator
     */
    public Iterator<KeyValue<T>> iterator() {
        return new MapIterator(this.list);
    }

    private class MapIterator implements Iterator<KeyValue<T>> {

        /**
         * Internal list.
         */
        private final SingleLinkedList<KeyValue<T>> list;
        /**
         * Current index.
         */
        private int currentIndex = 0;

        MapIterator(final SingleLinkedList<KeyValue<T>> listIn) {
            this.list = listIn;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public KeyValue<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            KeyValue<T> result = list.get(currentIndex);
            currentIndex++;
            return result;
        }
    }

    /**
     * Updates the dictionary entry with the given key to the given value.
     *
     * @param keyIn key to search
     * @param valueIn value mapped to key will be updated to the valueIn
     *
     * @return this map
     */
    public T replace(
            final String keyIn,
            final T valueIn) {
        this.remove(keyIn);
        this.put(keyIn, valueIn);
        return valueIn;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (KeyValue e: this.list) {
            sb.append(e.getKey()).append("=").append(e.getValue()).append("\n");
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

}
