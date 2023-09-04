package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo3 {
    @Test(invocationCount = 3,invocationTimeOut = 2)
    public void test1(){
        System.out.println("Test 1...");
        Assert.assertTrue("Test".length()>2);
    }
    @Test(timeOut = 3)
    public void test2(){
        System.out.println("Test 2....");
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
