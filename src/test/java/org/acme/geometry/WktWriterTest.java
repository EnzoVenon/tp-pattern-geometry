package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {
    
    @Test
    public void testWrite(){
        WktWriter writer = new WktWriter();
        GeometryFactory fact = new GeometryFactory();
        Point p1 = fact.examplePoint();
        Point p2 = new Point();
        LineString l1 = fact.exampleLineString(2);
        LineString l2 = new LineString();
        Assert.assertEquals("POINT(3.14 5.0)", writer.write(p1));
        Assert.assertEquals("LINESTRING(3.14 5.0,3.14 5.0)", writer.write(l1));
        Assert.assertEquals("POINT EMPTY", writer.write(p2));
        Assert.assertEquals("LINESTRING EMPTY", writer.write(l2));
        //Assert.assertThrows(RuntimeException, writer.write(g))
    }
}
