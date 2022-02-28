class Solution {
    public String largestMultipleOfThree(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        Arrays.sort(arr);
        StringBuilder  sb = new StringBuilder();
        if(sum % 3 == 0){
            if(arr[n - 1] == 0){
                return "0";
            }else{
                for(int i = n - 1; i >= 0; i--){
                    sb.append(arr[i]);
                }
                return sb.toString();
            }
        }else if(sum % 3 == 1){
            boolean found = false;
            //int idx = -1;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] % 3 == 1){
                    found = true;
                    arr[i] = -1;
                    break;
                }
            }

            if(!found){
                // find 2 elements with remainder == 2
                int[] storeIdx = {-1, -1};
                for(int i = 0; i < n; i++){
                    if(arr[i] % 3 == 2){
                        if(storeIdx[0] == -1){
                            storeIdx[0] = i;
                        }else{
                            storeIdx[1] = i;
                            break;
                        }
                    }
                }
                if(storeIdx[1] != -1){
                    arr[storeIdx[0]] = -1;
                    arr[storeIdx[1]] = -1;
                }else{
                    return sb.toString();
                }
            }
        }else if(sum % 3 == 2){
            boolean found = false;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] % 3 == 2){
                    found = true;
                    arr[i] = -1;
                    break;
                }
            }
            if(!found){
                int[] store = {-1, -1};
                
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 3 == 1) {
                        if (store[0] == -1) {
                            store[0] = i;
                        } else {
                            store[1] = i;
                            break;
                        }
                    }
                }
                
                // now flag those 2 elements such that they are not included in ans
                if (store[1] != -1) {
                    arr[store[0]] = -1;
                    arr[store[1]] = -1;
                    
                } else {
                    return sb.toString();
                }
            }
        }
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] != -1){
                sb.append(arr[i]);
            }
        }
          if (sb.length() > 0 && sb.charAt(0) != -1 && sb.charAt(0) == '0') {
            StringBuilder ans = new StringBuilder();
            ans.append(0);
            return ans.toString();
        }
        
        return sb.toString();
    }
}
