package com.norouzi.phoenix;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class Handler implements Serializable {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        objects.forEach(GameObject::tick);
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
