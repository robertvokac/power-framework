
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
import lombok.Setter;

import java.util.Set;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class Element implements XmlTypeI, Buildable {
    public static final char TAG_START = '<';
    public static final char TAG_END = '>';
    public static final char ELEMENT_END = '/';
    public static final char ELEMENT_SPACE = ' ';

    @Getter
    private final String elementName;

    @Getter
    private final ElementType elementType;

    @Getter
    @Setter
    private Elements elements = new Elements(this, this.getAllowedElements());

    @Getter
    @Setter
    private Attributes attributes = new Attributes(this.getAllowedAttributes());

    /**
     * @return null if all attributes are allowed
     */
    public Set<String> getAllowedAttributes() {
        return null;
    }

    /**
     * @return null if all attributes are allowed
     */
    public Set<String> getAllowedElements() {
        return null;
    }


    public Element(String elementName, String content) {
        this(elementName);
        this.getNoElement().setPlainText(content);
    }
    public Element(String elementName, XmlTypeI... xmlTypes) {
        this(elementName);
        add(xmlTypes);
    }

    public Element(String elementName, ElementType elementType, XmlTypeI... xmlTypes) {
        this(elementName, elementType);
        add(xmlTypes);

    }

    public void add(XmlTypeI... xmlTypeIs) {
        for (XmlTypeI e : xmlTypeIs) {
            add(e);
        }
    }
    public void add(XmlTypeI xmlTypeIs) {
            boolean isElement = xmlTypeIs instanceof Element;
            boolean isAttribute = xmlTypeIs instanceof Attribute;
            if (isElement) {
                Element var = (Element) xmlTypeIs;
                this.getElements().add(var);
               return;
            }
            if (isAttribute) {
                Attribute var = (Attribute) xmlTypeIs;
                this.getAttributes().add(var);
                return;
            }
            throw new PowerException("It is not an XmlTypeI");

    }
    /**
     * Creates new paired element
     *
     * @param elementName
     */
    public Element(String elementName) {
        this(elementName, ElementType.PAIRED);
    }

    /**
     * Creates new element with the specified type
     *
     * @param elementName
     * @param elementType
     */
    public Element(String elementName, ElementType elementType) {
        this.elementName = elementName;
        this.elementType = elementType;
    }

    public Element getByElementName(String elementName) {
        return elements.getByElementName(elementName);
    }

    public boolean isPaired() {
        return this.elementType == ElementType.PAIRED;
    }

    public Element setInnerText(String text) {
        this.getNoElement().setPlainText(text);
        return this;
    }

    public NoElement getNoElement() {
        NoElement ne = null;
        try {
            ne = (NoElement) getByElementName(NoElement.NAME);
        } catch (Exception e) {

        }

        if(ne==null){
            ne = new NoElement();
            this.add(ne);
        }
        return ne;

    }

    public String build() {

        StringBuilder sb = new StringBuilder();
        sb.append(TAG_START);
        sb.append(elementName);
        if (attributes != null) {
            sb.append(attributes.build());
        }

        if (isPaired()) {
            sb.append(TAG_END);

            sb.append(elements.build());

//            sb.append(Constants.NEW_LINE);
            sb.append(TAG_START);
            sb.append(ELEMENT_END);
            sb.append(elementName);
            sb.append(TAG_END);
        }
        if (!isPaired()) {
            sb.append(ELEMENT_SPACE);
            sb.append(ELEMENT_END);
            sb.append(TAG_END);
        }
        return sb.toString();
    }


    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public String getCache() {
        return null;
    }

    public String toString() {
        return build();
    }

    public XmlType getXmlType() {
        return XmlType.ELEMENT;
    }

    public final Element copy() {
        Element e = new Element(this.elementName, this.elementType);
        //TODO: elements and attributes should also call a copy method.
        for (Element ee : this.elements.toList()) {
            e.add(ee);
        }

        for (Attribute aa : this.attributes.toList()) {
            e.add(aa);
        }
        return e;

    }

    public Elements getElements() {
        return elements;
    }
    
    public void insertInto(Element element) {
        element.add(this);
    }
}
