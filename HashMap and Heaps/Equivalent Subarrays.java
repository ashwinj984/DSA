import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        //int len = set.size();

        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap < Integer, Integer > map = new HashMap < > ();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < arr.length - 1) {
                f1 = true;
                i++;
                int a = arr[i];
                map.put(a, map.getOrDefault(a, 0) + 1);
                if (map.size() == set.size()) {
                    //ans += arr.length - i;
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                if (map.size() == set.size()) {
                    ans += arr.length - i;
                }
                j++;
                int a = arr[j];
                if (map.get(a) == 1) {
                    map.remove(a);
                } else {
                    map.put(a, map.get(a) - 1);
                }
                if (map.size() < set.size()) {
                    break;
                }


            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        System.out.println(ans);

    }


}
