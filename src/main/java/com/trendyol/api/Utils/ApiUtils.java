package com.trendyol.api.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Arrays;

import static com.trendyol.api.constants.Contstants.*;
import static io.restassured.RestAssured.given;

public class ApiUtils{




    public static Response login(String username, String password) {
        return RestAssured.given().baseUri(BASE_URL).auth().preemptive().basic(username, password).get(USER_ENDPOINT);
    }

    public static Response performOperation(String operation, String username, String password, int... params)

    {
        RestAssured.urlEncodingEnabled = false;
        String paramm = Arrays.toString(params).replace("[", "").replace("]", "").replace(", ", ",");
        return RestAssured.given().baseUri(BASE_URL).auth().preemptive().basic(username, password).contentType(ContentType.JSON)
                .queryParams("params",paramm).log().all().post(operation);

    }

    public static Response getSum(String username, String password, int n) {
        RestAssured.urlEncodingEnabled = false;
        return RestAssured.given().baseUri(BASE_URL).auth().preemptive().basic(username, password).queryParam("params", n).get(SUM_ENDPOINT);
    }
}
