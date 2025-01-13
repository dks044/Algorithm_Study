import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String abc = "abcdefghijklmnopqrstuvwxyz";  
        ArrayList<Character> abc_arr = new ArrayList<>();
        for(char c : abc.toCharArray()){
            if(skip.indexOf(c)>=0) continue;
            abc_arr.add(c);
        }
        StringBuilder sb = new StringBuilder();
        char[] word = s.toCharArray();
        
        for(int i=0;i<word.length;i++){
            int ind = abc_arr.indexOf(word[i])+index;
            if(ind >= abc_arr.size()){
                ind = ind % abc_arr.size();
            }
            sb.append(abc_arr.get(ind));
        }
        
        
        return sb.toString();
    }
}
