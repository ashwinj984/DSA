// https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1#

class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
      
       return lcs(A, B, C, n1, n2, n3);
       
    }
    
    public int lcs(String s1, String s2, String s3, int m, int n, int o){
        int[][][] t = new int[m + 1][n + 1][o + 1];
        for(int i = 1; i  < t.length; i++){
            for(int j = 1; j < t[i].length; j++){
                for(int k = 1; k < t[i][j].length; k++){
                    if(s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)){
                        t[i][j][k] = 1 + t[i - 1][j - 1][k - 1];
                    }else{
                        t[i][j][k] = Math.max(t[i - 1][j][k], Math.max(t[i][j - 1][k], t[i][j][k - 1]));
                    }
                }
            }
        }
        return t[m][n][o];
    }
} 
