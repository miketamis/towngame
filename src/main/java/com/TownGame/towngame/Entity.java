package com.TownGame.towngame;

import org.newdawn.slick.Graphics;

public class Entity {

	private int xpos;
	private int ypos;
	static int speed;
	static int health;

    public Entity(int x, int y) {

	      xpos = x;
        ypos = y;
    }

	public void render(Graphics g) {}
	public void update() {

	}

    public void setX(int x) {
        xpos = x;
    }

    public void setY(int y) {
        ypos = y;
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

    public int getY() {
        return ypos;
    }

}
