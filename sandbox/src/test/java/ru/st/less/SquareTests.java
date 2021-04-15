package ru.st.less;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test
    public void testAreaV1() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(0, 1);
        Assert.assertEquals(p1.distance(p2), Math.sqrt(2));
    }
    @Test
    public void testAreaV2() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        Assert.assertEquals(p1.distance(p2), 0);
    }
    @Test
    public void testAreaV3() {
        Point p1 = new Point(99999, 7);
        Point p2 = new Point(32, 5);
        Assert.assertEquals(p1.distance(p2) - Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)), 0);
    }
}
