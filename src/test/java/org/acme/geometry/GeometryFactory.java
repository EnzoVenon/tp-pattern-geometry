package org.acme.geometry;

import java.util.ArrayList;

public class GeometryFactory {
    public GeometryFactory(){}
    public Point examplePoint(){
        return new Point(new Coordinate(3.14, 5));
    }

    public LineString exampleLineString(int size){
        GeometryFactory fact = new GeometryFactory();
        ArrayList<Point> list = new ArrayList<Point>();
        for(int i=0; i<size; i++){
            list.add(fact.examplePoint());
        }
        return new LineString(list);
    }
}
