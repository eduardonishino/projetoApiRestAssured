package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.ContentType;

import java.util.Map;

public class BaseUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static void setBaseURI(String uri){
        RestAssured.baseURI = uri;

    }

    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    public static Response post(Object json, ContentType contentType, String endpoint){
        return response = RestAssured.given()
                .contentType(contentType)
                .body(json)
                .post(endpoint)
                .thenReturn();
    }

    public static Response get(Map<String, String> hearder, String endpoint){
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
