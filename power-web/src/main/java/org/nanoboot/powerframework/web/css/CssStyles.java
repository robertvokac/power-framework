
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

package org.nanoboot.powerframework.web.css;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class CssStyles {

    public static final String SEPARATOR = "; ";

    @Getter
    private final List<CssStyle> cssStyles = new ArrayList<>();

    public CssStyles(String moreStyles){
        String[] a=moreStyles.split(";");
        for(String e:a){
            if(e.isEmpty()){
                continue;
            }
            this.add(new CssStyle(e));
        }
    }

    public CssStyles(CssStyle... cssStyles) {
        this.addAll(cssStyles);
    }


    public void add(String name, String value) {
        cssStyles.add(new CssStyle(name, value));
    }

    public void add(CssStyle cssStyle) {

        cssStyles.add(cssStyle);
    }

    public void addAll(CssStyle... cssStyle) {

        for (CssStyle a : cssStyle) {
            cssStyles.add(a);
        }
    }

    public boolean has(String name) {
        if (this.cssStyles == null) {
            return false;
        }
        for (CssStyle a : this.cssStyles) {
            if (a.getName().equals(name)) {

                return true;
            }
        }
        return false;
    }

    public String get(String name) {

        for (CssStyle a : this.cssStyles) {
            if (a.getName().equals(name)) {
                return a.getValue();
            }
        }
        throw new RuntimeException("There is no style " + name);
    }

    public void set(String name, String value) {
        if (!has(name)) {
            throw new RuntimeException("There is no style " + name);
        }
        for (CssStyle a : this.cssStyles) {
            if (a.getName().equals(name)) {
                a.setValue(value);
                return;
            }
        }
        throw new RuntimeException("There is no style " + name);
    }
    public String build() {
        StringBuilder sb = new StringBuilder();
        for (CssStyle a : this.getCssStyles()) {
            sb.append(a);
            sb.append(SEPARATOR);}
        sb.toString();
        return sb.toString();
    }


}
