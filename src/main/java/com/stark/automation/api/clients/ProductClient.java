package com.stark.automation.api.clients;
import com.stark.automation.api.endpoints.ApiEndpoints; import com.stark.automation.api.specifications.RequestSpecifications; import io.restassured.response.Response; import static io.restassured.RestAssured.given;
public class ProductClient { public Response get(int id) { return given().spec(RequestSpecifications.json()).when().get(ApiEndpoints.PRODUCTS + "/" + id); } }
