package com.rule.ruleengine.utils;

import java.util.HashMap;
import java.util.Map;

public class RuleDefinition {
	
	private static Map<String, String> ruleMap = new HashMap<String, String>();
	
	static {
		addRule();
	}
	
	public static void addRule() {
		// using '#' to identify a variable ( NOTE: #this, #root are reserved variables )
		ruleMap.put("nework:18+:english", "exeEQ('nework', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)");
		ruleMap.put("nework:18+:spanish", "exeEQ('nework', #city) && exeGTE( #age, 18) && exeEQ('spanish' , #lang)");
		ruleMap.put("nework:18+:spanish|english", "exeEQ('nework', #city) && exeGTE( #age, 18) && exeIN(#lang, 'english,spanish')");
		
		ruleMap.put("california:18+:english", "exeEQ('california', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)");
		ruleMap.put("california:18+:spanish", "exeEQ('california', #city) && exeGTE( #age, 18) && exeEQ('spanish' , #lang)");
		ruleMap.put("california:18+:spanish|english|french", "exeEQ('california', #city) && exeGTE( #age, 18) && exeIN(#lang, 'english,spanish,french')");
		
		
		ruleMap.put("dallas:18+:english", "exeEQ('dallas', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)");
		ruleMap.put("dallas:18+:TAM", "exeEQ('dallas', #city) && exeGTE( #age, 18) && exeEQ('spanish' , #lang)");
		ruleMap.put("dallas:18+:TAM|english", "exeEQ('dallas', #city) && exeGTE( #age, 18) && exeIN(#lang, 'english,spanish')");
		
		ruleMap.put("chicago:18+:english", "exeEQ('chicago', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)");
		ruleMap.put("chicago:18+:spanish", "exeEQ('chicago', #city) && exeGTE( #age, 18) && exeEQ('spanish' , #lang)");
		ruleMap.put("chicago:18+:spanish|english|chinese", "exeEQ('chicago', #city) && exeGTE( #age, 18) && exeIN(#lang, 'english,spanish,chinese')");
		
		
		ruleMap.put("phoenix:18+:english", "exeEQ('phoenix', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)");
		ruleMap.put("phoenix:18+:spanish", "exeEQ('phoenix', #city) && exeGTE( #age, 18) && exeEQ('spanish' , #lang)");
		ruleMap.put("phoenix:18+:spanish|english|russian", "exeEQ('phoenix', #city) && exeGTE( #age, 18) && exeIN(#lang, 'english,spanish,russian')");
		
	}


	public static Map<String, String> getRuleMap() {
		return ruleMap;
	}


	public static void setRuleMap(Map<String, String> ruleMap) {
		RuleDefinition.ruleMap = ruleMap;
	}

}
