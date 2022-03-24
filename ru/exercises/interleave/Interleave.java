package ru.exercises.interleave;

public class Interleave {
    public static boolean isInterleave(String first, String second, String third) {
        if (third.length() != first.length() +  second.length()) return false;

        boolean DT[][] = new boolean[first.length()+1][second.length()+1];
        for (int i = 0; i <  first.length()+1 ; i++) {
            for (int j = 0; j < second.length()+1; j++) {
                if (i==0 && j==0) DT[i][j] = true;
                else if (i==0)  {
                    DT[i][j] = ( DT[i][j-1] && second.charAt(j-1) == third.charAt(i+j-1));
                } else if (j==0) {
                    DT[i][j] = ( DT[i-1][j] && first.charAt(i-1) == third.charAt(i+j-1));
                } else {
                    DT[i][j] = (DT[i-1][j] && first.charAt(i-1) == third.charAt(i+j-1)) ||
                            (DT[i][j-1] && second.charAt(j-1) == third.charAt(i+j-1));
                }
            }
        }
        return DT[first.length()][second.length()];
    }
}
