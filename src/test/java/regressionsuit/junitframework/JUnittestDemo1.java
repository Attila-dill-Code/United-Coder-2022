package regressionsuit.junitframework;

import org.junit.*;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class JUnittestDemo1 {

    @BeforeClass
    public static void setUp1(){
        System.out.println("Before class test  01");
    }

    @BeforeEach           // the test each time run
    public void before(){
        System.out.println("Before test 1 ");
    }

    @AfterEach           // the test each time run
    public void after(){
        System.out.println("After test 1");
    }
    @AfterClass
    public static void tearDown1(){
        System.out.println("After all runs once all tests  01 ");
    }
    @BeforeAll   // this is not working
    public static void setUp(){
        System.out.println("Before All run once before all testes  !! ");
    }

    @AfterAll   // this is not working
    public static void tearDown(){
        System.out.println("After all runs once after all testes  !! ");
    }


    @RepeatedTest(3)  // this function is use for repeat test, you can use manyTime.
    @Test
    public void squareRootTest(){
        System.out.println("Testing a square root.... ");
        Assertions.assertTrue(Math.sqrt(9)==3);
    }
    @Test
    public void compareTwoString(){
        String s1 = "selenium";
        String s2 = "selenium";
        Assertions.assertEquals(s1,s2);
    }

    //@Disabled   // the code don't run
    @Test
    public void power(){
        System.out.println("Testing the power of a number");
        Assertions.assertTrue(Math.pow(10,2)==100);

    }


}
