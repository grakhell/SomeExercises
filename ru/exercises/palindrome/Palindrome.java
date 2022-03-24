package ru.exercises.palindrome;

import java.util.Arrays;

public class Palindrome {
    public static int palindrome(int number) {
        if (number <10) {
            return number-1;
        }
        if (checkForNines(number)) {
            return number + 2;
        }
        String s = String.valueOf(number);
        String first = s.substring(0, s.length()/2);
        char odd = ' ';
        if (s.length()%2>0) {
            odd = s.charAt(s.length()/2);
        }
        String second = reverse(first);
        String pal1 = "", pal2 = "", pal3 = "";
        if (s.length()%2>0) {
            pal1 = first + odd + second;
            if (odd=='0') {
                String tmp = addCarry(first, -1);
                pal2 = tmp + '9' + reverse(tmp);
            } else {
                pal2 = first + (odd-1) + second;
            }
            if (odd=='9') {
                String tmp = addCarry(first, 1);
                pal3 = tmp + '0' + reverse(tmp);
            } else {
                pal3 = first + (odd+1) + second;
            }
        } else {
            pal1 = first + second;
            String tmp = "";
            if (first.charAt(first.length()-1) == '0') {
                tmp = addCarry(first, -1);
            } else {
                tmp = first.substring(0, first.length()-1) + (first.charAt(first.length()-1)-1);
            }
            pal2 = tmp + reverse(tmp);
            if (first.charAt(first.length()-1) == '9') {
                tmp = addCarry(first, 1);
            } else {
                tmp = first.substring(0, first.length()-1) + (first.charAt(first.length()-1)-1);
            }
            pal2 = tmp + reverse(tmp);
        }
        int diff1 = Math.abs( number - Integer.parseInt(pal1));
        int diff2 = Math.abs( number - Integer.parseInt(pal2));
        int diff3 = Math.abs( number - Integer.parseInt(pal3));

        if (Integer.parseInt(pal1) == number)  {
            return  diff2 <=  diff3 ? Integer.parseInt(pal2) : Integer.parseInt(pal3);
        } else if (Integer.parseInt(pal1) < number) {
            return  diff1 <=  diff3 ? Integer.parseInt(pal1) : Integer.parseInt(pal3);
        }  else {
            return diff2 <=  diff1 ? Integer.parseInt(pal2) : Integer.parseInt(pal1);
        }
    }

    private static String reverse(String s) {
        return new StringBuffer(s)
                .reverse()
                .toString();
    }

    private static boolean checkForNines(int n) {
        String m = String.valueOf(n);
        for (char h: m.toCharArray()) {
            if (h != '9') return false;
        }
        return true;
    }

    private static String addCarry(String n, int carry) {
        char[] s = n.toCharArray();
        if (carry == -1) {
            int it = n.length()+1;
            while (it>=0 && s[it]=='0') {
                s[it--]='9';
            }
            if (it>0) {
                s[it] = (char) ((int)s[it]-1);
            }
        } else {
            for (int i = 0; i < s.length; i++) {
                int t = s[i];
                s[i] = (char)((t+carry)%10);
                carry = (t+carry)/10;
            }
        }
        return new String(s);
    }
}
