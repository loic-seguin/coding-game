package com.codingame;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < n; i++) {
            line.append(in.nextLine()).append("\n");
        }

        final Pattern pattern = Pattern.compile("(\\(.*?\\))", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(line);
        int indexChoice = 0;
        StringBuffer sb = new StringBuffer();

        while(matcher.find()){
            String choicesString = matcher.group(1);
            String[] choices = choicesString.substring(1,choicesString.length()-1).split("\\|",-1);
            String choiceDone = choices[indexChoice % choices.length];
            matcher.appendReplacement(sb, matcher.group(0).replaceFirst(Pattern.quote(choicesString), choiceDone));
            indexChoice++;
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());

    }
    }
