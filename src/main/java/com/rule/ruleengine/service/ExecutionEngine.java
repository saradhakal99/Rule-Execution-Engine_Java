package com.rule.ruleengine.service;

import org.springframework.stereotype.Service;

@Service("executionEngine")
public interface ExecutionEngine {

	public boolean exeEQ(String value, String source);

	public boolean exeGT(Number value, Number source);

	public boolean exeGTE(Number value, Number source);

	public boolean exeLT(Number value, Number source);

	public boolean exeLTE(Number value, Number source);

	public boolean exeIN(String value, String source);

	public boolean exeNOTIN(String value, String source);

	public boolean exeSTW(String value, String source);

	public boolean exeENW(String value, String source);

	public boolean exeBTWE(Number value, Number start, Number end);

	public boolean exeBTWI(Number value, Number start, Number end);
}
