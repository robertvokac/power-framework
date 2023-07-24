///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2023-2023 the original author or authors.
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
package org.nanoboot.powerframework.io.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author robertvokac
 */
public class FileUtils {

    private FileUtils() {
        //Not meant to be instantiated.
    }

    public static String readTextFromFile(File file) {
        if (!file.exists()) {
            return "";
        }
        try {
            return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        } catch (IOException ex) {
            throw new RuntimeException("Reading file failed: " + file.getName(), ex);
        }
    }

    public static List<String> readLinesFromFile(File file) {
        return readLinesFromFile(file, false);
    }

    public static List<String> readLinesFromFile(File file, boolean skipEmptyLines) {
        String content = readTextFromFile(file);
        String[] lines = content.split("\\r?\\n|\\r");
        return Arrays.stream(lines).filter(l -> skipEmptyLines ? !l.trim().isEmpty() : true).collect(
                Collectors.toList());
    }

    public static void writeTextToFile(String text, File file) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Writing to file failed: " + file.getName(), ex);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(text);
        printWriter.close();
    }

}
