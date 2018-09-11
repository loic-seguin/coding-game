package fr.loic.codinggame.balanced.ternary.computer.encode;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    private static int BASE = 3;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int decimal = in.nextInt();

        String ternary = "";
        double puissanceMax = Math.log(decimal)/Math.log(BASE);
        int puissanceInt = (int) puissanceMax;
        if ((puissanceMax == Math.floor(puissanceMax)) && !Double.isInfinite(puissanceMax)) {
            ternary = new String(new char[puissanceInt + 1]).replace('\0', '0');
            ternary = ternary.replaceFirst("0", "1");
        } else {
            int sum = (int) Math.pow(BASE, puissanceInt);
            if(Math.abs(decimal - sum) > getMax(puissanceInt - 1)){
                puissanceInt += 1;
            }

            ternary +="1";

            for (int i = puissanceInt - 1; i >= 0; i--) {
                int digit = (int) Math.pow(BASE, i);

                if(sum > decimal){
                    ternary += "T";
                    sum -= digit;
                } else if (sum < decimal){
                    ternary += "1";
                    sum += digit;
                } else {
                    ternary += new String(new char[i+1]).replace('\0', '0');
                }
            }
        }

        System.out.println(ternary);
    }

    public static int getMax(int pow){
        int sum = 0;
        for(int i = pow; i >= 0; i--){
            sum += Math.pow(BASE, i);
        }
        return sum;
    }
}
