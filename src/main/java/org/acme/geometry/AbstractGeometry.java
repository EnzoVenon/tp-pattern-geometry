package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {
    protected List<GeometryListener> listeners;

    public AbstractGeometry(){
        this.listeners = new ArrayList<GeometryListener>();
    }

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

    @Override
    public void addListener(GeometryListener listener){
        this.listeners.add(listener);
    }

    public void triggerChange(){
        for(GeometryListener listener : this.listeners){
            listener.onChange(this);
        }
    }
}
