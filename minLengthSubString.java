import java.util.*;
public class minLengthSubString {
    public static void main(String[] args) {
         String s = "ABFCACDB";
        System.out.println(minLength(s));
    }
    public static int minLength(String s) {
       StringBuilder sb = new StringBuilder();
       for(char currChar:s.toCharArray()){
           int len = sb.length();
           if(len >0 &&
                   ((sb.charAt(len-1)=='A' && currChar=='B')||
                   (sb.charAt(len-1) == 'C' && currChar == 'D'))){
               sb.deleteCharAt(len-1);
           }else{
               sb.append(currChar);
           }
       }
       return sb.length();
    }
}
