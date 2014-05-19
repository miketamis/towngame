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
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private Controller controller;
    public float level = 1f;
    private TrueTypeFont fontLevel;

    public Game(String title) {
        super(title);
        game = this;

    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("setup test"));
        app.setDisplayMode(800, 600, false);
        app.setAlwaysRender(true);
        app.setTargetFrameRate(60);
        app.start();


    }

    Random random = new Random();

    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Player(400, 300, 5, 100);
        controller = new Controller(player);
        container.getInput().addKeyListener(controller);
        entities.add(player);
        Camera camera = new Camera(50, 50);
        camera.attachEntity(player);
        entities.add(camera);

        // entities.add(new BasicZombie(150, 150, 2));
        // for(int i = 0; i < 5;i++) {
        //   entities.add(new BasicZombie(random.nextInt(800), random.nextInt(600), 2));
        // }

        Font awtFont = new Font("Verdana", Font.BOLD, 50);
        font = new TrueTypeFont(awtFont, false);

        Font ff = new Font("Verdana", Font.BOLD, 20);
        fontLevel = new TrueTypeFont(awtFont, false);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        controller.update();

        // if(random.nextInt(100) == 0) // 1 in 100 chance
        // {
        //     entities.add(new BasicZombie(random.nextInt(800), random.nextInt(600), 2) );
        // }
        //
        // if(!gameOver) {
        //     level += 0.01f;
        // }


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

        for (Entity e : entities) {
            if (e.getAlive()) {

                e.render(g);
            }
        }

        if (gameOver) {

            font.drawString(150.0f, 200.0f, "YOU ARE DEAD!", Color.red);
        }

        //fontLevel.drawString(10, 10, "Level: " + (int)level, Color.red);

        g.setColor(Color.blue);
        g.fillRect(Tile.t.xpos, Tile.t.ypos, 32, 32);
        g.drawRect(Tile.t.xpos, Tile.t.ypos, 32, 32);

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
