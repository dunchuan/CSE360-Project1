package edu.asu.CSE360._04._03;

import java.awt.*;
import java.awt.geom.AffineTransform;
/**
 * AnimationFrame is an object representing a single frame for the
 * draw thread to render.  An image and/or Transformation may optionally be
 * included.
 *
 * Recitation Project 2
 * Completion time: 1 hour
 *
 * @author Robert Wasinger * @version 1.0
 */
public class AnimationFrame {
    public int x;
    public int y;
    public int width;
    public int height;
    public Image image = null; // Currently unused
    public AffineTransform transform = null;

    public AnimationFrame(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public AnimationFrame(int x, int y, int width, int height, Image img) {
        this(x, y, width, height);
        this.image = img;
    }

    public AnimationFrame(AnimationFrame otherFrame) {
        this.x = otherFrame.x;
        this.y = otherFrame.y;
        this.width = otherFrame.width;
        this.height = otherFrame.height;
        this.image = otherFrame.image;
    }

    public boolean hasTransform() {
        return transform != null;
    }

    public void setTransform(AffineTransform transform) {
        this.transform = transform;
    }


}
