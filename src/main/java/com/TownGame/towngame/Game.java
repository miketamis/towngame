package com.TownGame.towngame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import java.util.ArrayList;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {
  public boolean right_down = false;
  public boolean left_down = false;
  public boolean up_down = false;
  public boolean down_down = false;

  private Player player;
  private ArrayList<Entity> entities = new ArrayList<Entity>();

  public Game(String title) {
    super(title);

  }

  public void keyPressed(int key, char code){
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
  public void init(GameContainer container) throws SlickException {
    player = new Player(50, 50, 5, 100);
    entities.add(player);
  }


  @Override
  public void update(GameContainer container, int delta) throws SlickException {
    for(Entity e : entities) {
      e.update();
    }
    if(down_down == true){
      player.move("down");
    }
    if(up_down == true){
      player.move("up");
    }
    if(left_down == true){
      player.move("left");
    }
    if(right_down == true){
      player.move("right");
    }
    }



  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {
    g.setColor(Color.green);
    g.fillRect(player.xpos, player.ypos, 32, 32);
    g.drawRect(player.xpos, player.ypos, 32, 32);

  }

  public static void main(String[] args) throws SlickException {
  AppGameContainer app = new AppGameContainer(new Game("setup test"));
  app.setDisplayMode(800, 600, false);
  app.setAlwaysRender(true);
  app.setTargetFrameRate(24);
  app.start();


  }



}
