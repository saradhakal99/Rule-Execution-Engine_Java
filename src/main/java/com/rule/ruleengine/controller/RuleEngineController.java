package com.rule.ruleengine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rule.ruleengine.config.SpringFoxConfig;
import com.rule.ruleengine.dto.UserParams;
import com.rule.ruleengine.service.RuleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("rule/v0")
@Api(tags = {SpringFoxConfig.RULE_ENGINE})
public class RuleEngineController {
	
	protected static Logger LOG = LoggerFactory.getLogger(RuleEngineController.class);
	
	@Autowired
	private RuleService ruleService;
	
	@GetMapping(value = "/execute", produces = "application/json")
	public Object executeRuleByParam(final @RequestParam( required = false) String city, 
			final @RequestParam( required = false) int age,
			final @RequestParam( required = false) String lang,
			Model model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserParams userParam = new UserParams(city, age, lang);
		LOG.info("UserParam : [{}]", userParam.toString());
		return ruleService.executeRuleWithUserParams(userParam);
	}
	
	@GetMapping(value = "/execute/{city}/{age}/{lang}", produces = "application/json")
	public Object executeRuleByPathVar(@PathVariable String city, 
			@PathVariable int age,
			@PathVariable String lang,
			Model model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserParams userParam = new UserParams(city, age, lang);
		LOG.info("UserParam : [{}]", userParam.toString());
		return ruleService.executeRuleWithUserParams(userParam);
	}
}