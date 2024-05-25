import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        // 배열의 끝에서부터 시작
        for (int i = numbers.length - 1; i >= 0; i--) {
            // 스택이 비어있지 않고, 현재 원소가 스택의 top에 있는 원소보다 크면,
            // 스택의 top에 있는 원소는 현재 원소의 "뒷 큰 수"가 될 수 없으므로 pop
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            // 스택이 비어있으면 뒷 큰 수가 없는 것이므로 -1
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                // 스택의 top에 있는 원소가 현재 원소의 "뒷 큰 수"
                answer[i] = stack.peek();
            }
            
            // 현재 원소를 스택에 push
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}
