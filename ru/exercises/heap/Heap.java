package ru.exercises.heap;

import java.util.Collections;
import java.util.List;

public class Heap {
    public static void convertHeap(List<Integer> lst) {
        for (int i = (lst.size()-2)/2; i >= 0 ; i--) {
            heapify(lst, i);
        }
    }

    private static void heapify(List<Integer> l, Integer i) {
        int left = 2 * i +1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < l.size() && l.get(left) > l.get(i))
        largest = left;
        if (right < l.size() && l.get(right) > l.get(largest))
        largest = right;
        if (largest != i)
        {
            Collections.swap(l, i , largest);
            heapify(l, largest);
        }
    }
}
