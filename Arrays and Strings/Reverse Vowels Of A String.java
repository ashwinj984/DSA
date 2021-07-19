import java.util.*;

public class Main {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    // write your code here
	  int left = 0;
	  int right = s.length() - 1;
	  char[] ch = s.toCharArray();
	  HashSet<Character> set = new HashSet<>();
	  set.add('a');
	  set.add('e');
	  set.add('i');
	  set.add('o');
	  set.add('u');
	  set.add('A');
	  set.add('E');
	  set.add('I');
	  set.add('O');
	  set.add('U');
	  while(left < right) {
		  if(set.contains(ch[left]) && set.contains(ch[right])) {
			  char temp = ch[left];
			  ch[left] = ch[right];
			  ch[right] = temp;
			  left++;
			  right--;
		  }
		  if(!set.contains(ch[left])) {
			  left++;
		  }
		  if(!set.contains(ch[right])) {
			  right--;
		  }
	  }
	  StringBuilder sb = new StringBuilder();
	  for(int i = 0; i < ch.length; i++) {
		  sb.append(ch[i]);
	  }
	  return sb.toString();
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}
   
