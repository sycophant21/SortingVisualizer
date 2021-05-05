package com.insert;

import com.helper.Sorter;
import com.window.Panel;

import java.util.List;

public class InsertSorter implements Sorter<Insert> {
    private final Panel panel;
    private List<Insert> inserts;

    public InsertSorter(Panel panel) {
        this.panel = panel;
    }

    public void sort(List<Insert> inserts) throws InterruptedException {
        this.inserts = inserts;
        for (int i = 1; i < inserts.size(); i++) {
            checkPrevious(i);
        }
        //System.out.println(inserts);
    }

    private void checkPrevious(int index) throws InterruptedException {
        int temp = index;
        int indexToChange = -1;
        for (int i = 0; i <= temp - 1; i++) {
            if (inserts.get(i).getValue() > inserts.get(temp).getValue()) {
                indexToChange = i;
                break;
            }
        }
        if (indexToChange != -1 && indexToChange < inserts.size()) {
            Insert insert = inserts.get(temp);
            insert.setX(inserts.get(indexToChange).getX());
            inserts.remove(temp);
            inserts.add(indexToChange, insert);
            for (int i = indexToChange + 1; i <= temp; i++) {
                inserts.get(i).setX(inserts.get(i - 1).getX() + (2 * inserts.get(i - 1).getWidth()));
            }
        }
        panel.repaint();
        Thread.sleep(50);
    }

}
