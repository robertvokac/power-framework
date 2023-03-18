
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
