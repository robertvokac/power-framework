
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

package com.robertvokac.powerframework.time.duration;

import com.robertvokac.powerframework.time.moment.LocalDateTime;
import com.robertvokac.powerframework.time.utils.TimeException;
import com.robertvokac.powerframework.time.utils.TimeUnit;
import com.robertvokac.powerframework.time.moment.UniversalDateTime;
import com.robertvokac.powerframework.time.moment.ZonedDateTime;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class Period {

    private static Duration getDuration(UniversalDateTime startUniversalDateTime,
            UniversalDateTime endUniversalDateTime) {
        java.time.LocalDateTime javaStartLocalDateTime = startUniversalDateTime.removeUniversalTimeZone().toJavaLocalDateTime();
        java.time.LocalDateTime javaEndLocalDateTime = endUniversalDateTime.removeUniversalTimeZone().toJavaLocalDateTime();
        java.time.Duration javaDuration = java.time.Duration.between(javaStartLocalDateTime, javaEndLocalDateTime);
        return new Duration(javaDuration.toMillis());
    }

    private final UniversalDateTime startUniversalDateTime;
    private final UniversalDateTime endUniversalDateTime;
    private final ZonedDateTime startZonedDateTime;
    private final ZonedDateTime endZonedDateTime;
    private final Duration duration;

    /**
     *
     * @param startUniversalDateTime UniversalDateTime instance
     * @param endUniversalDateTime UniversalDateTime instance
     */
    public Period(UniversalDateTime startUniversalDateTime,
            UniversalDateTime endUniversalDateTime) {
        this.startUniversalDateTime = startUniversalDateTime;
        this.endUniversalDateTime = endUniversalDateTime;
        this.startZonedDateTime = null;
        this.endZonedDateTime = null;
        this.duration = getDuration(startUniversalDateTime, endUniversalDateTime);
    }

    /**
     *
     * @param startZonedDateTime
     * @param endZonedDateTime
     */
    public Period(ZonedDateTime startZonedDateTime,
            ZonedDateTime endZonedDateTime) {
        this.startUniversalDateTime = null;
        this.endUniversalDateTime = null;
        this.startZonedDateTime = startZonedDateTime;
        this.endZonedDateTime = endZonedDateTime;
        this.duration = getDuration(startZonedDateTime.toUniversalDateTime(), endZonedDateTime.toUniversalDateTime());
    }

    /**
     *
     * @param startUniversalDateTime UniversalDateTime instance
     * @param plusDuration Duration to add
     */
    public Period(UniversalDateTime startUniversalDateTime,
            Duration plusDuration) {
        this.startUniversalDateTime = startUniversalDateTime;

        java.time.LocalDateTime javaStartLocalDateTime = startUniversalDateTime.removeUniversalTimeZone().toJavaLocalDateTime();
        this.endUniversalDateTime = new UniversalDateTime(LocalDateTime.toPowerLocalDateTime(javaStartLocalDateTime.plusNanos((long) plusDuration.toTotal(TimeUnit.MILLISECOND) * 1000000)));

        this.startZonedDateTime = null;
        this.endZonedDateTime = null;

        this.duration = getDuration(startUniversalDateTime, endUniversalDateTime);
    }

    /**
     *
     * @param startZonedDateTime ZonedDateTime instance
     * @param plusDuration Duration instance to add
     */
    public Period(ZonedDateTime startZonedDateTime,
            Duration plusDuration) {
        this.startUniversalDateTime = null;
        this.endUniversalDateTime = null;

        this.startZonedDateTime = startZonedDateTime;

        java.time.LocalDateTime javaStartLocalDateTime = startUniversalDateTime.removeUniversalTimeZone().toJavaLocalDateTime();
        this.endZonedDateTime = new UniversalDateTime(LocalDateTime.toPowerLocalDateTime(javaStartLocalDateTime.plusNanos((long) plusDuration.toTotal(TimeUnit.MILLISECOND) * 1000000))).convertToZonedDateTimeWithUniversalTimeZone();

        this.duration = getDuration(startZonedDateTime.toUniversalDateTime(), endZonedDateTime.toUniversalDateTime());
    }

    /**
     *
     * @return Duration instance counted of this period
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     *
     * @return true, if this period uses universalDateTime, otherwise false
     */
    public boolean usesUniversalTime() {
        return startUniversalDateTime != null;
    }

    /**
     *
     * @return true, if this period uses zonedDateTime, otherwise false
     */
    public boolean usesZonedTime() {
        return startZonedDateTime != null;
    }

    /**
     *
     * @return UniversalDateTime instance
     */
    public UniversalDateTime getStartUniversalDateTime() {
        if(startUniversalDateTime == null) {
            throw new TimeException("This period has no start universal date time.");
        }
        return startUniversalDateTime;
    }

    /**
     *
     * @return UniversalDateTime instance
     */
    public UniversalDateTime getEndUniversalDateTime() {
        if(endUniversalDateTime == null) {
            throw new TimeException("This period has no start universal date time.");
        }
        return endUniversalDateTime;
    }

    /**
     *
     * @return ZonedDateTime instance
     */
    public ZonedDateTime getStartZonedDateTime() {
        if(startZonedDateTime == null) {
            new TimeException("This period has no start universal date time.");
        }
        return startZonedDateTime;
    }

    /**
     *
     * @return ZonedDateTime instance
     */
    public ZonedDateTime getEndZonedDateTime() {
        if(endZonedDateTime == null) {
            new TimeException("This period has no start universal date time.");
        }
        return endZonedDateTime;
    }
}
