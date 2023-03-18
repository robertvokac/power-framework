
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

package org.nanoboot.powerframework.database;

import org.nanoboot.powerframework.collections.Queue;

/**
 * Used to execute more sql commands at once to achieve better performance.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class SqlCommandQueue {

    private final Queue<String> queue = new Queue<>();

    /**
     * Adds sql command.
     *
     * @param command
     */
    public void add(String command) {
        this.queue.enqueue(command);
    }

    String loadNextCommand() {
        return this.queue.dequeue();
    }

    boolean isThereANextCommand() {
        return !this.queue.isEmpty();
    }

    @Override
    public String toString() {
        return this.queue.toString();
    }

}
