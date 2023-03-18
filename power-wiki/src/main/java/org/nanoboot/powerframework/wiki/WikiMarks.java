
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
 *
 */
public class WikiMarks {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(WikiMarks.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    public static final String BOLD = "\\*\\*";
    public static final String ITALIC = "//";
    public static final String UNDERLINED = "__";
    public static final String COLOURED = "$$";
    public static final String BACKGROUND_HIGHLIGHTED = "##";
    public static final String SUPERSCRIPT = "^";
    public static final String SUBSCRIPT = ",,";
    public static final String MONOSPACE = "`";
    public static final String STROKE = "--";
    public static final String SMALLER_START = "~-";
    public static final String SMALLER_END = "-~";
    public static final String LARGER_START = "~+";
    public static final String LARGER_END = "+~";

    public static final String LINK_START = "[[";
    public static final String LINK_END = "]]";
    public static final String EMBED_START = "{{";
    public static final String EMBED_END = "}}";
    public static final String SIZE = "&&";

    public static final String MACRO_START = "<<";
    public static final String MACRO_END = ">>";

    public static final String PARSER_START = "{{{";
    public static final String PARSER_END = "}}}";

    public static final String HEADING1_START = "= ";
    public static final String HEADING2_START = "== ";
    public static final String HEADING3_START = "=== ";
    public static final String HEADING4_START = "==== ";
    public static final String HEADING5_START = "===== ";
    public static final String HEADING6_START = "====== ";
    public static final String HEADING1_END = " =";
    public static final String HEADING2_END = " ==";
    public static final String HEADING3_END = " ===";
    public static final String HEADING4_END = " ====";
    public static final String HEADING5_END = " =====";
    public static final String HEADING6_END = " ======";
    public static final String UNORDERED_LIST = " *";
    public static final String ORDERED_LIST = " 1.";
    public static final String TABLE_BORDER = " || ";
    public static final String TABLE_COLOURED = "$$$";
    public static final String TABLE_BACKGROUND_HIGHLIGHTED = "###";

    public static final String HORIZONTAL_RULE_4 = "----";
    public static final String HORIZONTAL_RULE_5 = "-----";
    public static final String HORIZONTAL_RULE_6 = "------";
    public static final String HORIZONTAL_RULE_7 = "-------";
    public static final String HORIZONTAL_RULE_8 = "--------";
    public static final String HORIZONTAL_RULE_9 = "---------";
    public static final String HORIZONTAL_RULE_10 = "----------";
    public static final String COMMENT_LINE_BEGINNING = "####";

    /**
     * Field description
     */
    private String name;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private WikiMarks() {
    }

}
