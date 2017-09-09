package edu.asu.CSE360._04._03;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/** The Companion class is a state machine reflecting the progress
 *      of the student.
 *
 *
 */

public class Companion extends ItsPane {
    private JLabel label = new JLabel("Companion.java");
    private Image image;
    private JLabel failureLabel = new JLabel("Unable to retrieve image.");

    public Companion() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        updateComponent();
    }

    @Override
    void updateComponent() {
        URL imagePath = null;
        removeAll();
        switch(state) {
            default:
            case 0:
                add(label);
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
                add(failureLabel);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

    }
}
