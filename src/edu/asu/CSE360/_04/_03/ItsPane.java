package edu.asu.CSE360._04._03;

import javax.swing.*;
import java.awt.*;


/**
 * (basic description of program)
 *
 * Recitation Project 1
 * Completion time: (estimation of hours spent on this program)
 *
 * @author Robert Wasinger * @version 1.0
 */

public abstract class ItsPane extends JPanel {
    static int state = 0;


    public ItsPane() {
//        final Dimension MIN_SIZE= new Dimension(400, 300);
//        final Dimension MAX_SIZE = new Dimension(800, 600);
//        setMinimumSize(MIN_SIZE);
//        setMaximumSize(MAX_SIZE);
//        setPreferredSize(MAX_SIZE);
    }



    void changeState(int newState) {
        state = newState;
        updateComponent();
        revalidate();
        repaint();
    }

    abstract void updateComponent();

}
