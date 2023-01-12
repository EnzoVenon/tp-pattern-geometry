package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
    public static final double EPSILON = 1.0e-15;
    
    @Test
    public void testDefaultConstructor(){
        Envelope e = new Envelope();
        Assert.assertTrue(Double.isNaN(e.getXmin()));
        Assert.assertTrue(Double.isNaN(e.getYmin()));
        Assert.assertTrue(Double.isNaN(e.getXmax()));
        Assert.assertTrue(Double.isNaN(e.getYmax()));
        Assert.assertTrue(e.isEmpty());
    }

    @Test
    public void testConstructor(){
        EnvelopeBuilder b = new EnvelopeBuilder();
        b.insert(new Coordinate(3.14, 5));
        Envelope e = b.build();
        Assert.assertEquals(3.14, e.getXmin(), EPSILON);
        Assert.assertEquals(5, e.getYmin(), EPSILON);
        Assert.assertEquals(3.14, e.getXmax(), EPSILON);
        Assert.assertEquals(5, e.getYmax(), EPSILON);
        Assert.assertEquals(false, e.isEmpty());
    }
}
