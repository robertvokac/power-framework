
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

package com.robertvokac.powerframework.web.html;

import com.robertvokac.powerframework.web.css.CssStylesSelectors;
import com.robertvokac.powerframework.xml.ElementType;
import com.robertvokac.powerframework.xml.Element;
import com.robertvokac.powerframework.xml.XmlTypeI;
import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class WebElement extends Element {

    @Getter
    private final CssStylesSelectors cssStylesSelectors=new CssStylesSelectors();

    public WebElement(String elementName, String content) {
        super(elementName, content);
    }
    public WebElement(String elementName, XmlTypeI... xmlTypes) {
        super(elementName, xmlTypes);
    }

    public WebElement(String elementName, ElementType elementType, XmlTypeI... xmlTypes) {
        super(elementName, elementType, xmlTypes);

    }

    /**
     * Creates new paired element
     *
     * @param elementName
     */
    public WebElement(String elementName) {
        super(elementName);
    }

    /**
     * Creates new element with the specified type
     *
     * @param elementName
     * @param elementType
     */
    public WebElement(String elementName, ElementType elementType) {
        super(elementName, elementType);
    }

}
