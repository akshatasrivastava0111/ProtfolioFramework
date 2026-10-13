package com.stark.automation.api.specifications;
import com.stark.automation.config.ConfigurationManager; import io.restassured.builder.RequestSpecBuilder; import io.restassured.filter.log.RequestLoggingFilter; import io.restassured.specification.RequestSpecification;
public final class RequestSpecifications { private RequestSpecifications() { } public static RequestSpecification json() { return new RequestSpecBuilder().setBaseUri(ConfigurationManager.value("api.base.url")).setContentType("application/json").addFilter(new RequestLoggingFilter()).build(); } }
