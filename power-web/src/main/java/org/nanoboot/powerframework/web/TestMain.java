
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
