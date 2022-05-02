package com.rule.ruleengine.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rule.ruleengine.service.ExecutionEngine;

@Service("executionEngine")
public class ExecutionEngineImpl implements ExecutionEngine{
	
	protected static Logger LOG = LoggerFactory.getLogger(ExecutionEngineImpl.class);
	
	public boolean exeEQ( String value, String source ) {
    	boolean ret = value.equalsIgnoreCase(source);
    	LOG.info("exeEQ Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeGT( Number value, Number source ) {
    	boolean ret = value.doubleValue() > source.doubleValue();
    	LOG.info("exeGT Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeGTE( Number value, Number source ) {
    	boolean ret = value.doubleValue() >= source.doubleValue();
    	LOG.info("exeGTE Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeLT( Number value, Number source ) {
    	boolean ret = value.doubleValue() < source.doubleValue();
    	LOG.info("exeLT Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeLTE( Number value, Number source ) {
    	boolean ret = value.doubleValue() <= source.doubleValue();
    	LOG.info("exeLTE Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeIN( String value, String source ) {
		if(null == source) {
			return false;
		}
		List<String> sourceArr = Arrays.asList(source.split("\\,"));
    	boolean ret = sourceArr.contains(value);
    	LOG.info("exeIN Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeNOTIN( String value, String source ) {
		if(null == source) {
			return true;
		}
		List<String> sourceArr = Arrays.asList(source.split("\\,"));
    	boolean ret = !sourceArr.contains(value);
    	LOG.info("exeNOTIN Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeSTW( String value, String source ) {
    	boolean ret = value.startsWith(source);
    	LOG.info("exeSTW Result=["+ret+"]");
    	return ret;
    }
	
	public boolean exeENW( String value, String source ) {
    	boolean ret = value.endsWith(source);
    	LOG.info("exeENW Result=["+ret+"]");
    	return true;
    }
	
	public boolean exeBTWE( Number value, Number start, Number end ) {
    	boolean ret = (start.doubleValue() < value.doubleValue() && value.doubleValue() < end.doubleValue());
    	LOG.info("exeBTWE Result=["+ret+"]");
    	return true;
    }
	
	public boolean exeBTWI( Number value, Number start, Number end ) {
    	boolean ret = (start.doubleValue() <= value.doubleValue() && value.doubleValue() <= end.doubleValue());
    	LOG.info("exeBTWI Result=["+ret+"]");
    	return true;
    }
}
