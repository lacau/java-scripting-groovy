package br.com.java.scripting.groovy.core;

import java.awt.Color;
import java.awt.Point;

/**
 * Created by lacau on 08/08/16.
 */
public class Geometry {

    Point points[];

    Color borderColor;

    int borderSize;

    public Geometry(Point[] points, Color borderColor, int borderSize) {
        this.points = points;
        this.borderColor = borderColor;
        this.borderSize = borderSize;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }
}