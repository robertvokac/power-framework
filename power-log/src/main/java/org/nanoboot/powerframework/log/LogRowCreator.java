
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

import org.nanoboot.powerframework.time.utils.LocalSettings;
import org.nanoboot.powerframework.time.moment.TimeZone;
import org.nanoboot.powerframework.time.moment.ZonedDateTime;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

class LogRowCreator {

    private static final String DELIMITER = " ";
    private static final String START = "[";
    private static final String END = "]";
    private static final String STATIC = "----------STATIC";
    private static final String DASH = "-";
    private static final String NOTOKAYOBJECT = "NOT_OKAY_OBJECT";

    static String createRow(long rowNumber,
            Object object,
            Level level,
            String className,
            String message) {

        if(object instanceof String) {
            message = message + DELIMITER + "Warning: The object to log is String.";
        }

        int hashCode = object == null ? 0 : object.hashCode();
        String hashCodeAsHexString = Integer.toHexString(hashCode);

        String hash = hashCodeAsHexString;

        TimeZone timeZone = LocalSettings.getLocalTimeZone();
        String time = ZonedDateTime.getCurrentZonedDateTimeForTimeZone(timeZone).toString();
        return org.nanoboot.powerframework.utils.StringUtils.appendObjects(
                String.format("%08d", rowNumber), DELIMITER,
                START, Thread.currentThread().getName(), END, DELIMITER,
                level, DELIMITER,
                START, time, " ", timeZone.toString(), END, DELIMITER,
                hash, DELIMITER,
                className, DELIMITER,
                message
        );

    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private LogRowCreator() {
    }
}
