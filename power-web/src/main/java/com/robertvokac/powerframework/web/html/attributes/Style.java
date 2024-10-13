
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

package com.robertvokac.powerframework.web.html.attributes;

import com.robertvokac.powerframework.xml.Attribute;
import com.robertvokac.powerframework.web.css.CssStyle;
import com.robertvokac.powerframework.web.css.CssStyles;
import lombok.Getter;
import lombok.Setter;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@robertvokac.com">Robert Vokac</a>
 * @since 0.0.0
 */
public class Style extends Attribute {
    public static final String NAME="style";

    @Getter
    @Setter
    private CssStyles cssStyles = new CssStyles();

    public Style(String moreStyles) {
        this(new CssStyles(moreStyles));
    }

    public Style(CssStyle cssStyle) {
        super(NAME, cssStyle.build());//??
        this.cssStyles.add(cssStyle);
    }
    public Style(CssStyles cssStyles) {
        super(NAME, cssStyles.build());
        for(CssStyle e: cssStyles.getCssStyles()){
            this.cssStyles.add(e);
        }
    }
    public String build(){
        this.setValue(cssStyles.build());
        return super.build();
    }

}
