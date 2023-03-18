
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

package org.nanoboot.powerframework.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Main {
    private static class Keys {

        public static final String SERVER_CONF = "serverconf";
        public static final String FROM = "from";
        public static final String SERVER_URL = "serverurl";
        public static final String SERVER_PORT = "serverport";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String SSL = "ssl";

        public static final String TO = "to";
        public static final String SUBJECT = "subject";
        public static final String TEXT = "text";
        public static final String ATTACHMENT = "attachment";
    }

    //https://www.baeldung.com/java-email

    public static void main(String[] args) {
        Properties argProps = makePropFromArgs(args);
        SmtpServer server = new SmtpServer();

        server.setFrom(argProps.getProperty(Keys.FROM));
        server.setServerUrl(argProps.getProperty(Keys.SERVER_URL));
        server.setServerPort(argProps.getProperty(Keys.SERVER_PORT));
        SmtpUser user = new SmtpUser();
        user.setUserName(argProps.getProperty(Keys.USERNAME));
        user.setPassword(argProps.getProperty(Keys.PASSWORD));
        server.setSsl(argProps.getProperty(Keys.SSL));

        MailMessage target = new MailMessage();
        target.setTo(argProps.getProperty(Keys.TO));
        target.setSubject(argProps.getProperty(Keys.SUBJECT));
        target.setText(argProps.getProperty(Keys.TEXT));
        if (argProps.containsKey(Keys.ATTACHMENT)) {
            target.setAttachment(argProps.getProperty(Keys.ATTACHMENT));
        }

        MailBox mailBox = new MailBox(server);
        mailBox.send(target,user);
    }
    public static Properties makePropFromArgs(String[] args) {
        Properties prop = new Properties();
        for(String arg : args) {
            System.out.println(arg);
            String[] array = arg.split("=");
            if(array.length == 1) {
                if (arg.contains(Keys.ATTACHMENT)) {
                    continue;
                } else {
                    throw new RuntimeException("Parsing key and value for \"" + arg + "\" failed.");
                }
            }
            String key = array[0];
            String value = array[1];
            prop.put(key, value);
        }
        if (prop.containsKey(Keys.SERVER_CONF)) {
            Properties serverConfProp = loadPropFromFile(prop.getProperty(Keys.SERVER_CONF));
            prop.putAll(serverConfProp);
        }
        return prop;
    }

    private static Properties loadPropFromFile(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
