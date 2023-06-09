package com.trendyol.api;

import com.trendyol.api.Utils.ApiUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import static com.trendyol.api.constants.Contstants.*;

public class TestBase {

    static int result;
    static String userInfo;
    static int statusCode;
    public static Logger logger;


    @BeforeSuite
    public static void setUp(){
        logger= Logger.getLogger("Automation");//added Logger
        logger.setLevel(Level.DEBUG);
    }
    public static void MathOperations(String Endpoint, String username, String password, int... params) {
        if (Endpoint==ADD_ENDPOINT){
            logger.info("The addition operation is performed");
        }
        else if (Endpoint==SUBTRACTION_ENDPOINT){
            logger.info("The substration operation is performed");
        }
        else if (Endpoint==MULTIPLICATION_ENDPOINT){
            logger.info("The multiplication operation is performed");
        }
        else if (Endpoint==DIVISION_ENDPOINT){
            logger.info("The division operation is performed");
        }
        else{
            logger.info("An invalid endpoint was entered.");
        }
        Response response = ApiUtils.performOperation(Endpoint, username, password, params);
        response.then().statusCode(200).contentType(ContentType.JSON);
        result= response.path("result");
        userInfo= response.path("user");
        statusCode = response.statusCode();
        logger.info("Result = " + result);
        logger.info("User = " + userInfo);


    }
    public static void SumOperations(String Endpoint, String username, String password, int n) {
        if (Endpoint==SUM_ENDPOINT){
            logger.info("The sum operation is performed");
        }
        else{
            logger.info("An invalid endpoint was entered.");
        }
        Response response = ApiUtils.getSum(username, password, n);
        response.then().statusCode(200).contentType(ContentType.JSON);
        result= response.path("result");
        userInfo= response.path("user");
        statusCode = response.statusCode();
        logger.info("Result = " + result);
        logger.info("User = " + userInfo);


    }
    }


