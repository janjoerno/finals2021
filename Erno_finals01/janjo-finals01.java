
package tla10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TLA10{

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Input string: ");
        String givenStr = scan.nextLine(); 
        
        System.out.print("Input first name: ");  
        String fname = scan.next();

        System.out.println("First Name: " + fname);
             
        if(fname.length() > givenStr.length()){
            String newStr = givenStr.repeat(givenStr.length()).substring(0, fname.length());       
            givenStr = newStr;
        }    
        String result_TestCase = StringToBinaryOperation(givenStr);  
        if(givenStr.length() > fname.length()){
            String newStrFN = fname.repeat(fname.length()).substring(0, givenStr.length());
            fname = newStrFN;
        }  
        String output = StringToBinaryOperation(fname);     
        String printFname = printBinary(output, 8, " ");
        String printString = printBinary(result_TestCase, 8, " ");
        
        System.out.println();
        System.out.println("First Name 8-bit Binary: \n" + printFname);
        System.out.println("String 8-bit Binary: \n" + printString);
       
        int length = output.length();
        
        String result_XOR = XORoperation(output, result_TestCase, length);
        System.out.println("\nXOR Result: \n" + printBinary(result_XOR, 8, " "));
    
        System.out.println("\nFinal Output: ");
        System.out.println(setGivenString(result_XOR));   
             
    }
     public static String StringToBinaryOperation(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0")                             
            );
        }
        return result.toString();
    }
    public static String printBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }
        return result.stream().collect(Collectors.joining(separator));
    }

    private static String XORoperation(String a, String b, int n){
    String ans = "";
        for (int i = 0; i < n; i++){

            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    } 
    private static int BinaryToDecimal(String n) {
        String num = n;
        int dec_value = 0;
        int base = 1;
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {

            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }
        return dec_value;
    }
    private static String setGivenString(String str) {
        int N = (str.length());
        if (N % 8 != 0) {
            return "Cannot Perform Program";
        }
        String res = "";
        for (int i = 0; i < N; i += 8) {
            int decimal_value
                = BinaryToDecimal((str.substring(i, 8+i)));
            res += (char)(decimal_value);
        }
        return res;
    }
}