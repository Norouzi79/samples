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
        for (GameObject object : handler.objects) {
            playerMovement(key, object);
            player2Movement(key, object);
            enemyMovement(key, object);
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(0);
    }

    private void playerMovement(int key, GameObject object) {
        if (object.getId().equals(ID.PLAYER)) {
            //key events for player 1
            if (key == KeyEvent.VK_W) {
                object.setVelY(-1);
            }

            if (key == KeyEvent.VK_S) {
                object.setVelY(1);
            }

            if (key == KeyEvent.VK_D) {
                object.setVelX(1);
            }

            if (key == KeyEvent.VK_A) {
                object.setVelX(-1);
            }
        }
    }

    private void playerMovementReleased(int key, GameObject object) {
        if (object.getId().equals(ID.PLAYER)) {
            //key events for player 1
            if (key == KeyEvent.VK_W) {
                object.setVelY(0);
            }

            if (key == KeyEvent.VK_S) {
                object.setVelY(0);
            }

            if (key == KeyEvent.VK_D) {
                object.setVelX(0);
            }

            if (key == KeyEvent.VK_A) {
                object.setVelX(0);
            }
        }
    }

    private void player2Movement(int key, GameObject object) {
        if (object.getId().equals(ID.PLAYER2)) {
            //key events for player 1
            if (key == KeyEvent.VK_I) {
                object.setVelY(-1);
            }

            if (key == KeyEvent.VK_K) {
                object.setVelY(1);
            }

            if (key == KeyEvent.VK_L) {
                object.setVelX(1);
            }

            if (key == KeyEvent.VK_J) {
                object.setVelX(-1);
            }
        }
    }

    private void player2MovementReleased(int key, GameObject object) {
        if (object.getId().equals(ID.PLAYER2)) {
            //key events for player 1
            if (key == KeyEvent.VK_I) {
                object.setVelY(0);
            }

            if (key == KeyEvent.VK_K) {
                object.setVelY(0);
            }

            if (key == KeyEvent.VK_L) {
                object.setVelX(0);
            }

            if (key == KeyEvent.VK_J) {
                object.setVelX(0);
            }
        }
    }

    private void enemyMovement(int key, GameObject object) {
        if (object.getId().equals(ID.ENEMY)) {
            //key events for player 1
            if (key == KeyEvent.VK_UP) {
                object.setVelY(-5);
            }

            if (key == KeyEvent.VK_DOWN) {
                object.setVelY(5);
            }

            if (key == KeyEvent.VK_RIGHT) {
                object.setVelX(5);
            }

            if (key == KeyEvent.VK_LEFT) {
                object.setVelX(-5);
            }
        }
    }

    private void enemyMovementReleased(int key, GameObject object) {
        if (object.getId().equals(ID.ENEMY)) {
            //key events for player 1
            if (key == KeyEvent.VK_UP) {
                object.setVelY(0);
            }

            if (key == KeyEvent.VK_DOWN) {
                object.setVelY(0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                object.setVelX(0);
            }

            if (key == KeyEvent.VK_LEFT) {
                object.setVelX(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        for (GameObject object : handler.objects) {
            playerMovementReleased(key, object);
            player2MovementReleased(key, object);
            enemyMovementReleased(key, object);
        }
    }
}
