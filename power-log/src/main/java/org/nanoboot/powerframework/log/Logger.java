
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

package org.nanoboot.powerframework.log;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Logger {

    private static Level level = Level.OFF;
    private static Target target = Target.NOTARGET;
    //0 for no limit
    private static long maximumLogFileSizeInBytes = 0;
    private static boolean logOkayClasses = false;
    private static long rowNumber = 0;

    /**
     *
     * @param classValue
     *
     * @return
     */
    public static Logger getLogger(Class<?> classValue) {
        return new Logger(classValue);
    }

    /**
     *
     * @param levelArg
     */
    public static void setLevel(Level levelArg) {
        level = levelArg;
    }

    /**
     *
     * @return
     */
    public static Level getLevel() {
        return level;
    }

    /**
     *
     * @param targetArg
     */
    public static void setTarget(Target targetArg) {
        target = targetArg;
    }

    /**
     *
     * @return
     */
    public static Target getTarget() {
        return target;
    }

    /**
     *
     * @return
     */
    public static long getMaximumLogFileSizeInBytes() {
        return maximumLogFileSizeInBytes;
    }

//    /**
//     *
//     * @param digitalInformationUnit
//     * @param value
//     */
//    public static void setMaximumLogFileSize(
//            DigitalInformationUnit digitalInformationUnit,
//            long value) {
//        maximumLogFileSizeInBytes = digitalInformationUnit.getBytes() * value;
//    }

    /**
     *
     * @return
     */
    public static boolean isLogOkayClasses() {
        return logOkayClasses;
    }

    /**
     *
     * @param logOkayClasses
     */
    public static void setLogOkayClasses(boolean logOkayClasses) {
        Logger.logOkayClasses = logOkayClasses;
    }

    private static boolean isLevelWanted(Level levelArg) {
        if(Logger.getLevel().getVerbiageIndex() == 0) {
            return false;
        }
        return levelArg.getVerbiageIndex() <= Logger.getLevel().getVerbiageIndex();
    }
    private final String className;
    private final boolean isOkayClass;

    private Logger(Class<?> classValue) {
        this.className = classValue.getName();
        isOkayClass = className.startsWith("org.nanoboot.powerframework.");
    }

    /**
     *
     * @param object
     * @param message
     */
    public void fatal(Object object,
            String message) {
        log(object, Level.FATAL, message);
    }

    /**
     *
     * @param object
     * @param message
     */
    public void error(Object object,
            String message) {
        log(object, Level.ERROR, message);
    }

    /**
     *
     * @param object
     * @param message
     */
    public void warn(Object object,
            String message) {
        log(object, Level.WARN, message);
    }

    /**
     *
     * @param object
     * @param message
     */
    public void info(Object object,
            String message) {
        log(object, Level.INFO, message);
    }

    /**
     *
     * @param object
     * @param message
     */
    public void debug(Object object,
            String message) {
        log(object, Level.DEBUG, message);
    }

    /**
     *
     * @param object
     * @param message
     */
    public void trace(Object object,
            String message) {
        log(object, Level.TRACE, message);
    }

    /**
     *
     * @param object
     * @param methodName
     * @param typeValue
     */
    public void traceStartOfMethod(Object object,
            String methodName,
            Object... typeValue) {
        trace(object, MethodStartMessageCreator.createMethodStartMessage(methodName, typeValue));
    }

    /**
     *
     * @param object
     * @param methodName
     */
    public void traceStartOfMethod(Object object,
            String methodName) {
        trace(object, MethodStartMessageCreator.createMethodStartMessage(methodName));
    }

    /**
     *
     * @param object
     * @param level
     * @param message
     */
    public void log(Object object,
            Level level,
            String message) {
        if((!(isLogOkayClasses())) && this.isOkayClass()) {
            return;
        }
//        if(PseudoRandomGenerator.getGlobalInstance().getInt(0, 3)>1){return;}
        if(getTarget() == Target.NOTARGET || !isLevelWanted(level)) {
            return;
        }

        String row = LogRowCreator.createRow(++rowNumber, object, level, getClassName(), message);
        if(target == Target.CONSOLE || target == Target.CONSOLEANDFILES) {
            if(level.getVerbiageIndex() <= 2) {
                System.err.println(row);
            } else {
                System.out.println(row);

            }
        }

        if(target == Target.FILES || target == Target.CONSOLEANDFILES) {
            logStringBuilder.append(row).append("\n");
            final String LOGGINGFILENAME = "log.txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOGGINGFILENAME, true))) {
                bw.write(row);
                bw.newLine();
                bw.flush();
            } catch (Exception e) {
                System.err.println("Can't write next log row to file " + LOGGINGFILENAME);
            }

            if(level.getVerbiageIndex() <= 4) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("info_" + LOGGINGFILENAME, true))) {
                    bw.write(row);
                    bw.newLine();
                    bw.flush();
                } catch (Exception e) {
                    System.err.println("Can't write next log row to file " + "info_" + LOGGINGFILENAME);
                }
            }
//            TODO
//            write to files
        }
    }

    private static StringBuilder logStringBuilder = new StringBuilder();

    public static void saveToFile() {
        final String LOGGINGFILENAME = "log.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOGGINGFILENAME, true))) {
            bw.write(logStringBuilder.toString());
            logStringBuilder = new StringBuilder();
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            System.err.println("Can't write next log row to file " + LOGGINGFILENAME);
        }
    }

    private String getClassName() {
        return this.className;
    }

    /**
     *
     * @return
     */
    public boolean isOkayClass() {
        return isOkayClass;
    }
}
