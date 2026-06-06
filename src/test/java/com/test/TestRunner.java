package com.test;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        
        // Create a list of test classes to run
        List<Class<?>> testClasses = new ArrayList<>();
        
        // Add your test classes here
        // testClasses.add(LoginTests.class);
        // testClasses.add(HomePageTests.class);
        // testClasses.add(SignupTests.class);
        // testClasses.add(AddToCart.class);
        
        testng.setTestClasses(testClasses.toArray(new Class[0]));
        
        // Run the tests
        testng.run();
    }
}
