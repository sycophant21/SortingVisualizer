package com.merge;

import com.helper.SortInitializer;
import com.helper.Utility;
import com.quick.Quick;

import java.util.ArrayList;
import java.util.List;

public class MergeInitializer implements SortInitializer<Merge> {
    @Override
    public List<Merge> initializeSort(List<Double> doubleList) {
        List<Merge> listToBeSorted = new ArrayList<>();
        int length = doubleList.size();
        double max = Utility.getMaximum(doubleList);
        double heightFactor = 355 / (max + 10);
        double width = 1440.0 / ((2.0 * length) + 1.0);
        double value = doubleList.get(0);
        listToBeSorted.add(new Merge((int) width, (int) Math.floor(Math.abs(value) * heightFactor), (int) Math.floor(width), value));
        for (int i = 1; i < length; i++) {
            Merge merge = listToBeSorted.get(listToBeSorted.size() - 1);
            value = doubleList.get(i);
            listToBeSorted.add(new Merge(merge.getX() + merge.getWidth() + (int) width, (int) Math.ceil(Math.abs(value) * heightFactor), (int) Math.floor(width), value));
        }
        return listToBeSorted;
    }
}
