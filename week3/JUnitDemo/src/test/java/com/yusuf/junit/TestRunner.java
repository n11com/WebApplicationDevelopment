package com.yusuf.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    /*
     * This is how you can run unit tests if you cannot run it within your IDE
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(EmpBusinessLogicTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

} 