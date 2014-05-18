package com.TownGame.towngame;

import org.newdawn.slick.Graphics;

public class Entity {

	private int xpos;
	private int ypos;


	public boolean colidesWith(Entity e) {
		if ((e.getX() - this.getX()) < 32 && (e.getX() - this.getX()) > -32) {
		    return ((e.getY() - this.getY()) < 32 && (e.getY() - this.getY()) > -32);
		}

		return false;
	}

    public void colideWith(Entity e) {

    }
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
