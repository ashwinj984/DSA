import java.util.*;

public class Main {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) {
        // Write your code here
        int sum = 0;
        int jumpCount = 0;
        while(sum < x){
            jumpCount++;
            sum += jumpCount;
        }
        
        if((sum - x) % 2 == 0){
            return jumpCount;
        }else{
            jumpCount++;
            sum += jumpCount;
            int diff = sum - x;
            if(diff % 2 == 0){
                return jumpCount;
            }else{
                return ++jumpCount;
            }
        }
    }

    //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}
