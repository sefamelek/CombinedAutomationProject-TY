package com.trendyol.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.trendyol.api.Constants.Contstants.*;

public class MathOperationMultiplication extends TestBase {

    @Test
    public void testMultiplicationWithPositiveNumbers() {
        int num1 = 2;
        int num2 = 3;
        int num3 = 4;
        int expected = num1 * num2 * num3;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithNegativeNumbers() {
        int num1 = -2;
        int num2 = -3;
        int num3 = -4;
        int expected = num1 * num2 * num3;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithZero() {
        int num1 = 2;
        int num2 = 3;
        int num3 = 0;
        int expected = num1 * num2 * num3;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithLargeNumbers() {
        int num1 = 1000;
        int num2 = 2000;
        int num3 = 3000;
        int expected = num1 * num2 * num3;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithOneNumber() {
        int num1 = 2;
        int expected = num1;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithTwoNumbers() {
        int num1 = 2;
        int num2 = 3;
        int expected = num1 * num2;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithThreeNumbers() {
        int num1 = 2;
        int num2 = 3;
        int num3 = 4;
        int expected = num1 * num2 * num3;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithFourNumbers() {
        int num1 = 3;
        int num2 = 4;
        int num3 = 5;
        int num4 = 2;
        int expected = num1 * num2 * num3 * num4;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, username, password, num1, num2, num3, num4);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

    @Test
    public void testMultiplicationWithWrongCredentials() {
        int num1 = 2;
        int num2 = 3;
        int num3 = 4;

        TestBase.MathOperations(MULTIPLICATION_ENDPOINT, "wrong_username", "wrong_password", num1, num2, num3);

        Assert.assertEquals(TestBase.statusCode, 401);
        Assert.assertEquals(TestBase.result, "Unauthorized");
    }
}

