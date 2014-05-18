package com.TownGame.towngame;

public class basicZombie extends Enemy{

<<<<<<< HEAD
public static BasicZombie z = new BasicZombie(80, 80, 2);
=======
  public static basicZombie z = new basicZombie(80, 80, 2);
>>>>>>> FETCH_HEAD


  basicZombie(int x, int y, int l){
   xpos = x;
   ypos = y;
   level = l;
   attack = level * 5;
   defense = level * 3;
   size = 32;

  }


}
