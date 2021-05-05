package com.selection;

import com.helper.Sorter;
import com.helper.Utility;
import com.window.Panel;

import java.util.List;
import java.util.stream.Collectors;

public class SelectionSorter implements Sorter<Selection> {
    private final Panel panel;

    public SelectionSorter(Panel panel) {
        this.panel = panel;
    }

    public void sort(List<Selection> selections) throws InterruptedException {
        int counter = 0;
        for (int i = 0; i < selections.size(); i++) {
            List<Double> doubleList = selections.stream().map(Selection::getValue).collect(Collectors.toList());
            int index = Utility.getIndexOfMinimumElementBetweenBounds(doubleList, i, doubleList.size() - 1);
            if (index != counter) {
                setProperties(selections.get(index), selections.get(counter));
            }
            counter++;
            panel.repaint();
            Thread.sleep(50);
        }
    }

    private void setProperties(Selection selection1, Selection selection2) {
        double tempV = selection1.getValue();
        int tempH = selection1.getHeight();
        selection1.setValue(selection2.getValue());
        selection1.setHeight(selection2.getHeight());
        selection2.setValue(tempV);
        selection2.setHeight(tempH);
    }
}
