package com.TownGame.towngame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Created by miketamis on 19/05/14.
 */
public class MapRender {

    Entity camera;
    Graphics g;

    public MapRender(Entity camera) {
        this.camera = camera;
    }

    public void setGraphics(Graphics g) {
        this.g = g;
    }

    public void setColor(Color color) {
        g.setColor(color);
    }

    public void fillRect(float x, float y, int sx, int sy) {
        g.fillRect(x - camera.getX() +400 ,y - camera.getY() + 300, sx,sy);
    }

    public void drawRect(float x, float y, int sx, int sy) {
        g.drawRect(x - camera.getX() + 400, y - camera.getY() + 300, sx, sy);
    }

    public void drawString(String s, float x, float y) {

    }
}
