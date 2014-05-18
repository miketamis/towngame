package com.TownGame.towngame;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;

public class Player extends Entity implements Controllable {

    private int speed;
    private int health;

	Player(int x, int y, int s, int h){
        super(x, y);
		speed = s;
		health = h;
	}

    @Override
    public void colideWith(Entity e) {
        if(e instanceof BasicZombie)
        health -= 1;
    }

	@Override
	public void update() {

	}

	@Override
	public void move(String string){

		if (string == "down"){ //down key
            incrementY(speed);
		}



		if (string ==  "left"){ //left key
            incrementX(-speed);
		}



		if (string ==  "up"){ //up key
            incrementY(-speed);

		}


		if (string ==  "right"){ //right key
            incrementX(speed);
		}


	}

public void render(Graphics g) {
	g.setColor(Color.green);
	g.fillRect(getX(), getY(), 32, 32);
	g.drawRect(getX(), getY(), 32, 32);
	g.drawString("Health: " + health, getX() - 20, getY() - 20);

}
}
