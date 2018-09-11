package fr.loic.codinggame.the.river.i;

import java.util.Scanner;

/**
 * Created by Loic on 31/07/2018.
 */
public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        Long un1 = r1;
        Long un2 = r2;

        while(!un1.equals(un2)) {
            long l;
            if(un1 < un2) {
                un1 = incrementBy(un1);
            } else {
                un2 = incrementBy(un2);
            }
        }

        System.out.println(un1);
    }

    public static Long incrementBy(Long un){
        String s = un.toString();
        for (int i = 0; i < s.length(); i++) {
            String l = s.charAt(i) + "";
            un += Long.parseLong(l);
        }
        return un;
    }
}