package br.com.java.scripting.groovy.core;

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