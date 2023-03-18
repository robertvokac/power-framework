
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

import java.util.ArrayList;

/**
 * Here goes the description of this class.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Block {

    private final ArrayList<String> lines = new ArrayList<>();
    private final ArrayList<String> origLines = new ArrayList<>();
    private final BlockType blockType;

    public Block(BlockType lineType) {
        this.blockType = lineType;
    }

    void addLine(String line) {
        if(blockType.isOneLined() && lines.size() == 1) {
            throw new WikiException(blockType.getDescription() + " is one lined. Cannot add line " + line);
        }
        origLines.add(line);
        if(this.blockType != BlockType.PARSER) {
            line = preProcessLine(line);
        }
        lines.add(line);
    }

    private String preProcessLine(String lineIn) {
        BlockType lineType = BlockType.getBlockType(lineIn);
        if(blockType != lineType) {
            throw new WikiException("Cannot add line to block. Line type is " + lineType + ", but the block type is " + blockType);
        }

        String line = lineIn;
        switch (blockType) {

            //            case OL: {
//                line = line.replace(WikiMarks.ORDERED_LIST, HtmlTags.LI_START);
//                line = line + HtmlTags.LI_END;
//            }
//            break;
//            case UL: {
//                line = line.replace(WikiMarks.UNORDERED_LIST, HtmlTags.LI_START);
//                line = line + HtmlTags.LI_END;
//            }
//            break;
            case BLANK: {

            }
            break;
            case P: {

            }
            break;
            default: {
            }
        }
        return line;
    }

    BlockType getBlockType() {
        return blockType;
    }

    public String getLine(int lineNumber) {
        return lines.get(lineNumber);
    }

    public String toHtml() {
        StringBuilder stringBuilder = new StringBuilder("<span style=\"background-color:orange\">" + this.blockType + "</span><br />");
        int linesMaxIndex = lines.size() - 1;
        int i = 0;
        for (String line : lines) {
            stringBuilder.append(line);
            if(i++ < linesMaxIndex) {
                stringBuilder.append('\n');
            }
        }

        String string = stringBuilder.toString();
        switch (blockType) {

            case H1: {
                string = string.replace(WikiMarks.HEADING1_START, HtmlTags.H1_START);
                string = string.replace(WikiMarks.HEADING1_END, HtmlTags.H1_END);
            }
            break;
            case H2: {
                string = string.replace(WikiMarks.HEADING2_START, HtmlTags.H2_START);
                string = string.replace(WikiMarks.HEADING2_END, HtmlTags.H2_END);
            }
            break;
            case H3: {
                string = string.replace(WikiMarks.HEADING3_START, HtmlTags.H3_START);
                string = string.replace(WikiMarks.HEADING3_END, HtmlTags.H3_END);
            }
            break;
            case H4: {
                string = string.replace(WikiMarks.HEADING4_START, HtmlTags.H4_START);
                string = string.replace(WikiMarks.HEADING4_END, HtmlTags.H4_END);
            }
            break;
            case H5: {
                string = string.replace(WikiMarks.HEADING5_START, HtmlTags.H5_START);
                string = string.replace(WikiMarks.HEADING5_END, HtmlTags.H5_END);
            }
            break;
            case H6: {
                string = string.replace(WikiMarks.HEADING6_START, HtmlTags.H6_START);
                string = string.replace(WikiMarks.HEADING6_END, HtmlTags.H6_END);
            }
            break;
            case LIST: {
                string = HtmlTags.OL_START + '\n' + string + '\n' + HtmlTags.OL_END;
            }
            break;
//            case UL: {
//                string = HtmlTags.UL_START + '\n' + string + '\n' + HtmlTags.UL_END;
//            }
//            break;
            case BLANK: {

            }
            break;
            case P: {
                string = HtmlTags.P_START + '\n' + string + '\n' + HtmlTags.P_END;
            }
            break;
            default: {
            }
        }
        //s = "\n\n\n\n### ZZZZZZZZZZZZZZZZZZZ ###\n" + s + "\n---------------------\n" + string + "\n-----------------";
        //System.out.println(s);
        string = "<!-- Block begins- lineType=" + this.blockType.getDescription() + " -->\n" + string + "\n<!-- Block ends- lineType=" + this.blockType.getDescription() + " -->";
        return string;
    }
    public String getOrig(){
        StringBuilder stringBuilder=new StringBuilder();
        for(String e:origLines){
            stringBuilder.append(e).append("\n");
        }
        return stringBuilder.toString();
    }

}
