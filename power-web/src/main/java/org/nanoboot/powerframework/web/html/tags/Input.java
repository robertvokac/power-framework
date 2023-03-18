
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

import org.nanoboot.powerframework.xml.ElementType;
import org.nanoboot.powerframework.xml.XmlUtils;
import org.nanoboot.powerframework.web.html.attributes.Name;
import org.nanoboot.powerframework.web.html.attributes.Type;
import org.nanoboot.powerframework.web.html.attributes.Value;
import org.nanoboot.powerframework.web.html.WebElement;
import org.nanoboot.powerframework.xml.XmlTypeI;

import java.util.Set;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Input extends WebElement {

    public static final String NAME = "input";

    public static final Set<String> ALLOWED_ATTRIBUTES
            = XmlUtils.createNewSet(Name.NAME, Type.NAME, Value.NAME);

    public Input(XmlTypeI xmlTypes) {
        this();
        add(xmlTypes);
    }

    public Input() {
        super(NAME, ElementType.NOT_PAIRED);

    }

    public Input(String name, String value) {
        this(null, name, value);
    }

    public Input(InputType type, String name, String value) {
        this();
        if (type != null) {
            withType(type);
        }
        withNameAndValue(name, value);
    }

    public Input withType(InputType type) {
        this.add(new Type(type.name().toLowerCase()));
        return this;
    }

    public Input withType(String type) {
        this.add(new Type(type));
        return this;
    }

    public Input withNameAndValue(String name, String value) {
        withName(name);
        withValue(value);
        return this;
    }

    public Input withName(String name) {
        if (name != null) {
            this.add(new Name(name));
        }
        return this;
    }

    public Input withValue(String value) {
        this.add(new Value(value));
        return this;
    }

    @Override
    public Set<String> getAllowedAttributes() {
        return ALLOWED_ATTRIBUTES;
    }

}
