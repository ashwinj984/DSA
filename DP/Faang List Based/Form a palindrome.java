// https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1#

class Solution{
    static int countMin(String s1)
    {
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        String s2 = sb.toString();
        int ans = findLcs(s1, s2);
        return s1.length() - ans;
    }
    
    static int findLcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m + 1][n + 1];
        for(int i = 1; i < t.length; i++){
            for(int j = 1; j < t[i].length; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    t[i][j] = 1 + t[i - 1][j - 1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
    }
}
