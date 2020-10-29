import java.io.*;
import java.util.*;

public class Main {
    //static int count;
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];
      
      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      int count = 0;
     boolean[][] visited = new boolean[m][n];
      for(int i = 0; i < arr.length; i++){
          for(int j = 0; j < arr[i].length; j++){
              if(visited[i][j] == false && arr[i][j] == 0){
                  drawTree(arr,i,j,visited);
                  count++;
              }
          }
      }
       System.out.println(count);
   }
  
   
   
   public static void drawTree(int[][] arr,int i,int j,boolean[][] visited){
       if(i < 0 || j < 0 || i>= arr.length||j>=arr.length||visited[i][j] == true||arr[i][j] == 1){
                        return ;
                    }
       
       visited[i][j] = true;
       drawTree(arr,i-1,j,visited);
       drawTree(arr,i,j-1,visited);
       drawTree(arr,i+1,j,visited);
       drawTree(arr,i,j+1,visited);
   }

}
