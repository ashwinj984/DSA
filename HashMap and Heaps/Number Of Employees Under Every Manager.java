import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    HashMap<String,String> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			map.put(scn.next(), scn.next());
		}
		
		findCount(map);
    
  }
  
  private static void findCount(HashMap<String, String> map) {
		HashMap<String, HashSet<String>> tree = new HashMap<>();
		String ceo = "";
		for(String emp : map.keySet()) {
			String man = map.get(emp);
			if(man.equals(emp)) {
				ceo = man;
			}else {
				if(tree.containsKey(man)) {
					HashSet<String> emps = tree.get(man);
					emps.add(emp);
				}else {
					HashSet<String> emps = new HashSet<>();
					emps.add(emp);
					tree.put(man, emps);
				}
			}
		}
		HashMap<String,Integer> result = new HashMap<>();
		int ni = getSize(tree,result,ceo);
		
		for(String str : result.keySet()) {
			System.out.println(str + " " + result.get(str));
		}
	}
	
	private static int getSize(HashMap<String, HashSet<String>> tree,HashMap<String, Integer> result,String man) {
		
		if(tree.containsKey(man) == false) {
			result.put(man,0);
			return 1;
		}
		int size = 0;
		for(String emp : tree.get(man)) {
			int csize = getSize(tree, result, emp);
			size += csize;
		}
		
		result.put(man, size);
		return size + 1;
	}

}
