package com.norouzi.phoenix.logic;

import com.norouzi.phoenix.Game;
import com.norouzi.phoenix.logic.interfaces.HUD;
import com.norouzi.phoenix.logic.players.Enemy;
import com.norouzi.phoenix.logic.players.ID;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random random;

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
        random = new Random();
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 500) {
            scoreKeep = 0;
            hud.setScore(0);
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() >= 2) {
                handler.addObject(new Enemy(random.nextInt(Game.WIDTH - 34), random.nextInt(Game.HEIGHT - 64), ID.ENEMY, handler));
            }
        }
    }
}
