package com.merge;

import com.helper.SortObject;

import javax.swing.text.Style;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Merge implements SortObject {
    private final int width;
    private int x;
    private int height;
    private double value;
    private boolean currentlyBeingSorted;

    public Merge(int x, int height, int width, double value) {
        this.width = width;
        this.x = x;
        this.height = height;
        this.value = value;
        this.currentlyBeingSorted = false;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isCurrentlyBeingSorted() {
        return currentlyBeingSorted;
    }

    public void setCurrentlyBeingSorted(boolean currentlyBeingSorted) {
        this.currentlyBeingSorted = currentlyBeingSorted;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        if (currentlyBeingSorted) {
            graphics.setColor(Color.GREEN);
            //graphics.fillRect(this.x, 355, width, this.height);
        }
        graphics.fillRect(this.x, 0, width, this.height);
    }

    @Override
    public String toString() {
        return "\nMerge{" +
                "x=" + x +
                ", height=" + height +
                ", value=" + value +
                "}\n";
    }
}
