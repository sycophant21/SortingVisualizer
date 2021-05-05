package com.helper;

import com.window.Panel;

import java.util.List;

public class Workflow {

    private final SortInitializer sortInitializer;
    private final Sorter sorter;
    private final Panel panel;

    public Workflow(SortHelpers sortHelpers, Panel panel) {

        this.sortInitializer = sortHelpers.getSortInitializer();
        this.sorter = sortHelpers.getSorter();
        this.panel = panel;
    }


    public void doSort(List<Double> doubleList) throws InterruptedException {
        List<SortObject> sortObjectList =  sortInitializer.initializeSort(doubleList);
        panel.repaint(sortObjectList);
        sorter.sort(sortObjectList);
        //initialize
        //initialize Panel
        //sort
    }
}
