package fr.loic.codinggame.gravity.tumbler;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        int count = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        List<String> lines = new ArrayList<>();

        char dot = '.';
        for (int i = 0; i < height; i++) {
            String raster = in.nextLine();
            int nbrDots = 0;
            for(int j = 0; j < raster.length(); j++){
                char c = raster.charAt(j);
                if(c == dot){
                    nbrDots++;
                }
            }

            if(nbrDots < width && nbrDots > 0) {
                raster = new String(new char[width]).replace('\0', '.');
                raster = raster.substring(0, nbrDots) + raster.substring(nbrDots).replace('.', '#');
            }

            if(count % 2 == 0){
                lines.add(raster);
            } else {
                for (int g = 0; g < raster.length(); g++) {
                    char c = raster.charAt(g);
                    if (lines.size() > g) {
                        lines.set(g, lines.get(g) + c);
                    } else {
                        lines.add(c + "");
                    }
                }
            }
        }

        lines.forEach(System.out::println);
    }
}
