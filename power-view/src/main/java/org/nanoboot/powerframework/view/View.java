
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

package org.nanoboot.powerframework.view;

import javafx.application.Platform;
import org.nanoboot.powerframework.view.window.WindowColourSkin;

/**
 * Represents Simplicity package main class.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class View {

    private static ViewRunner simplicityRunner;
    private static WindowColourSkin defaultWindowColourSkin;

    /**
     * This method must be called before using Simplicity.
     *
     * @param runner This object implements runObjectI interface and its method
     * run contains some logic.
     * @param defaultWindowColourSkin WindowColourSkin instance used as default in the Simplicity library.
     */
    public static void startSimplicity(ViewRunner runner,
                                       WindowColourSkin defaultWindowColourSkin) {
        View.setDefaultWindowColourSkin(defaultWindowColourSkin);
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
    public static ViewRunner getSimplicityRunner() {
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
        return View.defaultWindowColourSkin;
    }

    /**
     *
     * @param windowColourSkin WindowColourSkin instance
     */
    public static void setDefaultWindowColourSkin(WindowColourSkin windowColourSkin) {
        View.defaultWindowColourSkin = windowColourSkin;
    }

    /**
     *
     * @return information about Simplicity as String
     */
    public static String getInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\ndefaultWindowColourSkin: ").append(View.getDefaultWindowColourSkin());
        stringBuilder.append("\ndpmm: ").append(View.getDpmm());
        stringBuilder.append("\nzoom: ").append(Screen.getZoom());
        stringBuilder.append("\ndpi: ").append(Screen.getDpi());
        stringBuilder.append("\nheight: ").append(Screen.getHeight());
        stringBuilder.append("\nwidth: ").append(Screen.getWidth());
        stringBuilder.append("\nvisual height: ").append(Screen.getVisualHeight());
        stringBuilder.append("\nvisual width: ").append(Screen.getVisualWidth());
        return stringBuilder.toString();
    }

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private View() {
        //Not meant to be instantiated.
        Platform.setImplicitExit(false);
    }
}
