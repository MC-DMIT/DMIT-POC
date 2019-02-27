package com.techm.notification.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techm.notification.domain.EmailMetaData;
import com.techm.notification.service.NotificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/email/")
@Api(value="Email Notification System", description="Email Notification System")
public class EmailController {
	private Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	private NotificationService notificationService;

	@ApiOperation(value="Notification API", response=String.class)
	@RequestMapping(method = RequestMethod.POST, value = "send")
	public String sendNotification(@RequestBody EmailMetaData emailMetaData) throws MessagingException {
		// send a notification
		boolean success = true;
		try {
			notificationService.sendNotification(emailMetaData);
		} catch (MailException e) {
			success = false;
			logger.info("Error Sending Email: " + e.getMessage());
		}

		if (!success) {
			return "Error occured while sending Emails!!";
		}

		return "Emails were sent successfully!!";
	}
	
	@ApiOperation(value="Report Notification API", response=String.class)
	@RequestMapping(method = RequestMethod.POST, value = "sendWithAttachment")
	public String sendNotificationUsingAttachment(@RequestBody EmailMetaData emailMetaData) throws MessagingException {
		// send a notification
		boolean success = true;
		try {
			notificationService.sendNotificationWithAttachment(emailMetaData);
		} catch (MailException e) {
			success = false;
			logger.info("Error Sending Email: " + e.getMessage());
		}

		if (!success) {
			return "Error occured while sending Emails!!";
		}

		return "Emails were sent successfully!!";
	}
	
	@GetMapping("hello")
	public String helloworld() {
		return "Hello";
	}
}