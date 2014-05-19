package com.TownGame.towngame;


import org.newdawn.slick.Color;

public class Player extends Entity implements Controllable {

    private int speed;


    Player(int x, int y, int s, int h) {
        super(x, y);
        speed = s;
        setHealth(h);
    }

    @Override
    public void colideWith(Entity e) {
        if (e instanceof BasicZombie)
            incrementHealth(-1);
    }

    @Override
    public void update() {


    }

    @Override
    public void move(Direction direction) {
        if (Game.gameOver == false) {
            if (direction == Direction.DOWN) { //down key
                incrementY(speed);
            }


            if (direction == Direction.LEFT) { //left key
                incrementX(-speed);
							}



            if (direction == Direction.UP) { //up key
                incrementY(-speed);
            }


            if (direction == Direction.RIGHT) { //right key
                incrementX(speed);
            }

        }
    }

    public void render(MapRender g) {
        g.setColor(Color.blue);
        g.fillRect((int)getX(),(int) getY(), 32, 32);
        g.drawRect((int)getX(),(int) getY(), 32, 32);
        g.drawString("Health: " + getHealth(), getX() - 20, getY() - 20);
				g.setColor(Color.red);
				g.fillRect((int)getX() -5,(int) getY() -10, 42, 5);
				g.drawRect((int)getX() -5,(int) getY() -10, 42, 5);
				g.setColor(Color.green);
				g.fillRect((int)getX() -5,(int) getY() -20, (getHealth() * 42 / 100), 5);
				g.drawRect((int)getX() -5,(int) getY() -20, (getHealth() * 42 / 100), 5);


    }

    @Override
    public void kill(Source source) {
        super.kill(source); //do the stuff that normally happens when entity dies
        Game.gameOver = true;
        // Graphics.drawString("YOU ARE DEAD!", 400, 300);
    }


}
