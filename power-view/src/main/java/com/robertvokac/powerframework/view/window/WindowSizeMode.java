
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

/**
 * Window size modes.
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public enum WindowSizeMode {

    /**
     * Window is not fullscreen. Window is not maximized. Window has borders and
     * we can move it and change its size. Window has decorations.
     */
    RESTORED,
    /**
     * Window has no borders, we cannot move it. We cannot resize it. Window has
     * decorations.
     */
    MAXIMIZED,
    /**
     * Window has no borders, we cannot move it. We cannot resize it. Window has
     * no decorations.
     */
    FULLSCREEN;
}