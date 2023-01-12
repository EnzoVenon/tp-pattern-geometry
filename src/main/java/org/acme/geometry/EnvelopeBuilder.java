package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
    List<Double> xVals;
    List<Double> yVals;

    public EnvelopeBuilder(){
        this.xVals = new ArrayList<Double>();
        this.yVals = new ArrayList<Double>();
    }

    public void insert(Coordinate coordinate){
        this.xVals.add(coordinate.getX());
        this.yVals.add(coordinate.getY());
    }

    public Envelope build(){
        Coordinate bottomLeft = new Coordinate(Collections.min(xVals), Collections.min(yVals));
        Coordinate topRight = new Coordinate(Collections.max(xVals), Collections.max(yVals));
        return new Envelope(bottomLeft, topRight);
    }
}