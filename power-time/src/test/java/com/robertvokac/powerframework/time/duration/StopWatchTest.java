
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

import static org.junit.Assert.assertEquals;

import com.robertvokac.powerframework.time.utils.TimeUnit;
import org.junit.*;

/**
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class StopWatchTest {

    public StopWatchTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentStopWatchState method, of class StopWatch.
     */
    @Test
    public void testGetStopWatchState_shouldBeClear() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.CLEAR;
        StopWatchState returnedValue;
        //act
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getCurrentStopWatchState method, of class StopWatch.
     */
    @Test
    public void testGetStopWatchState_shouldBeRunning() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.RUNNING;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of clear method, of class StopWatch.
     */
    @Test
    public void testClear() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.CLEAR;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.clear();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of clear method, of class StopWatch.
     */
    @Test
    public void testClear2() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        int expectedValue = 0;
        int returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.clear();
        returnedValue = (int) stopWatch.getCurrentDuration().toTotal(TimeUnit.MILLISECOND);
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of start method, of class StopWatch.
     */
    @Test
    public void testStart() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.RUNNING;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of start method, of class StopWatch.
     */
    @Test
    public void testStart2() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.RUNNING;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.clear();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of stop method, of class StopWatch.
     */
    @Test
    public void testStop() {       //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.STOPPED;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.clear();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of getCurrentDuration method, of class StopWatch.
     */
    @Test
    public void testGetCurrentDuration() {
        StopWatch stopWatch = new StopWatch();
        boolean expectedValue = true;
        boolean returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.clear();
        stopWatch.start();
        stopWatch.stop();
        returnedValue = stopWatch.getCurrentDuration().toTotal(TimeUnit.MILLISECOND) == 0;
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isClear method, of class StopWatch.
     */
    @Test
    public void testIsClear() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.CLEAR;
        StopWatchState returnedValue;
        //act
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isRunning method, of class StopWatch.
     */
    @Test
    public void testIsRunning() {
        //arrange
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.RUNNING;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

    /**
     * Test of isStopped method, of class StopWatch.
     */
    @Test
    public void testIsStopped() {
        StopWatch stopWatch = new StopWatch();
        StopWatchState expectedValue = StopWatchState.STOPPED;
        StopWatchState returnedValue;
        //act
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.clear();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        returnedValue = stopWatch.getStopWatchState();
        //assert
        assertEquals(expectedValue, returnedValue);
    }

}
