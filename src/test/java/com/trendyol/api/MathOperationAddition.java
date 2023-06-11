package com.trendyol.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.trendyol.api.Constants.Contstants.*;

public class MathOperationAddition extends TestBase {

    @Test
    public void testAdditionWithPositiveNumbers() {
        int num1 = 2;
        int num2 = 4;
        int num3 = 6;
        int expected = num1 + num2 + num3;
        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, num2, num3);
        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        int num1 = -2;
        int num2 = -3;
        int expected = num1 + num2;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testAdditionWithZero() {
        int num1 = 2;
        int num2 = 0;
        int expected = num1 + num2;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testAdditionWithLargeNumbers() {
        int num1 = 1000000;
        int num2 = 2000000;
        int expected = num1 + num2;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }
    @Test
    public void testAdditionWithOneNumber() {
        int num1 = 2;
        int expected = num1;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testAdditionWithTwoNumbers() {
        int num1 = 2;
        int num2 = 3;
        int expected = num1 + num2;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }


    @Test
    public void testAdditionWithThreeNumbers() {
        int num1 = 2;
        int num2 = 3;
        int num3 = 4;
        int expected = num1 + num2 + num3;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testAdditionWithFourNumbers() {
        int num1 = 2;
        int num2 = 3;
        int num3 = 4;
        int num4 = 5;
        int expected = num1 + num2 + num3 + num4;

        TestBase.MathOperations(ADD_ENDPOINT, username, password, num1, 2, num3, num4);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testAdditionWithWrongCredentials() {
        int num1 = 2;
        int num2 = 3;

        TestBase.MathOperations(ADD_ENDPOINT, "wrong_username", "wrong_password", num1, num2);

        Assert.assertEquals(TestBase.statusCode, 401);
        Assert.assertEquals(TestBase.result, "Unauthorized");
    }

}

