import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap < String, String > map = new HashMap < > ();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        HashMap < String, Boolean > psrc = new HashMap < > ();
        for (String src: map.keySet()) {
            String dest = map.get(src);
            psrc.put(dest, false);
            if (psrc.containsKey(src) == false) {
                psrc.put(src, true);
            }
        }

        String asrc = "";
        for (String pots: psrc.keySet()) {
            if (psrc.get(pots)) {
                asrc = pots;
                break;
            }
        }

        while (true) {
            if (map.containsKey(asrc)) {
                System.out.print(asrc + " -> ");
                asrc = map.get(asrc);
            } else {
                System.out.print(asrc + ".");
                break;
            }
        }
    }
}
