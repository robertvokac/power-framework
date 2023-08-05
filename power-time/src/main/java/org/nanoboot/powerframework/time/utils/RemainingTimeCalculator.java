
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
    public long elapsedSecondSinceStart() {
        return (System.nanoTime() - this.startNanoTime) / 1000000000;
    }

    public void nextDone() {
        this.done++;
        if (this.done > this.total) {
            System.err.println("done is greater than total: " + "done=" + this.done + ", total=" + this.total);
        }
    }

    public long remainingSecondsUntilEnd() {
        long remains = this.total - this.done;
        long remainsSeconds = (this.elapsedSecondSinceStart() / this.done) * remains;
        return remainsSeconds;
    }

    public long getDoneCount() {
        return this.done;
    }

    public String getMessage() {
        return "Elapsed=" + this.elapsedSecondSinceStart() + " seconds Left=" + this.remainingSecondsUntilEnd() + " seconds Done=" + this.getDoneCount() + " tasks.";
    }
}
