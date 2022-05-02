package com.rule.ruleengine.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

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
public class APICustomException {

	private HttpStatus status;
    private String message;
    private List<String> errors;
}
