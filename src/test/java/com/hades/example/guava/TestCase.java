package com.hades.example.guava;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkState;

public class TestCase {

    @Test
    public void test() {
        test_checkState();
    }

    private void test_checkState() {
        int num1 = 1;
        int num2 = 2;
        checkState(num1 != num2, "num1 is equal num2");

        num2 = 1;

        /**
         * checkState: When condition is false, print error msg
         */
//        checkState(num1 != num2, "num 1 is not equal num2");// ERROR:java.lang.IllegalStateException: num 1 is equal num2
        checkState(num1 != num2, "num1 %s is equal num2 %s", num1, num2);// ERROR:java.lang.IllegalStateException: num1 1 is equal num2 1
    }
}
