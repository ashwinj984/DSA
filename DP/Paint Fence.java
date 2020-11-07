import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int c = scn.nextInt();
            
            int l2same = c;
            int l2diff = c * (c - 1);
            int total = l2same + l2diff;
            
            for(int i = 3; i<= n; i++){
                int nl2same = l2diff;
                int nl2diff = total * (c -1);
                int ntotal = nl2same + nl2diff;
                
                l2same = nl2same;
                l2diff = nl2diff;
                total = ntotal;
                
            }
            
            System.out.println(total);
    }
}
