
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

package org.nanoboot.powerframework.wiki;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class HtmlTags {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(HtmlTags.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    static final String B_START = "<b>";
    public static final String B_END = "</b>";
    public static final String I_START = "<i>";
    public static final String I_END = "</i>";
    public static final String U_START = "<u>";
    public static final String U_END = "</u>";
    public static final String COLOURED_START = "<span style=\"colour:%s\">";
    public static final String COLOURED_END = "</span>";
    public static final String BACKGROUND_HIGHLIGHTED_START = "<span style=\"background-colour:%s\">";
    public static final String BACKGROUND_HIGHLIGHTED_END = "</span>";
    public static final String SUPER_SCRIPT_START = "<sup>";
    public static final String SUPER_SCRIPT_END = "</sup>";
    public static final String SUB_SCRIPT_START = "<sub>";
    public static final String SUB_SCRIPT_END = "</sub>";
    public static final String MONOSPACE_START = "<span style=\"font-family: monospace, monospace;\">";
    public static final String MONOSPACE_SCRIPT_END = "</span>";
    public static final String STROKE_START = "<span style=\"text-decoration: line-through;\">";
    public static final String STROKE_END = "</span>";
    public static final String SMALLER_START = "<span style=\"font-size: 60%;\">";
    public static final String SMALLER_END = "</span>";
    public static final String LARGER_START = "<span style=\"font-size:140%;\">";
    public static final String LARGER_END = "</span>";
    public static final String LINK = "<a href=\"%s\">%s</a>";
    public static final String EMBED_IMG = "<img src=\"%s\" alt=\"%s\">";
    public static final String SIZE_START = "<span style=\"font-size:%s;\">";
    public static final String SIZE_END = "</span>";

    public static final String H1_START = "<h1>";
    public static final String H1_END = "</h1>";
    public static final String H2_START = "<h2>";
    public static final String H2_END = "</h2>";
    public static final String H3_START = "<h3>";
    public static final String H3_END = "</h3>";
    public static final String H4_START = "<h4>";
    public static final String H4_END = "</h4>";
    public static final String H5_START = "<h5>";
    public static final String H5_END = "</h5>";
    public static final String H6_START = "<h6>";
    public static final String H6_END = "</h6>";

    public static final String OL_START = "<ol>";
    public static final String OL_END = "</ol>";
    public static final String UL_START = "<ul>";
    public static final String UL_END = "</ul>";
    public static final String LI_START = "<li>";
    public static final String LI_END = "</li>";
    public static final String P_START = "<p>";
    public static final String P_END = "</p>";

    public static final String TABLE_START = "<table>";
    public static final String TABLE_END = "</table>";
    public static final String TR_START = "<tr>";
    public static final String TR_END = "</tr>";
    public static final String TH_START = "<th>";
    public static final String TH_END = "</th>";
    public static final String TD_START = "<td>";
    public static final String TD_END = "</td>";

    public static final String HR4 = "<hr style=\"height: 1px;\">";
    public static final String HR5 = "<hr style=\"height: 2px;\">";
    public static final String HR6 = "<hr style=\"height: 3px;\">";
    public static final String HR7 = "<hr style=\"height: 4px;\">";
    public static final String HR8 = "<hr style=\"height: 5px;\">";
    public static final String HR9 = "<hr style=\"height: 6px;\">";
    public static final String HR10 = "<hr style=\"height: 7px;\">";

    public static final String COMMENT_TEMPLATE = "<!-- %s -->";

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private HtmlTags() {
    }

}
