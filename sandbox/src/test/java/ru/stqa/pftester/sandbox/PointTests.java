package ru.stqa.pftester.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(2, 9);
        Point p2 = new Point(18, 25);
        Assert.assertEquals(p1.distance(p2), 22.627416997969522);
    }
}
