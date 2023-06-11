package com.trendyol.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.trendyol.api.Constants.Contstants.*;

public class MathOperationDivision extends TestBase {

    @Test
    public void testDivisionWithPositiveNumbers() {
        int num1 = 12;
        int num2 = 3;
        int expected = num1 / num2;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testDivisionWithNegativeNumbers() {
        int num1 = -10;
        int num2 = -2;
        int expected = num1 / num2;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testDivisionWithZero() {
        int num1 = 10;
        int num2 = 0;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 400);
        Assert.assertEquals(TestBase.result, "Division by zero is not allowed");
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testDivisionWithLargeNumbers() {
        int num1 = 1000000;
        int num2 = 1000;
        int expected = num1 / num2;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }


    @Test
    public void testDivisionWithOneNumber() {
        int num1 = 2;
        int expected = num1;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testDivisionWithTwoNumbers() {
        int num1 = 10;
        int num2 = 2;
        int expected = num1 / num2;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }


    @Test
    public void testDivisionWithThreeNumbers() {
        int num1 = 100;
        int num2 = 2;
        int num3 = 5;
        int expected = num1 / num2 / num3;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testDivisionWithFourNumbers() {
        int num1 = 100;
        int num2 = 2;
        int num3 = 5;
        int num4 = 2;
        int expected = num1 / num2 / num3 / num4;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2, num3, num4);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }


    @Test
    public void testDivisionWithWrongCredentials() {
        int num1 = 10;
        int num2 = 2;

        TestBase.MathOperations(DIVISION_ENDPOINT, "wrong_username", "wrong_password", num1, num2);

        Assert.assertEquals(TestBase.statusCode, 401);
        Assert.assertEquals(TestBase.result, "Unauthorized");
    }
}

