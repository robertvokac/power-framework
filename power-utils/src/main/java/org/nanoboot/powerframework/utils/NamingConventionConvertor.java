
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

import java.util.ArrayList;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class NamingConventionConvertor {

    /**
     * Delimiter for databases.
     */
    private static final String DATABASE_DELIMITER =
            AsciiCharacter.UNDERSCORE.asString();
    /**
     * Delimiter for humans.
     */
    private static final String HUMAN_DELIMITER =
            AsciiCharacter.SPACE.asString();

    /**
     * @param name                   name to convert
     * @param inputNamingConvention  input naming convention
     * @param outputNamingConvention output naming convention
     * @return converted name
     */
    public static String convert(
            final String name,
            final NamingConvention inputNamingConvention,
            final NamingConvention outputNamingConvention) {
        System.out.println("Going to convert name=" + name + " in=" + inputNamingConvention + " out=" + outputNamingConvention);
        check(name, inputNamingConvention);
        String[] array = convertToArray(name, inputNamingConvention);
        StringBuilder stringBuilder = new StringBuilder();

        if (outputNamingConvention == null) {
            throw new UtilsException("Output naming convention is null.");
        }
        switch (outputNamingConvention) {
            case JAVA:
                return convertToJavaField(array, stringBuilder);
            case JAVA_FIELD:
                return convertToJavaField(array, stringBuilder);
            case JAVA_CLASS:
                return convertToJavaClass(array, stringBuilder);
            case DATABASE:
                return convertToDatabase(array, stringBuilder);
            case HUMAN:
                return convertToHuman(array, stringBuilder);
            default:
                throw new UtilsException(
                        "Unknown NamingConvention" + inputNamingConvention);
        }

    }


    /**
     * Checks name validity.
     *
     * @param name                  name to be checked
     * @param inputNamingConvention input naming convention
     */
    private static void check(final String name,
                              final NamingConvention inputNamingConvention) {
        NamingConvention detectedNamingConvention = detectNamingConvention(name);
        boolean valid = detectedNamingConvention == inputNamingConvention;

        if (!valid) {
            if (inputNamingConvention == NamingConvention.JAVA && detectedNamingConvention == NamingConvention.JAVA_FIELD) {
                valid = true;
            }
        }
        if (!valid) {
            String msg = "Wrong name and input naming convention combination: name="
                    + name + ", in=" + inputNamingConvention + ", but detected is=" + detectedNamingConvention;
            throw new UtilsException(msg);
        }
    }

    /**
     * Detects naming convention.
     *
     * @param name name to detect
     * @return detected naming convention
     */
    public static NamingConvention detectNamingConvention(
            final String name) {
        boolean databasePredicate = name.contains(DATABASE_DELIMITER) || stringHasAllUpperCase(name);
        boolean humanPredicate = name.contains(HUMAN_DELIMITER);
        if (databasePredicate && !humanPredicate) {
            return NamingConvention.DATABASE;
        }
        if (!databasePredicate && humanPredicate) {
            return NamingConvention.HUMAN;
        }
        if (databasePredicate /*&& humanPredicate*/) {
            String msg = "The name contain database and also human delimiters.";
            throw new UtilsException(msg);
        }
        return Character.isUpperCase(name.charAt(0)) ? NamingConvention.JAVA_CLASS : NamingConvention.JAVA_FIELD;
    }

    private static boolean stringHasAllUpperCase(final String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Converts the Strings to Human representation.
     *
     * @param array         array
     * @param stringBuilder stringBuilder
     * @return human words
     */
    private static String convertToHuman(final String[] array,
                                         final StringBuilder stringBuilder) {
        for (String element : array) {
            stringBuilder.append(element.toLowerCase()).append(HUMAN_DELIMITER);
        }
        String tempString = stringBuilder.toString();
        return tempString.substring(0, tempString.length() - 1);
    }

    /**
     * Converts the Strings to database representation.
     *
     * @param array         array
     * @param stringBuilder stringBuilder
     * @return database words
     */
    private static String convertToDatabase(final String[] array,
                                            final StringBuilder stringBuilder) {
        for (String element : array) {
            stringBuilder
                    .append(element.toUpperCase()).append(DATABASE_DELIMITER);
        }
        String tempString = stringBuilder.toString();
        return tempString.substring(0, tempString.length() - 1);
    }

    /**
     * Converts the Strings to Java representation.
     *
     * @param array         array
     * @param stringBuilder stringBuilder
     * @return Java words
     */
    private static String convertToJavaField(final String[] array,
                                             final StringBuilder stringBuilder) {
        String string = convertToJavaClass(array, stringBuilder);
        return Character.toLowerCase(
                string.charAt(0)) + string.substring(1);

    }

    private static String convertToJavaClass(String[] array, StringBuilder stringBuilder) {
        for (String element : array) {
            if (element.length() != 0) {
                stringBuilder.append(Character.toUpperCase(element.charAt(0)));
                stringBuilder.append(element.substring(1, element.length()));
            }
        }
        String tempString = stringBuilder.toString();
        return tempString;
    }

    /**
     * Converts input string to array, all characters are changed to lower case.
     *
     * @param name                  name to convert
     * @param inputNamingConvention input naming convention
     * @return String array
     */
    private static String[] convertToArray(
            final String name,
            final NamingConvention inputNamingConvention) {

        switch (inputNamingConvention) {
            case DATABASE:
                return name.toLowerCase().split(DATABASE_DELIMITER);
            case JAVA:
                return getArrayFromJavaConvention(name);
            case JAVA_FIELD:
                return getArrayFromJavaConvention(name);
            case JAVA_CLASS:
                return getArrayFromJavaConvention(name);
            case HUMAN:
                return name.toLowerCase().split(HUMAN_DELIMITER);
            default:
                String msg = "Unknown NamingConvention" + inputNamingConvention;
                throw new UtilsException(msg);
        }
    }

    /**
     * Creates array from Java convention.
     *
     * @param name name
     * @return String array
     */
    private static String[] getArrayFromJavaConvention(final String name) {
        String finalName = name;
        if (Character.isUpperCase(finalName.charAt(0))) {
            finalName = finalName.substring(0, 1).toLowerCase() + finalName.substring(1);
        }

        ArrayList<Integer> upperCharPositions = getIndexesOfUpperChars(finalName);
        String[] result = new String[upperCharPositions.size() + 1];
        int startIndex;
        int endIndex = 0;
        int resultIndex = 0;
        for (int element : upperCharPositions) {
            if (element == 0) {
                continue;
            }
            startIndex = endIndex;
            endIndex = element;
            result[resultIndex] = finalName
                    .substring(startIndex, endIndex).toLowerCase();
            resultIndex++;
        }
        startIndex = endIndex;
        endIndex = finalName.length();
        result[resultIndex] = finalName.substring(startIndex, endIndex);

        return result;
    }

    /**
     * Returns indexes of all upper characters of the String.
     *
     * @param name name
     * @return String array with indexes
     */
    private static ArrayList<Integer> getIndexesOfUpperChars(
            final String name) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (Character.isUpperCase(ch)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Constructor.
     * <p>
     * Not meant to be instantiated.
     */
    private NamingConventionConvertor() {
        //Not meant to be instantiated.
    }
}
