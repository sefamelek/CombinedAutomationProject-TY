package com.trendyol.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.trendyol.api.constants.Contstants.*;

public class SumTests extends TestBase {

    @Test
    public void testSum() {
        int num=5;
        int expected = (num*(num+1))/2 ;
        TestBase.SumOperations(SUM_ENDPOINT,username,password,num);
        Assert.assertEquals(TestBase.statusCode, 200);
        Assert.assertEquals(TestBase.result, expected);
        Assert.assertEquals(TestBase.userInfo, "sefa");
    }
}