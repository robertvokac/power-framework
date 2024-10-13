
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

import com.robertvokac.powerframework.time.utils.TimeException;
import com.robertvokac.powerframework.time.utils.TimeUnit;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
