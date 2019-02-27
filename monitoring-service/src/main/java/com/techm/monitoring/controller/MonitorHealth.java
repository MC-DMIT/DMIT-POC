package com.techm.monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.monitoring.domain.HealthResult;
import com.techm.monitoring.domain.ServerDetails;
import com.techm.monitoring.service.MonitoringService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@Api(value="Monitoring System", description="Monitoring System")
public class MonitorHealth {
	@Autowired
	MonitoringService monitoringService;

	@ApiOperation(value="Application Health API", response=HealthResult.class)
	@GetMapping("/health")
	public HealthResult pingURL(@RequestBody ServerDetails serverDetails) {

		return monitoringService.pingURL(serverDetails);

	}

	//@GetMapping("/bulkHealth")
	public boolean bulkHealthCheck() {

		return monitoringService.bulkCheck();

	}

}
