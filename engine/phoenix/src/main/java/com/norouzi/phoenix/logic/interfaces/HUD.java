package com.norouzi.phoenix.logic.interfaces;

import com.norouzi.phoenix.Game;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }
}
