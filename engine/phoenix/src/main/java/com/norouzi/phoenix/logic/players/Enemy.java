package com.norouzi.phoenix.logic.players;

import com.norouzi.phoenix.Game;
import com.norouzi.phoenix.logic.GameObject;
import com.norouzi.phoenix.logic.Handler;

import java.awt.*;

public class Enemy extends GameObject {
    private Handler handler;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }
        Trail trail = new Trail(x, y, ID.TRAIL, handler, Color.RED, 16, 16, 0.01f);
        handler.addObject(trail);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);
    }
}