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
        Assert.assertEquals(true, p.isEmpty());
    }

    @Test
    public void testConstructor(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        Envelope e = p.getEnvelope();
        Assert.assertEquals(3.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5.0, p.getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.14, e.getXmin(), EPSILON);
    }

    @Test
    public void testGetType(){
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }

    @Test
    public void testTranslate(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        p.translate(1, 3.25);
        Assert.assertEquals(4.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(8.25, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testClone(){
        GeometryFactory fact = new GeometryFactory();
        Point p1 = fact.examplePoint();
        Point p2 = p1.clone();
        p1.translate(1, 3.25);
        Assert.assertEquals(3.14, p2.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5, p2.getCoordinate().getY(), EPSILON);
    }
}
