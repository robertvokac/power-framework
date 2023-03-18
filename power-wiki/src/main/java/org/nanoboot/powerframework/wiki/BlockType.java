
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
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

enum BlockType {

    H1("Heading 1", true),
    H2("Heading 2", true),
    H3("Heading 3", true),
    H4("Heading 4", true),
    H5("Heading 5", true),
    H6("Heading 6", true),
    LIST("List", false),
    BLANK("Blank line", true),
    P("Paragraph", false),
    TABLE("Table", false),
    PARSER("Parser", false),
    HR("Horizontal rule", false),
    CONTENT("Content", false),
    COMMENT("Comment", false);

    private String description;
    private boolean oneLined;

    BlockType(String string, boolean oneLined) {
        this.description = string;
        this.oneLined = oneLined;
    }

    static BlockType getBlockType(String line) {
        if(line.isEmpty()) {
            return BlockType.BLANK;
        }
        if(lineIsH1(line)) {
            return BlockType.H1;
        }
        if(lineIsH2(line)) {
            return BlockType.H2;
        }
        if(lineIsH3(line)) {
            return BlockType.H3;
        }
        if(lineIsH4(line)) {
            return BlockType.H4;
        }
        if(lineIsH5(line)) {
            return BlockType.H5;
        }
        if(lineIsH6(line)) {
            return BlockType.H6;
        }
        if(lineIsList(line)) {
            return BlockType.LIST;
        }

        if(lineIsTable(line)) {
            return BlockType.TABLE;
        }
        if(lineIsParser(line)) {
            return BlockType.PARSER;
        }
        if(lineIsHR(line)) {
            return BlockType.HR;
        }
        if(lineIsComment(line)) {
            return BlockType.COMMENT;
        }

        return BlockType.P;
    }

    private static boolean lineIsH1(String line) {
        return line.startsWith(WikiMarks.HEADING1_START);
    }

    private static boolean lineIsH2(String line) {
        return line.startsWith(WikiMarks.HEADING2_START);
    }

    private static boolean lineIsH3(String line) {
        return line.startsWith(WikiMarks.HEADING3_START);
    }

    private static boolean lineIsH4(String line) {
        return line.startsWith(WikiMarks.HEADING4_START);
    }

    private static boolean lineIsH5(String line) {
        return line.startsWith(WikiMarks.HEADING5_START);
    }

    private static boolean lineIsH6(String line) {
        return line.startsWith(WikiMarks.HEADING6_START);
    }

    private static boolean lineIsList(String line) {
        line = " " + line.trim();
        return line.startsWith(WikiMarks.UNORDERED_LIST) || line.startsWith(WikiMarks.ORDERED_LIST);
    }

    private static boolean lineIsTable(String line) {
        return line.startsWith(WikiMarks.TABLE_BORDER);
    }

    private static boolean lineIsParser(String line) {
        return line.startsWith(WikiMarks.PARSER_START);
    }

    private static boolean lineIsHR(String line) {
        return line.startsWith(WikiMarks.HORIZONTAL_RULE_4);
    }

    private static boolean lineIsComment(String line) {
        return line.startsWith(WikiMarks.COMMENT_LINE_BEGINNING);
    }

    public String getDescription() {
        return description;
    }

    public boolean isOneLined() {
        return this.oneLined;
    }

    public static boolean isIn(BlockType blockType, BlockType... blockTypes) {
        for (BlockType e : blockTypes) {
            if(e == blockType) {
                return true;
            }
        }
        return false;
    }
}
