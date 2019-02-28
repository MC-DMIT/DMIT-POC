package com.techm.notification.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.techm.notification.domain.EmailMetaData;

@Service
public class NotificationService {
	private JavaMailSender javaMailSender;

	@Value("${dmit.report.filename}")
	String fileName;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendNotification(EmailMetaData emailMetaData) throws MailException, MessagingException {
		// send email
		final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		final MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, "UTF-8");

		mail.setTo(emailMetaData.getEmailAddresses());
		//mail.setFrom(emailMetaData.getFrom());
		mail.setSubject(emailMetaData.getSubject());
		mail.setText(emailMetaData.getMailContents(), true);

		javaMailSender.send(mimeMessage);
	}
	
	public void sendNotificationWithAttachment(EmailMetaData emailMetaData) throws MailException, MessagingException {
		// send email
		final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		final MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true);

		mail.setTo(emailMetaData.getEmailAddresses());
		mail.setFrom(emailMetaData.getFrom());
		mail.setSubject(emailMetaData.getSubject());
		mail.setText(emailMetaData.getMailContents(), true);
		File file1=null;
		try {
			file1 = ResourceUtils.getFile("classpath:srq-data.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date d=new Date();
        mail.addAttachment(LocalDate.now()+"_"+fileName, file1);

		javaMailSender.send(mimeMessage);
	}
}