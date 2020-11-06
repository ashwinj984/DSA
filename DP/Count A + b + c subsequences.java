import java.util.*;

public  class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < str.length() ;i++){
            if(str.charAt(i) == 'a'){
                a = 2 * a + 1;
            }else if(str.charAt(i) == 'b'){
                b = 2 * b + a;
            }else if(str.charAt(i) == 'c'){
                c = 2 * c + b;
            }
        }
        System.out.println(c);
    }
}
