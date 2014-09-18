package com.gmail.elroman4.gungame.objects;

import com.gmail.elroman4.gungame.GamePanel;
import com.gmail.elroman4.gungame.objects.abstract_object.Resources;

public class Crystal extends Resources implements IUnit {

    public Crystal() {

        super("сrystal.png", 36, 38);

        X = (int) (Math.random() * (GamePanel.WIDTH - WIDTH));
        Y =50;
        speed = (int) (Math.random()*5)+1;
        musicOnDestroy = 0;
    }

    @Override
    public int moveY() {
        int oldY = Y;
        Y += speed;
        return Math.min(maxY, oldY);
    }

    public boolean getClear() {
        if (Y >= maxY)
            clear = true;
        return clear;
    }


}
