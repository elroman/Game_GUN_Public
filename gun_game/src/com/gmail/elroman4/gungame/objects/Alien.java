package com.gmail.elroman4.gungame.objects;

import com.gmail.elroman4.gungame.GamePanel;
import com.gmail.elroman4.gungame.objects.abstract_object.Enemy;

public class Alien extends Enemy implements IUnit {
    private final String stSoundCrush;

    public Alien() {
        super("alien.png", 44, 36);
        stSoundCrush = "E:/=Java=/workspace/Game_GUN_Public/out/production/Game_GUN_Public/gun10.wav";
        X = (int) (Math.random() * (GamePanel.WIDTH - WIDTH));
        Y = 50;

        minY = 50;
        maxY = GamePanel.HEIGHT;

        speed = 1;
        musicOnDestroy = 52;
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

public void setClear(){
    clear = true;
    super.playSound(stSoundCrush);

}



}

