package ru.stqa.pftester.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1() {
        Point p1 = new Point(2, 9);
        Point p2 = new Point(18, 25);
        Assert.assertEquals(p1.distance(p2), 22.627416997969522);
    }
    @Test
    public void testDistance2() {
        Point p1 = new Point(8, 9);
        Point p2 = new Point(4, 6);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }
    @Test
    public void testDistance3() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(4, 6);
        Assert.assertEquals(p1.distance(p2), 8.602325267042627);
    }
}
