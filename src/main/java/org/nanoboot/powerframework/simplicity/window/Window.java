
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

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nanoboot.powerframework.simplicity.Simplicity;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;

/**
 * Represents window. Window is place for everything player sees.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
 */
public abstract class Window extends Stage {

    private VBox windowVBox;
    private TitleBar titleBar;
    protected StackPane applicationArea = new StackPane();
    private ResizingGrid resizingGrid = null;

    private double dragOffsetXForMoving;
    private double dragOffsetYXForMoving;
    private boolean resizeable = false;
    private boolean closeable = true;
    private boolean showedTitleBar = false;

    private WindowSizeMode windowSizeMode;

    private int restoredWindowMinX;
    private int restoredWindowMinY;
    private int restoredWindowWidth;
    private int restoredWindowHeight;

    /**
     * Constructor
     */
    public Window() {

        this.centerOnScreen();
        titleBar = new TitleBar(this);

        initWindowVBox();
        switchToRestored();

        setDefaultSizeAndPosition();

        initAreaForUserInteraction();
        setValuesForRestoredWindow();
        if (this.canBeResized()) {
            this.resizingGrid.toFront();
        }
    }

    private void setDefaultSizeAndPosition() {
        setWidth((org.nanoboot.powerframework.simplicity.Screen.getVisualWidth()) / 2);
        setHeight((org.nanoboot.powerframework.simplicity.Screen.getVisualHeight()) / 8 * 6);
        setX((org.nanoboot.powerframework.simplicity.Screen.getVisualWidth() - this.getWidth()) / 2);
        setY((org.nanoboot.powerframework.simplicity.Screen.getVisualHeight() - this.getHeight()) / 2);
    }

    private void initWindowVBox() {
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {

                event.consume();
            }
        });
        this.initStyle(StageStyle.TRANSPARENT);
        windowVBox = new VBox();
        windowVBox.setFillWidth(true);
        this.setScene(new Scene(windowVBox, 400, 300));

        this.setFullScreenExitHint("");
        windowVBox.setVgrow(applicationArea, Priority.ALWAYS);
        windowVBox.getChildren().addAll(applicationArea);
    }

    private void setValuesForRestoredWindow() {

        this.restoredWindowMinX = (int) this.getX();
        this.restoredWindowMinY = (int) this.getY();
        this.restoredWindowWidth = (int) this.getWidth();
        this.restoredWindowHeight = (int) this.getHeight();
    }

    /**
     *
     * @param path
     */
    public void setIcon(String path) {
        this.titleBar.setIcon(path);
    }

    private void setCanBeMoved(boolean value) {
        this.titleBar.setCanBeMoved(value);
    }

    /**
     *
     * @param title
     */
    public void setWindowTitle(String title) {
        this.titleBar.setWindowTitle(title);
        this.setTitle(title);
    }

    /**
     *
     * @return title
     */
    public String getWindowTitle() {
        return this.titleBar.getWindowTitle();
    }

    private void setMaximizeRestoreButtonRestored() {
        this.titleBar.setMaximizeRestoreButtonRestored();

    }

    private void setMaximizeRestoreButtonMaximized() {
        this.titleBar.setMaximizeRestoreButtonMaximized();

    }

    /**
     * only the close button is shown
     */
    public void showOnlyTheCloseButton() {
        this.titleBar.showOnlyTheCloseButton();
        this.setResizeable(false);
    }

    /**
     *
     * @return boolean value
     */
    public boolean isShowedOnlyTheCloseButton() {
        return this.titleBar.isShowedOnlyTheCloseButton();
    }

    /**
     * show all title buttons
     */
    public void showAllTitleButtons() {
        this.titleBar.showAllTitleButtons();
        this.setResizeable(true);
    }

    /**
     *
     * @return boolean value
     */
    public boolean areShowedAllTitleButtons() {
        return this.titleBar.areShowedAllTitleButtons();
    }

    private void setResizeable(boolean value) {
        if (this.resizeable != value) {
            this.resizeable = value;
            if (value) {
                resizingGrid = new ResizingGrid();
                resizingGrid.setOnMouseDragged(this::handleResizeWindowAction);
                applicationArea.getChildren().add(resizingGrid);
                applicationArea.setAlignment(resizingGrid, Pos.BOTTOM_RIGHT);
            } else {
                this.applicationArea.getChildren().remove(this.resizingGrid);
                this.resizingGrid = null;
            }
        }

    }

    private boolean canBeResized() {
        return this.resizeable;
    }

    /**
     * Window's size and position can be changed.
     */
    public void switchToRestored() {
        this.setFullScreen(false);
        this.windowSizeMode = WindowSizeMode.RESTORED;
        setX(this.restoredWindowMinX);
        setY(this.restoredWindowMinY);
        setWidth(restoredWindowWidth);
        setHeight(restoredWindowHeight);

        this.setResizeable(true);
        this.setBorder(true);
        this.showTitleBar(true);
        this.setCanBeMoved(true);
        this.setMaximizeRestoreButtonMaximized();
        this.setMaximized(false);
        newTaskResizingWindow();
    }

    /**
     * Window's size and position can not be changed.
     */
    public void switchToMaximized() {
        this.setFullScreen(false);

        this.windowSizeMode = WindowSizeMode.MAXIMIZED;
        this.setValuesForRestoredWindow();
        this.setResizeable(false);
        this.setBorder(false);
        this.showTitleBar(true);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        setX(bounds.getMinX());
        setY(bounds.getMinY());
        setWidth(bounds.getWidth());
        setHeight(bounds.getHeight());

        this.setCanBeMoved(false);
        this.setMaximizeRestoreButtonRestored();
        newTaskResizingWindow();
    }

    /**
     ** Window's size and position can not be changed. The size is the biggest
     */
    public void switchToFullScreen() {
        this.windowSizeMode = WindowSizeMode.FULLSCREEN;
        if (this.canBeResized()) {
            this.setValuesForRestoredWindow();
        }
        this.setResizeable(false);
        this.setBorder(false);
        this.showTitleBar(false);
        this.setFullScreen(true);
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        setX(bounds.getMinX());
        setY(bounds.getMinY());
        setWidth(bounds.getWidth());
        setHeight(bounds.getHeight());
        newTaskResizingWindow();
    }

    private void newTaskResizingWindow() {
        Thread thread = new Thread(() -> {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
            for(int i=0;i<=10;i++)
            {try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
            this.onResizingWindow();}
            
        });
        thread.setDaemon(true);
        thread.start();
    }

    public WindowSizeMode getWindowSizeMode() {
        return this.windowSizeMode;
    }

    private void setBorder(boolean value) {
        if (value) {
            windowVBox.setStyle("-fx-background-color: rgb(" + Simplicity.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.LIGHT) + ");"
                    + "-fx-border-width: " + Simplicity.getDpmm() / 3 + ";"
                    + "-fx-border-color: rgb(" + Simplicity.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.DARK) + ");");
        } else {
            windowVBox.setStyle("-fx-background-color: rgb(" + Simplicity.getDefaultWindowColourSkin().getRGBStringForCSS(ColourVariant.LIGHT) + ");"
                    + "-fx-border-width: 0;");
        }

    }

    private void showTitleBar(boolean value) {
        if (value != showedTitleBar) {
            this.showedTitleBar = value;
            if (value) {
                windowVBox.getChildren().addAll(titleBar);
                titleBar.toBack();
            } else {
                this.windowVBox.getChildren().removeAll(this.titleBar);
            }
        }
    }

    /**
     *
     * @param e
     */
    public void handleMovingWindowStarted(MouseEvent e) {
        this.dragOffsetXForMoving = e.getScreenX() - this.getX();
        this.dragOffsetYXForMoving = e.getScreenY() - this.getY();
    }

    /**
     *
     * @param e
     */
    public void handleMovingWindowEnded(MouseEvent e) {
        this.setX(e.getScreenX() - this.dragOffsetXForMoving);
        this.setY(e.getScreenY() - this.dragOffsetYXForMoving);
        this.onMovingWindow();
    }

    /**
     *
     * @param event
     */
    public void handleMinimizeButtonAction(MouseEvent event) {
        this.setIconified(true);
    }

    /**
     *
     * @param event
     */
    public void handleMaximizeRestoreButtonAction(MouseEvent event) {
        if (this.windowSizeMode == WindowSizeMode.RESTORED) {
            this.switchToMaximized();
        } else if (this.windowSizeMode == WindowSizeMode.MAXIMIZED) {
            this.switchToRestored();
        }
    }

    /**
     *
     * @param value
     */
    public void setCloseable(boolean value) {
        this.closeable = value;
    }

    /**
     *
     * @return
     */
    public boolean isCloseable() {
        return this.closeable;
    }

    /**
     *
     * @param event
     */
    public void handleCloseButtonAction(MouseEvent event) {
        if (this.closeable) {
            this.onClosingWindow();
            super.close();
        }
    }

    protected void onClosingWindow() {
    }

    private void handleResizeWindowAction(MouseEvent event) {//NOSONAR
        double newX = event.getScreenX() - this.getX() + 13;
        double newY = event.getScreenY() - this.getY() + 10;

        if (newX > getMinWidth()) {
            this.setWidth(newX);
        } else {
            this.setWidth(getMinWidth());
        }

        if (newY > getMinHeight()) {
            this.setHeight(newY);
        } else {
            this.setHeight(getMinHeight());
        }
        this.onResizingWindow();
    }

    protected void onResizingWindow() {
    }

    protected void onMovingWindow() {
    }

    protected abstract void initAreaForUserInteraction();

}
