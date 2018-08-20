package com.codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> wordsToFind = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            wordsToFind.add(in.next());
        }

        int h = in.nextInt();
        int w = in.nextInt();

        char[][] linesChar = new char[h][w];
        char[][] linesCharLine = new char[h][w];
        char[][] linesCharColumn = new char[h][w];
        char[][] linesCharDiagToRight = new char[h][w];
        char[][] linesCharDiagToLeft = new char[h][w];

        for (int i = 0; i < h; i++) {
            String line = in.next();
            for(int j = 0 ; j < line.length(); j++){
                linesChar[i][j] = line.charAt(j);
                linesCharLine[i][j] = line.charAt(j);
                linesCharColumn[i][j] = line.charAt(j);
                linesCharDiagToRight[i][j] = line.charAt(j);
                linesCharDiagToLeft[i][j] = line.charAt(j);
            }

            lookForWord(linesCharLine,wordsToFind,line,i,-1,-1,-1,-1);
        }


        for(int j = 0; j < w; j++) {
            String verticalS = "";
            for (int i = 0; i < h; i++) {
                verticalS += String.valueOf(linesChar[i][j]);
            }

            lookForWord(linesCharColumn,wordsToFind,verticalS,-1,j,-1,-1,-1);
        }

        for(int i =0, j = 1; i < h-1 && j < w;) {
            String diag = linesCharDiagToLeft[i][j] + "";

            int x,y;

            x = i + 1;
            y = j - 1;

            while (y >= 0 && x < h){
                diag += linesCharDiagToLeft[x][y];
                x++;
                y--;
            }

            lookForWord(linesCharDiagToLeft, wordsToFind, diag, -1, -1, i,j, 0);

            if(j < w - 1) {
                j++;
            } else if(j == w - 1) {
                i++;
            }
        }

        for(int i =h-1, j = 1; i > 0 && j < w;) {
            String diag = linesCharDiagToRight[i][j] + "";

            int x,y;

            x = i - 1;
            y = j - 1;

            while (y >= 0 && x >=0 ){
                diag += linesCharDiagToRight[x][y];
                x--;
                y--;
            }

            lookForWord(linesCharDiagToRight, wordsToFind, diag, -1, -1, i,j, 1);

            if(j < w - 1) {
                j++;
            } else if(j == w - 1) {
                i--;
            }
        }

        for (int i = 0; i < h; i++) {
            for(int j = 0 ; j < w; j++){
                if(linesCharLine[i][j] != '*' && linesCharColumn[i][j] != '*' && linesCharDiagToRight[i][j] != '*' && linesCharDiagToLeft[i][j] != '*') {
                    System.out.print(linesChar[i][j]);
                }
            }
        }
    }

    public static void lookForWord(char[][] map, List<String> wordsToFind, String txtTolookInIt, int heightFixed, int widthFixed, int diagPositionX, int diagPositionY, int diagDirection){

        String txtInversedTolookInIt = new StringBuilder(txtTolookInIt).reverse().toString();
        for(String s : wordsToFind){
            String newString = "";
            if(txtTolookInIt.contains(s)) {
                newString = txtTolookInIt.replace(s, new String(new char[s.length()]).replace('\0', '*'));
            }
            if(txtInversedTolookInIt.contains(s)){
                newString = txtInversedTolookInIt.replace(s, new String(new char[s.length()]).replace('\0', '*'));
                newString = new StringBuilder(newString).reverse().toString();
            }

            if(diagPositionX < 0 && diagPositionY < 0) {
                for (int l = 0; l < newString.length(); l++) {
                    if (heightFixed != -1) {
                        if(map[heightFixed][l] != '*')
                            map[heightFixed][l] = newString.charAt(l);
                    } else {
                        if(map[l][widthFixed] != '*')
                            map[l][widthFixed] = newString.charAt(l);
                    }
                }
            } else {
                int x = diagPositionX;
                int y = diagPositionY;
                if(diagDirection == 0){
                    for (int l = 0; l < newString.length(); l++) {
                        if(map[x][y] != '*')
                            map[x][y] = newString.charAt(l);
                        x++;
                        y--;
                    }
                } else {
                    for (int l = 0; l < newString.length(); l++) {
                        if(map[x][y] != '*')
                            map[x][y] = newString.charAt(l);
                        x--;
                        y--;
                    }
                }
            }
        }
    }

}
