import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        char[] c = my_string.toCharArray();
        ArrayList<Integer> int_arr = new ArrayList<>();
        
        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i])){
                int_arr.add(c[i]-'0');
            }
        }  
        int[] answer = new int[int_arr.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = int_arr.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}
