
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

package org.nanoboot.powerframework.web.html;

import org.nanoboot.powerframework.web.PrettyPrinter;
import org.nanoboot.powerframework.web.css.CssStylesSelectors;
import org.nanoboot.powerframework.web.html.tags.Head;
import org.nanoboot.powerframework.web.html.tags.Html;
import org.nanoboot.powerframework.web.html.tags.Style;
import org.nanoboot.powerframework.xml.Buildable;
import org.nanoboot.powerframework.xml.Element;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class WebPage implements Buildable {
    @Getter
    private Html rootElement = new Html();

    public WebPage() {
        Map<String, CssStylesSelectors> allCssStylesSelectors = loadAllCssStylesSelectors();
        if (!allCssStylesSelectors.isEmpty()) {
            Head head = (Head) this.getElementByNamePath(("html.head"));
            Style style = (Style) head.getByElementName("style");
            if (style == null) {
                style = new Style();
                head.add(style);
            }
            for (Map.Entry<String, CssStylesSelectors> entry : allCssStylesSelectors.entrySet()) {

                style.getElements().addInnerText(entry.getValue().build());
            }
        }
    }


    public String build() {
        String result = "<!doctype html> \n" + rootElement.build();
        String prettyResult = null;
        try {
            prettyResult = PrettyPrinter.makePretty(result);
        } catch (Exception e) {
            System.err.println(e);
        }
        return prettyResult == null ? result : prettyResult;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public String getCache() {
        return null;
    }

    /**
     * Remove me
     *
     * @param elementNamePath
     * @return
     */
    @Deprecated
    public WebElement getElementByNamePath(String elementNamePath) {
        return null;
    }

    private Map<String, CssStylesSelectors> loadAllCssStylesSelectors() {
        Map<String, CssStylesSelectors> map = new HashMap<>();

        for (Element e : loadAllElements()) {
            WebElement we = (WebElement) e;
            if (we.getCssStylesSelectors() == null) {
                break;
            }
            if (map.containsKey(we.getCssStylesSelectors().getUuid())) {
                continue;
            }
            map.put(we.getCssStylesSelectors().getUuid(), we.getCssStylesSelectors());

        }


        return map;
    }

    private List<Element> loadAllElements() {
        return this.rootElement.getElements().loadElements();


    }
}
