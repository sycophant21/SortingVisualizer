package com.bubble;

import com.helper.Sorter;
import com.window.Panel;

import java.util.List;

public class BubbleSorter implements Sorter<Bubble> {
    private Panel panel;

    public BubbleSorter(Panel panel) {
        this.panel = panel;
    }

    public void sort(List<Bubble> listToBeSorted) throws InterruptedException {

        int counter = listToBeSorted.size();
        for (int i = 0; i < listToBeSorted.size(); i++) {
            counter--;
            if (counter > 0) {
                for (int j = 0; j < counter; j++) {
                    if (listToBeSorted.get(j).getValue() > listToBeSorted.get(j + 1).getValue()) {
                        setProperties(listToBeSorted.get(j), listToBeSorted.get(j + 1));
                    }
                    panel.repaint();
                    Thread.sleep(100);
                }
                panel.repaint();
                Thread.sleep(100);
            } else {
                panel.repaint();
                break;
            }
        }
    }

    private void setProperties(Bubble bubble1, Bubble bubble2) {
        double tempR = bubble1.getRadius();
        int tempY = bubble1.getY();
        double tempV = bubble1.getValue();
        bubble1.setValue(bubble2.getValue());
        bubble2.setValue(tempV);
        bubble1.setRadius(bubble2.getRadius());
        bubble2.setRadius(tempR);
        bubble1.setY(bubble2.getY());
        bubble2.setY(tempY);
        bubble2.setX((int) (bubble2.getX() - tempR + bubble1.getRadius()));
    }

}
