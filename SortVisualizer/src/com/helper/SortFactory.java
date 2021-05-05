package com.helper;

import com.bubble.Bubble;
import com.bubble.BubbleInitializer;
import com.bubble.BubbleSorter;
import com.insert.Insert;
import com.insert.InsertInitializer;
import com.insert.InsertSorter;
import com.merge.Merge;
import com.merge.MergeInitializer;
import com.merge.MergeSorter;
import com.quick.Quick;
import com.quick.QuickInitializer;
import com.quick.QuickSorter;
import com.selection.Selection;
import com.selection.SelectionInitializer;
import com.selection.SelectionSorter;
import com.window.Panel;

import java.util.Map;

public class SortFactory {
    private final Map<String, SortHelpers> sortHelpersMap;
    private final Panel panel;

    public SortFactory(Map<String, SortHelpers> sortHelpersMap, Panel panel) {
        this.sortHelpersMap = sortHelpersMap;
        this.panel = panel;
        initialiseMap();
    }

    private void initialiseMap() {
        BubbleInitializer bubbleInitializer = new BubbleInitializer();
        BubbleSorter bubbleSorter = new BubbleSorter(panel);
        SortHelpers<Bubble> bubbleSortHelpers = new SortHelpers<>(bubbleSorter, bubbleInitializer);
        sortHelpersMap.put("Bubble", bubbleSortHelpers);

        InsertInitializer insertInitializer = new InsertInitializer();
        InsertSorter insertSorter = new InsertSorter(panel);
        SortHelpers<Insert> insertSortHelpers = new SortHelpers<>(insertSorter, insertInitializer);
        sortHelpersMap.put("Insert", insertSortHelpers);

        MergeInitializer mergeInitializer = new MergeInitializer();
        MergeSorter mergeSorter = new MergeSorter(panel);
        SortHelpers<Merge> mergeSortHelpers = new SortHelpers<>(mergeSorter, mergeInitializer);
        sortHelpersMap.put("Merge", mergeSortHelpers);

        QuickInitializer quickQuickInitializer = new QuickInitializer();
        QuickSorter quickSorter = new QuickSorter(panel);
        SortHelpers<Quick> quickSortHelpers = new SortHelpers<>(quickSorter, quickQuickInitializer);
        sortHelpersMap.put("Quick", quickSortHelpers);

        SelectionInitializer selectionInitializer = new SelectionInitializer();
        SelectionSorter selectionSorter = new SelectionSorter(panel);
        SortHelpers<Selection> selectionSortHelpers = new SortHelpers<>(selectionSorter, selectionInitializer);
        sortHelpersMap.put("Selection", selectionSortHelpers);


    }

    public SortHelpers getSortHelpers(String sortPattern) {
        return sortHelpersMap.get(sortPattern);
    }

}
