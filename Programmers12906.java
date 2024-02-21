import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack =new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            int peek = stack.peek();
            if(arr[i] == peek){
                stack.pop();
            }
            stack.push(arr[i]);
        }
        int[] answer = new int[stack.size()];
        int index =0;
        for(int i : stack) answer[index++] = i;
        
        return answer;
    }
}
