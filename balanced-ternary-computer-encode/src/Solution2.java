import java.util.Scanner;

public class Solution2 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int DEC = in.nextInt();

        boolean isNegative = (DEC < 0);
        int resultDiv = Math.abs(DEC);
        String ternary = "";

        do{
            int modulo = resultDiv % 3;
            resultDiv = resultDiv/3;
            if(modulo == 2){
                ternary = (isNegative ? "1" : "T")  + ternary;
                resultDiv++;
            } else if(modulo == 1){
                ternary = (isNegative ? "T" : "1") + ternary;
            } else {
                ternary = "0" + ternary;
            }
        }while(resultDiv != 0);

        System.out.println(ternary);
    }
}
