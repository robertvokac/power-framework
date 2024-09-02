
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

import java.util.UUID;
import org.nanoboot.powerframework.text.TextUtils;

/**
 * Here goes the description of this class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 *
 */
public class Utils {

    /**
     * Logger for this class.
     */
    private static final org.nanoboot.powerframework.log.Logger LOG = org.nanoboot.powerframework.log.Logger.getLogger(Utils.class);

    /**
     * Constant description
     */
    private static final String SET = "set";
    private static final String GET = "get";
    /**
     * Field description
     */
    private String name;

    /**
     * Constructor
     *
     * Not meant to be instantiated.
     */
    private Utils() {
    }

    static String createSetMethodName(String javaName) {
        return SET + TextUtils.makeFirstLetterUpperCase(javaName);
    }

    static String createGetMethodName(String javaName) {
        return GET + TextUtils.makeFirstLetterUpperCase(javaName);
    }

    static String getUUIDFrom(Object object) {
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());
        return MethodInvocation.getString(object, entitySchema.getIdJavaName());
    }

    static void setUUIDTo(Object object, String uuid) {
        EntitySchema entitySchema = EntitySchema.getSchema(object.getClass());
        MethodInvocation.setString(object, entitySchema.getIdJavaName(), uuid);
    }

    public static String getUUID() {
//        MessageDigest salt;
//        try {
//            salt = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
//            throw new PersistenceException(ex.getMessage());
//        }
//        try {
//            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
//            throw new PersistenceException(ex.getMessage());
//        }
//        String digest = hexEncode(salt.digest());
//        return digest;
        return UUID.randomUUID().toString();
    }

    /**
     * The byte[] returned by MessageDigest does not have a nice
     * textual representation, so some form of encoding is usually performed.
     *
     * This implementation follows the example of David Flanagan's book
     * "Java In A Nutshell", and converts a byte array into a String
     * of hex characters.
     *
     * Another popular alternative is to use a "Base64" encoding.
     */
    private static String hexEncode(byte[] aInput) {
        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int idx = 0; idx < aInput.length; ++idx) {
            byte b = aInput[idx];
            result.append(digits[(b & 0xf0) >> 4]);
            result.append(digits[b & 0x0f]);
        }
        return result.toString();
    }
}
