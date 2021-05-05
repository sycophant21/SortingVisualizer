package com.insert;

import com.helper.SortInitializer;
import com.helper.Utility;

import java.util.LinkedList;
import java.util.List;

public class InsertInitializer implements SortInitializer<Insert> {

    @Override
    public List<Insert> initializeSort(List<Double> doubleList) {
        LinkedList<Insert> listToBeSorted = new LinkedList<>();
        int length = doubleList.size();
        double max = Utility.getMaximum(doubleList);
        double heightFactor = 770 / (max + 10);
        double width = 1440.0 / ((2 * length) + 1);
        double value = doubleList.get(0);
        listToBeSorted.add(new Insert((int) (width), (int) Math.floor(Math.abs(value) * heightFactor), (int) (width), value));
        for (int i = 1; i < length; i++) {
            Insert insert = listToBeSorted.get(listToBeSorted.size() - 1);
            value = doubleList.get(i);
            listToBeSorted.add(new Insert(insert.getX() + insert.getWidth() + (int) (width), (int) Math.ceil(Math.abs(value) * heightFactor), (int) (width), value));
        }
        return listToBeSorted;
    }
}
