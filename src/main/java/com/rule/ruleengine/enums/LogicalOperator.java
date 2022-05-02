package com.rule.ruleengine.enums;

public enum LogicalOperator {
	
	EQ("exeEQ"),
	NEQ("exeNEQ"),
	LT("exeLT"),
	GT("exeGT"),
	LTE("exeLTE"),
	GTE("exeGTE"),
	IN("exeIN"),
	NOT_IN("exeNOTIN"),
	STW("exeSTW"),
	ENW("exeENW"),
	BTWE("exeBTWE"),
	BTWI("exeBTWI"),
	BOP("("),
	BCL(")"),
	AND("&&"),
	OR("||"),
	REGEX("exeREGEX"),
	IL("exeInList"),
	NIL("exeNotInList"),
	NOP("exeNOOP");
	
	private String operator;
	
	private LogicalOperator(String operator) {
		this.operator = operator;
	}
	
	public static String getEnumOp(String val){
		
		if(EQ.toString().equalsIgnoreCase(val)) {
			return EQ.getOperator();
		}else if(NEQ.toString().equalsIgnoreCase(val)) {
			return NEQ.getOperator();
		}else if(LT.toString().equalsIgnoreCase(val)) {
			return LT.getOperator();
		}else if(LTE.toString().equalsIgnoreCase(val)) {
			return LTE.getOperator();
		}else if(GT.toString().equalsIgnoreCase(val)) {
			return GT.getOperator();
		}else if(GTE.toString().equalsIgnoreCase(val)) {
			return GTE.getOperator();
		}else if(IN.toString().equalsIgnoreCase(val)) {
			return IN.getOperator();
		}else if(NOT_IN.toString().equalsIgnoreCase(val)) {
				return NOT_IN.getOperator();
		}else if(BOP.toString().equalsIgnoreCase(val)) {
			return BOP.getOperator();
		}else if(BCL.toString().equalsIgnoreCase(val)) {
			return BCL.getOperator();
		}else if(AND.toString().equalsIgnoreCase(val)) {
			return AND.getOperator();
		}else if(OR.toString().equalsIgnoreCase(val)) {
			return OR.getOperator();
		}else if(REGEX.toString().equalsIgnoreCase(val)) {
			return REGEX.getOperator();
		}else if(IL.toString().equalsIgnoreCase(val)) {
			return IL.getOperator();
		}else if(NIL.toString().equalsIgnoreCase(val)) {
			return NIL.getOperator();
		}
		return NOP.getOperator();
	}

	public String getOperator() {
		return operator;
	}
}
