package br.com.java.scripting.groovy.core;

import java.awt.Color;
import java.awt.Point;

import br.com.java.scripting.groovy.util.CycleHolder;
import br.com.java.scripting.groovy.view.DrawPanel;
import br.com.java.scripting.groovy.view.MainDialog;

/**
 * Created by lacau on 09/08/16.
 */
public class EngineTask extends Thread {

    private DrawPanel drawPanel;

    private Stage stage;

    public EngineTask() {
        System.out.println("Start EngineTask.");
        drawPanel = MainDialog.getDrawPanel();
        CycleHolder.refresh(new CycleImpl());
        stage = new Stage(drawPanel.getWidth(), drawPanel.getHeight());
        drawPanel.setStage(stage);
        drawPanel.setGeometry(createGeometry());
    }

    @Override
    public void run() {
        Cycle cycle = CycleHolder.get();
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
            System.out.println(getName() + " - EngineTask thread interrupted.");
        }
    }

    private Geometry createGeometry() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 50);
        Point p3 = new Point(50, 50);
        Point p4 = new Point(50, 0);

        return new Geometry(new Point[] {p1, p2, p3, p4}, Color.red, 1);
    }
}