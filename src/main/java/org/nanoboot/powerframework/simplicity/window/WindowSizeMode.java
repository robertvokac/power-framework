
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

/**
 * Window size modes.
 *
 * @author Robert Vokac robertvokac@nanoboot.orgt Vokáč robertvokac@nanoboot.org
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
