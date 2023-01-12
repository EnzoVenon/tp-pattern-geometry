package org.acme.geometry;

public class WktWriter {

    public WktWriter() {}
    
    public String write(Geometry geometry) throws RuntimeException {
        String type = geometry.getType().toUpperCase();
        if ( geometry instanceof Point ){
            Point p = (Point)geometry;
            if(p.isEmpty()){
                return  type + " EMPTY";
            } else {
                return type + "(" + p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ")";
            }
        }else if ( geometry instanceof LineString ){
            LineString l = (LineString)geometry;
            if(l.isEmpty()){
                return type + " EMPTY";
            } else {
                type+="(";
                for(int i=0; i<l.getNumPoints(); i++){
                    type += l.getPointN(i).getCoordinate().getX() + " " + l.getPointN(i).getCoordinate().getY() + ",";
                }
                return type.substring(0, type.length()-1) + ")";
            }
        }else{
            throw new RuntimeException("geometry type not supported");
        }
    }
}