import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> answer_arr = new ArrayList<>();
        for(int a=0;a<numbers.length-1;a++){
            for(int b=a+1;b<numbers.length;b++){
                if(set.add(numbers[a]+numbers[b])) answer_arr.add(numbers[a]+numbers[b]);
            }
        }
        
        int[] answer = new int[answer_arr.size()];
        for(int i=0;i<answer_arr.size();i++){
            answer[i] = answer_arr.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
