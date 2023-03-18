
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

package org.nanoboot.powerframework.web.html;

import org.nanoboot.powerframework.web.css.CssStylesSelectors;
import org.nanoboot.powerframework.xml.ElementType;
import org.nanoboot.powerframework.xml.Element;
import org.nanoboot.powerframework.xml.XmlTypeI;
import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
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
