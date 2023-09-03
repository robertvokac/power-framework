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
package org.nanoboot.powerframework.time.utils;

import org.nanoboot.powerframework.time.duration.Duration;
import org.nanoboot.powerframework.time.moment.TimeZone;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import org.nanoboot.powerframework.utils.functions.ThreeArgFunction;

/**
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class RemainingTimeCalculator {

    private long startNanoTime = 0;
    private long total;
    private long done = 0;

    public static void main(String[] args) {
        //Test
        RemainingTimeCalculator rtc = new RemainingTimeCalculator(1000);
        for(int i = 0;i< 1000;i++) {
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            rtc.nextDone();
            System.out.println(rtc.currentStatus());
        }
    }
    public RemainingTimeCalculator(final int total) {
        this.total = total;
        this.start();
    }

    private void start() {
        this.startNanoTime = System.nanoTime();
    }

    private boolean started() {
        return this.startNanoTime != 0;
    }

    public long getElapsedSecondsSinceStart() {
        return (System.nanoTime() - this.startNanoTime) / 1000000000;
    }

    public void nextDone() {
        this.done++;
        if (this.done > this.total) {
            System.err.println("done is greater than total: " + "done=" + this.done + ", total=" + this.total);
        }
    }

    public String getProgressAsPrettyString() {
        return String.format("%,.2f", getProgress()) + "%";
    }

    public double getProgress() {
        return ((double) getDoneCount()) / ((double) getTotalCount());
    }

    public int getProgressInt() {
        return (int) getProgress();
    }

    public long getRemainsCount() {
        return getTotalCount() - getDoneCount();
    }

    public double getSecondsPerTask() {
        return ((double) getElapsedSecondsSinceStart()) / ((double) getDoneCount());
    }

    public double getTasksPerSecond() {
        return ((double) getDoneCount()) / ((double) getElapsedSecondsSinceStart());
    }
    
    public String getTasksPerSecondAsPrettyString() {
        return String.format("%,.1f", getTasksPerSecond()) + " tasks/s";
    }

    public long getRemainingSecondsUntilEnd() {
        return (long) (getSecondsPerTask() * getRemainsCount());
    }

    public long getDoneCount() {
        return this.done;
    }

    public long getTotalCount() {
        return this.total;
    }

    public static final String PLACEHOLDER_DONE = "{DONE}";
    public static final String PLACEHOLDER_TOTAL = "{TOTAL}";
    public static final String PLACEHOLDER_PROGRESS = "{PROGRESS}";
    public static final String PLACEHOLDER_PROGRESS_BAR = "{PROGRESS_BAR}";
    public static final String PLACEHOLDER_ELAPSED = "{ELAPSED}";
    public static final String PLACEHOLDER_LEFT = "{LEFT}";
    public static final String PLACEHOLDER_TASKS_PER_SECOND = "{TASKS_PER_SECOND}";
    public static final String PLACEHOLDER_TIME_OF_COMPLETION = "{TIME_OF_COMPLETION}";
    public static final String PLACEHOLDER_ELAPSED_LONG = "{ELAPSED_LONG}";
    public static final String PLACEHOLDER_LEFT_LONG = "{LEFT_LONG}";
    public static final String DEFAULT_STATUS_TEMPLATE = "Done {DONE}/{TOTAL} {PROGRESS} {PROGRESS_BAR} Elapsed={ELAPSED_LONG} LEFT={LEFT_LONG} PERFORMANCE={TASKS_PER_SECOND} Will finish at={TIME_OF_COMPLETION}";

    public String currentStatus() {
        return currentStatus(null);
    }

    public String currentStatus(String statusTemplate) {
        String returnThis = statusTemplate == null ? DEFAULT_STATUS_TEMPLATE : statusTemplate;
        ThreeArgFunction<String, String, Object, String> replaceIfNeeded = (result, placeholder, value) -> result.contains(placeholder) ? result.replace(placeholder, String.valueOf(value)) : result;
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_DONE, getDoneCount());
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_TOTAL, getTotalCount());
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_PROGRESS, getProgressAsPrettyString());
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_PROGRESS_BAR, getProgressBar());
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_ELAPSED, Duration.of(getElapsedSecondsSinceStart(), TimeUnit.SECOND).toString());
        Duration remainsDuration = Duration.of(getRemainingSecondsUntilEnd(), TimeUnit.SECOND);
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_LEFT, remainsDuration.toString());
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_TASKS_PER_SECOND, getTasksPerSecondAsPrettyString());
        String timeOfCompletion = getTimeOfCompletion();
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_TIME_OF_COMPLETION, timeOfCompletion);
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_ELAPSED_LONG, "\"" + Duration.of(getElapsedSecondsSinceStart(), TimeUnit.SECOND).toHumanString() + "\"");
        returnThis = replaceIfNeeded.apply(returnThis, PLACEHOLDER_LEFT_LONG, "\"" + Duration.of(getRemainingSecondsUntilEnd(), TimeUnit.SECOND).toHumanString() + "\"");
        if (returnThis.contains("{") || returnThis.contains("}")) {
            throw new TimeException("Cannot use built template. It is not valid (It still contains '{' or '}'): " + returnThis);
        }
        return returnThis;
    }
        /**
     * Returns text representation of progress.
     * @return text representation of progress
     */
    public String getProgressBar() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int percentProgress = getProgressInt() / 10;
        for (int i = 1; i <= (100 / 10); i++) {
            sb.append(i <= percentProgress ? "#" : " ");
        }
        sb.append("]");
        return sb.toString();
    }

    private String getTimeOfCompletion() {
        Duration remainsDuration = Duration.of(getRemainingSecondsUntilEnd(), TimeUnit.SECOND);
        return UniversalDateTime.now().plusDuration(remainsDuration).convertToZonedDateTimeWithUniversalTimeZone().toZonedDateTime(TimeZone.getDefaultTimeZone()).toString();
    }
}
