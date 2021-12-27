package com.norouzi.phoenix.logic.players;

import com.norouzi.phoenix.Game;
import com.norouzi.phoenix.logic.GameObject;

import java.awt.*;

public class Enemy extends GameObject {
    public Enemy(int x, int y, ID id) {
        super(x, y, id);
        velX = 5;
        velY = 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16)
            velX *= -1;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.CYAN);
        g2d.draw(getBounds());
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);
    }
}