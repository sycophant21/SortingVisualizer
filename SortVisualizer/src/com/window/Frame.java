package com.window;

import com.window.Panel;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(Panel panel) {
        this.setTitle("SortingVisualizer");
        this.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
    }
}
