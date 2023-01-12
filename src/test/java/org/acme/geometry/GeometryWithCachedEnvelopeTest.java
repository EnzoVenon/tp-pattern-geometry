package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testConstructor(){
        GeometryFactory fact = new GeometryFactory();
        Point p = fact.examplePoint();
        GeometryWithCachedEnvelope ca = new GeometryWithCachedEnvelope(p);
        Envelope e = ca.getEnvelope();
        Assert.assertEquals(3.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5.0, p.getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.14, e.getXmin(), EPSILON);
    }
}
