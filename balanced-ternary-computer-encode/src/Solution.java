import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    private static int BASE = 3;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int decimal = in.nextInt();
        if(decimal == 0){ System.out.println("0");return;}
        String ternary;
        double puissanceMax = Math.log(Math.abs(decimal))/Math.log(BASE);
        int puissanceInt;
        if ((puissanceMax == Math.floor(puissanceMax)) && !Double.isInfinite(puissanceMax)) {
            ternary = new String(new char[(int) puissanceMax + 1]).replace('\0', '0');
            ternary = ternary.replaceFirst("0", "1");
        } else {
            int sum = getSum((int) puissanceMax);
            if(sum < Math.abs(decimal)){
                puissanceInt = (int) puissanceMax + 1 ;
            } else {
                puissanceInt = (int) puissanceMax;
            }

            int count = (int) Math.pow(BASE, puissanceInt);
            boolean isNegative = (decimal < 0);

            if(decimal < 0 ) {
                ternary = "T";
            } else {
                ternary = "1";
            }

            int diff = Math.abs(Math.abs(decimal) - Math.abs(count));
            for (int i = puissanceInt - 1; i >= 0; i--) {
                if(diff < 0){
                    if(i > 0) {
                        int nextSum = getSum(i-1);
                        int nextDiffIfT =  decimal - (count - (int) Math.pow(BASE, i));
                        if(Math.abs(nextDiffIfT) <= nextSum) {
                            ternary += "T";
                            diff = nextDiffIfT;
                            count -= Math.pow(BASE, i);
                        } else {
                            ternary += "0";
                        }
                    } else {
                        ternary += "T";
                    }

                } else if (diff > 0){
                    if(i > 0) {
                        int nextSum = getSum(i-1);
                        int nextDiffIf1 = decimal - (count + (int) Math.pow(BASE, i));
                        if(Math.abs(nextDiffIf1) <= nextSum) {
                            ternary += "1";
                            diff = nextDiffIf1;
                            count += Math.pow(BASE, i);
                        } else {
                            ternary += "0";
                        }
                    } else {
                        ternary += "1";
                    }
                } else {
                    ternary += new String(new char[i+1]).replace('\0', '0');
                    break;
                }
            }
        }

        System.out.println(ternary);
    }

    public static int getSum(int pow) {
        int sum = 0;
        for(int i = pow ; i >= 0 ; i--){
            sum += Math.pow(BASE, i);
        }
        return sum;
    }
}