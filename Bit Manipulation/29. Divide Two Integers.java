// https://leetcode.com/problems/divide-two-integers/
// Reference
// https://leetcode.com/problems/divide-two-integers/discuss/13407/C%2B%2B-bit-manipulations

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int ans = 0;
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        while(dvd >= dvs){
            long temp = dvs;
            long m = 1;
            while(temp << 1 < dvd){
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            ans += m;
        }
        return sign * ans;
    } 
}
