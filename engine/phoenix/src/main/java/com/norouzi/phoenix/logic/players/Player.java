package com.norouzi.phoenix.logic.players;

import com.norouzi.phoenix.Game;
import com.norouzi.phoenix.logic.GameObject;
import com.norouzi.phoenix.logic.Handler;
import com.norouzi.phoenix.logic.interfaces.HUD;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        /*velX = r.nextInt(5) + 1;
        velY = r.nextInt(5);*/
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 36);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        collision();
    }

    private void collision() {
        for (GameObject object : handler.objects) {
            if (object.getId().equals(ID.ENEMY)) {
                if (getBounds().intersects(object.getBounds())) {
                    HUD.HEALTH --;
                }
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void render(Graphics g) {
        if (id.equals(ID.PLAYER))
            g.setColor(Color.BLUE);
        if (id.equals(ID.PLAYER2))
            g.setColor(Color.GREEN);
        g.fillRect(x, y, 32, 32);
    }
}
