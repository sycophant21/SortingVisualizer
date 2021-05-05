package com.window;

import com.helper.SortObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {
    private List<SortObject> sortObjectList;

    public Panel(List<SortObject> sortObjectList) {
        this.sortObjectList = sortObjectList;
    }

    public Panel() {
        this.sortObjectList = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1440,770);
        for (SortObject sortObject : sortObjectList) {
            sortObject.draw(g);
        }
    }

    public void repaint(List<SortObject> sortObjects) {
        this.sortObjectList = sortObjects;
        repaint();
    }

}
