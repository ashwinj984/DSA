class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        if(n == 1){
            return arr[0];
        }
        long max_so_far = 0;
        long max_till_here = 1;
        long min_till_here = 1;
        int flag = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                max_till_here = max_till_here * arr[i];
                min_till_here = Math.min(min_till_here * arr[i], 1);
                flag = 1;
            }else if(arr[i] == 0){
                max_till_here = 1;
                min_till_here = 1;
            }else{
                long temp = max_till_here;
                max_till_here = Math.max(min_till_here * arr[i], 1);
                min_till_here = temp * arr[i];
            }
            if(max_so_far  < max_till_here){
                max_so_far = max_till_here;
            }
        }
        
        if(flag == 0 && max_so_far == 0){
            return 0;
        }
        return max_so_far;
    }
}
