package com.gmail.elroman4.gungame.objects;

import java.awt.*;

public interface IUnit {

    Image getPicture();

    int moveX();

    int moveY();

    boolean getClear();

    void setClear(boolean newClear);


}
