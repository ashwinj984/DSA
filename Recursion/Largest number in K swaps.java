class Solution
{
    static String max;
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            max = str;
            findMaximum(str.toCharArray(), k);
            return max;
        }
        
    public static void findMaximum(char[] ch, int k){
        if(k == 0){
            return;
        }
        
        for(int i = 0; i < ch.length - 1; i++){
            for(int j = i + 1; j < ch.length; j++){
                if(ch[j] > ch[i]){
                    ch = swap(ch, i, j);
                    String str = new String(ch);
                    if(max.compareTo(str) < 0){
                        max = str;
                    }
                    findMaximum(ch, k - 1);
                    ch = swap(ch, i, j);
                }
            }
        }
    }
    
    public static char[] swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }
}
