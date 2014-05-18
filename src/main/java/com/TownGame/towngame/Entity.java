package com.TownGame.towngame;

import org.newdawn.slick.Graphics;

public class Entity {

	private int xpos;
	private int ypos;
	private int health;
	private boolean alive = true;



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

		public boolean getAlive() {
				return alive;
		}

		public void setAlive(boolean a) {
				 alive = a;
		}
		public int getHealth(){

			return health;
		}
		public void setHealth(int hp){

			health = hp;
		}
		public void incrementHealth(int hpp){

			health += hpp;
		}
		public void dead(Entity e){//only works for player currently,
			if( e instanceof Player){//will switch it over to enemies later with combat implementation
			if (this.getHealth() <= -1){
				this.setAlive(false);
				Game.gameOver = true;
				// Graphics.drawString("YOU ARE DEAD!", 400, 300);
			}
		}
		}

}
