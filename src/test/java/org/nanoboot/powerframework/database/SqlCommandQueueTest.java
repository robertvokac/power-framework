
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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class SqlCommandQueueTest {

    public SqlCommandQueueTest() {
    }

    /**
     * Test of add method, of class SqlCommandQueue.
     */
    @Test
    public void testAdd() {
        //arrange
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        String expectedString = "insert into customers values ('Jack','Black')";
        String returnedString;
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        returnedString = sqlCommandQueue.loadNextCommand();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of loadNextCommand method, of class SqlCommandQueue.
     */
    @Test
    public void testLoadNextCommand() {
        //arrange
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        String expectedString = "insert into customers values ('Susan','White')";
        String returnedString;
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        sqlCommandQueue.loadNextCommand();
        returnedString = sqlCommandQueue.loadNextCommand();
        //assert
        assertEquals(expectedString, returnedString);
    }

    /**
     * Test of isThereANextCommand method, of class SqlCommandQueue.
     */
    @Test
    public void testIsThereANextCommand() {
        //arrange
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        sqlCommandQueue.loadNextCommand();
        //assert
        assertTrue(sqlCommandQueue.isThereANextCommand());
    }

    /**
     * Test of isThereANextCommand method, of class SqlCommandQueue.
     */
    @Test
    public void testIsThereANextCommand2() {
        //arrange
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        sqlCommandQueue.loadNextCommand();
        sqlCommandQueue.loadNextCommand();
        //assert
        assertFalse(sqlCommandQueue.isThereANextCommand());
    }

    /**
     * Test of toString method, of class SqlCommandQueue.
     */
    @Test
    public void testToString() {
        //arrange
        SqlCommandQueue sqlCommandQueue = new SqlCommandQueue();
        String expectedString = "insert into customers values ('Jack','Black'), insert into customers values ('Susan','White'), ";
        String returnedString;
        //act
        sqlCommandQueue.add("insert into customers values ('Jack','Black')");
        sqlCommandQueue.add("insert into customers values ('Susan','White')");
        returnedString = sqlCommandQueue.toString();
        //assert
        assertEquals(expectedString, returnedString);

    }

}
