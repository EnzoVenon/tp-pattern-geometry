package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    public static final double EPSILON = 1.0e-15;
    
    @Test
    public void testDefaultConstructor(){
        Point p = new Point();
        Assert.assertEquals(true, Double.isNaN(p.getCoordinate().getX()));
        Assert.assertEquals(true, Double.isNaN(p.getCoordinate().getY()));
    }

    @Test
    public void testConstructor(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        Assert.assertEquals(3.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5.0, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testGetType(){
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }
}
