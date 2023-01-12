package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
    StringBuilder buffer;
    
    public WktVisitor() {
        this.buffer = new StringBuilder();
    }

    public void visit(Point point){
        buffer.append(point.getType().toUpperCase());
        if(point.isEmpty()){
            buffer.append(" EMPTY");
        } else {
            buffer.append("(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")");
        }
    }

    public void visit(LineString linestring){
        buffer.append(linestring.getType().toUpperCase());
        if(linestring.isEmpty()){
            buffer.append(" EMPTY");
        } else {
            buffer.append("(");
            for(int i=0; i<linestring.getNumPoints(); i++){
                if ( i != 0 ){
                    buffer.append(",");
                }
                buffer.append(linestring.getPointN(i).getCoordinate().getX() + " " + linestring.getPointN(i).getCoordinate().getY());
            }
            buffer.append(")");
        }
    }

    public String getResult() {
        return buffer.toString();
    }
}
