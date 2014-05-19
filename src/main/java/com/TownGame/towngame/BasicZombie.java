package com.TownGame.towngame;

import org.newdawn.slick.Color;

public class BasicZombie extends Enemy {

    private float speed;


    BasicZombie(int x, int y, int l) {

        super(x, y);

        level = l;
        attack = level * 5;
        defense = level * 3;
        size = 32;
        speed = 1;

    }

    @Override
    public void update() {
        speed = (float) Math.min(Math.log(Game.game.level / 20) + 7,7f);
        moveTowards(nearest(Player.class));
    }

    private Entity nearest(Class entity) {
      return Game.game.getNearest(entity,getX(),getY(), this);
    }

    @Override
    public void colideWith(Entity e) {
        super.colideWith(e);
        moveAwayFrom(e);
    }

    public void moveTowards(Entity e) {
        float xDif = e.getX() - getX();
        float yDif = e.getY() - getY();
        float total = Math.abs(xDif) + Math.abs(yDif);
        if(total < 4) { return; }
        float s = speed/total;
        incrementX(s * xDif);
        incrementY(s * yDif);
    }

    public void moveAwayFrom(Entity e) {
        float xDif = e.getX() - getX();
        float yDif = e.getY() - getY();
        float total = Math.abs(xDif) + Math.abs(yDif);
        float s = 1/total;
        incrementX(- (s * xDif));
        incrementY(- (s * yDif));
    }

    public void move(int move) {


    }


    public void render(MapRender g) {
        g.setColor(Color.red);
        g.fillRect(getX(), getY(), 32, 32);
        g.drawRect(getX(), getY(), 32, 32);
        //g.drawString("Health: " + getHealth(), getX() - 20, getY() - 20);

    }


}
