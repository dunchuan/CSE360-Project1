package edu.asu.CSE360._04._03;

import java.awt.*;

public class AnimationFrame {

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

    public int x;
    public int y;
    public int width;
    public int height;
    public Image image = null;
}
