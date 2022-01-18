class Solution
{
    public int gcd(int n, int m){
        if(m == 0){
            return n;
        }
        return gcd(m, n % m);
    }
    public int  minSteps(int m, int n, int d)
    {
      if(m > n){
          int temp = m;
          m = n;
          n = temp;
      }
      if(d > n){
          return -1;
      }
      if(d % gcd(m, n) != 0){
          return -1;
      }
      return Math.min(pour(n, m, d), pour(m, n, d));
    }
    
    public static int pour(int fromCap, int toCap, int d){
        int from = fromCap;
        int to = 0;
        int step = 1;
        while(from != d && to != d){
            int temp = Math.min(from, toCap - to);
            to +=  temp;
            from -= temp;
            step++;
            if(to == d || from == d){
                break;
            }
            if(to == toCap){
                to = 0;
                step++;
            }
            if(from == 0){
                from = fromCap;
                step++;
            }
        }
        
        return step;
        
    }
}
