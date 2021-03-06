package com.TownGame.towngame;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;


public class Game extends BasicGame {


    public static Game game;
    public static boolean gameOver = false;
    public Player player;
    TrueTypeFont font;
    private ArrayList<Entity> entities;
    private Controller controller;
    public float level = 1f;
    private TrueTypeFont fontLevel;
    private GameContainer container;
    public static boolean fullscreen = false;
    public Game(String title) {
        super(title);
        game = this;

    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("Project Town Game"));
        app.setDisplayMode(800, 600, fullscreen);
        app.setAlwaysRender(true);
        app.setTargetFrameRate(60);
        app.start();


    }

    Random random = new Random();

    MapRender mapRender;

    @Override
    public void init(GameContainer container) throws SlickException {
        gameOver = false;
        this.container = container;
        entities = new ArrayList<Entity>();
        player = new Player(400, 300, 5, 100);
        controller = new Controller(player);
        container.getInput().addKeyListener(controller);
        entities.add(player);
        camera = new Camera(50, 50);
        mapRender = new MapRender(camera);

        camera.attachEntity(player);
        entities.add(camera);

         entities.add(new BasicZombie(150, 150, 2));
         for(int i = 0; i < 5;i++) {

         }

        Font awtFont = new Font("Verdana", Font.BOLD, 30);
        font = new TrueTypeFont(awtFont, false);

        Font ff = new Font("Verdana", Font.BOLD, 20);
        fontLevel = new TrueTypeFont(awtFont, false);
    }
    public Camera camera;

    @Override
    public void keyPressed(int key, char code) {
        if(code == 'r') {
            level = 1;
            container.getInput().removeKeyListener(controller);
            try {
                init(container);
            } catch (SlickException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        controller.update();

        if(random.nextInt(100) == 0) // 1 in 100 chance
        {
            if(random.nextBoolean()) {
                entities.add(new BasicZombie(
                         (random.nextBoolean() ? -400 : 400) + camera.getX(),
                        random.nextInt(300) * (random.nextBoolean() ? -1 : 1) + camera.getY()
                        , 2));
            } else {
                entities.add(new BasicZombie(
                        random.nextInt(400) * (random.nextBoolean() ? -1 : 1) + camera.getX(),
                        (random.nextBoolean() ? -300 : 300) + camera.getY()
                        , 2));
            }
        }

        if(!gameOver) {
             level += 0.01f;
         }


        for (Entity e : entities) {
            e.update();
        }

        for (int i = 0; i < entities.size(); i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                Entity e = entities.get(i);
                Entity e2 = entities.get(j);
                if (e.colidesWith(e2)) {
                    e.colideWith(e2);
                    e2.colideWith(e);
                }

            }
        }


    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {

        mapRender.setGraphics(g);

        for (Entity e : entities) {
            if (e.getAlive()) {

                e.render(mapRender);
            }
        }

        if (gameOver) {

            font.drawString(10f, 150f, "YOU ARE DEAD! Press R to restart", Color.red);
        }

        fontLevel.drawString(10, 10, "Level: " + (int)level, Color.red);



    }


    public Entity getNearest(Class entity, float x, float y, Entity self) {
        Entity nearest = null;
        for(Entity e : entities) {
            if(e.getClass().equals(entity)) {
                if(e == self) { continue; }
                if(nearest == null) { nearest = e; continue; }
                if(nearest.getSquareDistanceTo(x, y) > e.getSquareDistanceTo(x, y)) {
                    nearest = e;
                }
            }
        }
        return nearest;
    }
}
