package com.TownGame.towngame;

import java.awt.Font;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import java.util.ArrayList;


public class Game extends BasicGame {


  TrueTypeFont font;
  public Player player;
  private ArrayList<Entity> entities = new ArrayList<Entity>();
  private Controller controller;
  public static Game game;
  public static boolean gameOver = false;

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
    entities.add(new BasicZombie(150, 150, 2));
    Font awtFont = new Font("Verdana", Font.BOLD, 50);
    font = new TrueTypeFont(awtFont, false);
  }


  @Override
  public void update(GameContainer container, int delta) throws SlickException {
    controller.update();

    for(Entity e : entities) {
      if(e instanceof Player){
      e.dead(e);
    }
      if(e.getAlive()){
      e.update();
    }

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

    for(int i = 0; i < entities.size(); i++) {
      for(int j = i + 1; j < entities.size(); j++) {
        Entity e = entities.get(i);
        Entity e2 = entities.get(j);
        if(e.inRange(e2)) {

         if(e.getX() >= e2.getX()){
           e2.incrementX(1);
        }else{
          e2.incrementX(-1);
        }

        if(e.getY() >= e2.getY()){
          e2.incrementY(1);
       }else{
         e2.incrementY(-1);
       }

   }



    }
  }
}



  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {

for(Entity e : entities) {
  if(e.getAlive()){

  e.render(g);
}
}

if (gameOver){

  font.drawString(150.0f, 200.0f, "YOU ARE DEAD!", Color.red);
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
