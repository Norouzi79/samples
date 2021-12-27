package com.norouzi.phoenix.logic;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class Handler implements Serializable {
    public LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }
    }

    public void render(Graphics g) {
        objects.forEach(x -> x.render(g));
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }
}
