package edu.asu.CSE360._04._03;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

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
    private Image baseImage;

    private MostRecentQueue<AnimationFrame> frames = new MostRecentQueue<>(
            new AnimationFrame(0, 0, 0, 0, null));


    public Companion() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        add(label);
    }

    @Override
    void updateComponent() {
        resetImage();

        Runnable animation = null;

        URL imagePath = null;
        removeAll();
        switch(state) {
            default:
            case 0:
                break;
            case 1:
                imagePath = getClass().getResource("/happy.png");
                animation = new AnimateHappy();
                break;
            case 2:
                resetImage();
                imagePath = getClass().getResource("/thinking.png");
                animation = null;
                break;
            case 3:
                resetImage();
                imagePath = getClass().getResource("/worry.png");
                animation = null;
                break;
            case 4:
                imagePath = getClass().getResource("/sad.png");
                animation = new AnimateSad();
                break;
        }

        if (animation != null) {
            new Thread(animation).start();
        }


        if (imagePath != null) {
            try {
                baseImage = ImageIO.read(imagePath);
            } catch (IOException e) {
                baseImage = null;
                add(label);
            }
        } else {
            label.setText("Unable to load image.");
            baseImage = null;
            add(label);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        AnimationFrame frame = frames.poll();
        Image image = frame.image == null ? baseImage : frame.image;

        g.drawImage(image, frame.x, frame.y, frame.width,
                frame.height, null);
    }

    private void resetImage() {
        frames.clear(new AnimationFrame(0, 0, getWidth(), getHeight(),
                baseImage));
        repaint();
    }



    private class AnimateHappy implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread starts: " + state);
            int initialState = state;
            int speed = 5;
            int frameCount = 30;
            int frameDelay = 10;

            LinkedList<AnimationFrame> happyFrames = new LinkedList<>();

            resetImage();

            int frameWidth = getWidth();
            int frameHeight = getHeight();
            int frameX = 0;
            int frameY = 0;

            for (int i = 0; i < frameCount; i++) {
                happyFrames.add(new AnimationFrame(frameX, frameY, frameWidth, frameHeight));

                frameWidth += speed;
                frameHeight += speed;

                // Splits the 'growth' evenly
                frameX -= speed / 2;
                frameY -= speed / 2;
            }

            speed *= -1;

            for (int i = 0; i < frameCount; i++) {
                happyFrames.add(new AnimationFrame(frameX, frameY, frameWidth, frameHeight));

                frameWidth += speed;
                frameHeight += speed;

                // Splits the 'growth' evenly
                frameX -= speed / 2;
                frameY -= speed / 2;

            }

            frames.cycle(happyFrames);

            while (initialState == ItsPane.state) {
                if (initialState != ItsPane.state)
                    break;

                    repaint();

                    try {
                        Thread.sleep(frameDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            System.out.println("Thread exits: " + initialState + " " + state);
        }
    }

    private class AnimateSad implements Runnable {
        @Override
        public void run() {

            System.out.println("Thread starts: " + state);
            int initialState = state;
            int speed = 5;
            int frameCount = 0;
            int frameDelay = 10;

            resetImage();
            int imageHeight = frames.getTail().height;

            AnimationFrame latestFrame = new AnimationFrame(0, 0 - imageHeight,
                    getWidth(), getHeight());
            frames.add(latestFrame);

            //45 pixels is bottom whitespace on current image
            while (latestFrame.y <= 45) {
                int prevY= latestFrame.y;
                latestFrame = new AnimationFrame(0, prevY + speed, latestFrame.width, latestFrame.height);
                frames.add(latestFrame);
                frameCount++;
            }

            for (int i = 0; i < frameCount; i++) {
                if (initialState != ItsPane.state)
                    break;

                repaint();

                try {
                    Thread.sleep(frameDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("Thread exits: " + initialState + " " + state);
        }
    }
//
//    private class AnimateWorried implements Runnable {
//        @Override
//        public void run() {
//
//        }
//    }
//
//    private class AnimateThinking implements Runnable {
//        @Override
//        public void run() {
//            System.out.println("Thread starts: " + state);
//            int initialState = state;
//            int frames = 100;
//            int frameDelay= 500;
//            final Graphics2D g2d = (Graphics2D) getGraphics();
//            while (initialState == state) {
//                for (int i = 0; i < frames; i++) {
//                    if (initialState != state)
//                        break;
//                    SwingUtilities.invokeLater(() -> {
//                        g2d.setBackground(Color.WHITE);
//                        g2d.clearRect(0, 0, getWidth(), getHeight());
//
//                        g2d.rotate(Math.PI / 20, imageWidth / 2, imageHeight / 2);
//                        g2d.drawRenderedImage(image, null);
//                    });
//
//
//
//                    try {
//                        Thread.sleep(frameDelay);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
////    }
}
