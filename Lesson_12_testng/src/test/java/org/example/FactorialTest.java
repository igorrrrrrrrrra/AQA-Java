package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(Factorial.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialWithNegativeNumber() {
        Factorial.calculateFactorial(-5);
    }
}
