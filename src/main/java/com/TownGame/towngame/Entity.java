package com.TownGame.towngame;

import org.newdawn.slick.Graphics;

public class Entity {

    private int xpos;
    private int ypos;
    private int health;
    private boolean alive = true;


    public Entity(int x, int y) {

        xpos = x;
        ypos = y;
    }

    public boolean colidesWith(Entity e) {
        if ((e.getX() - this.getX()) < 32 && (e.getX() - this.getX()) > -32) {
            return ((e.getY() - this.getY()) < 32 && (e.getY() - this.getY()) > -32);
        }

        return false;
    }

    public boolean inRange(Entity e) {
        if ((e.getX() - this.getX()) < 300 && (e.getX() - this.getX()) > -300) {
            return ((e.getY() - this.getY()) < 300 && (e.getY() - this.getY()) > -300);
        }

        return false;
    }

    public void colideWith(Entity e) {

    }

    public void render(Graphics g) {
    }

    public void update() {

    }

    public void incrementX(int speed) {
        xpos += speed;
    }

    public void incrementY(int speed) {
        ypos += speed;
    }

    public int getX() {
        return xpos;
    }

    public void setX(int x) {
        xpos = x;
    }

    public int getY() {
        return ypos;
    }

    public void setY(int y) {
        ypos = y;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean a) {
        alive = a;
    }

    public int getHealth() {

        return health;
    }

    public void setHealth(int hp) {

        health = hp;
        if (health < 0) {
            kill(new UnknownSource());
        }
    }

    public void incrementHealth(int hpp) {
        setHealth(getHealth() + hpp);
    }

    public void kill(Source source) {
        this.setAlive(false);
    }


}
