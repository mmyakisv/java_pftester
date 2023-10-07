package ru.stqa.pftester.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTests {

    @Test

    public void perimeter() {
        Triangle p = new Triangle(5, 9, 12);
        Assert.assertEquals(p.perimeter(), 26.0);
    }

    @Test
    public void perimeter1() {
        Triangle p = new Triangle(4, 4, 10);
        Assert.assertEquals(p.perimeter(), 18.0);
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
}
