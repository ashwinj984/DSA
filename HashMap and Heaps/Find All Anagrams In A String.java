import java.util.*;

public class Main {

    public static boolean compare(HashMap < Character, Integer > pmap, HashMap < Character, Integer > maps) {
        for (char ch: maps.keySet()) {
            if (pmap.getOrDefault(ch, 0) != maps.get(ch)) {
                return false;
            }
        }
        return true;
    }
    public static void findAnagrams(String s, String p) {


        HashMap < Character, Integer > maps = new HashMap < > ();
        HashMap < Character, Integer > pmap = new HashMap < > ();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        int i = 0;
        for (i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);

        }

        int j = 0;
        String ans = "";
        int count = 0;
        while (i < s.length()) {
            if (compare(pmap, maps)) {
                count++;
                ans += j + " ";
            }

            char chs = s.charAt(i);
            maps.put(chs, maps.getOrDefault(chs, 0) + 1);

            char chr = s.charAt(j);
            if (maps.get(chr) == 1) {
                maps.remove(chr);
            } else {
                maps.put(chr, maps.get(chr) - 1);
            }

            i++;
            j++;
        }
        if (compare(pmap, maps)) {
            count++;
            ans += j + " ";
        }
        System.out.println(count);
        System.out.println(ans);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String p = scn.next();
        findAnagrams(s, p);
    }

}
