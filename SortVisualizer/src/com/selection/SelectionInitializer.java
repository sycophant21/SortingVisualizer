package com.selection;

import com.helper.SortInitializer;
import com.helper.Utility;

import java.util.ArrayList;
import java.util.List;

public class SelectionInitializer implements SortInitializer<Selection> {

    public List<Selection> initializeSort(List<Double> doubleList) {
        List<Selection> listToBeSorted = new ArrayList<>();
        int length = doubleList.size();
        double max = Utility.getMaximum(doubleList);
        double heightFactor = 770 / (max + 10);
        double width = 1440.0 / ((2 * length) + 1);
        double value = doubleList.get(0);
        listToBeSorted.add(new Selection((int) (width), (int) Math.floor(Math.abs(value) * heightFactor), (int) (width), value));
        for (int i = 1; i < length; i++) {
            Selection selection = listToBeSorted.get(listToBeSorted.size() - 1);
            value = doubleList.get(i);
            listToBeSorted.add(new Selection(selection.getX() + selection.getWidth() + (int) (width), (int) Math.ceil(Math.abs(value) * heightFactor), (int) (width), value));
        }
        return listToBeSorted;
    }
}
