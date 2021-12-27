package com.norouzi.phoenix;

import com.norouzi.phoenix.logic.Handler;
import com.norouzi.phoenix.logic.interfaces.HUD;
import com.norouzi.phoenix.logic.interfaces.KeyInput;
import com.norouzi.phoenix.logic.interfaces.Window;
import com.norouzi.phoenix.logic.players.Enemy;
import com.norouzi.phoenix.logic.players.ID;
import com.norouzi.phoenix.logic.players.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = WIDTH / 16 * 9;
    private final Handler handler;
    private final Random r;
    private Thread thread;
    private boolean running = false;
    private HUD hud;

    public Game() {
        handler = new Handler();
        hud = new HUD();
        new Window(WIDTH, HEIGHT, "Let's build a game", this);
        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.PLAYER, handler));
        handler.addObject(new Player(WIDTH / 2 + 64, HEIGHT / 2 + 64, ID.PLAYER2, handler));
        r = new Random();
        this.addKeyListener(new KeyInput(handler));
        for (int i = 0; i < 20; i++) {
            handler.addObject(new Enemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.ENEMY, handler));
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        new Game();
    }

    public static int clamp(int variable, int min, int max) {
        if (variable >= max)
            return variable = max;
        else if (variable <= min)
            return variable = min;
        else
            return variable;
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }
}
