package com.bubble;

import com.helper.SortObject;

import java.awt.*;

public class Bubble implements SortObject {
    private double radius;
    private double lastValue;
    private double value;
    private int x;
    private int y;

    public Bubble(double radius, double value, int x, int y) {
        this.radius = radius;
        this.value = value;
        this.lastValue = value;
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(double value) {
        setLastValue(this.value);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(this.x, this.y, (int)Math.abs(this.radius), (int)Math.abs(this.radius));
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(null, Font.BOLD, (int) Math.abs(this.radius / 4)));
        graphics.drawString(String.valueOf(this.value), (int)(this.x + Math.abs(this.radius / 4)), (int)(this.y + Math.abs(this.radius / 2) + Math.abs(this.radius / 12)));
    }

    @Override
    public String toString() {
        return "\nBubble{" +
                "value=" + value +
                "}\n";
    }
}
