package com.gmail.elroman4.gungame;

import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

/**
 * Created with IntelliJ IDEA.
 * User: ren
 * Date: 24.06.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class ServicePanel extends JPanel {

     public void ServicePanel(){
        setSize(300,55);
     }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("killed aliens: ", 10, 15);


        //g.drawString( super.getCount() , 10, 15);
        g.drawLine(0, 20, getWidth(), 20);
        g.drawString("   ", 0, 25);

    }
}
