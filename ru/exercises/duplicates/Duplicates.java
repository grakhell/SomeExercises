package ru.exercises.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public static List<Integer> removeDuplicates(List<Integer> lst) {
        if (lst.size() <=1) {
            return lst;
        }
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < lst.size()-1 ; i++) {
            if (lst.get(i) != lst.get(i + 1)) {
                r.add(lst.get(i));
            }
        }
        r.add(lst.get(lst.size()-1));
        return r;
    }
}
