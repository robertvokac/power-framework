
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

package com.robertvokac.powerframework.db.manager;

import com.robertvokac.powerframework.collections.PowerQueue;

/**
 * Used to execute more sql commands at once to achieve better performance.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class CommandStore {

    private final PowerQueue<String> queue = new PowerQueue<>();

    public CommandStore() {

    }

    public CommandStore(String sqlCommands) {
        String[] commandsArray = sqlCommands.split(";");
        for (String part : commandsArray) {
            add(part);
        }
    }

    /**
     * Adds sql command.
     *
     * @param command
     */
    public void add(String command) {
        this.queue.add(command);
    }

    String getNextCommand() {
        return this.queue.poll();
    }

    boolean hasNextCommand() {
        return !this.queue.isEmpty();
    }

    @Override
    public String toString() {
        return this.queue.toString();
    }

}
