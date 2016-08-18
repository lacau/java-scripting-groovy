package br.com.java.scripting.groovy.core;

/**
 * Created by lacau on 10/08/16.
 */
public class MonitorTask extends Thread {

    private Engine engine;

    private boolean running;

    public MonitorTask() {
        running = true;
    }

    @Override
    public void run() {
        while(true) {
            if(running) {
                if(engine != null) {
                    engine.kill();
                    if(engine.isAlive()) {
                        continue;
                    }
                }

                engine = new Engine();
                engine.start();
                hold();
            }
        }
    }

    public void hold() {
        running = false;
    }

    public void release() {
        running = true;
    }
}