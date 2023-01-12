package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;


public class LineStringTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        LineString l = new LineString();
        Assert.assertEquals(0, l.getNumPoints(), EPSILON);
        Assert.assertEquals(true, l.isEmpty());
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

    @Test
    public void testTranslate(){
        GeometryFactory fact = new GeometryFactory();
        LineString l = fact.exampleLineString(4);
        l.translate(1, 3.25);
        Assert.assertEquals(4.14, l.getPointN(2).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(8.25, l.getPointN(2).getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testClone(){
        GeometryFactory fact = new GeometryFactory();
        LineString l1 = fact.exampleLineString(4);
        LineString l2 = l1.clone();
        l1.translate(1, 3.25);
        Assert.assertEquals(3.14, l2.getPointN(2).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5, l2.getPointN(2).getCoordinate().getY(), EPSILON);
    }
}