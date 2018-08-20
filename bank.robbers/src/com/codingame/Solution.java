package com.codingame;

import java.util.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {
    private static Queue<Vault> queue = new LinkedList<>();
    private static List<Rober> robbers = new ArrayList<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbrRobbers = in.nextInt();
        int nbrVaults = in.nextInt();

        for (int j = 0; j < nbrRobbers; j++) {
            robbers.add(new Rober());
        }

        for (int i = 0; i < nbrVaults; i++) {
            int nbrCharacters = in.nextInt();
            int nbrDigits = in.nextInt();

            Vault vault = new Vault(nbrCharacters, nbrDigits);
            robbers.get(0).addVault(vault);
            robbers.sort(Comparator.comparingInt(Rober::timeOfWork));
        }

        System.out.println(robbers.get(robbers.size()-1).timeOfWork());

    }

    static class Rober{

        private List<Vault> vaults;

        public Rober(){
            this.vaults = new ArrayList<>();
        }

        public void addVault(Vault vault){
            vaults.add(vault);
        }

        public int timeOfWork() {
            int sum = 0;
            for(Vault v : vaults) {
                sum += v.getNbrCombinations();
            }
            return sum;
        }
    }

    static class Vault {
        private int nbrCombinations;

        public Vault(int nbrCharacters, int nbrDigits){
            this.nbrCombinations = (int) (Math.pow(10, nbrDigits) * Math.pow(5, nbrCharacters - nbrDigits));
        }

        public Vault(int nbrCombinations){
            this.nbrCombinations = nbrCombinations;
        }

        public int getNbrCombinations() {
            return nbrCombinations;
        }
    }
}