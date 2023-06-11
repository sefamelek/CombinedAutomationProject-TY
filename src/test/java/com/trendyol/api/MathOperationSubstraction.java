package com.trendyol.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.trendyol.api.Constants.Contstants.*;

public class MathOperationSubstraction extends TestBase {

    @Test
    public void testSubtractionWithPositiveNumbers() {
        int num1 = 5;
        int num2 = 3;
        int expected = num1 - num2;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithNegativeNumbers() {
        int num1 = -5;
        int num2 = -3;
        int expected = num1 - num2;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithZero() {
        int num1 = 5;
        int num2 = 0;
        int expected = num1 - num2;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithLargeNumbers() {
        int num1 = 2000000;
        int num2 = 1000000;
        int expected = num1 - num2;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithOneNumber() {
        int num1 = 2;
        int expected = num1;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithTwoNumbers() {
        int num1 = 5;
        int num2 = 3;
        int expected = num1 - num2;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithThreeNumbers() {
        int num1 = 10;
        int num2 = 3;
        int num3 = 2;
        int expected = num1 - num2 - num3;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithFourNumbers() {
        int num1 = 10;
        int num2 = 3;
        int num3 = 2;
        int num4 = 1;
        int expected = num1 - num2 - num3 - num4;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2, num3, num4);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testSubtractionWithWrongCredentials() {
        int num1 = 5;
        int num2 = 3;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, "wrong_username", "wrong_password", num1, num2);

        Assert.assertEquals(TestBase.statusCode, 401);
        Assert.assertEquals(TestBase.result, "Unauthorized");
    }

}

