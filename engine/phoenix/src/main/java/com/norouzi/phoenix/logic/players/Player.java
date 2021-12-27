package com.norouzi.phoenix.logic.players;

import com.norouzi.phoenix.Game;
import com.norouzi.phoenix.logic.GameObject;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
        /*velX = r.nextInt(5) + 1;
        velY = r.nextInt(5);*/
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 36);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.CYAN);
        g2d.draw(getBounds());
        if (id.equals(ID.PLAYER))
            g.setColor(Color.BLUE);
        if (id.equals(ID.PLAYER2))
            g.setColor(Color.GREEN);
        g.fillRect(x, y, 32, 32);
    }
}
