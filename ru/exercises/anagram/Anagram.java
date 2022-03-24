package ru.exercises.anagram;

import java.util.Arrays;

public class Anagram {
    private static final int N = 256;
    public static boolean sortAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] t = a.toCharArray();
        char[] k = b.toCharArray();
        Arrays.sort(t);
        Arrays.sort(k);
        for (int i = 0; i < t.length; i++) {
            if (t[i] != k[i]) return false;
        }
        return true;
    }

    public static boolean hashAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] hash = new int[N];
        for (int i = 0; i < a.length() ; i++) {
            hash[a.charAt(i)] = hash[a.charAt(i)] + 1;
            hash[b.charAt(i)] = hash[b.charAt(i)] - 1;
        }
        for (int i = 0; i < N; i++) {
            if (hash[i] != 0)  return false;
        }
        return true;
    }
}
