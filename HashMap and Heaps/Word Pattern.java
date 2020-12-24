import java.util.*;

public class Main {

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Boolean> map2 = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(map1.containsKey(ch) == false){
                if(map2.containsKey(words[i])){
                    return false;
                }else{
                    map1.put(ch,words[i]);
                    map2.put(words[i],true);
                }
            }else{
                String s = map1.get(ch);
                if(s.equals(words[i]) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        System.out.println(wordPattern(pattern, words));
    }

}
