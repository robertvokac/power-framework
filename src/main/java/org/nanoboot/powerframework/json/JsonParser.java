
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

package org.nanoboot.powerframework.json;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.nanoboot.powerframework.PowerRuntimeException;

/**
 * Used to parse String representation of JsonObject or JsonArray to their
 * object representation.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
class JsonParser {

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    JsonParser() {
        //Not meant to be instantiated.
    }

    static char getFirstCharOfTheString(String string) {
        return string.charAt(0);
    }

    static char getLastCharOfTheString(String string) {
        return string.charAt(string.length() - 1);
    }

    protected static String deleteTheCharAtTheStartAndTheEnd(String string) {
        return string.substring(1, string.length() - 1);
    }

    protected static Object parseStringToValue(String stringToParse) {//NOSONAR
        String trimmedStringToParse = stringToParse.trim();
        if ("null".equals(trimmedStringToParse)) {
            return null;
        }
        if ("{".equals(trimmedStringToParse.substring(0, 1))) {
            return new JsonObject(trimmedStringToParse);
        }
        if ("[".equals(trimmedStringToParse.substring(0, 1))) {
            return new JsonArray(trimmedStringToParse);
        }
        if ("true".equals(trimmedStringToParse)) {
            return true;
        }
        if ("false".equals(trimmedStringToParse)) {
            return false;
        }
        if ("\"".equals(trimmedStringToParse.substring(0, 1))) {
            return parseStringToStringOrChar(trimmedStringToParse);
        }
        try {
            return parseStringToIntOrLongOrFloatOrDouble(trimmedStringToParse);
        } catch (Exception e) {
            throw new PowerRuntimeException("Something went wrong. I am not able to parse: \"" + stringToParse + "\". " + e);
        }

    }

    private static Object parseStringToStringOrChar(String stringToParse) {
        String stringWithoutQuotes = deleteTheCharAtTheStartAndTheEnd(stringToParse);
        if (stringWithoutQuotes.length() == 1) {
            return stringWithoutQuotes.charAt(0);
        } else {
            return stringWithoutQuotes;
        }
    }

    private static Object parseStringToIntOrLongOrFloatOrDouble(String stringToParse) {
        String intOrLongPattern = "[0-9]*";
        String floatOrDoublePattern = "([0-9]*)\\.([0-9]*)";

        if (Pattern.matches(floatOrDoublePattern, stringToParse)) {
            return parseStringToFloatOrDouble(stringToParse);
        }
        if (Pattern.matches(intOrLongPattern, stringToParse)) {
            return parseStringToIntOrLong(stringToParse);
        }
        throw new PowerRuntimeException("I am not able to parse: \"" + stringToParse + "\".");
    }

    private static Object parseStringToIntOrLong(String stringToParse) {
        try {
            return Integer.parseInt(stringToParse);
        } catch (Exception e) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, e);
            try {
                return Long.parseLong(stringToParse);
            } catch (Exception e2) {
                Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, e2);
                throw new PowerRuntimeException("The number is too long.");
            }
        }

    }

    private static Object parseStringToFloatOrDouble(String stringToParse) {
        int digitsPrecision = 0;
        for (int i = 0; i < stringToParse.length(); i++) {
            char currentChar = stringToParse.charAt(i);
            if (currentChar == '.') {
                digitsPrecision = stringToParse.length() - 1 - i;
                break;
            }
        }
        if (digitsPrecision > 6) {
            try {
                return Double.parseDouble(stringToParse);
            } catch (Exception e) {//NOSONAR
                throw new PowerRuntimeException("The number is too long.");
            }
        } else {
            return Float.parseFloat(stringToParse);
        }
    }

    protected static ArrayList<Integer> getListOfIndexesOfTheStringWhereCharIsCommaAndNestingIsZero(String collectionsOfValuesOfTheJsonArrayString) {
        int nesting = 0;
        ArrayList<Integer> listOfCommas = new ArrayList<>();
        char currentChar;
        for (int i = 0; i < collectionsOfValuesOfTheJsonArrayString.length(); i++) {
            currentChar = collectionsOfValuesOfTheJsonArrayString.charAt(i);
            if ((currentChar == '\"') && (nesting == 0)) {
                i++;//NOSONAR
                while ('\"' != collectionsOfValuesOfTheJsonArrayString.charAt(i)) {
                    i++;//NOSONAR
                }
            }
            if ((currentChar == ',') && (nesting == 0)) {
                listOfCommas.add(i);
            }
            if (nestingWillBeIncreased(currentChar)) {
                nesting++;
            }
            if (nestingWillBeDecreased(currentChar)) {
                nesting--;
            }
        }
        listOfCommas.add(collectionsOfValuesOfTheJsonArrayString.length());
        return listOfCommas;
    }

    private static boolean nestingWillBeIncreased(char charToCheck) {
        return (charToCheck == '{') || (charToCheck == '[');
    }

    private static boolean nestingWillBeDecreased(char charToCheck) {
        return (charToCheck == '}') || (charToCheck == ']');
    }
}
