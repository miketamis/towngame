package com.TownGame.towngame;

public class basicZombie extends Enemy{

  public static basicZombie z = new basicZombie(80, 80, 2);


  basicZombie(int x, int y, int l){
   super(x, y);
   level = l;
   attack = level * 5;
   defense = level * 3;
   size = 32;

  }
}
