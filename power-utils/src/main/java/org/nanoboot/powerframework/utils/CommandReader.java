
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

package org.nanoboot.powerframework.utils;

import org.nanoboot.powerframework.text.AsciiCharacter;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class CommandReader {

    /**
     * Space regexp.
     */
    private static final String SPACE_REGEXP = "\\s+";
    /**
     * Double colon delimiter.
     */
    private static final String SPACE_COLON_COLON_SPACE_DELIMITER = " :: ";
    /**
     * Default current index.
     */
    private static final int DEFAULT_CURRENT_INDEX = -1;
    /**
     * Array.
     */
    private final String[] commands;
    /**
     * Array index.
     */
    private int currentIndex = DEFAULT_CURRENT_INDEX;

    /**
     * Current command.
     */
    private String currentCommand = null;

    /**
     * Constructor.
     *
     * @param stringToSplit string to be split
     */
    public CommandReader(final String stringToSplit) {
        if (stringToSplit == null) {
            throw new UtilsException("stringToSplit must not be null.");
        }
        commands = stringToSplit.split(SPACE_REGEXP);
    }

    /**
     * Returns size of the split commands.
     * @return size of the split commands
     */
    public int size() {
        return commands.length;
    }

    /**
     * Returns size of the split commands.
     * @return size of the split commands
     */
    public int isEmpty() {
        return commands.length;
    }
    /**
     * Returns current command.
     *
     * @return current command
     */
    public String current() {
        return currentCommand;
    }

    /**
     * Increments the pointer to the current word.
     */
    private void incrementCurrentIndex() {
        if (!hasNext()) {
            throw new UtilsException("CommandReader has no next command.");
        }
        currentIndex++;
    }
    /**
     * Checks, if there is a next command.
     * @return true, if there is a next command, otherwise false
     */
    public boolean hasNext() {
        int nextIndex = currentIndex + 1;
        return isIndexValid(nextIndex);
    }

    /**
     * Checks, if the index is valid.
     * @param index index to be checked
     * @return true, if the index is at least zero and
     * less than the size, otherwise false
     */
    private boolean isIndexValid(final int index) {
        return index >= 0 && index < size();
    }

    /**
     * Returns next command.
     *
     * @return next command
     */
    public String next() {
        incrementCurrentIndex();
        this.currentCommand = commands[currentIndex];
        return current();
    }

    /**
     * Almost same as next().
     * The only difference is, that the current number is not updated.
     * @return next command, if exists, otherwise an exception is thrown.
     */
    public String nextPreview() {
        int nextNumber = currentNumber() + 1;
        return getCommandByNumber(nextNumber);
    }

    /**
     * Converts index to number. (one is added)
     * @param index index (starting from 0)
     * @return number
     */
    private int convertIndexToNumber(final int index) {
        return index + 1;
    }
    /**
     * Converts number to index. (one is removed)
     * @param number number (starting from 1)
     * @return number
     */
    private int convertNumberToIndex(final int number) {
        return number - 1;
    }
    /**
     * Returns command by number.
     * @param number number
     * @return command
     */
    public String getCommandByNumber(final int number) {
        if (!isNumberValid(number)) {
            throw new UtilsException("Number " + number + " is not valid.");
        }
        int index = convertNumberToIndex(number);
        return this.commands[index];
    }
    /**
     * Resets this command reader.
     */
    public void reset() {
        this.currentIndex = DEFAULT_CURRENT_INDEX;
        this.currentCommand = null;
    }
    /**
     * Checks, if a number is valid.
     * @param number number
     * @return true, if the number is valid, otherwise false
     */
    public boolean isNumberValid(final int number) {
        int index = convertNumberToIndex(number);
        return isIndexValid(index);
    }
    /**
     * Returns next as int.
     * @return next as int
     */
    public int nextAsInt() {
        return Integer.parseInt(next());
    }

    /**
     * Returns current number.
     * @return current number
     */
    public int currentNumber() {
        return convertIndexToNumber(currentIndex);
    }

    /**
     * Creates String array representing this CommandReader.
     * @return String array
     */
    public String[] toArray() {
        String[] returnArray = new String[this.commands.length];
        int index = 0;
        for (String e: this.commands) {
            returnArray[index] = e;
            index++;
        }
        return returnArray;
    }
    /**
     * Creates debugging string.
     * @return string representation
     * of the command reader for debugging purposes
     */
    public String toStringForDebuggingPurposes() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commands.length; i++) {
            String element = commands[i];
            if (i == this.currentIndex) {
                stringBuilder.append('[');
            }
            stringBuilder.append(element);
            if (i == this.currentIndex) {
                stringBuilder.append(']');
            }
            if (i != (commands.length - 1)) {
                stringBuilder.append(AsciiCharacter.SPACE.toChar());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : this.commands) {
            stringBuilder
                    .append(element)
                    .append(SPACE_COLON_COLON_SPACE_DELIMITER);
        }
        return stringBuilder.toString();
    }
}
