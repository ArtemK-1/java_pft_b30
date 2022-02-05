package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RectangleTests {

    @Test
    public void testArea(){
        Rectangle r = new Rectangle(4, 5);
        Assert.assertEquals(r.area(), 20.0);
    }
}