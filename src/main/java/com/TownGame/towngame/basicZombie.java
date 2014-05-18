package com.TownGame.towngame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;

public class BasicZombie extends Enemy {

    private int speed;
    public int health;

  BasicZombie(int x, int y, int l){

   super(x, y);

   level = l;
   attack = level * 5;
   defense = level * 3;
   size = 32;

  }

  public void move(int move){


    }


  public void render(Graphics g) {
    g.setColor(Color.red);
    g.fillRect(getX(), getY(), 32, 32);
    g.drawRect(getX(), getY(), 32, 32);
    g.drawString("Health: " + health, getX() - 20, getY() - 20);

  }








  }
