package com.quick;

import com.helper.SortObject;

import java.awt.*;

public class Quick implements SortObject {
    private final int width;
    private int x;
    private int height;
    private double value;

    public Quick(int x, int height, int width, double value) {
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(this.x, 0, width, this.height);
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
