
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

package org.nanoboot.powerframework.simplicity;

import javafx.geometry.Rectangle2D;

/**
 * Represents screen.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public final class Screen {

    private static double dpmm;
    private static double dpi;
    private static double zoom = 100;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private Screen() {
        //Not meant to be instantiated.
    }

    /**
     * Initialises screen.
     */
    static void initScreen() {
        setDpi();
        updateDpmm();
    }

    /**
     * Sets dots per inch.
     */
    private static void setDpi() {
        javafx.stage.Screen primaryScreen = javafx.stage.Screen.getPrimary();
        dpi = primaryScreen.getDpi();
    }

    /**
     * @return the resolution (dots per inch) of screen.
     */
    public static double getDpi() {
        return dpi;
    }

    /**
     * Sets the length of one millimetre long line in dots (dots per
     * millimetre.)
     */
    private static void updateDpmm() {
        double currentDpi = getDpi();
        if (currentDpi > 0) {
            dpmm = currentDpi / 25.4;
        } else {
            dpmm = 6;
        }
        dpmm = dpmm * (getZoom() / 100);
    }

    /**
     * @return the length of one millimetre long line in dots (dots per
     * millimetre).
     */
    public static double getDpmm() {
        return dpmm;
    }

    /**
     *
     * @return zoom
     */
    public static double getZoom() {
        return zoom;
    }

    /**
     *
     * @param zoom 100% is 100, 100% is default
     */
    public static void setZoom(double newZoom) {
        zoom = newZoom;
        updateDpmm();
    }

    private static Rectangle2D getBounds() {
        return javafx.stage.Screen.getPrimary().getBounds();
    }

    /**
     *
     * @return screen width
     */
    public static int getWidth() {
        return (int) getBounds().getWidth();
    }

    /**
     *
     * @return screen height
     */
    public static int getHeight() {
        return (int) getBounds().getHeight();
    }

    private static Rectangle2D getVisualBounds() {
        return javafx.stage.Screen.getPrimary().getVisualBounds();
    }

    /**
     *
     * @return screen visual width
     */
    public static int getVisualWidth() {
        return (int) getVisualBounds().getWidth();
    }

    /**
     *
     * @return screen visual height
     */
    public static int getVisualHeight() {
        return (int) getVisualBounds().getHeight();
    }
}
