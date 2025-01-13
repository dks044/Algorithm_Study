import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] bef = before.toCharArray();
        char[] aft = after.toCharArray();
        ArrayList<Character> a = new ArrayList<>(); //after
        for(char word : aft){
            a.add(word);
        }
        for(int i=0;i<bef.length;i++){
            if(a.contains(bef[i])){//중요포인트1
                a.remove(Character.valueOf(bef[i])); //중요포인트2
            }
        }
        
        if(a.isEmpty()){
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}
