package ru.exercises.numerals;

public class Numerals {
    private static int getValue(char symbol)  {
        switch (symbol) {
            case 'I', 'i' -> {
                return 1;
            }
            case 'V', 'v' -> {
                return 5;
            }
            case 'X', 'x' -> {
                return 10;
            }
            case 'L', 'l' -> {
                return 50;
            }
            case 'C', 'c' -> {
                return 100;
            }
            case 'D', 'd' -> {
                return 500;
            }
            case 'M', 'm' -> {
                return 1000;
            }
            default -> {
                return -1;
            }
        }
    }

    public static int romanToInt(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int v = getValue(roman.charAt(i));
            if (i < roman.length()-1) {
                int vNext  =  getValue(roman.charAt(i+1));
                if (v >= vNext)
                {
                    result = result + v;
                }
                else
                {
                    int afterSub = vNext - v;
                    result = result + afterSub;
                    i = i + 1;
                }
            } else {
                result = result + v;
            }
        }
        return result;
    }
}
