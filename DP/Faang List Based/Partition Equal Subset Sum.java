// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if(sum % 2 != 0){
            return 0;
        }
        
        return subsetSum(arr, sum /  2) == false ? 0 : 1;
    }
    
    public static boolean subsetSum(int[] arr, int wt){
        boolean[][] t = new boolean[arr.length + 1][wt + 1];
        for(int i = 0; i < t.length; i++){
            t[i][0] = true;
        }
        
        for(int i = 1; i < t.length; i++){
            for(int j = 1; j < t[i].length; j++){
                if(arr[i - 1] <= j){
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[arr.length][wt];
    }
}
