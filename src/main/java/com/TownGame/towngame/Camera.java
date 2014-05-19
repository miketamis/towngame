package com.TownGame.towngame;

public class Camera {

  public static float offsetX = 0;
  public static float offsetY = 0;
  public static float dOffsetX = 0;
  public static float dOffsetY = 0;



public void update(){
  if(offsetX >= 50){
    offsetX = 50;
  }
  if(offsetX <= -50){
    offsetX = -50;
  }
  if(offsetY >= 50){
    offsetY = 50;
  }
  if(offsetY <= -50){
    offsetY = -50;
  }
}
}
