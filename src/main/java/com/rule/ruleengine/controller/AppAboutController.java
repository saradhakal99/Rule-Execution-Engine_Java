package com.rule.ruleengine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rule.ruleengine.config.SpringFoxConfig;
import com.rule.ruleengine.dto.AppAboutDTO;

import io.swagger.annotations.Api;

@RestController
@Api(tags = {SpringFoxConfig.ABOUT})
public class AppAboutController {

	protected static Logger LOG = LoggerFactory.getLogger(AppAboutController.class);

	@Value("${build.version:1.0.0}")
	private String buildVersion;
	
	@Value("${build.date:01-11-2021}")
	private String buildDate;

	@GetMapping(value = "/about", produces = "application/json")
	@ResponseBody
	public AppAboutDTO printAbout() throws Exception {
		return new AppAboutDTO("Rule Engine" , 
				"Rule Execution Engine", 
				buildVersion, 
				buildDate, 
				"Copyright Info" , 
				"Rule Execution Engine App");
	}
	
}
