
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
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 *
 */
public class TextFormatter {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(TextFormatter.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    /**
     * Field description
     */
    private String name;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private TextFormatter() {
    }

    public static String format(String text) {
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

}
