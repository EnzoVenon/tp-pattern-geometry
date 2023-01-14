package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
        Envelope e = l.getEnvelope();
        Assert.assertEquals(4, l.getNumPoints(), EPSILON);
        Assert.assertEquals(3.14, l.getPointN(2).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5, l.getPointN(2).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.14, e.getXmin(), EPSILON);
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

    @Test
    public void testVisitor() throws UnsupportedEncodingException{
        GeometryFactory fact = new GeometryFactory();
        LineString l = fact.exampleLineString(2);
        LineString l2 = new LineString();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        WktVisitor wktVisitor = new WktVisitor();
        WktVisitor wktVisitorEmpty = new WktVisitor();
        l.accept(visitor);
        l.accept(wktVisitor);
        l2.accept(wktVisitorEmpty);
        Assert.assertEquals("Je suis une polyligne de 2 points.", os.toString("UTF8").trim());
        Assert.assertEquals("LINESTRING(3.14 5.0,3.14 5.0)", wktVisitor.getResult());
        Assert.assertEquals("LINESTRING(3.14 5.0,3.14 5.0)", l.asText());
        Assert.assertEquals("LINESTRING EMPTY", wktVisitorEmpty.getResult());
    }
}