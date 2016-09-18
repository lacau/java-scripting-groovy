package br.com.java.scripting.groovy.core;

import br.com.java.scripting.groovy.util.CycleHolder;

/**
 * Created by lacau on 10/08/16.
 */
public class MonitorTask extends Thread {

    private EngineTask engine;

    private boolean running;

    private static volatile boolean alive;

    private static MonitorTask self;

    public MonitorTask() {
        alive = true;
        running = true;
        self = this;
    }

    @Override
    public void run() {
        CycleHolder.refresh(new CycleImpl());
        try {
            while(alive) {
                if(running) {
                    if(engine != null) {
                        engine.interrupt();
                        if(engine.isAlive()) {
                            continue;
                        }
                    }

                    engine = new EngineTask();
                    engine.start();
                    hold();
                }

                Thread.sleep(3000);
            }
        } catch(InterruptedException e) {
            System.out.println(getName() + " - MonitorTask thread interrupted.");
        }
        System.out.println(getName() + " - MonitorTask thread stopped.");
    }

    public void hold() {
        running = false;
    }

    public void release() {
        running = true;
    }

    public static void kill() {
        self.engine.interrupt();
        alive = false;
    }
}