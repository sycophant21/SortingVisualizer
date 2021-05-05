package com.helper;

import java.util.Objects;

public class SortHelpers<T extends SortObject> {
    private final Sorter<T> sorter;
    private final SortInitializer<T> sortInitializer;

    public SortHelpers(Sorter<T> sorter, SortInitializer<T> sortInitializer) {
        this.sorter = sorter;
        this.sortInitializer = sortInitializer;
    }

    public Sorter<T> getSorter() {
        return sorter;
    }

    public SortInitializer<T> getSortInitializer() {
        return sortInitializer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SortHelpers)) return false;
        SortHelpers<T> that = (SortHelpers<T>) o;
        return getSorter().equals(that.getSorter()) && getSortInitializer().equals(that.getSortInitializer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSorter(), getSortInitializer());
    }
}
