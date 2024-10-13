
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

package com.robertvokac.powerframework.view.window;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import com.robertvokac.powerframework.view.View;
import com.robertvokac.powerframework.view.window.titlebuttons.CloseButton;
import com.robertvokac.powerframework.view.window.titlebuttons.MaximizeRestoreButton;
import com.robertvokac.powerframework.view.window.titlebuttons.MinimizeButton;

/**
 * Represents title bar of a window.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class TitleBar extends HBox {

    /**
     * title bar height in millimeters.
     */
    private static final double TITLEBARHEIGHT = 4.5;
    /**
     * Space between buttons in millimeters.
     */
    private final Insets spaceBeforeButtons = new Insets(0, 0, 0, View.getDpmm() * 1.5);
    /**
     * StackPane for title bar icon.
     */
    private final TitleIcon titleIcon;
    /**
     * Part of title bar with title of the window. This part is used to move
     * window.
     */
    private final MoveableArea moveableArea;

    /**
     * Button used to minimize Window.
     */
    private final MinimizeButton minimizeButton;
    /**
     * Button used to restore or maximize Window.
     */
    private final MaximizeRestoreButton maximizeRestoreButton;
    /**
     * Button used to close Window.
     */
    private final CloseButton closeButton;
    private boolean onlyTheCloseButtonIsShowed = false;

    /**
     *
     * @param window
     */
    public TitleBar(Window window) {
        WindowColourSkin tempWindowColourSkin = View.getDefaultWindowColourSkin();
        setFillHeight(true);
        setMinHeight(View.getDpmm() * TITLEBARHEIGHT);
        setMaxHeight(View.getDpmm() * TITLEBARHEIGHT);
        titleIcon = new TitleIcon();
        moveableArea = new MoveableArea(window);

        minimizeButton = new MinimizeButton(tempWindowColourSkin, window);
        maximizeRestoreButton = new MaximizeRestoreButton(tempWindowColourSkin, window);

        closeButton = new CloseButton(tempWindowColourSkin, window);

        getChildren().addAll(titleIcon, moveableArea, minimizeButton, maximizeRestoreButton, closeButton);

        setMargin(minimizeButton, spaceBeforeButtons);
        setMargin(maximizeRestoreButton, spaceBeforeButtons);

        setMargin(closeButton, spaceBeforeButtons);
    }

    /**
     *
     * @param path
     */
    public void setIcon(String path) {
        this.titleIcon.setIcon(path);
    }

    /**
     *
     * @param value
     */
    public void setCanBeMoved(boolean value) {
        this.moveableArea.setCanBeMoved(value);
    }

    /**
     *
     * @return boolean value
     */
    public boolean canBeMoved() {
        return this.moveableArea.canBeMoved();
    }

    /**
     *
     * @param title
     */
    public void setWindowTitle(String title) {
        this.moveableArea.setWindowTitle(title);
    }

    /**
     *
     * @return title
     */
    public String getWindowTitle() {
        return this.moveableArea.getWindowTitle();
    }

    /**
     * Sets maximize/restore button restored.
     */
    public void setMaximizeRestoreButtonRestored() {
        this.maximizeRestoreButton.setMaximizeRestoreButtonRestored();

    }

    /**
     * Sets maximize/restore button maximized.
     */
    public void setMaximizeRestoreButtonMaximized() {
        this.maximizeRestoreButton.setMaximizeRestoreButtonMaximized();

    }

    /**
     * Shows only the close button.
     */
    public void showOnlyTheCloseButton() {

        if(!this.isShowedOnlyTheCloseButton()) {
            getChildren().removeAll(minimizeButton, maximizeRestoreButton);
        }

        this.onlyTheCloseButtonIsShowed = true;
    }

    /**
     *
     * @return boolean value
     */
    public boolean isShowedOnlyTheCloseButton() {
        return onlyTheCloseButtonIsShowed;
    }

    /**
     * Shows all title buttons.
     */
    public void showAllTitleButtons() {

        if(this.isShowedOnlyTheCloseButton()) {
            getChildren().addAll(minimizeButton, maximizeRestoreButton);
            setMargin(minimizeButton, spaceBeforeButtons);
            setMargin(maximizeRestoreButton, spaceBeforeButtons);
        }

        this.onlyTheCloseButtonIsShowed = false;
    }

    /**
     *
     * @return
     */
    public boolean areShowedAllTitleButtons() {
        return !onlyTheCloseButtonIsShowed;
    }
}
