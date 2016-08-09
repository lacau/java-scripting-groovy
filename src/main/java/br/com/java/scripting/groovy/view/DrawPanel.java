package br.com.java.scripting.groovy.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

import br.com.java.scripting.groovy.core.Geometry;
import br.com.java.scripting.groovy.core.Stage;

/**
 * Created by lacau on 09/08/16.
 */
public class DrawPanel extends JPanel {

    private Stage stage;

    private Geometry geometry;

    public DrawPanel() {
        setBackground(Color.black);
    }

    @Override
    public void paint(Graphics graphics) {
        final Graphics2D g = (Graphics2D) graphics;
        if(stage != null && geometry != null) {
            final Point[] points = geometry.getPoints();

            g.setColor(geometry.getBorderColor());
            g.setStroke(new BasicStroke(geometry.getBorderSize()));

            for(int i = 0; i < points.length - 1; i++) {
                g.drawLine(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
            }
        }

        super.paint(g);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}