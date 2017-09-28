package edu.asu.CSE360._04._03;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

/**
 * Companion Class displays an image based upon the state value of
 * the superclass, ItsPane.
 *
 * Recitation Project 2
 * Completion time: 9 hours
 *
 * @author Jason Zellers, Robert Wasinger * @version 2.0
 */

public class Companion extends ItsPane {
    private JLabel label = new JLabel("Jason Zellers");
    private Image baseImage;

    private MostRecentQueue<AnimationFrame> frames = new MostRecentQueue<>(
            new AnimationFrame(0, 0, 0, 0, null));

    private final int frameDelay = 20;

    public Companion() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        add(label);
    }

    @Override
    void updateComponent() {
        resetFrames();

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

                imagePath = getClass().getResource("/thinking.png");
                animation = new AnimateThinking();
                break;
            case 3:
                imagePath = getClass().getResource("/worry.png");
                animation = new AnimateWorried();
                break;
            case 4:
                imagePath = getClass().getResource("/sad.png");
                animation = new AnimateSad();
                break;
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

        // ensures static images will load correctly
        resetFrames();

        if (animation != null) {
            new Thread(animation).start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        AnimationFrame frame = frames.poll();

        Image image = frame.image == null ? baseImage : frame.image;


        if (frame.hasTransform()) {
            Graphics2D g2d = (Graphics2D) g;
            // Graphics2D will use the raw image size unless it's scaled
            image = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);

            g2d.drawImage(image, frame.transform, null);
        }
        else {
            g.drawImage(image, frame.x, frame.y, frame.width,
                    frame.height, null);
        }
    }

    private void resetFrames() {
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

            LinkedList<AnimationFrame> happyFrames = new LinkedList<>();

            resetFrames();

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
            LinkedList<AnimationFrame> sadFrames = new LinkedList<>();

            resetFrames();
            int imageHeight = frames.getTail().height;

            AnimationFrame latestFrame = new AnimationFrame(0, 0 - imageHeight,
                    getWidth(), getHeight());
            sadFrames.add(latestFrame);

            //45 pixels consumes some bottom whitespace on current image
            while (latestFrame.y <= 45) {
                int prevY= latestFrame.y;
                latestFrame = new AnimationFrame(0, prevY + speed, latestFrame.width, latestFrame.height);
                sadFrames.add(latestFrame);
                frameCount++;
            }

            frames.add(sadFrames);

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

    private class AnimateWorried implements Runnable {
        int initialState = state;

        final int rightBound = 25;
        final int leftBound = 25;
        final int speed = 4;

        LinkedList<AnimationFrame> worriedFrames = new LinkedList<>();

        int imageHeight = frames.getTail().height;
        int imageWidth = frames.getTail().width;
        AnimationFrame worriedFrame;

        @Override
        public void run() {
            System.out.println("Thread Starts: " + state);
            resetFrames();

            for (int i = 0; i > -leftBound; i--) {
                buildWoriedFrame(i);
            }

            for (int i = -leftBound; i < rightBound; i++) {
                buildWoriedFrame(i);
            }

            for (int i = rightBound; i > 0; i--) {
                buildWoriedFrame(i);
            }

            frames.cycle(worriedFrames);

            while (initialState == state) {
                for (int i = 0; i < worriedFrames.size(); i++) {
                    if (initialState != state)
                        break;

                    repaint();

                    try {
                        Thread.sleep(frameDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        private void buildWoriedFrame(int i) {
            worriedFrame = new AnimationFrame(0, 0, imageWidth, imageHeight);

            AffineTransform transform = new AffineTransform();
            transform.translate(speed * i, 0);

            worriedFrame.setTransform(transform);
            worriedFrames.add(worriedFrame);
        }
    }

    private class AnimateThinking implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread starts: " + state);
            resetFrames();

            int initialState = state;
            int frameCount = 50;

            LinkedList<AnimationFrame> thinkingFrames = new LinkedList<>();

            int imageHeight = frames.getTail().height;
            int imageWidth = frames.getTail().width;

            AnimationFrame thinkFrame;

            for (int i = 1; i < frameCount + 1; i++) {
                thinkFrame = new AnimationFrame(0, 0, imageWidth, imageHeight);

                AffineTransform transform = new AffineTransform();
                transform.rotate(i * 2 * Math.PI /frameCount, imageWidth / 2, imageHeight / 2);

                thinkFrame.setTransform(transform);
                thinkingFrames.add(thinkFrame);
            }

            frames.cycle(thinkingFrames);

            while (initialState == state) {
                    repaint();

                    try {
                        Thread.sleep(frameDelay * 2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
