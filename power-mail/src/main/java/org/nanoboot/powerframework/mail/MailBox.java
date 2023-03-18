
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

import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import lombok.Data;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@Data
public class MailBox {
    private SmtpServer smtpServer;
    public MailBox() {

    }
    public MailBox(SmtpServer smtpServer) {
        this.smtpServer = smtpServer;
    }
    /**
     *
     * @param mailMessage
     * @return null, if everything is OK, otherwise the error descriptiopn
     */
    public String send (final MailMessage mailMessage, final SmtpUser user) {

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpServer.getServerUrl());

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", smtpServer.getServerPort());
        props.put("mail.smtp.ssl.enable", smtpServer.getSsl().equals("1") ? "true" : "false");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props,
                new jakarta.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user.getUserName(), user.getPassword());
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(smtpServer.getFrom()));
            message.setRecipients(jakarta.mail.Message.RecipientType.TO,
                    InternetAddress.parse(mailMessage.getTo()));
            message.setSubject(mailMessage.getSubject(), "utf-8");

            // if plaint text
            // message.setText(target.text);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart text = new MimeBodyPart();
            // if html text
            String type = mailMessage.getMailMessageType() == MailMessageType.TEXT ? "text/plain" : "text/html";
            text.setContent(mailMessage.getText(), type+"; charset=utf-8");
            multipart.addBodyPart(text);

            if(mailMessage.getAttachment() != null && !mailMessage.getAttachment().isEmpty()) {
                MimeBodyPart attachment = new MimeBodyPart();
                attachment.attachFile(new File(mailMessage.getAttachment()));
                multipart.addBodyPart(attachment);
            }

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return null;
    }
}
