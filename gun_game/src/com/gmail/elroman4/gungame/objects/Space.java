package com.gmail.elroman4.gungame.objects;

public class Space extends Unit implements IUnit {

    public Space() {
        super("space.png", 300, 300);

        X = 0;
        Y = 0;
        calculateCollisions = false;

    }
}
