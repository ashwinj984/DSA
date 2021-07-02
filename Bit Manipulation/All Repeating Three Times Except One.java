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
      // main logic
    int threeN = Integer.MAX_VALUE;
    int threeNp1 = 0;
    int threeNp2 = 0;
    for(int i = 0; i < arr.length; i++){
        int cwtn = arr[i] & threeN;
        int cwtnp1 = arr[i] & threeNp1;
        int cwtnp2 = arr[i] & threeNp2;
        
        threeN = threeN & (~cwtn);
        threeNp1 |= (cwtn);
        
        threeNp1 &= (~cwtnp1);
        threeNp2 |= (cwtnp1);
        
        threeNp2 &= (~cwtnp2);
        threeN |= (cwtnp2);
    }
   
    System.out.println(threeNp1);
   
  }

}
