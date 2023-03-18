
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

import javafx.application.Platform;
import org.nanoboot.powerframework.simplicity.window.WindowColourSkin;

/**
 * Represents Simplicity package main class.
 *
 * @author Robert Vokac robertvokac@nanoboot.org
 */
public final class Simplicity {

    private static SimplicityRunnerI simplicityRunner;
    private static WindowColourSkin defaultWindowColourSkin;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private Simplicity() {
        //Not meant to be instantiated.
        Platform.setImplicitExit(false);
    }
    /**
     * This method must be called before using Simplicity.
     *
     * @param runner This object implements runObjectI interface and its method
     * run contains some logic.
     * @param defaultWindowColourSkin
     */
    public static void startSimplicity(SimplicityRunnerI runner, WindowColourSkin defaultWindowColourSkin) {
        Simplicity.setDefaultWindowColourSkin(defaultWindowColourSkin);
        simplicityRunner = runner;
        JavaFXApplication.startJavaFXApplication();
    }

    /**
     * Stops Simplicity.
     */
    public static void stopSimplicity() {
        Platform.exit();
    }

    /**
     *
     * @return Simplicity runner
     */
    public static SimplicityRunnerI getSimplicityRunner() {
        return simplicityRunner;
    }

    /**
     * Returns count of dots per one millimeter on the screen.
     *
     * @return count of dots per one millimeter on the screen
     */
    public static double getDpmm() {
        return Screen.getDpmm();
    }

    /**
     *
     * @return default window colour skin
     */
    public static WindowColourSkin getDefaultWindowColourSkin() {
        return Simplicity.defaultWindowColourSkin;
    }

    /**
     *
     * @param windowColourSkin
     */
    public static void setDefaultWindowColourSkin(WindowColourSkin windowColourSkin) {
        Simplicity.defaultWindowColourSkin = windowColourSkin;
    }

    public static String getInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\ndefaultWindowColourSkin: ").append(Simplicity.getDefaultWindowColourSkin());
        stringBuilder.append("\ndpmm: ").append(Simplicity.getDpmm());
        stringBuilder.append("\nzoom: ").append(Screen.getZoom());
        stringBuilder.append("\ndpi: ").append(Screen.getDpi());
        stringBuilder.append("\nheight: ").append(Screen.getHeight());
        stringBuilder.append("\nwidth: ").append(Screen.getWidth());
        stringBuilder.append("\nvisual height: ").append(Screen.getVisualHeight());
        stringBuilder.append("\nvisual width: ").append(Screen.getVisualWidth());
        return stringBuilder.toString();
    }
}
