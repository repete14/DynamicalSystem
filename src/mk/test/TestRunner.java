package mk.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import mk.test.NodeTest;


/**
 *
 * @author mkirschner
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NodeTest.class);
        for (Failure failure : result.getFailures()) {
                System.out.println("Failed: " + failure.toString());
        }
        System.out.println("Number of failures: " + result.getFailureCount());
        //System.out.println(result.wasSuccessful());
    }   
}
