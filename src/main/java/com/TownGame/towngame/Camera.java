package com.TownGame.towngame;

import org.newdawn.slick.Color;

public class Camera extends Entity {


    private Entity entityToFollow;

    private float followDistanceY = 200;
    private float followDistanceX = 300;
    private boolean debug = false;

    public Camera(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(MapRender g) {
        if(debug) {
            g.setColor(Color.blue);
            g.fillRect(getX(), getY(), 32, 32);
            g.drawRect(getX(), getY(), 32, 32);
            g.drawString("Camera", getX() - 20, getY() - 20);
        }
    }

    public void attachEntity(Entity entityToFollow) {
        this.entityToFollow = entityToFollow;
    }

    @Override
    public void update() {
        super.update();
        if(entityToFollow == null) { return; };

        float difX = entityToFollow.getX() - getX();
        if(Math.abs(difX) > followDistanceX) {
            setX(entityToFollow.getX() + (difX < 0 ? 1 : -1) * followDistanceX);
        }

        float difY = entityToFollow.getY() - getY();
        if(Math.abs(difY) > followDistanceY) {
            setY(entityToFollow.getY() + (difY < 0 ? 1 : -1) * followDistanceY);
        }
    }
}
