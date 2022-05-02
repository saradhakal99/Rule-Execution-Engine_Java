package com.rule.ruleengine.service.impl;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import com.rule.ruleengine.dto.UserParams;
import com.rule.ruleengine.service.ExecutionEngine;
import com.rule.ruleengine.service.RuleService;
import com.rule.ruleengine.utils.RuleDefinition;

@Service("RuleServiceImpl")
public class RuleServiceImpl implements RuleService {

	protected static Logger LOG = LoggerFactory.getLogger(RuleServiceImpl.class);

	@Autowired
	private ExecutionEngine executionEngine;

	public Object executeRuleWithUserParams(UserParams userParam) {

		Map<String, String> result = new HashMap<String, String>();

		if (null == userParam) {
			result.put("Status", "FAILURE");
			result.put("Message", "User Param is null");
			return result;
		}
		result.put("Status", "Success");
		result.put("Message", "Execution Results as below");

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2010, 8, 10);

		EvaluationContext context = new StandardEvaluationContext(executionEngine);
		context.setVariable("city",
				null == userParam.getCity() ? userParam.getCity() : userParam.getCity().toLowerCase());
		context.setVariable("age", userParam.getAge());
		context.setVariable("lang",
				null == userParam.getLang() ? userParam.getLang() : userParam.getLang().toLowerCase());

		ExpressionParser parser = new SpelExpressionParser();

		for (String ruleKey : RuleDefinition.getRuleMap().keySet()) {
			Expression exp = parser.parseExpression(RuleDefinition.getRuleMap().get(ruleKey));

			boolean isSuccess = (boolean) exp.getValue(context);
			LOG.info("RuleKey=[{}], Rule=[{}], Result=[{}]", ruleKey, RuleDefinition.getRuleMap().get(ruleKey),
					isSuccess);
			if (isSuccess) {
				result.put("RuleId :" + ruleKey, "Rule :" + RuleDefinition.getRuleMap().get(ruleKey));
			}
		}
		return result;

	}
}
