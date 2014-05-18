package com.TownGame.towngame;

public class Enemy extends Entity {


    public Enemy(int x, int y) {
        super(x, y);
    }

  public int attack;
  public int defense;
  public int size;
  public int level;

  public int distX = ((Game.game.player.getX() + 16) - (BasicZombie.z.getX() + 16));
  public int distY = ((Game.game.player.getY() + 16) - (BasicZombie.z.getY() + 16));


public void attack(){
  if(distX*distX <= 16*16 && distY*distY <= 16*16){
    Player.p.health -= 1;
  }
}
}
