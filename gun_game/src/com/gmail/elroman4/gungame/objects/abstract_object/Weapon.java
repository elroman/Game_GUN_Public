package com.gmail.elroman4.gungame.objects.abstract_object;

import com.gmail.elroman4.gungame.objects.Unit;

/**
 * Created with IntelliJ IDEA.
 * User: ren
 * Date: 24.06.13
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public abstract class Weapon extends Unit {
    public boolean of_enemy;

    public Weapon(String FileNameImage, int Width, int Height) {
        super(FileNameImage, Width, Height);
    }

}
