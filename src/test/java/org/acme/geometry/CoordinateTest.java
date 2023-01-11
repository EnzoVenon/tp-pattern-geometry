package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(0.0, c.getX(), EPSILON);
		Assert.assertEquals(0.0, c.getY(), EPSILON);
	}
	@Test
	public void testConstructor(){
		Coordinate c = new Coordinate(3, 4.6);
		Assert.assertEquals(3, c.getX(), EPSILON);
		Assert.assertEquals(4.6, c.getY(), EPSILON);
	}
}
