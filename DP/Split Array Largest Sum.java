class Solution {
    public int splitArray(int[] nums, int m) {
        int start=-1,end=0;
        
        // taking range start(max. element from array) to end(sum of array)
        // because the answer can be between when m=1 and m=length of array
        //when m=1 answer would be the entire array sum
        // when m=length of array  answer would be the max. data from array  
        // therefore we get our search space and will use binary search
        
        for(int data:nums){
            if(data>start)start=data;
            end+=data; 
        } 
        
        
        while(start<end){
            
            int mid=start+(end-start)/2;
            int sum=0,subarraycount=1;
          // subarraycount is number of subarray. min. posible is 1
            
            for(int data:nums){
                //checking wheter we can add data to subarray or not
                // if not then making new array(i.e subarraycount++) and making sum=0
                // to check new subarray sum
                if(sum+data > mid){subarraycount++;sum=0;}
            
                if(sum+data <= mid){sum+=data;}
                
            }
            
            // if subarray count is less than m that means the mid is to large
            // if subarraycount is equal then this can be our answer 
            // But we need minimum sum with m subarray therefore moving left in searchspace
            // if subarraycount is greater than mid that means mid is very small and we have     to go to right to increase value of mid
            
            if(subarraycount<=m){
                end=mid; 
            }else{
                start=mid+1;
                
            }
            
            
            
        }
        
        
        
   // can return start or end because both will point to the answer     
        return start;
    }
}
