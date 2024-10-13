
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

package com.robertvokac.powerframework.xml;

import com.robertvokac.powerframework.core.PowerException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */

public class Attributes implements Buildable {

    public static final char ELEMENT_SPACE = ' ';

    @Getter
    private final List<Attribute> list = new ArrayList<>();
    private final Set<String> allowedAttributes;
    private boolean allowAnyAttribute = false;

    public boolean isAllowAnyAttribute() {
        return allowAnyAttribute;
    }

    public void setAllowAnyAttribute(boolean allowAnyAttribute) {
        this.allowAnyAttribute = allowAnyAttribute;
    }


    public Attributes(Set<String> allowedAttributes) {

        this.allowedAttributes = allowedAttributes;
    }

    public void add(String name, String value) {

        list.add(new Attribute(name, value));
    }


    public void add(Attribute attribute) {
        if (allowedAttributes != null) {
            String attributeName = attribute.getName();
            boolean attributeIsAllowed = XmlUtils.containsSetTheValue(allowedAttributes, attributeName) || allowAnyAttribute;
            boolean attributeIsId = attributeName.equals("id");
            boolean attributeIsClass = attributeName.equals("class");
            if (!(attributeIsAllowed || attributeIsId || attributeIsClass)) {
                throw new PowerException("Attribute " + attribute.getName() + " is not allowed. Only listed attributes are allowed: " + allowedAttributes.toString());
            }
        }

        list.add(attribute);
    }

    public void addAll(Attribute... attribute) {

        for (Attribute a : attribute) {
            add(a);
        }
    }

    /**
     * @param name
     * @return removed attribute, if the attribute was found, otherwise null
     */
    public Attribute remove(String name) {
        if (this.list == null) {
            return null;
        }
        Attribute attributeToBeRemoved = null;
        for (Attribute a : this.list) {
            if (a.getName().equals(name)) {
                attributeToBeRemoved = a;
                break;
            }
        }
        if (attributeToBeRemoved != null) {
            this.getList().remove(attributeToBeRemoved);
            return attributeToBeRemoved;
        } else {
            return null;
        }

    }

    public boolean has(String name) {
        if (this.list == null) {
            return false;
        }
        for (Attribute a : this.list) {
            if (a.getName().equals(name)) {

                return true;
            }
        }
        return false;
    }

    public String get(String name) {
        return getAsAttribute(name).getValue();

    }

    public Attribute getAsAttribute(String name) {

        //System.out.println("seaching attribute " + name + " this.list size is " + this.list.size());
        for(int i = 0; i<this.getList().size();i++){

            Attribute a = this.getList().get(i);
            System.out.println("seaching attribute " + name + " current attribute is " + a.getName());
            if (a.getName().equals(name)) {
                return a;
            }
        }
//        for (Attribute a : this.list) {
//            System.out.println("seaching attribute " + name + " current attribute is " + a.getName());
//            if (a.getName().equals(name)) {
//                return a;
//            }
//        }
        throw new PowerException("There is no attribute " + name);

    }

    public void set(String name, String value) {
        if (!has(name)) {
            throw new PowerException("There is no attribute " + name);
        }
        for (Attribute a : this.list) {
            if (a.getName().equals(name)) {
                a.setValue(value);
                return;
            }
        }
        throw new PowerException("There is no attribute " + name);
    }

    public String build() {
        StringBuilder sb = new StringBuilder();

        for (Attribute a : list) {
            sb.append(ELEMENT_SPACE);
            sb.append(a.build());
        }
        return sb.toString();
    }

    public List<Attribute> toList() {
        List<Attribute> listToReturn = new ArrayList<>();
        for (Attribute a : this.list) {
            listToReturn.add(a.copy());
        }
        return listToReturn;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public String getCache() {
        return null;
    }

    public Attributes copy() {
        Set<String> set = this.allowedAttributes == null ? null : new HashSet<>();
        if (set != null) {
            for (String e : this.allowedAttributes) {
                set.add(e);
            }
        }

        Attributes as = new Attributes(this.allowedAttributes);

        List<Attribute> list2 = new ArrayList<>();//todo
        for (Attribute a : this.list) {
            as.add(a.copy());
        }

        return as;
    }
}
