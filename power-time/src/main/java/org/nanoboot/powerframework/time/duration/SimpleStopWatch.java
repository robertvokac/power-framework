
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
//TODO: Simple stop watch- Power- if running multiple times- there is an error - it is thrown - StopWatch was already started- to be fixed

import org.nanoboot.powerframework.time.utils.TimeException;


/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class SimpleStopWatch {

    final static long MILLISECONDHASNANOSECONDS = 1000000;
    final static long SECONDHASMILLISECONDS = 1000;
    final static long MINUTEHASSECONDS = 60;
    final static long MINUTEHASMILLISECONDS = MINUTEHASSECONDS * SECONDHASMILLISECONDS;

    private long timeStart;
    private long timeEnd;

    private long totalNanoseconds;

    private long totalMilliseconds;
    private long runningTimeInMinutes;
    private long runningTimeInSeconds;
    private long runningTimeInMilliseconds;

    private boolean started = false;
    private boolean stopped = false;

    public SimpleStopWatch() {

    }

    public void start() {
        if(this.started) {
            throw new TimeException("The stop watch was already started.");
        }
        this.timeStart = System.nanoTime();
        this.started = true;
    }

    public void stop() {
        if(!this.started) {
            throw new TimeException("The stop watch was not started.");
        }

        if(this.stopped) {
            throw new TimeException("The stop watch was already stopped.");
        }

        this.timeEnd = System.nanoTime();
        this.stopped = true;
        this.computeTime();
    }

    private void computeTime() {

        this.throwExceptionIfWasNotStopped();

        this.totalNanoseconds = this.timeEnd - this.timeStart;
        this.totalMilliseconds = this.totalNanoseconds / MILLISECONDHASNANOSECONDS;

        long remainingMilliseconds = this.totalMilliseconds;

        this.runningTimeInMinutes = remainingMilliseconds / MINUTEHASMILLISECONDS;
        remainingMilliseconds = remainingMilliseconds - (this.runningTimeInMinutes * MINUTEHASMILLISECONDS);

        this.runningTimeInSeconds = remainingMilliseconds / SECONDHASMILLISECONDS;
        remainingMilliseconds = remainingMilliseconds - (this.runningTimeInSeconds * SECONDHASMILLISECONDS);

        this.runningTimeInMilliseconds = remainingMilliseconds;

    }

    public boolean isStarted() {
        return this.started;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public long getTotalNanoseconds() {
        this.throwExceptionIfWasNotStopped();
        return this.totalNanoseconds;
    }

    public long getTotalMilliseconds() {
        this.throwExceptionIfWasNotStopped();
        return this.totalMilliseconds;
    }

    public long getRunningTimeInMinutes() {
        this.throwExceptionIfWasNotStopped();
        return this.runningTimeInMinutes;
    }

    public long getRunningTimeInSeconds() {
        this.throwExceptionIfWasNotStopped();
        return this.runningTimeInSeconds;
    }

    public long getRunningTimeInMilliseconds() {
        this.throwExceptionIfWasNotStopped();
        return this.runningTimeInMilliseconds;
    }

    public String createMessage() {
        this.throwExceptionIfWasNotStopped();
        return "The running time was " + this.runningTimeInMinutes + " minutes, " + this.runningTimeInSeconds + " seconds and " + this.runningTimeInMilliseconds + " milliseconds (" + this.totalNanoseconds + " nanoseconds in total).";
    }

    private void throwExceptionIfWasNotStopped() {
        if(!this.stopped) {
            throw new TimeException("The stop watch was not stopped.");
        }
    }

}
