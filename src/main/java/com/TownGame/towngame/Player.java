package com.TownGame.towngame;

public class Player extends Entity implements Controllable {

<<<<<<< HEAD

public class Player extends Entity{

public static Player p = new Player(50, 50, 2, 100);
public boolean collided = false;
=======
static public boolean collided = false;
>>>>>>> FETCH_HEAD


	Player(int x, int y, int s, int h){
		xpos = x;
		ypos = y;
		speed = s;
		health = h;
	}

	@Override
	public void update() {

	}

	@Override
	public void move(String string){

		if (string == "down"){ //down key
			ypos +=speed;
		}



		if (string ==  "left"){ //left key
			xpos -=speed;
		}



		if (string ==  "up"){ //up key
			ypos -=speed;

		}


		if (string ==  "right"){ //right key
			xpos +=speed;
		}


	}



}
