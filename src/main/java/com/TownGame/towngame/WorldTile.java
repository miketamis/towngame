package com.TownGame.towngame;

public class WorldTile extends World {

  public int wtSizeX = 3;
  public int wtSizeY = 3;
  WorldTile[][] wt;
  private boolean captured = false;
  private boolean active = false;

  WorldTile(String t, int gx, int gy){
    setType(t);
    setGX(gx);
    setGY(gy);


  }

  public void init(){

    wt = new WorldTile[wtSizeX][wtSizeY];

    for(int i = 0; i < wtSizeX; i++){
      for(int j = 0; j < wtSizeY; j++){
        wt[i][j] = new WorldTile("townCenter", i, j);
      }
    }
  }



  public boolean getCaptured(){
    return captured;
  }

  public boolean getActive(){
    return active;
  }

  public void setActive(boolean a){
    active = a;
  }

  public void setCaptured(boolean c){
    captured = c;
  }


}
