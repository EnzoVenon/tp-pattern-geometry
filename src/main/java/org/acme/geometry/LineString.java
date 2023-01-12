package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {
    private List<Point> points;



    public LineString(){
        this.points = new ArrayList<Point>();
    }

    public LineString(List<Point> points){
        this.points = points;
    }

    public int getNumPoints(){
        return points.size();
    }

    public Point getPointN(int n){
        return points.get(n);
    }

    @Override
    public String getType() {
        return "LineString";
    }

    @Override
    public boolean isEmpty() {
        return this.points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy){
        for(int i=0; i<this.points.size(); i++){
            this.points.get(i).translate(dx, dy);
        }
    }

    @Override
    public LineString clone(){
        ArrayList<Point> l = new ArrayList<Point>();
        for(Point p : this.points){
            l.add(p.clone());
        }  
        return new LineString(l);
    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }
}
