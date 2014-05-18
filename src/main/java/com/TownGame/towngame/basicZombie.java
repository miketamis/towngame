package com.TownGame.towngame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class BasicZombie extends Enemy {

    private int speed;


    BasicZombie(int x, int y, int l) {

        super(x, y);

        level = l;
        attack = level * 5;
        defense = level * 3;
        size = 32;

    }

    @Override
    public void update() {
      moveTowards(Game.game.player);
    }

    public void moveTowards(Entity e) {
      float xDif = e.getX() - getX();
      float yDif = e.getY() - getY();
      float total = Math.abs(xDif) + Math.abs(yDif);
      float s = 1/total;
      incrementX(s * xDif);
      incrementY(s * yDif);
     }

    public void move(int move) {


    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getX(), getY(), 32, 32);
        g.drawRect(getX(), getY(), 32, 32);
        g.drawString("Health: " + getHealth(), getX() - 20, getY() - 20);

    }


}
