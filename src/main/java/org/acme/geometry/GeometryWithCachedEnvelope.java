package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener{
    Geometry original;
    Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = new Envelope();
        this.original.addListener(this);
    }

    public Geometry getOriginal(){
        return this.original;
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

    @Override
    public String asText(){
        return this.original.asText();
    }

    @Override
    public void addListener(GeometryListener listener){
        this.original.addListener(listener);
    }

    @Override
    public void onChange(Geometry geometry){
        this.cachedEnvelope = new Envelope();
    }
}
