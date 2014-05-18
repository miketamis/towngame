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


  private Player player;
  private ArrayList<Entity> entities = new ArrayList<Entity>();
  private Controller controller;

  public Game(String title) {
    super(title);

  }


  @Override
  public void init(GameContainer container) throws SlickException {
    player = new Player(50, 50, 5, 100);
    controller = new Controller(player);
    container.getInput().addKeyListener(controller);
    entities.add(player);
  }


  @Override
  public void update(GameContainer container, int delta) throws SlickException {
    controller.update();
    for(Entity e : entities) {
      e.update();
    }

    BasicZombie.z.attack();

    }



  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {
    g.setColor(Color.green);
    g.fillRect(Player.p.xpos, Player.p.ypos, 32, 32);
    g.drawRect(Player.p.xpos, Player.p.ypos, 32, 32);
    g.drawString("Health: " + Player.p.health, Player.p.xpos - 20, Player.p.ypos - 20);



    g.setColor(Color.red);
    g.fillRect(BasicZombie.z.xpos, BasicZombie.z.ypos, BasicZombie.z.size, BasicZombie.z.size);
    g.drawRect(BasicZombie.z.xpos, BasicZombie.z.ypos, BasicZombie.z.size, BasicZombie.z.size);



  }

  public static void main(String[] args) throws SlickException {
  AppGameContainer app = new AppGameContainer(new Game("setup test"));
  app.setDisplayMode(800, 600, false);
  app.setAlwaysRender(true);
  app.setTargetFrameRate(60);
  app.start();


  }



}
