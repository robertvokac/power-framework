
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

package org.nanoboot.powerframework.web.html.tags;

import org.nanoboot.powerframework.web.html.WebElement;
import org.nanoboot.powerframework.web.html.attributes.Id;
import org.nanoboot.powerframework.web.html.attributes.Name;
import org.nanoboot.powerframework.xml.XmlUtils;

import java.util.Set;
import org.nanoboot.powerframework.xml.Attribute;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Option extends WebElement {
    public static final String NAME = "option";

    public static final Set<String> ALLOWED_ATTRIBUTES
            = XmlUtils.createNewSet("label", "value", "selected");

    public Option() {
        super(NAME);

    }
    public Option(String title) {
        this();
        setInnerText(title);

    }
    public Option withSelected() {
        this.add(new Attribute("selected", "selected"));
        return this;
    }
    public Option withValue(String value) {
        this.add(new Attribute("value", value));
        return this;
    }
    public Option withLabel(String label) {
        this.add(new Attribute("label", label));
        return this;
    }
    public Option withEmptyLabel() {
        this.add(new Attribute("label", " "));
        return this;
    }
    @Override
    public Set<String> getAllowedAttributes() {
        return ALLOWED_ATTRIBUTES;
    }
}
//                <option label=" "></option>
//                <option value="1" selected>Yes
//            <option value="0">No
