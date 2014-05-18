package com.TownGame.towngame;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;

public class Player extends Entity implements Controllable {

    private int speed;


	Player(int x, int y, int s, int h){
        super(x, y);
		speed = s;
		setHealth(h);
	}

    @Override
    public void colideWith(Entity e) {
        if(e instanceof BasicZombie)
        incrementHealth(-1);
    }

	@Override
	public void update() {


	}

	@Override
	public void move(Direction direction){
if (Game.gameOver == false){
		if (direction == Direction.DOWN){ //down key
            incrementY(speed);
		}



		if (direction ==  Direction.LEFT){ //left key
            incrementX(-speed);
		}



		if (direction ==  Direction.UP){ //up key
            incrementY(-speed);

		}


		if (direction ==  Direction.RIGHT){ //right key
            incrementX(speed);
		}

		}
	}

public void render(Graphics g) {
	g.setColor(Color.green);
	g.fillRect(getX(), getY(), 32, 32);
	g.drawRect(getX(), getY(), 32, 32);
	g.drawString("Health: " + getHealth(), getX() - 20, getY() - 20);

}



}
