
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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.nanoboot.powerframework.utils.StringUtils;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 *
 */
public class WikiParser {

    /**
     * Logger for this class.
     */
    //private static final org.nanoboot.powerframework.logging.Logger LOG = org.nanoboot.powerframework.logging.Logger.getLogger(WikiParser.class);
    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    /**
     * Field description
     */
    private static TextProcessorI linkProcessor;
    private static final Map<String, TextProcessorI> macroProcessorsList = new HashMap<>();

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    public static void setLinkProcessor(TextProcessorI linkProcessorIn) {
        linkProcessor = linkProcessorIn;
    }

    public String convertWiki(String wikiText) {
        System.out.println("Converting wiki text:\n\n"+wikiText);
        ArrayList<Block> blocks = splitWikiTextToBlocks(wikiText);
        StringBuilder stringBuilder = new StringBuilder();
        for (Block block : blocks) {
            System.out.println("\n====================\n"+block.getBlockType()+"\n\n");
            String html = block.toHtml();
            System.out.println(block.getOrig()); 
            System.out.println("VVVVVVVVVVVVVVVVVVVV");
System.out.println(html);
            stringBuilder.append(html).append('\n').append('\n');
        }
        String string = stringBuilder.toString();
        return string;
    }

    public void setStyle(String string) {

    }

    public void addMacroProcessor(TextProcessorI macroProcessor) {
        macroProcessorsList.put(macroProcessor.getName(), macroProcessor);
    }

    public TextProcessorI getMacroProcessor(String macroName) {
        return macroProcessorsList.get(macroName);
    }

    @Deprecated
    public static String convert(String wikiText) {

        //System.err.println("\n\n\nWIKI" + "\n{\n" + wikiText + "\n}######$$$");
        while (true) {
            if(wikiText.contains(WikiMarks.BOLD)) {
                wikiText = wikiText.replaceFirst(WikiMarks.BOLD, HtmlTags.B_START);
                //System.err.println(String.format("Replacing %s by %s", BOLD, B_START));
            }
            if(wikiText.contains(WikiMarks.BOLD)) {
                wikiText = wikiText.replaceFirst(WikiMarks.BOLD, HtmlTags.B_END);
                //System.err.println(String.format("Replacing %s by %s", BOLD, B_END));
            }

            if(!wikiText.contains(WikiMarks.BOLD)) {
                break;
            }
        }

        while (true) {

            if(wikiText.contains(WikiMarks.ITALIC)) {
                wikiText = wikiText.replaceFirst(WikiMarks.ITALIC, HtmlTags.I_START);
                //System.err.println(String.format("Replacing %s by %s", ITALIC, I_START));
            }
            if(wikiText.contains(WikiMarks.ITALIC)) {
                wikiText = wikiText.replaceFirst(WikiMarks.ITALIC, HtmlTags.I_END);
                //System.err.println(String.format("Replacing %s by %s", ITALIC, I_END));
            }
            if(!wikiText.contains(WikiMarks.ITALIC)) {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<Block> blocks = splitWikiTextToBlocks(wikiText);

//        StringBuilder stringBuilder2 = new StringBuilder("Adding block\n\n");
//        for (Block block : blocks) {
//            stringBuilder2.append("\n###{\n").append(block.toHtml()).append("\n}\n");
//        }
        //System.err.println(stringBuilder2);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(WikiParser.class.getName()).log(Level.SEVERE, null, ex);
//        }
        for (Block block : blocks) {
            String html = block.toHtml();

            stringBuilder.append(html).append('\n').append('\n');
        }
        String string = stringBuilder.toString();
        //System.out.println("Wiki convertor returned\n\n\n{\n" + string + "\n}\n\n\n");
        return string;
    }

    @Deprecated
    private String processText(String text) {
        StringSource stringSource = new StringSource(text);
        StringBuilder out = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        while (stringSource.hasNext()) {
            char ch = stringSource.getNext();

            if(ch == '[' && stringSource.getLast() == '[') {
                ch = stringSource.getNext();
                while (!(ch == ']' && stringSource.get(1) == ']')) {
                    buffer.append(ch);
                    if(!stringSource.hasNext()) {
                        break;
                    }
                    ch = stringSource.getNext();
                }
                out.append(buffer.toString());
                buffer.delete(0, buffer.length());
            };

        }

        return out.toString();
    }

    @Deprecated
    public static void replaceOccurences(StringBuilder stringBuilder, String what, String replacement) {
        Pattern.compile(what).matcher(stringBuilder).replaceAll(replacement);
    }

    public static ArrayList<Block> splitWikiTextToBlocks(String wikiText) {
        BlockList blockList = new BlockList();

        ArrayList<Block> blocks;
        String[] lines = StringUtils.toLines(wikiText);

        for (String line : lines) {
            blockList.addLine(line);
        }
        blocks = blockList.getList();

        return blocks;
    }

}
