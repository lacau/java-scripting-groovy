package br.com.java.scripting.groovy.core;

import java.awt.Color;

/**
 * Created by lacau on 09/08/16.
 */
public final class Stage {

    final int width;

    final int height;

    private Color backgroundColor;

    public Stage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}