package com.TownGame.towngame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Camera extends Entity {


    private Entity entityToFollow;
    private float followDistance = 60;

    public Camera(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
      g.setColor(Color.blue);
      g.fillRect(getX(), getY(), 32, 32);
      g.drawRect(getX(), getY(), 32, 32);
      g.drawString("Camera", getX() - 20, getY() - 20);
    }

    public void attachEntity(Entity entityToFollow) {
        this.entityToFollow = entityToFollow;
    }

    @Override
    public void update() {
        super.update();
        if(entityToFollow == null) { return; };

        float difX = entityToFollow.getX() - getX();
        if(Math.abs(difX) > followDistance) {
            setX(entityToFollow.getX() + (difX < 0 ? 1 : -1) * followDistance);
        }

        float difY = entityToFollow.getY() - getY();
        if(Math.abs(difY) > followDistance) {
            setY(entityToFollow.getY() + (difY < 0 ? 1 : -1) * followDistance);
        }
    }
}
