package com.insert;

import com.helper.SortObject;

import java.awt.*;

public class Insert implements SortObject {
    private int x;
    private int height;
    private final int width;
    private double value;

    public Insert(int x, int height, int width, double value) {
        this.x = x;
        this.height = height;
        this.width = width;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(this.x, 0, width, this.height);
    }

    @Override
    public String toString() {
        return "Insert{" +
                "x=" + x +
                ", height=" + height +
                ", width=" + width +
                ", value=" + value +
                '}';
    }


}
