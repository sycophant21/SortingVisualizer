package com.helper;

import java.util.List;

public interface SortInitializer<T extends SortObject> {

    List<T> initializeSort(List<Double> tempList);
}
