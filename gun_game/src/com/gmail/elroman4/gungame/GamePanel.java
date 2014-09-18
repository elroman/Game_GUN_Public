package com.gmail.elroman4.gungame;

import com.gmail.elroman4.gungame.objects.*;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class GamePanel extends JPanel {

    public static int WIDTH;
    public static int HEIGHT;

    private static final long serialVersionUID = 1L;
    Tank tank;
    Alien alien;
    Space space;
    Crystal crystal;
    int stage;
    ArrayList<Unit> array_obj = new ArrayList<Unit>();
    Timer t_object = new Timer(30, new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            repaint();
        }
    });

    public GamePanel() {
        addKeyListener(new MyKey());
        setFocusable(true);
        t_object.start();

      }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

      createGameObjects();

        g.drawImage(space.getPicture(), space.moveX(), space.moveY(), null);

        for (int i = 0; i < array_obj.size(); i++) {
            Unit obj = array_obj.get(i);

            if (obj.getClear()) {
                array_obj.remove(obj);
                return;
            }

            paintGameObj(obj, g);
            obj.calculateCollisions(array_obj);
        }
    }

    private void createGameObjects() {
        if (WIDTH+HEIGHT ==0 ){
            WIDTH =  getWidth();
            HEIGHT = getHeight();  }

        if (space == null)
            space = new Space();
        if (crystal == null || crystal.getClear()) {
            crystal = new Crystal();
            array_obj.add(crystal);
        }
        if (tank == null) {
            tank = new Tank();
            array_obj.add(tank);
        }
        if (alien == null || alien.getClear()) {
            alien = new Alien();
            array_obj.add(alien);
        }
    }

    private void paintGameObj(Unit obj, Graphics g) {
        g.drawImage(obj.getPicture(), obj.moveX(), obj.moveY(), null);
    }

    private class MyKey implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {


            switch (event.getKeyCode()) {

                case KeyEvent.VK_SPACE:
                    array_obj.add(new Bomb(tank.getCentreX(), tank.getGunHeight()));
                    break;
                case KeyEvent.VK_RIGHT:
                    tank.moveRight();
                    break;
                case KeyEvent.VK_LEFT:
                    tank.moveLeft();
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}

