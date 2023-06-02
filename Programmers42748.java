import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> num_arr = new ArrayList<>();
        ArrayList<Integer> answer_arr = new ArrayList<>();
        
        for(int i=0;i<commands.length;i++){
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                num_arr.add(array[j]);
            }
            Collections.sort(num_arr);
            answer_arr.add(num_arr.get(commands[i][2]-1));
            num_arr.clear();
        }
        for(int i=0;i<answer_arr.size();i++) answer[i] = answer_arr.get(i);
        
        return answer;
    }
}
