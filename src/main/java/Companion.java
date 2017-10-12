
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Companion Class displays an image based upon the state value of
 * the superclass, ItsPane.
 *
 * Recitation Project 2
 * Completion time: 9 hours
 *
 * @author Jason Zellers, Robert Wasinger * @version 2.0
 */

public class Companion extends ItsPane implements ComponentListener, Observer{
    private JLabel label = new JLabel("Jason Zellers");
    private Image baseImage;

    private MostRecentQueue<AnimationFrame> frames = new MostRecentQueue<>(
            new AnimationFrame(0, 0, 0, 0, null));

    private final int frameDelay = 20;

    private Thread animationThread = null;


    public Companion() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        addComponentListener(this);
        add(label);
    }

    @Override
    void updateComponent() {
        animationThread = null;

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
                label.setText("Unable to load image.");
                add(label);
            }
        } else {
            baseImage = null;
            add(label);
        }

        // ensures static images will load correctly
        resetFrames();

        if (animation != null) {
            animationThread = new Thread(animation);
            animationThread.start();
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

    @Override
    public void componentResized(ComponentEvent e) {
        updateComponent();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("nogified");
        System.out.println(o);
    }


    private class AnimateHappy implements Runnable {

        @Override
        public void run() {

            int speed = 5;
            int frameCount = 30;

            LinkedList<AnimationFrame> happyFrames = new LinkedList<>();

            int frameWidth = frames.getTail().width;
            int frameHeight = frames.getTail().height;
            int frameX = 0;
            int frameY = 0;

            for (int i = 0; i < frameCount; i++) {
                happyFrames.add(new AnimationFrame(frameX, frameY, frameWidth,
                        frameHeight));

                frameWidth += speed;
                frameHeight += speed;

                // Splits the 'growth' evenly
                frameX -= speed / 2;
                frameY -= speed / 2;
            }

            speed *= -1;

            for (int i = 0; i < frameCount; i++) {
                happyFrames.add(new AnimationFrame(frameX, frameY, frameWidth,
                        frameHeight));

                frameWidth += speed;
                frameHeight += speed;

                // Splits the 'growth' evenly
                frameX -= speed / 2;
                frameY -= speed / 2;

            }

            frames.cycle(happyFrames);

            while (animationThread == Thread.currentThread()) {
                if (animationThread != Thread.currentThread())
                    break;

                    repaint();

                    try {
                        Thread.sleep(frameDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    private class AnimateSad implements Runnable {
        @Override
        public void run() {
            int speed = 5;
            int frameCount = 0;
            LinkedList<AnimationFrame> sadFrames = new LinkedList<>();

            int imageHeight = frames.getTail().height;
            int imageWidth = frames.getTail().width;

            AnimationFrame latestFrame = new AnimationFrame(0, 0 - imageHeight,
                    imageWidth, imageHeight);
            sadFrames.add(latestFrame);

            //45 pixels consumes some bottom whitespace on current image
            while (latestFrame.y <= 45) {
                int prevY= latestFrame.y;
                latestFrame = new AnimationFrame(0, prevY + speed,
                        latestFrame.width, latestFrame.height);
                sadFrames.add(latestFrame);
                frameCount++;
            }

            frames.add(sadFrames);

            for (int i = 0; i < frameCount; i++) {
                if (animationThread != Thread.currentThread())
                    break;

                repaint();

                try {
                    Thread.sleep(frameDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private class AnimateWorried implements Runnable {

        final int rightBound = 25;
        final int leftBound = 25;
        final int speed = 4;

        LinkedList<AnimationFrame> worriedFrames = new LinkedList<>();

        int imageHeight = frames.getTail().height;
        int imageWidth = frames.getTail().width;
        AnimationFrame worriedFrame;

        @Override
        public void run() {

            for (int i = 0; i > -leftBound; i--) {
                buildWorriedFrame(i);
            }

            for (int i = -leftBound; i < rightBound; i++) {
                buildWorriedFrame(i);
            }

            for (int i = rightBound; i > 0; i--) {
                buildWorriedFrame(i);
            }

            frames.cycle(worriedFrames);

            while (animationThread == Thread.currentThread()) {
                for (int i = 0; i < worriedFrames.size(); i++) {
                    if (animationThread != Thread.currentThread())
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

        private void buildWorriedFrame(int i) {
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

            int frameCount = 50;

            LinkedList<AnimationFrame> thinkingFrames = new LinkedList<>();

            int imageHeight = frames.getTail().height;
            int imageWidth = frames.getTail().width;

            AnimationFrame thinkFrame;

            for (int i = 1; i < frameCount + 1; i++) {
                thinkFrame = new AnimationFrame(0, 0, imageWidth, imageHeight);

                AffineTransform transform = new AffineTransform();
                transform.rotate(i * 2 * Math.PI /frameCount,
                        imageWidth / 2, imageHeight / 2);

                thinkFrame.setTransform(transform);
                thinkingFrames.add(thinkFrame);
            }

            frames.cycle(thinkingFrames);

            while (animationThread == Thread.currentThread()) {
                    repaint();

                    try {
                        Thread.sleep(frameDelay * 2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    /*
     * Observer Code
     *
     */






}
