
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

package org.nanoboot.powerframework.sql.filter;

/**
 * SqlConjunction Class.
 * 
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class SqlConjunction extends AbstractFilter {

    public static final String AND = "AND";
    public static final String OR = "OR";

    public SqlConjunction(final String conjunction, final Object... object) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        int operationCount = object.length;
        if (operationCount == 0) {
            this.result = "";
            return;
        }
        if (operationCount == 1) {
            this.result = object.toString();
            return;
        }
        int index = 0;
        final int maxIndex = object.length - 1;
        for (Object o : object) {
            stringBuilder.append(o);

            if (index++ != maxIndex) {
                stringBuilder.append(' ');
                stringBuilder.append(conjunction);
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append(')');
        this.result = stringBuilder.toString();

    }

    public SqlConjunction(final String raw) {

        this.result = raw;

    }

}
