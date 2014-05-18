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


  public Player player;
  private ArrayList<Entity> entities = new ArrayList<Entity>();
  private Controller controller;
    public static Game game;

  public Game(String title) {
    super(title);
      game = this;

  }


  @Override
  public void init(GameContainer container) throws SlickException {
    player = new Player(50, 50, 5, 100);
    controller = new Controller(player);
    container.getInput().addKeyListener(controller);
    entities.add(player);
    entities.add(new BasicZombie(80, 80, 2));
  }


  @Override
  public void update(GameContainer container, int delta) throws SlickException {
    controller.update();
    for(Entity e : entities) {
      e.update();

    }

    for(int i = 0; i < entities.size(); i++) {
      for(int j = i + 1; j < entities.size(); j++) {
        Entity e = entities.get(i);
        Entity e2 = entities.get(j);
        if(e.colidesWith(e2)) {
         e.colideWith(e2);
         e2.colideWith(e);
       }
      }
    }



    //BasicZombie.z.attack();

    }



  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {
for(Entity e : entities) {
  e.render(g);
}





  }

  public static void main(String[] args) throws SlickException {
  AppGameContainer app = new AppGameContainer(new Game("setup test"));
  app.setDisplayMode(800, 600, false);
  app.setAlwaysRender(true);
  app.setTargetFrameRate(60);
  app.start();


  }



}
