
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
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Select extends WebElement {

    public static final String NAME = "select";

    public static final Set<String> ALLOWED_ATTRIBUTES
            = XmlUtils.createNewSet(Name.NAME, Id.NAME, "size", "form");

    public Select() {
        super(NAME);

    }

    public Select withNameAndId(String id) {
        withId(id);
        withName(id);
        return this;
    }
    public Select withId(String id) {
        this.add(new Id(id));
        return this;
    }
    public Select withName(String name) {
        this.add(new Name(name));
        return this;
    }

    @Override
    public Set<String> getAllowedAttributes() {
        return ALLOWED_ATTRIBUTES;
    }
}
