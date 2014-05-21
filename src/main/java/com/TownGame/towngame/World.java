package com.TownGame.towngame;

public class World {

  private String type;
  private int gridX;
  private int gridY;

  public void init(){

  }

  public int getGX(){
    return gridX;
  }

  public int getGY(){
    return gridY;
  }

  public String getType(){
    return type;
  }

  public void setGX(int x){
    gridX = x;
  }

  public void setGY(int y){
    gridY = y;
  }

  public void setType(String t){
    type = t;
  }

}
