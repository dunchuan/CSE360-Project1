package edu.asu.CSE360._04._03;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Companion Class displays an image based upon the state value of
 * the superclass, ItsPane.
 *
 * Recitation Project 1
 * Completion time: 8.5 hours
 *
 * @author Jason Zellers, Robert Wasinger * @version 1.0
 */

public class Companion extends ItsPane {
    private JLabel label = new JLabel("Jason Zellers");
    private Image image;

    public Companion() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        add(label);

    }

    @Override
    void updateComponent() {
        URL imagePath = null;
        removeAll();
        switch(state) {
            default:
            case 0:
                break;
            case 1:
                imagePath = getClass().getResource("/happy.png");
                break;
            case 2:
                imagePath = getClass().getResource("/thinking.png");
                break;
            case 3:
                imagePath = getClass().getResource("/worry.png");
                break;
            case 4:
                imagePath = getClass().getResource("/sad.png");
                break;
        }


        if (imagePath != null) {
            try {
                image = ImageIO.read(imagePath);
            } catch (IOException e) {
                image = null;
                add(label);
            }
        } else {
            label.setText("Unable to load image.");
            image = null;
            add(label);
        }




    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
