
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

package org.nanoboot.powerframework.time.duration;

import org.nanoboot.powerframework.time.utils.TimeException;
import org.nanoboot.powerframework.time.utils.TimeUnit;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class StopWatch {

    private static final int NANOSECONDHASMILlISECONDS = 1000000;

    private static long convertNanosecondsToMilliSeconds(long nanoseconds) {
        return nanoseconds / NANOSECONDHASMILlISECONDS;
    }
    private Duration currentDuration = Duration.getZeroDuration();
    private StopWatchState stopWatchState = StopWatchState.CLEAR;

    private long startFlag = 0;
    private long endFlag = 0;

    /**
     *
     * @return
     */
    public StopWatchState getStopWatchState() {
        return this.stopWatchState;
    }

    /**
     *
     */
    public void clear() {
        this.stopWatchState = StopWatchState.CLEAR;
        this.currentDuration = Duration.getZeroDuration();
    }

    /**
     *
     */
    public void start() {
        if(this.stopWatchState == StopWatchState.RUNNING) {
            return;
        }
        startFlag = this.getCurrentFlagInNanoseconds();
        stopWatchState = StopWatchState.RUNNING;
    }

    /**
     *
     */
    public void stop() {
        if(this.stopWatchState == StopWatchState.RUNNING) {
            endFlag = this.getCurrentFlagInNanoseconds();
            this.currentDuration = this.currentDuration.plus(getElapsedTimeInMillisecondsFromFlags(), TimeUnit.MILLISECOND);
            startFlag = 0;
            endFlag = 0;
            this.stopWatchState = StopWatchState.STOPPED;
        }
    }

    private long getElapsedTimeInMillisecondsFromFlags() {
        return StopWatch.convertNanosecondsToMilliSeconds(endFlag - startFlag);
    }

    /**
     *
     * @return
     */
    public Duration getCurrentDuration() {
        if(this.stopWatchState == StopWatchState.RUNNING) {
            throw new TimeException("Can't get the duration, becuae the StopWatch is running. Stop StopWatch before getting duration");
        }

        return this.currentDuration;
    }

    private long getCurrentFlagInNanoseconds() {
        return System.nanoTime();
    }

    /**
     *
     * @return
     */
    public boolean isClear() {
        return this.stopWatchState == StopWatchState.CLEAR;
    }

    /**
     *
     * @return
     */
    public boolean isRunning() {
        return this.stopWatchState == StopWatchState.RUNNING;
    }

    /**
     *
     * @return
     */
    public boolean isStopped() {
        return this.stopWatchState == StopWatchState.STOPPED;
    }
}
