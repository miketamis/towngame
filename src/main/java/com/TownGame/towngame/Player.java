package com.TownGame.towngame;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

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

								 Camera.offsetY -= speed;
								if(Camera.offsetY <= -50){
									Camera.dOffsetY -=speed;
								}

            }


            if (direction == Direction.LEFT) { //left key
                incrementX(-speed);
								Camera.offsetX += speed;
								if(Camera.offsetX >= 50){
									Camera.dOffsetX +=speed;
								}
								
							}



            if (direction == Direction.UP) { //up key
                incrementY(-speed);

								Camera.offsetY += speed;
								if(Camera.offsetY >= 50){
									Camera.dOffsetY +=speed;
								}


            }


            if (direction == Direction.RIGHT) { //right key
                incrementX(speed);

								Camera.offsetX -= speed;
								if(Camera.offsetX <= -50){
									Camera.dOffsetX -=speed;
								}

            }

        }
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)getX() + Camera.dOffsetX,(int) getY() + Camera.dOffsetY, 32, 32);
        g.drawRect((int)getX() + Camera.dOffsetX,(int) getY() + Camera.dOffsetY, 32, 32);
        g.drawString("Health: " + getHealth(), getX() + Camera.dOffsetX - 20, getY() + Camera.dOffsetY - 20);
				g.drawString("xO: " + Camera.dOffsetX, getX() + Camera.dOffsetX - 20, getY() + Camera.dOffsetY +50);
				g.drawString("yO: " + Camera.dOffsetY, getX() + Camera.dOffsetX - 20, getY() + Camera.dOffsetY +65);

    }

    @Override
    public void kill(Source source) {
        super.kill(source); //do the stuff that normally happens when entity dies
        Game.gameOver = true;
        // Graphics.drawString("YOU ARE DEAD!", 400, 300);
    }


}
