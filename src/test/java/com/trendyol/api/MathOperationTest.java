package com.trendyol.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.trendyol.api.Constants.Contstants.*;

public class MathOperationTest extends TestBase {



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
    public void testSubtractionWithPositiveNumbers() {
        int num1 = 6;
        int num2 = 4;
        int expected = num1 - num2;

        TestBase.MathOperations(SUBTRACTION_ENDPOINT, username, password, num1, num2);

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
    public void testDivisionWithPositiveNumbers() {
        int num1 = 12;
        int num2 = 3;
        int expected = num1 / num2;

        TestBase.MathOperations(DIVISION_ENDPOINT, username, password, num1, num2);

        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }

}

