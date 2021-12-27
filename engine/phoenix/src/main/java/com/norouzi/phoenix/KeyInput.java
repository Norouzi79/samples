package com.norouzi.phoenix;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        System.out.println(key);
        for (GameObject object : handler.objects) {
            playerMovement(key, object);
            player2Movement(key, object);
            enemyMovement(key, object);
        }
    }

    private void playerMovement(int key, GameObject object) {
        if (object.getId().equals(ID.PLAYER)) {
            //key events for player 1
            if (key == KeyEvent.VK_W) {
                object.setY(object.getY() - 1);
            }

            if (key == KeyEvent.VK_S) {
                object.setY(object.getY() + 1);
            }

            if (key == KeyEvent.VK_D) {
                object.setX(object.getX() + 1);
            }

            if (key == KeyEvent.VK_A) {
                object.setX(object.getX() - 1);
            }
        }
    }

    private void player2Movement(int key, GameObject object) {
        if (object.getId().equals(ID.PLAYER2)) {
            //key events for player 1
            if (key == KeyEvent.VK_I) {
                object.setY(object.getY() - 1);
            }

            if (key == KeyEvent.VK_K) {
                object.setY(object.getY() + 1);
            }

            if (key == KeyEvent.VK_L) {
                object.setX(object.getX() + 1);
            }

            if (key == KeyEvent.VK_J) {
                object.setX(object.getX() - 1);
            }
        }
    }

    private void enemyMovement(int key, GameObject object) {
        if (object.getId().equals(ID.ENEMY)) {
            //key events for player 1
            if (key == KeyEvent.VK_UP) {
                object.setY(object.getY() - 1);
            }

            if (key == KeyEvent.VK_DOWN) {
                object.setY(object.getY() + 1);
            }

            if (key == KeyEvent.VK_RIGHT) {
                object.setX(object.getX() + 1);
            }

            if (key == KeyEvent.VK_LEFT) {
                object.setX(object.getX() - 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
    }
}
