package finals02;

import java.util.Scanner;

public class Finals02 {
    
 public static void main (String[]args){
     
        Scanner scan = new Scanner(System.in);
        System.out.println("input string: ");
        String input = scan.next();

        System.out.println("encode1 output: ");
        System.out.println(encode1(input));
        
        System.out.println("encode2 ouutput: ");
        System.out.println(encode2(input));      
        System.out.println("Equality: " + encode2(input).equals(encode1(input)));
    }
  public static String encode1(String s){
        String encoding = "";
        int i = 0;
        
        while (i < s.length()){
            int count = 1;
            
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                count++;
                i++;
            }
            encoding = encoding + count + s.charAt(i);
            i++;
        }
        return encoding;
    }
    
    public static String encode2(String s){
        
        String encoding = "";
        int i = 0;
        int count = 0;
        char current = s.charAt(i);
        
        while (i <= s.length()){
            
            if (i == s.length()){
                encoding = encoding + count + current;
            }
            else if (current != s.charAt(i) && i==1){
                encoding = encoding + count + current;
                current = s.charAt(i);
                count = 1;
            }
            else if(current != s.charAt(i)){
                encoding = encoding + (count) + current;
                current = s.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
            
            i++;
        }
        
        return encoding;
    }
}