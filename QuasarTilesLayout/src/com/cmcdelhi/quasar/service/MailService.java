package com.cmcdelhi.quasar.service;

import java.net.URL;

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
			URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			String cid = email.embed(url, "Apache logo");

			// set the html message
			email.setHtmlMsg("<html><body bgcolor='red'><h1>The apache logo - <img src=\"cid:"
					+ cid
					+ "\"><h1>"
					+ "<p>Apple Inc. is an American multinational corporation headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software and personal computers"
					+ "</p>"
					+ "<p>ABC national corporation headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software and personal computers</p>"
					+ "<ul><li><a href='/wiki/Canon_Inc.' title='Canon Inc.'>Canon</a></li><li><a href='/wiki/Hewlett-Packard' title='Hewlett-Packard'>HP</a></li></ul>"
					+ "<img alt='abc' src='//upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Wiktionary-logo-en.svg/23px-Wiktionary-logo-en.svg.png' width='23' height='25' />"
					+ "</body></html>");

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
