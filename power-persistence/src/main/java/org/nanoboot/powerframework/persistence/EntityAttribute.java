
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
import org.nanoboot.powerframework.persistence.annotations.Attribute;
import org.nanoboot.powerframework.persistence.annotations.AttributeName;
import org.nanoboot.powerframework.persistence.annotations.ForeignEntity;
import org.nanoboot.powerframework.persistence.annotations.UUID;
import org.nanoboot.powerframework.utils.NamingConvention;

/**
 * Here goes the description of this class.
 *
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class EntityAttribute {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(EntityAttribute.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    static EntityAttribute create(Field fIn) {
        try {
            return new EntityAttribute(fIn);
        } catch (PersistenceException e) {
            //e.printStackTrace();
            System.out.println(fIn.getName() + " failed");
            return null;
        }

    }

    private String name;
    private AttributeType type;
    private Class entity;
    private boolean uuid = false;
    private String javaName;
    private String javaType;

    private EntityAttribute(Field field) {
        System.out.println("Processing field " + field.getName());
        boolean isColumn = false;
        String columnName = null;
        Class foreignEntity = null;

        for (Annotation a : field.getDeclaredAnnotations()) {
            System.out.println("Found annotation " + a.annotationType());
            if(a instanceof Attribute) {
                isColumn = true;
                continue;
            }
            if(a instanceof AttributeName) {
                columnName = ((AttributeName) a).name();
                continue;
            }

            if(a instanceof ForeignEntity) {
                foreignEntity = ((ForeignEntity) a).clazz();
                continue;
            }
            if(a instanceof UUID) {
                uuid = true;
                continue;
            }

        }
        if(!isColumn) {
            throw new PersistenceException("Field " + field.getName() + " in class " + field.getDeclaringClass().getName() + " is not annotated with @Column");
        }
        if(columnName == null) {
            columnName = org.nanoboot.powerframework.utils.NamingConventionConvertor.convert(field.getName(), NamingConvention.JAVA_FIELD, NamingConvention.DATABASE);
        }
        name = columnName;
        type = AttributeType.getAttributeType(field);
        entity = foreignEntity;
        javaName = field.getName();
        javaType = loadJavaType(field);

    }

    public String getName() {
        return name;
    }

    public AttributeType getType() {
        return type;
    }

    public Class getEntity() {

        return entity;
    }

    public boolean isUUID() {
        return uuid;
    }

    public boolean isForeignEntity() {
        return entity != null;
    }

    public String getJavaName() {
        return javaName;
    }

    public String getJavaType() {
        return javaType;
    }

    static String loadJavaType(Field fieldIn) {
        return fieldIn.getType().getCanonicalName();
    }
}
