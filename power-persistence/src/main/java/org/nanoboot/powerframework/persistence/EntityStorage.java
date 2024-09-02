
///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2016-2024 the original author or authors.
//
// This program is free software: you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation, either version 3
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program. If not, see 
// <https://www.gnu.org/licenses/> or write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
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
