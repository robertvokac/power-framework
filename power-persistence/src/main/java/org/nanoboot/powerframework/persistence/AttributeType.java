
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

package org.nanoboot.powerframework.persistence;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.nanoboot.powerframework.persistence.annotations.ForeignEntity;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum AttributeType {

    ENTITY,
    NUMBER,
    REAL,
    TEXT,
    BOOLEAN,
    BLOB;

    public static AttributeType getAttributeType(Field field) {

        String canonicalName = EntityAttribute.loadJavaType(field);
        switch (canonicalName) {
            case "int":
                return NUMBER;
            case "long":
                return NUMBER;
            case "byte":
                return NUMBER;
            case "short":
                return NUMBER;
            case "float":
                return REAL;
            case "double":
                return REAL;
            case "boolean":
                return BOOLEAN;
            case "java.lang.Integer":
                return NUMBER;
            case "java.lang.Long":
                return NUMBER;
            case "java.lang.Byte":
                return NUMBER;
            case "java.lang.Short":
                return NUMBER;
            case "java.lang.Float":
                return REAL;
            case "java.lang.Double":
                return REAL;
            case "java.lang.Boolean":
                return BOOLEAN;
            case "java.lang.String":
                return TEXT;
        }
        for (Annotation a : field.getAnnotations()) {
            if(a instanceof ForeignEntity) {
                return ENTITY;
            }
        }
        throw new PersistenceException(("Cannot get AttributeType from canonicalName " + canonicalName));
    }
}
