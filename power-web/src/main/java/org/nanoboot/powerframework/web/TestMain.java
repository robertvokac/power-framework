
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

package org.nanoboot.powerframework.web;

import org.nanoboot.powerframework.web.html.WebPage;
import org.nanoboot.powerframework.web.html.attributes.Content;
import org.nanoboot.powerframework.web.html.attributes.Href;
import org.nanoboot.powerframework.web.html.attributes.HttpEquiv;
import org.nanoboot.powerframework.web.html.attributes.Rel;
import org.nanoboot.powerframework.web.html.tags.*;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TestMain {
    public static void main(String[] args) {
        WebPage page=new WebPage();
        Html html=page.getRootElement();

        Head head = getHead();


        Body body = getBody();

        html.add(head,body);
        System.out.println(page.build());
    }

    private static Head getHead() {
        Head head=new Head();
        Meta meta=new Meta();
        meta.add(new HttpEquiv("content-type"),new Content("text/html; charset=UTF-8"));
        head.add(meta);
        head.add(new Title("Tree Base | Home"));
        head.add(new Link(new Rel("stylesheet"),new Href("/styles/styles.css")));

        return head;
    }

    private static Body getBody() {
        Body body=new Body();
        return body;
    }


}
