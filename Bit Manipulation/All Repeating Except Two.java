import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
  // finding xor of all number so at last we will get only the xor of two numbers we have too find
  // once we found the xor take in right most set bit mask and add it with all values 
  // there will be two cases for 1 and 0
  // take different for 1 and for 0 and last x and y will be ans
   int xxory = 0;
   for(int i = 0; i < arr.length; i++){
       xxory = xxory ^ arr[i];
   }
   // right most set bit (1) mask
   int rmsbm = xxory & ~(xxory - 1);
   int x = 0;
   int y = 0;
   for(int val : arr){
       if((val & rmsbm) == 0){
           x = x ^ val;
       }else{
           y = y ^  val;
       }
   }
   
   if(x < y){
       System.out.println(x + "\n" + y);
   }else{
       System.out.println(y + "\n" + x);
   }
   
   
  }

}
