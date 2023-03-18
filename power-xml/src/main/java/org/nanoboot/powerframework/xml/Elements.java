
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

package org.nanoboot.powerframework.xml;

import org.nanoboot.powerframework.core.PowerException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Elements implements Buildable {

    @Getter
    private final List<Element> list = new ArrayList<>();

    @Getter
    private final Element parent;

    private final Set<String> allowedElements;
    private boolean allowAnyElement = false;

    public boolean isAllowAnyElement() {
        return allowAnyElement;
    }

    public void setAllowAnyElement(boolean allowAnyElement) {
        this.allowAnyElement = allowAnyElement;
    }

    public Elements(Element parent, Set<String> allowedElements) {
        this.parent = parent;
        this.allowedElements = allowedElements;
    }

    public Elements addInnerText(String innerText) {
        this.add(new NoElement(innerText));
        return this;
    }

    public Elements add(Element element) {
        if (!this.parent.isPaired()) {
            throw new PowerException("Only paired elements can have children");
        }
        if (element == null) {
            throw new RuntimeException("Element is null");
        }

        if (allowedElements != null) {
            if (!allowAnyElement && !XmlUtils.containsSetTheValue(allowedElements, element.getElementName())) {
                throw new PowerException("Element " + element.getElementName() + " is not allowed. Only listed elements are allowed: " + allowedElements.toString());
            }


        }
        this.list.add(element);
        return this;
    }

    public Elements addAll(Element... elements) {
        for (Element element : elements) {

            add(element);
        }
        return this;
    }

    public void removeAll() {
        this.list.clear();
    }


    public List<Element> toList() {
        List<Element> listToReturn = new ArrayList<>();
        for (Element e : this.list) {
            listToReturn.add(e.copy());
        }
        return listToReturn;
    }

    public String build() {
        if (this.list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Element element : this.list) {
            if (element == null) {
                throw new RuntimeException("Element is null");
            }
            sb.append(Constants.NEW_LINE);
            sb.append(element.build());
        }
        return sb.toString();
    }

    public Element getByElementName(String... a) {

        for (Element e : this.list) {
            if (e.getElementName().equals(a[0])) {
                if(a.length==1) {
                    return e;
                }else{
                    getByElementName(removeFirstField(a));
                }

            }
        }
        return null;
    }

    public String[] removeFirstField(String[] ar){
        String[] a=new String[ar.length-1];
        for(int i=1;i<ar.length;i++){
            a[i-1]=ar[i];
        }
        return a;
    }


    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public String getCache() {
        return null;
    }

    public List<Element> loadElements(){
        List<Element> list=new ArrayList<>();
        for(Element e:this.list){
            list.addAll(e.getElements().loadElements());
        }

        return list;
    }

}
