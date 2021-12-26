package com.norouzi.phoenix;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;

    public Game() {
        new Window(WIDTH, HEIGHT, "Let's build a game", this);
        handler = new Handler();
        handler.addObject(new Player(100, 100, ID.PLAYER));
        r = new Random();
        for (int i = 0; i < 50; i++) {
            handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.PLAYER));
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        new Game();
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
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
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
        g.dispose();
        bs.show();
    }
}
