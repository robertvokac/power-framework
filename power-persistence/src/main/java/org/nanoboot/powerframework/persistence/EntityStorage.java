
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

import java.util.HashMap;
import java.util.Map;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class EntityStorage {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(EntityStorage.class);

    /**
     * Constant description
     */
    private static final String CONSTANT = "constant";

    /**
     * Field description
     */
    private static final Map<String, Object> entityMap = new HashMap<>();

    /**
     * Constructor
     *
     * Constructor description
     *
     */
    public EntityStorage() {
    }

    public Object getEntity(String uid) {

        if(entityMap.containsKey(uid)) {
            return entityMap.get(uid);
        }
        return null;

    }

    public boolean hasEntity(String uid) {
        return entityMap.containsKey(uid);
    }

    public void putEntity(Object object) {
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());
        String uid = Utils.getUUIDFrom(object);
        if(entityMap.containsKey(uid)) {
            throw new PersistenceException("Cannot put entity " + entitySchema.getName() + " with uid " + uid + " There is already a entity with the class and uid in the storage.");
        }
        entityMap.put(uid, object);

    }

    public void deleteEntity(Object object) {
        String uid = Utils.getUUIDFrom(object);
        entityMap.remove(uid);
    }
}
