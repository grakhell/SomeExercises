package ru.exercises.inversion;

import java.util.List;

public class Inversion {
    public static int inversionCount(List<Integer> lst) {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insertAll(lst);
        return tree.getInversionCount();
    }
}
