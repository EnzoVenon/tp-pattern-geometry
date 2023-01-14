package org.acme.geometry;

public class Point extends AbstractGeometry {
    private Coordinate coordinate;

    public Point(){
        super();
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String getType(){
        return "Point";
    }

    @Override
    public boolean isEmpty() {
        return this.coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy){
        Coordinate c = new Coordinate(this.coordinate.getX()+dx, this.getCoordinate().getY()+dy);
        this.coordinate = c;
        this.triggerChange();
    }

    @Override
    public Point clone(){
        return new Point(this.coordinate);
    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }
}
