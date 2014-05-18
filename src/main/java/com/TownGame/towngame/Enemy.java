package com.TownGame.towngame;

public class Enemy extends Entity {

  public int attack;
  public int defense;
  public int size;
  public int level;
  public float distX = ((Player.p.xpos + 16) - (BasicZombie.z.xpos + 16));
  public float distY = ((Player.p.ypos + 16) - (BasicZombie.z.ypos + 16));

public void attack(){
  if(distX*distX <= 16*16 && distY*distY <= 16*16){
    Player.p.health -= 1;
  }
}


}
