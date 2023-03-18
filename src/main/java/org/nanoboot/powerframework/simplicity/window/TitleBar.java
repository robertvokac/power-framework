
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

package org.nanoboot.powerframework.simplicity.window;

import org.nanoboot.powerframework.simplicity.Simplicity;
import org.nanoboot.powerframework.simplicity.window.titlebuttons.CloseButton;
import org.nanoboot.powerframework.simplicity.window.titlebuttons.MaximizeRestoreButton;
import org.nanoboot.powerframework.simplicity.window.titlebuttons.MinimizeButton;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

/**
 * Represents title bar of a window.
 *
 * @author Robert Vokac e-mail: robertvokac@nanoboot.org
 */
public class TitleBar extends HBox {

    /**
     * title bar height in millimeters.
     */
    private static final double TITLEBARHEIGHT = 4.5;
    /**
     * Space between buttons in millimeters.
     */
    private final Insets spaceBeforeButtons = new Insets(0, 0, 0, Simplicity.getDpmm() * 1.5);
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
     * @param windowColourSkin
     * @param window
     */
    public TitleBar(Window window) {
        WindowColourSkin tempWindowColourSkin = Simplicity.getDefaultWindowColourSkin();
        setFillHeight(true);
        setMinHeight(Simplicity.getDpmm() * TITLEBARHEIGHT);
        setMaxHeight(Simplicity.getDpmm() * TITLEBARHEIGHT);
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

        if (!this.isShowedOnlyTheCloseButton()) {
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

        if (this.isShowedOnlyTheCloseButton()) {
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
