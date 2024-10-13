
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

package com.robertvokac.powerframework.view;

import javafx.application.Platform;
import com.robertvokac.powerframework.view.window.WindowColourSkin;

/**
 * Represents Simplicity package main class.
 *
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
