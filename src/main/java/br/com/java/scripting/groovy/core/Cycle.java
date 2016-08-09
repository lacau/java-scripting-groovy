package br.com.java.scripting.groovy.core;

/**
 * Created by lacau on 09/08/16.
 */
public interface Cycle {

    void init(Stage stage, Geometry geometry);

    Geometry beforeStep();

    Geometry afterStep();

    default long getInterval() {
        return 100;
    }
}