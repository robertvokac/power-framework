
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

package org.nanoboot.powerframework.web.html.tags;

import org.nanoboot.powerframework.web.html.attributes.Id;
import org.nanoboot.powerframework.xml.XmlUtils;
import org.nanoboot.powerframework.web.html.attributes.Action;
import org.nanoboot.powerframework.web.html.attributes.Method;
import org.nanoboot.powerframework.web.html.attributes.Name;
import org.nanoboot.powerframework.web.html.WebElement;
import org.nanoboot.powerframework.xml.NoElement;
import org.nanoboot.powerframework.xml.XmlTypeI;

import java.util.Set;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Form extends WebElement {

    public static final String NAME = "form";
    public static final Set<String> ALLOWED_ELEMENTS
            = XmlUtils.createNewSet(Input.NAME, Br.NAME, Label.NAME, Select.NAME);

    public static final Set<String> ALLOWED_ATTRIBUTES
            = XmlUtils.createNewSet(Name.NAME, Action.NAME, Method.NAME, NoElement.NAME, Id.NAME);

    public Form(XmlTypeI xmlTypes) {
        this();
        add(xmlTypes);
    }

    public Form() {
        super(NAME);

    }

    public Form(String action, FormMethod method) {
        this();
        getAttributes().add("action", action);
        getAttributes().add("method", method.name());

    }

    public Form(String action, String method) {
        this();
        getAttributes().add("action", action);
        getAttributes().add("method", method);

    }

    @Override
    public Set<String> getAllowedElements() {
        return ALLOWED_ELEMENTS;
    }

    @Override
    public Set<String> getAllowedAttributes() {
        return ALLOWED_ATTRIBUTES;
    }

}
