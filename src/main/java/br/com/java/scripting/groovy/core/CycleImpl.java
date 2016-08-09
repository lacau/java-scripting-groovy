package br.com.java.scripting.groovy.core;

import java.awt.Color;

/**
 * Created by lacau on 09/08/16.
 */
public class CycleImpl implements Cycle {

    private Geometry geometry;

    @Override
    public void init(Stage stage, Geometry geometry) {
        this.geometry = geometry;
        stage.setBackgroundColor(Color.gray);
    }

    @Override
    public Geometry beforeStep() {
        geometry.setBorderColor(Color.red);
        return geometry;
    }

    @Override
    public Geometry afterStep() {
        return geometry;
    }

    @Override
    public long getInterval() {
        return 100;
    }
}