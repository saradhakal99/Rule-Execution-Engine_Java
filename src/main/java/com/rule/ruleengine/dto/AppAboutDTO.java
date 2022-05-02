package com.rule.ruleengine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@ToString
public class AppAboutDTO {

	private String serviceName;
	private String description;
	private String version;
	private String buildDate;
	private String copyRight;
	private String summary;
}
