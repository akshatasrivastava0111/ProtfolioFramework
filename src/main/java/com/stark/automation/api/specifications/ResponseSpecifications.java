package com.stark.automation.api.specifications;
import io.restassured.builder.ResponseSpecBuilder; import io.restassured.specification.ResponseSpecification;
public final class ResponseSpecifications { private ResponseSpecifications() { } public static ResponseSpecification success() { return new ResponseSpecBuilder().expectContentType("application/json").build(); } }
