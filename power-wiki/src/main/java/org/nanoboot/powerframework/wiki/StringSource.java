
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
public class StringSource {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(StringSource.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    /**
     * Field description
     */
    private String string;
    private int position = 0;

    /**
     * Constructor
     *
     */
    public StringSource(String string) {
        this.string = string;
    }

    public char getNext() {
        return string.charAt(position++);
    }

    public char getLast() {
        if(position - 1 == 0) {
            return ' ';
        }
        return string.charAt(position - 1);
    }

    public boolean hasNext() {
        return position <= string.length() - 1;
    }

    public char get(int number) {
        return string.charAt(position + number);
    }

}
