package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

    @Override
    public abstract Geometry clone();

    public String asText(){
        WktVisitor wktVisitor = new WktVisitor();
        this.accept(wktVisitor);
        return wktVisitor.getResult();
    }

    @Override
    public Envelope getEnvelope(){
        EnvelopeBuilder b = new EnvelopeBuilder();
        this.accept(b);
        return b.build();
    }
}
