package ru.exercises.prefix;

public class Prefix {
    public static String LongestCommonPrefix(String[] strings) {
        if (strings.length == 0)
            return "-1";
        for (int i = 0; i < strings[0].length(); i++) {
            char c = strings[0].charAt(i);
            for (int j = 0; j < strings.length; j++) {
                if (i == strings[j].length() || strings[j].charAt(i) != c)
                return strings[0].substring(0, i);
            }
        }
        return strings[0];
    }
}
