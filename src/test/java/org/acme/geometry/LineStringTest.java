package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;


public class LineStringTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        LineString l = new LineString();
        Assert.assertEquals(0, l.getNumPoints(), EPSILON);
    }
    
    @Test
    public void testConstructor(){
        GeometryFactory fact = new GeometryFactory();
        LineString l = fact.exampleLineString(4);
        Assert.assertEquals(4, l.getNumPoints(), EPSILON);
        Assert.assertEquals(3.14, l.getPointN(2).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5, l.getPointN(2).getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testGetType(){
        LineString l = new LineString();
        Assert.assertEquals("LineString", l.getType());
    }
}