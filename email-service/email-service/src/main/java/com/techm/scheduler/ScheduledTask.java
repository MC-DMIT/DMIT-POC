package com.techm.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techm.notification.domain.EmailMetaData;

@Component
public class ScheduledTask {
	
	@Autowired
	RestTemplate restTemplate;
	@Scheduled(cron = "0 0 10 ? * MON") //Run scheduler on monday of every week
	public void weeklyReportEmailNotification() {
		EmailMetaData emd = new EmailMetaData();
		emd.setEmailAddresses(new String[]{"mc.dmit.user@gmail.com"});
		emd.setFrom("mc.dmit.user@gmail.com");
		emd.setMailContents("<html><body><p>Dear user, <Br><Br>Please find DMIT weekly report attatched.<br><Br> - Sent by DMIT Team. </body></html>");
		emd.setSubject("DMIT weekly report!");
		
		//restTemplate.getForEntity("localhost:11002/email/sendWithAttachment", null, uriVariables)
		ResponseEntity<String> result = restTemplate.postForEntity("localhost:11002/email/sendWithAttachment", emd, String.class);
		System.out.println(result);
	}
}
