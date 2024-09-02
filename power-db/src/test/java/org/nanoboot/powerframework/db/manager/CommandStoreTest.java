
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

package org.nanoboot.powerframework.db.manager;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

@Ignore
public class CommandStoreTest {

    public CommandStoreTest() {
    }

    /**
     * Test of add method, of class SqlCommandQueue.
     */
    @Test
    public void testAdd() {
        //arrange
        CommandStore sqlCommandQueue = new CommandStore();
        String expectedString = "insert into customers values ('Jack','Black')";
        String returnedString;
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        returnedString = sqlCommandQueue.getNextCommand();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of loadNextCommand method, of class SqlCommandQueue.
     */
    @Test
    public void testLoadNextCommand() {
        //arrange
        CommandStore sqlCommandQueue = new CommandStore();
        String expectedString = "insert into customers values ('Susan','White')";
        String returnedString;
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        sqlCommandQueue.getNextCommand();
        returnedString = sqlCommandQueue.getNextCommand();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of isThereANextCommand method, of class SqlCommandQueue.
     */
    @Test
    public void testIsThereANextCommand() {
        //arrange
        CommandStore sqlCommandQueue = new CommandStore();
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        sqlCommandQueue.getNextCommand();
        //assert
        assertTrue(sqlCommandQueue.hasNextCommand());
    }

    /**
     * Test of isThereANextCommand method, of class SqlCommandQueue.
     */
    @Test
    public void testIsThereANextCommand2() {
        //arrange
        CommandStore sqlCommandQueue = new CommandStore();
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        sqlCommandQueue.getNextCommand();
        sqlCommandQueue.getNextCommand();
        //assert
        assertFalse(sqlCommandQueue.hasNextCommand());
    }

    /**
     * Test of toString method, of class SqlCommandQueue.
     */
    @Test
    public void testToString() {
        //arrange
        CommandStore sqlCommandQueue = new CommandStore();
        String expectedString = "insert into customers values ('Jack','Black'), insert into customers values ('Susan','White')";
        String returnedString;
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        returnedString = sqlCommandQueue.toString();
        //assert
        assertEquals(expectedString, returnedString);

    }

}
