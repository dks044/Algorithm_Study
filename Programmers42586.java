import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> speedOfDay_arr = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int day =0;
            int work = progresses[i]; 
            while(work<=100){
                work += speeds[i];
                day++;
                if(work >= 100) break;
            }
            speedOfDay_arr.add(day);
            work =0;
        }
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans_arr = new ArrayList<>(); //정답용
        stack.push(speedOfDay_arr.get(0)); //1개 푸쉬하고 시작
        ans_arr.add(1);
        int index=0;
        for(int i=1;i<speedOfDay_arr.size();i++){
            if(stack.peek() >= speedOfDay_arr.get(i)) {
                ans_arr.set(index,ans_arr.get(index)+1);
            }else{
                stack.push(speedOfDay_arr.get(i));
                ans_arr.add(1);
                index++; //다음 최소작업 단위로 넘어감.
            }
        }
        int[] answer = new int[ans_arr.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans_arr.get(i);
        }
        
        
        return answer;
    }
}
