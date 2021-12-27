package com.norouzi.phoenix.logic.players;

import com.norouzi.phoenix.logic.GameObject;
import com.norouzi.phoenix.logic.Handler;

import java.awt.*;

public class Trail extends GameObject {
    private float alpha = 1f;
    private Handler handler;
    private Color color;
    private int width;
    private int height;
    private float life;

    public Trail(int x, int y, ID id, Handler handler, Color color, int width, int height, float life) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= (life - 0.0001f);
        }
        else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(alphaTransparent(alpha));
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g2d.setComposite(alphaTransparent(1));
    }

    public Rectangle getBounds() {
        return null;
    }

    private AlphaComposite alphaTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
}
