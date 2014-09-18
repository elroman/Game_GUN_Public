package com.gmail.elroman4.gungame.objects;

import com.gmail.elroman4.gungame.GamePanel;
import com.gmail.elroman4.gungame.Utils;
import com.gmail.elroman4.gungame.objects.abstract_object.Army;
import com.gmail.elroman4.gungame.objects.abstract_object.Enemy;
import com.gmail.elroman4.gungame.objects.abstract_object.Resources;
import com.gmail.elroman4.gungame.objects.abstract_object.Weapon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public abstract class Unit implements IUnit {

    public int X;
    public int Y;
    public int minY = 0;
    public int maxY = GamePanel.HEIGHT;
    public int minX = 0;
    public int maxX = GamePanel.WIDTH;
    public int WIDTH;
    public int HEIGHT;
    public int speed;
    public String PICTURE_FILE_NAME;
    public Image picture;
    public int musicOnDestroy = 0;
    public boolean clear = false;
    public boolean calculateCollisions;


    public Unit(String FileNameImage, int Width, int Height) {

        WIDTH = Width;
        HEIGHT = Height;
        PICTURE_FILE_NAME = FileNameImage;

        if (picture == null)
            picture = Utils.getImage(PICTURE_FILE_NAME, WIDTH, HEIGHT);

        calculateCollisions = true;
    }

    public Image getPicture() {
        return picture;
    }

    public int moveX() {
        return X;
    }

    public int moveY() {
        return Y;
    }

    public boolean getClear() {
        if (Y > maxY)
            clear = true;
        return clear;
    }

    public void setClear(boolean newClear) {
        clear = newClear;
    }

    public void calculateCollisions(ArrayList<Unit> array_obj) {
        for (int i = 0; i < array_obj.size(); i++) {
            for (int j = i + 1; j < array_obj.size(); j++) {

                Unit obj1 = array_obj.get(i);
                Unit obj2 = array_obj.get(j);
                if (obj1.calculateCollisions && obj2.calculateCollisions) {

                    int X11 = obj1.X;
                    int X12 = X11 + obj1.WIDTH;
                    int X21 = obj2.X;
                    int X22 = X21 + obj2.WIDTH;

                    int Y11 = obj1.Y;
                    int Y12 = Y11 + obj1.HEIGHT;
                    int Y21 = obj2.Y;
                    int Y22 = Y21 + obj2.HEIGHT;

                    if (X12 < X21) continue;
                    if (X11 > X22) continue;
                    if (Y12 < Y21) continue;
                    if (Y11 > Y22) continue;

                    if ((((X21 <= X11 && X11 <= X22) || (X21 <= X12 && X12 <= X22)) &&
                            ((Y21 <= Y11 && Y11 <= Y22) || (Y21 <= Y12 && Y12 <= Y22))) ||
                            (((X11 <= X21 && X21 <= X12) || (X11 <= X22 && X22 <= X12)) &&
                                    ((Y11 <= Y21 && Y21 <= Y12) || (Y11 <= Y22 && Y22 <= Y12)))) {


                        System.out.println(obj1.toString() + "  " + obj2.toString() + " есть столкновение ");

                        if ((obj1 instanceof Army) || (obj2 instanceof Army)) {
                            if ((obj1 instanceof Enemy) || (obj2 instanceof Enemy)) {
                                int k = 1;
                                obj1.clear = true;
                                obj2.clear = true;
                            }
                        }

                        if ((obj1 instanceof Army) || (obj2 instanceof Army)) {
                            if ((obj1 instanceof Resources) || (obj2 instanceof Resources)) {
                                int k = 1;
                                obj1.clear = true;
                                obj2.clear = true;
                            }
                        }

                        if ((obj1 instanceof Weapon) || (obj2 instanceof Weapon)) {
                            if ((obj1 instanceof Enemy) || (obj2 instanceof Enemy)) {
                                int k = 1;
                                obj1.clear = true;
                                obj2.clear = true;

                                if (obj1 instanceof Alien) {((Alien) obj1).setClear();}
                                else  {((Alien) obj2).setClear();}




                                }
                            }
                        }
                    }


//                        if (obj1 instanceof Crystal) {
//                            array_obj.remove(obj1);
//                            obj1.setClear(true);
//                            System.out.println(obj1.toString() + "  " + obj2.toString() + " условие 1");
//                        }
//                        if (obj2 instanceof Crystal) {
//                            array_obj.remove(obj2);
//                            obj2.setClear(true);
//                            System.out.println(obj1.toString() + "  " + obj2.toString() + " условие 2");
//                        }
//                        if (!(obj1 instanceof Crystal) && !(obj2 instanceof Crystal)) {
//                            if (!(obj1 instanceof Tank))
//                                array_obj.remove(obj1);
//                            if (!(obj2 instanceof Tank))
//                                array_obj.remove(obj2);
//
//                            obj1.setClear(true);
//                            obj2.setClear(true);
//                            System.out.println(obj1.toString() + "  " + obj2.toString() + " условие 3");
//                        }
                }}}



    public void playSound(String stSound) {

        try{
            ClassLoader classLoader = Utils.class.getClassLoader();
           AudioPlayer p = AudioPlayer.player;

            AudioStream as;
            as = new AudioStream(new FileInputStream(stSound));
            p.start(as);

        }

        catch(IOException IOE){}

        }




    public boolean collisingObject(Unit obj1,Unit obj2){




        return false;
    }


}