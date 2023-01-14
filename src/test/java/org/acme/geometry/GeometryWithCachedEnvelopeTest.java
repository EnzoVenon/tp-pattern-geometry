package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testConstructor(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        GeometryWithCachedEnvelope ca = new GeometryWithCachedEnvelope(p);
        Envelope e1 = ca.getEnvelope();
        Envelope e2 = ca.getEnvelope();
        Assert.assertSame(e1,e2);

        p.translate(0, 0);
        Assert.assertEquals(3.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5.0, p.getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.14, e1.getXmin(), EPSILON);
    }

    @Test
    public void testGetType(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        GeometryWithCachedEnvelope ca = new GeometryWithCachedEnvelope(p); 
        Assert.assertEquals("Point", ca.getType());
    }

    @Test
    public void testTranslate(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        GeometryWithCachedEnvelope ca = new GeometryWithCachedEnvelope(p); 
        ca.translate(1, 3.25);
        Assert.assertEquals(4.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(8.25, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testClone(){
        GeometryFactory fact = new GeometryFactory();
        Point p1 = fact.examplePoint();
        GeometryWithCachedEnvelope ca1 = new GeometryWithCachedEnvelope(p1);
        GeometryWithCachedEnvelope ca2 = (GeometryWithCachedEnvelope) ca1.clone();
        ca1.translate(1, 3.25);
        Assert.assertEquals(3.14, ((Point)ca2.getOriginal()).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5, ((Point)ca2.getOriginal()).getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testVisitor() throws UnsupportedEncodingException {
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        GeometryWithCachedEnvelope ca = new GeometryWithCachedEnvelope(p);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor logVisitor = new LogGeometryVisitor(out);
        new LogGeometryVisitor();
        WktVisitor wktVisitor = new WktVisitor();
        ca.accept(logVisitor);
        ca.accept(wktVisitor);
        Assert.assertEquals("C'est un point avec x=3.14 et y=5.0", os.toString("UTF8").trim());
        Assert.assertEquals("POINT(3.14 5.0)", wktVisitor.getResult());
        Assert.assertEquals("POINT(3.14 5.0)", ca.asText());
        Assert.assertTrue(! ca.isEmpty());
    }
}
