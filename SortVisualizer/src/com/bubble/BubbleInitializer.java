package com.bubble;

import com.helper.SortInitializer;

import java.util.ArrayList;
import java.util.List;

public class BubbleInitializer implements SortInitializer<Bubble> {
    public List<Bubble> initializeSort(List<Double> integers) {
        List<Bubble> listToBeSorted = new ArrayList<>();
        int length = integers.size();
        double sum = 0;
        for (double next : integers) {
            sum += Math.abs(next);
        }
        double radiusFactor = 1440 / sum;
        double value = integers.get(0);
        listToBeSorted.add(new Bubble(Math.abs(radiusFactor * value), value, 0, (int) (355 - (Math.abs(radiusFactor * value) / 2))));
        for (int i = 1 ; i < length ; i++) {
            Bubble last = (Bubble) listToBeSorted.get(listToBeSorted.size() - 1);
            value = integers.get(i);
            listToBeSorted.add(new Bubble(radiusFactor * Math.abs(value), value, (int) Math.ceil(last.getX() + last.getRadius()), (int) (355 - (Math.abs(radiusFactor * value) / 2))));
        }
        return listToBeSorted;
    }
}
