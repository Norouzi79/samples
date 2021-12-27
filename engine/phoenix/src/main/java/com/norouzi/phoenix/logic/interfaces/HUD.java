package com.norouzi.phoenix.logic.interfaces;

import com.norouzi.phoenix.Game;

import java.awt.*;

public class HUD {
    public static int HEALTH = 100;

    public void tick() {
        HEALTH --;
        HEALTH = Game.clamp(HEALTH, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);
    }
}
