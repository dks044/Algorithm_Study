import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> int_arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n % i ==0){
                int_arr.add(i);
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
