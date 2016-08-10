package br.com.java.scripting.groovy.core;

import java.awt.Color;
import java.awt.Point;

import br.com.java.scripting.groovy.Application;
import br.com.java.scripting.groovy.view.DrawPanel;
import br.com.java.scripting.groovy.view.MainDialog;

/**
 * Created by lacau on 09/08/16.
 */
public class Engine implements Runnable {

    private DrawPanel drawPanel;

    private Cycle cycle;

    private Stage stage;

    public Engine() {
        drawPanel = MainDialog.getDrawPanel();
        cycle = new CycleImpl(); // Should be load dynamically
        stage = new Stage(drawPanel.getWidth(), drawPanel.getHeight());
        drawPanel.setStage(stage);
        drawPanel.setGeometry(createGeometry());
    }

    @Override
    public void run() {
        cycle.init(drawPanel.getStage(), drawPanel.getGeometry());

        try {
            while(true) {
                cycle.beforeStep();

                drawPanel.invalidate();
                drawPanel.repaint();

                cycle.afterStep();

                Thread.sleep(cycle.getInterval());
            }
        } catch(InterruptedException e) {
            System.out.println("Engine thread interrupted.");
        }
    }

    private Geometry createGeometry() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 50);
        Point p3 = new Point(50, 50);
        Point p4 = new Point(50, 0);

        return new Geometry(new Point[] {p1, p2, p3, p4}, Color.red, 1);
    }

    public static void kill() {
        Application.getEngineThread().interrupt();
    }
}