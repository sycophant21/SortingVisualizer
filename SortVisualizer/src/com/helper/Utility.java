package com.helper;

import java.util.List;

public class Utility {

    public static double getMaximum(List<Double> list) {
        double max = Double.NEGATIVE_INFINITY;
        for (Double d : list) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    public static double getMinimum(List<Double> list) {
        double min = Double.POSITIVE_INFINITY;
        for (Double d : list) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public static int getIndexOfMinimumElement(List<Double> list) {
        return getIndexOfMinimumElementBetweenBounds(list, 0 , list.size() - 1);
    }

    public static int getIndexOfMinimumElementBetweenBounds(List<Double> list, int lowerBound, int higherBound) {
        double min = Double.POSITIVE_INFINITY;
        int counter = lowerBound - 1;
        for (int i = lowerBound ; i <= higherBound ; i++) {
            Double d = list.get(i);
            if (d < min) {
                min = d;
                counter = i;
            }
        }
        return counter;
    }

}
