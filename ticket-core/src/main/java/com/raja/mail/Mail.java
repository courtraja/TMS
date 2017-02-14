package com.raja.mail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

	public class Mail {

		private Mail() {
		}

		// User mail
		public static void sendSimpleMail(String mail, String message, int i) throws EmailException {
			Email email = new SimpleEmail();
			email.setSmtpPort(587);

			email.setAuthenticator(new DefaultAuthenticator("ticketapp.gvel@gmail.com", "ticketapp.gvel1234"));
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setSSLOnConnect(true);
			email.setFrom("ticketapp.gvel@gmail.com");
			email.setSubject("Ticket Management System");
			email.setMsg(message + "" + i);
			email.addTo(mail);
			email.setStartTLSEnabled(true);
			email.send();

		}

	
	}

