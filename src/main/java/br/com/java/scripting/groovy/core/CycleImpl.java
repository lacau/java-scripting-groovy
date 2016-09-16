package br.com.java.scripting.groovy.core;

import java.awt.Color;

/**
 * Created by lacau on 09/08/16.
 */
public class CycleImpl implements Cycle {

    private Geometry geometry;

    private static final long INTERVAL = 50L;

    @Override
    public void init(Stage stage, Geometry geometry) {
        this.geometry = geometry;
        stage.setBackgroundColor(Color.black);
    }

    @Override
    public Geometry beforeStep() {
        geometry.setBorderColor(Color.white);
        return geometry;
    }

    @Override
    public Geometry afterStep() {
        return geometry;
    }

    @Override
    public long getInterval() {
        return INTERVAL;
    }
}