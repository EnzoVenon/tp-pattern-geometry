package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {
    Geometry original;
    Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = new Envelope();
    }

    @Override
    public Envelope getEnvelope(){
        if(this.cachedEnvelope.isEmpty()){
            this.cachedEnvelope = original.getEnvelope();
        }
        return this.cachedEnvelope;
    }

    @Override
    public String getType(){
        return original.getType();
    }

    @Override
    public boolean isEmpty(){
        return original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy){
        original.translate(dx, dy);
    }

    @Override
    public Geometry clone(){
        return new GeometryWithCachedEnvelope(original.clone());
    }

    @Override
    public void accept(GeometryVisitor visitor){
        original.accept(visitor);
    }
}
