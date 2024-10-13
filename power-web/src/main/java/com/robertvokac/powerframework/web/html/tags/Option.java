
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

package com.robertvokac.powerframework.web.html.tags;

import com.robertvokac.powerframework.web.html.WebElement;
import com.robertvokac.powerframework.web.html.attributes.Id;
import com.robertvokac.powerframework.web.html.attributes.Name;
import com.robertvokac.powerframework.xml.XmlUtils;

import java.util.Set;
import com.robertvokac.powerframework.xml.Attribute;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
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
