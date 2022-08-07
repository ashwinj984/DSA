import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> ans = new ArrayList<>();
    int[] par = new int[m * n];
    int[] rank = new int[m * n];
    int count = 0;
    int[][] dir = {
        {-1,0},{1,0},{0,-1},{0,1}
    };
    Arrays.fill(par, -1);
    for(int i = 0; i < positions.length; i++){
        int row = positions[i][0];
        int col = positions[i][1];
        
        int cellNo = row * n + col;
        if(par[cellNo]  != -1){
            ans.add(count);
            continue;
        }
        par[cellNo] = cellNo;
        rank[cellNo] = 1;
        count++;
        
        for(int[] d : dir){
            int rowdash = row + d[0];
            int coldash = col + d[1];
            int cellNodash = rowdash * n + coldash;
            if(rowdash < 0 || coldash < 0 || rowdash >= n || coldash >= m || par[cellNodash] == -1){
                continue;
            }
            
            int lx = find(cellNo,par);
            int ly = find(cellNodash, par);
            if(lx != ly){
                if(rank[lx] > rank[ly]){
                    par[ly] = lx;
                }else if(rank[lx] < rank[ly]){
                    par[lx] = ly;
                }else{
                    par[lx] = ly;
                    rank[ly]++;
                }
                count--;
            }
        }
        ans.add(count);
    }
    return ans;
  }
  public static int find(int x, int[] parent){
      if(parent[x] == x){
          return x;
      }else{
          int temp = find(parent[x], parent);
          parent[x] = temp;
          return temp;
      }
  } 
}
