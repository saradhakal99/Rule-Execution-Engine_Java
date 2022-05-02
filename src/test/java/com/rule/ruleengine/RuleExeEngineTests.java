package com.rule.ruleengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.rule.ruleengine.config.WebConfig;
import com.rule.ruleengine.dto.APICustomException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
class RuleExeEngineTests {

	private static final String RULE_V0_EXECUTE = "/rule/v0/execute";
	private static final String URL_PREFIX = "http://localhost:8082/ruleengine";
	
	private RequestSpecification getRestAssured() {
        return RestAssured.given();
    }
	
	@Test
    public void whenAboutTry_thenOK() {
        final Response response = getRestAssured().get(URL_PREFIX + "/about");
        assertEquals(200, response.statusCode());
        System.out.println(response.asString());
    }
	
	@Test
    public void whenRuleTry_thenOK() {
		Map<String, Object> reqParams = new HashMap<String, Object>();
		reqParams.put("city", "chicago");
		reqParams.put("age", 19);
		reqParams.put("language", "english");
        final Response response = getRestAssured().formParams(reqParams).get(URL_PREFIX + RULE_V0_EXECUTE);
        final Map<String, String> apiRes = response.as(Map.class);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Success", apiRes.get("Status"));
        System.out.println(apiRes);
    }
	
	@Test
    public void whenRuleTry_thenOKTestRule() {
		Map<String, Object> reqParams = new HashMap<String, Object>();
		reqParams.put("city", "chicago");
		reqParams.put("age", 19);
		reqParams.put("language", "english");
        final Response response = getRestAssured().formParams(reqParams).get(URL_PREFIX + RULE_V0_EXECUTE);
        final Map<String, String> apiRes = response.as(Map.class);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("Success", apiRes.get("Status"));
        assertTrue(apiRes.get("RuleId :chicago:18+:english").contains("chicago"));
        assertTrue(apiRes.get("RuleId :chicago:18+:english").contains("english"));
        System.out.println(apiRes);
    }
	
	@Test
    public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() {
		Map<String, Object> reqParams = new HashMap<String, Object>();
		reqParams.put("city", "chicago");
		reqParams.put("age", "19");
		reqParams.put("language", "english");
        final Response response = getRestAssured().formParams(reqParams).post(URL_PREFIX + RULE_V0_EXECUTE);
        final APICustomException error = response.as(APICustomException.class);
		assertEquals(HttpStatus.SC_METHOD_NOT_ALLOWED, response.getStatusCode());
		assertEquals(1, error.getErrors().size());
		assertTrue(error.getErrors().get(0).contains("Supported methods are"));
        System.out.println("Response: " + error);

    }
	
	@Test
    public void whenSendInvalidHttpMediaType_thenUnsupportedMediaType() {
		Map<String, Object> reqParams = new HashMap<String, Object>();
		reqParams.put("city", "chicago");
		reqParams.put("age", "Test");
		reqParams.put("language", "english");
        final Response response = getRestAssured().formParams(reqParams).get(URL_PREFIX + RULE_V0_EXECUTE);
        final APICustomException error = response.as(APICustomException.class);
		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
		assertEquals(1, error.getErrors().size());
		assertTrue(error.getErrors().get(0).contains("age should be of type int"));
        System.out.println("Response: " + error);

    }

}
