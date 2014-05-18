package com.TownGame.towngame;

public class Player extends Entity implements Controllable {


public static Player p = new Player(50, 50, 2, 100);
public boolean collided = false;



	Player(int x, int y, int s, int h){
        super(x, y);
		speed = s;
		health = h;
	}

	@Override
	public void update() {

	}

	@Override
	public void move(String string){

		if (string == "down"){ //down key
            incrementX(speed);
		}



		if (string ==  "left"){ //left key
            incrementY(-speed);
		}



		if (string ==  "up"){ //up key
            incrementX(-speed);

		}


		if (string ==  "right"){ //right key
            incrementX(speed);
		}


	}



}
