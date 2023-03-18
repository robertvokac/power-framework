
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

package org.nanoboot.powerframework.time.moment;

import java.time.*;
import java.util.*;
import org.nanoboot.powerframework.time.utils.TimeException;

/**
 * Represents time zone.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TimeZone {

    private static final ArrayList<String> listOfTimeZones = new ArrayList<>(ZoneId.getAvailableZoneIds());

    static {
        Collections.sort(listOfTimeZones);
    }

    /**
     *
     * @return list of all available time zone IDs
     */
    public static List<String> getListOfTimeZoneIDs() {
        return Collections.unmodifiableList(listOfTimeZones);
    }

    /**
     *
     * @param timeZoneID
     *
     * @return true if the timeZoneID is valid (available), otherwise false.
     */
    public static boolean isTimeZoneIDValid(String timeZoneID) {
        return listOfTimeZones.contains(timeZoneID);
    }
    private final String timeZoneID;

    /**
     * Constructor
     *
     * Only time zone with valid timeZoneID can be created.
     *
     * @param timeZoneID
     */
    public TimeZone(String timeZoneID) {
        if(!TimeZone.isTimeZoneIDValid(timeZoneID)) {
            throw new TimeException("There is no time zone id with the name " + timeZoneID + ".");
        }
        this.timeZoneID = timeZoneID;
    }

    /**
     *
     * @return time zone ID of this time zone
     */
    @Override
    public String toString() {
        return this.timeZoneID;
    }

    /**
     *
     * @return time zone ID of this time zone
     */
    public String getTimeZoneID() {
        return this.toString();
    }

}
