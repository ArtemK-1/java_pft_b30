package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void TestDistance(){
        Point p1 = new Point(-1, 0);
        Point p2 = new Point(-1, 10);
        Assert.assertEquals(p1.distance(p2), 10);
        Assert.assertEquals(p2.distance(p2), 0);
        Assert.assertEquals(p2.distance(p1), 10);
        Assert.assertEquals(p1.distance(p2), p2.distance(p1));
    }
}
