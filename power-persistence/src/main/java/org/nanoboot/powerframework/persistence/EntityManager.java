
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

import java.util.ArrayList;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.sql.core.ColumnNameValue;
import org.nanoboot.powerframework.db.manager.Database;
import org.nanoboot.powerframework.sql.core.SqlStatementCreator;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class EntityManager {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(EntityManager.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";
    private static final EntityStorage entityStorage = new EntityStorage();

    /**
     * Field description
     */
    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private EntityManager() {
        super();
    }

    private static Database database = null;

    public static void init(Database databaseIn) {
        database = databaseIn;
    }

    public static Database getDatabase() {
        return database;
    }

    public static Object load(Class clazz, String uid) {
        if(!entityStorage.hasEntity(uid)) {
            Object object = loadEntityFromDatabase(clazz, uid);
            entityStorage.putEntity(object);
        }
        return entityStorage.getEntity(uid);

    }

    private static Object loadEntityFromDatabase(Class clazz, String uid) {
        System.out.println(clazz + " " + uid);
        Object object;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException ex) {
            throw new PersistenceException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new PersistenceException(ex.getMessage());
        }
        EntitySchema entitySchema = EntitySchema.getSchema(clazz);
        JsonObject row = getDatabase().getRow(entitySchema.getName(), uid);
        for (EntityAttribute a : entitySchema.getAttributesList()) {
            String columnName = a.getName();
            String columnValue = row.getString(columnName);
            AttributeType type = a.getType();
            String javaName = a.getJavaName();
            String javaType = a.getJavaType();
            System.out.println("Setting " + object.getClass().getName() + " " + javaName + " " + javaType + " " + columnValue);
            setAttribute(object, type, javaName, javaType, columnValue);

        }
        return object;
    }

    private static void setAttribute(Object object, AttributeType attributeType, String javaName, String javaType, String valueIn) {
        switch (javaType) {

            case "int": {
                Integer value = Integer.valueOf(valueIn);
                MethodInvocation.setInt(object, javaName, value);
            }
            ;
            break;
            case "short": {
                Short value = Short.valueOf(valueIn);
                MethodInvocation.setShort(object, javaName, value);
            }
            break;
            case "byte": {
                Byte value = Byte.valueOf(valueIn);
                MethodInvocation.setByte(object, javaName, value);
            }
            break;
            case "long": {
                Long value = Long.valueOf(valueIn);
                MethodInvocation.setLong(object, javaName, value);
            }
            break;
            case "float": {
                Float value = Float.valueOf(valueIn);
                MethodInvocation.setFloat(object, javaName, value);
            }
            break;
            case "double": {
                Double value = Double.valueOf(valueIn);
                MethodInvocation.setDouble(object, javaName, value);
            }
            break;
            case "boolean": {
                Boolean value = Boolean.valueOf(valueIn);
                MethodInvocation.setBoolean(object, javaName, value);
            }
            case "java.lang.Integer": {
                Integer value = Integer.valueOf(valueIn);
                MethodInvocation.setInt(object, javaName, value);
            }
            ;
            break;
            case "java.lang.Short": {
                Short value = Short.valueOf(valueIn);
                MethodInvocation.setShort(object, javaName, value);
            }
            break;
            case "java.lang.Byte": {
                Byte value = Byte.valueOf(valueIn);
                MethodInvocation.setByte(object, javaName, value);
            }
            break;
            case "java.lang.Long": {
                Long value = Long.valueOf(valueIn);
                MethodInvocation.setLong(object, javaName, value);
            }
            break;
            case "java.lang.Float": {
                Float value = Float.valueOf(valueIn);
                MethodInvocation.setFloat(object, javaName, value);
            }
            break;
            case "java.lang.Double": {
                Double value = Double.valueOf(valueIn);
                MethodInvocation.setDouble(object, javaName, value);
            }
            break;
            case "java.lang.Boolean": {
                Boolean value = Boolean.valueOf(valueIn);
                MethodInvocation.setBoolean(object, javaName, value);
            }
            case "java.lang.String": {
                String value = valueIn;
                MethodInvocation.setString(object, javaName, value);
            }
            break;

            case "org.nanoboot.powerframework.collections.bit.Blob": {
//                Integer value = Integer.valueOf(valueIn);
//                MethodInvocation.setInt(object, javaName, value);
            }
            break;
            default: {
                throw new PersistenceException("Cannot set attribute " + javaName);
            }
        }

    }

    public static void persist(Object object) {
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());

        boolean existTable = getDatabase().existTable(entitySchema.getName());
        System.out.println("Table " + entitySchema.getName() + "exist?=" + existTable);
        if(!existTable) {
            getDatabase().execute(entitySchema.createSqlCreateStatement());
        }

        boolean insert = !EntityManager.isInDatabase(object);
        boolean update = EntityManager.isInDatabase(object);

        if(insert) {
            addEntityToDatabase(object, entitySchema);
        }
        if(update) {
            updateEntityInDatabase(object, entitySchema);
        }

    }

    private static void addEntityToDatabase(Object object, EntitySchema entitySchema) {
        String uuid = Utils.getUUID();
        Utils.setUUIDTo(object, uuid);
        String[] valuesIn = new String[entitySchema.getAttributesList().size()];
        int index = 0;
        for (EntityAttribute a : entitySchema.getAttributesList()) {
            String value = "";

            value = JavaSqlConvertor.getStringFromJava(object, a);

            valuesIn[index++] = value;
        }

        String sqlInsert = SqlStatementCreator.createInsert(entitySchema.getName(), valuesIn);
        getDatabase().execute(sqlInsert);

    }

    private static void updateEntityInDatabase(Object object, EntitySchema entitySchema) {
        JsonObject row = getDatabase().getRow(entitySchema.getName(), MethodInvocation.getString(object, entitySchema.getIdJavaName()));
        ArrayList<EntityAttribute> changedAttributesList = new ArrayList<>();
        for (EntityAttribute a : entitySchema.getAttributesList()) {
            String stringValue = row.getString(a.getName());
            if(a.getType() == AttributeType.TEXT) {
                stringValue = '\'' + stringValue + '\'';
            }
            String entityValue = JavaSqlConvertor.getStringFromJava(object, a);

            boolean different = !stringValue.equals(entityValue);
            if(different) {

                changedAttributesList.add(a);
            }
        }
        ColumnNameValue[] columnNameValuesArray = new ColumnNameValue[changedAttributesList.size()];
        int index = 0;
        for (EntityAttribute a : changedAttributesList) {
            ColumnNameValue columnNameValue = new ColumnNameValue(a.getName(), JavaSqlConvertor.getStringFromJava(object, a));
            columnNameValuesArray[index++] = columnNameValue;
        }
        if(!changedAttributesList.isEmpty()) {
            String conditions = entitySchema.getIdJavaName() + "='" + Utils.getUUIDFrom(object) + "'";
            String sqlUpdateStatement = SqlStatementCreator.createUpdate(entitySchema.getName(), conditions, columnNameValuesArray);
            getDatabase().execute(sqlUpdateStatement);
        }
    }

    public static void delete(Object object) {
        if(!EntityManager.isInDatabase(object)) {
            throw new PersistenceException("Cannot delete object " + object.toString() + "from database. The object is not in the database.");
        }
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());

        String javaName = entitySchema.getIdJavaName();
        System.out.println("javaName=" + javaName);

        getDatabase().execute("DELETE FROM " + entitySchema.getName() + " WHERE " + entitySchema.getIdName() + "='" + getId(object) + "'");
        entityStorage.deleteEntity(object);
    }

    private static String getId(Object object) {
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());
        return MethodInvocation.getString(object, entitySchema.getIdJavaName());
    }

    public static boolean isInDatabase(Object object) {
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());

        return MethodInvocation.getString(object, entitySchema.getIdJavaName()) != null;
    }
}
