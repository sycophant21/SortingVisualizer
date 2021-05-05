package com.helper;

import java.util.List;

public interface Sorter<T extends SortObject> {

    void sort(List<T> tempList) throws InterruptedException;
}
