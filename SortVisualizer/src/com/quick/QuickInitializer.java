package com.quick;

import com.helper.SortInitializer;
import com.helper.Utility;

import java.util.ArrayList;
import java.util.List;

public class QuickInitializer implements SortInitializer<Quick> {

    public List<Quick> initializeSort(List<Double> doubleList) {
        List<Quick> listToBeSorted = new ArrayList<>();
        int length = doubleList.size();
        double max = Utility.getMaximum(doubleList);
        double heightFactor = 765 / (max + 10);
        double width = 1440.0 / ((2.0 * length) + 1.0);
        double value = doubleList.get(0);
        listToBeSorted.add(new Quick((int) width, (int) Math.floor(Math.abs(value) * heightFactor), (int) Math.floor(width), value));
        for (int i = 1; i < length; i++) {
            Quick quick = listToBeSorted.get(listToBeSorted.size() - 1);
            value = doubleList.get(i);
            listToBeSorted.add(new Quick(quick.getX() + quick.getWidth() + (int) width, (int) Math.ceil(Math.abs(value) * heightFactor), (int) Math.floor(width), value));
        }
        return listToBeSorted;
    }
}
