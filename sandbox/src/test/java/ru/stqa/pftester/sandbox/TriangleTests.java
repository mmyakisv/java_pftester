package ru.stqa.pftester.sandbox;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TriangleTests {

    @Test

    public void perimeter() {
        Triangle p = new Triangle(5, 9, 12);
        Assert.assertEquals(p.perimeter(), 26.0);
    }

    @Test
    public void perimeter1() {
        Triangle p = new Triangle(4, 4, 7);
        Assert.assertEquals(p.perimeter(), 15.0);
    }

    @Test
    public void perimeter2() {
        Triangle p = new Triangle(8, 8, 8);
        Assert.assertEquals(p.perimeter(), 24.0);
    }

    @Test
    public void square() {
        Triangle s = new Triangle(6, 9, 14);
        Assert.assertEquals(s.square(), 18.410255294264662);
    }

    @Test
    public void square1() {
        Triangle s = new Triangle(8, 8, 8);
        Assert.assertEquals(s.square(), 27.712812921102035);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide1() {
        try {
            new Triangle(-4, 4, 10);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Triangle side should be non-negative");
        }
    }
    @Test
    void cannotCreateTriangleWithNegativeSide2() {
        try {
            new Triangle(4, -4, 10);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Triangle side should be non-negative");
        }
    }
    @Test
    void cannotCreateTriangleWithNegativeSide3() {
        try {
            new Triangle(4, 4, -10);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Triangle side should be non-negative");
        }
    }
    @Test
    void cannotCreateTriangleWithSumBothSides() {
        try {
            new Triangle(13, 7, 21);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("The sum of any two sides must not be less than the third");
        }
    }
}
