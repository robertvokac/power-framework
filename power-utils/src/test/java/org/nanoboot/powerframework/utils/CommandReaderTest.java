
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

package org.nanoboot.powerframework.utils;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class CommandReaderTest {

    @Test(expected = UtilsException.class)
    public void constructor_exception() {
        //prepare
        CommandReader commandReader = new CommandReader(null);
        //execute
        //assert
    }

    @Test
    public void size() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertEquals(5, commandReader.size());
    }

    @Test
    public void current() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertNull(commandReader.current());
        commandReader.next();
        assertEquals("A", commandReader.current());
        commandReader.next();
        assertEquals("B", commandReader.current());
        commandReader.nextPreview();
        assertEquals("B", commandReader.current());
    }

    @Test
    public void hasNext() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertTrue(commandReader.hasNext());
        commandReader.next();
        assertTrue(commandReader.hasNext());
        commandReader.next();
        assertTrue(commandReader.hasNext());
        commandReader.next();
        assertTrue(commandReader.hasNext());
        commandReader.next();
        assertTrue(commandReader.hasNext());
        commandReader.next();
        assertFalse(commandReader.hasNext());
    }

    @Test
    public void next() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertEquals("A", commandReader.next());
        assertEquals("B", commandReader.next());
        assertEquals("C", commandReader.next());
        assertEquals("D", commandReader.nextPreview());
        assertEquals("D", commandReader.next());
        assertEquals("E", commandReader.next());
        assertFalse(commandReader.hasNext());
    }
    @Test(expected = UtilsException.class)
    public void next_exception() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        commandReader.next();
        commandReader.next();
        commandReader.next();
        commandReader.next();
        commandReader.next();
        commandReader.next();
    }

    @Test
    public void nextPreview() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertEquals("A", commandReader.next());
        assertEquals("B", commandReader.nextPreview());
        assertEquals("B", commandReader.nextPreview());
        assertEquals("B", commandReader.nextPreview());
        assertEquals("B", commandReader.nextPreview());
        assertEquals("B", commandReader.next());
        assertEquals("C", commandReader.next());
        assertEquals("D", commandReader.next());
        assertEquals("E", commandReader.nextPreview());
        assertEquals("E", commandReader.nextPreview());
        assertEquals("E", commandReader.nextPreview());
        assertEquals("E", commandReader.next());
    }

    @Test
    public void getCommandByNumber() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertEquals("A", commandReader.getCommandByNumber(1));
        assertEquals("B", commandReader.getCommandByNumber(2));
        assertEquals("C", commandReader.getCommandByNumber(3));
        assertEquals("D", commandReader.getCommandByNumber(4));
        assertEquals("E", commandReader.getCommandByNumber(5));
    }

    @Test(expected = UtilsException.class)
    public void getCommandByNumber_exception1() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        commandReader.getCommandByNumber(0);
    }

    @Test(expected = UtilsException.class)
    public void getCommandByNumber_exception2() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        commandReader.getCommandByNumber(6);
    }

    @Test
    public void reset() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        commandReader.next();
        commandReader.next();
        commandReader.next();
        commandReader.reset();
        //assert
        assertEquals("A", commandReader.next());
        assertEquals("B", commandReader.next());
        assertEquals("C", commandReader.next());
        commandReader.reset();
        assertEquals("A", commandReader.next());
        assertEquals("B", commandReader.next());
    }

    @Test
    public void isNumberValid() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        for(int number = -5; number < 20; number++) {
            boolean numberIsValid = commandReader.isNumberValid(number);
            if (number >= 1 && number <= 5) {
                assertTrue(numberIsValid);
            } else {
                assertFalse(numberIsValid);
            }
        }
    }

    @Test
    public void nextAsInt() {
        //prepare
        CommandReader commandReader = new CommandReader("A B 4 D E");
        //execute
        commandReader.next();
        commandReader.next();
        //assert
        assertEquals(4, commandReader.nextAsInt());
    }

    @Test
    public void currentNumber() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertEquals(0, commandReader.currentNumber());
        commandReader.next();
        assertEquals(1, commandReader.currentNumber());
        commandReader.next();
        assertEquals(2, commandReader.currentNumber());
        commandReader.next();
        assertEquals(3, commandReader.currentNumber());
        commandReader.next();
        assertEquals(4, commandReader.currentNumber());
        commandReader.next();
        assertEquals(5, commandReader.currentNumber());
    }

    @Test
    public void toArray() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        //assert
        assertArrayEquals((new String[] {"A", "B", "C", "D", "E"}), commandReader.toArray());
    }

    @Test
    public void toStringForDebuggingPurposes() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        commandReader.next();
        commandReader.next();
        commandReader.next();
        commandReader.next();
        //assert
        assertEquals("A B C [D] E", commandReader.toStringForDebuggingPurposes());
    }

    @Test
    public void testToString() {
        //prepare
        CommandReader commandReader = new CommandReader("A B C D E");
        //execute
        commandReader.next();
        commandReader.next();
        commandReader.next();
        commandReader.next();
        //assert
        assertEquals("A :: B :: C :: D :: E :: ", commandReader.toString());
    }
}
