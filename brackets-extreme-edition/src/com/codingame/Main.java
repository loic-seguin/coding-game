package com.codingame;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private final static String openers = "{[(";
    private final static String closers = "}])";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String expression = in.next();

        Stack<Character> openersStack = new Stack<>();

        for(int i = 0 ; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(openers.indexOf(c) >= 0){
                openersStack.push(c);
            } else if(closers.indexOf(c) >= 0){
                if(!openersStack.isEmpty()) {
                    Character opener = openersStack.peek();
                    if (openers.indexOf(opener) != closers.indexOf(c)) {
                        System.out.println("false");return;
                    } else {
                        openersStack.pop();
                    }
                } else {
                    System.out.println("false");return;
                }
            }
        }

        System.out.println(openersStack.isEmpty());

    }
}
