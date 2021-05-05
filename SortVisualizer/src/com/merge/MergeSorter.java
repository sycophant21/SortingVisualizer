package com.merge;

import com.helper.Sorter;
import com.window.Panel;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorter<Merge> {
    private final Panel panel;
    private List<Merge> mergeList;

    public MergeSorter(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void sort(List<Merge> mergeList) throws InterruptedException {
        this.mergeList = mergeList;
        //System.out.println(mergeList);
        sort(0, mergeList.size() - 1);
        //System.out.println(mergeList);
        for (Merge merge : mergeList) {
            merge.setCurrentlyBeingSorted(true);
            panel.repaint();
            Thread.sleep(5);
        }
    }

    private void sort(int lower, int higher) throws InterruptedException {
        if (higher > lower) {
            int middle = lower + (higher - lower) / 2;
            sort(lower, middle);
            sort(middle + 1, higher);

            List<Merge> tempMergeList1 = new ArrayList<>();
            List<Merge> tempMergeList2 = new ArrayList<>();

            fillListsToBeSorted(lower, middle, tempMergeList1);
            fillListsToBeSorted(middle + 1, higher, tempMergeList2);

            int counter1 = 0;
            int counter2 = 0;

            int isDone;

            for (int i = lower; i <= higher; i++) {

                if (tempMergeList1.get(counter1).getValue() > tempMergeList2.get(counter2).getValue()) {
                    isDone = fillList(mergeList.get(i), tempMergeList2.get(counter2), counter2, counter1, tempMergeList2, tempMergeList1, i, higher);
                    if (isDone == -1) {
                        break;
                    } else {
                        counter2 = isDone;
                    }

                } else {
                    isDone = fillList(mergeList.get(i), tempMergeList1.get(counter1), counter1, counter2, tempMergeList1, tempMergeList2, i, higher);
                    if (isDone == -1) {
                        break;
                    } else {
                        counter1 = isDone;
                    }
                }
            }
            sortingDone();
        }
        panel.repaint();
        Thread.sleep(5);
    }

    private void sortingDone() {
        for (Merge merge : mergeList) {
            merge.setCurrentlyBeingSorted(false);
        }
    }

    private void fillListsToBeSorted(int lower, int higher, List<Merge> tempMergeList) throws InterruptedException {
        for (int i = lower; i <= higher; i++) {
            Merge tempMerge = mergeList.get(i);
            tempMerge.setCurrentlyBeingSorted(true);
            Merge newMerge = new Merge(tempMerge.getX(), tempMerge.getHeight(), tempMerge.getWidth(), tempMerge.getValue());
            newMerge.setCurrentlyBeingSorted(true);
            tempMergeList.add(newMerge);
        }
    }

    private int fillList(Merge primaryMergeElement, Merge secondaryMergeElement, int primaryCounter, int secondaryCounter, List<Merge> primaryList, List<Merge> secondaryList, int lastIndex, int maxIndex) throws InterruptedException {
        panel.repaint();
        Thread.sleep(5);
        swap(primaryMergeElement, secondaryMergeElement);
        primaryCounter++;
        if (primaryCounter == primaryList.size()) {
            for (int j = lastIndex + 1; j <= maxIndex; j++) {
                panel.repaint();
                Thread.sleep(5);
                swap(mergeList.get(j), secondaryList.get(secondaryCounter));
                secondaryCounter++;
                panel.repaint();
                Thread.sleep(5);
            }
            return -1;
        }
        return primaryCounter;
    }

    private void swap(int index1, int index2) {
        double tempV = mergeList.get(index1).getValue();
        int tempH = mergeList.get(index1).getHeight();
        mergeList.get(index1).setHeight(mergeList.get(index2).getHeight());
        mergeList.get(index1).setValue(mergeList.get(index2).getValue());
        mergeList.get(index2).setHeight(tempH);
        mergeList.get(index2).setValue(tempV);
    }

    private void swap(Merge merge1, Merge merge2) {
/*        int tempX = merge1.getX();
        merge1.setX(merge2.getX());
        merge2.setX(tempX);*/
        double tempV = merge1.getValue();
        int tempH = merge1.getHeight();
        merge1.setHeight(merge2.getHeight());
        merge1.setValue(merge2.getValue());
        merge2.setHeight(tempH);
        merge2.setValue(tempV);
    }
}
