
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

package com.robertvokac.powerframework.utils;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class NamingConventionConvertorTest {

    private static final String DATABASE_STRING = "MY_BEST_FRIEND";
    private static final String HUMAN_STRING = "my best friend";
    private static final String JAVA_STRING = "myBestFriend";
    private static final String UNKNOWN_STRING = "my-best-friend";
    @Test
    public void convert_database_human() {
        //prepare
        String input = DATABASE_STRING;
        String expected = HUMAN_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.DATABASE;
        NamingConvention outputNamingConvention = NamingConvention.HUMAN;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
    @Test
    public void convert_database_java() {
        //prepare
        String input = DATABASE_STRING;
        String expected = JAVA_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.DATABASE;
        NamingConvention outputNamingConvention = NamingConvention.JAVA_FIELD;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
    @Test
    public void convert_human_database() {
        //prepare
        String input = HUMAN_STRING;
        String expected = DATABASE_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.HUMAN;
        NamingConvention outputNamingConvention = NamingConvention.DATABASE;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
    @Test
    public void convert_human_java() {
        //prepare
        String input = HUMAN_STRING;
        String expected = JAVA_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.HUMAN;
        NamingConvention outputNamingConvention = NamingConvention.JAVA_FIELD;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
    @Test
    public void convert_java_database() {
        //prepare
        String input = JAVA_STRING;
        String expected = DATABASE_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.JAVA_FIELD;
        NamingConvention outputNamingConvention = NamingConvention.DATABASE;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
    @Test
    public void convert_java_human() {
        //prepare
        String input = JAVA_STRING;
        String expected = HUMAN_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.JAVA_FIELD;
        NamingConvention outputNamingConvention = NamingConvention.HUMAN;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }

    @Test
    public void convert_database_database() {
        //prepare
        String input = DATABASE_STRING;
        String expected = DATABASE_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.DATABASE;
        NamingConvention outputNamingConvention = NamingConvention.DATABASE;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }

    @Test
    public void convert_human_human() {
        //prepare
        String input = HUMAN_STRING;
        String expected = HUMAN_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.HUMAN;
        NamingConvention outputNamingConvention = NamingConvention.HUMAN;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }

    @Test
    public void convert_java_java() {
        //prepare
        String input = JAVA_STRING;
        String expected = JAVA_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.JAVA_FIELD;
        NamingConvention outputNamingConvention = NamingConvention.JAVA_FIELD;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }

    @Test(expected = UtilsException.class)
    public void convert_java_unknwon() {
        //prepare
        String input = JAVA_STRING;
        String expected = UNKNOWN_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.JAVA_FIELD;
        NamingConvention outputNamingConvention = NamingConvention.UNKNOWN;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }

    @Test(expected = UtilsException.class)
    public void convert_exception() {
        //prepare
        String input = JAVA_STRING;
        String expected = JAVA_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.JAVA_FIELD;
        NamingConvention outputNamingConvention = null;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
    @Test(expected = UtilsException.class)
    public void convert_invalidArguments_exception() {
        //prepare
        String input = HUMAN_STRING;
        String expected = DATABASE_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.JAVA_FIELD;
        NamingConvention outputNamingConvention = NamingConvention.DATABASE;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }

    @Test
    public void detectNamingConvention() {
        assertEquals(NamingConvention.DATABASE, NamingConventionConvertor.detectNamingConvention("ABC_DEF_GHI"));
        assertEquals(NamingConvention.HUMAN, NamingConventionConvertor.detectNamingConvention("abc def ghi"));
        assertEquals(NamingConvention.JAVA_FIELD, NamingConventionConvertor.detectNamingConvention("abcDefGhi"));
    }
    @Test(expected = UtilsException.class)
    public void detectNamingConvention2() {
        assertEquals(NamingConvention.DATABASE, NamingConventionConvertor.detectNamingConvention("ABC_DEF GHI"));
    }

    @Test(expected = UtilsException.class)
    public void convert_unknwon_java() {
        //prepare
        String input = UNKNOWN_STRING;
        String expected = JAVA_STRING;
        String returned;
        NamingConvention inputNamingConvention = NamingConvention.UNKNOWN;
        NamingConvention outputNamingConvention = NamingConvention.JAVA_FIELD;
        //execute
        returned = NamingConventionConvertor.convert(input, inputNamingConvention, outputNamingConvention);
        //assert
        assertEquals(expected, returned);
    }
}
