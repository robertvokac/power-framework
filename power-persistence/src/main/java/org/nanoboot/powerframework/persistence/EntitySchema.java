
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.nanoboot.powerframework.persistence.annotations.Entity;
import org.nanoboot.powerframework.persistence.annotations.EntityName;
import org.nanoboot.powerframework.utils.NamingConvention;
import org.nanoboot.powerframework.utils.annotations.Done;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class EntitySchema {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(EntitySchema.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";
    private static final Map<String, EntitySchema> map = new HashMap<>();

    private String name;
    private String uuid = null;
    private String UUIDJavaName = null;

    private final java.util.ArrayList<EntityAttribute> attributesList = new java.util.ArrayList<>();

    @Done
    public static EntitySchema getSchema(Class clazz) {

        String entityName = getEntityNameFromClass(clazz);
        return getSchemaByName(entityName, clazz);
    }

    @Done
    private static String getEntityNameFromClass(Class clazz) {
        String entityName = null;
        boolean isEntity = false;
        for (Annotation a : clazz.getAnnotations()) {
            System.out.println("Found annotation " + a.toString());
            if(a instanceof Entity) {
                isEntity = true;
                continue;
            }
            if(a instanceof EntityName) {
                entityName = ((EntityName) a).name();
                continue;
            }
        };
        if(!isEntity) {
            throw new PersistenceException("Class " + clazz + " is not annotated with @Entity. Cannot create schema from this class");
        }
        if(entityName != null) {
            return entityName;
        }
        entityName = org.nanoboot.powerframework.utils.NamingConventionConvertor.convert(clazz.getName(), NamingConvention.JAVA_FIELD, NamingConvention.DATABASE);
        return entityName;
    }

    @Done
    private static EntitySchema getSchemaByName(String entityName, Class clazz) {
        if(!map.containsKey(entityName)) {
            map.put(entityName, new EntitySchema(clazz));
        }
        return map.get(entityName);
    }

    private EntitySchema(Class clazz) {
        this.name = getEntityNameFromClass(clazz);
        loadAttributesList(clazz);
        for (EntityAttribute a : attributesList) {
            if(a.isUUID()) {
                this.uuid = a.getName();
                this.UUIDJavaName = a.getJavaName();
            }
        }
        if(uuid == null) {
            throw new PersistenceException("Class " + clazz + " has no field annotated with @UUID. Cannot create schema from this class");

        }

    }

    private void loadAttributesList(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("class " + clazz + " has " + fields.length);
        for (Field f : fields) {

            EntityAttribute attribute = EntityAttribute.create(f);
            System.out.println("Attribute for " + f.getName() + " is " + attribute);
            if(attribute != null) {

                attributesList.add(attribute);
            }
        }
        System.out.println("attributesList.size()=" + attributesList.size());

    }

    public String getName() {
        return name;
    }

    public String getIdName() {
        return uuid;
    }

    public ArrayList<EntityAttribute> getForeingKeys() {
        ArrayList<EntityAttribute> list = new ArrayList<>();
        for (EntityAttribute a : getAttributesList()) {
            if(a.isForeignEntity()) {
                list.add(a);
            }
        }
        return list;
    }

    /**
     * Field description
     */
    public ArrayList<EntityAttribute> getAttributesList() {
        return attributesList;
    }

    public String getIdJavaName() {
        return UUIDJavaName;
    }

    public String createSqlCreateStatement() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(this.getName());
        stringBuilder.append("(\n");

        int aCount = getAttributesList().size();
        int attributeNumber = 0;
        for (EntityAttribute a : getAttributesList()) {
            attributeNumber++;
            stringBuilder.append("\t");
            stringBuilder.append(a.getName());
            stringBuilder.append(" ");
            if(a.getType() == AttributeType.ENTITY || a.getType() == AttributeType.BOOLEAN || a.getType() == AttributeType.NUMBER) {
                stringBuilder.append("INTEGER");
            } else {
                stringBuilder.append(a.getType().name());
            }
            if(a.isUUID()) {
                stringBuilder.append(" PRIMARY KEY");
            }
            if(attributeNumber < aCount) {
                stringBuilder.append(", ");
            }

            stringBuilder.append("\n");
        }

        ArrayList<EntityAttribute> foreignKeysList = getForeingKeys();
        int foreingKeysCount = foreignKeysList.size();
        if(!getForeingKeys().isEmpty()) {
            attributeNumber = 0;

            for (EntityAttribute a : foreignKeysList) {
                attributeNumber++;
                stringBuilder.append(", \n");
                stringBuilder.append("FOREIGN KEY(");
                stringBuilder.append(a.getName());
                stringBuilder.append(") REFERENCES ");

                EntitySchema foreingKeyEntitySchema = EntitySchema.getSchema(a.getEntity());
                stringBuilder.append(foreingKeyEntitySchema.getName());
                stringBuilder.append(" (");
                stringBuilder.append(foreingKeyEntitySchema.getIdName());
                stringBuilder.append(")");

                if(attributeNumber < foreingKeysCount) {
                    stringBuilder.append(", ");
                }

                stringBuilder.append("\n");
            }
        }
        stringBuilder.append(");");
        return stringBuilder.toString();
    }
}
