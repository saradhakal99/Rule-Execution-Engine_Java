package com.rule.ruleengine.service;

import com.rule.ruleengine.dto.UserParams;

public interface RuleService {

	public Object executeRuleWithUserParams(UserParams userParam);
}
