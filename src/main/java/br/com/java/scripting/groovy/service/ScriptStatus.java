package br.com.java.scripting.groovy.service;

import java.awt.Color;

/**
 * Created by Lacau on 18/09/2016.
 */
public enum ScriptStatus {

    LOADED("loaded", Color.blue),
    RUNNING("running", new Color(0, 200, 0));

    String name;

    Color color;

    ScriptStatus(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}