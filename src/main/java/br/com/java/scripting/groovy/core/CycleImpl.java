package br.com.java.scripting.groovy.core;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 * Created by lacau on 09/08/16.
 */
public class CycleImpl implements Cycle {

    private Geometry geometry;

    private Stage stage;

    private static final long INTERVAL = 2L;

    private static final int DISTANCE = 3;

    private static final int DIRECTIONS = 8;

    private Random random = new Random();

    private int direction;

    @Override
    public void init(Stage stage, Geometry geometry) {
        this.stage = stage;
        this.geometry = geometry;
        this.stage.setBackgroundColor(Color.black);
        changeColor();
        changeDirection();
    }

    @Override
    public Geometry beforeStep() {
        return geometry;
    }

    @Override
    public Geometry afterStep() {
        switch(direction) {
            case 0:
                return moveDown(DISTANCE);
            case 1:
                return moveUp(DISTANCE);
            case 2:
                return moveLeft(DISTANCE);
            case 3:
                return moveRight(DISTANCE);
            case 4:
                moveDown(DISTANCE);
                return moveRight(DISTANCE);
            case 5:
                moveDown(DISTANCE);
                return moveLeft(DISTANCE);
            case 6:
                moveUp(DISTANCE);
                return moveRight(DISTANCE);
            case 7:
                moveUp(DISTANCE);
                return moveLeft(DISTANCE);
        }

        return geometry;
    }

    @Override
    public long getInterval() {
        return INTERVAL;
    }

    private Geometry moveUp(int distance) {
        if(canMoveUp(distance))
            for(Point p : geometry.getPoints())
                p.y -= distance;

        return geometry;
    }

    private boolean canMoveUp(int distance) {
        for(Point p : geometry.getPoints())
            if(p.y - distance < 0) {
                changeDirection();
                changeColor();
                return false;
            }

        return true;
    }

    private Geometry moveDown(int distance) {
        if(canMoveDown(distance))
            for(Point p : geometry.getPoints())
                p.y += distance;

        return geometry;
    }

    private boolean canMoveDown(int distance) {
        for(Point p : geometry.getPoints())
            if(p.y + distance > stage.getHeight()) {
                changeDirection();
                changeColor();
                return false;
            }

        return true;
    }

    private Geometry moveLeft(int distance) {
        if(canMoveLeft(distance))
            for(Point p : geometry.getPoints())
                p.x -= distance;

        return geometry;
    }

    private boolean canMoveLeft(int distance) {
        for(Point p : geometry.getPoints())
            if(p.x - distance < 0) {
                changeDirection();
                changeColor();
                return false;
            }

        return true;
    }

    private Geometry moveRight(int distance) {
        if(canMoveRight(distance))
            for(Point p : geometry.getPoints())
                p.x += distance;

        return geometry;
    }

    private boolean canMoveRight(int distance) {
        for(Point p : geometry.getPoints())
            if(p.x + distance > stage.getWidth()) {
                changeDirection();
                changeColor();
                return false;
            }

        return true;
    }

    private void changeDirection() {
        direction = random.nextInt(DIRECTIONS);
    }

    private void changeColor() {
        geometry.setBorderColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
    }
}