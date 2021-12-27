package com.norouzi.phoenix.logic.interfaces;

import java.awt.*;

public class HUD {
    public static int HEALTH = 100;

    public void tick() {
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
    }
}
