import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> int_arr = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            int_arr.add(score[i]);
            Collections.sort(int_arr);
            if(int_arr.size()>k){
                int_arr.remove(0);
            }
            answer[i] = int_arr.get(0);
        }
        
        return answer;
    }
}
