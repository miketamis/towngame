package com.TownGame.towngame;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class Controller implements KeyListener {

  private Controllable player;
private boolean right_down = false;
private boolean left_down = false;
private boolean up_down = false;
private boolean down_down = false;

  public Controller(Controllable player) {
    this.player = player;
  }

  public void update() {
    if(down_down == true){
      player.move(Direction.DOWN);
    }
    if(up_down == true){
      player.move(Direction.UP);
    }
    if(left_down == true){
      player.move(Direction.LEFT);
    }
    if(right_down == true){
      player.move(Direction.RIGHT);
    }
  }

    @Override
  public void keyPressed(int key, char code){
        System.out.println(key);
    if (key ==  31 || key == 208){ //down key
      down_down = true;
    }
    if (key ==  30 || key == 203){ //left key
      left_down = true;
    }
    if (key ==  17 || key == 200){ //up key
      up_down = true;
    }
    if (key ==  32 || key == 205){ //right key
      right_down = true;
    }

  }

    @Override
  public void keyReleased(int key, char code){
    if (key ==  31 || key == 208){ //down key
      down_down = false;
    }
    if (key ==  30 || key == 203){ //left key
      left_down = false;
    }
    if (key ==  17 || key == 200){ //up key
      up_down = false;
    }
    if (key ==  32 || key == 205){ //right key
      right_down = false;
    }

  }

    @Override
    public void setInput(Input input) {

    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {

    }

    @Override
    public void inputStarted() {

    }
}
