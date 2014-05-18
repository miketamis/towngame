package com.TownGame.towngame;

public class BasicZombie extends Enemy{
  public static BasicZombie z = new BasicZombie(80, 80, 2);
  size = 32;
  attack = level * 5;
  defense = level * 3;

  BasicZombie(int x, int y, int l){
   xpos = x;
   ypos = y;
   level = l;

  }
}
