package com.cmcdelhi.quasar.service;

import java.net.URL;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.cmcdelhi.quasar.util.log.Log;

public class MailService {

	public boolean sendRegistartionConfirmationMail(
			QuasarMailConfiguration qmc, String... emailids) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(qmc.getHost());
			email.setSmtpPort(Integer.parseInt(qmc.getPort()));
			email.setAuthentication(qmc.getAdimnusername(),
					qmc.getAdminpassword());
			email.setSSLOnConnect(Boolean.parseBoolean(qmc.getStarttls()));

			email.setFrom(qmc.getAdimnusername());

			email.setSubject("TestMail");
			// embed the image and get the content id
			// URL url = new URL("http://www.apache.org/");
			// String cid = email.embed(url, "Apache logo");

			// // set the html message
			// email.setHtmlMsg("<html><body bgcolor='red'><h1>The apache logo - <img src=\"cid:"
			// + cid
			// + "\"></h1>"
			// +
			// "<p>Apple Inc. is an American multinational corporation headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software and personal computers"
			// + "</p>"
			// +
			// "<p>ABC national corporation headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software and personal computers</p>"
			// +
			// "<ul><li><a href='/wiki/Canon_Inc.' title='Canon Inc.'>Canon</a></li><li><a href='/wiki/Hewlett-Packard' title='Hewlett-Packard'>HP</a></li></ul>"
			// +
			// "<img alt='abc' src='//upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Wiktionary-logo-en.svg/23px-Wiktionary-logo-en.svg.png' width='23' height='25' />"
			// + "</body></html>");

			// email.setHtmlMsg("<html>"
			// + "<head>"
			// + "<meta charset='ISO-8859-1'>"
			// + "<title>Insert title here</title>"
			// + "<style type='text/css'>"
			// + "#studentdetail {"
			// + "background-color: graytext;"
			// + "font-family: sans-serif;"
			// + "padding: 10px;"
			// + "-webkit-border-radius: 4px;"
			// + "-moz-border-radius: 4px;"
			// + "	border-radius: 4px;"
			// + "box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);"
			// + "-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);"
			// + "-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);"
			// + "padding: 10px;"
			// + "}"
			// + "</style>"
			// + "</head>"
			// + "<body>"
			//
			// + "	<table id=\"studentdetail\">"
			// + "<tr>"
			// +
			// "			<td align=\"center\"><img alt=\"alt\" src=\"images/logo.png\"></td>"
			// +
			// "			<td align=\"left\">CMC LTD,New Delhi,Near Kohat Enclave Metro"
			// + "				Station</td>"
			// + "		</tr>"
			// + "		<tr>"
			// + "			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
			// + "				<p>"
			// +
			// "					Grettings, Thanks for registering at CMC Delhi. We wish you a"
			// +
			// "					prosperous learning.If you any query click on this link <a"
			// + "						href=\"www.cmcdelhi.com\" >Link</a>" + "				</p>"
			// + "			</td>" + "		</tr>" + "	</table>"
			//
			// + "</body>" + "</html>");

			//MailChimp
			email.setHtmlMsg("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head><body><table id=\"studentdetail\" style=\"background-color: graytext;font-family: sans-serif;padding: 10px;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);\"><tr><td align=\"center\"><img alt=\"alt\" src=\"images/logo.png\"></td><td align=\"left\">CMC LTD,New Delhi,Near Kohat Enclave Metro Station</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>Grettings, Thanks for registering at CMC Delhi. We wish you a prosperous learning.If you any query click on this link <a href=\"www.cmcdelhi.com\">Link</a></p></td></tr></table></body></html>");

			// /Email Attachment
			// EmailAttachment attachment = new EmailAttachment();
			// attachment.setPath("/home/guffy/Pictures/fggsa.jpg");
			// attachment.setDisposition(EmailAttachment.ATTACHMENT);
			// attachment.setDescription("Picture of JMosque");
			// attachment.setName("Mousque");

			// email.attach(attachment);

			// set the alternative message
			email.setTextMsg("Your email client does not support HTML messages");

			// adding up the recivers
			for (String em : emailids) {
				email.addTo(em);
			}

			email.send();

			return true;

		} catch (EmailException e) {
			Log.e("Email Exception : " + e.getMessage());

		} catch (Exception e) {
			Log.e("Exception : " + e.getMessage());

		}
		return false;

	}
}
