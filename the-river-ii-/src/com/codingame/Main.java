package com.codingame;

import java.util.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        int river = r1 - 1;
        while(river > 0) {

            int sum = river + getSum(river);
            if(sum != r1 ){
                river--;
            } else {
                System.out.println("YES");return;
            }
        }

        System.out.println("NO");

    }

    public static int getSum(int number){
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}