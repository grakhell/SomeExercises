package ru.exercises.trapping;

import java.util.List;

public class Trapping {
    public static int maxWaterTrapped(List<Integer> heighs) {
        int lo = 0, hi = heighs.size() - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (lo < hi) {
            if (heighs.get(lo) > leftMax)
                leftMax = heighs.get(lo);
            if (heighs.get(hi) > rightMax)
                rightMax = heighs.get(hi);
            if (leftMax < rightMax) {
                water += (leftMax - heighs.get(lo));
                lo = lo + 1;
            } else {
                water += (rightMax - heighs.get(hi));
                hi = hi - 1;
            }
        }
        return water;
    }
}
