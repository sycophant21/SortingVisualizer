package com.quick;

import com.helper.Sorter;
import com.window.Panel;

import java.util.List;

public class QuickSorter implements Sorter<Quick> {
    private final Panel panel;
    private List<Quick> quicks;

    public QuickSorter(Panel panel) {
        this.panel = panel;
    }

    public void sort(List<Quick> quicks) throws InterruptedException {
        this.quicks = quicks;
        sort(0, quicks.size() - 1);
    }

    private void sort(int lower, int higher) throws InterruptedException {
        if (lower < higher) {
            Quick pivotElement = quicks.get(higher);
            int i = lower - 1;
            for (int j = lower; j <= higher - 1; j++) {
                if (quicks.get(j).getValue() < pivotElement.getValue()) {
                    i++;
                    swapProperties(i, j);
                    panel.repaint();
                    Thread.sleep(10);
                }
            }
            swapProperties(i + 1, higher);
            panel.repaint();
            Thread.sleep(10);
            if (i % 2 == 0) {
                sort(i + 2, higher);
                sort(lower, i);
            }
            else {
                sort(lower, i);
                sort(i + 2, higher);
            }

        }
    }

    private void swapProperties(int index1, int index2) {
        int tempH = quicks.get(index1).getHeight();
        double tempV = quicks.get(index1).getValue();
        quicks.get(index1).setHeight(quicks.get(index2).getHeight());
        quicks.get(index1).setValue(quicks.get(index2).getValue());
        quicks.get(index2).setHeight(tempH);
        quicks.get(index2).setValue(tempV);
    }

}

